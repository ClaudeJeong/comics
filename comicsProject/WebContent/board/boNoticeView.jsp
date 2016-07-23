<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.colorgraph {
	height: 5px;
	border-top: 0;
	background: #c4e17f;
	border-radius: 5px;
	background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%,
		#f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%,
		#db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%,
		#669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%,
		#f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%,
		#db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%,
		#669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca
		25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe
		50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1
		87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca
		25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe
		50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1
		87.5%, #62c2e4 87.5%, #62c2e4);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container col-sm-offset-2 col-sm-8">
<hr class="colorgraph">
<font size="3px" style="font-style: italic; font-weight: bold;">제목 :</font> ${bean.subject}<br><br>
<font size="3px" style="font-style: italic; font-weight: bold;">작성자 :</font> ${bean.writer}<br><br>

<font size="3px" style="font-style: italic; font-weight: bold;">등록일 :</font> ${bean.regDate}<br><br>

<c:if test="${ bean.regDate == bean.updateDate}">
	<font size="3px" style="font-style: italic; font-weight: bold;">수정일 :</font> - <br>
</c:if>
<c:if test="${ bean.regDate != bean.updateDate}">
    <font size="3px" style="font-style: italic; font-weight: bold;">수정일 :</font> ${bean.updateDate}<br> 
</c:if>
</div>
<div class="container col-sm-offset-2 col-sm-8">
<hr class="colorgraph">
<font size="3px" style="font-style: italic; font-weight: bold;">내용 :</font> <br> ${bean.content}
<div style="margin-left: 430px; margin-top: 10px;">
<input type="button" class="btn btn-info  btn-md" type="button" value="돌아가기" onclick="goback()">
</div>
</div>
<script type="text/javascript">
function goback(){
	location.href='<%=MyCtrlCommand%>boList&${requestScope.parameters}';
}
</script>
</body>
</html>