<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	String message = (String)request.getAttribute("message");
	String context = request.getContextPath();
	String servPath = "/ComicsCtrl";
	String MyCtrlCommand = context + servPath +"?command=";
%>
<head>
<base target="_self">
<style type="text/css">
.colorgraph {
  height: 5px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="row" style="margin-top:20px;">
    <div class="col-sm-4 col-sm-offset-4">
		<form role="form" action="<%=MyCtrlCommand%>meChangePass" method="post" name="myform" id="myform">
		<input type="hidden" id="id" name="id">
		<input type="hidden" id="name" name="name">
			<fieldset>
				<h3>비밀번호 변경</h3>
				<hr class="colorgraph">
				<div class="form-group">
                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="변경할 비밀번호를 입력하세요">
				</div>
				<div class="form-group">
                    <input type="password" name="repassword" id="repassword" class="form-control input-lg" placeholder="다시 한번 입력하세요">
				</div>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-md btn-success btn-block" value="변경하기" onclick="return chekPass()">
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>
</div>
<script type="text/javascript">
function chekPass() {
	var pass = $('#password').val();
	var repass = $('#repassword').val();
	
	if((pass.length < 6) || (pass.length > 15)){
		alert("6자이상 15자 이하로 해주세요");
		return false;
	}
	if(pass != repass){
		alert("비밀번호를 확인해주세요");
		return false;
	}
    var id = window.dialogArguments['id'];
    var name = window.dialogArguments['name'];
    $('#id').val(id);
    $('#name').val(name);
    alert("비밀번호가 변경 되었습니다");
	window.close();

	return true;
}
</script>
</body>
</html>