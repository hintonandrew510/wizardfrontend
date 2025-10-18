/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint;

/**
 *
 * @author andrewhinton
 */
import com.google.api.services.drive.model.File;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.springframework.core.io.ClassPathResource;
import java.io.InputStream;
import java.io.IOException;
import org.springframework.util.ResourceUtils;

public class Powerpoint {

    public static void main(String[] args) throws Exception {

        // Create a ClassPathResource object for the specified file
        ClassPathResource resource = new ClassPathResource("/powerpointtemplate/radio.pptx");

        java.io.File file = ResourceUtils.getFile("classpath:powerpointtemplate/tv.pptx");
        InputStream inputStream = new FileInputStream(file);
        String fileName = file.getCanonicalPath();
        System.out.println("file " + file.getCanonicalPath());
        String filePath = resource.getPath();
        System.out.println("filePath " + filePath);
        //InputStream inputStream = resource.getInputStream();

        // Load the template
        //  FileInputStream fis = new FileInputStream("/powerpointtemplate/radio.pptx");
        // XMLSlideShow ppt = new XMLSlideShow(inputStream);
        //  FileInputStream templateFile = new FileInputStream(filePath);
        XMLSlideShow ppt = new XMLSlideShow(inputStream);
        System.out.println("loaded pptx");
        int q = 2;
        //fis.close();
//
        // Access the first slide (or iterate through slides)
        XSLFSlide slide = ppt.getSlides().get(0);

        // Find and update a text placeholder
        for (XSLFTextShape shape : slide.getPlaceholders()) {
            if (shape.getText().contains("{{PLACEHOLDER_TITLE}}")) { // Assuming a placeholder like this
                shape.setText("Your New Title");
            }
            if (shape.getText().contains("{{PLACEHOLDER_CONTENT}}")) {
                shape.setText("This is the new content for the slide.");
            }
        }

        // Save the new presentation
        FileOutputStream fos = new FileOutputStream("/opt/wizard/download/output.pptx");
        ppt.write(fos);
        fos.close();
        ppt.close();
    }
}
