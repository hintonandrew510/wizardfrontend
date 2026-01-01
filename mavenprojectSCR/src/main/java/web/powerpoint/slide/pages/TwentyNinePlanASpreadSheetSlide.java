package web.powerpoint.slide.pages;


import org.apache.poi.xslf.usermodel.XSLFSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlidesData;
import web.powerpoint.slide.AbstractSlide;

public class TwentyNinePlanASpreadSheetSlide extends AbstractSlide {

    public TwentyNinePlanASpreadSheetSlide(String pageName, String planASpreadSheet, SlideEnum slideEnum, SlidesData slidesData) {
        super(slidesData, slideEnum, pageName);
    }

//	public TwentyNinePlanASpreadSheetSlide(String writeRange, String pageName, SlideEnum slideEnum,SlidesData slidesData) {
//		super(writeRange, pageName, slideEnum, slidesData);
//		// TODO Auto-generated constructor stub
//	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
