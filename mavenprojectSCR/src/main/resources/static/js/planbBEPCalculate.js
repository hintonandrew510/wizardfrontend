function calculate()
{
	var planBAverageSale = convertToNumberFromCurrency(document.getElementById("planBAverageSale").value); // a
	var planBGrossMargin = document.getElementById("planBGrossMargin").value; // b
	var planBClosingPct = document.getElementById("planBClosingPct").value; // c 
	var planBProspectValue = convertToNumberFromCurrency(document.getElementById("planBProspectValue").value); // d
	var planBInvestment = convertToNumberFromCurrency(document.getElementById("planBInvestment").value); // e
	var f_planBProspectsNeededRaw = planBInvestment / (planBAverageSale * (planBGrossMargin/100) * (planBClosingPct/100));
	
	var g_planBProspectSalesNeeded = f_planBProspectsNeededRaw * (planBClosingPct/100); // g = f * c;
	
	if (Number.isNaN(g_planBProspectSalesNeeded))
	{
		g_planBProspectSalesNeeded = 0;
	}
	
	var h_planBGrossProfitOnSales = g_planBProspectSalesNeeded * planBAverageSale; // h = g * a;
	
	// tinas var planBGrossProfitOnSales = convertToNumberFromCurrency(document.getElementById("planBGrossProfitOnSales").value); // h
	var i_planBMonthsRaw = convertIntToNumber(document.getElementById("planBMonths").value); // i
	
	var planBAdditionalGrossSales = h_planBGrossProfitOnSales * i_planBMonthsRaw; // j = hi
	
	
	document.getElementById("planBProspectsNeeded").value =  Math.round(f_planBProspectsNeededRaw * 10) / 10;
	document.getElementById("planBProspectSalesNeeded").value =  Math.round(g_planBProspectSalesNeeded * 10) / 10;
	document.getElementById("planBGrossProfitOnSales").value =  FormatAmount(Math.round(h_planBGrossProfitOnSales));
	
	document.getElementById("planBAdditionalGrossSales").value =  FormatAmount(Math.round(planBAdditionalGrossSales));
	document.getElementById("planBMonths").value =  i_planBMonthsRaw;
	document.getElementById("planBAdditionalGrossSales").value =  FormatAmount(Math.round(planBAdditionalGrossSales));
	
	
	/*
	//var planBAverageSale = convertToNumberFromCurrency(document.getElementById("planBAverageSale").value); // a
	var planBAverageSale = document.getElementById("planBAverageSale").value; // a
	var planBGrossMargin = document.getElementById("planBGrossMargin").value; // b
	var planBClosingPct = document.getElementById("planBClosingPct").value; // c 
	var planBProspectValue = 0;
	var planBProspectValueRaw = 0;
	
	if (document.getElementById("planBGrossMargin").value != null &&
		document.getElementById("planBGrossMargin").value != ""	&&
		document.getElementById("planBClosingPct").value != null &&
		document.getElementById("planBClosingPct").value != "")
	{
		    planBProspectValue= FormatAmount(Math.round( convertToNumberFromCurrency(planBAverageSale) * (planBGrossMargin/100) * (planBClosingPct/100)));
		    planBProspectValueRaw = convertToNumberFromCurrency(planBAverageSale) * (planBGrossMargin/100) * (planBClosingPct/100);
	}
	
	var planBInvestment = convertToNumberFromCurrency(document.getElementById("planBInvestment").value); // e
	var planBProspectsNeeded = planBProspectValue == 0 ? 0 : planBInvestment/planBProspectValueRaw ; // f = e/d
	var planBProspectSalesNeeded = planBProspectsNeeded * (planBClosingPct/100) ; // g = fc
	var planBGrossProfitOnSales = planBProspectSalesNeeded * planBAverageSale; // h = ga
	var planBMonths = convertIntToNumber(document.getElementById("planBMonths").value); // i
	var planBAdditionalGrossSales = planBGrossProfitOnSales * planBMonths; // j = hi
	
	//document.getElementById("planBAverageSale").value = FormatAmount(planBAverageSale);
	document.getElementById("planBAverageSale").value = planBAverageSale;
	document.getElementById("planBInvestment").value = FormatAmount(planBInvestment);
	document.getElementById("planBProspectValue").value =  planBProspectValue;
	document.getElementById("planBProspectsNeeded").value =  Math.round(planBProspectsNeeded * 10) / 10;
	document.getElementById("planBProspectSalesNeeded").value =  Math.round(planBProspectSalesNeeded *10) / 10;	
	document.getElementById("planBGrossProfitOnSales").value =  FormatAmount(Math.round(planBGrossProfitOnSales));
	document.getElementById("planBAdditionalGrossSales").value =  FormatAmount(Math.round(planBAdditionalGrossSales));
	*/
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
//initial
calculate();


