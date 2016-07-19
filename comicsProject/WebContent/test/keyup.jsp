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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<input type="text" id="id">
</div>
<div id="idcheck"  style="top: 10px; left: 100px;"></div>
<script type="text/javascript">
$(document).ready(function() {
	alert("시작");
	$('#id').keyup(function() {
		alert("키업");
		if ($('#id').val().length < 4) {
		$('#idcheck').html("<div class='alert-danger' style='top: 10px; left: 100px;'> 4글자이상 입력해주세요</div>");
	}else{
		$('#idcheck').html("<div class='alert-danger'> </div>");
	}
});
});
</script>
</body>
</html>