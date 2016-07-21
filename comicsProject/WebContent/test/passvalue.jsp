<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript"> 

 var win;
 function open_popup(){          //메뉴에서 기업보장분석을 팝업으로 띄우는 func.
  win = window.open('getvalue.jsp','값전달값');
 }

 function call_popup(str){  //부모창에서 자식창에 값 전달
  try{
   popup.call(str);  //popup은 자식창이 onLoad 시에 선언
   }catch(e){
   alert('창이 닫혔습니다.');
  }
 }

</script>
</head>

<body>
 <input type='button' value='open' onclick='open_popup()' />
 <input type='button' id='btn_call' value='call' disabled='disabled' onclick='call_popup("test")' />
</body>
</html>

