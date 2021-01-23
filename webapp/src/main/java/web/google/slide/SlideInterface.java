package web.google.slide;

import java.util.List;
import java.util.Map;

import web.page.PieChart;
import web.page.planamedipage.MediaChart;

public interface SlideInterface {
	
	    public List<SlideReplacementData> composeGoogleSlideData();
	    public List<PieChart> getPieChartData();
	    public MediaChart getMediaChart();
	    public boolean isClientObjectiveConsumer();
	    public boolean isClientObjectiveBrand();
	    public boolean isClientObjectiveBrandOtherText();
	    public boolean isClientObjectiveProductService();
	    public boolean isClientObjectivePromotion();
	    public SlideEnum getSlideType();
	    public boolean hasReplacementData();
	    public String getWriteRange();
	    public boolean needsDataRefresh();
	    public String getPageName();
	    public boolean isChart();
	    public boolean isPieChart();
	    public boolean isBarChart();
	    public SlideEnum getSlideEnum();
	    public SlidesData getSlidesData();
   
	    
	    
}
