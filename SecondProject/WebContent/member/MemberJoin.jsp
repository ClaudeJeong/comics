<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="./../common/top.jsp"%>

<%
	int meoffset = 2;
	int mywidth = twelve - 2 * myoffset;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<form class="form-group" role="form" action="<%=myCtrlCommand%>meJoin" method="post">
		<div
			class="container row col-sm-offset-<%=meoffset%> col-sm-<%=mywidth%>">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>회원가입</h3>
					<hr width="70%" color="red">
				</div>
				<div class="panel-body">
					<table
						class="table table-striped table-condensed table-hover table-bordered">
						<tr>
							<td>아이디</td>
							<td>
								<div class="form-inline">
									<input type="text" size="20" class="form-control" id="id"
										name="id" placeholder="아이디를 입력하세요">
								</div>
							</td>
						</tr>
						<tr>
							<td>이름</td>
							<td>
								<div class="form-inline">
									<input type="text" size="20" class="form-control" id="name"
										name="name" placeholder="이름을 입력하세요">
								</div>
							</td>
						</tr>
						<tr>
							<td>별명</td>
							<td>
								<div class="form-inline">
									<input type="text" size="20" class="form-control" id="nickname"
										name="nickname" placeholder="별명을 입력하세요">
								</div>
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td>
								<div class="form-inline">
									<input type="password" size="20" class="form-control" id="password"
										name="password" placeholder="비밀번호를 입력하세요">
								</div>
							</td>
						</tr>
						<tr>
							<td>비밀번호 확인</td>
							<td>
								<div class="form-inline">
									<input type="password" size="20" class="form-control" id="repassword"
										name="repassword" placeholder="비밀번호를 입력하세요">
								</div>
							</td>
						</tr>
						<tr>
							<td>성별</td>
							<td>
								<div class="form-inline">
									<input type="radio" class="radio-inline" id="gender"
										name="gender" value="남자">남자
										<input type="radio" class="radio-inline" id="gender"
										name="gender" value="여자">여자
								</div>
							</td>
						</tr>
						<tr>
							<td>생일</td>
							<td>
								<div class="form-inline">
									<input type="text" size="20" class="form-control" id="birth"
										name="birth" placeholder="생년월일을 입력하세요">
								</div>
							</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>
								<div class="form-inline">
									<input type="text" size="20" class="form-control" id="email"
										name="email1" placeholder="메일을 입력하세요">
										@
									<select class="form-control" name="email2">
										<option value="===선택하세요===">===선택하세요===
										<option value="@naver.com">naver.com
										<option value="@gmail.com">gmail.com
										<option value="@daum.net">daum.net
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td>핸드폰</td>
							<td>
								<div class="form-inline">
									<input type="text" size="5" class="form-control" id="phone1"
										name="phone1" value="010">
										-
										<input type="text" size="5" class="form-control" id="phone2"
										name="phone2">
										-
										<input type="text" size="5" class="form-control" id="phone3"
										name="phone3">
								</div>
							</td>
						</tr>
						<tr>
							<td>우편번호</td>
							<td>
								<div class="form-inline">
								<input type="text" size="8" class="form-control" id="zipode"
										name="zipcode">
										&nbsp;&nbsp;&nbsp;
								<input type="button" value="우편번호 찾기" class="btn btn-sm btn-primary">
								</div>		
							</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>
								<div class="form-inline">
									<input type="text" size="40" class="form-control" id="address1"
										name="address1">
								</div>
							</td>
						</tr>
						<tr>
							<td>상세주소</td>
							<td>
							<div class="form-inline">
									<input type="text" size="40" class="form-control" id="address2"
										name="address2">
								</div>
							</td>
						</tr>
					</table>
						<div class="row col-sm-offset-6">
								<div class="form-group">
									<button type="submit" class="btn btn-success btn-sm">가입하기</button>
									&nbsp;&nbsp;&nbsp;
									<button type="reset" class="btn btn-success btn-sm">취소하기</button>
								</div>
						</div>
				</div>

			</div>
		</div>
	</form>
</body>
</html>