

const map = new Map();
map.set('introduceNewDepartmentLabel', 'Introduce New Department/Products/Services');
map.set('featureSpecificProductsLabel', 'Feature Specific Products/Services');
map.set('callAttentiontoBrandsPrivateLabelsCarriedLabel', 'Call Attention to Brands/Private Labels Carried');
map.set('promoteOffPriceItemsServicesLabel', 'Promote Off-price Items/Services');

map.set('quarterlySeasonalCampaignLabel', 'Establish a quarterly spike/seasonal campaign');

map.set('utilizeCoopVendorDollarsLabel', 'Utilize Co-op/Vendor Dollars');
map.set('retainCurrentConsumersLabel', 'Retain/Recapture Consumers');

map.set('increaseCustomerVisitsLabel', 'Increase Frequency of Customer Visits');
map.set('increaseTrafficLeadCallsLabel', 'Grow New Traffic/Lead Calls');
map.set('expandTargetConsumersLabel', 'Expand Target Consumers (by age, sex, geography)');
map.set('changeConsumerAttitudesLabel', 'Change Consumer Attitudes');
map.set('makePromotionalEventsStrongerLabel', 'Make Promotional Events Stronger');
map.set('increaseDigitalMobileOnlineResponseLabel', 'Develop Digital/Mobile/Social Strategies');
map.set('developDatabaseMarketingLabel', 'Develop Database Marketing (Email and Text)');
map.set('initiateCauseMarketingProgramLabel', 'Initiate Cause Marketing Programs');
map.set('developSpeciallyStagedEventLabel', 'Develop Specially Staged Events');
map.set('maintainMarketDominanceLabel', 'Maintain Market Dominance');
map.set('improveBusinessNameBrandLabel', 'Elevate Business Brand/Image');
map.set('establishorReestablishBusinessImageLabel', 'Improve Reputation and Listing Management');
map.set('createPentUpDemandLabel', 'Enhance Website (Mobile, Response, SEO, SEM)');
map.set('increaseMarketShareLabel', 'Increase Market Share');
map.set('otherLabel', 'Other:');


function addSelection(id) {
	console.group("addSelection");
	console.log("id " + id);
	var myElement = document.getElementById(id);
	 if(myElement){
		 console.log("id does exists " + id);

		 myElement.className = 'highlight';
	 } else {
		 console.log("id does NOT exists " + id);
	  }
	
	
	console.groupEnd();
	
	
	
	
 }


function addLabel(key) {
	
	console.group("addLabel");
	console.log("key [" + key + "]");
	var lookupKey = key;
	
	
	  var findString  = key.indexOf("-a");
	  console.log("findString 1 [" + findString + "]")
      if (findString == -1 ) {
    	  // did not find -a
    	  console.log("did not find -a")
    	  findString  = key.indexOf("-b");
    	  console.log("findString 2 [" + findString + "]")
          if (findString == -1 ) {
        	  console.log("did not find -b")
          } else {
        	  // found -b
        	  lookupKey = key.replace("-b", "");
        	  console.log("lookupKey -b [" + lookupKey + "]");
        	  
          }
    	  
    	  
    	  
      } else {
    	  // found -a
    	  lookupKey = key.replace("-a", "");
    	  console.log("lookupKey -a [" + lookupKey + "]");
    	  
      }
	
      
    

	
	
	
	try {
	   if (map.has(lookupKey)) {
	     var keyvalue = map.get(lookupKey);
	    document.getElementById(key).innerHTML = keyvalue;
	   } else {
		document.getElementById(key).innerHTML = lookupKey;
	   }
	} catch(err) {
		console.log("error finding key [" + lookupKey + "]");
	}
	
	console.groupEnd();
	
}

function addOtherText(otherTextLabel) {
	document.getElementById("otherLabel").innerHTML = otherTextLabel;
}

function getLabelText(key) {
	if (map.has(key)) {
	  var keyvalue = map.get(key);
	  return keyvalue;
	} else {
		return key;
	}
	
}
