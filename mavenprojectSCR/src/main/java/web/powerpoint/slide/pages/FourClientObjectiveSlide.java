package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import web.page.clientobjectivesonepage.ClientObjectivesOnePageModel;
import web.page.clientobjectivesonepage.ClientObjectivesOnePageTwoModel;
import web.page.presentedtopage.PresentedToPageModel;
import web.page.strategicmarketingpageone.StrategicMarketingPageOneModel;
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

    private ClientObjectivesOnePageTwoModel getOrder(int orderToFind,ClientObjectivesOnePageModel clientObjectivesOnePageModel ) {
        

        Map<String, String> labels = new HashMap<>();
        labels.put("introduceNewDepartment", "Introduce New Department/Products/Services");
        labels.put("featureSpecificProducts", "Feature Specific Products/Services");
        labels.put("callAttentiontoBrandsPrivatesCarried", "Call Attention to Brands/Private s Carried");
        labels.put("promoteOffPriceItemsServices", "Promote Off-price Items/Services");

        labels.put("quarterlySeasonalCampaign", "Establish a quarterly spike/seasonal campaign");

        labels.put("utilizeCoopVendorDollars", "Utilize Co-op/Vendor Dollars");
        labels.put("retainCurrentConsumers", "Retain/Recapture Consumers");

        labels.put("increaseCustomerVisits", "Increase Frequency of Customer Visits");
        labels.put("increaseTrafficLeadCalls", "Grow New Traffic/Lead Calls");
        labels.put("expandTargetConsumers", "Expand Target Consumers (by age, sex, geography)");
        labels.put("changeConsumerAttitudes", "Change Consumer Attitudes");
        labels.put("makePromotionalEventsStronger", "Make Promotional Events Stronger");
        labels.put("increaseDigitalMobileOnlineResponse", "Develop Digital/Mobile/Social Strategies");
        labels.put("developDatabaseMarketing", "Develop Database Marketing (Email and Text)");
        labels.put("initiateCauseMarketingProgram", "Initiate Cause Marketing Programs");
        labels.put("developSpeciallyStagedEvent", "Develop Specially Staged Events");
        labels.put("maintainMarketDominance", "Maintain Market Dominance");
        labels.put("improveBusinessNameBrand", "Elevate Business Brand/Image");
        labels.put("establishorReestablishBusinessImage", "Improve Reputation and Listing Management");
        labels.put("createPentUpDemand", "Enhance Website (Mobile, Response, SEO, SEM)");
        labels.put("increaseMarketShare", "Increase Market Share");

        List<ClientObjectivesOnePageTwoModel> orderList = this.getmSlidesData().getPageModels().getOrderList();
        ClientObjectivesOnePageTwoModel foundClientObjectivesOnePageTwoModel = null;
        for (ClientObjectivesOnePageTwoModel clientObjectivesOnePageTwoModel : orderList) {
            int sortorder = clientObjectivesOnePageTwoModel.getSortOrder();
            if (sortorder == orderToFind) {
                foundClientObjectivesOnePageTwoModel = clientObjectivesOnePageTwoModel;
                 String description  = labels.get(clientObjectivesOnePageTwoModel.getKey());
                 if (description == null ) {
                     description = clientObjectivesOnePageModel.getOtherText();
                     
                 }
                 
                 clientObjectivesOnePageTwoModel.setLabel(description);
                break;
            }
        }
        return foundClientObjectivesOnePageTwoModel;
    }

    @Override
    public void populateSlide(XSLFSlide slide) {
        ClientObjectivesOnePageModel clientObjectivesOnePageModel = getmSlidesData().getPageModels().getClientObjectivesOnePageModel();
        StrategicMarketingPageOneModel strategicMarketingPageOneModel = getmSlidesData().getPageModels().getStrategicMarketingPageOneModel();

        List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
        SlideReplacementData selllingAdvantages = new SlideReplacementData("selllingAdvantages", strategicMarketingPageOneModel.getSellingAdvantages());

        listData.add(selllingAdvantages);

        replaceTextOnSlide(listData, slide);

//slidesData.getPageModels().setOrderList(orderList);
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
                                if (r.getRawText().contains("order1")) {
                                    ClientObjectivesOnePageTwoModel clientObjectivesOnePageTwoModel = getOrder(1,clientObjectivesOnePageModel);
                                    clientObjectivesOnePageTwoModel.getLabel();
                                    r.setText(clientObjectivesOnePageTwoModel.getLabel());
                                }
                                if (r.getRawText().contains("order2")) {
                                    ClientObjectivesOnePageTwoModel clientObjectivesOnePageTwoModel = getOrder(2,clientObjectivesOnePageModel);
                                    clientObjectivesOnePageTwoModel.getLabel();
                                    r.setText(clientObjectivesOnePageTwoModel.getLabel());
                                }
                                if (r.getRawText().contains("order3")) {
                                    ClientObjectivesOnePageTwoModel clientObjectivesOnePageTwoModel = getOrder(3,clientObjectivesOnePageModel);
                                    clientObjectivesOnePageTwoModel.getLabel();
                                    r.setText(clientObjectivesOnePageTwoModel.getLabel());
                                }
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
                                    r.setText("Call Attention to Brands/Private s Carried");

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
                                if (r.getRawText().contains("Retain:Consumer")) {
                                    r.setText("Retain/Recapture Consumers");

                                    if (clientObjectivesOnePageModel.isRetainCurrentConsumers()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Increase:Consumer")) {
                                    r.setText("Increase Frequency of Customer Visits");

                                    if (clientObjectivesOnePageModel.isIncreaseCustomerVisits()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Grow:Consumer")) {
                                    r.setText("Grow New Traffic/Lead Calls");

                                    if (clientObjectivesOnePageModel.isIncreaseTrafficLeadCalls()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Expand:Consumer")) {
                                    r.setText("Expand Target Consumers (by age, sex, geography)");

                                    if (clientObjectivesOnePageModel.isExpandTargetConsumers()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Change:Consumer")) {
                                    //Change Consumer Attitudes
                                    r.setText("Change Consumer Attitudes");

                                    if (clientObjectivesOnePageModel.isChangeConsumerAttitudes()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }
                                if (r.getRawText().contains("Make:Consumer")) {
                                    r.setText("Make Promotional Events Stronger");

                                    if (clientObjectivesOnePageModel.isMakePromotionalEventsStronger()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                }

                                if (r.getRawText().contains("Make:Promotion")) {
                                    r.setText("Make Promotional Events Stronger");
                                    if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                        r.setBold(true);
                                    } else {
                                        r.setBold(false);
                                    }

                                    if (r.getRawText().contains("Develop:Promotion")) {
                                        r.setText("Develop Digital/Mobile/Social Strategies");
                                        if (clientObjectivesOnePageModel.isCallAttentiontoBrandsPrivateLabelsCarried()) {
                                            r.setBold(true);
                                        } else {
                                            r.setBold(false);
                                        }

                                    }
                                    if (r.getRawText().contains("Establish:Promotion")) {
                                        r.setText("Establish a quarterly spike/seasonal campaign");
                                        if (clientObjectivesOnePageModel.isQuarterlySeasonalCampaign()) {
                                            r.setBold(true);
                                        } else {
                                            r.setBold(false);
                                        }

                                    }
                                    if (r.getRawText().contains("Develop:Promotion")) {
                                        r.setText("Develop Database Marketing (Email and Text)");
                                        if (clientObjectivesOnePageModel.isDevelopDatabaseMarketing()) {
                                            r.setBold(true);
                                        } else {
                                            r.setBold(false);
                                        }

                                    }
                                    if (r.getRawText().contains("Initiate:Promotion")) {
                                        r.setText("Initiate Cause Marketing Programs");
                                        if (clientObjectivesOnePageModel.isInitiateCauseMarketingProgram()) {
                                            r.setBold(true);
                                        } else {
                                            r.setBold(false);
                                        }

                                    }
                                    if (r.getRawText().contains("Specially:Promotion")) {
                                        r.setText("Develop Specially Staged Events");
                                        if (clientObjectivesOnePageModel.isDevelopSpeciallyStagedEvent()) {
                                            r.setBold(true);
                                        } else {
                                            r.setBold(false);
                                        }

                                    }
                                    if (r.getRawText().contains("Maintain:Brand")) {
                                        r.setText("Maintain Market Dominance");
                                        if (clientObjectivesOnePageModel.isMaintainMarketDominance()) {
                                            r.setBold(true);
                                        } else {
                                            r.setBold(false);
                                        }

                                    }
                                    if (r.getRawText().contains("Improve:Brand")) {
                                        r.setText("Improve Reputation and Listing Management");
                                        if (clientObjectivesOnePageModel.isEstablishorReestablishBusinessImage()) {
                                            r.setBold(true);
                                        } else {
                                            r.setBold(false);
                                        }

                                    }
                                    if (r.getRawText().contains("Enhance:Brand")) {

                                        r.setText("Enhance Website (Mobile, Response, SEO, SEM)");
                                        if (clientObjectivesOnePageModel.isCreatePentUpDemand()) {
                                            r.setBold(true);
                                        } else {
                                            r.setBold(false);
                                        }

                                    }

                                    if (r.getRawText().contains("Increase:Brand")) {

                                        r.setText("Increase Market Share");
                                        if (clientObjectivesOnePageModel.isIncreaseMarketShare()) {
                                            r.setBold(true);
                                        } else {
                                            r.setBold(false);
                                        }

                                    }
                                    if (r.getRawText().contains("Increate:Brand")) {

                                        r.setText(clientObjectivesOnePageModel.getOtherText());
                                        if (clientObjectivesOnePageModel.isOther()) {
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

}
