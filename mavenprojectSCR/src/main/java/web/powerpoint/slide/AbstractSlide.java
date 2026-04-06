package web.powerpoint.slide;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.google.slide.SlideReplacementData;
import web.google.slide.SlidesData;
import web.model.Contact;

public abstract class AbstractSlide implements SlideInterface {

    private static final Logger mLog = LoggerFactory.getLogger(AbstractSlide.class.getName());
 @Override
    public SlidesData getmSlidesData() {
        return mSlidesData;
    }

    public void setmSlidesData(SlidesData mSlidesData) {
        this.mSlidesData = mSlidesData;
    }

    public String getPageName() {
        return pageName;
    }
    
    
    public Contact getContact() {
        return contact;
    }
    public String getSlideEnumName() {
        return slideEnum.name();
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @Override
    public SlidePageNameEnum getSlideEnum() {
        return slideEnum;
    }

    public void setSlideEnum(SlidePageNameEnum slideEnum) {
        this.slideEnum = slideEnum;
    }
    private SlidesData mSlidesData;
    private String pageName;
    private SlidePageNameEnum slideEnum;
    private Contact contact;
    private XMLSlideShow ppt;

    public AbstractSlide(SlidesData slidesData, SlidePageNameEnum slideEnum, String pageName,Contact contact,XMLSlideShow ppt ) {
        this.slideEnum = slideEnum;
        mSlidesData = slidesData;
        this.pageName = pageName;
        this.contact = contact;
        this.ppt = ppt;
    }
    
    public XMLSlideShow getPPT(){
        return this.ppt;
    }

    public String formatStringToCurrency(int currency) {
        String currencyStr = String.valueOf(currency);
        currencyStr = formatStringToCurrency(currencyStr);
        return currencyStr;
    }

    public String withLargeIntegers(String value) {
        try {
            double valuedouble = Double.parseDouble(value);
            DecimalFormat df = new DecimalFormat("###,###,###");
            return df.format(valuedouble);
        } catch (Exception e) {
            return "";
        }
    }

    public String formatStringToCurrency(String currency) {
        try {
            if (currency == null || currency == "") {
                return "";
            }
            double amount = Double.parseDouble(currency);
            NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
            usdCostFormat.setMaximumFractionDigits(0);
            String output = usdCostFormat.format(amount);
            return output;
        } catch (Exception ex) {

            return "";
        }
    }
    
     public void replaceTextOnSlide(List<SlideReplacementData> listData, XSLFSlide slide ) {
         for (SlideReplacementData slideReplacementData : listData) {
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
                            
                            String label = slideReplacementData.getGoogleSlideVariableName();
                            label = label.trim();
// Perform the replacement using standard Java string methods
                                if (text.contains(label)) {
                                String updatedText = text.replace(slideReplacementData.getGoogleSlideVariableName(), slideReplacementData.getGoogleSlideVariableValue());
                                // Set the new text in the text run
                                incomingTextRun.setText(updatedText);
                            }
                        }
                    }
                }
            }
         }
     }
    


}
