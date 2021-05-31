package web.google.slide;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




public class GoogleSlideErrorController {
	private static final Logger mLog = LoggerFactory.getLogger(GoogleSlideErrorController.class.getName());

	@RequestMapping(value = "/GoogleErrorPage", method = RequestMethod.POST)
	public String displayErrorPage() {
		mLog.info("displayErrorPage");
		
		GoogleErrorModel errorModel;
	    if(ErrorSessionHelper.isAvailable()) {
	    	errorModel = ErrorSessionHelper.getGoogleErrorModel();;
	    }
	    else {
	    	return "ERROR, no err available to display";
	    }
		
		
		mLog.trace(errorModel.getError());
	 return "googleerror";
	}

}
