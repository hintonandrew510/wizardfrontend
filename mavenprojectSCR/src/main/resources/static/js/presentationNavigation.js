let navigationMap = new Map();
//load map
navigationMap.set(1,"PresentedToPage");
navigationMap.set(2,"TeamCommitmentPage");
navigationMap.set(3,"MarketPlaceCompetitionPage");
navigationMap.set(4,"ClientObjectivesPage");
navigationMap.set(5,"StrategicMarketingPageTwo");
navigationMap.set(6,"TargetMarketingPage");
navigationMap.set(7,"ConfidentialClientEvaluationPageData");
navigationMap.set(8,"ConfidentialClientEvaluationLastYearPage");
navigationMap.set(9,"ConfidentialClientEvaluationProposedPage");
navigationMap.set(10,"ProfileOfConsumersPage");
navigationMap.set(11,"MarketingStrategiesPage");
navigationMap.set(12,"CreateConceptOne");
navigationMap.set(13,"CreateConceptTwo");
navigationMap.set(14,"DigitalMobileSocialStrategies");
navigationMap.set(15,"LongRangeStrategicPlansPage");
navigationMap.set(16,"AdvantagesLongRange");
navigationMap.set(17,"PlanAMediaPage");
navigationMap.set(18,"PlanAExcelPage");
navigationMap.set(19,"PlanAProposedPage");
navigationMap.set(20,"PlanABEPPage");
navigationMap.set(21,"PlanALifetimeValuedPage");
navigationMap.set(22,"PlanADigitalROICalculator");
navigationMap.set(23,"PlanBMediaPage");
navigationMap.set(24,"PlanBExcelPage");
navigationMap.set(25,"PlanBProposedPage");
navigationMap.set(26,"PlanBBEPPage");
navigationMap.set(27,"PlanBLifetimeValuedPage");
navigationMap.set(28,"PlanBDigitalROICalculator");
navigationMap.set(29,"PlanAMediaPageFlightDates");
navigationMap.set(30,"PlanBMediaPageFlightDates");
navigationMap.set(31,"ClientPolicyAgreementPage");
navigationMap.set(32,"SalesServiceAgreementPage");
//navigationMap.set(1,"PresentedToPage");
//navigationMap.set(1,"PresentedToPage");


function gotoAnchor(anchorID,direction) {
	console.group("gotoAnchor");
	var elementToScroll = null;
	
	

	var elmnt = null;
	var found = false;
	
	while(found == false) {
		
		elementToScroll = navigationMap.get(anchorID);
		if (typeof elementToScroll == "undefined"  ) {
			console.log("not found [" + anchorID + "]");
			break;
		}
		console.log("section [" + elementToScroll + "]");
		elmnt = document.getElementById(elementToScroll);
		if (elmnt != null) {
			console.log("found [" + anchorID + "]");
			break;
		} else {
			if (direction == "down") {
				anchorID = anchorID + 1;
				console.log("down [" + anchorID + "]");
				continue;
			} else {
				anchorID = anchorID - 1;
				console.log("up [" + anchorID + "]");
				continue;
			}
		}//outter if
		
		
	}//end of while
	
	if (elmnt != null ) { 
	    elmnt.scrollIntoView();
    }
	console.groupEnd();
}

