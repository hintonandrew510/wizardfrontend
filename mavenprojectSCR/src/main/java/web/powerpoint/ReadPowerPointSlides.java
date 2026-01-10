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

public class ReadPowerPointSlides {

    public static void main(String[] args) {
        org.apache.poi.openxml4j.util.ZipSecureFile.setMinInflateRatio(0.001); // or a different value as needed

             String fileName ="/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/powerpointtemplate/tv.pptx";
       
        try (FileInputStream input = new FileInputStream(fileName);
             XMLSlideShow ppt = new XMLSlideShow(input)) { //

            List<XSLFSlide> slides = ppt.getSlides();
            
             for (XSLFSlide slide : ppt.getSlides()) {
                  System.out.println("name " + slide.getSlideName());
                   System.out.println("name " + slide.getTitle());
                  System.out.println("number " + slide.getSlideNumber());
                //  System.out.println("name " + slide.
                 List<XSLFComment>  comments = slide.getComments();
                 for (XSLFComment comment : comments) {
                   System.out.println("comment " + comment.getText());
                     
                 }
             }

         
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
