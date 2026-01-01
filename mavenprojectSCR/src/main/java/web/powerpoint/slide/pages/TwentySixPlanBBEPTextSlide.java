package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.planBBEPPage.PlanBBEPPageModel;
import web.powerpoint.slide.AbstractSlide;

public class TwentySixPlanBBEPTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(TwentySixPlanBBEPTextSlide.class.getName());

	public TwentySixPlanBBEPTextSlide(SlidesData sildeData, SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}

	
	public List<SlideReplacementData> composeGoogleSlideData() {
		
		PlanBBEPPageModel planBBEPPageModel = getmSlidesData()
				.getPageModels().getPlanBBEPPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();


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
		listData.add(planBGrossMargin);
		listData.add(planBClosingPct);
		listData.add(planBProspectValue);
		listData.add(planBProspectsNeeded);
		listData.add(planBProspectSalesNeeded);
		listData.add(planBGrossProfitOnSales);
		listData.add(planBMonths);
		listData.add(planBAdditionalGrossSales);
		
		
		
		
		listData.add(planBMonths);
		
		
		//planAGrossProfitOnSales
		//

		
		

		return listData;
	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
