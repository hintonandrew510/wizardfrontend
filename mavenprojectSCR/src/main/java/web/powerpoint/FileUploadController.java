/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.data.MyUserPrincipal;
import web.model.Contact;
import web.powerpoint.slide.PowerPointService;

@RestController
public class FileUploadController {

    private final String FILE_STORAGE_LOCATION = "/opt/wizard/download"; // Configure this path
        @Autowired
    private PowerPointService powerPointService;

    @RequestMapping(value = "/upload/slideshow/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable int id, Authentication authentication) {
        try {
            // Load the file from the resources folder
            //  Resource resourced = new ClassPathResource("static/" + fileName); // Assuming files are in src/main/resources/static
           // String fileName = createPowerPoint("1");
            //File downloadFile = new File(fileName);
            Path filePath = (Path) Paths.get(FILE_STORAGE_LOCATION).resolve("WWAY Wilmington_updated.pptx").normalize();
            Resource resource = new UrlResource(filePath.toUri());
            MyUserPrincipal userDetails = (MyUserPrincipal) authentication.getPrincipal();
            Contact contact = userDetails.getContact();
            //powerPointService.buildPowerPointDocument(id, contact);

            // ClassPathResource resource = new ClassPathResource("/powerpointtemplate/tv.pptx");
            //   Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() && resource.isReadable()) {
                // Determine content type
                String contentType = "application/vnd.openxmlformats-officedocument.presentationml.presentation"; // PPTX specific content type
                String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

                //String contentType = "application/vnd.openxmlformats-officedocument.presentationml.presentation"; // Default content type
                // You can add logic here to determine the actual content type based on file extension
                // For example: if (fileName.endsWith(".pdf")) contentType = MediaType.APPLICATION_PDF_VALUE;
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private String createPowerPoint(String id) throws Exception {
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
        return "/opt/wizard/download/output.pptx";
    }
}
