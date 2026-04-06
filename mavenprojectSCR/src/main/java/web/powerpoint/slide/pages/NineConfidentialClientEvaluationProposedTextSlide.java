package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;


import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.model.Contact;
import web.page.PieChart;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class NineConfidentialClientEvaluationProposedTextSlide extends AbstractSlide {
	public NineConfidentialClientEvaluationProposedTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
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
