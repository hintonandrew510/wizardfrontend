var monthlyAverage =0;
var dailyCost = 0;
var monthlyAverageB =0;
var dailyCostB = 0;

function dailyCostAndMonthlyAverageB()
{
	
	console.group("dailyCostAndMonthlyAverageB");
	console.log("monthlyAverageB " + monthlyAverageB);
	console.log("dailyCost " + dailyCostB);
	var monthlyAverageFormattted = CurrencyFormatted(monthlyAverageB);
	var dailyCostFormattted = CurrencyFormatted(dailyCostB);
	console.log("monthlyAverageFormattted " + monthlyAverageFormattted);
	console.log("dailyCostFormattted " + dailyCostFormattted);
	
	console.groupEnd();
	
	document.getElementById("monthlyAverageIdB").textContent = monthlyAverageFormattted;
	document.getElementById("dailyCostIdB").textContent = dailyCostFormattted;
}	




function dailyCostAndMonthlyAverage()
{
	
	console.group("dailyCostAndMonthlyAverage");
	console.log("monthlyAverage " + monthlyAverage);
	console.log("dailyCost " + dailyCost);
	var monthlyAverageFormattted = CurrencyFormatted(monthlyAverage);
	var dailyCostFormattted = CurrencyFormatted(dailyCost);
	console.log("monthlyAverageFormattted " + monthlyAverageFormattted);
	console.log("dailyCostFormattted " + dailyCostFormattted);
	
	console.groupEnd();
	
	document.getElementById("monthlyAverageId").textContent = monthlyAverageFormattted;
	document.getElementById("dailyCostId").textContent = dailyCostFormattted;
}	
function buildSpreadSheet() {
	console.group("buildSpreadSheet A");

	// determine to hide spread sheet
	if (objs === undefined || objs.length == 0) {
		// array empty or does not exist
		$('#spreadSheet').hide();
		return;
	} else {
		$('#spreadSheet').show();
	}

	var janTotal = 0;
	var febTotal = 0;
	var marTotal = 0;
	var aprTotal = 0;
	var mayTotal = 0;
	var junTotal = 0;
	var julTotal = 0;
	var augTotal = 0;
	var sepTotal = 0;
	var octTotal = 0;
	var novTotal = 0;
	var decTotal = 0;

	// Test to see if the browser supports the HTML template element by checking
	// for the presence of the template element's content attribute.
	if ('content' in document.createElement('template')) {

		// Instantiate the table with the existing HTML tbody
		// and the row with the template
		var template = document.querySelector('#productrow');

		// Clone the new row and insert it into the table
		var tbody = document.querySelector("tbody");
		// remove all nodes
		while (tbody.firstChild) {
			tbody.firstChild.remove();
		}
		for (i in objs) {
			janTotal = janTotal + convertToNumberFromCurrency(objs[i].jan);
			febTotal = febTotal + convertToNumberFromCurrency(objs[i].feb);
			marTotal = marTotal + convertToNumberFromCurrency(objs[i].mar);
			aprTotal = aprTotal + convertToNumberFromCurrency(objs[i].apr);
			mayTotal = mayTotal + convertToNumberFromCurrency(objs[i].may);
			console.log("jun " + convertToNumberFromCurrency(objs[i].jun));
			console.log("junTotal " + junTotal);
			junTotal = junTotal + convertToNumberFromCurrency(objs[i].jun);
			julTotal = julTotal + convertToNumberFromCurrency(objs[i].jul);
			augTotal = augTotal + convertToNumberFromCurrency(objs[i].aug);
			sepTotal = sepTotal + convertToNumberFromCurrency(objs[i].sep);
			octTotal = octTotal + convertToNumberFromCurrency(objs[i].oct);
			novTotal = novTotal + convertToNumberFromCurrency(objs[i].nov);
			decTotal = decTotal + convertToNumberFromCurrency(objs[i].dec);
			var clone = document.importNode(template.content, true);
			var td = clone.querySelectorAll("td");

			td[0].textContent = objs[i].name;
			td[1].textContent = objs[i].jan;
			td[2].textContent = objs[i].feb;
			td[3].textContent = objs[i].mar;
			td[4].textContent = objs[i].apr;
			td[5].textContent = objs[i].may;
			td[6].textContent = objs[i].jun;
			td[7].textContent = objs[i].jul;
			td[8].textContent = objs[i].aug;
			td[9].textContent = objs[i].sep;
			td[10].textContent = objs[i].oct;
			td[11].textContent = objs[i].nov;
			td[12].textContent = objs[i].dec;
			td[13].textContent = CurrencyFormatted(objs[i].rt);
			tbody.appendChild(clone);
		}// end of for

	} else {
		// Find another way to add the rows to the table because
		// the HTML template element is not supported.
	}

	// Test to see if the browser supports the HTML template element by checking
	// for the presence of the template element's content attribute.
	if ('content' in document.createElement('template')) {

		// Instantiate the table with the existing HTML tfoot
		// and the row with the template
		var template = document.querySelector('#footerrow');

		// Clone the new row and insert it into the table
		var tfoot = document.querySelector("tfoot");
		// remove all nodes
		while (tfoot.firstChild) {
			tfoot.firstChild.remove();
		}
		var clone = document.importNode(template.content, true);
		var td = clone.querySelectorAll("td");
		td[1].textContent = CurrencyFormatted(janTotal);
		td[2].textContent = CurrencyFormatted(febTotal);
		td[3].textContent = CurrencyFormatted(marTotal);
		td[4].textContent = CurrencyFormatted(aprTotal);
		td[5].textContent = CurrencyFormatted(mayTotal);
		td[6].textContent = CurrencyFormatted(junTotal);
		td[7].textContent = CurrencyFormatted(julTotal);
		td[8].textContent = CurrencyFormatted(augTotal);
		td[9].textContent = CurrencyFormatted(sepTotal);
		td[10].textContent = CurrencyFormatted(octTotal);
		td[11].textContent = CurrencyFormatted(novTotal);
		td[12].textContent = CurrencyFormatted(decTotal);
		var grandtotal = janTotal + febTotal + marTotal;
		grandtotal  =  grandtotal + aprTotal + mayTotal + junTotal;
		grandtotal = grandtotal +julTotal + augTotal + sepTotal;
		grandtotal = grandtotal +octTotal + novTotal + decTotal;
		td[13].textContent = CurrencyFormatted(grandtotal);
                monthlyAverage = grandtotal/12;
		monthlyAverage = Math.round(monthlyAverage);
		dailyCost = Math.round(monthlyAverage/30);
		
		
		tfoot.appendChild(clone);

	} else {
		// Find another way to add the rows to the table because
		// the HTML template element is not supported.
	}// end of footer
	console.groupEnd();

}// end of function

