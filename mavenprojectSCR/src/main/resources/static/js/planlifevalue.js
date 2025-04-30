function calculate()
{
	var averageSale = document.getElementById("averageSale").value;
	var grossProfitMargin = document.getElementById("grossProfitMargin").value;
	var averageRepeatSales = document.getElementById("averageRepeatSales").value;
	//alert ("averageRepeatSales " + averageRepeatSales);
	
	var yearsOfPatronage = document.getElementById("yearsOfPatronage").value;
	var monthlyInvestmentAverage= document.getElementById("monthlyInvestmentAverage").value;
	var averageSaleCal =0;
	var grossProfitMarginCal =0;
	var averageRepeatSalesCal =0;
	var yearsOfPatronageCal =0;
	var monthlyInvestmentAverageCal = 0;
	
	if (averageSale != null && 
		averageSale != "") {
		// tinas averageSale = averageSale.substring(1);
		// tinas averageSale = removeComma(averageSale);
		averageSale = convertToNumberFromCurrency(averageSale);
		averageSaleCal = Number(averageSale);
	}
	if (monthlyInvestmentAverage != null) {
		// monthlyInvestmentAverage = monthlyInvestmentAverage.substring(1);
		// monthlyInvestmentAverage = removeComma(monthlyInvestmentAverage);
		monthlyInvestmentAverage = convertToNumberFromCurrency(monthlyInvestmentAverage);
		monthlyInvestmentAverageCal = Number(monthlyInvestmentAverage);
	}
	
	if (grossProfitMargin != null) {
		grossProfitMarginCal = Number(grossProfitMargin);
		grossProfitMarginCal = grossProfitMarginCal/100;
	}
	
	if (averageRepeatSales != null) {
		averageRepeatSalesCal = Number(averageRepeatSales);
	}
	if (yearsOfPatronage != null) {
		yearsOfPatronageCal = Number(yearsOfPatronage);
	}
	var c_grossProfitPerSale = averageSaleCal * grossProfitMarginCal;
	var e_averageCustomerValue = c_grossProfitPerSale *  averageRepeatSalesCal;
	var g_lifetimeValuePerCustomer =e_averageCustomerValue * yearsOfPatronageCal;
	// tinas var i_prospectsNeededToBreakEven = Math.round(g_lifetimeValuePerCustomer / monthlyInvestmentAverageCal);
	var i_prospectsNeededToBreakEven = Math.round(monthlyInvestmentAverageCal / g_lifetimeValuePerCustomer * 10) / 10;
	
	if (Number.isNaN(i_prospectsNeededToBreakEven))
	{
		i_prospectsNeededToBreakEven = 0;
	}
	console.log(" averageRepeatSales " +  averageRepeatSales);
	console.log(" c_grossProfitPerSale " +  c_grossProfitPerSale);
	console.log(" e_averageCustomerValue " +  e_averageCustomerValue);
	console.log("g_lifetimeValuePerCustomer " +  g_lifetimeValuePerCustomer);
	console.log("i_prospectsNeededToBreakEven " +  i_prospectsNeededToBreakEven);
	
	// tinas document.getElementById("grossProfitPerSale").value =  formatCurrency(Math.round(c_grossProfitPerSale));
	document.getElementById("grossProfitPerSale").value =  FormatAmount(Math.round(c_grossProfitPerSale));
	document.getElementById("averageCustomerValue").value = FormatAmount(Math.round(e_averageCustomerValue));//e
	document.getElementById("lifetimeValuePerCustomer").value = FormatAmount(Math.round(g_lifetimeValuePerCustomer));
	document.getElementById("prospectsNeededToBreakEven").value = i_prospectsNeededToBreakEven;
}


function totalRow() {
	calculate();
	//document.getElementById("totalRow").value = total;
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
