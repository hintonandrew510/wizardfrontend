/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.service;

import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.springframework.stereotype.Service;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author andrewhinton
 */
@Service
public class ReplaceImageInPlaceholderServiceImpl implements ReplaceImageInPlaceholderService{

    @Override
    public void replaceImageInSlide( XMLSlideShow ppt,String fileName, XSLFSlide slide) throws Exception{
            // 2. Load the image file into a byte array
        InputStream imageStream = new FileInputStream(fileName);
        byte[] pictureData = IOUtils.toByteArray(imageStream);
        imageStream.close();
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
        
        
    }
     
    
}
