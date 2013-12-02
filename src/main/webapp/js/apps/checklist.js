var ajaxUrl = contextRoot + "/checklist/user/";

$(document).ready(function() {
	var body = $('body');
	if($(body).hasClass('lists')) {
		isUser();
	} else if($(body).hasClass('detail')) {
		addTask();
		toggleCompleted();
	}
});

function toggleCompleted() {
	$('#checklist ul li').click(function(e) {
		$(this).toggleClass('completed');
		var checkbox = $(this).children('input[type="checkbox"]');
		checkbox.attr('checked', !checkbox.attr('checked'));
	});
}

function addTask() {
	$('.addTask').click(function(e) {
		e.preventDefault();
		return addTaskToList();
	});
	$('#newTask').on('keypress', function(e){
		if(e.keyCode == '13') {
			e.preventDefault();
			e.stopPropagation();
			return addTaskToList();
		}
	});
}
function addTaskToList() {
	var newTaskInput = $('#newTask');
	var newTask = jQuery.trim($(newTaskInput).val());
	if('' == newTask) {
		alert('Please enter a task description');
		return false;
	} else {
		var nextIndexInput = $('#nextIndex');
		var nextIndex = $(nextIndexInput).val();
		var html = '<li class="uncompleted">';
		html += '<input id="tasks' + nextIndex + '.completed1" name="tasks[' + nextIndex + '].completed" type="checkbox" value="true">';
		html += '<label for="tasks' + nextIndex + '.completed1">'+ newTask +'</label>';
		html += '<input type="hidden" name="_tasks[' + nextIndex + '].completed" value="on">';
		html += '<input id="tasks' + nextIndex + '.description" name="tasks[' + nextIndex + '].description" value="'+ newTask +'" type="hidden">';
		html += '</li>';
		
		nextIndex++;
		$(nextIndexInput).val(nextIndex);
		
		$('#checklist ul').append(html);
		
		$(newTaskInput).val('');
		return true;
	}
}
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
						 saveUser(function() {
							 $( modal ).dialog( "close" );
						 });
					 }
				}
			 });

			$('#username').on('keypress', function(e) {
				if(e.keyCode == '13') {
					e.preventDefault();
					e.stopPropagation();
					saveUser(function() {
						 $( modal ).dialog( "close" );
					 });	
				}
			});
			
		})
	;
}

function saveUser(cb) {
	var username = jQuery.trim($('#username').val());
	 if('' == username) {
		 alert('Please enter a username');
	 } else {
		 // put username in session
		 $.get(ajaxUrl + username)
		 	.done(function() {
		 		cb();
		 	});
	 }
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