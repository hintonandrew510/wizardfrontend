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
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFComment;
import org.apache.poi.xslf.usermodel.XSLFGraphicFrame;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

public class ReadPowerPointSlides {

    public static void display(XSLFSlide slide) {
        org.apache.poi.openxml4j.util.ZipSecureFile.setMinInflateRatio(0.001); // or a different value as needed

        System.out.println("name " + slide.getSlideName());
        System.out.println("name " + slide.getTitle());
        System.out.println("number " + slide.getSlideNumber());
        //  System.out.println("name " + slide.
        List<XSLFComment> comments = slide.getComments();
        for (XSLFComment comment : comments) {
            System.out.println("comment " + comment.getText());

        }

        for (XSLFShape shape : slide.getShapes()) {
            if (shape instanceof XSLFGraphicFrame) {
                XSLFGraphicFrame xslFGraphicFrame = (XSLFGraphicFrame) shape;
                String shapeName = xslFGraphicFrame.getShapeName();
                System.out.println(shapeName);
                break;

                // Check if it's a placeholder you want to replace (can use shape name or type)
                // if (picShape.getPlaceholder() != null && picShape.getPlaceholder().getPlaceholderDetails().getPlaceholder().name().equals("Picture Placeholder 1 Name")) {
                // This is a simplified representation.
                // Directly replacing the image content of an existing XSLFPictureShape is complex.
                // A more common approach is to *delete* the existing picture shape and *create* a new one in its place.
                //}
            }
        }
        
        
        for (XSLFShape shape : slide.getShapes()) {
            // Check if the shape is a text shape
            if (shape instanceof XSLFTextShape) {
                XSLFTextShape textShape = (XSLFTextShape) shape;
                List<XSLFTextParagraph> paragraphs = textShape.getTextParagraphs();

                for (XSLFTextParagraph para : paragraphs) {
                    List<XSLFTextRun> textRuns = para.getTextRuns();
                    for (XSLFTextRun incomingTextRun : textRuns) {
                        String text = incomingTextRun.getRawText();
                        text = text.trim();
                        System.out.println("text " + text);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        org.apache.poi.openxml4j.util.ZipSecureFile.setMinInflateRatio(0.001); // or a different value as needed

        String fileName = "/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/powerpointtemplate/tv.pptx";

        try (FileInputStream input = new FileInputStream(fileName); XMLSlideShow ppt = new XMLSlideShow(input)) { //

            List<XSLFSlide> slides = ppt.getSlides();

            for (XSLFSlide slide : ppt.getSlides()) {
                System.out.println("name " + slide.getSlideName());
                System.out.println("name " + slide.getTitle());
                System.out.println("number " + slide.getSlideNumber());
                //  System.out.println("name " + slide.
                List<XSLFComment> comments = slide.getComments();
                for (XSLFComment comment : comments) {
                    System.out.println("comment " + comment.getText());

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
