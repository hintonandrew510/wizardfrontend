/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide;

import org.apache.poi.xslf.usermodel.XSLFSlide;
import web.google.slide.SlidesData;


/**
 *
 * @author andrewhinton
 */
public interface SlideInterface {
    public void populateSlide(XSLFSlide slide);
    public SlidesData getmSlidesData();
    public SlidePageNameEnum getSlideEnum();
    
}
