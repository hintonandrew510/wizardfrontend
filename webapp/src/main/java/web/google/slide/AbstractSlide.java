package web.google.slide;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import web.page.PieChart;
import web.page.planamedipage.MediaChart;

public abstract class AbstractSlide implements SlideInterface {
	private static final Logger mLog = LoggerFactory.getLogger(AbstractSlide.class.getName());

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

	public String formatStringToCurrency(int currency) {
		String currencyStr = String.valueOf(currency);
		currencyStr = formatStringToCurrency(currencyStr);
		return currencyStr;
	}

	public String withLargeIntegers(String value) {
		try {
			double valuedouble = Double.parseDouble(value);
			DecimalFormat df = new DecimalFormat("###,###,###");
			return df.format(valuedouble);
		} catch (Exception e) {
            return "";
		}
	}

	public String formatStringToCurrency(String currency) {
		try {
			if (currency == null || currency == "") {
				return "";
			}
			double amount = Double.parseDouble(currency);
			NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
			usdCostFormat.setMaximumFractionDigits(0);
			String output = usdCostFormat.format(amount);
			return output;
		} catch (Exception ex) {

			return "";
		}
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

	public AbstractSlide(SlidesData slidesData, SlideEnum slideEnum, String pageName) {
		this.slideEnum = slideEnum;
		mSlidesData = slidesData;
		this.pageName = pageName;
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

		mLog.warn("hasReplacementData");
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
			mLog.error(ex.getMessage());
		}
		return isTextReplacement;
	}

	@Override
	public SlideEnum getSlideEnum() {
		// TODO Auto-generated method stub
		return this.slideEnum;
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
