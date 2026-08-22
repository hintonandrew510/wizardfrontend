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
                
                
                : text[AMonth] 
2026-06-24T12:25:24.750-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[BCost] 
2026-06-24T12:25:24.750-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[CMonth] 
2026-06-24T12:25:24.751-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[DClick] 
2026-06-24T12:25:24.751-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[EMonth] 
2026-06-24T12:25:24.751-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[FCost] 
2026-06-24T12:25:24.751-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[GSales] 
2026-06-24T12:25:24.751-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[HMonth] 
2026-06-24T12:25:24.751-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[ICost] 
2026-06-24T12:25:24.752-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[JProj] 
2026-06-24T12:25:24.752-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[KMonth] 
2026-06-24T12:25:24.752-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[LMonth] 
2026-06-24T12:25:24.752-04:00  WARN 6148 --- [web] [nio-8081-exec-2] w.p.s.AbstractSlide                      : text[MMonth] 




         */

        SlideReplacementData planAMonthlyDigitalInvestment = new SlideReplacementData("AMonth",
                pageModel.getPlanAMonthlyDigitalInvestment());

        SlideReplacementData planACostPerThousand = new SlideReplacementData("BCost",
                pageModel.getPlanACostPerThousand());

        String planAClosingPctNumberStr = pageModel.getPlanAClosingPctNumber();

        planAClosingPctNumberStr = this.withLargeIntegers(planAClosingPctNumberStr);
        mLog.info("planAClosingPctNumberStr " + planAClosingPctNumberStr);
        //CMonth
        SlideReplacementData planAClosingPctNumber = new SlideReplacementData("CMonth",
                planAClosingPctNumberStr);
        SlideReplacementData planAClickThroughRate = new SlideReplacementData("DClick",
                pageModel.getPlanAClickThroughRate() + "%");

        SlideReplacementData planAMonthlyClicks = new SlideReplacementData("EMonth",
                pageModel.getPlanAMonthlyClicks());

        SlideReplacementData planACostPerClicks = new SlideReplacementData("FCost",
                pageModel.getPlanACostPerClicks());

        SlideReplacementData planASalesConversionPercentage = new SlideReplacementData("GSales",
                pageModel.getPlanASalesConversionPercentage() + "%");

        SlideReplacementData planAMonthlyConversions = new SlideReplacementData("HMonth",
                pageModel.getPlanAMonthlyConversions());

        SlideReplacementData planACostPerConversion = new SlideReplacementData("ICost",
                pageModel.getPlanACostPerConversion());

        SlideReplacementData planAProjectedGrossProfit = new SlideReplacementData("hI",
                pageModel.getPlanAProjectedGrossProfit());

        SlideReplacementData planAMonthlyGrossProfit = new SlideReplacementData("JProj",
                pageModel.getPlanAMonthlyGrossProfit());

        SlideReplacementData planAMonthlyROID = new SlideReplacementData("KMonth",
                pageModel.getPlanAMonthlyROID());
        SlideReplacementData planAMonthlyROIP = new SlideReplacementData("LMonth",
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
       // replaceTextOnSlidePrint(listData, slide);
        replaceTextOnSlide(listData, slide);
    }

}
