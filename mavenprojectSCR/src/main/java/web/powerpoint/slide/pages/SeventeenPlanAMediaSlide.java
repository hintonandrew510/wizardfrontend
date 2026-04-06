package web.powerpoint.slide.pages;



import org.apache.poi.xslf.usermodel.XSLFSlide;
import web.google.slide.SlidesData;
import web.model.Contact;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class SeventeenPlanAMediaSlide extends AbstractSlide {

    public SeventeenPlanAMediaSlide(SlidesData sildeData , SlidePageNameEnum slideEnum, String pageName, Contact contact) {
		super(sildeData, slideEnum, pageName, contact);
    }

   



//	public SeventeenPlanAMediaSlide(MediaChart mediaChart,  String writeRange,  String pageName,SlideEnum slideEnum) {
//		
//		//super(mediaChart,  writeRange,  pageName, slideEnum);
//		// TODO Auto-generated constructor stub
//	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	


}
