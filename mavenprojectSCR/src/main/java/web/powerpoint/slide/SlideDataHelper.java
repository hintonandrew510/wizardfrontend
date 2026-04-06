/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.google.slide.PageModels;
import web.google.slide.SlideEnum;
import web.google.slide.SlidesData;
import web.model.Contact;
import web.model.WizardData;
import web.page.ChartBuilder;
import web.page.JSONManager;
import web.page.PageNameEnum;
import static web.page.PageNameEnum.ClientObjectivesOnePage;
import static web.page.PageNameEnum.ConfidentialClientEvaluationOnePage;
import static web.page.PageNameEnum.CreateConceptOnePage;
import static web.page.PageNameEnum.CreateConceptTwoPage;
import static web.page.PageNameEnum.DigitalMobileSocialStrategiesPage;
import static web.page.PageNameEnum.MarketPlaceCompetitionPage;
import static web.page.PageNameEnum.MarketingStrategiesPage;
import static web.page.PageNameEnum.PlanABEPPage;
import static web.page.PageNameEnum.PlanADigitalROICalculatorPage;
import static web.page.PageNameEnum.PlanAExcelPage;
import static web.page.PageNameEnum.PlanALifetimeValuedPage;
import static web.page.PageNameEnum.PlanAMediaPage;
import static web.page.PageNameEnum.PlanAProposedPage;
import static web.page.PageNameEnum.PlanBBEPPage;
import static web.page.PageNameEnum.PlanBDigitalROICalculatorPage;
import static web.page.PageNameEnum.PlanBExcelPage;
import static web.page.PageNameEnum.PlanBLifetimeValuedPage;
import static web.page.PageNameEnum.PlanBMediaPage;
import static web.page.PageNameEnum.PlanBProposedPage;
import static web.page.PageNameEnum.PresentedToPage;
import static web.page.PageNameEnum.ProfileOfConsumersPage;
import static web.page.PageNameEnum.StrategicMarketingPageOne;
import static web.page.PageNameEnum.StrategicMarketingPageThree;
import static web.page.PageNameEnum.StrategicMarketingPageTwo;
import static web.page.PageNameEnum.TargetMarketingPage;
import static web.page.PageNameEnum.TeamCommitmentPage;
import web.page.PieChart;
import web.page.Publish;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageModel;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageTwoModel;
import web.page.clientobjectivesonepage.ClientObjectivesPageHelper;
import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;
import web.page.extra.ExtraPageModel;
import web.page.marketplacecompetitionpage.MarketPlaceCompetitionPageModel;
import web.page.planABEPPage.PlanABEPPageModel;
import web.page.planBBEPPage.PlanBBEPPageModel;
import web.page.planDigitalroicalculatorpage.PlanDigitalROICalculatorPageModel;
import web.page.planalifetimevaluedpage.PlanALifetimeValuedPageModel;
import web.page.planamedipage.MediaChart;
import web.page.planamedipage.MediaChartHelper;
import web.page.planamedipage.PlanMediaPageModel;
import web.page.planbLifetimevaluedpage.PlanBLifetimeValuedPageModel;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;
import web.page.strategicmarketingpagethree.StrategicMarketingHelper;
import web.page.strategicmarketingpagethree.StrategicMarketingPageThreeModel;
import web.page.strategicmarketingpagetwo.StrategicMarketingPageTwoModel;
import web.page.targetmarketingpage.TargetMarketingHeaderRow;
import web.page.targetmarketingpage.TargetMarketingPageModel;
import web.page.teamcommitmentpage.TeamCommitmentPageModel;
import web.powerpoint.slide.pages.EightConfidentialClientEvaluationOneSlide;
import web.powerpoint.slide.pages.EightConfidentialClientEvaluationOneTextSlide;
import web.powerpoint.slide.pages.FiveStrategicMarketingPageSlide;
import web.powerpoint.slide.pages.FourClientObjectiveSlide;
import web.powerpoint.slide.pages.FourClientObjectiveTextSlide;
import web.powerpoint.slide.pages.NineConfidentialClientEvaluationProposedSlide;
import web.powerpoint.slide.pages.NineConfidentialClientEvaluationProposedTextSlide;
import web.powerpoint.slide.pages.NineteenPlanAProposedTextSlide;
import web.powerpoint.slide.pages.OnePresentedToSlide;
import web.powerpoint.slide.pages.SevenConfidentialClientEvaluationTextSlide;
import web.powerpoint.slide.pages.SeventeenPlanAMediaSlide;
import web.powerpoint.slide.pages.SixTargetMarketingSlide;
import web.powerpoint.slide.pages.ThirtyPlanBSpreadSheetSlide;
import web.powerpoint.slide.pages.ThirtyPlanBSpreadSheetTextSlide;
import web.powerpoint.slide.pages.ThreeMarketPlaceCompetitionSlide;
import web.powerpoint.slide.pages.TwentyEightPlanBDigitalROICalculatorTextSlide;
import web.powerpoint.slide.pages.TwentyFivePlanBProposedTextSlide;
import web.powerpoint.slide.pages.TwentyNinePlanASpreadSheetSlide;
import web.powerpoint.slide.pages.TwentyNinePlanASpreadSheetTextSlide;
import web.powerpoint.slide.pages.TwentyOnePlanALifetimeValuedTextSlide;
import web.powerpoint.slide.pages.TwentyPlanABEPTextSlide;
import web.powerpoint.slide.pages.TwentySevenPlanBLifetimeValuedTextSlide;
import web.powerpoint.slide.pages.TwentySixPlanBBEPTextSlide;
import web.powerpoint.slide.pages.TwentyThreePlanBMediaSlide;
import web.powerpoint.slide.pages.TwentyTwoPlanADigitalROICalculatorTextSlide;
import web.powerpoint.slide.pages.TwoTeamCommitmentSlide;

