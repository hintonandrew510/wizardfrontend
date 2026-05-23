/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.pages;

import java.util.List;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.google.slide.SlidesData;
import web.model.Contact;
import web.page.planamedipage.PlanMediaPageModel;
import web.powerpoint.ReadPowerPointSlides;
import web.powerpoint.entity.BarChartDataEntity;
import web.powerpoint.entity.BarChartEntity;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;
import web.powerpoint.slide.helper.ReplaceImageInPlaceholderHelper;

/**
 *
 * @author andrewhinton
 */
public class TwentyOnePlanAMediaSlide extends AbstractSlide {

    private Logger mLog = LoggerFactory.getLogger(TwentyOnePlanAMediaSlide.class.getName());

    public TwentyOnePlanAMediaSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
    }

    @Override
    public void populateSlide(XSLFSlide slide) {
        //this.getSlideEnum().EightConfidentialClientEvaluationOneSlide.d
        String name = this.getSlideEnumName();

        PlanMediaPageModel planAMediaPagedataPageModel = getmSlidesData().getPageModels().getPlanAMediaPagedataPageModel();
        List<BarChartDataEntity> barChartDataEntityList = web.powerpoint.slide.helper.BarChartHelper.convert(planAMediaPagedataPageModel);

        //slidesData.getPageModels().setPlanAMediaPagedataPageModel(planAMediaPagedataPageModel);
       
        String fileaName = this.getContact().getName() + this.getPageName();

        BarChartEntity barChartEntity = BarChartEntity.builder()
                .fileName(fileaName)
                .bottomTitle("bottom")
                .topTitle("top")
                .xAxis("xaxis")
                .yAxis("yaxis").barChartDataEntityList(barChartDataEntityList).build();

        try {
            //Proposed Schedule – Plan A
            //
            String fileName = web.powerpoint.slide.helper.BarChartHelper.createBarChart(barChartEntity);
            ReplaceImageInPlaceholderHelper.replaceImageInSlide(this.getPPT(), fileName, slide);
            ReadPowerPointSlides.display(slide);

        } catch (Exception ex) {
            mLog.error(ex.getMessage());

        }

    }

}
