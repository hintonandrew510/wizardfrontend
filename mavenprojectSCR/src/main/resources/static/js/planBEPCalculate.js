function calculate()
{
	
	//var planAAverageSale = formatNumber(document.getElementById("planAAverageSale").value); // a
	var planAAverageSale = convertToNumberFromCurrency(document.getElementById("planAAverageSale").value); //a
	//var planAAverageSale = document.getElementById("planAAverageSale").value; // a
	var planAGrossMargin = document.getElementById("planAGrossMargin").value; // b
	var planAClosingPct = document.getElementById("planAClosingPct").value; // c 
	var planAProspectValue = 0;
	var planAProspectValueRaw = 0;
	
	if (document.getElementById("planAGrossMargin").value != null &&
		document.getElementById("planAGrossMargin").value != ""	&&
		document.getElementById("planAClosingPct").value != null &&
		document.getElementById("planAClosingPct").value != "")
	{
		    planAProspectValue= FormatAmount(Math.round(planAAverageSale * (planAGrossMargin/100) * (planAClosingPct/100)));
		    planAProspectValueRaw = planAAverageSale * (planAGrossMargin/100) * (planAClosingPct/100);
	}
	
	//var planAInvestment = formatNumber(document.getElementById("planAInvestment").value); // e
	var planAInvestment = convertToNumberFromCurrency(document.getElementById("planAInvestment").value); // e
	var planAProspectsNeeded = planAProspectValueRaw == 0 ? 0 : planAInvestment/planAProspectValueRaw ; // f = e/d
	var planAProspectSalesNeeded = planAProspectsNeeded * (planAClosingPct/100) ; // g = fc
	
	if (Number.isNaN(planAProspectSalesNeeded))
	{
		planAProspectSalesNeeded = 0;
	}
	
	var planAGrossProfitOnSales = planAProspectSalesNeeded * planAAverageSale; // h = ga
	var planAMonths = convertIntToNumber(document.getElementById("planAMonths").value); // i
	var planAAdditionalGrossSales = planAGrossProfitOnSales * planAMonths; // j = hi
	
	document.getElementById("planAAverageSale").value = FormatAmount(planAAverageSale);
	//document.getElementById("planAAverageSale").value = planAAverageSale;
	document.getElementById("planAInvestment").value = FormatAmount(planAInvestment);
	document.getElementById("planAProspectValue").value =  planAProspectValue;
	//document.getElementById("planAProspectValue").value =  55;
	document.getElementById("planAProspectsNeeded").value =  Math.round(planAProspectsNeeded * 10) / 10;
	document.getElementById("planAProspectSalesNeeded").value =  Math.round(planAProspectSalesNeeded * 10) / 10;	
	document.getElementById("planAGrossProfitOnSales").value =  FormatAmount(Math.round(planAGrossProfitOnSales));
	document.getElementById("planAAdditionalGrossSales").value =  FormatAmount(Math.round(planAAdditionalGrossSales));
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
	s = minus + s;
	if(s.indexOf('.') > 0) { s = s.substr(0,s.indexOf('.')); }
	s = "$" + s.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	return s;
}

function convertToNumberFromCurrency(currency)
{
	//if (currency == null) {
	//	return 0;
	//}
		
	//var convert = currency.substring(1);
	var convert = currency.replace(/,/g, '').replace('$', '');
	//convert = Number(convert);
	return convert;
}

//initial
calculate();
