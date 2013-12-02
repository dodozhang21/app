var ajaxUrl = contextRoot + "/checklist/user/";

$(document).ready(function() {
	isUser();
});

function isUser() {
	$.get(ajaxUrl)
		.done(function() {
	        
		})
		.fail(function() {
			var modal = $( "#dialog-modal" ).dialog({
				 width: 400,
				 open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); },
				 modal: true,
				 buttons: {
					 "Submit": function() {
						 var username = jQuery.trim($('#username').val());
						 if('' == username) {
							 alert('Please enter a username');
						 } else {
							 // put username in session
							 $.get(ajaxUrl + username)
							 	.done(function() {
							 		$( modal ).dialog( "close" );
							 	});
						 }
					 }
				}
			 });
		})
	;
}

function getUserInput() {
	$( "#dialog-modal" ).dialog({
		 modal: true,
		 buttons: {
			 "Submit": function() {
				 var username = jQuery.trim($('#username'));
				 if('' == username) {
					 alert('Please enter a username');
				 } else {
					 // put username in session
					 $.get(ajaxUrl + username)
					 	.done(function() {
					 		$( this ).dialog( "close" );
					 	});
				 }
			 },
			 Cancel: function() {
				 $( this ).dialog( "close" );
			 }
		}
	 });
}