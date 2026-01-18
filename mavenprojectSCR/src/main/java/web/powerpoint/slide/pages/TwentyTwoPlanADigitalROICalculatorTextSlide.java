package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.planDigitalroicalculatorpage.PlanDigitalROICalculatorPageModel;
import web.powerpoint.slide.AbstractSlide;

public class TwentyTwoPlanADigitalROICalculatorTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(TwentyTwoPlanADigitalROICalculatorTextSlide.class.getName());

	public TwentyTwoPlanADigitalROICalculatorTextSlide(SlidesData sildeData, SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}

	
	public List<SlideReplacementData> composeGoogleSlideData() {
		
		PlanDigitalROICalculatorPageModel pageModel = getmSlidesData()
				.getPageModels().getPlanADigitalROICalculatorPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

			
		SlideReplacementData planAMonthlyDigitalInvestment = new SlideReplacementData("planAMonthlyDigitalInvestment",
				pageModel.getPlanAMonthlyDigitalInvestment());
		
		SlideReplacementData planACostPerThousand = new SlideReplacementData("planACostPerThousand",
				pageModel.getPlanACostPerThousand());
		
		String planAClosingPctNumberStr = pageModel.getPlanAClosingPctNumber();
		
		planAClosingPctNumberStr = this.withLargeIntegers(planAClosingPctNumberStr);
		mLog.info("planAClosingPctNumberStr " + planAClosingPctNumberStr);
		SlideReplacementData planAClosingPctNumber = new SlideReplacementData("planAClosingPctNumber",
				planAClosingPctNumberStr);
		SlideReplacementData planAClickThroughRate = new SlideReplacementData("planAClickThroughRate",
				pageModel.getPlanAClickThroughRate() + "%");
		
		SlideReplacementData planAMonthlyClicks = new SlideReplacementData("planAMonthlyClicks",
				pageModel.getPlanAMonthlyClicks());
		
		SlideReplacementData planACostPerClicks = new SlideReplacementData("planACostPerClicks",
				pageModel.getPlanACostPerClicks());
		
		SlideReplacementData planASalesConversionPercentage = new SlideReplacementData("planASalesConversionPercentage",
				pageModel.getPlanASalesConversionPercentage() + "%");
		
		
		SlideReplacementData planAMonthlyConversions = new SlideReplacementData("planAMonthlyConversions",
				pageModel.getPlanAMonthlyConversions());
		
		
		
		SlideReplacementData planACostPerConversion = new SlideReplacementData("planACostPerConversion",
				pageModel.getPlanACostPerConversion());
		
		SlideReplacementData planAProjectedGrossProfit = new SlideReplacementData("planAProjectedGrossProfit",
				pageModel.getPlanAProjectedGrossProfit());
		
		SlideReplacementData planAMonthlyGrossProfit = new SlideReplacementData("planAMonthlyGrossProfit",
				pageModel.getPlanAMonthlyGrossProfit());
		
		SlideReplacementData planAMonthlyROID = new SlideReplacementData("planAMonthlyROID",
				pageModel.getPlanAMonthlyROID());
		SlideReplacementData planAMonthlyROIP = new SlideReplacementData("planAMonthlyROIP",
				pageModel.getPlanAMonthlyROIP() + "%");
		
		
		listData.add(planAMonthlyDigitalInvestment);
		listData.add(planACostPerThousand);
		listData.add(planAClosingPctNumber);
		listData.add(planAClickThroughRate);
		listData.add(planAMonthlyClicks);
		listData.add(planACostPerClicks);
		listData.add(planACostPerConversion);
		listData.add(planAProjectedGrossProfit);
		listData.add(planAMonthlyGrossProfit);
		listData.add(planAMonthlyROID);
		listData.add(planAMonthlyROIP);
		listData.add(planAMonthlyDigitalInvestment);
		listData.add(planASalesConversionPercentage);
		listData.add(planAMonthlyConversions);
		
		
		
		
		//planAGrossProfitOnSales
		//

		
		

		return listData;
	}

    @Override
    public void populateSlide(XSLFSlide slide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
