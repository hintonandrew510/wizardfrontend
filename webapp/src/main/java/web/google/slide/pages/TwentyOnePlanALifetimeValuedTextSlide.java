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
import web.page.planalifetimevaluedpage.PlanALifetimeValuedPageModel;
import web.page.planamedipage.MediaChart;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;

public class TwentyOnePlanALifetimeValuedTextSlide extends AbstractSlide {
	private static final Logger mLog = Logger.getLogger(TwentyOnePlanALifetimeValuedTextSlide.class.getName());

	public TwentyOnePlanALifetimeValuedTextSlide(SlidesData sildeData, SlideEnum slideEnum) {
		super(sildeData, slideEnum);
	}

	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		PlanALifetimeValuedPageModel planALifetimeValuedPageModel =  getmSlidesData()
				.getPageModels().getPlanALifetimeValuedPageModel();
		

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		SlideReplacementData averageSale = new SlideReplacementData("a_averageSale",
				planALifetimeValuedPageModel.getAverageSale());
		SlideReplacementData grossProfitMargin = new SlideReplacementData("a_grossProfitMargin",
				planALifetimeValuedPageModel.getGrossProfitMargin() );
		SlideReplacementData grossProfitPerSale = new SlideReplacementData("a_grossProfitPerSale",
				planALifetimeValuedPageModel.getGrossProfitPerSale() );
		SlideReplacementData averageRepeatSales = new SlideReplacementData("a_averageRepeatSales",
				planALifetimeValuedPageModel.getAverageRepeatSales());
		
		SlideReplacementData averageCustomerValue = new SlideReplacementData("a_averageCustomerValue",
				planALifetimeValuedPageModel.getAverageCustomerValue());
		
		SlideReplacementData yearsOfPatronage = new SlideReplacementData("a_yearsOfPatronage",
				planALifetimeValuedPageModel.getYearsOfPatronage());
		
		SlideReplacementData lifetimeValuePerCustomer = new SlideReplacementData("a_lifetimeValuePerCustomer",
				planALifetimeValuedPageModel.getLifetimeValuePerCustomer());
		
		SlideReplacementData prospectsNeededToBreakEven = new SlideReplacementData("a_prospectsNeededToBreakEven",
				planALifetimeValuedPageModel.getProspectsNeededToBreakEven());
		
		
		listData.add(averageSale);
		listData.add(grossProfitMargin);
		listData.add(grossProfitPerSale);
		listData.add(averageRepeatSales);
		listData.add(averageCustomerValue);
		listData.add(yearsOfPatronage);
		listData.add(lifetimeValuePerCustomer);
		listData.add(prospectsNeededToBreakEven);
		
		//planAGrossProfitOnSales
		//

		
		

		return listData;
	}

}
