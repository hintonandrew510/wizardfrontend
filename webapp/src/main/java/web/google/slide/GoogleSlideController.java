package web.google.slide;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
import com.google.api.client.util.Data;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.slides.v1.Slides;
import com.google.api.services.slides.v1.SlidesScopes;
import com.google.api.services.slides.v1.model.BatchUpdatePresentationRequest;
import com.google.api.services.slides.v1.model.BatchUpdatePresentationResponse;
import com.google.api.services.slides.v1.model.Page;
import com.google.api.services.slides.v1.model.PageElement;
import com.google.api.services.slides.v1.model.Presentation;
import com.google.api.services.slides.v1.model.ReplaceAllTextRequest;
import com.google.api.services.slides.v1.model.Request;
import com.google.api.services.slides.v1.model.Response;
import com.google.api.services.slides.v1.model.SubstringMatchCriteria;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.ClearValuesRequest;
import com.google.api.services.sheets.v4.model.ClearValuesResponse;
import com.google.api.services.sheets.v4.model.ExtendedValue;
import com.google.api.services.sheets.v4.model.GridCoordinate;
import com.google.api.services.sheets.v4.model.RowData;
import com.google.api.services.sheets.v4.model.UpdateCellsRequest;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

@Controller // This means that this class is a Controller

public class GoogleSlideController {
	@Autowired
	private Environment mEnvironment;
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
	public String generate(HttpSession session, @RequestParam(required = true) String authCodeId) {
		// remove value from session

		String domain = mEnvironment.getProperty("google.domain");
		mLog.info("authCodeId [" + authCodeId + "]");
		try {
			java.io.File file = ResourceUtils.getFile("classpath:client_secret.json");
			String contents = FileUtils.readFileToString(file, "UTF-8");
			
			mLog.info("contents [" + contents + "]");
			InputStreamReader isr = new InputStreamReader(IOUtils.toInputStream(contents,"UTF-8"));
			// Reader targetReader = new StringReader(initialString);
			//targetReader.close();
			mLog.info("file " + file);
			// InputStream inputStream = new FileInputStream(file);
			// byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);

			// Exchange auth code for access token
			
			
			GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(),
					isr);
			//GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(),
					//new FileReader(file));
			GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(),
					JacksonFactory.getDefaultInstance(), "https://oauth2.googleapis.com/token",
					clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret(), authCodeId,
					domain) // Specify the same redirect URI that you use with your web
							// app. If you don't have a web version of your app, you can
							// specify an empty string.
							.execute();

			String accessToken = tokenResponse.getAccessToken();

			mLog.info("access Token " + accessToken);

			// Use access token to call API
			GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
			mLog.info("credential " + credential);

			// 1IWyyvihcALCHYEM6pDBP5HJ4-2UxMcmmYBQtp3jxlE0
			String presentationId = "1IWyyvihcALCHYEM6pDBP5HJ4-2UxMcmmYBQtp3jxlE0";
			presentationId = "1ZpzLy8P1Nvk2kVLqJ-Bdck4kQRSx3jEuEcf7VB4Mi_Y";
			// temp
			presentationId = "19vhAFr5DHSoeGPo7GgK9zQ3zZMShx-Nl9BOuAEKLsPU";

			presentationId = "1ZpzLy8P1Nvk2kVLqJ-Bdck4kQRSx3jEuEcf7VB4Mi_Y";

			presentationId = "1bo_kj7KR97kGU1oNUT31HpOS_dywpfFEMRmpRnSUeO4";
			// https://docs.google.com/presentation/d/1ZpzLy8P1Nvk2kVLqJ-Bdck4kQRSx3jEuEcf7VB4Mi_Y/edit#slide=id.gac76981968_0_5

			// get the drive service

			Drive drive = new Drive.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
					.setApplicationName(APPLICATION_NAME).build();

			mLog.info("drive [" + drive + "]");

			Sheets sheets = new Sheets.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
					.setApplicationName(APPLICATION_NAME).build();

			mLog.info("sheets [" + sheets + "]");
			writeSheetExample( sheets);

			List<File> result = new ArrayList<File>();
			Files.List request = drive.files().list();
			FileList files = request.execute();
			result.addAll(files.getFiles());
			for (File fileA : result) {
				mLog.info("id " + fileA.getId());
				// mLog.info("desc " + fileA.getDescription());
				mLog.info("name " + fileA.getName());
				// mLog.info("web link " + fileA.getWebViewLink());
			}
			String newFileName = "new_" + getDateTime();
			mLog.info("new file " + newFileName);
			File newFile = copyFile(drive, presentationId, newFileName);
			String newFileId = newFile.getId();
			mLog.info("new File Id" + newFile.getId());
			// for ()
			// File driveFile = drive.files().get(presentationId).execute();
			// mLog.info("driveFile " + driveFile);

			// Get profile info from ID token
			// GoogleIdToken idToken = tokenResponse.parseIdToken();
			// GoogleIdToken.Payload payload = idToken.getPayload();
			// String userId = payload.getSubject(); // Use this value as a key to identify
			// a user.
			// mLog.info("userId " + userId);
			// String email = payload.getEmail();
			mLog.info("setup up slides ");

