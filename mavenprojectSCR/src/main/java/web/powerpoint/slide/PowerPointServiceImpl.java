/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide;

import java.io.FileInputStream;
import java.io.IOException;
import web.powerpoint.slide.pages.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import web.google.slide.GoogleHelper;
import web.google.slide.PageModels;
import web.google.slide.SlideEnum;
import web.google.slide.SlidesData;
import web.model.Wizard;

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

import web.repository.WizardDataRepository;
import web.repository.WizardRepository;

/**
 *
 * @author andrewhinton
 *
 *
 * import java.util.Arrays; import java.util.List; import
 * java.util.stream.Collectors;
 *
 * public class ListFilterExample { public static void main(String[] args) {
 * List<Product> allProducts = Arrays.asList( new Product("Laptop", 1200.0), new
 * Product("Mouse", 25.0), new Product("Keyboard", 75.0), new Product("Monitor",
 * 300.0) );
 *
 * // Filter products with price > 100 List<Product> expensiveProducts =
 * allProducts.stream() .filter(product -> product.getPrice() > 100.0)
 * .collect(Collectors.toList());
 *
 * System.out.println("Expensive Products:"); expensiveProducts.forEach(product
 * -> System.out.println(product.getName())); } }
 *
 */
@Service
public class PowerPointServiceImpl implements PowerPointService {
    
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private WizardRepository wizardRepository;
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private WizardDataRepository wizardDataRepository;
    private static final Logger mLog = LoggerFactory.getLogger(PowerPointServiceImpl.class.getName());
    @Value("classpath:powerpointtemplate/tv.pptx")
    Resource resourceFileTV;
    
    @Override
    public String buildPowerPointDocument(int id) {
        //wizardRepository.
        Optional<Wizard> wizardOpt = wizardRepository.findById(id);
	Wizard wizard = wizardOpt.orElse(null);
        Iterable<WizardData> dataPages = wizardDataRepository.findByWizardid(Integer.valueOf(id));
        List<String> excludedPagesList = GoogleHelper.getSlidesExcluded(dataPages);
        List<SlideInterface> slidesModels = getSlidesData(dataPages);
        
        try {
           // wizard.
            FileInputStream fis = (FileInputStream) resourceFileTV.getInputStream();
            XMLSlideShow ppt = new XMLSlideShow(fis);
            fis.close();
            for (XSLFSlide slide : ppt.getSlides()) {
                String slideName = slide.getSlideName();
                // Filter products with price > 100
                List<SlideInterface> model = slidesModels.stream()
                        .filter(slideInterface -> slideInterface.getSlideEnum().name() == slideName)
                        .collect(Collectors.toList());
                model.get(0).populateSlide(slide);
                
            }
            
        } catch (IOException ex) {
            mLog.equals(ex);
        }
        
        return "";
    }
    
