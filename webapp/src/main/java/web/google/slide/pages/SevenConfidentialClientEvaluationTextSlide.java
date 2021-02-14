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
		SlideReplacementData lastYearLabel4 = new SlideReplacementData("lastYearLabel4", lastYearLabel4Str);
		String lastYearValue4Str = confidentialClientEvaluationOnePageModel.getLastYearValue4() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue4(); 
		SlideReplacementData lastYearValue4 = new SlideReplacementData("lastYearValue4", lastYearValue4Str);
		
		String lastYearLabel5Str = confidentialClientEvaluationOnePageModel.getLastYearLabel5() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearLabel5(); 
		SlideReplacementData lastYearLabel5 = new SlideReplacementData("lastYearLabel5", lastYearLabel5Str);
		String lastYearValue5Str = confidentialClientEvaluationOnePageModel.getLastYearValue5() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue5(); 
		SlideReplacementData lastYearValue5 = new SlideReplacementData("lastYearValue5", lastYearValue5Str);
		
		
		String lastYearLabel6Str = confidentialClientEvaluationOnePageModel.getLastYearLabel6() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearLabel6(); 
		SlideReplacementData lastYearLabel6 = new SlideReplacementData("lastYearLabel6", lastYearLabel6Str);
		String lastYearValue6Str = confidentialClientEvaluationOnePageModel.getLastYearValue6() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue6(); 
		SlideReplacementData lastYearValue6 = new SlideReplacementData("lastYearValue6", lastYearValue6Str);
		
		String lastYearLabel7Str = confidentialClientEvaluationOnePageModel.getLastYearLabel7() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearLabel7(); 
		SlideReplacementData lastYearLabel7 = new SlideReplacementData("lastYearLabel7", lastYearLabel7Str);
		String lastYearValue7Str = confidentialClientEvaluationOnePageModel.getLastYearValue7() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue7(); 
		SlideReplacementData lastYearValue7 = new SlideReplacementData("lastYearValue7", lastYearValue7Str);
		
		
		String lastYearLabel8Str = confidentialClientEvaluationOnePageModel.getLastYearLabel8() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearLabel8(); 
		SlideReplacementData lastYearLabel8 = new SlideReplacementData("lastYearLabel8", lastYearLabel8Str);
		String lastYearValue8Str = confidentialClientEvaluationOnePageModel.getLastYearValue8() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue8(); 
		SlideReplacementData lastYearValue8 = new SlideReplacementData("lastYearValue8", lastYearValue8Str);
		
		String lastYearLabel9Str = confidentialClientEvaluationOnePageModel.getLastYearLabel9() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearLabel9(); 
		SlideReplacementData lastYearLabel9 = new SlideReplacementData("lastYearLabel9", lastYearLabel9Str);
		String lastYearValue9Str = confidentialClientEvaluationOnePageModel.getLastYearValue9() == null ? "" : confidentialClientEvaluationOnePageModel.getLastYearValue9(); 
		SlideReplacementData lastYearValue9 = new SlideReplacementData("lastYearValue9", lastYearValue9Str);
		SlideReplacementData totalMediaInvestment = new SlideReplacementData("totalMediaInvestment", confidentialClientEvaluationOnePageModel.getTotalMediaInvestment());
		
		
