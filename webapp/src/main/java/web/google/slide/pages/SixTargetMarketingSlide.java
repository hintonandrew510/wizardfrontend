package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.targetmarketingpage.TargetMarketingHeaderRow;
import web.page.targetmarketingpage.TargetMarketingPageModel;

public class SixTargetMarketingSlide extends AbstractSlide {

	public SixTargetMarketingSlide(SlidesData sildeData , SlideEnum slideEnum) {
		super(sildeData, slideEnum);
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		TargetMarketingPageModel targetMarketingPageModel = getmSlidesData().getPageModels().getTargetMarketingPageModel();
		TargetMarketingHeaderRow targetMarketingHeaderRow = getmSlidesData().getPageModels().getTargetMarketingHeaderRow();
		String pctMenStr = targetMarketingPageModel.getPctMen() + "%";
		SlideReplacementData pctMen = new SlideReplacementData("pctMen", pctMenStr);
		listData.add(pctMen);
		
		String pctWomenStr = targetMarketingPageModel.getPctWomen() + "%";
		SlideReplacementData pctWomen = new SlideReplacementData("pctWomen", pctWomenStr);
		listData.add(pctWomen);	
		
		SlideReplacementData describeIdealTargetConsumer = new SlideReplacementData("describeIdealTargetConsumer", targetMarketingPageModel.getDescribeIdealTargetConsumer());
		listData.add(describeIdealTargetConsumer);
		
		
		
		
		String hostIncomeStr = targetMarketingPageModel.getHouseholdIncome();
		Integer hostIncome = Integer.valueOf(hostIncomeStr);
		String block = "\u2b1b";
		String checkMark= "\u2713";
		String Id150 = block;
		String Id100149 = block;
		String Id5099 = block;
		String Idunder50 = block;
		
		switch(hostIncome) {
		case 1:
			Id150 = checkMark;
//document.getElementById("150Id").checked = true;

			break;
		case 2:
			Id100149 = checkMark;
			//document.getElementById("100149Id").checked = true;

			break;
		case 3:
			Id5099 = checkMark;
			//document.getElementById("5099Id").checked = true;
			break;
		case 4:
			Idunder50 = checkMark;
			//document.getElementById("under50Id").checked = true;
			break;
		default:
			// code block
		}
		
		SlideReplacementData dId150 = new SlideReplacementData("150Id", Id150);
		listData.add(dId150);
		
		SlideReplacementData dId100149 = new SlideReplacementData("100149Id", Id100149);
		listData.add(dId100149);
		
		SlideReplacementData dId5099 = new SlideReplacementData("5099Id", Id5099);
		listData.add(dId5099);
		
		SlideReplacementData dIdunder50 = new SlideReplacementData("under50Id", Idunder50);
		listData.add(dIdunder50);
		
		SlideReplacementData have12to18 = new SlideReplacementData("have12to18", String.valueOf(targetMarketingPageModel.getHave12to18()));
		listData.add(have12to18);
	
		SlideReplacementData have19to25 = new SlideReplacementData("have19to25", String.valueOf(targetMarketingPageModel.getHave19to25()));
		listData.add(have19to25);
		
		SlideReplacementData have26to35 = new SlideReplacementData("have26to35", String.valueOf(targetMarketingPageModel.getHave26to35()));
		listData.add(have26to35);
		
		SlideReplacementData have46to55 = new SlideReplacementData("have46to55", String.valueOf(targetMarketingPageModel.getHave46to55()));
		listData.add(have46to55);
		
		SlideReplacementData have56Plus = new SlideReplacementData("have56Plus", String.valueOf(targetMarketingPageModel.getHave56Plus()));
		listData.add(have56Plus);
			
		SlideReplacementData want19to25 = new SlideReplacementData("want19to25", String.valueOf(targetMarketingPageModel.getWant19to25()));
		listData.add(want19to25);
	
		SlideReplacementData want26to35 = new SlideReplacementData("want26to35", String.valueOf(targetMarketingPageModel.getWant26to35()));
		listData.add(want26to35);
		
		SlideReplacementData want36to45 = new SlideReplacementData("have26to35", String.valueOf(targetMarketingPageModel.getWant36to45()));
		listData.add(want36to45);
		
		SlideReplacementData want46to55 = new SlideReplacementData("want46to55", String.valueOf(targetMarketingPageModel.getWant46to55()));
		listData.add(want46to55);
		
		SlideReplacementData want55Plus = new SlideReplacementData("want55Plus", String.valueOf(targetMarketingPageModel.getWant55Plus()));
		listData.add(want55Plus);
		
		return listData;
	
	}

}
