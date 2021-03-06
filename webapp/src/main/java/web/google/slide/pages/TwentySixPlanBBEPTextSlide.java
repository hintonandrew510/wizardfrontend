package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import web.google.slide.AbstractSlide;
import web.google.slide.GoogleSlideController;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;
import web.page.planABEPPage.PlanABEPPageModel;
import web.page.planBBEPPage.PlanBBEPPageModel;
import web.page.planamedipage.MediaChart;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;

public class TwentySixPlanBBEPTextSlide extends AbstractSlide {
	private static final Logger mLog = Logger.getLogger(TwentySixPlanBBEPTextSlide.class.getName());

	public TwentySixPlanBBEPTextSlide(SlidesData sildeData, SlideEnum slideEnum) {
		super(sildeData, slideEnum);
	}

	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		
		PlanBBEPPageModel planBBEPPageModel = getmSlidesData()
				.getPageModels().getPlanBBEPPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();


		SlideReplacementData planBAverageSale = new SlideReplacementData("planBAverageSale",
				planBBEPPageModel.getPlanBAverageSale() + "%");
		
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

}
