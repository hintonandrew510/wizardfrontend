
function start() {
	console.group("Start Google Slide");
	//https://www.googleapis.com/auth/drive
	var scopes = 'https://www.googleapis.com/auth/drive.metadata ' +
		'https://www.googleapis.com/auth/drive.appdata ' +
		'https://www.googleapis.com/auth/presentations ' +
		'https://www.googleapis.com/auth/drive.file  ' +
		'https://www.googleapis.com/auth/drive ';
	

		

		


	//521128643660-41ra210r6jhbvdm56mspq9bn5v806r6s.apps.googleusercontent.com
		gapi.load('auth2', function() {
		//521128643660-41ra210r6jhbvdm56mspq9bn5v806r6s.apps.googleusercontent.com	
		auth2 = gapi.auth2.init({
			client_id : '521128643660-41ra210r6jhbvdm56mspq9bn5v806r6s.apps.googleusercontent.com',
			scope: scopes,
		// Scopes to request in addition to 'profile' and 'email'
		// scope: 'additional_scope'
		});
		
	});
    console.log("call authorization");
   
	console.groupEnd();
}

function signInCallback(authResult) {
	console.group("Start actual signInCallback");
	if (authResult['code']) {
		 console.log("authResult[code] " + authResult['code']);
		 //call backend server
		 document.getElementById("authCodeId").value =  authResult['code'];
		 document.getElementById("shareForm").submit();
	} else {
		console.log("Error calling google");
	}
	console.groupEnd();
}
console.group("Starting signInCallback");

// signInCallback defined in step 6.
//auth2.grantOfflineAccess().then(signInCallback);
console.groupEnd();