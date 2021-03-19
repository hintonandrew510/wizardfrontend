package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.planamedipage.MediaChart;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;

public class EightConfidentialClientEvaluationOneTextSlide extends AbstractSlide {
	public EightConfidentialClientEvaluationOneTextSlide(SlidesData sildeData , SlideEnum slideEnum) {
		super(sildeData, slideEnum);
	}
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		List<PieChart> pieChartData = getmSlidesData().getPageModels().getPieChartConfidentialClientEvaluationOnePage();
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		int total=0;
		for (PieChart pieChart : pieChartData ) {
			total = pieChart.getLabelValue() + total;
		}
		String formaTotal = this.formatStringToCurrency(total);
		SlideReplacementData totalAdvertisingInvestmentConfidentialClientEvaluationOnePage = new SlideReplacementData("totalAdvertisingInvestmentConfidentialClientEvaluationOnePage", formaTotal);
		listData.add(totalAdvertisingInvestmentConfidentialClientEvaluationOnePage);
		
		return listData;
	}
	
	
}
