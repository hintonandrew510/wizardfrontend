package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.planamedipage.PlanMediaPageModel;
import web.page.planproposedpage.PlanProposedPageModel;

public class ThirtyPlanBSpreadSheetTextSlide extends AbstractSlide {
	private static final Logger mLog = Logger.getLogger(NineteenPlanAProposedTextSlide.class.getName());

	public ThirtyPlanBSpreadSheetTextSlide(SlidesData sildeData, SlideEnum slideEnum) {
		super(sildeData, slideEnum);
	}

	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		PlanMediaPageModel planBMediaPagedataPageModel = getmSlidesData()
				.getPageModels().getPlanBMediaPagedataPageModel();
		PlanSpreadSheets planSpreadSheets = new PlanSpreadSheets(planBMediaPagedataPageModel.getMediaRows());

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		SlideReplacementData dailyCostB = new SlideReplacementData("dailyCostB",
				planSpreadSheets.getDailyCost());
		SlideReplacementData monthlyAverageB = new SlideReplacementData("monthlyAverageB",
				planSpreadSheets.getMonthlyAverage());
		
		listData.add(dailyCostB);
		listData.add(monthlyAverageB);


		
		

		return listData;
	}

}
