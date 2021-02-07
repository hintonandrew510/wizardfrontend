package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.targetmarketingpage.TargetMarketingHeaderRow;
import web.page.targetmarketingpage.TargetMarketingPageModel;

public class SixTargetMarketingSlide extends AbstractSlide {

	public SixTargetMarketingSlide(SlidesData sildeData , SlideEnum slideEnum) {
		super(sildeData, slideEnum);
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		TargetMarketingPageModel targetMarketingPageModel = getmSlidesData().getPageModels().getTargetMarketingPageModel();
		TargetMarketingHeaderRow targetMarketingHeaderRow = getmSlidesData().getPageModels().getTargetMarketingHeaderRow();
		String pctMenStr = targetMarketingPageModel.getPctMen() + "%";
		SlideReplacementData pctMen = new SlideReplacementData("pctMen", pctMenStr);
		listData.add(pctMen);
		
		String pctWomenStr = targetMarketingPageModel.getPctWomen() + "%";
		SlideReplacementData pctWomen = new SlideReplacementData("pctWomen", pctWomenStr);
		listData.add(pctWomen);	
		SlideReplacementData test = new SlideReplacementData("test", "\u2713");
		listData.add(test);
		String crossStr= "\u2713";
		SlideReplacementData cross = new SlideReplacementData("cross", crossStr);
		listData.add(test);
		listData.add(cross);
		return listData;
	
	}

}
