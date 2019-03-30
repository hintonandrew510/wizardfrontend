package web.page.planproposedpage;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.model.Wizard;
import web.model.WizardData;
import web.page.Pages;
import web.page.JSONManager;
import web.page.PageNameEnum;
import web.repository.WizardDataRepository;
import web.repository.WizardRepository;


@Controller    // This means that this class is a Controller
public class PlanBProposedPageController {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private WizardRepository wizardRepository;
	
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private WizardDataRepository wizardDataRepository;

	private static final Logger mLog = Logger.getLogger(PlanBProposedPageController.class.getName());
	@RequestMapping(value = "/PlanBProposedPage", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam String ID) {
		mLog.info("starting detail");
		//get wizard header 
		Optional<Wizard> wizardOpt = wizardRepository.findById(Integer.valueOf(ID));
		Wizard wizard = wizardOpt.orElse(null);
		WizardData wizardData = wizardDataRepository.findByPagesequenceAndWizardid(Pages.PlanBProposedPage.getPageSequence(), wizard.getWizardid());
		PlanProposedPageModel dataPageModel = null;
		if (wizardData != null) {
			dataPageModel =(PlanProposedPageModel)JSONManager.convertFromJson(wizardData.getPagedata(),PlanProposedPageModel.class);
			
		}
		//DemographicManager.convertFromJson(json)
		model.addAttribute("wizardData", wizardData);
		model.addAttribute("dataPageModel", dataPageModel);
		model.addAttribute("wizard", wizard);
		return "pages/PlanAProposedPage";
	}
	
	@RequestMapping(value = "/savePlanBProposedPage", method = RequestMethod.POST) // replace with my class variables
	public String save(@RequestParam String wizardId
			,@RequestParam String planACity
			,@RequestParam String planAReach
			,@RequestParam String planAFrequency
			,@RequestParam String planADigitalImpressionsMonthly
			,@RequestParam String planAMonthly
			,@RequestParam String planADaily
			,@RequestParam String wizarddataid
			,@RequestParam String nextPage
			,@RequestParam String publishNextPage
			,@RequestParam(required=false, value="next") String next
	        ,@RequestParam(required=false, value="publish") String publish){
		mLog.info("starting save");
		
		//internal next page or publish
		String internalNextPage = nextPage;
		if (publish != null) {
			internalNextPage= publishNextPage;
		}
		
		WizardData wizardData = new WizardData();
		wizardData.setPagename(PageNameEnum.PlanBProposedPage.toString());
		wizardData.setPagesequence(Pages.PlanBProposedPage.getPageSequence());
		if (wizarddataid != null && wizarddataid.trim().length() > 0 ) {
			Integer wizardDataInt = Integer.valueOf(wizarddataid);
			wizardData.setWizarddataid(wizardDataInt);
		}
		Integer wizardIdInt = Integer.valueOf(wizardId);
		wizardData.setWizardid(wizardIdInt); //todo - fix constuctor
		PlanProposedPageModel demographic  = new PlanProposedPageModel(planACity, planAReach, planAFrequency, planADigitalImpressionsMonthly, planAMonthly, planADaily);
		String pageData = JSONManager.convertToJson(demographic);
		
		wizardData.setPagedata(pageData);
		wizardDataRepository.save(wizardData);
		//model.addAttribute("wizard", wizard);
		return internalNextPage;
	}
	
}