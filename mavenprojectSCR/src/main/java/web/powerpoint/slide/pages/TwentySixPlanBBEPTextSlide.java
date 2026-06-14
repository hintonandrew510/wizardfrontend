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
import web.page.planBBEPPage.PlanBBEPPageModel;
import web.page.planproposedpage.PlanProposedPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class TwentySixPlanBBEPTextSlide extends AbstractSlide {
	private static final Logger mLog = LoggerFactory.getLogger(TwentySixPlanBBEPTextSlide.class.getName());

	public TwentySixPlanBBEPTextSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
	}

	
	

    @Override
    public void populateSlide(XSLFSlide slide) {
         PresentedToPageModel presentedToPageModel = getmSlidesData().getPageModels().getPresentedToPageModel();
       
        	//List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
       // SlideReplacementData clientContactName = new SlideReplacementData("clientContactName", presentedToPageModel.getClientContactName());
        SlideReplacementData clientBusinessName = new SlideReplacementData("clientBusinessName", presentedToPageModel.getClientBusinessName());
        
		
		PlanProposedPageModel planBProposedPageModel = getmSlidesData()
				.getPageModels().getPlanBProposedPageModel();

		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();

		String planAReachStr = withLargeIntegers(planBProposedPageModel.getPlanAReach());
		SlideReplacementData planBCity = new SlideReplacementData("planBCity",
				planBProposedPageModel.getPlanACity());
		SlideReplacementData planBReach = new SlideReplacementData("planBReach",
				planAReachStr);
		SlideReplacementData planBFrequency = new SlideReplacementData("planBFrequency",
				planBProposedPageModel.getPlanAFrequency());
		String planADigitalImpressionsMonthlyStr = withLargeIntegers(planBProposedPageModel.getPlanADigitalImpressionsMonthly());
		SlideReplacementData planBDigitalImpressionsMonthly = new SlideReplacementData("planBDigitalImpressionsMonthly",
				planADigitalImpressionsMonthlyStr);
		SlideReplacementData planBMonthly = new SlideReplacementData("planBMonthly",
				planBProposedPageModel.getPlanAMonthly());
		SlideReplacementData planBDaily = new SlideReplacementData("planBDaily",
				planBProposedPageModel.getPlanADaily());
		listData.add(planBCity);
		listData.add(planBReach);
		listData.add(planBFrequency);
		listData.add(planBDigitalImpressionsMonthly);
		listData.add(planBMonthly);
		listData.add(planBDaily);
                listData.add(clientBusinessName);
                //clientBusinessName
                replaceTextOnSlide(listData, slide);
                
    }

}
