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
import web.page.planamedipage.MediaChart;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;

public class NineteenPlanAProposedTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(NineteenPlanAProposedTextSlide.class.getName());

	public NineteenPlanAProposedTextSlide(SlidesData sildeData, SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}

	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		
		PlanProposedPageModel planAProposedPageModel = getmSlidesData()
				.getPageModels().getPlanAProposedPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		String planAReachStr = withLargeIntegers(planAProposedPageModel.getPlanAReach());
		SlideReplacementData planACity = new SlideReplacementData("planACity",
				planAProposedPageModel.getPlanACity());
		SlideReplacementData planAReach = new SlideReplacementData("planAReach",
				planAReachStr);
		SlideReplacementData planAFrequency = new SlideReplacementData("planAFrequency",
				planAProposedPageModel.getPlanAFrequency());
		String planADigitalImpressionsMonthlyStr = withLargeIntegers(planAProposedPageModel.getPlanADigitalImpressionsMonthly());
		SlideReplacementData planADigitalImpressionsMonthly = new SlideReplacementData("planADigitalImpressionsMonthly",
				planADigitalImpressionsMonthlyStr);
		SlideReplacementData planAMonthly = new SlideReplacementData("planAMonthly",
				planAProposedPageModel.getPlanAMonthly());
		SlideReplacementData planADaily = new SlideReplacementData("planADaily",
				planAProposedPageModel.getPlanADaily());
		listData.add(planACity);
		listData.add(planAReach);
		listData.add(planAFrequency);
		listData.add(planADigitalImpressionsMonthly);
		listData.add(planAMonthly);
		listData.add(planADaily);

		
		

		return listData;
	}

}
