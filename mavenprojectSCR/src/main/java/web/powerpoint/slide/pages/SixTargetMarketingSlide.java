package web.powerpoint.slide.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
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
import web.page.targetmarketingpage.TargetMarketingHeaderRow;
import web.page.targetmarketingpage.TargetMarketingPageModel;
import web.powerpoint.slide.AbstractSlide;
import web.powerpoint.slide.SlidePageNameEnum;

public class SixTargetMarketingSlide extends web.powerpoint.slide.AbstractSlide {

    private static final Logger mLog = LoggerFactory.getLogger(web.powerpoint.slide.pages.SixTargetMarketingSlide.class.getName());

    public SixTargetMarketingSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName, Contact contact, XMLSlideShow ppt) {
        super(slidesData, slideEnum, pageName, contact, ppt);
    }

    @Override
    public void populateSlide(XSLFSlide slide) {
        {
            List<SlideReplacementData> listData = new ArrayList<SlideReplacementData>();
            TargetMarketingPageModel targetMarketingPageModel = getmSlidesData().getPageModels().getTargetMarketingPageModel();
            TargetMarketingHeaderRow targetMarketingHeaderRow = getmSlidesData().getPageModels().getTargetMarketingHeaderRow();
            String pctMenStr = targetMarketingPageModel.getPctMen() + "%";
            SlideReplacementData pctMen = new SlideReplacementData("pctMen", pctMenStr);
            listData.add(pctMen);

            String pctWomenStr = targetMarketingPageModel.getPctWomen() + "%";
            SlideReplacementData pctWomen = new SlideReplacementData("pctWom", pctWomenStr);
            listData.add(pctWomen);

            SlideReplacementData describeIdealTargetConsumer = new SlideReplacementData("describeIdealTargetConsumer", targetMarketingPageModel.getDescribeIdealTargetConsumer());
            listData.add(describeIdealTargetConsumer);
//\u2610  □ Unchecked: \u2610

//"\u2611 Checked Box");
            String hostIncomeStr = targetMarketingPageModel.getHouseholdIncome();
            Integer hostIncome = Integer.valueOf(hostIncomeStr);
            String block = "\u2610";
            String checkMark = " \u2610";
            String Id150 = block + " $150k Plus";
            String Id100149 = block + " $100-$149K";
            String Id5099 = block + " $50-$99K";
            String Idunder50 = block + " Under $50K";

            switch (hostIncome) {
                case 1:
                    Id150 = checkMark + " $150k Plus";;
//document.getElementById("150Id").checked = true;

                    break;
                case 2:
                    Id100149 = checkMark + " $100-$149K";
                    //document.getElementById("100149Id").checked = true;

                    break;
                case 3:
                    Id5099 = checkMark + " $50-$99K";
                    //document.getElementById("5099Id").checked = true;
                    break;
                case 4:
                    Idunder50 = checkMark + " Under $50K";
                    //document.getElementById("under50Id").checked = true;
                    break;
                default:
                // code block
            }

            SlideReplacementData dId150 = new SlideReplacementData("150Kplus", Id150);
            listData.add(dId150);

            SlideReplacementData dId100149 = new SlideReplacementData("100K149K", Id100149);
            listData.add(dId100149);

            SlideReplacementData dId5099 = new SlideReplacementData("50K-99K", Id5099);
            listData.add(dId5099);

            SlideReplacementData dIdunder50 = new SlideReplacementData("Under50K", Idunder50);
            listData.add(dIdunder50);
            replaceTextOnSlide(listData, slide);

            String have12to18 = String.valueOf(targetMarketingPageModel.getHave12to18());

            String have19to25 = String.valueOf(targetMarketingPageModel.getHave19to25());

            String have26to35 = String.valueOf(targetMarketingPageModel.getHave26to35());

            String have36to45 = String.valueOf(targetMarketingPageModel.getHave36to45());

            String have46to55 = String.valueOf(targetMarketingPageModel.getHave46to55());

            String have56Plus = String.valueOf(targetMarketingPageModel.getHave56Plus());

            String want19to25 = String.valueOf(targetMarketingPageModel.getWant19to25());

            String want26to35 = String.valueOf(targetMarketingPageModel.getWant26to35());

            String want36to45 = String.valueOf(targetMarketingPageModel.getWant36to45());

            String want46to55 = String.valueOf(targetMarketingPageModel.getWant46to55());

            String want55Plus = String.valueOf(targetMarketingPageModel.getWant55Plus());
//
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
                                    if (r.getRawText().contains("have12to18")) {
                                        r.setText(have12to18);
                                    }
                                    if (r.getRawText().contains("have19to25")) {
                                        r.setText(have19to25);
                                    }
                                    if (r.getRawText().contains("have26to35")) {
                                        r.setText(have26to35);
                                    }
                                    if (r.getRawText().contains("have36to45")) {
                                        r.setText(have36to45);
                                    }

                                    if (r.getRawText().contains("have46to55")) {
                                        r.setText(have46to55);
                                    }
                                    if (r.getRawText().contains("have56Plus")) {
                                        r.setText(have56Plus);
                                    }

                                    if (r.getRawText().contains("want19to25")) {
                                        r.setText(want19to25);
                                    }
                                    if (r.getRawText().contains("want26to35")) {
                                        r.setText(want26to35);
                                    }
                                    if (r.getRawText().contains("want36to45")) {
                                        r.setText(want36to45);
                                    }
                                    if (r.getRawText().contains("want46to55")) {
                                        r.setText(want46to55);
                                    }
                                    if (r.getRawText().contains("want55Plus")) {
                                        r.setText(want55Plus);
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
