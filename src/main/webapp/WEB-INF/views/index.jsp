<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Unique Email Addresses</title>
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	
</head>
<body>

	<div id="mainContainer" class="container">
		<div id="inputContainer">
			<h1>Unique Email Address</h1>
			<input type="text" id="emailAddress">
		    <button id="addButton" >Add More Email Addresses</button>
		    <button id="submitButton" type="submit">Submit</button>
		</div>
		
		<div id="outputContainer">
		</div>
		
		<div>
			<ul>       
	    	</ul>
		</div>
		
		<div id="reset">
		</div>
	    
	</div>

</body>

<script type="text/javascript">

	$("#addButton").click(function(event) {
		
		if($("input[type='text']").val() != "") {
			
			var emailAddress = $("input[type='text']").val();

			$("input[type='text']").val("");
			
			$("ul").append("<li>" + emailAddress + "</li>");
		}
	});
	
	$("#mainContainer").on("click", "#resetButton", function() {
		
		location.reload();
	});
	
	$("#submitButton").click(function(event) {
		
		var emailAddress = [];
		
		$("li").each(function() {
			
			emailAddress.push($(this).text());
		});
		
		var data = {'emailAddress': emailAddress};
		
		$.ajax({
		    
		    url: "${pageContext.request.contextPath}/getCountOfUniqueEmailAddress",
		    type: "POST",
		    contentType: 'application/json; charset=UTF-8',
		    dataType: 'json',
		    data: JSON.stringify(data),
		    success: function(data) {
		    	$('#inputContainer').slideUp();
		    	$("#outputContainer").append("<h1>The Number of Unique Email Addresses is " + data + "</h1>");
		    	$("#reset").append("<h2>Click reset button below to find number of unique address again!</h2>");
		    	$("#reset").append("<button id='resetButton'>Reset</button>");
		    },
		    error: function(data) {
		    	alert("fail");
		    }
		});
	});

</script>

</html>