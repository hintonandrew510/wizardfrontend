function calculateWomen () {

	//clear
	console.clear();
	
	var pctMen = document.getElementById("pctMen").value;
    var pctWomen = 100 - pctMen;
    document.getElementById("pctWomen").value = pctWomen;
}

function calculateMen () {

	//clear
	console.clear();
	var pctWomen = document.getElementById("pctWomen").value;
    var pctMen = 100 - pctWomen;
    document.getElementById("pctMen").value = pctMen;
}

function calculateHave (haveParm, wantParm) {

	//clear
	console.clear();
	
	var wantvalue = document.getElementById(wantParm).value;
    var haveValue = 100 - wantvalue;
    document.getElementById(haveParm).value = haveValue;
}

function calculateWant (haveParm, wantParm) {
	//clear
	console.clear();
	
	var haveValue = document.getElementById(haveParm).value;
    var wantValue = 100 - haveValue;
    document.getElementById(wantParm).value = wantValue;
}

//init
calculateWomen();
calculateMen ();
