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
import web.page.planbLifetimevaluedpage.PlanBLifetimeValuedPageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class TwentyEightPlanBLifetimeValuedTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(TwentyEightPlanBLifetimeValuedTextSlide.class.getName());

	public TwentyEightPlanBLifetimeValuedTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
	}




    @Override
    public void populateSlide(XSLFSlide slide) {
        PlanBLifetimeValuedPageModel planBLifetimeValuedPageModel =  getmSlidesData()
				.getPageModels().getPlanBLifetimeValuedPageModel();
		

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		SlideReplacementData averageSale = new SlideReplacementData("b_averageSale",
				planBLifetimeValuedPageModel.getAverageSale());
		SlideReplacementData grossProfitMargin = new SlideReplacementData("b_grossProfitMargin",planBLifetimeValuedPageModel.getGrossProfitMargin() + "%");
		SlideReplacementData grossProfitPerSale = new SlideReplacementData("b_grossProfitPerSale",
				planBLifetimeValuedPageModel.getGrossProfitPerSale()  );
		
		//String averageRepeatSalesStr = this.formatStringToCurrency(planBLifetimeValuedPageModel.getAverageRepeatSales());
		String averageRepeatSalesStr = String.valueOf(planBLifetimeValuedPageModel.getAverageRepeatSales());
		
		
		
		SlideReplacementData averageRepeatSales = new SlideReplacementData("b_averageRepeatSales",
				averageRepeatSalesStr);
		
		SlideReplacementData averageCustomerValue = new SlideReplacementData("b_averageCustomerValue",
				planBLifetimeValuedPageModel.getAverageCustomerValue());
		
		SlideReplacementData yearsOfPatronage = new SlideReplacementData("b_yearsOfPatronage",
				planBLifetimeValuedPageModel.getYearsOfPatronage() + "");
		
		SlideReplacementData lifetimeValuePerCustomer = new SlideReplacementData("planBMonthly",
				planBLifetimeValuedPageModel.getLifetimeValuePerCustomer());
		
		SlideReplacementData prospectsNeededToBreakEven = new SlideReplacementData("b_prospectsNeededToBreakEven",
				planBLifetimeValuedPageModel.getProspectsNeededToBreakEven());
		
		
		listData.add(averageSale);
		listData.add(grossProfitMargin);
		listData.add(grossProfitPerSale);
		listData.add(averageRepeatSales);
		listData.add(averageCustomerValue);
		listData.add(yearsOfPatronage);
		listData.add(lifetimeValuePerCustomer);
		listData.add(prospectsNeededToBreakEven);
                 replaceTextOnSlide(listData, slide);
                 mLog.warn("CLASS"+ TwentyEightPlanBLifetimeValuedTextSlide.class.getName());
        this.replaceTextOnSlidePrint(listData, slide);
		
		//planAGrossProfitOnSales
		//

    }
}
