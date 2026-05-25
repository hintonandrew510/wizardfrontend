package web.powerpoint.slide.pages;


import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.model.Contact;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageTwoModel;
import web.page.planamedipage.PlanMediaPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;
import web.powerpoint.slide.helper.TableHelper;

public class ThirtyPlanBSpreadSheetSlide extends AbstractSlide {
 private static final Logger mLog = LoggerFactory.getLogger(ThirtyPlanBSpreadSheetSlide.class.getName());

    public ThirtyPlanBSpreadSheetSlide(SlidesData sildeData , SlidePageNameEnum slideEnum, String pageName, Contact contact) {
		super(sildeData, slideEnum, pageName, contact, null);
    }
    
    /*
              ThirtyPlanBSpreadSheetSlide thirtyPlanBSpreadSheetSlide = new ThirtyPlanBSpreadSheetSlide(
                     SlidePageNameEnum.ThirtyPlanBSpreadSheetTextSlide, "ThirtyPlanBSpreadSheetSlide", slidesData, contact);

    
    */

//	public ThirtyPlanBSpreadSheetSlide(String writeRange, String pageName, SlideEnum slideEnum,SlidesData slidesData) {
//		super(writeRange, pageName, slideEnum, slidesData);
//		// TODO Auto-generated constructor stub
//	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        PresentedToPageModel presentedToPageModel = getmSlidesData().getPageModels().getPresentedToPageModel();
        PlanMediaPageModel planBMediaPagedataPageModel = getmSlidesData()
                .getPageModels().getPlanBMediaPagedataPageModel();
        PlanSpreadSheets planSpreadSheets = new PlanSpreadSheets(planBMediaPagedataPageModel.getMediaRows(), "TwentyNinePlanASpreadSheetTextSlide", true);

        List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

        SlideReplacementData dailyCostA = new SlideReplacementData("dailyCostA",
                planSpreadSheets.getDailyCost());
        SlideReplacementData monthlyAverageA = new SlideReplacementData("monthlyAverageA",
                planSpreadSheets.getMonthlyAverage());
        SlideReplacementData station = new SlideReplacementData("station", presentedToPageModel.getStation());
        SlideReplacementData businessname = new SlideReplacementData("businessname", presentedToPageModel.getClientBusinessName());

        List<ClientObjectivesOnePageTwoModel> orderList = getmSlidesData().getPageModels().getOrderList();
        String firstRow = "";
        String secondRow = "";
        String thirdRow = "";
        if (orderList != null && !orderList.isEmpty()) {
            if (orderList.get(0) != null) {
                ClientObjectivesOnePageTwoModel clientObjectivesOnePageTwoModel = orderList.get(0);
                firstRow = clientObjectivesOnePageTwoModel.getLabel();
            }
            if (orderList.get(1) != null) {
                ClientObjectivesOnePageTwoModel clientObjectivesOnePageTwoModel = orderList.get(1);
                secondRow = clientObjectivesOnePageTwoModel.getLabel();
            }
            if (orderList.get(2) != null) {
                ClientObjectivesOnePageTwoModel clientObjectivesOnePageTwoModel = orderList.get(2);
                thirdRow = clientObjectivesOnePageTwoModel.getLabel();
            }

        }
        
        
         SlideReplacementData firstRowData = new SlideReplacementData("firstRow",
                firstRow);
         SlideReplacementData secondRowData = new SlideReplacementData("secondRow",
                secondRow);
           SlideReplacementData thirdRowData = new SlideReplacementData("thirdRow",
                thirdRow);
         
        listData.add(firstRowData);
        listData.add(secondRowData);
        listData.add(thirdRowData);
        
        
        
        
        
        listData.add(dailyCostA);
        listData.add(station);
        listData.add(monthlyAverageA);
        listData.add(businessname);
        replaceTextOnSlide(listData, slide);

        TableHelper.buildTable(planSpreadSheets, slide, this.getPPT());
    }
}
