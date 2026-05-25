/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.helper;

import org.apache.poi.xslf.usermodel.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import org.apache.poi.sl.usermodel.TableCell.BorderEdge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.powerpoint.slide.pages.PlanSpreadSheet;
import web.powerpoint.slide.pages.PlanSpreadSheets;

/**
 *
 * @author andrewhinton
 */
public class TableHelper {

    private static final Logger mLog = LoggerFactory.getLogger(TableHelper.class.getName());

    public static void buildTable(PlanSpreadSheets planSpreadSheets, XSLFSlide slide, XMLSlideShow ppt) {
        try {

            // 2. Get the slide width (standard is 720 points)
            Dimension slideSize = ppt.getPageSize();
            double slideWidth = slideSize.getWidth();
            // 3. Define desired table percentage (e.g., 80%)
            double tablePercentage = 1.20;
            double tableWidth = slideWidth * tablePercentage;
            int tableWidthInt = (int) tableWidth;
            mLog.info("width " + tableWidthInt);
            // 2. Get the slide width (standard is 720 points)

            // 2. Create and position the table
            XSLFTable table = slide.createTable();
            int columnWidth = 20;
            double fontSize = 8.0;
            int rowHeaderHeight = 10;
            int startX = 50;
            int startY = 220;
            double tableHeight = 300.0;
            Color headerColor = new Color(0, 104, 145);

            // table.setAnchor(new Rectangle(50, 220, tableWidthInt, 600)); // (x, y, width, height)
            // Data array
            //build header
            XSLFTableRow rowHealder = table.addRow();
            rowHealder.setHeight(rowHeaderHeight); // Set row height
            XSLFTableCell cellMedia = rowHealder.addCell();
            cellMedia.setText("Media");

//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);
            XSLFTableCell cellJan = rowHealder.addCell();
            cellJan.setText("Jan");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellFeb = rowHealder.addCell();
            cellFeb.setText("Feb");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellMar = rowHealder.addCell();
            cellMar.setText("Mar");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellApr = rowHealder.addCell();
            cellApr.setText("Apr");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellMay = rowHealder.addCell();
            cellMay.setText("May");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellJun = rowHealder.addCell();
            cellJun.setText("Jun");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellJul = rowHealder.addCell();
            cellJul.setText("Jul");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellAug = rowHealder.addCell();
            cellAug.setText("Aug");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellSep = rowHealder.addCell();
            cellSep.setText("Sep");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellOct = rowHealder.addCell();
            cellOct.setText("Oct");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellNov = rowHealder.addCell();
            cellNov.setText("Nov");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell cellDec = rowHealder.addCell();
            cellDec.setText("Dec");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            XSLFTableCell celltopTotal = rowHealder.addCell();
            celltopTotal.setText("Total");
//            table.setColumnWidth(table.getNumberOfColumns() - 1, columnWidth);

            cellMedia.setFillColor(headerColor);
            cellMedia.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellMedia.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellMedia.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellJan.setFillColor(headerColor);
            cellJan.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellJan.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellJan.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellFeb.setFillColor(headerColor);
            cellFeb.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellFeb.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellFeb.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellMar.setFillColor(headerColor);
            cellMar.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellMar.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellMar.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellApr.setFillColor(headerColor);
            cellApr.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellApr.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellApr.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellMay.setFillColor(headerColor);
            cellMay.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellMay.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellMay.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellJun.setFillColor(headerColor);
            cellJun.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellJun.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellJun.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellJul.setFillColor(headerColor);
            cellJul.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellJul.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellJul.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellAug.setFillColor(headerColor);
            cellAug.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellAug.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellAug.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellSep.setFillColor(headerColor);
            cellSep.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellSep.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellSep.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellOct.setFillColor(headerColor);
            cellOct.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellOct.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellOct.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellNov.setFillColor(headerColor);
            cellNov.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellNov.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellNov.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            cellDec.setFillColor(headerColor);
            cellDec.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            cellDec.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            cellDec.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            celltopTotal.setFillColor(headerColor);
            celltopTotal.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
            celltopTotal.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
            celltopTotal.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            for (PlanSpreadSheet planSpreadSheet : planSpreadSheets.getPlanSpreadSheets()) {
                XSLFTableRow row = table.addRow();
                XSLFTableCell cellDataMedia = row.addCell();
                cellDataMedia.setText(planSpreadSheet.getName());
                cellDataMedia.setFillColor(new Color(240, 240, 240));
                cellDataMedia.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataMedia.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataJan = row.addCell();
                cellDataJan.setText(planSpreadSheet.getJan());
                cellDataJan.setFillColor(new Color(240, 240, 240));
                cellDataJan.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataJan.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataFeb = row.addCell();
                cellDataFeb.setText(planSpreadSheet.getFeb());
                cellDataFeb.setFillColor(new Color(240, 240, 240));
                cellDataFeb.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataFeb.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataMar = row.addCell();
                cellDataMar.setText(planSpreadSheet.getMar());
                cellDataMar.setFillColor(new Color(240, 240, 240));
                cellDataMar.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataMar.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataApr = row.addCell();
                cellDataApr.setText(planSpreadSheet.getApr());
                cellDataApr.setFillColor(new Color(240, 240, 240));
                cellDataApr.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataApr.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataMay = row.addCell();
                cellDataMay.setText(planSpreadSheet.getMay());
                cellDataMay.setFillColor(new Color(240, 240, 240));
                cellDataMay.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataMay.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataJun = row.addCell();
                cellDataJun.setText(planSpreadSheet.getJun());
                cellDataJun.setFillColor(new Color(240, 240, 240));
                cellDataJun.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataJun.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataJul = row.addCell();
                cellDataJul.setText(planSpreadSheet.getJul());
                cellDataJul.setFillColor(new Color(240, 240, 240));
                cellDataJul.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataJul.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataAug = row.addCell();
                cellDataAug.setText(planSpreadSheet.getAug());
                cellDataAug.setFillColor(new Color(240, 240, 240));
                cellDataAug.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataAug.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataSep = row.addCell();
                cellDataSep.setText(planSpreadSheet.getSep());
                cellDataSep.setFillColor(new Color(240, 240, 240));
                cellDataSep.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataSep.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataOct = row.addCell();
                cellDataOct.setText(planSpreadSheet.getOct());
                cellDataOct.setFillColor(new Color(240, 240, 240));
                cellDataOct.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataOct.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataNov = row.addCell();
                cellDataNov.setText(planSpreadSheet.getNov());
                cellDataNov.setFillColor(new Color(240, 240, 240));
                cellDataNov.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataNov.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataDec = row.addCell();
                cellDataDec.setText(planSpreadSheet.getDec());
                cellDataDec.setFillColor(new Color(240, 240, 240));
                cellDataDec.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataDec.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                XSLFTableCell cellDataTotal
                        = row.addCell();
                cellDataTotal.setText(planSpreadSheet.getRt());
                cellDataTotal.setFillColor(new Color(240, 240, 240));
                cellDataTotal.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
                cellDataTotal.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

                //planSpreadSheet.
            }//end of for

            //total row
            planSpreadSheets.constructBottomTotals();
            planSpreadSheets.constructTotals();
            XSLFTableRow bottomRow = table.addRow();

            XSLFTableCell cellDataBottomTotal = bottomRow.addCell();
            cellDataBottomTotal.setText("Total");
            cellDataBottomTotal.setFillColor(new Color(240, 240, 240));
            cellDataBottomTotal.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomTotal.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            //jan
            XSLFTableCell cellDataBottomJan = bottomRow.addCell();
            cellDataBottomJan.setText(planSpreadSheets.getJan());
            cellDataBottomJan.setFillColor(new Color(240, 240, 240));
            cellDataBottomJan.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomJan.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomFeb = bottomRow.addCell();
            cellDataBottomFeb.setText(planSpreadSheets.getFeb());
            cellDataBottomFeb.setFillColor(new Color(240, 240, 240));
            cellDataBottomFeb.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomFeb.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomMar = bottomRow.addCell();
            cellDataBottomMar.setText(planSpreadSheets.getMar());
            cellDataBottomMar.setFillColor(new Color(240, 240, 240));
            cellDataBottomMar.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomMar.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomApr = bottomRow.addCell();
            cellDataBottomApr.setText(planSpreadSheets.getApr());
            cellDataBottomApr.setFillColor(new Color(240, 240, 240));
            cellDataBottomApr.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomApr.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomMay = bottomRow.addCell();
            cellDataBottomMay.setText(planSpreadSheets.getMay());
            cellDataBottomMay.setFillColor(new Color(240, 240, 240));
            cellDataBottomMay.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomMay.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomJun = bottomRow.addCell();
            cellDataBottomJun.setText(planSpreadSheets.getJun());
            cellDataBottomJun.setFillColor(new Color(240, 240, 240));
            cellDataBottomJun.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomJun.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomJul = bottomRow.addCell();
            cellDataBottomJul.setText(planSpreadSheets.getJul());
            cellDataBottomJul.setFillColor(new Color(240, 240, 240));
            cellDataBottomJul.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomJul.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomAug = bottomRow.addCell();
            cellDataBottomAug.setText(planSpreadSheets.getAug());
            cellDataBottomAug.setFillColor(new Color(240, 240, 240));
            cellDataBottomAug.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomAug.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomSep = bottomRow.addCell();
            cellDataBottomSep.setText(planSpreadSheets.getAug());
            cellDataBottomSep.setFillColor(new Color(240, 240, 240));
            cellDataBottomSep.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomSep.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomOct = bottomRow.addCell();
            cellDataBottomOct.setText(planSpreadSheets.getAug());
            cellDataBottomOct.setFillColor(new Color(240, 240, 240));
            cellDataBottomOct.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomOct.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomNov = bottomRow.addCell();
            cellDataBottomNov.setText(planSpreadSheets.getNov());
            cellDataBottomNov.setFillColor(new Color(240, 240, 240));
            cellDataBottomNov.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomNov.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomDec = bottomRow.addCell();
            cellDataBottomDec.setText(planSpreadSheets.getDec());
            cellDataBottomDec.setFillColor(new Color(240, 240, 240));
            cellDataBottomDec.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomDec.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            XSLFTableCell cellDataBottomTotalRow = bottomRow.addCell();
            cellDataBottomTotalRow.setText(planSpreadSheets.getRt());
            cellDataBottomTotalRow.setFillColor(new Color(240, 240, 240));
            cellDataBottomTotalRow.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.BLACK);
            cellDataBottomTotalRow.getTextParagraphs().get(0).getTextRuns().get(0).setFontSize(fontSize);

            double slideWidthtwo = 720.0;
            slideWidthtwo = 800.0;
            double leftMargin = 54.0;   // 0.75 inch margin
            double rightMargin = 54.0;  // 0.75 inch margin

// Calculate the maximum table width available
            double maxTableWidth = slideWidthtwo - (leftMargin + rightMargin);
            table.setAnchor(new Rectangle2D.Double(startX, startY, maxTableWidth, tableHeight));
            int numCols = table.getNumberOfColumns();
            // 4. Distribute that max width proportionally across all columns
            double columnWidthtwo = tableWidth / numCols;
            for (int i = 0; i < numCols; i++) {
                table.setColumnWidth(i, columnWidthtwo);
            }

        } catch (Exception ex) {
            mLog.error("error " + ex.getMessage());
        }

    }

    public static void main(String[] args) throws Exception {
        // 1. Initialize presentation and slide
        XMLSlideShow ppt = new XMLSlideShow();
        XSLFSlide slide = ppt.createSlide();

        // 2. Create and position the table
        XSLFTable tbl = slide.createTable();
        tbl.setAnchor(new Rectangle(100, 100, 450, 150)); // (x, y, width, height)

        // Data array
        String[][] data = {
            {"ID", "Name", "Role"},
            {"1", "Alice", "Developer"},
            {"2", "Bob", "Manager"},
            {"3", "Charlie", "Designer"}
        };

        // 3. Populate rows and cells
        for (int r = 0; r < data.length; r++) {
            XSLFTableRow row = tbl.addRow();
            row.setHeight(30); // Set row height

            for (int c = 0; c < data[r].length; c++) {
                XSLFTableCell cell = row.addCell();
                cell.setText(data[r][c]);

                // Style the header row differently
                if (r == 0) {
                    cell.setFillColor(new Color(0, 104, 145));
                    cell.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
                    cell.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);
                } else {
                    cell.setFillColor(new Color(240, 240, 240));
                }

                // Apply cell borders
                cell.setBorderColor(BorderEdge.top, Color.BLACK);
                cell.setBorderColor(BorderEdge.bottom, Color.BLACK);
                cell.setBorderColor(BorderEdge.left, Color.BLACK);
                cell.setBorderColor(BorderEdge.right, Color.BLACK);
            }
        }

        // 4. Adjust column widths (e.g., set second column wider)
        tbl.setColumnWidth(0, 100);
        tbl.setColumnWidth(1, 200);
        tbl.setColumnWidth(2, 150);

        // 5. Save the presentation
        try (FileOutputStream out = new FileOutputStream("StyledTable.pptx")) {
            ppt.write(out);
        }
    }

}