String proposedLabel1Str = confidentialClientEvaluationOnePageModel.getProposedLabel1() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedLabel1(); 
		
		SlideReplacementData proposedLabel1 = new SlideReplacementData("proposedLabel1", proposedLabel1Str);
		String proposedValue1Str = confidentialClientEvaluationOnePageModel.getProposedValue1() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedValue1(); 
		SlideReplacementData proposedValue1 = new SlideReplacementData("proposedValue1", proposedValue1Str);
		
		String proposedLabel2Str = confidentialClientEvaluationOnePageModel.getProposedLabel2() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedLabel2(); 
		SlideReplacementData proposedLabel2 = new SlideReplacementData("proposedLabel2", proposedLabel2Str);
		String proposedValue2Str = confidentialClientEvaluationOnePageModel.getProposedValue2() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedValue2(); 
		SlideReplacementData proposedValue2 = new SlideReplacementData("proposedValue2", proposedValue2Str);
		
		String proposedLabel3Str = confidentialClientEvaluationOnePageModel.getProposedLabel3() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedLabel3(); 
		SlideReplacementData proposedLabel3 = new SlideReplacementData("proposedLabel3", proposedLabel3Str);
		String proposedValue3Str = confidentialClientEvaluationOnePageModel.getProposedValue3() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedValue3(); 
		SlideReplacementData proposedValue3 = new SlideReplacementData("proposedValue2", proposedValue3Str);
		
		
		String proposedLabel4Str = confidentialClientEvaluationOnePageModel.getProposedLabel4() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedLabel4(); 
		SlideReplacementData proposedLabel4 = new SlideReplacementData("proposedLabel4", proposedLabel4Str);
		String proposedValue4Str = confidentialClientEvaluationOnePageModel.getProposedValue4() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedValue4(); 
		SlideReplacementData proposedValue4 = new SlideReplacementData("proposedValue4", proposedValue4Str);
		
		String proposedLabel5Str = confidentialClientEvaluationOnePageModel.getProposedLabel5() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedLabel5(); 
		SlideReplacementData proposedLabel5 = new SlideReplacementData("proposedLabel5", proposedLabel5Str);
		String proposedValue5Str = confidentialClientEvaluationOnePageModel.getProposedValue5() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedValue5(); 
		SlideReplacementData proposedValue5 = new SlideReplacementData("proposedValue5", proposedValue5Str);
		
		
		String proposedLabel6Str = confidentialClientEvaluationOnePageModel.getProposedLabel6() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedLabel6(); 
		SlideReplacementData proposedLabel6 = new SlideReplacementData("proposedLabel6", proposedLabel6Str);
		String proposedValue6Str = confidentialClientEvaluationOnePageModel.getProposedValue6() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedValue6(); 
		SlideReplacementData proposedValue6 = new SlideReplacementData("proposedValue6", proposedValue6Str);
		
		String proposedLabel7Str = confidentialClientEvaluationOnePageModel.getProposedLabel7() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedLabel7(); 
		SlideReplacementData proposedLabel7 = new SlideReplacementData("proposedLabel7", proposedLabel7Str);
		String proposedValue7Str = confidentialClientEvaluationOnePageModel.getProposedValue7() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedValue7(); 
		SlideReplacementData proposedValue7 = new SlideReplacementData("proposedValue7", proposedValue7Str);
		
		
		String proposedLabel8Str = confidentialClientEvaluationOnePageModel.getProposedLabel8() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedLabel8(); 
		SlideReplacementData proposedLabel8 = new SlideReplacementData("proposedLabel8", proposedLabel8Str);
		String proposedValue8Str = confidentialClientEvaluationOnePageModel.getProposedValue8() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedValue8(); 
		SlideReplacementData proposedValue8 = new SlideReplacementData("proposedValue8", proposedValue8Str);
		
		String proposedLabel9Str = confidentialClientEvaluationOnePageModel.getProposedLabel9() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedLabel9(); 
		SlideReplacementData proposedLabel9 = new SlideReplacementData("proposedLabel9", proposedLabel9Str);
		String proposedValue9Str = confidentialClientEvaluationOnePageModel.getProposedValue9() == null ? "" : confidentialClientEvaluationOnePageModel.getProposedValue9(); 
		SlideReplacementData proposedValue9 = new SlideReplacementData("proposedValue9", proposedValue9Str);
		SlideReplacementData totalMediaInvestmentTwo = new SlideReplacementData("totalMediaInvestmentTwo", confidentialClientEvaluationOnePageModel.getTotalMediaInvestment());
		
		SlideReplacementData taiNext12Months = new SlideReplacementData("taiNext12Months", confidentialClientEvaluationOnePageModel.getTaiNext12Months());
		String pctGrossSalesStr = confidentialClientEvaluationOnePageModel.getPctGrossSales() + "%";
		SlideReplacementData pctGrossSales = new SlideReplacementData("pctGrossSales", pctGrossSalesStr);
		SlideReplacementData estimatedGrossSalesNext12Months = new SlideReplacementData("estimatedGrossSalesNext12Months", confidentialClientEvaluationOnePageModel.getEstimatedGrossSalesNext12Months());
		SlideReplacementData taiShouldBe = new SlideReplacementData("taiShouldBe", confidentialClientEvaluationOnePageModel.getTaiShouldBe());
		String industryAverageStr = confidentialClientEvaluationOnePageModel.getIndustryAverage() + "%";
		SlideReplacementData industryAverage = new SlideReplacementData("industryAverage", industryAverageStr);
		SlideReplacementData salesGoals = new SlideReplacementData("salesGoals", confidentialClientEvaluationOnePageModel.getSalesGoals());
		
		listData.add(taiNext12Months);
		listData.add(pctGrossSales);
		listData.add(estimatedGrossSalesNext12Months);
		listData.add(industryAverage);
		listData.add(taiShouldBe);
		listData.add(salesGoals);
			
		
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
		listData.add(lastYearLabel6);
		listData.add(lastYearValue6);
		listData.add(lastYearLabel7);
		listData.add(lastYearValue7);
		listData.add(lastYearLabel8);
		listData.add(lastYearValue8);
		listData.add(lastYearLabel9);
		listData.add(lastYearValue9);
		listData.add(totalMediaInvestment);
		
		
		listData.add(proposedLabel1);
		listData.add(proposedValue1);
		listData.add(proposedLabel2);
		listData.add(proposedValue2);
		listData.add(proposedLabel3);
		listData.add(proposedValue3);
		listData.add(proposedLabel4);
		listData.add(proposedValue4);
		listData.add(proposedLabel5);
		listData.add(proposedValue5);
		listData.add(proposedLabel6);
		listData.add(proposedValue6);
		listData.add(proposedLabel7);
		listData.add(proposedValue7);
		listData.add(proposedLabel8);
		listData.add(proposedValue8);
		listData.add(proposedLabel9);
		listData.add(proposedValue9);
		listData.add(totalMediaInvestmentTwo);
		
	
		
		
		
		return listData;
	}
	
	
}
