// Jquery Dependency 1.1
// Jquery Dependency

$("input[data-type='currency']").on({
    keyup: function() {
      formatCurrency($(this));
    },
    blur: function() { 
      formatCurrency($(this), "blur");
    }
});

$("input[data-type='currencyWithCents']").on({
    keyup: function() {
      formatCurrencyWithCents($(this));
    },
    blur: function() { 
    	formatCurrencyWithCents($(this), "blur");
    }
});

function convertIntToNumber(intValue) {
	if (intValue == null || intValue =="" ) {
		return 0;
	} 
	return intValue;
}

function formatNumber(n) {
  // format number 1000000 to 1,234,567
  return n.replace(/\D/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",")
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
	currency = currency.replace(/,/g, '');
	
	return currency;
} 


function formatMoney(n, c, d, t) {
	  var c = isNaN(c = Math.abs(c)) ? 2 : c,
	    d = d == undefined ? "." : d,
	    t = t == undefined ? "," : t,
	    s = n < 0 ? "-" : "",
	    i = String(parseInt(n = Math.abs(Number(n) || 0).toFixed(c))),
	    j = (j = i.length) > 3 ? j % 3 : 0;

	  return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
}



function formatCurrency(input, blur) {
  // appends $ to value, validates decimal side
  // and puts cursor back in right position.
  
  // get input value
  var input_val = input.val();
  input_val = input_val.trim();
  
  // don't validate empty input
  if (input_val === "") { 
	  totalRow(); 
	  return;
   }
	
 //remove period
  input_val = input_val.replace('.', "");
  
  // original length
  var original_len = input_val.length;

  // initial caret position 
  var caret_pos = input.prop("selectionStart");
    
  // check for decimal
  if (input_val.indexOf(".") >= 0) {

    // get position of first decimal
    // this prevents multiple decimals from
    // being entered
    var decimal_pos = input_val.indexOf(".");

    // split number by decimal point
    var left_side = input_val.substring(0, decimal_pos);
    var right_side = input_val.substring(decimal_pos);

    // add commas to left side of number
    left_side = formatNumber(left_side);

    // validate right side
    right_side = formatNumber(right_side);
    
    // On blur make sure 2 numbers after decimal
    if (blur === "blur") {
     //aah right_side += "00";
     
    }
    
    // Limit decimal to only 2 digits
    right_side = right_side.substring(0, 2);

    // join number by .
    input_val = "$" + left_side + "." + right_side;

  } else {
    // no decimal entered
    // add commas to number
    // remove all non-digits
    input_val = formatNumber(input_val);
    input_val = "$" + input_val;
    
    // final formatting
    if (blur === "blur") {
      //aah input_val += ".00";
    }
  }
  
  // send updated string to input
  input.val(input_val);

  // put caret back in the right position
  var updated_len = input_val.length;
  caret_pos = updated_len - original_len + caret_pos;
  input[0].setSelectionRange(caret_pos, caret_pos);
  totalRow();
}
  

function formatCurrencyWithCents(input, blur) {
	  // appends $ to value, validates decimal side
	  // and puts cursor back in right position.
	  
	  // get input value
	  var input_val = input.val();
	 
	  
	  // don't validate empty input
	  if (input_val === "") { 
		 input_val = ""; 
		 return;
	   }
		
	 //remove period
	 // tinas input_val = input_val.replace('.', "");
	  
	  // original length
	  var original_len = input_val.length;

	  // initial caret position 
	  var caret_pos = input.prop("selectionStart");
	    
	  // check for decimal
	  if (input_val.indexOf(".") >= 0) {

	    // get position of first decimal
	    // this prevents multiple decimals from
	    // being entered
	    var decimal_pos = input_val.indexOf(".");

	    // split number by decimal point
	    var left_side = input_val.substring(0, decimal_pos);
	    var right_side = input_val.substring(decimal_pos);

	    // add commas to left side of number
	    left_side = formatNumber(left_side);

	    // validate right side
	    right_side = formatNumber(right_side);
	    
	    // On blur make sure 2 numbers after decimal
	    if (blur === "blur") {
	     //aah right_side += "00";
	     
	    }
	    
	    // Limit decimal to only 2 digits
	    right_side = right_side.substring(0, 2);

	    // join number by .
	    input_val = "$" + left_side + "." + right_side;

	  } else {
	    // no decimal entered
	    // add commas to number
	    // remove all non-digits
	    input_val = formatNumber(input_val);
	    input_val = "$" + input_val;
	    
	    // final formatting
	    if (blur === "blur") {
	      //aah input_val += ".00";
	    }
	  }
	  
	  // send updated string to input
	  input.val(input_val);

	  // put caret back in the right position
	  var updated_len = input_val.length;
	  caret_pos = updated_len - original_len + caret_pos;
	  input[0].setSelectionRange(caret_pos, caret_pos);
	  totalRow();
	}



function CurrencyFormatted(amount) {
	var i = parseFloat(amount);
	if(isNaN(i)) { i = 0.00; }
	var minus = '';
	if(i < 0) { minus = '-'; }
	i = Math.abs(i);
	i = parseInt((i + .005) * 100);
	i = i / 100;
	s = new String(i);
	//aah if(s.indexOf('.') < 0) { s += '.00'; }
	//aah if(s.indexOf('.') == (s.length - 2)) { s += '0'; }
	s = minus + s;
	//add commas
	s = s.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
	s = "$" + s;
	return s;
}


// tinas
$("input[data-type='numberwithcomma']").on({
    keyup: function() {
    	addCommas($(this));
    	//return "5,000";
    } ,
    blur: function() { 
    	addCommas($(this), "blur");
    } 
});

function addCommas(input, blur) {
	  // appends $ to value, validates decimal side
	  // and puts cursor back in right position.
	  
	  // get input value
	  var input_val = input.val();
	 
	  
	  // don't validate empty input
	  if (input_val === "") { 
		 input_val = "0"; 
	   }
		
	 //remove period
	  input_val = input_val.replace('.', "");
	  
	  // original length
	  var original_len = input_val.length;

	  // initial caret position 
	  var caret_pos = input.prop("selectionStart");
	    
	  // check for decimal
	  if (input_val.indexOf(".") >= 0) {

	    // get position of first decimal
	    // this prevents multiple decimals from
	    // being entered
	    var decimal_pos = input_val.indexOf(".");

	    // split number by decimal point
	    var left_side = input_val.substring(0, decimal_pos);
	    var right_side = input_val.substring(decimal_pos);

	    // add commas to left side of number
	    left_side = formatNumber(left_side);

	    // validate right side
	    right_side = formatNumber(right_side);
	    
	    // On blur make sure 2 numbers after decimal
	    if (blur === "blur") {
	     //aah right_side += "00";
	     
	    }
	    
	    // Limit decimal to only 2 digits
	    right_side = right_side.substring(0, 2);

	    // join number by .
	    input_val = left_side + "." + right_side;

	  } else {
	    // no decimal entered
	    // add commas to number
	    // remove all non-digits
	    input_val = formatNumber(input_val);
	    input_val = input_val;
	    
	    // final formatting
	    if (blur === "blur") {
	      //aah input_val += ".00";
	    }
	  }
}

