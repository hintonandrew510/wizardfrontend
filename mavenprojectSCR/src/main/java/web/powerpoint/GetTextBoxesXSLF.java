/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint;

/**
 *
 * @author andrewhinton
 */
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

public class GetTextBoxesXSLF {

    public static void main(String[] args) throws IOException {
        org.apache.poi.openxml4j.util.ZipSecureFile.setMinInflateRatio(0.001); // or a different value as needed

        FileInputStream fis = new FileInputStream("/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/powerpointtemplate/tv.pptx");
        XMLSlideShow pptxShow = new XMLSlideShow(fis);
        fis.close();
        int tableNumber = 0;
        for (XSLFSlide slide : pptxShow.getSlides()) {
            if (slide.getSlideNumber() == 4) {
                for (XSLFShape shape : slide.getShapes()) {
                    // Check if the shape is a text shape

                    if (shape instanceof XSLFTable) {
                        //System.out.println("Name of table " + shape);
                        XSLFTable table = (XSLFTable) shape;
                        tableNumber = tableNumber + 1;

                        System.out.println("table one " + tableNumber);

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
                                        //System.out.println(" parent " + r.getXmlObject().);

                                        System.out.println(" r.getRawText() " + r.getRawText());
                                        r.setBold(true);
                                        //content.append(r.getText());
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
                                // System.out.println("TextBox Content: " + text);
                            }
                        }
                    }
                }
                break;

            }
            System.out.println("--- Slide " + slide.getSlideNumber() + " ---");
            // Iterate through all shapes on the slide

        }
        pptxShow.close();
    }
}
