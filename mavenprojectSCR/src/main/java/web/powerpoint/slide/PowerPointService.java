/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author andrewhinton
 */
public interface PowerPointService {
    public String buildPowerPointDocument(int id);
    public FileInputStream readTemplate() throws IOException;
}
