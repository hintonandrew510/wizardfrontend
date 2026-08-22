/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package web.powerpoint.slide;

/**
 *
 * @author andrewhinton
 */
import web.*;
import java.text.BreakIterator;

// MavenprojectSCR {
import java.text.BreakIterator;

public class ParagraphHelper {
    public static String wrapText(String text, int lineLength) {
        if (text == null || text.length() <= lineLength) {
            return text;
        }

        StringBuilder formattedText = new StringBuilder();
        BreakIterator boundary = BreakIterator.getWordInstance();
        boundary.setText(text);

        int start = boundary.first();
        int currentLineLength = 0;

        for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
            String word = text.substring(start, end);
            
            // If adding the word exceeds the limit, wrap to a new line
            if (currentLineLength + word.length() > lineLength && currentLineLength > 0) {
                formattedText.append("\n");
                currentLineLength = 0;
                
                // Skip leading spaces on the new line
                if (word.startsWith(" ")) {
                    word = word.substring(1);
                }
            }
            
            formattedText.append(word);
            currentLineLength += word.length();
        }

        return formattedText.toString();
    }

    public static void main(String[] args) {
        String longString = "Java is a high-level, class-based, object-oriented programming language " +
                            "that is designed to have as few implementation dependencies as possible. " +
                            "It is intended to let programmers write once, run anywhere.";
        
        // Wrap text at 40 characters
        String paragraph = wrapText(longString, 40);
           String[] lines = paragraph.split("\\r?\\n");
        for (String line : lines) {
              System.out.println(line);
        }
        //System.out.println(paragraph);
    }
}
