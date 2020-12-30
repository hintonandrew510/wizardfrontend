package web.google.slide;

import java.util.List;

import web.page.PieChart;
import web.page.planamedipage.MediaChart;

public abstract class AbstractSlide implements SlideInterface {
	private SlidesData mSlidesData;
	private String writeRange;
	private String pageName;
    public List<PieChart> getPieChartList() {
		return pieChartList;
	}
	public void setPieChartList(List<PieChart> pieChartList) {
		this.pieChartList = pieChartList;
		
	}
	public MediaChart getMediaChart() {
		return mediaChart;
	}
	public void setMediaChart(MediaChart mediaChart) {
		this.mediaChart = mediaChart;
	}
	private List<PieChart> pieChartList;
    private MediaChart mediaChart;
    
	public AbstractSlide(MediaChart mediaChart) {
		super();
		this.mediaChart = mediaChart;
	}
	public AbstractSlide(List<PieChart> pieChartList, String writeRange,  String pageName) {
		super();
		this.pieChartList = pieChartList;
		this.writeRange = writeRange;
		this.pageName = pageName;
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
	@Override
	public List<PieChart> getPieChartData() {
		// TODO Auto-generated method stub
		return this.getPieChartList();
	}
	
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isBarChart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasReplacementData() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isPieChart() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getWriteRange() {
		// TODO Auto-generated method stub
		return writeRange;
	}
	@Override
	public boolean needsDataRefresh() {
		if (isPieChart() || isBarChart()) {
			return true;
		}
		return false;
	}
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return this.pageName;
	}


}
