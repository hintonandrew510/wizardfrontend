package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.google.slide.SlideReplacementData;

import web.google.slide.SlidesData;
import web.model.Contact;
import web.page.JSONManager;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageTwoModel;
import web.page.marketplacecompetitionpage.MarketPlaceCompetitionPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;
import web.page.strategicmarketingpagethree.StrategicMarketingHelper;
import web.page.strategicmarketingpagethree.StrategicMarketingPageThreeModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class FiveStrategicMarketingPageSlide extends AbstractSlide {

    private static final Logger mLog = LoggerFactory.getLogger(FiveStrategicMarketingPageSlide.class.getName());

    public FiveStrategicMarketingPageSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact) {
        super(slidesData, slideEnum, pageName, contact);
    }

    @Override
    public void populateSlide(XSLFSlide slide) {
        StrategicMarketingPageOneModel model = getmSlidesData().getPageModels().getStrategicMarketingPageOneModel();
        StrategicMarketingPageThreeModel strategicMarketingPageThreeModel = getmSlidesData().getPageModels().getStrategicMarketingPageThreeModel();

        StrategicMarketingHelper strategicMarketingHelper = getmSlidesData().getPageModels().getStrategicMarketingHelper();
        List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
        SlideReplacementData companyNameProjectImage = new SlideReplacementData("companyNameProjectImage", model.getCompanyNameProjectImage());
        SlideReplacementData currentCompanySlogan = new SlideReplacementData("currentCompanySlogan", model.getCurrentCompanySlogan());
        String planToExpandBoolen = model.isPlanToExpand() ? "Yes" : "No";
        SlideReplacementData planToExpand = new SlideReplacementData("planToExpand", planToExpandBoolen);
        
        SlideReplacementData compliments = new SlideReplacementData("compliments", strategicMarketingPageThreeModel.getCompliments());
      
        SlideReplacementData complaint = new SlideReplacementData("complaint", strategicMarketingPageThreeModel.getComplaint());
        
        SlideReplacementData marketingStrategy = new SlideReplacementData("marketingStrategy", strategicMarketingPageThreeModel.getMarketingStrategy());
        SlideReplacementData socialStrategy = new SlideReplacementData("socialStrategy", strategicMarketingPageThreeModel.getSocialStrategy());

        listData.add(companyNameProjectImage);
        listData.add(currentCompanySlogan);
        listData.add(planToExpand);
   

        listData.add(compliments);
       
        listData.add(complaint);
      
        listData.add(marketingStrategy);
        listData.add(socialStrategy);
        replaceTextOnSlide(listData, slide);

        for (XSLFShape shape : slide.getShapes()) {
            // Check if the shape is a text shape
            int tableNumber = 0;
            if (shape instanceof XSLFTable) {
                //System.out.println("Name of table " + shape);
                XSLFTable table = (XSLFTable) shape;
                tableNumber = tableNumber + 1;

                // Get all rows from the table
                List<XSLFTableRow> rows = table.getRows();

                // You can now iterate through the rows
                for (XSLFTableRow row : rows) {
                    // Process the row (e.g., get cells from the row)
                    List<XSLFTableCell> cells = row.getCells();
                    for (XSLFTableCell cell : cells) {
                        mLog.info(" cell data " + cell.getText());

                        for (XSLFTextParagraph p : cell.getTextParagraphs()) {
                            //System.out.println(" p.getText() " + p.getText());
                            for (XSLFTextRun r : p.getTextRuns()) {
                                //(" r.getRawText() " + r.getRawText());
                                //order1
                                String test = r.getRawText();
                                mLog.info("raw Text " + test);
                                if (r.getRawText().contains("poorestMonths")) {
                                    r.setText(strategicMarketingHelper.getPoorestMonths());
                                }
                                if (r.getRawText().contains("bestMonths")) {
                                    r.setText(strategicMarketingHelper.getBestMonths()  );
                                }
                                if (r.getRawText().contains("bestDays")) {
                                    r.setText(strategicMarketingHelper.getBestDays());
                                }

                            }
                        }

                    }
                }
            }
            if (shape instanceof XSLFTextShape) {
                XSLFTextShape textShape = (XSLFTextShape) shape;
                // Get text from all paragraphs within the text shape
                for (XSLFTextParagraph paragraph : textShape.getTextParagraphs()) {
                    String text = paragraph.getText();
                    if (!text.isEmpty()) {
                        //System.out.println("TextBox Content: " + text);
                    }
                }
            }
        }
        mLog.info("END populateSlide ");
    }

}
