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
import web.page.planDigitalroicalculatorpage.PlanDigitalROICalculatorPageModel;
import web.page.planamedipage.MediaChart;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;

public class TwentyTwoPlanADigitalROICalculatorTextSlide extends AbstractSlide {
	private static final Logger mLog = Logger.getLogger(TwentyTwoPlanADigitalROICalculatorTextSlide.class.getName());

	public TwentyTwoPlanADigitalROICalculatorTextSlide(SlidesData sildeData, SlideEnum slideEnum) {
		super(sildeData, slideEnum);
	}

	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		
		PlanDigitalROICalculatorPageModel pageModel = getmSlidesData()
				.getPageModels().getPlanADigitalROICalculatorPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

			
		SlideReplacementData planAMonthlyDigitalInvestment = new SlideReplacementData("planAMonthlyDigitalInvestment",
				pageModel.getPlanAMonthlyDigitalInvestment());
		
		SlideReplacementData planACostPerThousand = new SlideReplacementData("planACostPerThousand",
				pageModel.getPlanACostPerThousand());
		
		String planAClosingPctNumberStr = pageModel.getPlanAClosingPctNumber();
		//planAClosingPctNumberStr = this.formatStringToCurrency(planAClosingPctNumberStr);
		SlideReplacementData planAClosingPctNumber = new SlideReplacementData("planAClosingPctNumber",
				planAClosingPctNumberStr);
		SlideReplacementData planAClickThroughRate = new SlideReplacementData("planAClickThroughRate",
				pageModel.getPlanAClickThroughRate() + "%");
		
		SlideReplacementData planAMonthlyClicks = new SlideReplacementData("planAMonthlyClicks",
				pageModel.getPlanAMonthlyClicks());
		
		SlideReplacementData planACostPerClicks = new SlideReplacementData("planACostPerClicks",
				pageModel.getPlanACostPerClicks());
		
		SlideReplacementData planASalesConversionPercentage = new SlideReplacementData("planASalesConversionPercentage",
				pageModel.getPlanASalesConversionPercentage() + "%");
		
		
		SlideReplacementData planAMonthlyConversions = new SlideReplacementData("planAMonthlyConversions",
				pageModel.getPlanAMonthlyConversions());
		
		
		
		SlideReplacementData planACostPerConversion = new SlideReplacementData("planACostPerConversion",
				pageModel.getPlanACostPerConversion());
		
		SlideReplacementData planAProjectedGrossProfit = new SlideReplacementData("planAProjectedGrossProfit",
				pageModel.getPlanAProjectedGrossProfit());
		
		SlideReplacementData planAMonthlyGrossProfit = new SlideReplacementData("planAMonthlyGrossProfit",
				pageModel.getPlanAMonthlyGrossProfit());
		
		SlideReplacementData planAMonthlyROID = new SlideReplacementData("planAMonthlyROID",
				pageModel.getPlanAMonthlyROID());
		SlideReplacementData planAMonthlyROIP = new SlideReplacementData("planAMonthlyROIP",
				pageModel.getPlanAMonthlyROIP());
		
		
		listData.add(planAMonthlyDigitalInvestment);
		listData.add(planACostPerThousand);
		listData.add(planAClosingPctNumber);
		listData.add(planAClickThroughRate);
		listData.add(planAMonthlyClicks);
		listData.add(planACostPerClicks);
		listData.add(planACostPerConversion);
		listData.add(planAProjectedGrossProfit);
		listData.add(planAMonthlyGrossProfit);
		listData.add(planAMonthlyROID);
		listData.add(planAMonthlyROIP);
		listData.add(planAMonthlyDigitalInvestment);
		listData.add(planASalesConversionPercentage);
		listData.add(planAMonthlyConversions);
		
		
		
		
		//planAGrossProfitOnSales
		//

		
		

		return listData;
	}

}
