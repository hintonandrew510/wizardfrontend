package web.google.slide.pages;

import java.util.ArrayList;
import java.util.List;

import web.google.slide.AbstractSlide;
import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.marketplacecompetitionpage.MarketPlaceCompetitionPageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;

public class ThreeMarketPlaceCompetitionSlide extends AbstractSlide {
	public ThreeMarketPlaceCompetitionSlide(SlidesData sildeData , SlideEnum slideEnum, String pageName) {
		super(sildeData, slideEnum, pageName);
	}
	@Override
	public List<SlideReplacementData> composeGoogleSlideData() {
		MarketPlaceCompetitionPageModel pageModel = getmSlidesData().getPageModels().getMarketPlaceCompetitionPageModel();
		StrategicMarketingPageOneModel strategicMarketingPageOneModel = getmSlidesData().getPageModels().getStrategicMarketingPageOneModel();
		
		if (pageModel == null || strategicMarketingPageOneModel == null) {
			return null;
		}
		
		List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
		
		
		SlideReplacementData yearsInBusiness = new SlideReplacementData("yearsInBusiness", String.valueOf(strategicMarketingPageOneModel.getYearsInBusiness()));
		SlideReplacementData numberOfLocations = new SlideReplacementData("numberOfLocations", String.valueOf(strategicMarketingPageOneModel.getNumberOfLocations()));
		String planToExpandString = strategicMarketingPageOneModel.isPlanToExpand() ? "Yes" : "No";
		SlideReplacementData planToExpand = new SlideReplacementData("planToExpand", planToExpandString);
		
		
		SlideReplacementData firstTierBusiness = new SlideReplacementData("firstTierBusiness", pageModel.getFirstTierBusiness());
		SlideReplacementData secondTierBusiness = new SlideReplacementData("secondTierBusiness", pageModel.getSecondTierBusiness());
		
		SlideReplacementData thirdTierBusiness = new SlideReplacementData("thirdTierBusiness", pageModel.getThirdTierBusiness());
		SlideReplacementData fourthTierBusiness = new SlideReplacementData("fourthTierBusiness", pageModel.getFourthTierBusiness());
	
		SlideReplacementData competitionA = new SlideReplacementData("competitionA", pageModel.getCompetitionA());
		SlideReplacementData competitionB = new SlideReplacementData("competitionB", pageModel.getCompetitionB());
	
		SlideReplacementData competitionStrengthA = new SlideReplacementData("competitionStrengthA", pageModel.getCompetitionStrengthA());
		SlideReplacementData competitionStrengthB = new SlideReplacementData("competitionStrengthB", pageModel.getCompetitionStrengthB());
	
		SlideReplacementData competitionWeaknessA = new SlideReplacementData("competitionWeaknessA", pageModel.getCompetitionWeaknessA());
		SlideReplacementData competitionWeaknessB = new SlideReplacementData("competitionWeaknessB", pageModel.getCompetitionWeaknessB());
	
		
		listData.add(yearsInBusiness);
		listData.add(numberOfLocations);
		listData.add(planToExpand);
		listData.add(firstTierBusiness);
		listData.add(secondTierBusiness);
		
		listData.add(thirdTierBusiness);
		listData.add(fourthTierBusiness);
		
		listData.add(competitionA);
		listData.add(competitionB);
		
		listData.add(competitionStrengthA);
		listData.add(competitionStrengthB);
		
		listData.add(competitionWeaknessA);
		listData.add(competitionWeaknessB);
		
		
		return listData;


		


	}

	
}
