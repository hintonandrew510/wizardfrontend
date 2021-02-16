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

			
		SlideReplacementData planBMonths = new SlideReplacementData("planBMonths",
				planBBEPPageModel.getPlanBMonths());
		
		
		
		
		listData.add(planBMonths);
		
		
		//planAGrossProfitOnSales
		//

		
		

		return listData;
	}

}
