package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import web.google.slide.AbstractSlide;
import web.google.slide.GoogleSlideController;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;
import web.page.planABEPPage.PlanABEPPageModel;
import web.page.planBBEPPage.PlanBBEPPageModel;
import web.page.planDigitalroicalculatorpage.PlanDigitalROICalculatorPageModel;
import web.page.planamedipage.MediaChart;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;

public class TwentyEightPlanBDigitalROICalculatorTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(TwentyEightPlanBDigitalROICalculatorTextSlide.class.getName());

	public TwentyEightPlanBDigitalROICalculatorTextSlide(SlidesData sildeData, SlideEnum slideEnum) {
		super(sildeData, slideEnum);
	}

	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		
		PlanDigitalROICalculatorPageModel pageModel = getmSlidesData()
				.getPageModels().getPlanBDigitalROICalculatorPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

			
		SlideReplacementData planBMonthlyDigitalInvestment = new SlideReplacementData("planBMonthlyDigitalInvestment",
				pageModel.getPlanAMonthlyDigitalInvestment());
		
		SlideReplacementData planBCostPerThousand = new SlideReplacementData("planBCostPerThousand",
				pageModel.getPlanACostPerThousand());
		
		String planBClosingPctNumberStr = pageModel.getPlanAMonthlyDigitalInvestment();
		planBClosingPctNumberStr = this.formatStringToCurrency(planBClosingPctNumberStr);
		SlideReplacementData planBClosingPctNumber = new SlideReplacementData("planBClosingPctNumber",
				planBClosingPctNumberStr);
		SlideReplacementData planBClickThroughRate = new SlideReplacementData("planBClickThroughRate",
				pageModel.getPlanAClickThroughRate() + "%");
		
		SlideReplacementData planBMonthlyClicks = new SlideReplacementData("planBMonthlyClicks",
				pageModel.getPlanAMonthlyClicks());
		
		SlideReplacementData planBCostPerClicks = new SlideReplacementData("planBCostPerClicks",
				pageModel.getPlanACostPerClicks());
		
		SlideReplacementData planBSalesConversionPercentage = new SlideReplacementData("planBSalesConversionPercentage",
				pageModel.getPlanASalesConversionPercentage() + "%");
		
		
		SlideReplacementData planBMonthlyConversions = new SlideReplacementData("planBMonthlyConversions",
				pageModel.getPlanAMonthlyConversions());
		
		
		
		SlideReplacementData planBCostPerConversion = new SlideReplacementData("planBCostPerConversion",
				pageModel.getPlanACostPerConversion());
		
		SlideReplacementData planBProjectedGrossProfit = new SlideReplacementData("planBProjectedGrossProfit",
				pageModel.getPlanAProjectedGrossProfit());
		
		SlideReplacementData planBMonthlyGrossProfit = new SlideReplacementData("planBMonthlyGrossProfit",
				pageModel.getPlanAMonthlyGrossProfit());
		
		SlideReplacementData planBMonthlyROID = new SlideReplacementData("planBMonthlyROID",
				pageModel.getPlanAMonthlyROID());
		SlideReplacementData planBMonthlyROIP = new SlideReplacementData("planBMonthlyROIP",
				pageModel.getPlanAMonthlyROIP());
		
		
		listData.add(planBMonthlyDigitalInvestment);
		listData.add(planBCostPerThousand);
		listData.add(planBClosingPctNumber);
		listData.add(planBClickThroughRate);
		listData.add(planBMonthlyClicks);
		listData.add(planBCostPerClicks);
		listData.add(planBCostPerConversion);
		listData.add(planBProjectedGrossProfit);
		listData.add(planBMonthlyGrossProfit);
		listData.add(planBMonthlyROID);
		listData.add(planBMonthlyROIP);
		listData.add(planBMonthlyDigitalInvestment);
		listData.add(planBSalesConversionPercentage);
		listData.add(planBMonthlyConversions);
		
		
		
		
		//planAGrossProfitOnSales
		//

		
		

		return listData;
	}

}
