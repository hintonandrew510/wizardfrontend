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
import web.page.planamedipage.MediaChart;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;

public class TwentyFivePlanAProposedTextSlide extends AbstractSlide {
	private static final Logger mLog = Logger.getLogger(TwentyFivePlanAProposedTextSlide.class.getName());

	public TwentyFivePlanAProposedTextSlide(SlidesData sildeData, SlideEnum slideEnum) {
		super(sildeData, slideEnum);
	}

	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		
		PlanProposedPageModel planBProposedPageModel = getmSlidesData()
				.getPageModels().getPlanBProposedPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		String planAReachStr = formatStringToCurrency(planBProposedPageModel.getPlanAReach());
		SlideReplacementData planBCity = new SlideReplacementData("planBCity",
				planBProposedPageModel.getPlanACity());
		SlideReplacementData planBReach = new SlideReplacementData("planBReach",
				planAReachStr);
		SlideReplacementData planBFrequency = new SlideReplacementData("planBFrequency",
				planBProposedPageModel.getPlanAFrequency());
		String planADigitalImpressionsMonthlyStr = formatStringToCurrency(planBProposedPageModel.getPlanADigitalImpressionsMonthly());
		SlideReplacementData planBDigitalImpressionsMonthly = new SlideReplacementData("planBDigitalImpressionsMonthly",
				planADigitalImpressionsMonthlyStr);
		SlideReplacementData planBMonthly = new SlideReplacementData("planBMonthly",
				planBProposedPageModel.getPlanAMonthly());
		SlideReplacementData planBDaily = new SlideReplacementData("planBDaily",
				planBProposedPageModel.getPlanADaily());
		listData.add(planBCity);
		listData.add(planBReach);
		listData.add(planBFrequency);
		listData.add(planBDigitalImpressionsMonthly);
		listData.add(planBMonthly);
		listData.add(planBDaily);

		
		

		return listData;
	}

}
