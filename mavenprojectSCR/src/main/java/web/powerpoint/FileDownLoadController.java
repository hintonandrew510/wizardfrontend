/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.data.MyUserPrincipal;

/**
 *
 * @author andrewhinton
 */
@Controller // This means that this class is a Controller
public class FileDownLoadController {
     private static final Logger mLog = LoggerFactory.getLogger(FileDownLoadController.class.getName());

       @GetMapping(path = "/displaydownload")
	public String displaydownload(Model model, Authentication authentication) {
		mLog.info("starting about");

		MyUserPrincipal userDetails = (MyUserPrincipal) authentication.getPrincipal();

		
		model.addAttribute("contact", userDetails.getContact());

		return "displaydownload";

	}

}
