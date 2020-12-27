package web.google.slide.pages;

import java.util.Map;

import web.google.slide.AbstractSlide;
import web.google.slide.SlidesData;
import web.page.presentedtopage.PresentedToPageModel;

public class PresentedToSlide extends AbstractSlide {
	public PresentedToSlide(SlidesData sildeData) {
		super(sildeData);
	}
	@Override
	public Map<String, String> composeGoogleSlideData() {
		PresentedToPageModel presentedToPageModel =  getmSlidesData().getPageModels().getPresentedToPageModel();
		return null;
	}

}
