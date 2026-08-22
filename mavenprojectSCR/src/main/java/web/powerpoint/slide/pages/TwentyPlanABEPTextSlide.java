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
import web.page.planABEPPage.PlanABEPPageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class TwentyPlanABEPTextSlide extends AbstractSlide {

    private static final Logger mLog = LoggerFactory.getLogger(TwentyPlanABEPTextSlide.class.getName());

    public TwentyPlanABEPTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
    }

    @Override
    public void populateSlide(XSLFSlide slide) {
        
        /*
        	a {PlanABEPPageModel?.planAAverageSale}"
        
	b ${PlanABEPPageModel?.planAGrossMargin} + '%'"
c ${PlanABEPPageModel?.planAClosingPct} + '%'"
d ${PlanABEPPageModel?.planAProspectValue}"

e ${PlanAProposedPageModel?.planAMonthly}"'
        
f ${PlanABEPPageModel?.planAProspectsNeeded}"
g	${PlanABEPPageModel?.planAProspectSalesNeeded}
h	"${PlanABEPPageModel?.planAGrossProfitOnSales}"
		I "${PlanABEPPageModel?.planAMonths}"
		
J "${PlanABEPPageModel?.planAAdditionalGrossSales}"
        */

        PlanABEPPageModel planABEPPageModel = getmSlidesData()
                .getPageModels().getPlanABEPPageModel();

        List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

        SlideReplacementData planAAverageSale = new SlideReplacementData("AAver",
                planABEPPageModel.getPlanAAverageSale());
        
        SlideReplacementData planAGrossMargin = new SlideReplacementData("BGross",
                planABEPPageModel.getPlanAGrossMargin() + "%");
        
        SlideReplacementData planAClosingPct = new SlideReplacementData("CClose",
                planABEPPageModel.getPlanAClosingPct() + "%");
        
        SlideReplacementData planAProspectValue = new SlideReplacementData("DProj",
                planABEPPageModel.getPlanAProspectValue()); //AProspectValue

        SlideReplacementData planAProspectsNeeded = new SlideReplacementData("EClient",
                planABEPPageModel.getPlanAMonths());

        SlideReplacementData planAProspectSalesNeeded = new SlideReplacementData("FMonth",
                planABEPPageModel.getPlanAProspectsNeeded());
//planAProspectsNeeded planAProspectsNeeded
        
        SlideReplacementData planAGrossProfitOnSales = new SlideReplacementData("GMonth",
                planABEPPageModel.getPlanAProspectSalesNeeded());
                       //planAProspectSalesNeeded

        SlideReplacementData planAMonths = new SlideReplacementData("HGross",
                planABEPPageModel.getPlanAGrossProfitOnSales());
        
        //planAGrossProfitOnSales

        SlideReplacementData planAAdditionalGrossSales = new SlideReplacementData("INumb",
                planABEPPageModel.getPlanAMonths());
        SlideReplacementData planAAdditionalGrossSalesB = new SlideReplacementData("JAdd",
                planABEPPageModel.getPlanAGrossProfitOnSales());
        //planAAdditionalGrossSales

        listData.add(planAAverageSale);
        listData.add(planAGrossMargin);
        listData.add(planAClosingPct);
        listData.add(planAProspectValue);
        listData.add(planAProspectsNeeded);
        listData.add(planAProspectSalesNeeded);
        listData.add(planAGrossProfitOnSales);
        listData.add(planAMonths);
        listData.add(planAAdditionalGrossSales);
        listData.add(planAAdditionalGrossSalesB);
        replaceTextOnSlide(listData, slide);
    }

}
