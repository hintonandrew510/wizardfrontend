package web.powerpoint.slide.pages;


import org.apache.poi.xslf.usermodel.XSLFSlide;
import web.google.slide.SlidesData;
import web.model.Contact;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class ThirtyPlanBSpreadSheetSlide extends AbstractSlide {

    public ThirtyPlanBSpreadSheetSlide(SlidesData sildeData , SlidePageNameEnum slideEnum, String pageName, Contact contact) {
		super(sildeData, slideEnum, pageName, contact);
    }

//	public ThirtyPlanBSpreadSheetSlide(String writeRange, String pageName, SlideEnum slideEnum,SlidesData slidesData) {
//		super(writeRange, pageName, slideEnum, slidesData);
//		// TODO Auto-generated constructor stub
//	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
