package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.PieChart;
import web.page.planamedipage.MediaChart;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.teamcommitmentpage.TeamCommitmentPageModel;

public class TwoTeamCommitmentSlide extends AbstractSlide {
	public TwoTeamCommitmentSlide(SlidesData sildeData, SlideEnum slideEnum) {
		super(sildeData, slideEnum);
	}
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		TeamCommitmentPageModel model =  getmSlidesData().getPageModels().getTeamCommitmentPageModel();
		
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		
		
		
		SlideReplacementData topLevelName = new SlideReplacementData("topLevelName", model.getTopLevelName());
		SlideReplacementData topLevelTitle = new SlideReplacementData("topLevelTitle", model.getTopLevelTitle());
		SlideReplacementData secondLevelName = new SlideReplacementData("secondLevelName", model.getSecondLevelName());
		SlideReplacementData secondLevelTitle = new SlideReplacementData("secondLevelTitle", model.getSecondLevelTitle());
		SlideReplacementData thirdLevelName = new SlideReplacementData("thirdLevelName", model.getThirdLevelName());
		SlideReplacementData thirdLevelTitle = new SlideReplacementData("thirdLevelTitle", model.getThirdLevelTitle());
		SlideReplacementData fourthLevelName = new SlideReplacementData("fourthLevelName", model.getFourthLevelName());
		SlideReplacementData fourthLevelTitle = new SlideReplacementData("fourthLevelTitle", model.getFourthLevelTitle());

		listData.add(topLevelName);
		listData.add(topLevelTitle);
		listData.add(secondLevelName);
		listData.add(secondLevelTitle);
		listData.add(thirdLevelName);
		listData.add(thirdLevelTitle);
		listData.add(thirdLevelName);
		listData.add(thirdLevelTitle);
		listData.add(fourthLevelName);
		listData.add(fourthLevelTitle);
		return listData;

	}


	
}
