package web.powerpoint.slide.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.poi.xslf.usermodel.XSLFSlide;



import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.planamedipage.MediaChart;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;
import web.powerpoint.slide.AbstractSlide;

public class FourClientObjectiveTextSlide extends AbstractSlide {
	public FourClientObjectiveTextSlide(SlidesData sildeData , SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}
	
	public List<SlideReplacementData> composeGoogleSlideData() {
		StrategicMarketingPageOneModel strategicMarketingPageOneModel = getmSlidesData().getPageModels().getStrategicMarketingPageOneModel();
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		SlideReplacementData misconceptions = new SlideReplacementData("misconceptions", strategicMarketingPageOneModel.getMisconceptions());
		SlideReplacementData sellingAdvantages = new SlideReplacementData("sellingAdvantages", strategicMarketingPageOneModel.getSellingAdvantages());
		listData.add(misconceptions);
		listData.add(sellingAdvantages);
		return listData;
	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	
	
}
