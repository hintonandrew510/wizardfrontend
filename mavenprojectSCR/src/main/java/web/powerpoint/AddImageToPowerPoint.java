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

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.sl.usermodel.PictureData;

public class AddImageToPowerPoint {

    public static void main(String[] args) {
        // 1. Create a new presentation
        XMLSlideShow ppt = new XMLSlideShow();

        // 2. Create a blank slide
        XSLFSlide slide = ppt.createSlide();

        try {
            // 3. Read the image file into a byte array
            File imageFile = new File("path/to/your/image.png"); // Replace with your image path
            InputStream is = new FileInputStream(imageFile);
            byte[] pictureData = IOUtils.toByteArray(is);
            is.close();

            // 4. Add the image data to the presentation
            // Use the correct PictureType for your image (PNG, JPEG, etc.)
            XSLFPictureData pd = ppt.addPicture(pictureData, PictureData.PictureType.PNG);

            // 5. Create a picture shape on the slide
            XSLFPictureShape picture = slide.createPicture(pd);

            // 6. Set the image position and size (anchor)
            // Rectangle(x-coordinate, y-coordinate, width, height)
            picture.setAnchor(new Rectangle(50, 50, 400, 300)); // Example coordinates and size

            // 7. Save the presentation to a file
            FileOutputStream out = new FileOutputStream("presentation_with_image.pptx");
            ppt.write(out);
            out.close();
            ppt.close();

            System.out.println("Image successfully added to presentation_with_image.pptx");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
