package web.powerpoint.slide.pages;

import web.google.slide.pages.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import web.google.slide.GoogleSlideController;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;
import web.page.planABEPPage.PlanABEPPageModel;
import web.page.planalifetimevaluedpage.PlanALifetimeValuedPageModel;
import web.page.planamedipage.MediaChart;
import web.page.planbLifetimevaluedpage.PlanBLifetimeValuedPageModel;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;
import web.powerpoint.slide.AbstractSlide;

public class TwentySevenPlanBLifetimeValuedTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(TwentySevenPlanBLifetimeValuedTextSlide.class.getName());

	public TwentySevenPlanBLifetimeValuedTextSlide(SlidesData sildeData, SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}


	public List<SlideReplacementData> composeGoogleSlideData() {
		PlanBLifetimeValuedPageModel planBLifetimeValuedPageModel =  getmSlidesData()
				.getPageModels().getPlanBLifetimeValuedPageModel();
		

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		SlideReplacementData averageSale = new SlideReplacementData("b_averageSale",
				planBLifetimeValuedPageModel.getAverageSale());
		SlideReplacementData grossProfitMargin = new SlideReplacementData("b_grossProfitMargin",planBLifetimeValuedPageModel.getGrossProfitMargin() + "%");
		SlideReplacementData grossProfitPerSale = new SlideReplacementData("b_grossProfitPerSale",
				planBLifetimeValuedPageModel.getGrossProfitPerSale()  );
		
		//String averageRepeatSalesStr = this.formatStringToCurrency(planBLifetimeValuedPageModel.getAverageRepeatSales());
		String averageRepeatSalesStr = String.valueOf(planBLifetimeValuedPageModel.getAverageRepeatSales());
		
		
		
		SlideReplacementData averageRepeatSales = new SlideReplacementData("b_averageRepeatSales",
				averageRepeatSalesStr);
		
		SlideReplacementData averageCustomerValue = new SlideReplacementData("b_averageCustomerValue",
				planBLifetimeValuedPageModel.getAverageCustomerValue());
		
		SlideReplacementData yearsOfPatronage = new SlideReplacementData("b_yearsOfPatronage",
				planBLifetimeValuedPageModel.getYearsOfPatronage() + "");
		
		SlideReplacementData lifetimeValuePerCustomer = new SlideReplacementData("b_lifetimeValuePerCustomer",
				planBLifetimeValuedPageModel.getLifetimeValuePerCustomer());
		
		SlideReplacementData prospectsNeededToBreakEven = new SlideReplacementData("b_prospectsNeededToBreakEven",
				planBLifetimeValuedPageModel.getProspectsNeededToBreakEven());
		
		
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

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
