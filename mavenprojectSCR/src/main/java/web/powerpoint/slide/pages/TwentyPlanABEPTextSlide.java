package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.planABEPPage.PlanABEPPageModel;
import web.powerpoint.slide.AbstractSlide;

public class TwentyPlanABEPTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(TwentyPlanABEPTextSlide.class.getName());

	public TwentyPlanABEPTextSlide(SlidesData sildeData, SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}

	
	public List<SlideReplacementData> composeGoogleSlideData() {
		
		PlanABEPPageModel planABEPPageModel = getmSlidesData()
				.getPageModels().getPlanABEPPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		SlideReplacementData planAAverageSale = new SlideReplacementData("planAAverageSale",
				planABEPPageModel.getPlanAAverageSale());
		SlideReplacementData planAGrossMargin = new SlideReplacementData("planAGrossMargin",
				planABEPPageModel.getPlanAGrossMargin() + "%");
		SlideReplacementData planAClosingPct = new SlideReplacementData("planAClosingPct",
				planABEPPageModel.getPlanAClosingPct() + "%");
		SlideReplacementData planAProspectValue = new SlideReplacementData("planAProspectValue",
				planABEPPageModel.getPlanAProspectValue());
		
		SlideReplacementData planAProspectsNeeded = new SlideReplacementData("planAProspectsNeeded",
				planABEPPageModel.getPlanAProspectsNeeded());
		
		SlideReplacementData planAProspectSalesNeeded = new SlideReplacementData("planAProspectSalesNeeded",
				planABEPPageModel.getPlanAProspectSalesNeeded());
		
		SlideReplacementData planAGrossProfitOnSales = new SlideReplacementData("planAGrossProfitOnSales",
				planABEPPageModel.getPlanAGrossProfitOnSales());
		
		SlideReplacementData planAMonths = new SlideReplacementData("planAMonths",
				planABEPPageModel.getPlanAMonths());
		
		SlideReplacementData planAAdditionalGrossSales = new SlideReplacementData("planAAdditionalGrossSales",
				planABEPPageModel.getPlanAAdditionalGrossSales());
		
		listData.add(planAAverageSale);
		listData.add(planAGrossMargin);
		listData.add(planAClosingPct);
		listData.add(planAProspectValue);
		listData.add(planAProspectsNeeded);
		listData.add(planAProspectSalesNeeded);
		listData.add(planAGrossProfitOnSales);
		listData.add(planAMonths);
		listData.add(planAAdditionalGrossSales);
		//planAGrossProfitOnSales
		//

		
		

		return listData;
	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
