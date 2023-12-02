package web.google.slide;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ClearValuesRequest;
import com.google.api.services.sheets.v4.model.ClearValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.slides.v1.Slides;
import com.google.api.services.slides.v1.SlidesScopes;

import web.data.MyUserPrincipal;
import web.model.Agent;
import web.model.Wizard;
import web.page.JSONManager;
import web.repository.AgentRepository;

@Controller 
public class GoogleVerificationController {
	@Autowired
	private Environment mEnvironment;
	private static final Logger mLog = LoggerFactory.getLogger(GoogleVerificationController.class.getName());

	private static final String APPLICATION_NAME = "Google Slides API Java Quickstart";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "tokens";
	private static final List<String> SCOPES = Collections.singletonList(SlidesScopes.PRESENTATIONS_READONLY);
	private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
	private GoogleProfile mGoogleProfile;
	private GeneratedSlide mGeneratedSlide = new GeneratedSlide();
	private Agent mAgent;
	private GoogleCredential mCredential;
	private Drive mDrive;
	private Sheets mSheets;
	private Slides mSlides;
	private String mNewFileId;
	private String mNewFileName;
	private String mAuthCodeId;
	@Autowired
	private AgentRepository agentRepository;
	
	@GetMapping(path = "/dispalyGoogleVerification")
	public String display(Model model, Authentication authentication)  {
		mLog.info("starting dispaly");

		
		return "googleverification";

	}
	private GoogleVerification writeSheetData(Sheets service, GoogleVerification googleVerification) {
		mLog.warn("ENTERING writeSheetData");
		mLog.info("starting WriteSheetExample");
		String spreadsheetId = this.mGoogleProfile.getSheetsId();
		mLog.info("starting spreadsheetId [" + spreadsheetId + "]");

		// String writeRange = "ConfidentialClientEvaluationOnePage_Data!A1:B"; // range
		// and sheet name
		String writeRange = "Verify_Data!A1:B"; // range and sheet name
		

		List<List<Object>> writeData = new ArrayList<>();
		List<Object> dataRow = new ArrayList<>();

		// spike = green slow = red base = blue
		
		dataRow.add("Writing to sheet has been verified on " + GoogleHelper.getDateTime());
		//dataRow.add("test");
		writeData.add(dataRow);
		ValueRange body = new ValueRange().setValues(writeData).setMajorDimension("ROWS");
		mLog.warn("ClearValuesResponse ");
		ClearValuesRequest requestBody = new ClearValuesRequest();
		Sheets.Spreadsheets.Values.Clear request = null;
		try {
			request = service.spreadsheets().values().clear(spreadsheetId,
					writeRange, requestBody);
			mLog.info("ClearValuesResponse ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			googleVerification.setCanWriteDataSheet(false);
			googleVerification.setWriteDataSheetComment(e.getMessage());
		}
		mLog.info("ClearValuesResponse ");
		try {
		 request.execute();

		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			googleVerification.setCanWriteDataSheet(false);
			String message = " can not clear sheet " + "[" + spreadsheetId + "] " + e.getMessage();
			mLog.error(message );
			googleVerification.setWriteDataSheetComment(" can not clear " + e.getMessage());
			return googleVerification;
		}
		try {
			service.spreadsheets().values().update(spreadsheetId, writeRange, body).setValueInputOption("RAW").execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			String message = " can not update sheet " + "[" + spreadsheetId + "] " + e.getMessage();
			mLog.error(message + " " + body);
			googleVerification.setCanWriteDataSheet(false);
			googleVerification.setWriteDataSheetComment(message);
		}
		return googleVerification;
	}
	
	/**/
	@RequestMapping(value = "/GoogleSlideVerification", method = RequestMethod.POST)
	public String verifyGoogleSlide( HttpServletRequest request,
			@RequestParam(required = true) String authCodeId, Model model,  Authentication authentication) {
		mLog.warn("entering GoogleSlideVerification");
		GoogleVerification googleVerification = new GoogleVerification();
		MyUserPrincipal userDetails = (MyUserPrincipal) authentication.getPrincipal();
		mLog.info("userDetails =" + userDetails);
		mLog.info("authCodeId " + authCodeId);
		mAgent = userDetails.getAgent();
		Optional<Agent> agentdOpt = agentRepository.findById(mAgent.getAgentid());
		mAgent = agentdOpt.orElse(null);
		
		String json = mAgent.getGoogleprofile();
		if (json == null) {
			//throw new ProfileException("profile not found");
		}

		mGoogleProfile = (GoogleProfile) JSONManager.convertFromJson(json, GoogleProfile.class);
		String domain = mEnvironment.getProperty("prod.google.domain");
		String localDomain = request.getLocalName();
		if (localDomain.contains("local") || localDomain.contains("quiett")) {
			domain = mEnvironment.getProperty("local.google.domain");
		}
		// domain = request.getLocalName();
		mLog.info("domain [" + domain + "]");
		String contents = null;
		java.io.File file = null;
		try {
			mLog.info(" try to get classpath:client_secret.json");
			file = ResourceUtils.getFile("classpath:client_secret.json");
			if (file != null ) {
				mLog.info(" got file  classpath:client_secret.json " + file.toString());
			} else {
				mLog.info(" COULD not get file ");
			}
			
			contents = FileUtils.readFileToString(file, "UTF-8");
			mLog.info("File contents [" + contents + "]");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		// mLog.info("resultContents [" + resultContents + "]");
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(IOUtils.toInputStream(contents, "UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Reader targetReader = new StringReader(initialString);
		// targetReader.close();
		mLog.info("json file " + file);
		// InputStream inputStream = new FileInputStream(file);
		// byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);

		// Exchange auth code for access token

		GoogleClientSecrets clientSecrets = null;
		try {
			clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(), isr);
			googleVerification.setClientSecretsStr(clientSecrets.toString());
			mLog.info("clientSecrets [" + clientSecrets);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// GoogleClientSecrets clientSecrets =
		// GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(),
		// new FileReader(file));
		mLog.info("clientSecrets.getDetails().getClientId() [" + clientSecrets.getDetails().getClientId() + "]");
		mLog.info(
				"clientSecrets.getDetails().getClientSecret() [" + clientSecrets.getDetails().getClientSecret() + "]");

		GoogleTokenResponse tokenResponse = null;
		String accessToken = null;
		try {
			tokenResponse = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(),
					JacksonFactory.getDefaultInstance(), "https://oauth2.googleapis.com/token",
					clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret(), authCodeId,
					domain) // Specify the same redirect URI that you use with your web
							// app. If you don't have a web version of your app, you can
							// specify an empty string.
							.execute();
			mLog.info("tokenResponse [" + tokenResponse);
			
			accessToken = tokenResponse.getAccessToken();
			googleVerification.setAccessToken(accessToken);
			//googleVerification.setAccessToken(accessToken);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			// mLog.error(ex);
			mLog.error("ERROR WRITTING [" + sw.toString() + "]");
		}
	
		
		
		String emailAddress = GoogleHelper.emailAddress(tokenResponse);
		googleVerification.setEmail(emailAddress);
		mLog.info("access Token [" + accessToken);
		mCredential = new GoogleCredential().setAccessToken(accessToken);
		
		mSheets = new Sheets.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), mCredential)
				.setApplicationName(APPLICATION_NAME).build();
		
		googleVerification = writeSheetData(mSheets, googleVerification);
		Drive mDrive = new Drive.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), mCredential)
				.setApplicationName(APPLICATION_NAME).build();
		mLog.info("drive [" + mDrive + "]");
		
		// new Filename name
		String newFileName = "verify " + " " + GoogleHelper.getDateTime();
		File newFile = null;
		try {
			mLog.info("try to access drive");
			
			newFile = GoogleHelper.copyFile(mDrive, mGoogleProfile.getSlidesId(), newFileName,
					this.mGoogleProfile.getGeneratedFolderId());
			mNewFileId = newFile.getId();
			googleVerification.setNewFileId(mNewFileId);
			
			
			Map<String, String> comments = GoogleHelper.retrieveComments(mGoogleProfile);
			if (comments != null) {
				StringBuilder mapAsString = new StringBuilder("{");
			    for (String key : comments.keySet()) {
			        mapAsString.append(key + "=" + comments.get(key) + ", ");
			    }
			    mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
			    googleVerification.setComments(mapAsString.toString());
			}
			mLog.info("setup up slides ");

			mSlides = new Slides.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), mCredential)
					.setApplicationName(APPLICATION_NAME).build();
			//mSlides.
			//googleVerification.setComments(comments.);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//swallow message
		}
		
		//refresh
		model.addAttribute("model", googleVerification);
		return "googleVerificationStatus";
	}//end of method
}
