package web.powerpoint.slide.pages;


import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;



import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.model.Contact;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class FourClientObjectiveTextSlide extends AbstractSlide {
	public FourClientObjectiveTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
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
    	StrategicMarketingPageOneModel strategicMarketingPageOneModel = getmSlidesData().getPageModels().getStrategicMarketingPageOneModel();
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		SlideReplacementData misconceptions = new SlideReplacementData("misconceptions", strategicMarketingPageOneModel.getMisconceptions());
		SlideReplacementData sellingAdvantages = new SlideReplacementData("sellingAdvantages", strategicMarketingPageOneModel.getSellingAdvantages());
		listData.add(misconceptions);
		listData.add(sellingAdvantages);
                replaceTextOnSlide(listData, slide);
    }
	
	
}
