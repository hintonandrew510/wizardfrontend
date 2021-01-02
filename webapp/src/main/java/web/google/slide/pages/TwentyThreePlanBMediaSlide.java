package web.google.slide.pages;

import web.google.slide.AbstractSlide;
import web.page.planamedipage.MediaChart;

public class TwentyThreePlanBMediaSlide extends AbstractSlide {

	public TwentyThreePlanBMediaSlide(MediaChart mediaChart,  String writeRange,  String pageName) {
		
		super(mediaChart,  writeRange,  pageName);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isBarChart() {
		return true;
	}


}
