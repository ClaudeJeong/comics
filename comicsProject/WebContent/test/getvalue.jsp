<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
 window.onload = function () {
  opener.popup = this;  //자식 창이 뜰때 opener에 popup이라는 변수에 this를 지정해주며, 부모창에서 'popup'으로 자식창의 함수를 호출함.
  opener.document.getElementById('btn_call').disabled = false;
 }

 function call(str){
  opener.popup = null;
  opener.document.getElementById('btn_call').disabled = true;
  document.getElementById('div1').innerHTML +=  str +' called<br />';
 }
</script>
</head>
<body>
 <div id='div1' ></div>
</body>
</html>
