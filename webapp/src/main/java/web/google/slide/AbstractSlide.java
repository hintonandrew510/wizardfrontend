package web.google.slide;

import java.util.List;
import java.util.logging.Logger;

import web.page.PieChart;
import web.page.planamedipage.MediaChart;

public abstract class AbstractSlide implements SlideInterface {
	private static final Logger mLog = Logger.getLogger(AbstractSlide.class.getName());

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

	public void setMediaChart(MediaChart mediaChart, String writeRange, String pageName) {
		this.mediaChart = mediaChart;
		this.writeRange = writeRange;
		this.pageName = pageName;

	}

	private List<PieChart> pieChartList;
	private MediaChart mediaChart;

	public AbstractSlide(MediaChart mediaChart, String writeRange, String pageName, SlideEnum slideEnum) {
		super();
		this.mediaChart = mediaChart;
		this.writeRange = writeRange;
		this.pageName = pageName;
		this.slideEnum = slideEnum;
	}

	public AbstractSlide(List<PieChart> pieChartList, String writeRange, String pageName, SlideEnum slideEnum) {
		super();
		this.pieChartList = pieChartList;
		this.writeRange = writeRange;
		this.pageName = pageName;
		this.slideEnum = slideEnum;
	}

	public AbstractSlide(String writeRange, String pageName, SlideEnum slideEnum) {
		super();
		this.writeRange = writeRange;
		this.pageName = pageName;
		this.slideEnum = slideEnum;
	}
	
	
	
	public AbstractSlide(String writeRange, String pageName, SlideEnum slideEnum, SlidesData slidesData) {
		super();
		this.writeRange = writeRange;
		this.pageName = pageName;
		this.slideEnum = slideEnum;
		mSlidesData = slidesData;
	}
	public SlidesData getmSlidesData() {
		return mSlidesData;
	}
	
	@Override
	public SlidesData getSlidesData() {
		// TODO Auto-generated method stub
		return mSlidesData;
	}

	public void setmSlidesData(SlidesData mSlidesData) {
		this.mSlidesData = mSlidesData;
	}

	public AbstractSlide(SlidesData slidesData, SlideEnum slideEnum) {
		this.slideEnum = slideEnum;
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
	public boolean hasReplacementData() {
		mLog.warning("hasReplacementData");
		boolean isTextReplacement = false;
		try {
			switch (this.slideEnum) {
			case TextSlideReplacement:
				isTextReplacement = true;
				break;
			default:
				isTextReplacement = false;
			}
		} catch (Exception ex) {
			mLog.severe(ex.getMessage());
		}
		return isTextReplacement;
	}

	@Override
	public boolean isChart() {
		boolean hasChartData = false;
		try {
			switch (this.slideEnum) {
			case BarChart:
			case PieChart:
				hasChartData = true;
				break;
			default:
				hasChartData = false;
			}
		} catch (Exception ex) {
			mLog.severe(ex.getMessage());
		}
		return hasChartData;

	}
	
	@Override
	public boolean isClientObjectiveBrand() {
		boolean hasClientData = false;
		try {
			switch (this.slideEnum) {
			
			case ClientObjectiveBRAND:
				hasClientData = true;
				break;
			default:
				hasClientData = false;
				break;
			}
			
		} catch (Exception ex) {
			mLog.severe(ex.getMessage());
		}
		// TODO Auto-generated method stub
		return hasClientData;
	}
	@Override
	public boolean isClientObjectiveProductService() {
		boolean hasClientData = false;
		try {
			switch (this.slideEnum) {
			
			case ClientObjectivePRODUCTSERVICE:
				hasClientData = true;
				break;
			default:
				hasClientData = false;
				break;
			}
			
		} catch (Exception ex) {
			mLog.severe(ex.getMessage());
		}
		// TODO Auto-generated method stub
		return hasClientData;
	}
	@Override
	public boolean isClientObjectivePromotion() {
		boolean hasClientData = false;
		try {
			switch (this.slideEnum) {
			
			case ClientObjectivePROMOTION:
				hasClientData = true;
				break;
			default:
				hasClientData = false;
				break;
			}
			
		} catch (Exception ex) {
			mLog.severe(ex.getMessage());
		}
		// TODO Auto-generated method stub
		return hasClientData;
	}

	@Override
	public boolean isClientObjectiveConsumer() {
		boolean hasClientData = false;
		try {
			switch (this.slideEnum) {
			
			case ClientObjectiveCONSUMER:
				hasClientData = true;
				break;
			default:
				hasClientData = false;
				break;
			}
			
		} catch (Exception ex) {
			mLog.severe(ex.getMessage());
		}
		// TODO Auto-generated method stub
		return hasClientData;
	}

	@Override
	public boolean isPieChart() {
		boolean hasChartData = false;
		try {
			switch (this.slideEnum) {
			case PieChart:
				hasChartData = true;
				break;
			default:
				hasChartData = false;
			}
		} catch (Exception ex) {
			mLog.severe(ex.getMessage());
		}
		return hasChartData;
	}

	@Override
	public boolean isBarChart() {
		boolean hasChartData = false;
		switch (this.slideEnum) {
		case BarChart:

			hasChartData = true;
			break;
		default:
			hasChartData = false;
		}
		return hasChartData;
	}

	private SlideEnum slideEnum;

	@Override
	public String getWriteRange() {
		// TODO Auto-generated method stub
		return writeRange;
	}

	@Override
	public boolean needsDataRefresh() {
		boolean needsRefresh = false;
		switch (this.slideEnum) {
		case BarChart:
		case PieChart:
			needsRefresh = true;
			break;
		default:
			needsRefresh = false;
			break;

		}

		return needsRefresh;
	}

	@Override
	public String getPageName() {

		// TODO Auto-generated method stub
		return this.pageName;
	}

	@Override
	public SlideEnum getSlideType() {
		// TODO Auto-generated method stub
		return slideEnum;
	}

}
