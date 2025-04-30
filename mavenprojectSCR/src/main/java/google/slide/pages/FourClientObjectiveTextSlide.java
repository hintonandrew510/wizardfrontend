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

public class FourClientObjectiveTextSlide extends AbstractSlide {
	public FourClientObjectiveTextSlide(SlidesData sildeData , SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		StrategicMarketingPageOneModel strategicMarketingPageOneModel = getmSlidesData().getPageModels().getStrategicMarketingPageOneModel();
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		SlideReplacementData misconceptions = new SlideReplacementData("misconceptions", strategicMarketingPageOneModel.getMisconceptions());
		SlideReplacementData sellingAdvantages = new SlideReplacementData("sellingAdvantages", strategicMarketingPageOneModel.getSellingAdvantages());
		listData.add(misconceptions);
		listData.add(sellingAdvantages);
		return listData;
	}
	
	
}
