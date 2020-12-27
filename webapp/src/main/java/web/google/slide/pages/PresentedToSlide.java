package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.presentedtopage.PresentedToPageModel;

public class PresentedToSlide extends AbstractSlide {
	public PresentedToSlide(SlidesData sildeData) {
		super(sildeData);
	}
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		PresentedToPageModel presentedToPageModel =  getmSlidesData().getPageModels().getPresentedToPageModel();
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		SlideReplacementData clientContactName = new SlideReplacementData("clientContactName", presentedToPageModel.getClientContactName());
		SlideReplacementData clientBusinessName = new SlideReplacementData("clientBusinessName", presentedToPageModel.getClientBusinessName());
		SlideReplacementData portfolioManagerName = new SlideReplacementData("portfolioManagerName", presentedToPageModel.getPortfolioManagerName());
		SlideReplacementData station = new SlideReplacementData("station", presentedToPageModel.getStation());

		listData.add(clientContactName);
		listData.add(clientBusinessName);
		listData.add(portfolioManagerName);
		listData.add(station);
		return listData;


		


	}

}
