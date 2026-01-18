package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFSlide;


import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.powerpoint.slide.AbstractSlide;

public class NineConfidentialClientEvaluationProposedTextSlide extends AbstractSlide {
	public NineConfidentialClientEvaluationProposedTextSlide(SlidesData sildeData , SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}
	
	public List<SlideReplacementData> composeGoogleSlideData() {
		List<PieChart> pieChartData = getmSlidesData().getPageModels().getPieChartConfidentialClientEvaluationProposed();
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		int total=0;
		for (PieChart pieChart : pieChartData ) {
			total = pieChart.getLabelValue() + total;
		}
		String formaTotal = this.formatStringToCurrency(total);
		SlideReplacementData totalAdvertisingInvestmentConfidentialClientEvaluationProposed = new SlideReplacementData("totalAdvertisingInvestmentConfidentialClientEvaluationProposed", formaTotal);
		listData.add(totalAdvertisingInvestmentConfidentialClientEvaluationProposed);
		
		return listData;
	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	
	
}
