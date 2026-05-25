package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
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

public class TwentyNinePlanASpreadSheetTextSlide extends AbstractSlide {

    private static final Logger mLog = LoggerFactory.getLogger(NineteenPlanAProposedTextSlide.class.getName());

    public TwentyNinePlanASpreadSheetTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
    }

    @Override
    public void populateSlide(XSLFSlide slide) {
        PresentedToPageModel presentedToPageModel = getmSlidesData().getPageModels().getPresentedToPageModel();
        PlanMediaPageModel planAMediaPagedataPageModel = getmSlidesData()
                .getPageModels().getPlanAMediaPagedataPageModel();
        PlanSpreadSheets planSpreadSheets = new PlanSpreadSheets(planAMediaPagedataPageModel.getMediaRows(), "TwentyNinePlanASpreadSheetTextSlide", true);

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

        /*
          List<ClientObjectivesOnePageTwoModel> orderList = ClientObjectivesPageHelper.getList(true,
                                clientObjectivesOnePageModel);

                        strategicMarketingPageOneModel = (StrategicMarketingPageOneModel) JSONManager
                                .convertFromJson(data.getPagedata(), StrategicMarketingPageOneModel.class);
                        // model.addAttribute("StrategicMarketingPageOne",
                        // strategicMarketingPageOneModel);

                        publish.setStrategicMarketingPageOne(true);
                        slidesData.getPageModels().setStrategicMarketingPageOneModel(strategicMarketingPageOneModel);

                        List<Object> pageData = new ArrayList<Object>();
                        pageData.add(clientObjectivesOnePageModel);
                        pageData.add(orderList);

                        slidesData.getPageModels().setOrderList(orderList);
         */
        TableHelper.buildTable(planSpreadSheets, slide, this.getPPT());
    }
}
