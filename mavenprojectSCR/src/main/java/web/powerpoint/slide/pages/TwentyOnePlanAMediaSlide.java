/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.google.slide.SlidesData;
import web.model.Contact;
import web.page.PieChart;
import web.page.planamedipage.MediaChart;
import web.page.planamedipage.MediaChartHelper;
import web.page.planamedipage.PlanMediaPageModel;
import web.powerpoint.entity.BarChartDataEntity;
import web.powerpoint.entity.BarChartEntity;
import web.powerpoint.entity.PieEntity;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;
import web.powerpoint.slide.helper.PieChartWithPercentageHelper;
import web.powerpoint.slide.helper.ReplaceImageInPlaceholderHelper;
import web.powerpoint.slide.service.PowerPointServiceImpl;

/**
 *
 * @author andrewhinton
 */
public class TwentyOnePlanAMediaSlide extends AbstractSlide {

     private Logger mLog = LoggerFactory.getLogger(PowerPointServiceImpl.class.getName());

    public TwentyOnePlanAMediaSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
    }

  

  @Override
    public void populateSlide(XSLFSlide slide) {
        //this.getSlideEnum().EightConfidentialClientEvaluationOneSlide.d
        String name = this.getSlideEnumName();
        List<PieChart> piechart = getmSlidesData().getPageModels().getPieChartConfidentialClientEvaluationProposed();
        PlanMediaPageModel planAMediaPagedataPageModel = getmSlidesData().getPageModels().getPlanAMediaPagedataPageModel();
         MediaChart mediaChartA = MediaChartHelper.generate(planAMediaPagedataPageModel);
        
        //slidesData.getPageModels().setPlanAMediaPagedataPageModel(planAMediaPagedataPageModel);
        
        List<BarChartDataEntity> barChartDataEntityList = new ArrayList<>();
        BarChartDataEntity barChartDataEntity = BarChartDataEntity.builder()
                .columnKey("Jan").rowKey("rowkey").doubleValue(10).build();
         BarChartDataEntity barChartDataEntitytwo = BarChartDataEntity.builder()
                .columnKey("feb").rowKey("rowkeyd").doubleValue(20).build();
           BarChartDataEntity barChartDataEntitythree = BarChartDataEntity.builder()
                .columnKey("mar").rowKey("rowkeyd").doubleValue(30).build();
         barChartDataEntityList.add(barChartDataEntity);
         
         
          barChartDataEntityList.add(barChartDataEntitytwo);
           barChartDataEntityList.add(barChartDataEntitythree);
        
      BarChartEntity barChartEntity = BarChartEntity.builder()
              .fileName("aah")
              .bottomTitle("bottom")
              .topTitle("top")
              .xAxis("xaxis")
              .yAxis("yaxis").barChartDataEntityList(barChartDataEntityList).build();
        
        
        
        
        

        PieEntity pieEntity = new PieEntity();
        pieEntity.setPieChartList(piechart);
        pieEntity.setTitle("Proposed Year’s Media Allocation");
        String fileaName = this.getContact().getName() + this.getPageName();
        pieEntity.setFileName(fileaName);
        fileaName = PieChartWithPercentageHelper.createPieChart(pieEntity);

        try {
            ReplaceImageInPlaceholderHelper.replaceImageInSlide(this.getPPT(), fileaName, slide);

            //
        } catch (Exception ex) {
            mLog.error(ex.getMessage());
        }

    }

}

