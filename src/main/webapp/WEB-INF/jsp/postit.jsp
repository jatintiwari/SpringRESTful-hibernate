<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Rest Example: Post</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>

<h1>API Post Example</h1>

<form id="post_example" name="post_example" action="#">
<label>Id </label><input type="text" name="pcPartsId" id="pcPartsId"/><br>
<label>Title</label><input type="text" name="pcPartsTitle" id="pcPartsTitle"/><br>
<label>Code </label><input type="text" name="pcPartsCode" id="pcPartsCode"/><br>
<label>Maker </label><input type="text" name="pcPartsMaker" id="pcPartsMaker"/><br>
<label>Avail </label><input type="text" name="pcPartsAvail" id="pcPartsAvail"/><br>
<input type="button" name="submit_it" id="submit_it" value="submit"/>

</form>
<br />
 <div id="div_ajaxResponse"></div>
 
 <script>
 $(document).ready(function() {
		//console.log("ready");
		var $post_example = $('#post_example');
		
		/**
		 * This is for the Submit button
		 * It will trigger a ajax POST call to: v1/inventory
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
				url: "http://localhost:8080/SpringREST/v1/inventory",
				data:{incomingdata:JSON.stringify(jsObj)},
				/* data: JSON.stringify(jsObj), */ 
				 /* contentType:"application/json",  */
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
					$('#div_ajaxResponse').html(JSON.stringify(jsObj));
					//alert(XMLHttpRequest.getAllResponseHeaders());
					//console.log( XMLHttpRequest.getAllResponseHeaders() );
				}, 
				dataType: "json" //request JSON 
			};
			$.ajax(ajaxObj);
		});
	});
 
 
 /**
  * jquery plugin
  * Serialize a form to javascript object
  * @returns js object
  */
 (function($) {
 	$.fn.serializeObject = function()
 	{
 		var o = {};
 		var a = this.serializeArray();
 		$.each(a, function() {
 			if (o[this.name] !== undefined) {
 				if (!o[this.name].push) {
 					o[this.name] = [o[this.name]];
 				}
 				o[this.name].push(this.value || '');
 			} else {
 				o[this.name] = this.value || '';
 			}
 		});
 		return o;
 	};
 })(jQuery);
 
 </script>
 
 

</body>
</html>