function buildSpreadSheetB() {
	console.group("buildSpreadSheetB");
	
	

	// determine to hide spread sheet
	if (objs === undefined || objs.length == 0) {
		// array empty or does not exist
		console.log("array empty or does not exist" );
	
		$('#spreadSheetB').hide();
		return;
	} else {
		console.log("array  does exists" );
		$('#spreadSheetB').show();
	}

	var janTotal = 0;
	var febTotal = 0;
	var marTotal = 0;
	var aprTotal = 0;
	var mayTotal = 0;
	var junTotal = 0;
	var julTotal = 0;
	var augTotal = 0;
	var sepTotal = 0;
	var octTotal = 0;
	var novTotal = 0;
	var decTotal = 0;

	// Test to see if the browser supports the HTML template element by checking
	// for the presence of the template element's content attribute.
	if ('content' in document.createElement('template')) {

		// Instantiate the table with the existing HTML tbody
		// and the row with the template
		var template = document.querySelector('#productrowB');
                console.log("template "  + template);
		// Clone the new row and insert it into the table
		var tbody = document.querySelector('#tbodyB');
		// remove all nodes
		while (tbody.firstChild) {
			tbody.firstChild.remove();
		}
		for (i in objs) {
			janTotal = janTotal + convertToNumberFromCurrency(objs[i].jan);
			febTotal = febTotal + convertToNumberFromCurrency(objs[i].feb);
			marTotal = marTotal + convertToNumberFromCurrency(objs[i].mar);
			aprTotal = aprTotal + convertToNumberFromCurrency(objs[i].apr);
			mayTotal = mayTotal + convertToNumberFromCurrency(objs[i].may);
			junTotal = junTotal + convertToNumberFromCurrency(objs[i].jun);
			julTotal = julTotal + convertToNumberFromCurrency(objs[i].jul);
			augTotal = augTotal + convertToNumberFromCurrency(objs[i].aug);
			sepTotal = sepTotal + convertToNumberFromCurrency(objs[i].sep);
			octTotal = octTotal + convertToNumberFromCurrency(objs[i].oct);
			novTotal = novTotal + convertToNumberFromCurrency(objs[i].nov);
			decTotal = decTotal + convertToNumberFromCurrency(objs[i].dec);
			var clone = document.importNode(template.content, true);
			var td = clone.querySelectorAll("td");

			td[0].textContent = objs[i].name;
			td[1].textContent = objs[i].jan;
			td[2].textContent = objs[i].feb;
			td[3].textContent = objs[i].mar;
			td[4].textContent = objs[i].apr;
			td[5].textContent = objs[i].may;
			td[6].textContent = objs[i].jun;
			td[7].textContent = objs[i].jul;
			td[8].textContent = objs[i].aug;
			td[9].textContent = objs[i].sep;
			td[10].textContent = objs[i].oct;
			td[11].textContent = objs[i].nov;
			td[12].textContent = objs[i].dec;
			td[13].textContent = CurrencyFormatted(objs[i].rt);
			tbody.appendChild(clone);
		}// end of for

	} else {
		// Find another way to add the rows to the table because
		// the HTML template element is not supported.
	}

	// Test to see if the browser supports the HTML template element by checking
	// for the presence of the template element's content attribute.
	if ('content' in document.createElement('template')) {

		// Instantiate the table with the existing HTML tfoot
		// and the row with the template
		var template = document.querySelector('#footerrowB');

		// Clone the new row and insert it into the table
		var tfoot = document.querySelector("#tfootB");
		// remove all nodes
		while (tfoot.firstChild) {
			tfoot.firstChild.remove();
		}
		var clone = document.importNode(template.content, true);
		var td = clone.querySelectorAll("td");
		td[1].textContent = CurrencyFormatted(janTotal);
		td[2].textContent = CurrencyFormatted(febTotal);
		td[3].textContent = CurrencyFormatted(marTotal);
		td[4].textContent = CurrencyFormatted(aprTotal);
		td[5].textContent = CurrencyFormatted(mayTotal);
		td[6].textContent = CurrencyFormatted(junTotal);
		td[7].textContent = CurrencyFormatted(julTotal);
		td[8].textContent = CurrencyFormatted(augTotal);
		td[9].textContent = CurrencyFormatted(sepTotal);
		td[10].textContent = CurrencyFormatted(octTotal);
		td[11].textContent = CurrencyFormatted(novTotal);
		td[12].textContent = CurrencyFormatted(decTotal);
		var grandtotal = janTotal + febTotal + marTotal;
		grandtotal  =  grandtotal + aprTotal + mayTotal + junTotal;
		grandtotal = grandtotal +julTotal + augTotal + sepTotal;
		grandtotal = grandtotal +octTotal + novTotal + decTotal;
		td[13].textContent = CurrencyFormatted(grandtotal);
                monthlyAverageB = grandtotal/12;
		monthlyAverageB = Math.round(monthlyAverageB);
		dailyCostB = Math.round(monthlyAverageB/30);
		
		
		tfoot.appendChild(clone);

	} else {
		// Find another way to add the rows to the table because
		// the HTML template element is not supported.
	}// end of footer
console.groupEnd();
}// end of function
