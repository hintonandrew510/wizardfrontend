package web.controller;

import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.data.MyUserPrincipal;
import web.google.slide.GoogleProfile;
import web.model.Agent;
import web.model.Wizard;
import web.page.JSONManager;
import web.repository.AgentRepository;
import web.service.AgentServiceImpl;
import web.util.EncryptionDecryptionManager;

@Controller // This means that this class is a Controller
public class GeneralController {
	
	private static final Logger mLog = LoggerFactory.getLogger(GeneralController.class.getName());
	
	@RequestMapping(value = "/")
	public String root() 
	{
		mLog.info("starting googleprofile");
		return "index";
	}
        @RequestMapping(value = "/about")
	public String showAbout() 
	{
		mLog.info("starting about");
		return "about";
	}
        //
	
	

	

}
