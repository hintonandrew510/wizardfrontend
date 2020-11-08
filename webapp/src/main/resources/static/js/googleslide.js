
function start() {
	console.group("Start Google Slide");
		gapi.load('auth2', function() {
		auth2 = gapi.auth2.init({
			client_id : '925858081612-lfg0lmjn0c3kjbgcl1l8jme6dhdiubjo.apps.googleusercontent.com',
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
	} else {
		console.log("Error calling google");
	}
	console.groupEnd();
}
console.group("Starting signInCallback");

// signInCallback defined in step 6.
//auth2.grantOfflineAccess().then(signInCallback);
console.groupEnd();
