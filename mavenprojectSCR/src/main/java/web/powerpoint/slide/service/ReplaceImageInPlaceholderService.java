/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.service;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import web.powerpoint.entity.PieEntity;

/**
 *
 * @author andrewhinton
 */
public interface ReplaceImageInPlaceholderService {
      public void replaceImageInSlide( XMLSlideShow ppt, String fileName, XSLFSlide slide) throws Exception;
    
}
