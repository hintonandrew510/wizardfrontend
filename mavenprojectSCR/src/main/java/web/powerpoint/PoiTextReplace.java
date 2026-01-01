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
import java.io.IOException;
import java.util.List;

public class PoiTextReplace {

    public static void replaceTextInPresentation(String filePath, String oldText, String newText) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XMLSlideShow ppt = new XMLSlideShow(fis);
        fis.close();

        for (XSLFSlide slide : ppt.getSlides()) {
            // Iterate over all shapes in the slide
            for (XSLFShape shape : slide.getShapes()) {
                // Check if the shape is a text shape
                if (shape instanceof XSLFTextShape) {
                    XSLFTextShape textShape = (XSLFTextShape) shape;
                    List<XSLFTextParagraph> paragraphs = textShape.getTextParagraphs();

                    for (XSLFTextParagraph para : paragraphs) {
                        List<XSLFTextRun> textRuns = para.getTextRuns();
                        for (XSLFTextRun incomingTextRun : textRuns) {
                            String text = incomingTextRun.getRawText();
                            // Perform the replacement using standard Java string methods
                            if (text.contains(oldText)) {
                                String updatedText = text.replace(oldText, newText);
                                // Set the new text in the text run
                                incomingTextRun.setText(updatedText);
                            }
                        }
                    }
                }
            }
        }

        // Write the changes to a new file
        FileOutputStream out = new FileOutputStream(filePath.replace(".pptx", "_updated.pptx"));
        ppt.write(out);
        out.close();
        ppt.close();
    }

    public static void main(String[] args) {
        try {
            // Replace "input.pptx" with your actual file path
            replaceTextInPresentation("/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/powerpointtemplate/tvbak.pptx", "{{Name}}", "andrew");
            System.out.println("Text replacement complete. New file saved as input_updated.pptx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

