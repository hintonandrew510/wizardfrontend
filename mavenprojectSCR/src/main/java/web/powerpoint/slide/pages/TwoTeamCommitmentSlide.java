package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import web.google.slide.SlideEnum;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.teamcommitmentpage.TeamCommitmentPageModel;
import web.powerpoint.slide.AbstractSlide;

public class TwoTeamCommitmentSlide extends AbstractSlide {

    private static final Logger mLog = LoggerFactory.getLogger(TwoTeamCommitmentSlide.class.getName());

    public TwoTeamCommitmentSlide(SlidesData sildeData, SlideEnum slideEnum, String pageName) {
        super(sildeData, slideEnum, pageName);
    }

    public List<SlideReplacementData> composeGoogleSlideData() {
        TeamCommitmentPageModel model = getmSlidesData().getPageModels().getTeamCommitmentPageModel();

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

    @Override
    public void populateSlide(XSLFSlide slide) {
        TeamCommitmentPageModel model = getmSlidesData().getPageModels().getTeamCommitmentPageModel();

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
        replaceTextOnSlide(listData, slide);

        //loop thru add repalce data on slide
        mLog.trace(listData.toString());

    }

}
