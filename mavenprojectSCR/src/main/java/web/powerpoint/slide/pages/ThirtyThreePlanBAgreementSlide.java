package web.powerpoint.slide.pages;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

public class ThirtyThreePlanBAgreementSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(NineteenPlanAProposedTextSlide.class.getName());

	public ThirtyThreePlanBAgreementSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
	}


	
     @Override
    public void populateSlide(XSLFSlide slide) {
        PresentedToPageModel presentedToPageModel = getmSlidesData().getPageModels().getPresentedToPageModel();
        PlanMediaPageModel planBMediaPagedataPageModel = getmSlidesData()
                .getPageModels().getPlanBMediaPagedataPageModel();
        PlanSpreadSheets planSpreadSheets = new PlanSpreadSheets(planBMediaPagedataPageModel.getMediaRows(), "TwentyNinePlanASpreadSheetTextSlide", true);

        List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

        SlideReplacementData dailyCostA = new SlideReplacementData("dailyAver",
                planSpreadSheets.getDailyCost());
        SlideReplacementData monthlyAverageA = new SlideReplacementData("monthAver",
                planSpreadSheets.getMonthlyAverage());
        SlideReplacementData station = new SlideReplacementData("station", presentedToPageModel.getStation());
        SlideReplacementData businessname = new SlideReplacementData("businessname", presentedToPageModel.getClientBusinessName());

        List<ClientObjectivesOnePageTwoModel> orderList = getmSlidesData().getPageModels().getOrderList();
         orderList.sort(Comparator.comparing(ClientObjectivesOnePageTwoModel::getSortOrder).reversed());
        //Collections.sort(orderList, (o1, o2) -> o1.getSortOrder().compareTo(o2.getSortOrder()));
        //Collections.sort(orderList, (o1, o2) -> o1.getSortOrder().compareTo(o2.getSortOrder()));
      

  
        listData.add(dailyCostA);
        listData.add(station);
        listData.add(monthlyAverageA);
        listData.add(businessname);
        replaceTextOnSlide(listData, slide);

        
    }
}
