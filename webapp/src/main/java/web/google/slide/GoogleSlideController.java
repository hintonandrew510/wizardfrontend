package web.google.slide;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.slides.v1.Slides;
import com.google.api.services.slides.v1.SlidesScopes;
import com.google.api.services.slides.v1.model.Page;
import com.google.api.services.slides.v1.model.Presentation;

@Controller // This means that this class is a Controller

public class GoogleSlideController {
	private static final Logger mLog = Logger.getLogger(GoogleSlideController.class.getName());

	private static final String APPLICATION_NAME = "Google Slides API Java Quickstart";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "tokens";

	/**
	 * Global instance of the scopes required by this quickstart. If modifying these
	 * scopes, delete your previously saved tokens/ folder.
	 */
	private static final List<String> SCOPES = Collections.singletonList(SlidesScopes.PRESENTATIONS_READONLY);
	private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @param HTTP_TRANSPORT The network HTTP Transport.
	 * @return An authorized Credential object.
	 * @throws IOException If the credentials.json file cannot be found.
	 */

	@RequestMapping(value = "/GenerateGoogleSlide", method = RequestMethod.POST)
	public String generate(HttpSession session, @RequestParam(required = true) String authCodeId,
			@RequestParam(required = true) String encryptId) {
		// remove value from session
		mLog.info("authCodeId [" + authCodeId + "]");
		try {
			java.io.File file = ResourceUtils.getFile("classpath:client_secret.json");
			mLog.info("file " + file);
			// InputStream inputStream = new FileInputStream(file);
			// byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);

			// Exchange auth code for access token
			GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(),
					new FileReader(file));
			GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(),
					JacksonFactory.getDefaultInstance(), "https://oauth2.googleapis.com/token",
					clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret(), authCodeId,
					"http://localhost:8080") // Specify the same redirect URI that you use with your web
						// app. If you don't have a web version of your app, you can
						// specify an empty string.
							.execute();

			String accessToken = tokenResponse.getAccessToken();
			mLog.info("access Token " + accessToken);

			// Use access token to call API
			GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
			mLog.info("credential " + credential);
			//1IWyyvihcALCHYEM6pDBP5HJ4-2UxMcmmYBQtp3jxlE0
			String presentationId = "1IWyyvihcALCHYEM6pDBP5HJ4-2UxMcmmYBQtp3jxlE0";
			Drive drive = new Drive.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
					.setApplicationName(APPLICATION_NAME).build();
			mLog.info("drive " + drive);
			List<File> result = new ArrayList<File>();
		    Files.List request = drive.files().list();
		    FileList files = request.execute();
		    result.addAll(files.getFiles());
		    for (File fileA : result) {
		    	mLog.info("id " + fileA.getId());
		    	mLog.info("desc " + fileA.getDescription());
		    	mLog.info("name " + fileA.getName());
		    	mLog.info("web link " + fileA.getWebViewLink());
		    }
		//for ()
			//File driveFile = drive.files().get(presentationId).execute();
			//mLog.info("driveFile " + driveFile);
			
			// Get profile info from ID token
			GoogleIdToken idToken = tokenResponse.parseIdToken();
			GoogleIdToken.Payload payload = idToken.getPayload();
			String userId = payload.getSubject();  // Use this value as a key to identify a user.
			mLog.info("userId " + userId);
			String email = payload.getEmail();
			mLog.info("email " + email);
			
			Slides service = new Slides.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
					.setApplicationName(APPLICATION_NAME).build();

			// https://docs.google.com/presentation/d/1MIJx-AseaerrkR94Ft89hPGoTTDmcIzbf0qPn160nP8/edit#slide=id.ga8b5bb1d1e_0_0
			// https://docs.google.com/presentation/d/14dc1IXjJ1XEAHhUFgi_4ixOWlIdZPy1eMlOohuiZ2Zg/edit#slide=id.p1
			//https://docs.google.com/presentation/d/1IWyyvihcALCHYEM6pDBP5HJ4-2UxMcmmYBQtp3jxlE0/edit#slide=id.p1
			
			Presentation response = service.presentations().get(presentationId).execute();
			List<Page> slides = response.getSlides();

			System.out.printf("The presentation contains %s slides:\n", slides.size());
			for (int i = 0; i < slides.size(); ++i) {
				System.out.printf("- Slide #%s contains %s elements.\n", i + 1, slides.get(i).getPageElements().size());
			}
			// Credential Credential =
			// String data = new String(bdata, StandardCharsets.UTF_8);
			// mLog.info(data);
		} catch (Exception e) {
			mLog.severe("ERROR " + e.getMessage());
		}
		// ignore id
		String nextPage = "googleslidepage";
		return nextPage;

	}

	private void ggoool() throws IOException {
		String authCode = "";
		String CLIENT_SECRET_FILE = "/path/to/client_secret.json";

		// Exchange auth code for access token
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(),
				new FileReader(CLIENT_SECRET_FILE));
		GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(),
				JacksonFactory.getDefaultInstance(), "https://oauth2.googleapis.com/token",
				clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret(), authCode, "") // Specify
																														// the
																														// same
																														// redirect
																														// URI
																														// that
																														// you
																														// use
																														// with
																														// your
																														// web
																														// app.
																														// If
																														// you
																														// don't
																														// have
																														// a
																														// web
																														// version
																														// of
																														// your
																														// app,
																														// you
																														// can
																														// specify
																														// an
																														// empty
																														// string.
						.execute();

		String accessToken = tokenResponse.getAccessToken();

		// Use access token to call API
		GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
		Drive drive = new Drive.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
				.setApplicationName("Auth Code Exchange Demo").build();
		// File file = null;
		drive.files().get("appfolder").execute();

		// Get profile info from ID token
		GoogleIdToken idToken = tokenResponse.parseIdToken();
		GoogleIdToken.Payload payload = idToken.getPayload();
		String userId = payload.getSubject(); // Use this value as a key to identify a user.
		String email = payload.getEmail();
		boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
		String name = (String) payload.get("name");
		String pictureUrl = (String) payload.get("picture");
		String locale = (String) payload.get("locale");
		String familyName = (String) payload.get("family_name");
		String givenName = (String) payload.get("given_name");
	}

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @param HTTP_TRANSPORT The network HTTP Transport.
	 * @return An authorized Credential object.
	 * @throws IOException If the credentials.json file cannot be found.
	 */
	private Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws Exception {
		// Load client secrets.
		mLog.info("starting getCredentials");
		java.io.File file = ResourceUtils.getFile("classpath:credentials.json");
		InputStream inputStream = new FileInputStream(file);

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(inputStream));
		mLog.info("clientSecrets " + clientSecrets);
		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES)
						.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();
		mLog.info("Build flow and trigger user authorization request. ");

		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}

}