/**
 *
 * @author andrewhinton
 */
public class SlideDataHelper {

    private static final Logger mLog = LoggerFactory.getLogger(SlideDataHelper.class.getName());

    public static SlideInterface findModelBySlidePageName(String slidePageName, List<SlideInterface> models) {
        SlideInterface foundSlideInterface = null;
        for (SlideInterface model : models) {
            String modelname = model.getSlideEnum().getDescription();
            if (slidePageName.equals(modelname)) {
                foundSlideInterface = model;
                break;
            }

        }

        return foundSlideInterface;
    }

    public static List<SlideInterface> getSlidesData(Iterable<WizardData> dataPages, Contact contact) {
        mLog.warn("entering getSlidesData");
        List<SlideInterface> slidesList = new ArrayList<SlideInterface>();
        SlidesData slidesData = new SlidesData();
        ClientObjectivesOnePageModel clientObjectivesOnePageModel = null;
        StrategicMarketingPageOneModel strategicMarketingPageOneModel = null;
        ConfidentialClientEvaluationOnePageModel confidentialClientEvaluationOnePageModel = null;
        MarketPlaceCompetitionPageModel marketPlaceCompetitionPageModel = null;
        PlanABEPPageModel planABEPPageModel = null;
        PlanDigitalROICalculatorPageModel planADigitalROICalculatorPageModel = null;

        PageModels pageModels = new PageModels();
        Publish publish = new Publish();
        // get all pages

        for (WizardData data : dataPages) {
            // pull of data model
            PageNameEnum pageName = null;
            try {
                pageName = PageNameEnum.valueOf(data.getPagename());
            } catch (Exception ex) {
                mLog.error("error " + ex.getMessage());
                continue;
            }

//            // exculded
//            if (data.isExcluded()) {
//                mLog.info("PAGE Excluded name = " + pageName);
//                continue;
//            }
            switch (pageName) {

                // ConfidentialClientEvaluationOnePage
                case ClientObjectivesOnePage:
                    try {

                        clientObjectivesOnePageModel = (ClientObjectivesOnePageModel) JSONManager
                                .convertFromJson(data.getPagedata(), ClientObjectivesOnePageModel.class);
                        List<ClientObjectivesOnePageTwoModel> orderList = ClientObjectivesPageHelper.getList(true,
                                clientObjectivesOnePageModel);

                        strategicMarketingPageOneModel = (StrategicMarketingPageOneModel) JSONManager
                                .convertFromJson(data.getPagedata(), StrategicMarketingPageOneModel.class);
                        // model.addAttribute("StrategicMarketingPageOne",
                        // strategicMarketingPageOneModel);

                        publish.setStrategicMarketingPageOne(true);
                        slidesData.getPageModels().setStrategicMarketingPageOneModel(strategicMarketingPageOneModel);

                        List<Object> pageData = new ArrayList<Object>();
                        pageData.add(clientObjectivesOnePageModel);
                        pageData.add(orderList);

                        slidesData.getPageModels().setOrderList(orderList);
                        slidesData.getPageModels().setClientObjectivesOnePageModel(clientObjectivesOnePageModel);

                        /*
                          slidesData.getPageModels().setPresentedToPageModel(presentedToPageModel);
                        // if (!presentedToPageModel.getClientBusinessName().isEmpty() &&
                        // !presentedToPageModel.getClientContactName().isEmpty()) {
                        OnePresentedToSlide presentedToSlide = new OnePresentedToSlide(slidesData,
                                SlidePageNameEnum.OnePresentedToSlide, "OnePresentedToSlide");
                        slidesList.add(presentedToSlide);
                         */
                        mLog.info("found page ClientObjectivesOnePageTwoModel");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }

                case ConfidentialClientEvaluationOnePage:
                    try {

                        confidentialClientEvaluationOnePageModel = (ConfidentialClientEvaluationOnePageModel) JSONManager
                                .convertFromJson(data.getPagedata(), ConfidentialClientEvaluationOnePageModel.class);
                        List<PieChart> pieChart = ChartBuilder
                                .buildLastYearConfidentialClientEvaluation(confidentialClientEvaluationOnePageModel);
                        // slide 8
                        slidesData.getPageModels().setPieChartConfidentialClientEvaluationOnePage(pieChart);

                        slidesData.getPageModels()
                                .setConfidentialClientEvaluationOnePageModel(confidentialClientEvaluationOnePageModel);
                        slidesData.getPublish().setConfidentialClientEvaluationOnePage(true);

                        // model.addAttribute("ConfidentialClientEvaluationOnePageLastYearChartModel",
                        // pieChart);
                        // model.addAttribute("ConfidentialClientEvaluationOnePageModel", pieChart);
                        // model.addAttribute("ConfidentialClientEvaluationPageDataModel",
                        // confidentialClientEvaluationOnePageModel);
                        if (pieChart.size() > 0) {
                            publish.setConfidentialClientEvaluationOnePage(true);
                        }

                        // confidentialClientEvaluationProposedPage
                        List<PieChart> pieChartProposed = ChartBuilder
                                .buildNextYearConfidentialClientEvaluation(confidentialClientEvaluationOnePageModel);
                        slidesData.getPageModels().setPieChartConfidentialClientEvaluationProposed(pieChartProposed);
                        // slide 9
                        slidesData.getPublish().setConfidentialClientEvaluationProposedPage(true);

                        // NineConfidentialClientEvaluationProposedSlide
                        // model.addAttribute("ConfidentialClientEvaluationOnePageLastYearChartProposedModel",
                        // pieChartProposed);
                        // model.addAttribute("ConfidentialClientEvaluationOnePageModel",
                        // pieChartProposed);
                        if (pieChartProposed.size() > 0) {
                            publish.setConfidentialClientEvaluationProposedPage(true);
                        }

                        mLog.info("found page ConfidentialClientEvaluationOnePageModel");
                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case CreateConceptOnePage:
                    try {
                        ExtraPageModel createConceptOnePageModel = null;

                        createConceptOnePageModel = (ExtraPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                ExtraPageModel.class);
                        // model.addAttribute("CreateConceptOnePageModel", createConceptOnePageModel);

                        publish.setCreateConceptOnePage(true);
                        mLog.info("found page createConceptOnePageModel");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case CreateConceptTwoPage:
                    try {
                        ExtraPageModel createConceptTwoPageModel = null;

                        createConceptTwoPageModel = (ExtraPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                ExtraPageModel.class);
                        // model.addAttribute("CreateConceptTwoPageModel", createConceptTwoPageModel);

                        publish.setCreateConceptTwoPage(true);
                        mLog.info("found page createConceptTwoPageModel");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case DigitalMobileSocialStrategiesPage:
                    try {
                        ExtraPageModel digitalMobileSocialStrategiesPageModel = null;

                        digitalMobileSocialStrategiesPageModel = (ExtraPageModel) JSONManager
                                .convertFromJson(data.getPagedata(), ExtraPageModel.class);
                        // model.addAttribute("DigitalMobileSocialStrategiesPageModel",
                        // digitalMobileSocialStrategiesPageModel);
                        mLog.info("found page digitalMobileSocialStrategiesPage");

                        publish.setDigitalMobileSocialStrategiesPage(true);

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }

                case MarketPlaceCompetitionPage:
                    try {

                        marketPlaceCompetitionPageModel = (MarketPlaceCompetitionPageModel) JSONManager
                                .convertFromJson(data.getPagedata(), MarketPlaceCompetitionPageModel.class);
                        // model.addAttribute("MarketPlaceCompetitionPageModel",
                        // marketPlaceCompetitionPageModel);
                        slidesData.getPageModels().setMarketPlaceCompetitionPageModel(marketPlaceCompetitionPageModel);

                        mLog.info("found page marketingStrategiesPageModel");

                        publish.setMarketingStrategiesPage(true);
                        publish.setMarketPlaceCompetitionPage(true);
                        mLog.info("found page MarketPlaceCompetitionPageModel");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case MarketingStrategiesPage:
                    try {
                        ExtraPageModel marketingStrategiesPageModel = null;

                        marketingStrategiesPageModel = (ExtraPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                ExtraPageModel.class);
                        // model.addAttribute("MarketingStrategiesPageModel",
                        // marketingStrategiesPageModel);

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }

                case PlanABEPPage:
                    try {

                        planABEPPageModel = (PlanABEPPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                PlanABEPPageModel.class);
                        // model.addAttribute("PlanABEPPageModel", planABEPPageModel);
                        slidesData.getPublish().setPlanABEPPage(true);
                        slidesData.getPageModels().setPlanABEPPageModel(planABEPPageModel);

                        // TwentyPlanABEPTextSlide
                        mLog.info("found page PlanABEPPage");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }

                case PlanADigitalROICalculatorPage:
                    try {

                        planADigitalROICalculatorPageModel = (PlanDigitalROICalculatorPageModel) JSONManager
                                .convertFromJson(data.getPagedata(), PlanDigitalROICalculatorPageModel.class);
                        // model.addAttribute("PlanADigitalROICalculatorPage",
                        // planADigitalROICalculatorPageModel);

                        slidesData.getPublish().setPlanADigitalROICalculatorPage(true);

                        slidesData.getPageModels()
                                .setPlanADigitalROICalculatorPageModel(planADigitalROICalculatorPageModel);

                        mLog.info("found page PlanADigitalROICalculatorPage");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }

                case PlanAExcelPage:
                    try {
                        ExtraPageModel planAExcelPageModel = null;

                        planAExcelPageModel = (ExtraPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                ExtraPageModel.class);
                        String textArea = planAExcelPageModel.getTextArea();
                        textArea = textArea.replaceAll("\\r\\n", "");
                        // mLog.info("text planAExcelPageModel [" + textArea + "]");
                        // planAExcelPageModel.setTextArea(textArea);
                        // model.addAttribute("PlanAExcelPageModel", planAExcelPageModel);

                        publish.setPlanAExcelPage(true);
                        mLog.info("found page planAExcelPageModel");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case PlanAProposedPage:
                    try {
                        PlanProposedPageModel planAProposedPageModel = null;

                        planAProposedPageModel = (PlanProposedPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                PlanProposedPageModel.class);
                        // model.addAttribute("PlanAProposedPageModel", planAProposedPageModel);

                        publish.setPlanAProposedPage(true);
                        slidesData.getPublish().setPlanAProposedPage(true);
                        slidesData.getPageModels().setPlanAProposedPageModel(planAProposedPageModel);

                        mLog.info("found page planAProposedPage");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case PlanBProposedPage:
                    try {
                        PlanProposedPageModel planBProposedPageModel = null;

                        planBProposedPageModel = (PlanProposedPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                PlanProposedPageModel.class);
                        // model.addAttribute("PlanBProposedPageModel", planBProposedPageModel);
                        slidesData.getPublish().setPlanAProposedPage(true);
                        slidesData.getPageModels().setPlanBProposedPageModel(planBProposedPageModel);

                        // publish.setPlanBProposedPage(true);
                        mLog.info("found page planBProposedPage");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case PlanALifetimeValuedPage:
                    try {
                        PlanALifetimeValuedPageModel planALifetimeValuedPageModel = null;

                        planALifetimeValuedPageModel = (PlanALifetimeValuedPageModel) JSONManager
                                .convertFromJson(data.getPagedata(), PlanALifetimeValuedPageModel.class);
                        // model.addAttribute("PlanALifetimeValuedPageModel",
                        // planALifetimeValuedPageModel);

                        slidesData.getPageModels().setPlanALifetimeValuedPageModel(planALifetimeValuedPageModel);

                        mLog.info("found page PlanALifetimeValuedPage");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }

//PlanBDigitalROICalculatorPage
                //
                case PlanBLifetimeValuedPage:
                    try {
                        PlanBLifetimeValuedPageModel planBLifetimeValuedPageModel = null;

                        planBLifetimeValuedPageModel = (PlanBLifetimeValuedPageModel) JSONManager
                                .convertFromJson(data.getPagedata(), PlanBLifetimeValuedPageModel.class);
                        // model.addAttribute("PlanBLifetimeValuedPageModel",
                        // planBLifetimeValuedPageModel);
                        slidesData.getPageModels().setPlanBLifetimeValuedPageModel(planBLifetimeValuedPageModel);

                        mLog.info("found page PlanBLifetimeValuedPage");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                //
                case PlanBExcelPage:
                    try {
                        ExtraPageModel planBExcelPagePageModel = null;

                        planBExcelPagePageModel = (ExtraPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                ExtraPageModel.class);
                        // model.addAttribute("PlanBExcelPageModel", planBExcelPagePageModel);

                        mLog.info("found page PlanAExcelPage");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case PlanBBEPPage:
                    try {
                        PlanBBEPPageModel planBBEPPageModel = null;

                        planBBEPPageModel = (PlanBBEPPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                PlanBBEPPageModel.class);
                        // model.addAttribute("PlanBBEPPageModel", planBBEPPageModel);
                        // slidesData.getPublish().setPlanBBEPPageModel(true);
                        slidesData.getPageModels().setPlanBBEPPageModel(planBBEPPageModel);
                        
                        mLog.info("found page PlanBBEPPage");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case PlanBDigitalROICalculatorPage:
                    try {
                        PlanDigitalROICalculatorPageModel planBDigitalROICalculatorPageModel = null;

                        planBDigitalROICalculatorPageModel = (PlanDigitalROICalculatorPageModel) JSONManager
                                .convertFromJson(data.getPagedata(), PlanDigitalROICalculatorPageModel.class);
                        // model.addAttribute("PlanBDigitalROICalculatorPage",
                        // planBDigitalROICalculatorPageModel);

                        slidesData.getPublish().setPlanBDigitalROICalculatorPage(true);

                        slidesData.getPageModels()
                                .setPlanBDigitalROICalculatorPageModel(planBDigitalROICalculatorPageModel);

                        publish.setPlanBDigitalROICalculatorPage(true);
                        mLog.info("found page PlanBDigitalROICalculatorPage");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case PlanAMediaPage:
                    mLog.info("found page PlanAMediaPage");
                    try {
                        PlanMediaPageModel planAMediaPagedataPageModel = null;
                        planAMediaPagedataPageModel = (PlanMediaPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                PlanMediaPageModel.class);
                        MediaChart mediaChartA = MediaChartHelper.generate(planAMediaPagedataPageModel);
                        // model.addAttribute("PlanAMediaPage", mediaChartA);
                        // model.addAttribute("PlanAMediaPagedataPageModel",
                        // planAMediaPagedataPageModel);
                        if (mediaChartA != null) {

                            publish.setPlanAMediaPage(true);

                            slidesData.getPublish().setPlanAMediaPage(true);
                            slidesData.getPageModels().setPlanAMediaPagedataPageModel(planAMediaPagedataPageModel);

                            mLog.info("found page SeventeenPlanAMediaSlide");

                        }
                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }

                // PlanAProposedPage
                case PlanBMediaPage:
                    mLog.info("found page PlanBMediaPage");
                    try {
                        PlanMediaPageModel planBMediaPagedataPageModel = null;
                        planBMediaPagedataPageModel = (PlanMediaPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                PlanMediaPageModel.class);
                        MediaChart mediaChart = MediaChartHelper.generate(planBMediaPagedataPageModel);
                        // model.addAttribute("PlanBMediaPagedataPageModel",
                        // planBMediaPagedataPageModel);
                        // model.addAttribute("PlanBMediaPage", mediaChart);
                        if (mediaChart != null) {

                            publish.setPlanBMediaPage(true);
                            slidesData.getPageModels().setPlanBMediaPagedataPageModel(planBMediaPagedataPageModel);
                            slidesData.getPublish().setPlanBMediaPage(true);

                            mLog.info("found page TwentyThreePlanBMediaSlide");
                            mLog.info("found page TwentyThreePlanBMediaSlide");

                        }
                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case PresentedToPage:
                    try {
                        PresentedToPageModel presentedToPageModel = null;

                        presentedToPageModel = (PresentedToPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                PresentedToPageModel.class);
                        // model.addAttribute("PresentedToPage", presentedToPageModel);
                        slidesData.getPublish().setPresentedToPage(true);
                        slidesData.getPageModels().setPresentedToPageModel(presentedToPageModel);
                        // if (!presentedToPageModel.getClientBusinessName().isEmpty() &&
                        // !presentedToPageModel.getClientContactName().isEmpty()) {

                        mLog.info("found page PresentedToPage");
                        // }

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }

                case ProfileOfConsumersPage:
                    try {
                        ExtraPageModel profileOfConsumersPageModel = null;

                        profileOfConsumersPageModel = (ExtraPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                ExtraPageModel.class);
                        // model.addAttribute("ProfileOfConsumersPageModel",
                        // profileOfConsumersPageModel);

                        publish.setProfileOfConsumersPage(true);

                        mLog.info("found page profileOfConsumersPageModel");
                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }

                case StrategicMarketingPageOne:
                    try {

                        strategicMarketingPageOneModel = (StrategicMarketingPageOneModel) JSONManager
                                .convertFromJson(data.getPagedata(), StrategicMarketingPageOneModel.class);
                        // model.addAttribute("StrategicMarketingPageOne",
                        // strategicMarketingPageOneModel);

                        publish.setStrategicMarketingPageOne(true);
                        slidesData.getPageModels().setStrategicMarketingPageOneModel(strategicMarketingPageOneModel);
                        // FiveStrategicMarketingPageSlide

                        mLog.info("value found page StrategicMarketingPageOne "
                                + strategicMarketingPageOneModel.getYearsInBusiness());
                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case StrategicMarketingPageThree:
                    try {
                        StrategicMarketingPageThreeModel strategicMarketingPageThreeModel = null;

                        strategicMarketingPageThreeModel = (StrategicMarketingPageThreeModel) JSONManager
                                .convertFromJson(data.getPagedata(), StrategicMarketingPageThreeModel.class);
                        // model.addAttribute("StrategicMarketingPageThree",
                        // strategicMarketingPageThreeModel);

                        StrategicMarketingHelper strategicMarketingHelper = new StrategicMarketingHelper(
                                strategicMarketingPageThreeModel);
                        // model.addAttribute("StrategicMarketingHelper", strategicMarketingHelper);
                        slidesData.getPageModels().setStrategicMarketingPageThreeModel(strategicMarketingPageThreeModel);
                        slidesData.getPageModels().setStrategicMarketingHelper(strategicMarketingHelper);

                        publish.setStrategicMarketingPageThree(true);
                        mLog.info("found page StrategicMarketingPageThree");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case StrategicMarketingPageTwo:
                    mLog.info("start StrategicMarketingPageTwo");

                    try {
                        StrategicMarketingPageTwoModel strategicMarketingPageTwoModel = null;

                        strategicMarketingPageTwoModel = (StrategicMarketingPageTwoModel) JSONManager
                                .convertFromJson(data.getPagedata(), StrategicMarketingPageTwoModel.class);
                        // model.addAttribute("StrategicMarketingPageTwo",
                        // strategicMarketingPageTwoModel);

                        publish.setStrategicMarketingPageTwo(true);
                        mLog.info("found page StrategicMarketingPageTwo");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                case TargetMarketingPage:
                    try {
                        TargetMarketingPageModel targetMarketingPageModel = null;

                        targetMarketingPageModel = (TargetMarketingPageModel) JSONManager
                                .convertFromJson(data.getPagedata(), TargetMarketingPageModel.class);
                        // model.addAttribute("targetMarketingPageModel", targetMarketingPageModel);
                        TargetMarketingHeaderRow targetMarketingHeaderRow = new TargetMarketingHeaderRow(
                                targetMarketingPageModel);

                        // model.addAttribute("targetMarketingHeaderRow", targetMarketingHeaderRow);
                        publish.setTargetMarketingPage(true);

                        slidesData.getPublish().setTargetMarketingPage(true);
                        slidesData.getPageModels().setTargetMarketingPageModel(targetMarketingPageModel);
                        slidesData.getPageModels().setTargetMarketingHeaderRow(targetMarketingHeaderRow);

                        mLog.info("found page targetMarketingPageModel");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }

                case TeamCommitmentPage:
                    try {
                        TeamCommitmentPageModel teamCommitmentPageModel = null;

                        teamCommitmentPageModel = (TeamCommitmentPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                TeamCommitmentPageModel.class);
                        // model.addAttribute("TeamCommitmentPage", teamCommitmentPageModel);

                        slidesData.getPublish().setTeamCommitmentPage(true);
                        slidesData.getPageModels().setTeamCommitmentPageModel(teamCommitmentPageModel);

                        mLog.info("found page TeamCommitmentPage");

                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
            }//END OF SWITCH
            

            // model.addAttribute("PublishModel", publish);
        }//end of switch
        
        FourClientObjectiveSlide fourClientObjectiveSlide
                    = new FourClientObjectiveSlide(slidesData, SlidePageNameEnum.FourClientObjectiveSlide, "FourClientObjectiveSlide", contact);
            slidesList.add(fourClientObjectiveSlide);

            FourClientObjectiveSlide slideConsumer = new FourClientObjectiveSlide(
                    "StrategicMarketing_Data_CONSUMER!B1:E", "StrategicMarketing_Data_CONSUMER",
                    SlidePageNameEnum.FourClientObjectiveSlide, slidesData);
            slidesList.add(slideConsumer);
            FourClientObjectiveSlide slidePromotion = new FourClientObjectiveSlide(
                    "StrategicMarketing_Data_Promotion!B1:E", "StrategicMarketing_Data_Promotion",
                    SlidePageNameEnum.FourClientObjectiveSlide, slidesData);
            slidesList.add(slidePromotion);
            FourClientObjectiveSlide slideBrand = new FourClientObjectiveSlide(
                    "StrategicMarketing_Data_Brand!A1:B", "StrategicMarketing_Data_Brand",
                    SlidePageNameEnum.FourClientObjectiveSlide, slidesData);
            slidesList.add(slideBrand);

            FourClientObjectiveSlide slideTop = new FourClientObjectiveSlide("Strategic_Marketing_top!A1:E",
                    "Strategic_Marketing_top", SlidePageNameEnum.FourClientObjectiveSlide, slidesData);
            slidesList.add(slideTop);
            EightConfidentialClientEvaluationOneSlide slideEightConfidentialClientEvaluationOneSlide = new EightConfidentialClientEvaluationOneSlide(
                    slidesData, SlidePageNameEnum.EightConfidentialClientEvaluationOneTextSlide, "ConfidentialClientEvaluationOnePage_Data!A1:B", contact);

            slidesList.add(slideEightConfidentialClientEvaluationOneSlide);

            SevenConfidentialClientEvaluationTextSlide sevenConfidentialClientEvaluationTextSlide = new SevenConfidentialClientEvaluationTextSlide(
                    slidesData, SlidePageNameEnum.SevenConfidentialClientEvaluationTextSlide, "sevenConfidentialClientEvaluationOnePage", contact);
            slidesList.add(sevenConfidentialClientEvaluationTextSlide);

            EightConfidentialClientEvaluationOneTextSlide eightConfidentialClientEvaluationOneTextSlide = new EightConfidentialClientEvaluationOneTextSlide(
                    slidesData, SlidePageNameEnum.EightConfidentialClientEvaluationOneTextSlide,
                    "EightConfidentialClientEvaluationOneTextSlide",contact);
            slidesList.add(eightConfidentialClientEvaluationOneTextSlide);
            NineConfidentialClientEvaluationProposedSlide nineConfidentialClientEvaluationProposedSlide = new NineConfidentialClientEvaluationProposedSlide(
                    slidesData,
                    SlidePageNameEnum.NineConfidentialClientEvaluationProposedSlide, "ConfidentialClientEvaluationProposedPage_Data!A1:B", contact);

            slidesList.add(nineConfidentialClientEvaluationProposedSlide);

            NineConfidentialClientEvaluationProposedTextSlide nineConfidentialClientEvaluation = new NineConfidentialClientEvaluationProposedTextSlide(
                    slidesData, SlidePageNameEnum.NineConfidentialClientEvaluationProposedSlide,
                    "NineConfidentialClientEvaluationProposedTextSlide", contact);
            slidesList.add(nineConfidentialClientEvaluation);
            ThreeMarketPlaceCompetitionSlide slide = new ThreeMarketPlaceCompetitionSlide(slidesData,
                    SlidePageNameEnum.ThreeMarketPlaceCompetitionSlide, "ThreeMarketPlaceCompetitionSlide", contact);
            slidesList.add(slide);
            TwentyPlanABEPTextSlide twentyPlanABEPTextSlide = new TwentyPlanABEPTextSlide(slidesData,
                    SlidePageNameEnum.TwentyPlanABEPTextSlide, "TwentyPlanABEPTextSlide");
            slidesList.add(twentyPlanABEPTextSlide);
            TwentyTwoPlanADigitalROICalculatorTextSlide textSlide = new TwentyTwoPlanADigitalROICalculatorTextSlide(
                    slidesData, SlidePageNameEnum.TwentyTwoPlanADigitalROICalculatorTextSlide, "TwentyTwoPlanADigitalROICalculatorTextSlide");
            slidesList.add(textSlide);
            NineteenPlanAProposedTextSlide nineteenPlanAProposedTextSlide = new NineteenPlanAProposedTextSlide(
                    slidesData, SlidePageNameEnum.NineConfidentialClientEvaluationProposedSlide, "NineteenPlanAProposedTextSlide", contact);
            slidesList.add(nineteenPlanAProposedTextSlide);
            TwentyFivePlanBProposedTextSlide twentyFivePlanAProposedTextSlide = new TwentyFivePlanBProposedTextSlide(
                    slidesData, SlidePageNameEnum.TwentyFivePlanBProposedTextSlide, "TwentyFivePlanBProposedTextSlide");
            slidesList.add(twentyFivePlanAProposedTextSlide);
            TwentyOnePlanALifetimeValuedTextSlide textSlidea = new TwentyOnePlanALifetimeValuedTextSlide(
                    slidesData, SlidePageNameEnum.TwentyOnePlanALifetimeValuedTextSlide, "TwentyOnePlanALifetimeValuedTextSlide");
            slidesList.add(textSlidea);
            TwentySevenPlanBLifetimeValuedTextSlide textSlidec = new TwentySevenPlanBLifetimeValuedTextSlide(
                    slidesData, SlidePageNameEnum.TwentySevenPlanBLifetimeValuedTextSlide, "TwentySevenPlanBLifetimeValuedTextSlide");
            slidesList.add(textSlidec);

            TwoTeamCommitmentSlide slidetwoTeam = new TwoTeamCommitmentSlide(slidesData,
                    SlidePageNameEnum.TwoTeamCommitmentSlide, "TwoTeamCommitmentSlide");
            slidesList.add(slidetwoTeam);
            SixTargetMarketingSlide slideSixTargetMarketing = new SixTargetMarketingSlide(slidesData,
                    SlidePageNameEnum.SixTargetMarketingSlide, "SixTargetMarketingSlide", contact);
            slidesList.add(slideSixTargetMarketing);
            FiveStrategicMarketingPageSlide fiveStrategicMarketingPageSlide = new FiveStrategicMarketingPageSlide(
                    slidesData, SlidePageNameEnum.FiveStrategicMarketingPageSlide, "FiveStrategicMarketingPageSlide", contact);
            slidesList.add(fiveStrategicMarketingPageSlide);
            FourClientObjectiveTextSlide fourClientObjectiveTextSlide = new FourClientObjectiveTextSlide(
                    slidesData, SlidePageNameEnum.FourClientObjectiveSlide, "FourClientObjectiveTextSlide", contact);
            slidesList.add(fourClientObjectiveTextSlide);
            OnePresentedToSlide presentedToSlide = new OnePresentedToSlide(slidesData,
                    SlidePageNameEnum.OnePresentedToSlide, "OnePresentedToSlide", contact);
            slidesList.add(presentedToSlide);
            TwentyThreePlanBMediaSlide twentyThreePlanBMediaSlide = new TwentyThreePlanBMediaSlide(
                    slidesData, SlidePageNameEnum.TwentyThreePlanBMediaSlide, "PlanBMediaPage");
            slidesList.add(twentyThreePlanBMediaSlide);
            ThirtyPlanBSpreadSheetSlide thirtyPlanBSpreadSheetSlide = new ThirtyPlanBSpreadSheetSlide(
                    "PlanBSpreadSheet!A1:P", "PlanBSpreadSheet", SlidePageNameEnum.ThirtyPlanBSpreadSheetTextSlide, slidesData, contact);

            ThirtyPlanBSpreadSheetTextSlide thirtyPlanBSpreadSheetTextSlide = new ThirtyPlanBSpreadSheetTextSlide(
                    slidesData, SlidePageNameEnum.ThirtyPlanBSpreadSheetTextSlide, "ThirtyPlanBSpreadSheetTextSlide",contact);

            slidesList.add(thirtyPlanBSpreadSheetTextSlide);
            slidesList.add(thirtyPlanBSpreadSheetSlide);
            SeventeenPlanAMediaSlide seventeenPlanAMediaSlide = new SeventeenPlanAMediaSlide(slidesData,
                    SlidePageNameEnum.SeventeenPlanAMediaSlide, "", contact);
            slidesList.add(seventeenPlanAMediaSlide);
            TwentyNinePlanASpreadSheetSlide twentyNinePlanASpreadSheetSlide = new TwentyNinePlanASpreadSheetSlide(
                    "PlanASpreadSheet!A1:P", "PlanASpreadSheet", SlidePageNameEnum.TwentyNinePlanASpreadSheetTextSlide, slidesData);
            TwentyNinePlanASpreadSheetTextSlide twentyNinePlanASpreadSheetTextSlide = new TwentyNinePlanASpreadSheetTextSlide(
                    slidesData, SlidePageNameEnum.TwentyNinePlanASpreadSheetSlide, "TwentyNinePlanASpreadSheetTextSlide");

            slidesList.add(twentyNinePlanASpreadSheetTextSlide);

            slidesList.add(twentyNinePlanASpreadSheetSlide);

            TwentyEightPlanBDigitalROICalculatorTextSlide textSlideTwentyEightPlanBDigitalROICalculatorText = new TwentyEightPlanBDigitalROICalculatorTextSlide(
                    slidesData, SlidePageNameEnum.TwentyEightPlanBDigitalROICalculatorTextSlide,
                    "TwentyEightPlanBDigitalROICalculatorTextSlide", contact);
            slidesList.add(textSlideTwentyEightPlanBDigitalROICalculatorText);
            TwentySixPlanBBEPTextSlide twentySixPlanBBEPTextSlide = new TwentySixPlanBBEPTextSlide(slidesData,
                                SlidePageNameEnum.TwentySixPlanBBEPTextSlide, "TwentySixPlanBBEPTextSlide");
                        slidesList.add(twentySixPlanBBEPTextSlide);
                        slidesData.getPublish().setPlanBBEPPage(true);

        // BatchUpdatePresentationRequest update = new BatchUpdatePresentationRequest();
        // update.setRequests(mRequests);
        // googleSlides.presentations().batchUpdate(prez.getPresentationId(),
        // update).execute();
        mLog.warn("leaving getSlidesData");
        return slidesList;
    }

}
