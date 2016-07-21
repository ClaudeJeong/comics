<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="./css/nav.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>message</title>
</head>
<body>
<div class="col-sm-offset-2 col-sm-8" align="center" style="margin-top: 20px;">
	<span id="mymessage"></span>
</div>
<script type="text/javascript">
	$(document).ready(function() {	
	var message = opener.message.value;
	$('#mymessage').html("<span class='alert-info'>" + message + "</span>");
	});
	</script>
</body>
</html>