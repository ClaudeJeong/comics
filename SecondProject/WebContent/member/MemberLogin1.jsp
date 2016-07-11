<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login_Page</title>
</head>
<body>

	<div
		class="container row col-sm-offset-2 col-sm-8"
		style="margin-top: 30px;">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<font
					style="font-size: 20px; font-family: 고딕체; font-style: italic; font-weight: bold">회원
					로그인</font>
			</div>
			<form class="form-horizontal" role="form" action="<%=MyCtrlByForm%>" method="post">
			<input type="hidden" name="command" value="meLogin">
			<div class="panel-body">
			<div class="col-sm-8" style="margin-top:35px">
					<div class="form-inline">
						<label class="control-label col-sm-2" for="email">아이디:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="id" name="id" 
								size="20" placeholder="아이디를 입력하세요.">
						</div>
					</div>
					<br><br><br>
					<div class="form-inline">
						<label class="control-label col-sm-2" for="pwd">비밀번호:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password" name="password"
								size="20" placeholder="비밀번호를 입력하세요.">
						</div>
					</div>
					<br><br><br>
					<div class="col-sm-offset-3">
					<div class="form-inline">
						<input type="submit" class="btn btn-primary" id="submit" name="submit" size="20px" value="로그인">
					</div>
					</div>
					</div>
			<div class="col-sm-4">
				<img src="<%=contextPath%>/images/niconico2.png" class="img-thumbnail" alt="Cinque Terre"
							width="500" height="800">
			</div>		
			</div>
			</form>
		</div>
	</div>

</body>
</html>