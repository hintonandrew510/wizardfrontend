function totalRow() {
	calculate();
	//document.getElementById("totalRow").value = total;
}

function calculate()
{
	//clear
	console.clear();
	
	var planAMonthlyDigitalInvestment = document.getElementById("planAMonthlyDigitalInvestment").value;
	var planACostPerThousand = document.getElementById("planACostPerThousand").value;
	var planAClickThroughRate = document.getElementById("planAClickThroughRate").value;
	var planASalesConversionPercentage  = document.getElementById("planASalesConversionPercentage").value;
	//alert ("averageRepeatSales " + averageRepeatSales);
	
	var planAProjectedGrossProfit = document.getElementById("planAProjectedGrossProfit").value;
	var planAProjectedGrossProfit= document.getElementById("planAProjectedGrossProfit").value;
	var planAMonthlyDigitalInvestmentCal =0;
	var planACostPerThousandCal =1;
	var planAClickThroughRateCal =0;
	var planASalesConversionPercentageCal =0;
	var monthlyInvestmentAverageCal = 0;
	var planAMonthlyDigitalInvestmentCal = 0;
	
	
	if (planAProjectedGrossProfit != null && planAProjectedGrossProfit !="" ) {
		planAProjectedGrossProfit = planAProjectedGrossProfit.substring(1);
		planAProjectedGrossProfit = removeComma(planAProjectedGrossProfit);;
		planAProjectedGrossProfit = Number(planAProjectedGrossProfit);
	}
	
	if (planAMonthlyDigitalInvestment != null && planAMonthlyDigitalInvestment !="") {
		planAMonthlyDigitalInvestment = planAMonthlyDigitalInvestment.substring(1);
		planAMonthlyDigitalInvestment = removeComma(planAMonthlyDigitalInvestment);
		planAMonthlyDigitalInvestmentCal = Number(planAMonthlyDigitalInvestment);
	}
	
	
	
	
	if (planASalesConversionPercentage != null && planASalesConversionPercentage !="") {
		planASalesConversionPercentageCal = Number(planASalesConversionPercentage);
		planASalesConversionPercentageCal = planASalesConversionPercentageCal/100;
	}	
	
	if (planACostPerThousand != null && planACostPerThousand !="") {
		planACostPerThousand = planACostPerThousand.substring(1);
		planACostPerThousand = removeComma(planACostPerThousand);
		planACostPerThousandCal = Number(planACostPerThousand);
		
	} 
	
	if (planAClickThroughRate != null && planAClickThroughRate !="") {
		planAClickThroughRateCal = Number(planAClickThroughRate)/100;
	}
	
	var c_planAClosingPctNumber = (planAMonthlyDigitalInvestmentCal / planACostPerThousandCal) * 1000;
	var e_planAMonthlyClicks = c_planAClosingPctNumber *  planAClickThroughRateCal;
	
	var f_planACostPerClicks = (e_planAMonthlyClicks == 0) ? 0 : planAMonthlyDigitalInvestmentCal/e_planAMonthlyClicks;
	var h_planAMonthlyConversions = e_planAMonthlyClicks * planASalesConversionPercentageCal;
	var i_planACostPerConversion = (h_planAMonthlyConversions == 0) ? 0:Math.round(planAMonthlyDigitalInvestmentCal / h_planAMonthlyConversions);
	var k_planAMonthlyGrossProfit = Math.round(planAProjectedGrossProfit * h_planAMonthlyConversions);
	var l_planAMonthlyROID = Math.round(k_planAMonthlyGrossProfit - planAMonthlyDigitalInvestmentCal);
	var m_planAMonthlyROIP = Math.round(l_planAMonthlyROID / planAMonthlyDigitalInvestmentCal);
	console.log(" planAMonthlyDigitalInvestmentCal " +  planAMonthlyDigitalInvestmentCal);
	
	console.log(" c_planAClosingPctNumber " +  c_planAClosingPctNumber);
	console.log(" e_planAMonthlyClicks " +  e_planAMonthlyClicks);
	console.log(" f_planACostPerClicks " +  f_planACostPerClicks);
	console.log("h_planAMonthlyConversions " +  h_planAMonthlyConversions);
	console.log("i_planACostPerConversion " +  i_planACostPerConversion);
	console.log("k_planAMonthlyGrossProfit " +  k_planAMonthlyGrossProfit);
	console.log("l_planAMonthlyROID " +  l_planAMonthlyROID);
	console.log("m_planAMonthlyROIP " +  m_planAMonthlyROIP);
	
	document.getElementById("planAClosingPctNumber").value =  c_planAClosingPctNumber;
	document.getElementById("planAMonthlyClicks").value = e_planAMonthlyClicks;//e
	document.getElementById("planACostPerClicks").value = f_planACostPerClicks;
	document.getElementById("planAMonthlyConversions").value = h_planAMonthlyConversions;
	document.getElementById("planACostPerConversion").value = i_planACostPerConversion;
	document.getElementById("planAMonthlyGrossProfit").value = k_planAMonthlyGrossProfit;
	document.getElementById("planAMonthlyROID").value = l_planAMonthlyROID;
	document.getElementById("planAMonthlyROIP").value = m_planAMonthlyROIP;
}


