package web.powerpoint.slide.pages;


import java.util.List;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.springframework.beans.factory.annotation.Autowired;


import web.google.slide.SlidesData;
import web.model.Contact;
import web.page.PieChart;
import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;
import web.powerpoint.entity.PieEntity;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;
import web.powerpoint.slide.service.PieChartWithPercentageService;
import web.powerpoint.slide.service.ReplaceImageInPlaceholderService;

public class EightConfidentialClientEvaluationOneTextSlide extends AbstractSlide {
    @Autowired
    private PieChartWithPercentageService pieChartWithPercentageService;
    @Autowired
     ReplaceImageInPlaceholderService replaceImageInPlaceholderService;
    
	public EightConfidentialClientEvaluationOneTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
	}

    @Override
    public void populateSlide(XSLFSlide slide) {
       //this.getSlideEnum().EightConfidentialClientEvaluationOneSlide.d
       String name = this.getSlideEnumName();
       List<PieChart> piechart = getmSlidesData().getPageModels().getPieChartConfidentialClientEvaluationOnePage();
       PieEntity pieEntity = new PieEntity();
       pieEntity.setPieChartList(piechart);
       pieEntity.setTitle("Previous Year’s Media Allocation");
       String fileaName = this.getContact().getName() + this.getPageName();
       pieEntity.setFileName(fileaName);
       pieChartWithPercentageService.createPieChart(pieEntity);
      // replaceImageInPlaceholderService.replaceImageInSlide(ppt, fileaName, slide);
       
      //

       
       
       
       
    }
	
	
}
