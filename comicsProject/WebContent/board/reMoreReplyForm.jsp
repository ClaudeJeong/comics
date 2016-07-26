<%@page import="mypkg.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String context = request.getContextPath();
String servPath = "/ComicsCtrl";
String MyCtrlCommand = context + servPath +"?command=";
%>
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
<base target="_self">
</head>
<body>
<form name="myform" id="myform">
<div class="form-group col-sm-offset-4 col-sm-4" style="margin-top: 20px;">
  <label for="comment">댓글달기:</label>
  <textarea class="form-control" rows="5" id="morereply" name="morereply"></textarea>
 <input class="btn btn-danger btn-sm" type="button" value="댓글달기" style="margin-left: 260px; margin-top: 8px"
   			onclick="return goreply()"> &nbsp;&nbsp; <span id="lengthcheck"></span>
 
</div>
</form>

<input type="hidden" id="boardtype" name="boardtype" value="${param.boardtype}">
	


<script type="text/javascript">
function goreply(){
	if( $('#morereply').val().length > 300 ){
		alert("300자 이하로 쓰세요");
		return false;
	}
	if( $('#morereply').val().length == 0 ){
			alert("글을 써주세요");
			return false;
	}
	
	var morereply = $('#morereply').val();
	//window.opener.document.getElementById("reply").value = morereply;
	window.returnValue = morereply;
	window.close();
	return true;
}
$(document).ready(function(){
$('#morereply').keyup(function(){
	var relength = $('#morereply').val().length
	$('#lengthcheck').html("<span class='alert-default'>" +relength + "/300</span>");
});

});		
</script>
</body>
</html>