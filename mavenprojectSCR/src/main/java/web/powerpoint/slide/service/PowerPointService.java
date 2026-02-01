/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.service;

import java.io.IOException;
import java.io.InputStream;
import web.model.Contact;

/**
 *
 * @author andrewhinton
 */
public interface PowerPointService {
    public String buildPowerPointDocument(int wizardId, Contact contact);
    public InputStream readTemplate(String clientType) throws IOException;
}
