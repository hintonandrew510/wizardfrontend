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
import web.page.planalifetimevaluedpage.PlanALifetimeValuedPageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class TwentyOnePlanALifetimeValuedTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(TwentyOnePlanALifetimeValuedTextSlide.class.getName());

	public TwentyOnePlanALifetimeValuedTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
	}


	
    @Override
    public void populateSlide(XSLFSlide slide) {
                    PlanALifetimeValuedPageModel planALifetimeValuedPageModel =  getmSlidesData()
				.getPageModels().getPlanALifetimeValuedPageModel();
		/*
                    AAver
                    BTime
                    CEqual
                    DTime
                    EEqual  
                    FTime
                    GEqual
                    HSo
                    IThen
                    */

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		SlideReplacementData averageSale = new SlideReplacementData("AAver",
				planALifetimeValuedPageModel.getAverageSale());
		SlideReplacementData grossProfitMargin = new SlideReplacementData("BTime",
				planALifetimeValuedPageModel.getGrossProfitMargin() + "%" );
		SlideReplacementData grossProfitPerSale = new SlideReplacementData("CEqual",
				planALifetimeValuedPageModel.getGrossProfitPerSale() );
		SlideReplacementData averageRepeatSales = new SlideReplacementData("DTime",
				planALifetimeValuedPageModel.getAverageRepeatSales());
		
		SlideReplacementData averageCustomerValue = new SlideReplacementData("EEqual",
				planALifetimeValuedPageModel.getAverageCustomerValue());
		
		SlideReplacementData yearsOfPatronage = new SlideReplacementData("FTime",
				planALifetimeValuedPageModel.getYearsOfPatronage());
		
		SlideReplacementData lifetimeValuePerCustomer = new SlideReplacementData("GEqual",
				planALifetimeValuedPageModel.getLifetimeValuePerCustomer());
		
		SlideReplacementData prospectsNeededToBreakEven = new SlideReplacementData("HSo",
				planALifetimeValuedPageModel.getProspectsNeededToBreakEven());
		
		String planAmonthStr = planALifetimeValuedPageModel.getMonthlyInvestmentAverage();
                SlideReplacementData planAMonth = new SlideReplacementData("IThen",
				planAmonthStr);
		
                
		listData.add(averageSale);
                listData.add(planAMonth);
                listData.add(grossProfitMargin);
		//grossProfitMargin = grossProfitMargin + "%";
		listData.add(grossProfitMargin);
		listData.add(grossProfitPerSale);
		listData.add(averageRepeatSales);
		listData.add(averageCustomerValue);
		listData.add(yearsOfPatronage);
		listData.add(lifetimeValuePerCustomer);
		listData.add(prospectsNeededToBreakEven);
                replaceTextOnSlide(listData, slide);
		
		//planAGrossProfitOnSales
    }

}
