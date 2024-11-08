package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.planamedipage.MediaChart;
import web.page.presentedtopage.PresentedToPageModel;

public class OnePresentedToSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(OnePresentedToSlide.class.getName());

	public OnePresentedToSlide(SlidesData sildeData , SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		
		PresentedToPageModel presentedToPageModel =  getmSlidesData().getPageModels().getPresentedToPageModel();
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		SlideReplacementData clientContactName = new SlideReplacementData("clientContactName", presentedToPageModel.getClientContactName());
		SlideReplacementData clientBusinessName = new SlideReplacementData("clientBusinessName", presentedToPageModel.getClientBusinessName());
		SlideReplacementData portfolioManagerName = new SlideReplacementData("portfolioManagerName", presentedToPageModel.getPortfolioManagerName());
		SlideReplacementData station = new SlideReplacementData("station", presentedToPageModel.getStation());
		SlideReplacementData portfolioPhoneNumber = new SlideReplacementData("portfolioPhoneNumber", presentedToPageModel.getPortfolioPhoneNumber());
		
		listData.add(clientContactName);
		listData.add(clientBusinessName);
		listData.add(portfolioManagerName);
		listData.add(station);
		listData.add(portfolioPhoneNumber);
		mLog.trace(listData.toString());
		return listData;


		


	}
	
	



}
