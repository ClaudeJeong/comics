<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="resourceSiteForm" action="http://www.aaa/" style="display:inline;" method="post" target="_blank">
  <dl id="aaa">
  <dt class="lang">다국어메뉴</dt>
  <dd class="lang_menu">
   <select title="사이트 언어를 선택하세요." name="resourceSite">
    <option value="http://www.**./">KOREA</option>
    <option value="http://english.**">ENGLISH</option>
    <option value="http://japanese.**">JAPANESE</option>
   </select>
  </dd>
  <dd><input type="image" src="/images/kr/common/eng_btn_go.gif" alt="GO" /></dd>
  </dl>
</form>
<script type="text/javascript">
   $("form[name=resourceSiteForm]").submit(function() {
    if ( !confirm("새창으로 이동하시겠습니까?") )  return false;
     this.action = this.resourceSite.value;
     return true;
   });

</script>



</body>
</html>