			Slides slides = new Slides.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
					.setApplicationName(APPLICATION_NAME).build();
			mLog.info("slides have been setup " + slides);
			// https://docs.google.com/presentation/d/1MIJx-AseaerrkR94Ft89hPGoTTDmcIzbf0qPn160nP8/edit#slide=id.ga8b5bb1d1e_0_0
			// https://docs.google.com/presentation/d/14dc1IXjJ1XEAHhUFgi_4ixOWlIdZPy1eMlOohuiZ2Zg/edit#slide=id.p1
			// https://docs.google.com/presentation/d/1IWyyvihcALCHYEM6pDBP5HJ4-2UxMcmmYBQtp3jxlE0/edit#slide=id.p1

			/*
			 * Presentation response = slides.presentations().get(newFileId ).execute();
			 * List<Page> pages = response.getSlides(); for (Page page : pages) { //page.
			 * List<PageElement> pageElements = page.getPageElements(); for (PageElement
			 * pageElement : pageElements) { pageElement.getTitle(); } }
			 */

			// Create the text merge (replaceAllText) requests for this presentation.
			List<Request> requests = new ArrayList<>();
			Request requestText = new Request();
			ReplaceAllTextRequest replaceAllTextRequest = new ReplaceAllTextRequest();
			SubstringMatchCriteria substringMatchCriteria = new SubstringMatchCriteria();
			substringMatchCriteria.setText("{{customer-name}}").setMatchCase(true).setText("ddfdfd");
			replaceAllTextRequest.setContainsText(substringMatchCriteria);
			requestText.setReplaceAllText(replaceAllTextRequest);
			// requests.add(requestText);

			requests.add(new Request().setReplaceAllText(new ReplaceAllTextRequest()
					.setContainsText(new SubstringMatchCriteria().setText("{{customer-name}}").setMatchCase(true))
					.setReplaceText("yes")));

			mLog.info("requests made");
			// Execute the requests for this presentation.
			BatchUpdatePresentationRequest body = new BatchUpdatePresentationRequest().setRequests(requests);
			mLog.info("requests  body " + body);
			BatchUpdatePresentationResponse responseA = slides.presentations().batchUpdate(newFileId, body).execute();

			mLog.info("requests  responseA " + responseA);
			// Count total number of replacements made.
			int numReplacements = 0;

			for (Response resp : responseA.getReplies()) {
				try {
					numReplacements += resp.getReplaceAllText().getOccurrencesChanged();
				} catch (Exception ex) {
					mLog.severe("replace text error " + ex.getMessage());
				}

			}
			mLog.info("Created merged presentation for  with ID: " + newFileId);
			mLog.info("numReplacements " + numReplacements);

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

	/**
	 * Copy an existing file.
	 *
	 * @param service      Drive API service instance.
	 * @param originFileId ID of the origin file to copy.
	 * @param copyTitle    Title of the copy.
	 * @return The copied file if successful, {@code null} otherwise.
	 */
	private File copyFile(Drive service, String originFileId, String copyName) {
		File copiedFile = new File();
		copiedFile.setName(copyName);

		try {
			return service.files().copy(originFileId, copiedFile).execute();
		} catch (IOException e) {
			System.out.println("An error occurred: " + e);
		}
		return null;
	}

	private String getDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
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

	private void writeSheetExample(Sheets service)  {
		
		mLog.info("starting WriteSheetExample");
		List<Data> myData = new ArrayList<Data>();
	  
	    List<Request> requests = new ArrayList<>();

	    List<CellData> values = new ArrayList<>();


	     // values.add(new CellData()
	              //  .setUserEnteredValue(new ExtendedValue()
	                    //    .setStringValue("Hello World!")));
	      
	      
	      
	      String spreadsheetId = "1NVWsixQHvBFbr9fpUmSCFKfb3BNrbYgspYSZzyItZL8";
	      String writeRange = "mediasheet!A1:E"; //range and sheet name
      
	        List<List<Object>> writeData = new ArrayList<>();
	        //three rows
	        //five columns
	        for (int x = 0; x < 3; x++) {
	            List<Object> dataRow = new ArrayList<>();
	            dataRow.add(11);
	            dataRow.add(22);
	            dataRow.add(33);
	            dataRow.add(44);
	            dataRow.add(55);
	            writeData.add(dataRow);
	        }
	       
	        ValueRange body = new ValueRange().setValues(writeData).setMajorDimension("ROWS");
	       // ValueRange body = new ValueRange().setValues(values);
	        try {
	        	
	        	//cleare values
	        	 // TODO: Assign values to desired fields of `requestBody`:
	            ClearValuesRequest requestBody = new ClearValuesRequest();

	           
	            Sheets.Spreadsheets.Values.Clear request = service.spreadsheets().values().clear(spreadsheetId, writeRange, requestBody);

	           ClearValuesResponse response = request.execute();
	           mLog.info("response [" + response + "]");
	        	
				UpdateValuesResponse result =
				        service.spreadsheets().values().update(spreadsheetId, writeRange, body)
				                .setValueInputOption("RAW")
				                .execute();
				mLog.info("result [" + result + "]");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				mLog.severe(e.getMessage());
			}
	       // BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest()
	         //       .setRequests(requests);
	       // service.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest)
	           //     .execute();
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
