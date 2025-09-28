/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint;

/**
 *
 * @author andrewhinton
 */

import org.apache.poi.xslf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Powerpoint {
    public static void main(String[] args) throws Exception {
        // Load the template
        FileInputStream fis = new FileInputStream("template.pptx");
        XMLSlideShow ppt = new XMLSlideShow(fis);
        fis.close();

        // Access the first slide (or iterate through slides)
        XSLFSlide slide = ppt.getSlides().get(0);

        // Find and update a text placeholder (e.g., title)
        for (XSLFTextShape shape : slide.getPlaceholders()) {
            if (shape.getTextType() == Placeholder.TITLE) { // Or check shape name/id
                shape.setText("New Presentation Title");
            }
        }

        // Add a new slide based on a layout from the template
        XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0); // Assuming one master
        XSLFSlideLayout titleAndContentLayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
        XSLFSlide newSlide = ppt.createSlide(titleAndContentLayout);
        newSlide.getPlaceholders().get(0).setText("New Slide Title");
        newSlide.getPlaceholders().get(1).setText("Content for the new slide.");


        // Save the new presentation
        FileOutputStream fos = new FileOutputStream("output.pptx");
        ppt.write(fos);
        fos.close();
        ppt.close();
    }
}


