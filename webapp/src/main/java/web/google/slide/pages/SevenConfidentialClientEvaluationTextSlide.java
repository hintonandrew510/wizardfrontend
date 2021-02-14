package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.confidentialclientevaluationnonepage.ConfidentialClientEvaluationOnePageModel;
import web.page.planamedipage.MediaChart;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;

public class SevenConfidentialClientEvaluationTextSlide extends AbstractSlide {
	public SevenConfidentialClientEvaluationTextSlide(SlidesData sildeData , SlideEnum slideEnum) {
		super(sildeData, slideEnum);
	}
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		ConfidentialClientEvaluationOnePageModel confidentialClientEvaluationOnePageModel = getmSlidesData().getPageModels().getConfidentialClientEvaluationOnePageModel();
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		String lastYearLabel1Str = confidentialClientEvaluationOnePageModel.getLastYearLabel1() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearLabel1(); 
		SlideReplacementData lastYearLabel1 = new SlideReplacementData("lastYearLabel1", lastYearLabel1Str);
		String lastYearValue1Str = confidentialClientEvaluationOnePageModel.getLastYearValue1() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue1(); 
		SlideReplacementData lastYearValue1 = new SlideReplacementData("lastYearValue1", lastYearValue1Str);
		
		String lastYearLabel2Str = confidentialClientEvaluationOnePageModel.getLastYearLabel2() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearLabel2(); 
		SlideReplacementData lastYearLabel2 = new SlideReplacementData("lastYearLabel2", lastYearLabel2Str);
		String lastYearValue2Str = confidentialClientEvaluationOnePageModel.getLastYearValue2() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue2(); 
		SlideReplacementData lastYearValue2 = new SlideReplacementData("lastYearValue2", lastYearValue2Str);
		
		String lastYearLabel3Str = confidentialClientEvaluationOnePageModel.getLastYearLabel3() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearLabel3(); 
		SlideReplacementData lastYearLabel3 = new SlideReplacementData("lastYearLabel3", lastYearLabel3Str);
		String lastYearValue3Str = confidentialClientEvaluationOnePageModel.getLastYearValue3() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue3(); 
		SlideReplacementData lastYearValue3 = new SlideReplacementData("lastYearValue2", lastYearValue3Str);
		
		
		String lastYearLabel4Str = confidentialClientEvaluationOnePageModel.getLastYearLabel4() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearLabel4(); 
		SlideReplacementData lastYearLabel4 = new SlideReplacementData("lastYearLabel3", lastYearLabel4Str);
		String lastYearValue4Str = confidentialClientEvaluationOnePageModel.getLastYearValue4() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue4(); 
		SlideReplacementData lastYearValue4 = new SlideReplacementData("lastYearValue2", lastYearValue4Str);
		
		String lastYearLabel5Str = confidentialClientEvaluationOnePageModel.getLastYearLabel5() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearLabel5(); 
		SlideReplacementData lastYearLabel5 = new SlideReplacementData("lastYearLabel3", lastYearLabel5Str);
		String lastYearValue5Str = confidentialClientEvaluationOnePageModel.getLastYearValue5() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue5(); 
		SlideReplacementData lastYearValue5 = new SlideReplacementData("lastYearValue5", lastYearValue5Str);
		
		
		
		
		
		
		
		//SlideReplacementData sellingAdvantages = new SlideReplacementData("sellingAdvantages", strategicMarketingPageOneModel.getSellingAdvantages());
		listData.add(lastYearLabel1);
		listData.add(lastYearValue1);
		listData.add(lastYearLabel2);
		listData.add(lastYearValue2);
		listData.add(lastYearLabel3);
		listData.add(lastYearValue3);
		listData.add(lastYearLabel4);
		listData.add(lastYearValue4);
		listData.add(lastYearLabel5);
		listData.add(lastYearValue5);
		//listData.add(sellingAdvantages);
		return listData;
	}
	
	
}
