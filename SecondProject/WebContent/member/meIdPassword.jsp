<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container row col-sm-offset-2 col-sm-8"
		style="margin-top: 30px;">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<font
					style="font-size: 20px; font-family: 고딕체; font-style: italic; font-weight: bold">
					아이디 / 비밀번호 찾기</font>
			</div>
			<form class="form-horizontal" role="form" action="<%=myCtrlCommand%>meIdPassword"
				method="post">
				<div class="panel-body">
					<div class="col-sm-6" style="margin-top: 20px">
						<div class="form-inline">
						<div style="margin-bottom: 30px;">아이디 찾기</div>
							<label class="control-label col-sm-2" for="email">이메일</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email" name="email"
									size="20" placeholder="이메일을 입력하세요.">
							<br><br>
							<div class="form-inline">
								<input type="submit" class="btn btn-primary" id="submit"
									name="submit1" size="20px" value="아이디 찾기">
							</div>
							</div>
						</div>
					</div>
					<div class="col-sm-6" style="margin-top: 20px">
						<div class="form-inline">
						<div style="margin-bottom: 30px;">비밀번호 찾기</div>
							<label class="control-label col-sm-2" for="email">아이디:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="id" name="id"
									size="20" placeholder="아이디를 입력하세요.">
							<br><br>
							<div class="form-inline">
								<input type="submit" class="btn btn-primary" id="submit"
									name="submit2" size="20px" value="비밀번호 찾기">
							</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>