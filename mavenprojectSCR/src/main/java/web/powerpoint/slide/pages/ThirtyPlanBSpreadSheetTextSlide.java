package web.powerpoint.slide.pages;


import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.model.Contact;
import web.page.planamedipage.PlanMediaPageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class ThirtyPlanBSpreadSheetTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(NineteenPlanAProposedTextSlide.class.getName());

	public ThirtyPlanBSpreadSheetTextSlide(SlidesData sildeData , SlidePageNameEnum slideEnum, String pageName, Contact contact) {
		super(sildeData, slideEnum, pageName, contact);
	}


	public List<SlideReplacementData> composeGoogleSlideData() {
		PlanMediaPageModel planBMediaPagedataPageModel = getmSlidesData()
				.getPageModels().getPlanBMediaPagedataPageModel();
		PlanSpreadSheets planSpreadSheets = new PlanSpreadSheets(planBMediaPagedataPageModel.getMediaRows(),"ThirtyPlanBSpreadSheetTextSlide",true);

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		SlideReplacementData dailyCostB = new SlideReplacementData("dailyCostB",
				planSpreadSheets.getDailyCost());
		SlideReplacementData monthlyAverageB = new SlideReplacementData("monthlyAverageB",
				planSpreadSheets.getMonthlyAverage());
		
		listData.add(dailyCostB);
		listData.add(monthlyAverageB);


		
		

		return listData;
	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
