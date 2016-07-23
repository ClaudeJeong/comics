<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board_List</title>
</head>
<body>

<div class="container" style="margin-top: 20px">
  <h2>공지사항</h2>
  <div class="table-responsive">          
  <table class="table">
    <thead>
    	<tr>
					<td colspan="10" align="center">
						<form class="form-inline" role="form" name="myform" action="<%=MyCtrlCommand%>boList" method="post">
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="all" selected="selected">-- 선택하세요---------
									<option value="writer">작성자
									<option value="subject">제목
									<option value="content">글 내용									
								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control btn-xs" name="keyword"
									id="keyword" placeholder="검색 키워드">
							</div>
							<button class="btn btn-default btn-warning" type="submit" onclick="search();">검색</button>
							<button class="btn btn-default btn-warning" type="button" onclick="searchAll();">전체 검색</button>
							<button class="btn btn-default btn-info" type="button"
								onclick="writeForm();">글 쓰기</button>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<p class="form-control-static">${requestScope.pagingStatus}</p>
						</form>
					</td>
				</tr>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>등록일</th>
        <th>수정일</th>
        <th>조회수</th>
      </tr>
    </thead>
   
    <c:forEach var="bean" items="${requestScope.lists}">
    <tbody>
      <tr>
        <td>${bean.no}</td>
       	 <td>
      	 	<a href="#">${bean.subject} </a>
       	 </td>
       
        <td>${bean.writer}</td>
        <td>${bean.regDate}</td>
        <c:if test="${ bean.regDate == bean.updateDate}">
       		 <td>-</td>
        </c:if>
        <c:if test="${ bean.regDate != bean.updateDate}">
       		<td>${bean.updateDate}</td>
        </c:if>
        <td>${bean.readHit}</td>
      </tr>
    </tbody>
    </c:forEach>
  </table>
  </div>
  <div align="center">
			<footer>${requestScope.pagingHtml}</footer>			
		</div>
</div>
<script type="text/javascript">
		$('#mode option').each(function (index){
			if( $(this).val() == '${requestScope.mode}' ){
				$(this).attr('selected', 'selected') ;
			}
		});	
		
		$('#keyword').val( '${requestScope.keyword}' ) ;
		
		function search(){
			if( $('#mode').val() == 'all' ){
				alert('검색 목록을 선택해주세요') ;
			}
		}
		
		function searchAll(){
			location.href='<%=MyCtrlCommand%>boList';
		}
	</script>
</body>
</html>