package web.google.slide;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Handler;
import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.google.api.services.drive.model.Comment;
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
import com.google.api.services.slides.v1.model.DeleteObjectRequest;
import com.google.api.services.slides.v1.model.Response;
import com.google.api.services.slides.v1.model.SubstringMatchCriteria;
import web.data.MyUserPrincipal;
import web.model.Agent;
import web.model.Wizard;
import web.model.WizardData;
import web.page.JSONManager;
import web.page.PieChart;
import web.repository.WizardDataRepository;
import web.repository.WizardRepository;

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

/**
 * @author andrewhinton
 *
 */
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

	private Wizard mWizard;
	private Iterable<WizardData> mDataPages;
	private List<SlideInterface> mSlidesModels;
	private List<String> mExcludedPagesList;
	private Map<String, String> mComments;
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private WizardRepository wizardRepository;
	// Which is auto-generated by Spring, we will use it to handle the data
	@Autowired
	private WizardDataRepository wizardDataRepository;

	@GetMapping(path = "/google")
	public String googleAuthenticate(org.springframework.ui.Model model, Authentication authentication) {

		mLog.warning("entering googleAuthenticate");

		// mLog.info(msg);(GoogleSlideController.class.getName(), "googleAuthenticate");

		MyUserPrincipal userDetails = (MyUserPrincipal) authentication.getPrincipal();

		GoogleProfile dataPageModel = null;
		if (userDetails.getAgent().getGoogleprofile() != null) {
			dataPageModel = (GoogleProfile) JSONManager.convertFromJson(userDetails.getAgent().getGoogleprofile(),
					GoogleProfile.class);

		} else {
			return "redirect:googleprofile";
		}

		model.addAttribute("dataPageModel", dataPageModel);
		model.addAttribute("contact", userDetails.getContact());
		mLog.warning("exiting googleAuthenticate");
		return "google";

	}

	/*
	 * Initialize class variables
	 */
	private void initialize() throws IOException, ProfileException {
		// remove value from session

		mLog.entering(GoogleSlideController.class.getName(), "initialize");
		mLog.warning("entering initialize");
		// agent.setContactId(contact.getContactId());
		mExcludedPagesList = GoogleHelper.getSlidesExcluded(this.mDataPages);
		// get Slide data from database
		mSlidesModels = GoogleHelper.getSlidesData(this.mDataPages);

		String json = mAgent.getGoogleprofile();
		if (json == null) {
			throw new ProfileException("profile not found");
		}

		mGoogleProfile = (GoogleProfile) JSONManager.convertFromJson(json, GoogleProfile.class);
		String domain = mEnvironment.getProperty("google.domain");

		java.io.File file = ResourceUtils.getFile("classpath:client_secret.json");
		String contents = FileUtils.readFileToString(file, "UTF-8");
		mLog.info("contents [" + contents + "]");

		// mLog.info("resultContents [" + resultContents + "]");
		InputStreamReader isr = new InputStreamReader(IOUtils.toInputStream(contents, "UTF-8"));
		// Reader targetReader = new StringReader(initialString);
		// targetReader.close();
		mLog.info("file " + file);
		// InputStream inputStream = new FileInputStream(file);
		// byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);

		// Exchange auth code for access token

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(), isr);
		// GoogleClientSecrets clientSecrets =
		// GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(),
		// new FileReader(file));
		GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(),
				JacksonFactory.getDefaultInstance(), "https://oauth2.googleapis.com/token",
				clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret(), mAuthCodeId,
				domain) // Specify the same redirect URI that you use with your web
						// app. If you don't have a web version of your app, you can
						// specify an empty string.
						.execute();

		String accessToken = tokenResponse.getAccessToken();

		mLog.info("access Token " + accessToken);
		String emailAddress = GoogleHelper.emailAddress(tokenResponse);
		mGeneratedSlide.setEmailAddress(emailAddress);

		// Use access token to call API
		mCredential = new GoogleCredential().setAccessToken(accessToken);
		Drive mDrive = new Drive.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), mCredential)
				.setApplicationName(APPLICATION_NAME).build();
		mLog.info("drive [" + mDrive + "]");
		// new Filename name
		String newFileName = this.mWizard.getName() + " " + GoogleHelper.getDateTime();
		mLog.info("newFileName [" + newFileName + "]");
		try {
			File newFile = GoogleHelper.copyFile(mDrive, mGoogleProfile.getSlidesId(), newFileName,
					this.mGoogleProfile.getGeneratedFolderId());
			mNewFileId = newFile.getId();

			mGeneratedSlide.setFileName(newFileName);
			mGeneratedSlide.setFileNameId(this.mNewFileId);
			mLog.info("newFile id [" + newFile.getId() + "]");
			
			this.mComments = GoogleHelper.retrieveComments(mDrive,
					 mGoogleProfile.getSlidesId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mLog.severe(e.getLocalizedMessage());
		}

		mSheets = new Sheets.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), mCredential)
				.setApplicationName(APPLICATION_NAME).build();

		mLog.info("sheets [" + mSheets + "]");

		mLog.info("setup up slides ");

		mSlides = new Slides.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), mCredential)
				.setApplicationName(APPLICATION_NAME).build();
		mLog.info("slides have been setup " + mSlides);

		// File newFile = GoogleHelper.copyFile(mDrive, mGeneratedSlide.getFileNameId(),
		// newFileName,
		// this.mGoogleProfile.getGeneratedFolderId());

		mLog.warning("exiting initialize");
		mLog.exiting(GoogleSlideController.class.getName(), "initialize");

	}

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @param HTTP_TRANSPORT The network HTTP Transport.
	 * @return An authorized Credential object.
	 * @throws IOException If the credentials.json file cannot be found.
	 */

	@RequestMapping(value = "/GenerateGoogleSlide", method = RequestMethod.POST)
	public String generateGoogleSlide(Model model, Authentication authentication, HttpSession session,
			@RequestParam(required = true) String authCodeId) {
		mLog.warning("entering generate");
		mLog.info("authCodeId [" + authCodeId + "]");
		mAuthCodeId = authCodeId;
		mLog.entering(GoogleSlideController.class.getName(), "generate");
		// TODO set to 37 wizard
		String id = "37";
		mDataPages = wizardDataRepository.findByWizardid(37);
		MyUserPrincipal userDetails = (MyUserPrincipal) authentication.getPrincipal();
		mAgent = userDetails.getAgent();

		Optional<Wizard> wizardOpt = wizardRepository.findById(Integer.valueOf(id));

		mWizard = wizardOpt.orElse(null);
		if (mWizard != null) {
			mLog.info("mWizard " + mWizard.getName());
		} else {
			mLog.severe("can not file wizard  " + id);
		}

		try {
			initialize();
		} catch (IOException ioException) {
			// TODO Auto-generated catch block
			mLog.severe(ioException.getMessage());
		} catch (ProfileException e) {
			// TODO Auto-generated catch block
			return "redirect:/googleprofile";
		}

		try {

			// https://docs.google.com/presentation/d/1T-FYqBE2mJ9nsnvF2JzyPbT3W0Uzr07VLyvK4sjnDco/edit#slide=id.p

			// get slide id from agent
			String presentationId = mGoogleProfile.getSlidesId();
			mLog.info("presentationId [" + presentationId + "]");
			// https://docs.google.com/presentation/d/1ZpzLy8P1Nvk2kVLqJ-Bdck4kQRSx3jEuEcf7VB4Mi_Y/edit#slide=id.gac76981968_0_5

			// get the drive service

			writeSheetExample(mSheets);
			/*
			 * List<File> result = new ArrayList<File>(); Files.List request =
			 * drive.files().list(); FileList files = request.execute();
			 * result.addAll(files.getFiles()); for (File fileA : result) { mLog.info("id "
			 * + fileA.getId()); // mLog.info("desc " + fileA.getDescription());
			 * mLog.info("name " + fileA.getName()); // mLog.info("web link " +
			 * fileA.getWebViewLink()); }
			 */

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

			// delete slide
			// get the slide names and ids from the comments and remove pages
			mLog.info("FIGURE OUT SLIDES TO DELETE  ");
			try {
				mLog.info("pages to consider  " + this.mExcludedPagesList.size());
				mLog.info("comment size  " + this.mComments.size());
				for (String excludedPage : this.mExcludedPagesList) {
					mLog.info("looking for  [" + excludedPage + "]");
					if (this.mComments.containsKey(excludedPage)) {
						String pageToExclude = this.mComments.get(excludedPage);
						DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest();
						deleteObjectRequest.setObjectId(pageToExclude);
						//Request delRequest = new Request().setDeleteObject(deleteObjectRequest);
						Request deleteRequest = new Request();
						deleteRequest.setDeleteObject(deleteObjectRequest);
						mLog.info("Removing page  [" + excludedPage + "]");
						requests.add(new Request().setDeleteObject(deleteObjectRequest));
						// requests.add(deleteRequest);
					}

				}

			} catch (Exception e) {
				mLog.warning("could not read comment   + " + e.getMessage());
			}

			
			// gb1f3d784ca_0_16
			

			// add data to slides
			if (mSlidesModels != null) {
				for (SlideInterface page : mSlidesModels) {
					List<SlideReplacementData> listSlideReplacementData = page.composeGoogleSlideData();
					for (SlideReplacementData slideReplacementData : listSlideReplacementData) {

						requests.add(
								new Request()
										.setReplaceAllText(
												new ReplaceAllTextRequest()
														.setContainsText(new SubstringMatchCriteria()
																.setText(slideReplacementData
																		.getGoogleSlideVariableName())
																.setMatchCase(true))
														.setReplaceText(
																slideReplacementData.getGoogleSlideVariableValue())));
					}
				}
			}

			// requests.add(new Request().setReplaceAllText(new ReplaceAllTextRequest()
			// .setContainsText(new
			// SubstringMatchCriteria().setText("{{customer-name}}").setMatchCase(true))
			// .setReplaceText("yes")));

			

			mLog.info("requests made");
			// Execute the requests for this presentation.
			BatchUpdatePresentationRequest body = new BatchUpdatePresentationRequest().setRequests(requests);
			mLog.info("requests  body " + body);
			BatchUpdatePresentationResponse responseA = mSlides.presentations().batchUpdate(this.mNewFileId, body)
					.execute();

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

			Presentation response = mSlides.presentations().get(this.mNewFileId).execute();
			List<Page> pages = response.getSlides();

			// change i to any other index if desired
			for (Page page : pages) {
				String pageId = page.getObjectId();
				mLog.info("pageId " + pageId);
			}

			/*
			 * Presentation response = slides.presentations().get(newFileId ).execute();
			 * List<Page> pages = response.getSlides(); for (Page page : pages) { //page.
			 * List<PageElement> pageElements = page.getPageElements(); for (PageElement
			 * pageElement : pageElements) { pageElement.getTitle(); } }
			 */

			mLog.info("Created merged presentation for  with ID: " + this.mNewFileId);
			mLog.info("numReplacements " + numReplacements);

			// Credential Credential =
			// String data = new String(bdata, StandardCharsets.UTF_8);
			// mLog.info(data);
		} catch (Exception e) {
			mLog.severe("ERROR " + e.getMessage());
		}
		// ignore id
		model.addAttribute("agent", mAgent);
		model.addAttribute("generatedSlide", mGeneratedSlide);
		model.addAttribute("googleProfile", mGoogleProfile);
		String nextPage = "googleslidegeneratedpage";
		mLog.warning("exiting generate");
		mLog.entering(GoogleSlideController.class.getName(), "generate");
		return nextPage;

	}

	private void writeSheetExample(Sheets service) {
		mLog.warning("entering WriteSheetExample");
		mLog.info("starting WriteSheetExample");
		List<Data> myData = new ArrayList<Data>();

		List<Request> requests = new ArrayList<>();

		List<CellData> values = new ArrayList<>();

		// values.add(new CellData()
		// .setUserEnteredValue(new ExtendedValue()
		// .setStringValue("Hello World!")));

		String spreadsheetId = "1NVWsixQHvBFbr9fpUmSCFKfb3BNrbYgspYSZzyItZL8";
		spreadsheetId = this.mGoogleProfile.getSheetsId();
		mLog.info("starting spreadsheetId [" + spreadsheetId + "]");
		//String writeRange = "mediasheet!A1:E"; // range and sheet name
		String writeRange = "ConfidentialClientEvaluationOnePage_Data!A1:B"; // range and sheet name

		List<List<Object>> writeData = new ArrayList<>();
		// three rows
		// five columns
		/*for (int x = 0; x < 3; x++) {
			List<Object> dataRow = new ArrayList<>();
			dataRow.add(11);
			dataRow.add(22);
			dataRow.add(33);
			dataRow.add(44);
			dataRow.add(55);
			writeData.add(dataRow);
		}*/
		
		PieChart PieChartOne = new PieChart("weight", 190); 
		List<Object> dataRowOne = new ArrayList<>();
		dataRowOne.add(PieChartOne.getLabel());
		dataRowOne.add(PieChartOne.getLabelValue());
		writeData.add(dataRowOne);
		
		PieChart PieChartTwo = new PieChart("height", 90); 
		List<Object> dataRowOneTwo = new ArrayList<>();
		dataRowOneTwo.add(PieChartTwo.getLabel());
		dataRowOneTwo.add(PieChartTwo.getLabelValue());
		writeData.add(dataRowOneTwo);
       
       
		ValueRange body = new ValueRange().setValues(writeData).setMajorDimension("ROWS");
		// ValueRange body = new ValueRange().setValues(values);
		try {

			// cleare values
			// TODO: Assign values to desired fields of `requestBody`:
			ClearValuesRequest requestBody = new ClearValuesRequest();

			Sheets.Spreadsheets.Values.Clear request = service.spreadsheets().values().clear(spreadsheetId, writeRange,
					requestBody);

			ClearValuesResponse response = request.execute();
			mLog.info("response [" + response + "]");

			UpdateValuesResponse result = service.spreadsheets().values().update(spreadsheetId, writeRange, body)
					.setValueInputOption("RAW").execute();
			mLog.info("result [" + result + "]");
			mLog.warning("exting WriteSheetExample");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			mLog.severe(spreadsheetId + " not found");
			mLog.severe(e.getMessage());
			mLog.warning("exiting WriteSheetExample");
		}
		// BatchUpdateSpreadsheetRequest batchUpdateRequest = new
		// BatchUpdateSpreadsheetRequest()
		// .setRequests(requests);
		// service.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest)
		// .execute();
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
