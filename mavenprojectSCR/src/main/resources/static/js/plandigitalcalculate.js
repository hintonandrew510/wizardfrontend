function totalRow() {
	calculate();
	// document.getElementById("totalRow").value = total;
}

function calculate() {
	// clear
	console.clear();

	var planAMonthlyDigitalInvestment = document
			.getElementById("planAMonthlyDigitalInvestment").value;
	var planACostPerThousand = document.getElementById("planACostPerThousand").value;
	var planAClickThroughRate = document
			.getElementById("planAClickThroughRate").value;
	var planASalesConversionPercentage = document
			.getElementById("planASalesConversionPercentage").value;
	// alert ("averageRepeatSales " + averageRepeatSales);

	var planAProjectedGrossProfit = document
			.getElementById("planAProjectedGrossProfit").value;
	var planAProjectedGrossProfit = document
			.getElementById("planAProjectedGrossProfit").value;
	var planAMonthlyDigitalInvestmentCal = 0;
	var planACostPerThousandCal = 0;
	var planAClickThroughRateCal = 0;
	var planASalesConversionPercentageCal = 0;
	var monthlyInvestmentAverageCal = 0;
	var planAMonthlyDigitalInvestmentCal = 0;

	if (planAProjectedGrossProfit != null && planAProjectedGrossProfit != "") {
		// tinas planAProjectedGrossProfit = planAProjectedGrossProfit.substring(1);
		// tinas planAProjectedGrossProfit = removeComma(planAProjectedGrossProfit);
		
		// tinas planAProjectedGrossProfit = Number(planAProjectedGrossProfit);
		planAProjectedGrossProfit = convertToNumberFromCurrency(planAProjectedGrossProfit);
	}

	if (planAMonthlyDigitalInvestment != null
			&& planAMonthlyDigitalInvestment != "") {
		// tinas planAMonthlyDigitalInvestment = planAMonthlyDigitalInvestment.substring(1);
		// tinas planAMonthlyDigitalInvestmentCal = removeComma(planAMonthlyDigitalInvestment);
		// tinas planAMonthlyDigitalInvestmentCal = Number(planAMonthlyDigitalInvestment);
		planAMonthlyDigitalInvestmentCal = convertToNumberFromCurrency(planAMonthlyDigitalInvestment);
	}

	if (planASalesConversionPercentage != null
			&& planASalesConversionPercentage != "") {
		planASalesConversionPercentageCal = Number(planASalesConversionPercentage);
		planASalesConversionPercentageCal = planASalesConversionPercentageCal / 100;
	}

	if (planACostPerThousand != null && planACostPerThousand != "") {
		// tinas planACostPerThousand = planACostPerThousand.substring(1);
		// tinas planACostPerThousand = removeComma(planACostPerThousand);
		// tinas planACostPerThousandCal = Number(planACostPerThousand);
		planACostPerThousandCal = convertToNumberFromCurrency(planACostPerThousand);
	}

	if (planAClickThroughRate != null && planAClickThroughRate != "") {
		planAClickThroughRateCal = Number(planAClickThroughRate) / 100;
	}

	var c_planAClosingPctNumber = 0;
	if (planACostPerThousandCal != 0) {
		c_planAClosingPctNumber = (planAMonthlyDigitalInvestmentCal / planACostPerThousandCal) * 1000;
	}

	var e_planAMonthlyClicks = c_planAClosingPctNumber
			* planAClickThroughRateCal;

	var f_planACostPerClicks = (e_planAMonthlyClicks == 0) ? 0
			: planAMonthlyDigitalInvestmentCal / e_planAMonthlyClicks;
	var h_planAMonthlyConversions = e_planAMonthlyClicks
			* planASalesConversionPercentageCal;
	var i_planACostPerConversion = (h_planAMonthlyConversions == 0) ? 0
			: Math.round(planAMonthlyDigitalInvestmentCal
					/ h_planAMonthlyConversions);
	var k_planAMonthlyGrossProfit = Math.round(planAProjectedGrossProfit
			* h_planAMonthlyConversions);
	var l_planAMonthlyROID = Math.round(k_planAMonthlyGrossProfit
			- planAMonthlyDigitalInvestmentCal);
	var m_planAMonthlyROIP = l_planAMonthlyROID
			/ planAMonthlyDigitalInvestmentCal * 100;
	
	if (Number.isNaN(m_planAMonthlyROIP))
	{
		m_planAMonthlyROIP = 0;
	}
	console.log(" planAMonthlyDigitalInvestmentCal " + planAMonthlyDigitalInvestmentCal);
	console.log(" c_planAClosingPctNumber " + c_planAClosingPctNumber);
	console.log(" e_planAMonthlyClicks " + e_planAMonthlyClicks);
	console.log(" f_planACostPerClicks " + f_planACostPerClicks);
	console.log("h_planAMonthlyConversions " + h_planAMonthlyConversions);
	console.log("i_planACostPerConversion " + i_planACostPerConversion);
	console.log("k_planAMonthlyGrossProfit " + k_planAMonthlyGrossProfit);
	console.log("l_planAMonthlyROID " + l_planAMonthlyROID);
	console.log("m_planAMonthlyROIP " + m_planAMonthlyROIP);

	c_planAClosingPctNumber = Math.round(c_planAClosingPctNumber);
	
	document.getElementById("planAClosingPctNumber").value = c_planAClosingPctNumber;
	document.getElementById("planAMonthlyClicks").value = Math.round(e_planAMonthlyClicks);// e
	document.getElementById("planACostPerClicks").value = FormatAmount(Math.round(f_planACostPerClicks));
	document.getElementById("planAMonthlyConversions").value = Math.round(h_planAMonthlyConversions);
	document.getElementById("planACostPerConversion").value = FormatAmount(i_planACostPerConversion);
	document.getElementById("planAMonthlyGrossProfit").value = FormatAmount(k_planAMonthlyGrossProfit);
	document.getElementById("planAMonthlyROID").value = FormatAmount(l_planAMonthlyROID);
	//document.getElementById("planAMonthlyROIP").value = m_planAMonthlyROIP;
	document.getElementById("planAMonthlyROIP").value = Math.round(m_planAMonthlyROIP);
}


function FormatAmount(amount) {
	var i = parseFloat(amount);
	if(isNaN(i)) { i = 0.00; }
	var minus = '';
	if(i < 0) { minus = '-'; }
	i = Math.abs(i);
	i = parseInt((i + .005) * 100);
	i = i / 100;
	s = new String(i);
	if(s.indexOf('.') < 0) { s += '.00'; }
	if(s.indexOf('.') == (s.length - 2)) { s += '0'; }
	//s = minus + s;
	if(s.indexOf('.') > 0) { s = s.substr(0,s.indexOf('.')); }
	
	s = "$" + s.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    if (minus.length > 0) { s = "(" + s + ")";}
	return s;
}

function convertToNumberFromCurrency(currency)
{
	if (currency == null) {
		return 0;
	}
		
	var convert = currency.substring(1);
	convert = removeComma(convert);
	convert = Number(convert);
	return convert;


}

function removeComma(currency){
	var position = currency.indexOf(",");
	while(position > 0) {
		currency  = currency.replace(",","");
		position = currency.indexOf(",");
	}
	return currency;
}

//initial
calculate();
