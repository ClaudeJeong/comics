<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	
String context = request.getContextPath();
String servPath = "/ComicsCtrl";
String MyCtrlCommand = context + servPath +"?command="; 
%>
<html>
<head>
<style type="text/css">
@import url(http://fonts.googleapis.com/css?family=Roboto:400);
body {
  background-color:#fff;
  -webkit-font-smoothing: antialiased;
  font: normal 14px Roboto,arial,sans-serif;
}

.container {
    padding: 25px;
    position: fixed;
}

.form-login {
    background-color: #EDEDED;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 15px;
    border-color:#d2d2d2;
    border-width: 5px;
    box-shadow:0 1px 0 #cfcfcf;
}

h4 { 
 border:0 solid #fff; 
 border-bottom-width:1px;
 padding-bottom:10px;
 text-align: center;
}

.form-control {
    border-radius: 10px;
}

.wrapper {
    text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<div class="container">
    <div class="row">
    <form name="myform" id="myform">
        <div class="col-sm-offset-3 col-sm-6" style="margin-top:30px; margin-left:35px;">
            <div class="form-login">
            <h4>Good Bye~</h4>
            <input type="password" id="password" name="password" class="form-control input-sm chat-input" placeholder="비밀번호를 입력하세요" />
            </br>
            <input type="password" id="repassword" name="repassword" class="form-control input-sm chat-input" placeholder="다시 입력하세요" />
            </br>
            <div class="wrapper">
            <span class="group-btn">     
                <input type="button" class="btn btn-primary btn-sm" value="탈퇴하기" onclick="return selfClose();"><i class="fa fa-sign-in"></i></a>
            </span>
            </div>
            </div>
        </div>
        </form>
    </div>
</div>
<script type="text/javascript">
function selfClose(){
	var password = document.myform.password.value;
	var repassword = document.myform.repassword.value;
	var sessionpass = ${sessionScope.loginfo.password};
	if(password == repassword && password == sessionpass){
		window.returnValue = 'ok';
		window.close();
		return true;
	}else{
		alert("비밀번호를 확인해 주세요");
		return false;
	}
	
	
}
</script>	
</body>
</html>