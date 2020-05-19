

$('document').ready(function(){
	
	var password = document.getElementById("password")
	
	var confirmPassword = document.getElementById("confirmPassword");
	
	function validatePassword(){
		
		  if(password.value != confirmPassword.value) {
		    confirmPassword.setCustomValidity("Le mot de passe ne correspond pas");
		  } else {
		    confirmPassword.setCustomValidity('');
		  }
		  
     }
	
	password.onchange = validatePassword;
	confirmPassword.onkeyup = validatePassword;		
	
});

document.getElementById("pushToken").value = $( "input[name*='_csrf']" ).val();
