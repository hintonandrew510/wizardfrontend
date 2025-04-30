package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.planamedipage.PlanMediaPageModel;
import web.page.planproposedpage.PlanProposedPageModel;

public class TwentyNinePlanASpreadSheetTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(NineteenPlanAProposedTextSlide.class.getName());

	public TwentyNinePlanASpreadSheetTextSlide(SlidesData sildeData, SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}

	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		PlanMediaPageModel planAMediaPagedataPageModel = getmSlidesData()
				.getPageModels().getPlanAMediaPagedataPageModel();
		PlanSpreadSheets planSpreadSheets = new PlanSpreadSheets(planAMediaPagedataPageModel.getMediaRows(),"TwentyNinePlanASpreadSheetTextSlide",true);

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		SlideReplacementData dailyCostA = new SlideReplacementData("dailyCostA",
				planSpreadSheets.getDailyCost());
		SlideReplacementData monthlyAverageA = new SlideReplacementData("monthlyAverageA",
				planSpreadSheets.getMonthlyAverage());
		
		listData.add(dailyCostA);
		listData.add(monthlyAverageA);


		
		

		return listData;
	}

}
