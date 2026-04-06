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


	public List<SlideReplacementData> composeGoogleSlideData() {
		PlanALifetimeValuedPageModel planALifetimeValuedPageModel =  getmSlidesData()
				.getPageModels().getPlanALifetimeValuedPageModel();
		

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		SlideReplacementData averageSale = new SlideReplacementData("a_averageSale",
				planALifetimeValuedPageModel.getAverageSale());
		SlideReplacementData grossProfitMargin = new SlideReplacementData("a_grossProfitMargin",
				planALifetimeValuedPageModel.getGrossProfitMargin() + "%" );
		SlideReplacementData grossProfitPerSale = new SlideReplacementData("a_grossProfitPerSale",
				planALifetimeValuedPageModel.getGrossProfitPerSale() );
		SlideReplacementData averageRepeatSales = new SlideReplacementData("a_averageRepeatSales",
				planALifetimeValuedPageModel.getAverageRepeatSales());
		
		SlideReplacementData averageCustomerValue = new SlideReplacementData("a_averageCustomerValue",
				planALifetimeValuedPageModel.getAverageCustomerValue());
		
		SlideReplacementData yearsOfPatronage = new SlideReplacementData("a_yearsOfPatronage",
				planALifetimeValuedPageModel.getYearsOfPatronage());
		
		SlideReplacementData lifetimeValuePerCustomer = new SlideReplacementData("a_lifetimeValuePerCustomer",
				planALifetimeValuedPageModel.getLifetimeValuePerCustomer());
		
		SlideReplacementData prospectsNeededToBreakEven = new SlideReplacementData("a_prospectsNeededToBreakEven",
				planALifetimeValuedPageModel.getProspectsNeededToBreakEven());
		
		
		listData.add(averageSale);
		//grossProfitMargin = grossProfitMargin + "%";
		listData.add(grossProfitMargin);
		listData.add(grossProfitPerSale);
		listData.add(averageRepeatSales);
		listData.add(averageCustomerValue);
		listData.add(yearsOfPatronage);
		listData.add(lifetimeValuePerCustomer);
		listData.add(prospectsNeededToBreakEven);
		
		//planAGrossProfitOnSales
		//

		
		

		return listData;
	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
