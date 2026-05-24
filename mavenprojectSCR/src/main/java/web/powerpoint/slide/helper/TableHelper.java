/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.helper;

import org.apache.poi.xslf.usermodel.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.FileOutputStream;
import org.apache.poi.sl.usermodel.TableCell.BorderEdge;
import web.powerpoint.slide.pages.PlanSpreadSheet;
import web.powerpoint.slide.pages.PlanSpreadSheets;

/**
 *
 * @author andrewhinton
 */
public class TableHelper {

    public static void buildTable(PlanSpreadSheets planSpreadSheets, XSLFSlide slide) {
        // 2. Create and position the table
        XSLFTable tbl = slide.createTable();
        tbl.setAnchor(new Rectangle(300, 300, 600, 500)); // (x, y, width, height)
        // Data array

        //build header
        XSLFTableRow rowHealder = tbl.addRow();
        rowHealder.setHeight(30); // Set row height
        XSLFTableCell cellMedia = rowHealder.addCell();
        cellMedia.setText("Media");

        XSLFTableCell cellJan = rowHealder.addCell();
        cellJan.setText("Jan");

        XSLFTableCell cellFeb = rowHealder.addCell();
        cellFeb.setText("Feb");
        XSLFTableCell cellMar = rowHealder.addCell();
        cellMar.setText("Mar");
        XSLFTableCell cellApr = rowHealder.addCell();
        cellApr.setText("Apr");

        XSLFTableCell cellMay = rowHealder.addCell();
        cellMay.setText("May");
        XSLFTableCell cellJun = rowHealder.addCell();
        cellJun.setText("Jun");
        XSLFTableCell cellJul = rowHealder.addCell();
        cellJul.setText("Jul");
        XSLFTableCell cellAug = rowHealder.addCell();
        cellAug.setText("Aug");
        XSLFTableCell cellSep = rowHealder.addCell();
        cellSep.setText("Sep");
        XSLFTableCell cellOct = rowHealder.addCell();
        cellSep.setText("Oct");
        XSLFTableCell cellNov = rowHealder.addCell();
        cellNov.setText("Nov");
        XSLFTableCell cellDec = rowHealder.addCell();
        cellDec.setText("Dec");
        XSLFTableCell celltopTotal = rowHealder.addCell();
        celltopTotal.setText("Total");

        cellMedia.setFillColor(new Color(0, 104, 145));
        cellMedia.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellMedia.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellJan.setFillColor(new Color(0, 104, 145));
        cellJan.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellJan.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellFeb.setFillColor(new Color(0, 104, 145));
        cellFeb.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellFeb.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellMar.setFillColor(new Color(0, 104, 145));
        cellMar.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellMar.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellApr.setFillColor(new Color(0, 104, 145));
        cellApr.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellApr.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellMay.setFillColor(new Color(0, 104, 145));
        cellMay.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellMay.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellJun.setFillColor(new Color(0, 104, 145));
        cellJun.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellJun.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellJul.setFillColor(new Color(0, 104, 145));
        cellJul.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellJul.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellAug.setFillColor(new Color(0, 104, 145));
        cellAug.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellAug.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellSep.setFillColor(new Color(0, 104, 145));
        cellSep.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellSep.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellOct.setFillColor(new Color(0, 104, 145));
        cellOct.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellOct.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellNov.setFillColor(new Color(0, 104, 145));
        cellNov.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellNov.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        cellDec.setFillColor(new Color(0, 104, 145));
        cellDec.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        cellDec.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        celltopTotal.setFillColor(new Color(0, 104, 145));
        celltopTotal.getTextParagraphs().get(0).getTextRuns().get(0).setFontColor(Color.WHITE);
        celltopTotal.getTextParagraphs().get(0).getTextRuns().get(0).setBold(true);

        for (PlanSpreadSheet planSpreadSheet : planSpreadSheets.getPlanSpreadSheets()) {
            XSLFTableRow row = tbl.addRow();
            XSLFTableCell cellDataJan = row.addCell();
            cellDataJan.setText(planSpreadSheet.getJan());
             cellDataJan.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataFeb = row.addCell();
            cellDataFeb.setText(planSpreadSheet.getFeb());
            cellDataFeb.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataMar = row.addCell();
            cellDataMar.setText(planSpreadSheet.getMar());
            cellDataMar.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataApr = row.addCell();
            cellDataApr.setText(planSpreadSheet.getApr());
            cellDataApr.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataMay = row.addCell();
            cellDataMay.setText(planSpreadSheet.getMay());
            cellDataMay.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataJun = row.addCell();
            cellDataJun.setText(planSpreadSheet.getJun());
            cellDataJun.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataJul = row.addCell();
            cellDataJul.setText(planSpreadSheet.getJul());
            cellDataJul.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataAug = row.addCell();
            cellDataAug.setText(planSpreadSheet.getAug());
            cellDataAug.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataSep = row.addCell();
            cellDataSep.setText(planSpreadSheet.getSep());
            cellDataSep.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataOct = row.addCell();
            cellDataOct.setText(planSpreadSheet.getOct());
            cellDataOct.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataNov = row.addCell();
            cellDataNov.setText(planSpreadSheet.getNov());
            cellDataNov.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataDec = row.addCell();
            cellDataDec.setText(planSpreadSheet.getDec());
            cellDataDec.setFillColor(new Color(240, 240, 240));
            XSLFTableCell cellDataTotal
                    = row.addCell();
            cellDataTotal.setText(planSpreadSheet.getRt());
            cellDataTotal.setFillColor(new Color(240, 240, 240));

            //planSpreadSheet.
        }

        // 3. Populate rows and cells
        // 4. Adjust column widths (e.g., set second column wider)
//        tbl.setColumnWidth(0, 100);
//        tbl.setColumnWidth(1, 200);
//        tbl.setColumnWidth(2, 150);
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
