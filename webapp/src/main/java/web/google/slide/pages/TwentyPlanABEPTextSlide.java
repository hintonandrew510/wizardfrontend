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
import web.page.planamedipage.MediaChart;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;

public class TwentyPlanABEPTextSlide extends AbstractSlide {
	private static final Logger mLog = Logger.getLogger(TwentyPlanABEPTextSlide.class.getName());

	public TwentyPlanABEPTextSlide(SlidesData sildeData, SlideEnum slideEnum) {
		super(sildeData, slideEnum);
	}

	@Override
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
		
		// SlideReplacementData planAMonthly = new SlideReplacementData("planAMonthly",
				// planABEPPageModel.getPlanAMonthly());
		
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
		//listData.add(planAMonthly);
		listData.add(planAProspectsNeeded);
		listData.add(planAProspectSalesNeeded);
		listData.add(planAGrossProfitOnSales);
		listData.add(planAMonths);
		listData.add(planAAdditionalGrossSales);
		//planAGrossProfitOnSales
		//

		
		

		return listData;
	}

}
