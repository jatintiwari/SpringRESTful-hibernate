	<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<title>Get</title>
</head>
<body>

	<form action="#" id="getform" name="getform">
		<label>Enter Id: <input type="text" name="pcPartsId"
			id="pcPartsId"></label> <input type="button" id="submit_it"
			name="submit_it" value="submit">
	</form>
	<br>
	<div id="div_ajaxResponse"></div>
	<script>
		$(document).ready(function() {
							var $post_example = $('#getform');
							$('#submit_it').click(function(e) {
												e.preventDefault(); //cancel form submit
												var jsObj = $post_example.serializeObject(),
													ajaxObj = {};

												ajaxObj = {
													type : "GET",
													url : "http://localhost:8080/SpringREST/inventory/"+$('#pcPartsId').val(),
													data:jsObj,
													dataType:'json',
													cache: false,
													error : function(jqXHR,textStatus,errorThrown) {
														console.log("Error "+ jqXHR.getAllResponseHeaders()+ " "+ errorThrown);
													},
													success : function(data) {
													//	alert("success");
														$('#div_ajaxResponse').html(JSON.stringify(data));
														
														
													},
													complete : function(XMLHttpRequest,data) {
													//	$('#div_ajaxResponse').html(JSON.stringify(jsObj));
													//	alert(XMLHttpRequest.getAllResponseHeaders());
													},
													dataType : "json" //request JSON 
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
			$.fn.serializeObject = function() {
				var o = {};
				var a = this.serializeArray();
				$.each(a, function() {
					if (o[this.name] !== undefined) {
						if (!o[this.name].push) {
							o[this.name] = [ o[this.name] ];
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