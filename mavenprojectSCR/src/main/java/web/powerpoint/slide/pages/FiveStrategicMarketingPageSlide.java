package web.powerpoint.slide.pages;


import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.google.slide.SlideReplacementData;


import web.google.slide.SlidesData;
import web.page.JSONManager;
import web.page.marketplacecompetitionpage.MarketPlaceCompetitionPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;
import web.page.strategicmarketingpagethree.StrategicMarketingHelper;
import web.page.strategicmarketingpagethree.StrategicMarketingPageThreeModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class FiveStrategicMarketingPageSlide extends AbstractSlide {
 private static final Logger mLog = LoggerFactory.getLogger(FiveStrategicMarketingPageSlide.class.getName());

    public FiveStrategicMarketingPageSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName) {
        super(slidesData, slideEnum, pageName);
    }

    @Override
    public void populateSlide(XSLFSlide slide) {
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
                   replaceTextOnSlide(listData, slide);

        //loop thru add repalce data on slide
        mLog.trace(listData.toString());
                      
    }
	
	
	



}
