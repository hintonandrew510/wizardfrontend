package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.planamedipage.MediaChart;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;
import web.page.strategicmarketingpagethree.StrategicMarketingHelper;
import web.page.strategicmarketingpagethree.StrategicMarketingPageThreeModel;

public class FiveStrategicMarketingPageSlide extends AbstractSlide {
	public FiveStrategicMarketingPageSlide(SlidesData sildeData , SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		StrategicMarketingPageOneModel model =  getmSlidesData().getPageModels().getStrategicMarketingPageOneModel();
		StrategicMarketingPageThreeModel strategicMarketingPageThreeModel = getmSlidesData().getPageModels().getStrategicMarketingPageThreeModel();
		
		StrategicMarketingHelper strategicMarketingHelper =  getmSlidesData().getPageModels().getStrategicMarketingHelper();
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		SlideReplacementData companyNameProjectImage = new SlideReplacementData("companyNameProjectImage", model.getCompanyNameProjectImage());
		SlideReplacementData currentCompanySlogan = new SlideReplacementData("currentCompanySlogan", model.getCurrentCompanySlogan());
		String planToExpandBoolen = model.isPlanToExpand() ? "Yes" : "No";
		SlideReplacementData planToExpand = new SlideReplacementData("planToExpand", planToExpandBoolen);
		SlideReplacementData poorestMonths = new SlideReplacementData("poorestMonths", strategicMarketingHelper.getPoorestMonths());

		SlideReplacementData compliments = new SlideReplacementData("compliments",strategicMarketingPageThreeModel.getCompliments());
		SlideReplacementData bestMonths = new SlideReplacementData("bestMonths", strategicMarketingHelper.getBestMonths());

		SlideReplacementData complaint = new SlideReplacementData("complaint",strategicMarketingPageThreeModel.getComplaint());
		SlideReplacementData bestDays = new SlideReplacementData("bestDays", strategicMarketingHelper.getBestDays());
		
		SlideReplacementData marketingStrategy = new SlideReplacementData("marketingStrategy",strategicMarketingPageThreeModel.getMarketingStrategy());
		SlideReplacementData socialStrategy = new SlideReplacementData("socialStrategy", strategicMarketingPageThreeModel.getSocialStrategy());

		
		
		listData.add(companyNameProjectImage);
		listData.add(currentCompanySlogan);
		listData.add(planToExpand);
		listData.add(poorestMonths);
		
		
		listData.add(compliments);
		listData.add(bestMonths);
		listData.add(complaint);
		listData.add(bestDays);
		listData.add(marketingStrategy);
		listData.add(socialStrategy);
		
		return listData;


		


	}
	
	



}
