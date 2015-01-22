	/**
 * js file for post.html
 */

$(document).ready(function() {
	//console.log("ready");
	
	var $post_example = $('#post_example');
	
	/**
	 * This is for the Submit button
	 * It will trigger a ajax POST call to: api/v3/inventory
	 * This will submit a item entry to our inventory database
	 */
	$('#submit_it').click(function(e) {
	//	console.log("submit button has been clicked");
		e.preventDefault(); //cancel form submit
		
		var jsObj = $post_example.serializeObject()
			, ajaxObj = {};
		
		//console.log(jsObj);
		
		ajaxObj = {  
			type: "POST",
			url: "http://localhost:8080/InventoryRESTWS/api/v3/inventory/", 
			data: JSON.stringify(jsObj), 
			contentType:"application/json",
			error: function(jqXHR, textStatus, errorThrown) {
				console.log("Error " + jqXHR.getAllResponseHeaders() + " " + errorThrown);
			},
			success: function(data) { 
				alert(data);
				//console.log(data);
				if(data[0].HTTP_CODE >= 200) {
					alert(data[0].MSG);
					$('#div_ajaxResponse').html( data[0].MSG );
				}
			},
			complete: function(XMLHttpRequest,data) {
				$('#div_ajaxResponse').html("added");
				//alert(XMLHttpRequest.getAllResponseHeaders());
				//console.log( XMLHttpRequest.getAllResponseHeaders() );
			}, 
			dataType: "json" //request JSON
		};
		$.ajax(ajaxObj);
	});
});