    public static List<SlideInterface> getSlidesData(Iterable<WizardData> dataPages) {
        mLog.warn("entering getSlidesData");
        List<SlideInterface> slidesList = new ArrayList<SlideInterface>();
        SlidesData slidesData = new SlidesData();
        
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

            // exculded
            if (data.isExcluded()) {
                mLog.info("PAGE Excluded name = " + pageName);
                continue;
            }
            switch (pageName) {

                // ConfidentialClientEvaluationOnePage
                case ClientObjectivesOnePage:
                    try {
                        
                        ClientObjectivesOnePageModel clientObjectivesOnePageModel = null;
                        clientObjectivesOnePageModel = (ClientObjectivesOnePageModel) JSONManager
                                .convertFromJson(data.getPagedata(), ClientObjectivesOnePageModel.class);
                        List<ClientObjectivesOnePageTwoModel> orderList = ClientObjectivesPageHelper.getList(true,
                                clientObjectivesOnePageModel);
                        
                        List<Object> pageData = new ArrayList<Object>();
                        pageData.add(clientObjectivesOnePageModel);
                        pageData.add(orderList);
                        
                        slidesData.getPageModels().setOrderList(orderList);
                        slidesData.getPageModels().setClientObjectivesOnePageModel(clientObjectivesOnePageModel);
                        FourClientObjectiveSlide slideProductService = new FourClientObjectiveSlide(
                                "StrategicMarketing_Data_CONSUMER!B1:E", "StrategicMarketing_Data_CONSUMER", SlideEnum.ClientObjectivePRODUCTSERVICE, slidesData);
                        slidesList.add(slideProductService);
                        FourClientObjectiveSlide slideConsumer = new FourClientObjectiveSlide(
                                "StrategicMarketing_Data_CONSUMER!B1:E", "StrategicMarketing_Data_CONSUMER",
                                SlideEnum.ClientObjectiveCONSUMER, slidesData);
                        slidesList.add(slideConsumer);
                        FourClientObjectiveSlide slidePromotion = new FourClientObjectiveSlide(
                                "StrategicMarketing_Data_Promotion!B1:E", "StrategicMarketing_Data_Promotion",
                                SlideEnum.ClientObjectivePROMOTION, slidesData);
                        slidesList.add(slidePromotion);
                        FourClientObjectiveSlide slideBrand = new FourClientObjectiveSlide(
                                "StrategicMarketing_Data_Brand!A1:B", "StrategicMarketing_Data_Brand",
                                SlideEnum.ClientObjectiveBRAND, slidesData);
                        slidesList.add(slideBrand);
                        
                        FourClientObjectiveSlide slideTop = new FourClientObjectiveSlide("Strategic_Marketing_top!A1:E",
                                "Strategic_Marketing_top", SlideEnum.ClientObjectiveTop, slidesData);
                        slidesList.add(slideTop);
                        
                        mLog.info("found page ClientObjectivesOnePageTwoModel");
                        
                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                
                case ConfidentialClientEvaluationOnePage:
                    try {
                        ConfidentialClientEvaluationOnePageModel confidentialClientEvaluationOnePageModel = null;
                        
                        confidentialClientEvaluationOnePageModel = (ConfidentialClientEvaluationOnePageModel) JSONManager
                                .convertFromJson(data.getPagedata(), ConfidentialClientEvaluationOnePageModel.class);
                        List<PieChart> pieChart = ChartBuilder
                                .buildLastYearConfidentialClientEvaluation(confidentialClientEvaluationOnePageModel);
                        // slide 8
                        slidesData.getPageModels().setPieChartConfidentialClientEvaluationOnePage(pieChart);
                        
                        slidesData.getPageModels()
                                .setConfidentialClientEvaluationOnePageModel(confidentialClientEvaluationOnePageModel);
                        slidesData.getPublish().setConfidentialClientEvaluationOnePage(true);
                        EightConfidentialClientEvaluationOneSlide slideEightConfidentialClientEvaluationOneSlide = new EightConfidentialClientEvaluationOneSlide(
                                slidesData, SlideEnum.PieChart, "ConfidentialClientEvaluationOnePage_Data!A1:B");
                        
                        slidesList.add(slideEightConfidentialClientEvaluationOneSlide);
                        
                        SevenConfidentialClientEvaluationTextSlide sevenConfidentialClientEvaluationTextSlide = new SevenConfidentialClientEvaluationTextSlide(
                                slidesData, SlideEnum.TextSlideReplacement, "sevenConfidentialClientEvaluationOnePage");
                        slidesList.add(sevenConfidentialClientEvaluationTextSlide);
                        
                        EightConfidentialClientEvaluationOneTextSlide eightConfidentialClientEvaluationOneTextSlide = new EightConfidentialClientEvaluationOneTextSlide(
                                slidesData, SlideEnum.TextSlideReplacement,
                                "EightConfidentialClientEvaluationOneTextSlide");
                        slidesList.add(eightConfidentialClientEvaluationOneTextSlide);

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
                        NineConfidentialClientEvaluationProposedSlide nineConfidentialClientEvaluationProposedSlide = new NineConfidentialClientEvaluationProposedSlide(
                                slidesData,
                                SlideEnum.PieChart, "ConfidentialClientEvaluationProposedPage_Data!A1:B");
                        
                        slidesList.add(nineConfidentialClientEvaluationProposedSlide);
                        
                        NineConfidentialClientEvaluationProposedTextSlide nineConfidentialClientEvaluation = new NineConfidentialClientEvaluationProposedTextSlide(
                                slidesData, SlideEnum.TextSlideReplacement,
                                "NineConfidentialClientEvaluationProposedTextSlide");
                        slidesList.add(nineConfidentialClientEvaluation);

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
                        MarketPlaceCompetitionPageModel marketPlaceCompetitionPageModel = null;
                        
                        marketPlaceCompetitionPageModel = (MarketPlaceCompetitionPageModel) JSONManager
                                .convertFromJson(data.getPagedata(), MarketPlaceCompetitionPageModel.class);
                        // model.addAttribute("MarketPlaceCompetitionPageModel",
                        // marketPlaceCompetitionPageModel);
                        slidesData.getPageModels().setMarketPlaceCompetitionPageModel(marketPlaceCompetitionPageModel);
                        ThreeMarketPlaceCompetitionSlide slide = new ThreeMarketPlaceCompetitionSlide(slidesData,
                                SlideEnum.TextSlideReplacement, "ThreeMarketPlaceCompetitionSlide");
                        slidesList.add(slide);
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
                        PlanABEPPageModel planABEPPageModel = null;
                        
                        planABEPPageModel = (PlanABEPPageModel) JSONManager.convertFromJson(data.getPagedata(),
                                PlanABEPPageModel.class);
                        // model.addAttribute("PlanABEPPageModel", planABEPPageModel);
                        slidesData.getPublish().setPlanABEPPage(true);
                        slidesData.getPageModels().setPlanABEPPageModel(planABEPPageModel);
                        TwentyPlanABEPTextSlide twentyPlanABEPTextSlide = new TwentyPlanABEPTextSlide(slidesData,
                                SlideEnum.TextSlideReplacement, "TwentyPlanABEPTextSlide");
                        slidesList.add(twentyPlanABEPTextSlide);

                        // TwentyPlanABEPTextSlide
                        mLog.info("found page PlanABEPPage");
                        
                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
                
                case PlanADigitalROICalculatorPage:
                    try {
                        PlanDigitalROICalculatorPageModel planADigitalROICalculatorPageModel = null;
                        
                        planADigitalROICalculatorPageModel = (PlanDigitalROICalculatorPageModel) JSONManager
                                .convertFromJson(data.getPagedata(), PlanDigitalROICalculatorPageModel.class);
                        // model.addAttribute("PlanADigitalROICalculatorPage",
                        // planADigitalROICalculatorPageModel);

                        slidesData.getPublish().setPlanADigitalROICalculatorPage(true);
                        
                        slidesData.getPageModels()
                                .setPlanADigitalROICalculatorPageModel(planADigitalROICalculatorPageModel);
                        TwentyTwoPlanADigitalROICalculatorTextSlide textSlide = new TwentyTwoPlanADigitalROICalculatorTextSlide(
                                slidesData, SlideEnum.TextSlideReplacement, "TwentyTwoPlanADigitalROICalculatorTextSlide");
                        slidesList.add(textSlide);
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
                        NineteenPlanAProposedTextSlide nineteenPlanAProposedTextSlide = new NineteenPlanAProposedTextSlide(
                                slidesData, SlideEnum.TextSlideReplacement, "NineteenPlanAProposedTextSlide");
                        slidesList.add(nineteenPlanAProposedTextSlide);
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
                        TwentyFivePlanBProposedTextSlide twentyFivePlanAProposedTextSlide = new TwentyFivePlanBProposedTextSlide(
                                slidesData, SlideEnum.TextSlideReplacement, "TwentyFivePlanBProposedTextSlide");
                        slidesList.add(twentyFivePlanAProposedTextSlide);
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
                        TwentyOnePlanALifetimeValuedTextSlide textSlide = new TwentyOnePlanALifetimeValuedTextSlide(
                                slidesData, SlideEnum.TextSlideReplacement, "TwentyOnePlanALifetimeValuedTextSlide");
                        slidesList.add(textSlide);
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
                        TwentySevenPlanBLifetimeValuedTextSlide textSlide = new TwentySevenPlanBLifetimeValuedTextSlide(
                                slidesData, SlideEnum.TextSlideReplacement, "TwentySevenPlanBLifetimeValuedTextSlide");
                        slidesList.add(textSlide);
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
                        TwentySixPlanBBEPTextSlide twentySixPlanBBEPTextSlide = new TwentySixPlanBBEPTextSlide(slidesData,
                                SlideEnum.TextSlideReplacement, "TwentySixPlanBBEPTextSlide");
                        slidesList.add(twentySixPlanBBEPTextSlide);
                        slidesData.getPublish().setPlanBBEPPage(true);
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
                        TwentyEightPlanBDigitalROICalculatorTextSlide textSlide = new TwentyEightPlanBDigitalROICalculatorTextSlide(
                                slidesData, SlideEnum.TextSlideReplacement,
                                "TwentyEightPlanBDigitalROICalculatorTextSlide");
                        slidesList.add(textSlide);
                        
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
                            SeventeenPlanAMediaSlide seventeenPlanAMediaSlide = new SeventeenPlanAMediaSlide(slidesData,
                                    SlideEnum.BarChart, "");
                            slidesList.add(seventeenPlanAMediaSlide);
                            TwentyNinePlanASpreadSheetSlide twentyNinePlanASpreadSheetSlide = new TwentyNinePlanASpreadSheetSlide(
                                    "PlanASpreadSheet!A1:P", "PlanASpreadSheet", SlideEnum.PlanASpreadSheet, slidesData);
                            TwentyNinePlanASpreadSheetTextSlide twentyNinePlanASpreadSheetTextSlide = new TwentyNinePlanASpreadSheetTextSlide(
                                    slidesData, SlideEnum.TextSlideReplacement, "TwentyNinePlanASpreadSheetTextSlide");
                            
                            slidesList.add(twentyNinePlanASpreadSheetTextSlide);
                            
                            slidesList.add(twentyNinePlanASpreadSheetSlide);
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
                            TwentyThreePlanBMediaSlide twentyThreePlanBMediaSlide = new TwentyThreePlanBMediaSlide(
                                    slidesData, SlideEnum.BarChart, "PlanBMediaPage");
                            slidesList.add(twentyThreePlanBMediaSlide);
                            ThirtyPlanBSpreadSheetSlide thirtyPlanBSpreadSheetSlide = new ThirtyPlanBSpreadSheetSlide(
                                    "PlanBSpreadSheet!A1:P", "PlanBSpreadSheet", SlideEnum.PlanBSpreadSheet, slidesData);
                            
                            ThirtyPlanBSpreadSheetTextSlide thirtyPlanBSpreadSheetTextSlide = new ThirtyPlanBSpreadSheetTextSlide(
                                    slidesData, SlideEnum.TextSlideReplacement, "ThirtyPlanBSpreadSheetTextSlide");
                            
                            slidesList.add(thirtyPlanBSpreadSheetTextSlide);
                            slidesList.add(thirtyPlanBSpreadSheetSlide);
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
                        OnePresentedToSlide presentedToSlide = new OnePresentedToSlide(slidesData,
                                SlideEnum.TextSlideReplacement, "OnePresentedToSlide");
                        slidesList.add(presentedToSlide);
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
                        StrategicMarketingPageOneModel strategicMarketingPageOneModel = null;
                        
                        strategicMarketingPageOneModel = (StrategicMarketingPageOneModel) JSONManager
                                .convertFromJson(data.getPagedata(), StrategicMarketingPageOneModel.class);
                        // model.addAttribute("StrategicMarketingPageOne",
                        // strategicMarketingPageOneModel);

                        publish.setStrategicMarketingPageOne(true);
                        slidesData.getPageModels().setStrategicMarketingPageOneModel(strategicMarketingPageOneModel);
                        // FiveStrategicMarketingPageSlide
                        FourClientObjectiveTextSlide fourClientObjectiveTextSlide = new FourClientObjectiveTextSlide(
                                slidesData, SlideEnum.TextSlideReplacement, "FourClientObjectiveTextSlide");
                        slidesList.add(fourClientObjectiveTextSlide);
                        
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
                        FiveStrategicMarketingPageSlide fiveStrategicMarketingPageSlide = new FiveStrategicMarketingPageSlide(
                                slidesData, SlideEnum.TextSlideReplacement, "FiveStrategicMarketingPageSlide");
                        slidesList.add(fiveStrategicMarketingPageSlide);
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
                        SixTargetMarketingSlide slide = new SixTargetMarketingSlide(slidesData,
                                SlideEnum.TextSlideReplacement, "SixTargetMarketingSlide");
                        slidesList.add(slide);
                        
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
                        TwoTeamCommitmentSlide slide = new TwoTeamCommitmentSlide(slidesData,
                                SlideEnum.TextSlideReplacement, "TwoTeamCommitmentSlide");
                        slidesList.add(slide);
                        mLog.info("found page TeamCommitmentPage");
                        
                        break;
                    } catch (Exception ex) {
                        mLog.error("error " + ex.getMessage());
                        break;
                    }
            }
            // model.addAttribute("PublishModel", publish);

        }
        // BatchUpdatePresentationRequest update = new BatchUpdatePresentationRequest();
        // update.setRequests(mRequests);
        // googleSlides.presentations().batchUpdate(prez.getPresentationId(),
        // update).execute();
        mLog.warn("leaving getSlidesData");
        return slidesList;
    }
    
}
