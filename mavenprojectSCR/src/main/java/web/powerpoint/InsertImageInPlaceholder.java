/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint;

/**
 *
 * @author andrewhinton
 */
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class InsertImageInPlaceholder {

    public static void main(String[] args) throws Exception {
        // 1. Open the existing presentation
        FileInputStream fis = new FileInputStream("/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/powerpointtemplate/image.pptx");
        XMLSlideShow ppt = new XMLSlideShow(fis);
        fis.close();

        // 2. Load the image file into a byte array
        InputStream imageStream = new FileInputStream("/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/powerpointtemplate/BarChart.jpeg");
        byte[] pictureData = IOUtils.toByteArray(imageStream);
        imageStream.close();

        // Add the image data to the presentation's picture library
        //XSLFPictureData pd = ppt.addPicture(pictureData, PictureData.PictureType.PNG);
        // Find the slide with the placeholder (e.g., the first slide)
        XSLFSlide slide = ppt.getSlides().get(0);
//XSLFGraphicFrame
        // Iterate through shapes to find the picture placeholder
        Rectangle2D anchor = null;
        for (XSLFShape shape : slide.getShapes()) {
            if (shape instanceof XSLFGraphicFrame) {
                XSLFGraphicFrame xslFGraphicFrame = (XSLFGraphicFrame) shape;
                anchor = shape.getAnchor();
                slide.removeShape(xslFGraphicFrame);
                break;

                // Check if it's a placeholder you want to replace (can use shape name or type)
                // if (picShape.getPlaceholder() != null && picShape.getPlaceholder().getPlaceholderDetails().getPlaceholder().name().equals("Picture Placeholder 1 Name")) {
                // This is a simplified representation.
                // Directly replacing the image content of an existing XSLFPictureShape is complex.
                // A more common approach is to *delete* the existing picture shape and *create* a new one in its place.
                //}
            }
        }
        if (anchor != null) {
            XSLFPictureData pd = ppt.addPicture(pictureData, XSLFPictureData.PictureType.JPEG);
            XSLFPictureShape picture = slide.createPicture(pd);
            picture.setAnchor(anchor);

        }
        FileOutputStream out = new FileOutputStream("./output.pptx");
      
        ppt.write(out);
        out.close();
        ppt.close();

    }
}
