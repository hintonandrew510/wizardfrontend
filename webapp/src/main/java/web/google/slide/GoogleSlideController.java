package web.google.slide;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
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

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.ClearValuesRequest;
import com.google.api.services.sheets.v4.model.ClearValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.slides.v1.Slides;
import com.google.api.services.slides.v1.SlidesScopes;
import com.google.api.services.slides.v1.model.BatchUpdatePresentationRequest;
import com.google.api.services.slides.v1.model.BatchUpdatePresentationResponse;
import com.google.api.services.slides.v1.model.DeleteObjectRequest;
import com.google.api.services.slides.v1.model.Page;
import com.google.api.services.slides.v1.model.PageElement;
import com.google.api.services.slides.v1.model.Presentation;
import com.google.api.services.slides.v1.model.RefreshSheetsChartRequest;
import com.google.api.services.slides.v1.model.ReplaceAllTextRequest;
import com.google.api.services.slides.v1.model.Request;
import com.google.api.services.slides.v1.model.Response;
import com.google.api.services.slides.v1.model.SheetsChart;
import com.google.api.services.slides.v1.model.SubstringMatchCriteria;

import web.data.MyUserPrincipal;
import web.google.slide.pages.PlanSpreadSheet;
import web.google.slide.pages.PlanSpreadSheets;
import web.model.Agent;
import web.model.Wizard;
import web.model.WizardData;
import web.page.JSONManager;
import web.page.PieChart;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageModel;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageTwoModel;
import web.page.planamedipage.MediaChart;
import web.page.planamedipage.PlanMediaPageModel;
import web.page.planproposedpage.PlanProposedPageModel;
import web.repository.WizardDataRepository;
import web.repository.WizardRepository;

/**
 * @author andrewhinton
 *
 */
@Controller // This means that this class is a Controller

public class GoogleSlideController {

	@Autowired
	private Environment mEnvironment;
	private static final Logger mLog = LoggerFactory.getLogger(GoogleSlideController.class.getName());

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

