package web.powerpoint.slide.pages;


import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.springframework.beans.factory.annotation.Autowired;


import web.google.slide.SlidesData;
import web.model.Contact;
import web.page.PieChart;
import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;
import web.powerpoint.slide.service.PieChartWithPercentageService;

public class EightConfidentialClientEvaluationOneTextSlide extends AbstractSlide {
    @Autowired
    PieChartWithPercentageService pieChartWithPercentageService;
	public EightConfidentialClientEvaluationOneTextSlide(SlidesData sildeData , SlidePageNameEnum slideEnum, String pageName, Contact contact) {
		super(sildeData, slideEnum, pageName, contact);
	}

    @Override
    public void populateSlide(XSLFSlide slide) {
       //this.getSlideEnum().EightConfidentialClientEvaluationOneSlide.d
       String name = this.getSlideEnumName();
       List<PieChart> piechart = getmSlidesData().getPageModels().getPieChartConfidentialClientEvaluationOnePage();
       
       
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	
	
}
