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
import web.page.planDigitalroicalculatorpage.PlanDigitalROICalculatorPageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class TwentyTwoPlanADigitalROICalculatorTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(TwentyTwoPlanADigitalROICalculatorTextSlide.class.getName());

	public TwentyTwoPlanADigitalROICalculatorTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
	}

	
    @Override
    public void populateSlide(XSLFSlide slide) {
        	PlanDigitalROICalculatorPageModel pageModel = getmSlidesData()
				.getPageModels().getPlanADigitalROICalculatorPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
/*
                
                
                



GSales​




LMonth​
MMonth
                */
			
		SlideReplacementData planAMonthlyDigitalInvestment = new SlideReplacementData("AMonth",
				pageModel.getPlanAMonthlyDigitalInvestment());
		
		SlideReplacementData planACostPerThousand = new SlideReplacementData("BCost",
				pageModel.getPlanACostPerThousand());
		
		String planAClosingPctNumberStr = pageModel.getPlanAClosingPctNumber();
		
		planAClosingPctNumberStr = this.withLargeIntegers(planAClosingPctNumberStr);
		mLog.info("planAClosingPctNumberStr " + planAClosingPctNumberStr);
		SlideReplacementData planAClosingPctNumber = new SlideReplacementData("CMonth​",
				planAClosingPctNumberStr);
		SlideReplacementData planAClickThroughRate = new SlideReplacementData("DClick​",
				pageModel.getPlanAClickThroughRate() + "%");
		
		SlideReplacementData planAMonthlyClicks = new SlideReplacementData("EMonth​",
				pageModel.getPlanAMonthlyClicks());
		
		SlideReplacementData planACostPerClicks = new SlideReplacementData("FCost​",
				pageModel.getPlanACostPerClicks());
		
		SlideReplacementData planASalesConversionPercentage = new SlideReplacementData("GSales​",
				pageModel.getPlanASalesConversionPercentage() + "%");
		
		
		SlideReplacementData planAMonthlyConversions = new SlideReplacementData("HMonth​",
				pageModel.getPlanAMonthlyConversions());
		
		
		
		SlideReplacementData planACostPerConversion = new SlideReplacementData("ICost​",
				pageModel.getPlanACostPerConversion());
		
		SlideReplacementData planAProjectedGrossProfit = new SlideReplacementData("hI",
				pageModel.getPlanAProjectedGrossProfit());
		
		SlideReplacementData planAMonthlyGrossProfit = new SlideReplacementData("JProj​",
				pageModel.getPlanAMonthlyGrossProfit());
		
		SlideReplacementData planAMonthlyROID = new SlideReplacementData("KMonth​",
				pageModel.getPlanAMonthlyROID());
		SlideReplacementData planAMonthlyROIP = new SlideReplacementData("MMonth",
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
                replaceTextOnSlide(listData, slide);
    }

}