		mLog.warn("entering googleAuthenticate");

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
		mLog.warn("exiting googleAuthenticate");
		return "google";

	}

	/*
	 * Initialize class variables
	 */
	private void initialize(String localDomain) throws IOException, ProfileException {
		// remove value from session

		mLog.trace(GoogleSlideController.class.getName(), "initialize");
		mLog.warn("entering initialize");
		// agent.setContactId(contact.getContactId());
		mExcludedPagesList = GoogleHelper.getSlidesExcluded(this.mDataPages);
		// get Slide data from database
		mSlidesModels = GoogleHelper.getSlidesData(this.mDataPages);

		String json = mAgent.getGoogleprofile();
		if (json == null) {
			throw new ProfileException("profile not found");
		}

		mGoogleProfile = (GoogleProfile) JSONManager.convertFromJson(json, GoogleProfile.class);
		String domain = mEnvironment.getProperty("prod.google.domain");
		
		if (localDomain.contains("local")) {
		domain = mEnvironment.getProperty("local.google.domain");
		}
		//domain = request.getLocalName();
		mLog.info("domain [" + domain + "]");
		java.io.File file = ResourceUtils.getFile("classpath:client_secret.json");
		String contents = FileUtils.readFileToString(file, "UTF-8");
		mLog.info("File contents [" + contents + "]");

		// mLog.info("resultContents [" + resultContents + "]");
		InputStreamReader isr = new InputStreamReader(IOUtils.toInputStream(contents, "UTF-8"));
		// Reader targetReader = new StringReader(initialString);
		// targetReader.close();
		mLog.info("json file " + file);
		// InputStream inputStream = new FileInputStream(file);
		// byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);

		// Exchange auth code for access token

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(), isr);
		mLog.info("clientSecrets [" + clientSecrets);
		// GoogleClientSecrets clientSecrets =
		// GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(),
		// new FileReader(file));
		mLog.info("clientSecrets.getDetails().getClientId() [" + clientSecrets.getDetails().getClientId() + "]");
		mLog.info("clientSecrets.getDetails().getClientSecret() [" + clientSecrets.getDetails().getClientSecret() + "]");
		
		GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(),
				JacksonFactory.getDefaultInstance(), "https://oauth2.googleapis.com/token",
				clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret(), mAuthCodeId,
				domain) // Specify the same redirect URI that you use with your web
						// app. If you don't have a web version of your app, you can
						// specify an empty string.
						.execute();
		mLog.info("tokenResponse [" + tokenResponse);
		String accessToken = tokenResponse.getAccessToken();

		mLog.info("access Token [" + accessToken);
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

			this.mComments = GoogleHelper.retrieveComments(mDrive, mGoogleProfile.getSlidesId());
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			// mLog.error(ex);
			mLog.error("ERROR WRITTING [" + sw.toString() + "]");
			// TODO Auto-generated catch block
			//mLog.error(e.getLocalizedMessage());
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

		mLog.warn("exiting initialize");
		mLog.trace(GoogleSlideController.class.getName(), "initialize");

	}

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @param HTTP_TRANSPORT The network HTTP Transport.
	 * @return An authorized Credential object.
	 * @throws IOException If the credentials.json file cannot be found.
	 */

	@RequestMapping(value = "/GenerateGoogleSlide", method = RequestMethod.POST)
	public String generateGoogleSlide(Model model,HttpServletRequest request, Authentication authentication, HttpSession session,
			@RequestParam(required = true) String authCodeId) {
		mLog.warn("entering generate");
		mLog.info("request.getLocalName() " + request.getLocalName());
		mLog.info(" request.getLocalAddr(); " + request.getLocalAddr());
		
		mLog.info("authCodeId [" + authCodeId + "]");
		mAuthCodeId = authCodeId;
		mLog.trace(GoogleSlideController.class.getName(), "generate");
		// TODO set to 37 wizard

		String id = null;
		try {
			id = session.getAttribute("ID").toString();
		} catch (Exception ex) {
			mLog.info("not in session id use test wizard");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			// mLog.error(ex);
			mLog.error("ERROR WRITTING DATA [" + sw.toString() + "]");
		}
		mLog.info("session id [" + id + "]");
		String testWizardid = mEnvironment.getProperty("wizard");
		if (testWizardid != null && id == null) {
			id = testWizardid;
			mLog.info("testWizardid [" + testWizardid + "]");
		}

		mDataPages = wizardDataRepository.findByWizardid(Integer.valueOf(id));
		MyUserPrincipal userDetails = (MyUserPrincipal) authentication.getPrincipal();
		mAgent = userDetails.getAgent();

		Optional<Wizard> wizardOpt = wizardRepository.findById(Integer.valueOf(id));

		mWizard = wizardOpt.orElse(null);
		if (mWizard != null) {
			mLog.info("mWizard " + mWizard.getName());
		} else {
			mLog.error("can not file wizard  " + id);
		}

		try {
			initialize(request.getLocalName());
		} catch (IOException ioException) {
			// TODO Auto-generated catch block
			mLog.error(ioException.getMessage());
		} catch (ProfileException ex) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			// mLog.error(ex);
			mLog.error("ERROR WRITTING DATA [" + sw.toString() + "]");
			return "redirect:/googleprofile";
		}

		try {

			// https://docs.google.com/presentation/d/1T-FYqBE2mJ9nsnvF2JzyPbT3W0Uzr07VLyvK4sjnDco/edit#slide=id.p

			// get slide id from agent
			String presentationId = mGoogleProfile.getSlidesId();
			mLog.info("presentationId [" + presentationId + "]");
			// https://docs.google.com/presentation/d/1ZpzLy8P1Nvk2kVLqJ-Bdck4kQRSx3jEuEcf7VB4Mi_Y/edit#slide=id.gac76981968_0_5

			// get the drive service
			mLog.info("WRITING DATA  ");

			try {
				writeSheetData(mSheets);
			} catch (Exception ex) {

				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				// mLog.error(ex);
				mLog.error("ERROR WRITTING DATA [" + sw.toString() + "]");
			}
			mLog.info("DONE WITH WRITING DATA  ");
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
			// Request requestText = new Request();

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
						// Request delRequest = new Request().setDeleteObject(deleteObjectRequest);
						Request deleteRequest = new Request();
						deleteRequest.setDeleteObject(deleteObjectRequest);
						mLog.info("Removing page  [" + excludedPage + "]");
						requests.add(new Request().setDeleteObject(deleteObjectRequest));
						// requests.add(deleteRequest);
					}

				}

			} catch (Exception e) {
				mLog.error("could not read comment   + " + e.getMessage());
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				// mLog.error(ex);
				mLog.error("ERROR comment [" + sw.toString() + "]");

			}
			mLog.info("DELETED OF SLIDES DONE");

			// gb1f3d784ca_0_16
			mLog.info("REPLACE DATA IN SLIDES");
			// add data to slides
			if (mSlidesModels != null) {
				for (SlideInterface page : mSlidesModels) {
					// only process replacement pages

					if (!page.hasReplacementData()) {
						continue; // skip over charts
					}
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
				} // end if for
					// refresh data from sheets for LInk data

				Presentation response = mSlides.presentations().get(this.mNewFileId).execute();
				List<Page> pages = response.getSlides();

				// change i to any other index if desired
				for (Page page : pages) {
					String pageId = page.getObjectId();
					mLog.info("SLIDEID " + pageId);
					List<PageElement> pageElementList = page.getPageElements();
					for (PageElement pageElement : pageElementList) {
						// String desc = pageElement.getDescription();
						// mLog.info("desc " + desc);
						String elementid = pageElement.getObjectId();
						// mLog.info("elementid " + elementid);
						SheetsChart chart = pageElement.getSheetsChart();
						if (chart != null) {
							Integer chartId = chart.getChartId();
							mLog.info("chartId " + chartId);
							requests.add(new Request()
									.setRefreshSheetsChart(new RefreshSheetsChartRequest().setObjectId(elementid)));

						}
						// requests.add(new Request()
						// .setRefreshSheetsChart(new
						// RefreshSheetsChartRequest().setObjectId(elementid)));

					}
					mLog.info(" ");
					// page.getSheetsCharts();

				}
				// requests.add(new Request()
				// .setRefreshSheetsChart(new
				// RefreshSheetsChartRequest().setObjectId("gaa1e0f9807_1_0")));

			} // end of if

			// requests.add(new Request().setReplaceAllText(new ReplaceAllTextRequest()
			// .setContainsText(new
			// SubstringMatchCriteria().setText("{{customer-name}}").setMatchCase(true))
			// .setReplaceText("yes")));
			mLog.info("REPLACE DATA IN SLIDES DONE");
			mLog.info("requests made");
			// Execute the requests for this presentation.
			BatchUpdatePresentationRequest body = new BatchUpdatePresentationRequest().setRequests(requests);
			mLog.info("");
			mLog.info("requests  body [" + body + "]");
			BatchUpdatePresentationResponse responseA = mSlides.presentations().batchUpdate(this.mNewFileId, body)
					.execute();
			mLog.info("");
			// mLog.info("requests responseA [" + responseA);
			// Count total number of replacements made.
			int numReplacements = 0;

			for (Response resp : responseA.getReplies()) {
				try {
					numReplacements += resp.getReplaceAllText().getOccurrencesChanged();
				} catch (Exception ex) {
					// StringWriter sw = new StringWriter();
					// PrintWriter pw = new PrintWriter(sw);
					// ex.printStackTrace(pw);
					// mLog.error(ex);
					// mLog.error("ERROR replace text error [" + resp.toString() + "]");

				}

			}

			/*
			 * Presentation response = slides.presentations().get(newFileId ).execute();
			 * List<Page> pages = response.getSlides(); for (Page page : pages) { //page.
			 * List<PageElement> pageElements = page.getPageElements(); for (PageElement
			 * pageElement : pageElements) { pageElement.getTitle(); } }
			 */

			mLog.info("Created merged presentation for  with ID: " + this.mNewFileId);
			mLog.info("numReplacements " + numReplacements);
			mLog.info("request.getLocalName() " + request.getLocalName());
			mLog.info(" request.getLocalAddr(); " + request.getLocalAddr());
			
			// Credential Credential =
			// String data = new String(bdata, StandardCharsets.UTF_8);
			// mLog.info(data);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			// mLog.error(ex);
			mLog.error("ERROR  [" + sw.toString() + "]");

		}
		// ignore id
		model.addAttribute("agent", mAgent);
		model.addAttribute("generatedSlide", mGeneratedSlide);
		model.addAttribute("googleProfile", mGoogleProfile);
		String nextPage = "googleslidegeneratedpage";
		mLog.warn("exiting generate");
		mLog.trace(GoogleSlideController.class.getName(), "generate");
		return nextPage;

	}

	/**
	 * 
	 * @param service
	 */
	private void writeSheetData(Sheets service) {
		mLog.warn("ENTERING writeSheetData");
		mLog.info("starting WriteSheetExample");
		List<Data> myData = new ArrayList<Data>();

		List<Request> requests = new ArrayList<>();

		List<CellData> values = new ArrayList<>();

		// values.add(new CellData()
		// .setUserEnteredValue(new ExtendedValue()
		// .setStringValue("Hello World!")));

		// String spreadsheetId = "1NVWsixQHvBFbr9fpUmSCFKfb3BNrbYgspYSZzyItZL8";
		String spreadsheetId = this.mGoogleProfile.getSheetsId();
		// try {
		// The ranges to retrieve from the spreadsheet.
		// List<String> ranges = new ArrayList<>(); // TODO: Update placeholder value.

		// True if grid data should be returned.
		// This parameter is ignored if a field mask was set in the request.
		/*
		 * boolean includeGridData = false; // TODO: Update placeholder value.
		 * 
		 * Spreadsheets.Get spreadSheets = service.spreadsheets().get(spreadsheetId);
		 * spreadSheets.setRanges(ranges);
		 * spreadSheets.setIncludeGridData(includeGridData);
		 * 
		 * Spreadsheet response = spreadSheets.execute(); List<Sheet>
		 * sheets=response.getSheets();
		 * 
		 * for (Sheet sheet : sheets) { mLog.info("sheet [" + sheet.toString() + "]");
		 * List<EmbeddedChart> charts = sheet.getCharts(); for (EmbeddedChart chart :
		 * charts) { Integer chartID = chart.getChartId(); mLog.info("chart id [" +
		 * chartID + "]"); } }
		 */

		// updateChartSpecRequest.setSpec(spec)

		// spreadSheets.
		// spreadSheets.getClass().getName();
		// mLog.info("package [" + spreadSheets.getClass().getPackage().getName() +
		// "]");

		// mLog.info("spreadSheets.getClass().getName(); [" +
		// spreadSheets.getClass().getName() + "]");
		// } catch (IOException e1) {
		// TODO Auto-generated catch block
		// mLog.error(e1.getMessage());
		// }
		mLog.info("starting spreadsheetId [" + spreadsheetId + "]");

		// String writeRange = "ConfidentialClientEvaluationOnePage_Data!A1:B"; // range
		// and sheet name
		String writeRange = null; // range and sheet name

		if (mSlidesModels != null) {
			for (SlideInterface page : mSlidesModels) {
				mLog.info("PAGE Name [" + page.getPageName() + "]");
				mLog.info("SLIDEENUM [" + page.getSlideEnum() + "]");

				List<List<Object>> writeData = new ArrayList<>();

				if (page.getSlideEnum() == null) {
					mLog.info("no enumeration found");
					continue;// skip
				}

				writeRange = page.getWriteRange();
				mLog.info("writeRange [" + writeRange + "]");
				if (writeRange == null) {
					mLog.info("no writerange  found");
					continue;// skip
				}
				ClientObjectivesOnePageModel clientObjectivesOnePageModel = null;

				try {
					clientObjectivesOnePageModel = page.getSlidesData().getPageModels()
							.getClientObjectivesOnePageModel();
				} catch (Exception ex) {
					// sollow
					mLog.info("just not yet in map");
				}

				List<Object> dataRowOne = new ArrayList<>();
				List<Object> dataRowTwo = new ArrayList<>();
				List<Object> dataRowThree = new ArrayList<>();
				List<Object> dataRowFour = new ArrayList<>();
				List<Object> dataRowFive = new ArrayList<>();
				List<Object> dataRowSix = new ArrayList<>();

				Integer turnOn = null;
				switch (page.getSlideEnum()) {

				case BarChart:
					mLog.warn("BAR CHART WRITTING");
					mLog.info("bar chart start write [" + page.getPageName() + "]");
					MediaChart mediaChart = page.getMediaChart();
					if (mediaChart == null) {
						mLog.warn("null mediachart data skipping " + page.getPageName());
						continue;
					}
					List<Object> dataRowHeader = new ArrayList<>();

					// spike = green slow = red base = blue
					dataRowHeader.add("Month");
					dataRowHeader.add("Spike");
					dataRowHeader.add("Slow");
					dataRowHeader.add("Brand");
					writeData.add(dataRowHeader);

					try {
						/*     */
						List<Object> dataRowJan = GoogleHelper.writeJan(mediaChart);
						writeData.add(dataRowJan);

						List<Object> dataRowFeb = GoogleHelper.writeFeb(mediaChart);
						writeData.add(dataRowFeb);

						List<Object> dataRowMar = GoogleHelper.writeMar(mediaChart);
						writeData.add(dataRowMar);

						List<Object> dataRowApr = GoogleHelper.writeApr(mediaChart);
						writeData.add(dataRowApr);

						List<Object> dataRowMay = GoogleHelper.writeMay(mediaChart);
						writeData.add(dataRowMay);

						List<Object> dataRowJun = GoogleHelper.writeJun(mediaChart);
						writeData.add(dataRowJun);

						List<Object> dataRowJul = GoogleHelper.writeJul(mediaChart);
						writeData.add(dataRowJul);

						List<Object> dataRowAug = GoogleHelper.writeAug(mediaChart);
						writeData.add(dataRowAug);

						List<Object> dataRowSep = GoogleHelper.writeSep(mediaChart);
						writeData.add(dataRowSep);

						List<Object> dataRowOct = GoogleHelper.writeOct(mediaChart);
						writeData.add(dataRowOct);

						List<Object> dataRowNov = GoogleHelper.writeNov(mediaChart);
						writeData.add(dataRowNov);

						List<Object> dataRowDec = GoogleHelper.writeDec(mediaChart);
						writeData.add(dataRowDec);
					} catch (Exception ex) {
						mLog.warn("null mediachart values data skipping " + page.getPageName());
						continue;
					}
					mLog.info("finish setting up bar end chart [" + page.getPageName() + "]");

					break;

				case ClientObjectiveTop:
					mLog.warn("ClientObjectiveTop start writting [" + page.getPageName() + "]");

					List<ClientObjectivesOnePageTwoModel> orderList = page.getSlidesData().getPageModels()
							.getOrderList();
					if (orderList == null) {
						mLog.warn("null orderList skipping " + page.getPageName());
						continue;
					}
					int counter = 1;
					for (ClientObjectivesOnePageTwoModel clientObjectivesOnePageTwoModel : orderList) {
						int sortOrder = clientObjectivesOnePageTwoModel.getSortOrder();
						if (sortOrder == 0) {
							// skip
							continue;
						}
						List<Object> dataRow = new ArrayList<>();
						String content = GoogleHelper.findLabelContent(clientObjectivesOnePageTwoModel.getLabel());
						dataRow.add(counter + ". " + content);
						counter = counter + 1;
						writeData.add(dataRow);
					}
					mLog.warn("finish setting up ClientObjectiveTop [" + page.getPageName() + "]");

					break;
				case ClientObjectivePRODUCTSERVICE:
					mLog.warn("ClientObjectiveProductService start writting [" + page.getPageName() + "]");

					if (clientObjectivesOnePageModel == null) {
						mLog.warn("null ClientObjectiveProductService skipping " + page.getPageName());
						continue;
					}

					turnOn = clientObjectivesOnePageModel.isIntroduceNewDepartment() ? 0 : 1;
					dataRowOne.add(turnOn);
					writeData.add(dataRowOne);

					turnOn = clientObjectivesOnePageModel.isFeatureSpecificProducts() ? 0 : 1;
					dataRowTwo.add(turnOn);
					writeData.add(dataRowTwo);

					turnOn = clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried() ? 0 : 1;
					dataRowThree.add(turnOn);
					writeData.add(dataRowThree);

					turnOn = clientObjectivesOnePageModel.isPromoteOffPriceItemsServices() ? 0 : 1;
					dataRowFour.add(turnOn);
					writeData.add(dataRowFour);

					turnOn = clientObjectivesOnePageModel.isUtilizeCoopVendorDollars() ? 0 : 1;
					dataRowFive.add(turnOn);
					writeData.add(dataRowFive);
					// dataRow.add(pieChart.getLabelValue());

					mLog.warn("finish setting up ClientObjectiveProductService [" + page.getPageName() + "]");

					break;
				case ClientObjectiveCONSUMER:
					mLog.warn("ClientObjectiveConsumer start writting [" + page.getPageName() + "]");

					if (clientObjectivesOnePageModel == null) {
						mLog.warn("null ClientObjectiveConsumer skipping " + page.getPageName());
						continue;
					}

					turnOn = clientObjectivesOnePageModel.isRetainCurrentConsumers() ? 0 : 1;

					dataRowOne.add(turnOn);
					writeData.add(dataRowOne);

					turnOn = clientObjectivesOnePageModel.isIncreaseCustomerVisits() ? 0 : 1;

					dataRowTwo.add(turnOn);
					writeData.add(dataRowTwo);

					turnOn = clientObjectivesOnePageModel.isIncreaseTrafficLeadCalls() ? 0 : 1;

					dataRowThree.add(turnOn);
					writeData.add(dataRowThree);

					turnOn = clientObjectivesOnePageModel.isExpandTargetConsumers() ? 0 : 1;

					dataRowFour.add(turnOn);
					writeData.add(dataRowFour);

					turnOn = clientObjectivesOnePageModel.isChangeConsumerAttitudes() ? 0 : 1;

					dataRowFive.add(turnOn);
					writeData.add(dataRowFive);

					mLog.info(writeData.toString());
					// dataRow.add(pieChart.getLabelValue());

					mLog.warn("finish setting up ClientObjectiveConsumer [" + page.getPageName() + "]");

					break;
				case ClientObjectivePROMOTION:
					mLog.warn("ClientObjectivePromotion start writting [" + page.getPageName() + "]");

					if (clientObjectivesOnePageModel == null) {
						mLog.warn("null clientObjectivesOnePageModel skipping " + page.getPageName());
						continue;
					}

					turnOn = clientObjectivesOnePageModel.isMakePromotionalEventsStronger() ? 0 : 1;
					dataRowOne.add(turnOn);
					writeData.add(dataRowOne);

					turnOn = clientObjectivesOnePageModel.isIncreaseDigitalMobileOnlineResponse() ? 0 : 1;
					dataRowTwo.add(turnOn);
					writeData.add(dataRowTwo);

					turnOn = clientObjectivesOnePageModel.isQuarterlySeasonalCampaign() ? 0 : 1;
					dataRowThree.add(turnOn);
					writeData.add(dataRowThree);

					turnOn = clientObjectivesOnePageModel.isDevelopDatabaseMarketing() ? 0 : 1;
					dataRowFour.add(turnOn);
					writeData.add(dataRowFour);

					turnOn = clientObjectivesOnePageModel.isInitiateCauseMarketingProgram() ? 0 : 1;
					dataRowFive.add(turnOn);
					writeData.add(dataRowFive);
					// dataRow.add(pieChart.getLabelValue());

					turnOn = clientObjectivesOnePageModel.isDevelopSpeciallyStagedEvent() ? 0 : 1;
					dataRowSix.add(turnOn);
					writeData.add(dataRowSix);

					mLog.warn("finish setting up ClientObjectivePromotion [" + page.getPageName() + "]");

					break;
				case ClientObjectiveBRAND:
					mLog.warn("ClientObjectiveBrand start writting [" + page.getPageName() + "]");

					if (clientObjectivesOnePageModel == null) {
						mLog.warn("null ClientObjectiveBrand skipping " + page.getPageName());
						continue;
					}

					turnOn = clientObjectivesOnePageModel.isMaintainMarketDominance() ? 0 : 1;
					dataRowOne.add("Maintain Market Dominance");
					dataRowOne.add(turnOn);
					writeData.add(dataRowOne);

					turnOn = clientObjectivesOnePageModel.isImproveBusinessNameBrand() ? 0 : 1;
					dataRowTwo.add("Elevate Business Brand/Image");
					dataRowTwo.add(turnOn);
					writeData.add(dataRowTwo);

					turnOn = clientObjectivesOnePageModel.isEstablishorReestablishBusinessImage() ? 0 : 1;
					dataRowThree.add("Improve Reputation and Listing Management");
					dataRowThree.add(turnOn);
					writeData.add(dataRowThree);

					turnOn = clientObjectivesOnePageModel.isCreatePentUpDemand() ? 0 : 1;
					dataRowFour.add("Enhance Website (Mobile, Response, SEO, SEM)");
					dataRowFour.add(turnOn);
					writeData.add(dataRowFour);

					turnOn = clientObjectivesOnePageModel.isIncreaseMarketShare() ? 0 : 1;
					dataRowFive.add("Increase Market Share");
					dataRowFive.add(turnOn);
					writeData.add(dataRowFive);
					if (clientObjectivesOnePageModel.getOtherText() != null) {
						turnOn = clientObjectivesOnePageModel.isOther() ? 0 : 1;
						dataRowSix.add(clientObjectivesOnePageModel.getOtherText());
						dataRowSix.add(turnOn);
						writeData.add(dataRowSix);
					}

					mLog.warn("finish setting up ClientObjectiveBrand [" + page.getPageName() + "]");

					break;
				case PlanASpreadSheet:
					mLog.warn("PlanASpreadSheet WRITTING");
					List<Object> dataRowPlanASpreadSheetHeader = new ArrayList<>();
					List<Object> dataRowPlanASpreadSheetFooter = new ArrayList<>();
					PlanMediaPageModel planAMediaPagedataPageModel = page.getSlidesData().getPageModels()
							.getPlanAMediaPagedataPageModel();
					

					try {
						PlanSpreadSheets planSpreadSheets = new PlanSpreadSheets(planAMediaPagedataPageModel.getMediaRows());

						// spike = green slow = red base = blue
						dataRowPlanASpreadSheetHeader.add("Media");
						dataRowPlanASpreadSheetHeader.add("Jan");
						dataRowPlanASpreadSheetHeader.add("Feb");
						dataRowPlanASpreadSheetHeader.add("Mar");
						dataRowPlanASpreadSheetHeader.add("Apr");
						dataRowPlanASpreadSheetHeader.add("May");
						dataRowPlanASpreadSheetHeader.add("Jun");
						dataRowPlanASpreadSheetHeader.add("Jul");
						dataRowPlanASpreadSheetHeader.add("Aug");
						dataRowPlanASpreadSheetHeader.add("Sep");
						dataRowPlanASpreadSheetHeader.add("Oct");
						dataRowPlanASpreadSheetHeader.add("Nov");
						dataRowPlanASpreadSheetHeader.add("Dec");
						dataRowPlanASpreadSheetHeader.add("Total");
						writeData.add(dataRowPlanASpreadSheetHeader);

						List<PlanSpreadSheet> planSpreadSheetList = planSpreadSheets.getPlanSpreadSheets();
						for (PlanSpreadSheet row : planSpreadSheetList) {
							List<Object> dataRow = new ArrayList<>();
							dataRow.add(row.getName());
							dataRow.add(row.getJan());
							dataRow.add(row.getFeb());
							dataRow.add(row.getMar());
							dataRow.add(row.getApr());
							dataRow.add(row.getMay());
							dataRow.add(row.getJun());
							dataRow.add(row.getJul());
							dataRow.add(row.getAug());
							dataRow.add(row.getSep());
							dataRow.add(row.getOct());
							dataRow.add(row.getNov());
							dataRow.add(row.getDec());
							String gt = GoogleHelper.convertStringToCurrency(row.getRt());
							dataRow.add(gt);
							writeData.add(dataRow);
						}
						
						
						dataRowPlanASpreadSheetFooter.add("Monthly Totals");
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getJan());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getFeb());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getMar());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getApr());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getMay());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getJun());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getJul());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getAug());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getSep());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getOct());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getNov());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getDec());
						dataRowPlanASpreadSheetFooter.add(planSpreadSheets.getRt());
						writeData.add(dataRowPlanASpreadSheetFooter);
						

					} catch (Exception ex) {
						StringWriter sw = new StringWriter();
						PrintWriter pw = new PrintWriter(sw);
						ex.printStackTrace(pw);
						// mLog.error(ex);
						mLog.error("ERROR PlanASpreadSheet DATA [" + sw.toString() + "]");
						//mLog.error("ERROR PlanASpreadSheet WRITTING " + ex.getMessage());
					}

					mLog.warn("finish PlanASpreadSheet start writting [" + page.getPageName() + "]");

					break;
				case PlanBSpreadSheet:
					mLog.warn("PlanBSpreadSheet WRITTING");
					List<Object> dataRowPlanBSpreadSheetHeader = new ArrayList<>();
					List<Object> dataRowPlanBSpreadSheetFooter = new ArrayList<>();
					PlanMediaPageModel planBMediaPagedataPageModel = page.getSlidesData().getPageModels()
							.getPlanBMediaPagedataPageModel();
					
					try {
					PlanSpreadSheets planBSpreadSheets = new PlanSpreadSheets(planBMediaPagedataPageModel.getMediaRows());
					
					// spike = green slow = red base = blue
					dataRowPlanBSpreadSheetHeader.add("Media");
					dataRowPlanBSpreadSheetHeader.add("Jan");
					dataRowPlanBSpreadSheetHeader.add("Feb");
					dataRowPlanBSpreadSheetHeader.add("Mar");
					dataRowPlanBSpreadSheetHeader.add("Apr");
					dataRowPlanBSpreadSheetHeader.add("May");
					dataRowPlanBSpreadSheetHeader.add("Jun");
					dataRowPlanBSpreadSheetHeader.add("Jul");
					dataRowPlanBSpreadSheetHeader.add("Aug");
					dataRowPlanBSpreadSheetHeader.add("Sep");
					dataRowPlanBSpreadSheetHeader.add("Oct");
					dataRowPlanBSpreadSheetHeader.add("Nov");
					dataRowPlanBSpreadSheetHeader.add("Dec");
					dataRowPlanBSpreadSheetHeader.add("Total");
					writeData.add(dataRowPlanBSpreadSheetHeader);
					
					List<PlanSpreadSheet> planSpreadSheetList = planBSpreadSheets.getPlanSpreadSheets();
					for (PlanSpreadSheet row : planSpreadSheetList) {
						List<Object> dataRow = new ArrayList<>();
						dataRow.add(row.getName());
						dataRow.add(row.getJan());
						dataRow.add(row.getFeb());
						dataRow.add(row.getMar());
						dataRow.add(row.getApr());
						dataRow.add(row.getMay());
						dataRow.add(row.getJun());
						dataRow.add(row.getJul());
						dataRow.add(row.getAug());
						dataRow.add(row.getSep());
						dataRow.add(row.getOct());
						dataRow.add(row.getNov());
						dataRow.add(row.getDec());
						String gt = GoogleHelper.convertStringToCurrency(row.getRt());
						dataRow.add(gt);
						writeData.add(dataRow);
					}
				
					dataRowPlanBSpreadSheetFooter.add("Monthly Totals");
					
					mLog.info(planBSpreadSheets.getJan());
					mLog.info(planBSpreadSheets.getFeb());
					mLog.info(planBSpreadSheets.getMar());
					mLog.info(planBSpreadSheets.getApr());
					mLog.info(planBSpreadSheets.getMay());
					mLog.info(planBSpreadSheets.getJun());
					mLog.info(planBSpreadSheets.getJul());
					mLog.info(planBSpreadSheets.getAug());
					mLog.info(planBSpreadSheets.getSep());
					mLog.info(planBSpreadSheets.getOct());
					mLog.info(planBSpreadSheets.getNov());
					mLog.info(planBSpreadSheets.getDec());
					mLog.info(planBSpreadSheets.getRt());
					
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getJan());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getFeb());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getMar());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getApr());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getMay());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getJun());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getJul());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getAug());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getSep());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getOct());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getNov());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getDec());
					dataRowPlanBSpreadSheetFooter.add(planBSpreadSheets.getRt());
					
					
					writeData.add(dataRowPlanBSpreadSheetFooter);
					
					} catch (Exception ex) {
						StringWriter sw = new StringWriter();
						PrintWriter pw = new PrintWriter(sw);
						ex.printStackTrace(pw);
						// mLog.error(ex);
						mLog.error("ERROR PlanBSpreadSheet DATA [" + sw.toString() + "]");
						
						
						//mLog.error("ERROR PlanBSpreadSheet WRITTING " + ex.getMessage());
					}

					mLog.warn("finish PlanBSpreadSheet start writting [" + page.getPageName() + "]");

					break;
				case PieChart:
					mLog.warn("PIE CHART WRITTING");
					mLog.warn("pie chart start writting [" + page.getPageName() + "]");

					List<PieChart> pieChartList = page.getPieChartData();
					if (pieChartList == null) {
						mLog.warn("null pie data skipping " + page.getPageName());
						continue;
					}

					for (PieChart pieChart : pieChartList) {
						String label = pieChart.getLabel();
						if (label != null && !label.equals("")) {
							mLog.info("label   [" + label + "]");
							List<Object> dataRow = new ArrayList<>();
							dataRow.add(pieChart.getLabel());
							dataRow.add(pieChart.getLabelValue());
							writeData.add(dataRow);
						}

					}
					mLog.warn("finish setting up pie chart start writting [" + page.getPageName() + "]");

					break;
				default:
					break;
				}

				ValueRange body = new ValueRange().setValues(writeData).setMajorDimension("ROWS");
				// ValueRange body = new ValueRange().setValues(values);
				try {

					// cleare values
					// TODO: Assign values to desired fields of `requestBody`:
					ClearValuesRequest requestBody = new ClearValuesRequest();
					mLog.info("ClearValuesResponse ");
					
					
                    if (page != null && page.getWriteRange() != null) {
                    	Sheets.Spreadsheets.Values.Clear request = service.spreadsheets().values().clear(spreadsheetId,
    							page.getWriteRange(), requestBody);
    					mLog.info("ClearValuesResponse ");
    					ClearValuesResponse response = request.execute();
    					mLog.info("response from [" + response + "]");

    					UpdateValuesResponse result = service.spreadsheets().values()
    							.update(spreadsheetId, writeRange, body).setValueInputOption("RAW").execute();
    					mLog.info("updated data [" + result + "]");
    					mLog.warn("WROTE data for  [" + writeRange + "]");
                    }
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
					e.printStackTrace(pw);
					// mLog.error(ex);
					mLog.error("ERROR Clearing data [" + sw.toString() + "]");
				
					
				}

			} // end of for
		} // end of outter if

		/*
		 * 
		 * ValueRange body = new
		 * ValueRange().setValues(writeData).setMajorDimension("ROWS"); // ValueRange
		 * body = new ValueRange().setValues(values); try {
		 * 
		 * // cleare values // TODO: Assign values to desired fields of `requestBody`:
		 * ClearValuesRequest requestBody = new ClearValuesRequest();
		 * 
		 * Sheets.Spreadsheets.Values.Clear request =
		 * service.spreadsheets().values().clear(spreadsheetId, writeRange,
		 * requestBody);
		 * 
		 * ClearValuesResponse response = request.execute(); mLog.info("response [" +
		 * response + "]");
		 * 
		 * UpdateValuesResponse result =
		 * service.spreadsheets().values().update(spreadsheetId, writeRange, body)
		 * .setValueInputOption("RAW").execute(); mLog.info("result [" + result + "]");
		 * mLog.warn("exting WriteSheetExample"); } catch (IOException e) { // TODO
		 * Auto-generated catch block mLog.error(spreadsheetId + " not found");
		 * mLog.error(e.getMessage()); mLog.warn("exiting WriteSheetExample"); }
		 */

		// BatchUpdateSpreadsheetRequest batchUpdateRequest = new
		// BatchUpdateSpreadsheetRequest()
		// .setRequests(requests);
		// service.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest)
		// .execute();
		mLog.warn("LEAVING writeSheetData");

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
