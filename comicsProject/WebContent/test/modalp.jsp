<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
	function modalPop(url) {

		var popOptions = "dialogWidth: 300px; dialogHeight: 220px; center: yes; resizable: yes; status: no; scroll: no;";

		var vReturn = window.showModalDialog(url, window, popOptions);

		if (vReturn == 'ok') {

			// (���â���� ��ư �̺�Ʈ ���� �Ǵ� �ݱ� ��)���â�� ������ �� �θ�â���� ���� �� �Լ�
			self.location.href="http://localhost:8888/comicsProject/main.jsp";
			location.reload();
			alert("���ε强��?");
			return;

		} else {

			return;

		}

		return vReturn;

	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<A href="javascript:modalPop('modals.jsp');">����˾� ����</A> 
</body>
</html>