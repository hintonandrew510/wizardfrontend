/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.helper;

import java.awt.Color;
import java.io.FileOutputStream;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

public class RedCheckboxCreator {
    public static void main(String[] args) {
        try (XMLSlideShow ppt = new XMLSlideShow()) {
            // Create a blank slide
            XSLFSlide slide = ppt.createSlide();

            // Create a text box to hold the checkbox line
            XSLFTextBox textBox = slide.createTextBox();
            textBox.setAnchor(new java.awt.Rectangle(100, 100, 400, 50));

            XSLFTextParagraph paragraph = textBox.addNewTextParagraph();

            // 1. Create the RED CHECKBOX run
            XSLFTextRun checkboxRun = paragraph.addNewTextRun();
            
            // Common Unicode Checkbox Symbols:
            // "\u2611" = Ballot Box with Check
            // "\u2612" = Ballot Box with X
            // "\u2610" = Empty Ballot Box
            checkboxRun.setText("\u2611 "); 
            
            // Set the font to a standard style that supports Unicode symbols well
            checkboxRun.setFontFamily("Segoe UI Symbol"); 
            checkboxRun.setFontSize(24.0);
            
            // Apply the RED color to the checkbox
            checkboxRun.setFontColor(Color.RED);

            // 2. Create the standard text run following the checkbox
            XSLFTextRun textRun = paragraph.addNewTextRun();
            textRun.setText("This is an item with a red checkbox.");
            textRun.setFontFamily("Arial");
            textRun.setFontSize(18.0);
            textRun.setFontColor(Color.BLACK);

            // Save the presentation
            try (FileOutputStream out = new FileOutputStream("red_checkbox.pptx")) {
                ppt.write(out);
            }
            System.out.println("Presentation created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

