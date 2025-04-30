package web.google.slide;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller // This means that this class is a Controller
public class GoogleSlideErrorController {
	private static final Logger mLog = LoggerFactory.getLogger(GoogleSlideErrorController.class.getName());

	@RequestMapping(value = "/GoogleErrorPage", method = RequestMethod.GET)
	public String displayErrorPage(Model model) {
		mLog.info("displayErrorPage");
		
		GoogleErrorModel errorModel;
	    if(ErrorSessionHelper.isAvailable()) {
	    	errorModel = ErrorSessionHelper.getGoogleErrorModel();
	    	model.addAttribute("errorModel", errorModel);
	    }
	    else {
	    	return "ERROR, no err available to display";
	    }
		
		
		mLog.trace(errorModel.getError());
	 return "googleerror";
	}

}
