package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.model.Contact;

import web.page.planBBEPPage.PlanBBEPPageModel;
import web.page.planproposedpage.PlanProposedPageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class TwentySevenPlanBBEPTextSlide extends AbstractSlide {

    private static final Logger mLog = LoggerFactory.getLogger(TwentySevenPlanBBEPTextSlide.class.getName());

    public TwentySevenPlanBBEPTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
    }

    @Override
    public void populateSlide(XSLFSlide slide) {
        /*
        A- planBAverageSale
        B- planBGrossMargin
        C - planBClosingPct
        D - planBProspectValue
        E -     planBMonthly $4,000  PlanBProposedPageModel?.planAMonthly
        F - planBProspectsNeeded
        G- planBProspectSalesNeeded
        H - planBGrossProfitOnSales
        I planBMonths
        J planBAdditionalGrossSales

         */
//planBMonthly
        PlanBBEPPageModel planBBEPPageModel = getmSlidesData()
                .getPageModels().getPlanBBEPPageModel();

        PlanProposedPageModel proposedPageModel = getmSlidesData().getPageModels().getPlanBProposedPageModel();
        //String planAMonthly = proposedPageModel.getPlanAMonthly();

        List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
        
         SlideReplacementData planAMonthly = new SlideReplacementData("planBMonthly",
                proposedPageModel.getPlanAMonthly());

        SlideReplacementData planBAverageSale = new SlideReplacementData("planBAverageSale",
                planBBEPPageModel.getPlanBAverageSale());

        SlideReplacementData planBGrossMargin = new SlideReplacementData("planBGrossMargin",
                planBBEPPageModel.getPlanBGrossMargin() + "%");

        SlideReplacementData planBClosingPct = new SlideReplacementData("planBClosingPct",
                planBBEPPageModel.getPlanBClosingPct() + "%");

        SlideReplacementData planBProspectValue = new SlideReplacementData("planBProspectValue",
                planBBEPPageModel.getPlanBProspectValue());

        SlideReplacementData planBProspectsNeeded = new SlideReplacementData("planBProspectsNeeded",
                planBBEPPageModel.getPlanBProspectsNeeded());

        SlideReplacementData planBProspectSalesNeeded = new SlideReplacementData("planBProspectSalesNeeded",
                planBBEPPageModel.getPlanBProspectSalesNeeded());

        SlideReplacementData planBGrossProfitOnSales = new SlideReplacementData("planBGrossProfitOnSales",
                planBBEPPageModel.getPlanBGrossProfitOnSales());

        SlideReplacementData planBMonths = new SlideReplacementData("planBMonths",
                planBBEPPageModel.getPlanBMonths());

        SlideReplacementData planBAdditionalGrossSales = new SlideReplacementData("planBAdditionalGrossSales",
                planBBEPPageModel.getPlanBAdditionalGrossSales());

        listData.add(planBAverageSale);
         listData.add(planAMonthly);
        listData.add(planBGrossMargin);
        listData.add(planBClosingPct);
        listData.add(planBProspectValue);
        listData.add(planBProspectsNeeded);
        listData.add(planBProspectSalesNeeded);
        listData.add(planBGrossProfitOnSales);
        listData.add(planBMonths);
        listData.add(planBAdditionalGrossSales);

        listData.add(planBMonths);
        replaceTextOnSlide(listData, slide);
        mLog.warn("CLASS" + TwentySevenPlanBBEPTextSlide.class.getName());
        //this.replaceTextOnSlidePrint(listData, slide);

    }

}
