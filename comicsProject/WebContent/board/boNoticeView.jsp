<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	String boradtype = (String)request.getAttribute("boardtype");
%> 
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


<div align="right" style="margin-right:300px; margin-top:30px;">
<font size="2px" style="font-weight:bold;">
<c:if test="${ sessionScope.loginfo.nickname == bean.writer }">
<a href="<%=MyCtrlCommand%>boUpdateForm&no=${bean.no}&${requestScope.parameters}">수정</a>	&nbsp;&nbsp; 
<a href="<%=MyCtrlCommand%>boDelete&no=${bean.no}&${requestScope.parameters}&boardtype=${bean.boardType}" onclick="return realDelete()">삭제</a>
</c:if>
</font>
</div>

<div class="container col-sm-offset-2 col-sm-8">
<hr class="colorgraph">
<font size="2px" style="font-style: italic; font-weight: bold;">제목 :</font> ${bean.subject}<br><br>
<font size="2px" style="font-style: italic; font-weight: bold;">작성자 :</font> ${bean.writer}<br><br>
<font size="2px" style="font-style: italic; font-weight: bold;">등록일 :</font> ${bean.regDate}<br><br>
<c:if test="${ bean.regDate == bean.updateDate}">
	<font size="2px" style="font-style: italic; font-weight: bold;">수정일 :</font> - <br>
</c:if>
<c:if test="${ bean.regDate != bean.updateDate}">
    <font size="2px" style="font-style: italic; font-weight: bold;">수정일 :</font> ${bean.updateDate}<br> 
</c:if>
</div>
<div class="container col-sm-offset-2 col-sm-8">
<hr class="colorgraph">
<font size="2px" style="font-style: italic; font-weight: bold;">내용 :</font> <br> ${bean.content}
<div style="margin-left: 430px; margin-top: 10px;">
<input type="button" class="btn btn-info  btn-md" type="button" value="돌아가기" onclick="goback()">
</div>
</div>

<div class="form-group col-sm-offset-4 col-sm-4" style="margin-top: 50px;">

<c:forEach var="lists" items="${requestScope.lists}">
<form class="form-group" id="myform" name="myform" action="<%=MyCtrlCommand%>reMoreWrite&groupno=${lists.groupNo}&no=${bean.no}&orderno=${lists.orderNo}&writer=${sessionScope.loginfo.nickname}&depth=${lists.depth}&${requestScope.parameters}" method="post">
<textarea name="morere" id="morere" style="width: 0px; height: 0px; visibility: hidden;"></textarea> 
<table>

<hr class="colorgraph" style="height: 2px;">
<c:if test="${lists.depth > 0}">
re:
</c:if>
<tr>
	<td>작성자: ${lists.writer} &nbsp;&nbsp;&nbsp;&nbsp; </td>
	<td>작성일: ${lists.regDate} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
	<c:if test="${lists.writer == sessionScope.loginfo.nickname}">
	<c:if test="${lists.writer != null}">
	<td>
		<a href="<%=MyCtrlCommand%>reDelete&renum=${lists.reNum}&no=${bean.no}&${requestScope.parameters}">삭제</a>
		&nbsp;&nbsp;
	</td>
	</c:if>
	</c:if>
	<c:if test="${lists.writer != null}">
	<td>
            <input type="submit" value="댓글 쓰기"
                onclick="return moreReply()" class="btn btn-danger btn-sm">
	</td>
	</c:if>
</tr>
</table>
</form>
<br>
<div style="margin-top:-30px;">
<table>
<tr>
	<td>내용: </td>
</tr>
<tr>
	<td>
		${lists.content}
	</td>
</tr>

</table>
</div>
 </c:forEach>

<div align="center">
			${requestScope.pagingHtml}		
		</div>
</div>
<form action="<%=MyCtrlCommand%>rewrite&no=${bean.no}&writer=${sessionScope.loginfo.nickname}&boardtype=${bean.boardType}&${requestScope.parameters}" method="post" >
<div class="form-group col-sm-offset-4 col-sm-4" style="margin-top: 20px;">
  <label for="comment">댓글달기:</label>
  <textarea class="form-control" rows="5" id="reply" name="reply"></textarea>
  <input type="submit" class="btn btn-danger  btn-sm" type="button" value="댓글달기" style="margin-left: 445px; margin-top: 8px"
   			onclick="return goreply()"> &nbsp;&nbsp;<span id="lengthcheck"></span>
</div>
<input type="hidden" id="boardtype" name="boardtype" value="<%=boradtype%>">
	
</form>

<script type="text/javascript">

function moreReply() {
	var popOptions = "dialogWidth: 400px; dialogHeight: 250px; center: yes; resizable: yes; status: no; scroll: no;";
	var url='<%=MyCtrlCommand%>reMoreReplyForm';
	var vReturn = window.showModalDialog(url, window, popOptions);
	var reply = vReturn;
	//alert(reply);
	$('#morere').val(reply);
	$('#morere').attr('value', reply) ;
	//document.myform.morere.value = reply;
	//alert("하하하하");
	
	if (vReturn !='') {
		return true;

	} else {
		return false;

	} 

	return false;
}

function goback(){
	if($('#boardtype').val() == '공지사항'){
		location.href='<%=MyCtrlCommand%>boList&${requestScope.parameters}';
	}else{
		location.href='<%=MyCtrlCommand%>boFreeList&${requestScope.parameters}';
	}
}
function realDelete() {
	if(confirm("게시물을 삭제 하시겠습니까?")){
		return true;
	}else{
		return false;
	}
}
function goreply(){
		
		if( <%=whologin%> == 0 ){
			alert("로그인 해주세요");
			return false;
		} 
		if( $('#reply').val().length > 300 ){
			alert("300자 이하로 쓰세요");
			return false;
		}
		if( $('#reply').val().length == 0 ){
				alert("글을 써주세요");
				return false;
		}
		return true;
	}
$(document).ready(function(){
	$('#reply').keyup(function(){
		var relength = $('#reply').val().length
		$('#lengthcheck').html("<span class='alert-default'>" +relength + "/300</span>");
	});
	
});		
	
</script>
</body>
</html>