package web.powerpoint.slide.pages;

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
import web.google.slide.SlidesData;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class FourClientObjectiveSlide extends AbstractSlide {

    public FourClientObjectiveSlide(SlidesData sildeData, SlidePageNameEnum slideEnum, String pageName) {
        super(sildeData, slideEnum, pageName);
    }

    public FourClientObjectiveSlide(String pageName, String strategicMarketing_Data_CONSUMER, SlidePageNameEnum slideEnum, SlidesData slidesData) {
        super(slidesData, slideEnum, pageName);
    }
    
    private static final Logger mLog = LoggerFactory.getLogger(web.google.slide.pages.OnePresentedToSlide.class.getName());


    /*


 r.getRawText() Promote Off-price Items/Services
 r.getRawText() Utilize Co-op/Vendor Dollars
 r.getRawText() Maintain Market Dominance
 r.getRawText() Elevate Business Brand/Image
 r.getRawText() Improve Reputation and Listing Management
 r.getRawText() Enhance Website (Mobile, Response, SEO, SEM)
 r.getRawText() Increase Market Share
 r.getRawText() Make Promotional Events Stronger
 r.getRawText() Develop Digital/Mobile/Social Strategies
 r.getRawText() Establish a quarterly spike/seasonal campaign
 r.getRawText() Develop Database Marketing (Email and Text)
 r.getRawText() Initiate Cause Marketing Programs
 r.getRawText() Develop Specially Staged Events
 r.getRawText() Maintain Market Dominance
 r.getRawText() Elevate Business Brand/Image
 r.getRawText() Improve Reputation and Listing Management
 r.getRawText() Enhance Website (Mobile, Response, SEO, SEM)
 r.getRawText() Increase Market Share
 r.getRawText() Tech Recruitment
 r.getRawText() 1. Initiate Cause Marketing Programs
 r.getRawText() 2. Tech Recruitment
 r.getRawText() 3. Expand Target Consumers (by age, sex, geography)
     */
    @Override
    public void populateSlide(XSLFSlide slide) {
        ClientObjectivesOnePageModel clientObjectivesOnePageModel = getmSlidesData().getPageModels().getClientObjectivesOnePageModel();
        for (XSLFShape shape : slide.getShapes()) {
            // Check if the shape is a text shape

            if (shape instanceof XSLFTable) {
                //System.out.println("Name of table " + shape);
                XSLFTable table = (XSLFTable) shape;

                // Get all rows from the table
                List<XSLFTableRow> rows = table.getRows();

                // You can now iterate through the rows
                for (XSLFTableRow row : rows) {
                    // Process the row (e.g., get cells from the row)
                    List<XSLFTableCell> cells = row.getCells();
                    for (XSLFTableCell cell : cells) {
                        //System.out.println(" cell data " + cell.getText());

                        for (XSLFTextParagraph p : cell.getTextParagraphs()) {
                            //System.out.println(" p.getText() " + p.getText());
                            for (XSLFTextRun r : p.getTextRuns()) {
                                //(" r.getRawText() " + r.getRawText());
                                if (r.getRawText().contains("Introduce New Department")) {
                                    if (clientObjectivesOnePageModel.isIntroduceNewDepartment()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }

                                if (r.getRawText().contains("Feature Specific Products")) {
                                    if (clientObjectivesOnePageModel.isFeatureSpecificProducts()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                            if (r.getRawText().contains("Call Attention to Brands")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

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

    }

}
