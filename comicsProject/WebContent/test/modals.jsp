<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<SCRIPT LANGUAGE=JavaScript>
	/*


	 �ڽ�â���� ������ �̵��� ������� ��â���� ������ ��찡 �ֽ��ϴ�.

	 �̷� ��쿡�� submit�ϴ� �Լ� ���� 

	 document.addrform.target = 'selfWin';

	 window.name = 'selfWin';

	 �ҽ��� �߰��ϰ�, 

	 body�±� �ȿ� �ִ� form �±׿� onsubmit="return false;"�� �߰��ϸ� �ڽ�â ���ο��� ������ �̵��� �̷�����ϴ�.


	 */

	//������ �̵�

	function goLink() {

		document.addrform.action = 'abc.html';

		document.addrform.target = 'selfWin';

		window.name = 'selfWin';

		document.addrform.submit();

		document.addrform.action = '';

	}

	//â �ݱ�

	function closeModal() {

		window.returnValue = 'ok';

		window.close();

	}
</SCRIPT>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name="addrform" id="addform" action="" method="post" onsubmit="return false;">

<input type="button" name="btn" value="������ �̵�" onclick="JavaScript:goLink();"> 

<br />

<A onclick="closeModal();">â�ݱ�</A> 

</form>

</body>
</html>