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
import org.apache.poi.xslf.usermodel.XSLFComment;
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

    private String getSlidePageName(XSLFSlide slide) {
        String pageName = null;
        List<XSLFComment> comments = slide.getComments();
        for (XSLFComment comment : comments) {
            pageName = comment.getText();
            mLog.info("Slide page name " + pageName);
            break;

        }
        return pageName;
    }

    @Override
    public String buildPowerPointDocument(int id) {
        //wizardRepository.
        //Optional<Wizard> wizardOpt = wizardRepository.findById(id);
        //Wizard wizard = wizardOpt.orElse(null);
        Iterable<WizardData> dataPages = wizardDataRepository.findByWizardid(Integer.valueOf(id));
        List<String> excludedPagesList = GoogleHelper.getSlidesExcluded(dataPages);
        List<SlideInterface> slidesModels = SlideDataHelper.getSlidesData(dataPages);

        try {
            // wizard.
            FileInputStream fis = readTemplate();
            XMLSlideShow ppt = new XMLSlideShow(fis);
            fis.close();
            for (XSLFSlide slide : ppt.getSlides()) {
                String slideNumber = slide.getSlideName();
                mLog.info("Slide number " + slideNumber);
                String slidePageName = getSlidePageName(slide);
                if (slidePageName == null) {
                    mLog.info("Slide number skipped - not comment added" + slideNumber);
                    continue;
                }
                //skip if no page def
                // Filter products with price > 100
                List<SlideInterface> model = slidesModels.stream()
                        .filter(slideInterface -> slideInterface.getSlideEnum().name() == slidePageName)
                        .collect(Collectors.toList());
                model.get(0).populateSlide(slide);

            }

        } catch (IOException ex) {
            mLog.equals(ex);
        }

        return "";
    }

  
    @Override
    public FileInputStream readTemplate() throws IOException {
        String fileName = resourceFileTV.getFilename();
        mLog.info(fileName);
         FileInputStream fileInputStream  = (FileInputStream) resourceFileTV.getInputStream();
       
        return fileInputStream;
    }

}
