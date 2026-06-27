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

public class TwentyNinePlanBDigitalROICalculatorTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(TwentyNinePlanBDigitalROICalculatorTextSlide.class.getName());

	public TwentyNinePlanBDigitalROICalculatorTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
	}

	

    @Override
    public void populateSlide(XSLFSlide slide) {
        PlanDigitalROICalculatorPageModel pageModel = getmSlidesData()
				.getPageModels().getPlanBDigitalROICalculatorPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

			/*
                




      : text[] 
2026-06-24T14:29:53.339-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[] 
2026-06-24T14:29:53.340-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[] 
2026-06-24T14:29:53.340-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[] 
2026-06-24T14:29:53.340-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[] 
2026-06-24T14:29:53.340-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[] 
2026-06-24T14:29:53.340-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[] 
2026-06-24T14:29:53.341-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[] 
2026-06-24T14:29:53.341-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[ICost] 
2026-06-24T14:29:53.341-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[JProj] 
2026-06-24T14:29:53.341-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[] 
2026-06-24T14:29:53.341-04:00  WARN 6629 --- [web] [nio-8081-exec-5] w.p.s.AbstractSlide                      : text[] 
2026-06-24T14:29:53.341-04:00  CMonth                      : text[MMonth] 


                */
		SlideReplacementData planBMonthlyDigitalInvestment = new SlideReplacementData("AMonth",
				pageModel.getPlanAMonthlyDigitalInvestment());
		
		SlideReplacementData planBCostPerThousand = new SlideReplacementData("BCost",
				pageModel.getPlanACostPerThousand());
		
		String planBClosingPctNumberStr = pageModel.getPlanAClosingPctNumber();
		planBClosingPctNumberStr = this.withLargeIntegers(planBClosingPctNumberStr);
		SlideReplacementData planBClosingPctNumber = new SlideReplacementData("CMonth",
				planBClosingPctNumberStr);
		SlideReplacementData planBClickThroughRate = new SlideReplacementData("DClick",
				pageModel.getPlanAClickThroughRate() + "%");
		
		SlideReplacementData planBMonthlyClicks = new SlideReplacementData("EMonth",
				pageModel.getPlanAMonthlyClicks());
		
		SlideReplacementData planBCostPerClicks = new SlideReplacementData("FCost",
				pageModel.getPlanACostPerClicks());
		
		SlideReplacementData planBSalesConversionPercentage = new SlideReplacementData("GSales",
				pageModel.getPlanASalesConversionPercentage() + "%");
		
		
		SlideReplacementData planBMonthlyConversions = new SlideReplacementData("HMonth",
				pageModel.getPlanAMonthlyConversions());
		
		
		
		SlideReplacementData planBCostPerConversion = new SlideReplacementData("ICost",
				pageModel.getPlanACostPerConversion());
		
		SlideReplacementData planBProjectedGrossProfit = new SlideReplacementData("JProj",
				pageModel.getPlanAProjectedGrossProfit());
		
		SlideReplacementData planBMonthlyGrossProfit = new SlideReplacementData("KMonth",
				pageModel.getPlanAMonthlyGrossProfit());
		
		SlideReplacementData planBMonthlyROID = new SlideReplacementData("LMonth​",
				pageModel.getPlanAMonthlyROID());
		SlideReplacementData planBMonthlyROIP = new SlideReplacementData("MMonth",
				pageModel.getPlanAMonthlyROIP() + "%");
		
                
		
		listData.add(planBMonthlyDigitalInvestment);
		listData.add(planBCostPerThousand);
		listData.add(planBClosingPctNumber);
		listData.add(planBClickThroughRate);
		listData.add(planBMonthlyClicks);
		listData.add(planBCostPerClicks);
		listData.add(planBCostPerConversion);
		listData.add(planBProjectedGrossProfit);
		listData.add(planBMonthlyGrossProfit);
		listData.add(planBMonthlyROID);
		listData.add(planBMonthlyROIP);
		listData.add(planBMonthlyDigitalInvestment);
		listData.add(planBSalesConversionPercentage);
		listData.add(planBMonthlyConversions);
                replaceTextOnSlidePrint(listData, slide);
     replaceTextOnSlide(listData, slide);
               mLog.warn("CLASS"+ TwentyNinePlanBDigitalROICalculatorTextSlide.class.getName());
        this.replaceTextOnSlidePrint(listData, slide);
		
	

    }

}
