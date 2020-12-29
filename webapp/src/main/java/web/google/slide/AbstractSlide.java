package web.google.slide;

import java.util.List;

import web.page.PieChart;
import web.page.planamedipage.MediaChart;

public abstract class AbstractSlide implements SlideInterface {
	private SlidesData mSlidesData;
	
    private List<PieChart> pieChartList;
    private MediaChart mediaChart;
    
	public AbstractSlide(MediaChart mediaChart) {
		super();
		this.mediaChart = mediaChart;
	}
	public AbstractSlide(List<PieChart> pieChartList) {
		super();
		this.pieChartList = pieChartList;
	}
	public SlidesData getmSlidesData() {
		return mSlidesData;
	}
	public void setmSlidesData(SlidesData mSlidesData) {
		this.mSlidesData = mSlidesData;
	}
	public AbstractSlide(SlidesData slidesData) {
		mSlidesData = slidesData;
	}

}
