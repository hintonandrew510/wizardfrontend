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










 r.getRawText() Increase Market Share
 r.getRawText() Tech Recruitment

     */
    @Override
    public void populateSlide(XSLFSlide slide) {
        ClientObjectivesOnePageModel clientObjectivesOnePageModel = getmSlidesData().getPageModels().getClientObjectivesOnePageModel();
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
                        //System.out.println(" cell data " + cell.getText());

                        for (XSLFTextParagraph p : cell.getTextParagraphs()) {
                            //System.out.println(" p.getText() " + p.getText());
                            for (XSLFTextRun r : p.getTextRuns()) {
                                //(" r.getRawText() " + r.getRawText());
                                if (r.getRawText().contains("Introduce:Product")) {
                                    r.setText("Introduce New Department/Products/Services");
                                    if (clientObjectivesOnePageModel.isIntroduceNewDepartment()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Feature:Product")) {
                                    r.setText("Feature Specific Products/Services");
                                    
                                    if (clientObjectivesOnePageModel.isFeatureSpecificProducts()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Call:Product")) {
                                     r.setText("Call Attention to Brands/Private Labels Carried");
                                    
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Promote:Product")) {
                                    r.setText("Promote Off-price Items/Services");
                                    
                                    
                                    if (clientObjectivesOnePageModel.isPromoteOffPriceItemsServices()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Utilize:Product")) {
                                      r.setText("Utilize Co-op/Vendor Dollars");
                                    if (clientObjectivesOnePageModel.isUtilizeCoopVendorDollars()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Maintain Market")) {
                                    if (clientObjectivesOnePageModel.isMaintainMarketDominance()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Elevate Business Brand")) {
                                    if (clientObjectivesOnePageModel.isExpandTargetConsumers()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Improve Reputation and Listing")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Enhance Website")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Make Promotional Events Stronger")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Develop Digital/Mobile")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Establish a quarterly")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Enhance Website")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Develop Database Marketing")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Initiate Cause Marketing ")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Maintain Market Dominance")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Elevate Business Brand")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Improve Reputation")) {
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Enhance Website")) {
                                    if (clientObjectivesOnePageModel.isMaintainMarketDominance()) {
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
