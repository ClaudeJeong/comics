package mypkg.util;

public class ReplyPaging {
	//����¡ ���� ����
		private int totalCount = 0 ; //�� ���ڵ� �Ǽ�
		private int totalPage = 0 ; //��ü ������ ��
		
		private int repageNumber = 0 ; //������ ������ �ѹ�(ǥ�� ������ �������� 1���� totalPage�����̴�.)
		private int repageSize = 0 ; //�� �������� ������ �Ǽ�
		private int beginRow = 0 ; //���� �������� ���� ��
		private int endRow = 0 ; //���� �������� �� ��
		
		private int pageCount = 10 ; //������ ������ ��ũ ��
		private int beginPage = 0 ; //����¡ ó�� ���� ������ ��ȣ
		private int endPage = 0 ; //����¡ ó�� �� ������ ��ȣ
		
		private String url = "" ; //���� ==>  http://localhost:8989/MyServlet/list.do
		private String pagingHtml = "";//�ϴ��� ���� ������ ��ũ
		private String pagingStatus = ""; //��� ������ ���� ������ ��ġ ǥ��
		//�˻��� ���� ���� �߰�
		private String mode = "" ; //�˻� ���(�ۼ���, ������, ��ü �˻��� all) ���
		private String keyword = "" ; //�˻��� �ܾ�  
		
		//pagination Size ����
		private String paginationSize = " pagination-sm" ; //  pagination-lg   pagination-sm    pagination-xs

		
		
		public ReplyPaging(String _repageNumber, String _repageSize, int totalCount, String url, int no) {
			if ( _repageNumber == null || _repageNumber.equals("null") || _repageNumber.equals("")) {
				_repageNumber = "1" ; 
			}
			this.repageNumber = Integer.parseInt( _repageNumber ) ;
			
			if ( _repageSize == null || _repageSize.equals("null") || _repageSize.equals("")) {
				_repageSize = "10" ; 
			}
			this.repageSize = Integer.parseInt( _repageSize ) ;
			
			this.totalCount = totalCount ;
			this.url = url ;
			 
			this.totalPage = (int)Math.ceil((double)totalCount / repageSize) ;
			
			this.beginRow = ( repageNumber - 1 ) * repageSize + 1 ;
			
			this.endRow = this.repageNumber * this.repageSize  ;

			this.beginPage = ( this.repageNumber -1 ) / this.pageCount * this.pageCount + 1 ;
			
			this.endPage = this.beginPage + this.pageCount - 1 ;  

			if( this.totalPage < this.endPage ){ this.endPage = this.totalPage ;  } 
			
			this.pagingHtml = this.getPagingHtml( url, no ) ;
			
			this.pagingStatus = "�� " + totalCount + "��[" 
					+ this.repageNumber + "/" + this.totalPage + "]" ;
			
			
			
			//this.DisplayInformation(); 
		}

		
		private String getPagingHtml( String url, int no ){ //����¡ ���ڿ��� �����.
			String result = "" ;
			
			//add_param ���� : �˻� �����Ͽ� �߰��Ǵ� �Ķ���� ����Ʈ
			
			result += "<ul class='pagination" + paginationSize + "'>";
			if ( repageNumber <= pageCount ) {//1���� 10������������ [��ó��]�� [����]�� ���� 
				//result += "��ó��&nbsp;&nbsp;";
				//result += "����&nbsp;&nbsp;";			
			} else {
				result += "<li><a href='" + url + "&repageNumber=" + 1 + 
					"&repageSize=" + repageSize + "&no=" + no + "'>��ó��</a></li>&nbsp;&nbsp;";
				
				result += "<li><a href='" + url + "&repageNumber=" + (beginPage - 1) + 
					"&repageSize=" + repageSize + "&no=" + no + "'>����</a></li>&nbsp;&nbsp;";
			}		
			//������ ���� ��ȣ ���� ~ �� ��ȣ ���� ǥ��
			
			for (int i = beginPage ; i <= endPage ; i++) {
				if(i == repageNumber){ //���� �������̸� ��ũ�� ����, ���������� ǥ��
					result += "<li class='active'><a><font color='red'><b>" + i + "</b></font></a></li>&nbsp;";
				}else{
					result += "<li><a href='" + url + "&repageNumber=" + i + 
						"&repageSize=" + repageSize + "&no=" + no + "'>" + i + "</li></a>&nbsp;";	
				}			
			}
			
			//���������� [����]�� [�ǳ�]�� ����
			if ( repageNumber >= (totalPage / pageCount * pageCount + 1) ) {
				//result += "����&nbsp;&nbsp;";
				//result += "�� ��&nbsp;&nbsp;";	
			} else {			
				result += "<li><a href='" + url + "&repageNumber=" + (endPage + 1) + 
					"&repageSize=" + repageSize + "&no=" + no + "'>����</a></li>&nbsp;&nbsp;";
				
				result += "<li><a href='" + url + "&repageNumber=" + totalPage + 
					"&repageSize=" + repageSize + "&no=" + no + "'>�� ��</a></li>";
			}
			result += "</ul>"; 
			return result ;
		}	

		private void DisplayInformation() {
			System.out.println("�� ���ڵ� �Ǽ� : " + totalCount + "\n");
			System.out.println("��ü ������ �� : " + totalPage + "\n");
			System.out.println("������ ������ �ѹ� : " + repageNumber + "\n");
			System.out.println("�� �������� ������ �Ǽ� : " + repageSize + "\n");
			System.out.println("���� �������� ���� �� : " + beginRow + "\n");
			System.out.println("���� �������� �� �� : " + endRow + "\n");
			System.out.println("������ ������ ��ũ �� : " + pageCount + "\n");
			System.out.println("����¡ ó�� ���� ������ ��ȣ : " + beginPage + "\n");
			System.out.println("����¡ ó�� �� ������ ��ȣ : " + endPage + "\n");
			System.out.println("��û URL : " + url + "\n");
			//System.out.println("�ϴ��� ���� ������ ��ũ : " + pagingHtml + "\n");
			System.out.println("��� ������ ���� ������ ��ġ ǥ�� : " + pagingStatus + "\n");	
			System.out.println("�˻� ��� : " + mode + "\n");
			System.out.println("�˻� Ű���� : " + keyword + "\n");
		}
		
		public String getPagingHtml() {	return pagingHtml;}
		public int getrepageNumber() {	return repageNumber;}
		public int getrepageSize() {	return repageSize;}	
		public String getPagingStatus() {	return pagingStatus;}	
		public int getBeginRow() {	return beginRow;}
		public int getEndRow() {	return endRow;}
		
		//�� �˻��� ���Ͽ� �˻� ���� �˻� Ű���� �׸��� �߰���
		public String getMode() {return mode;}
		public String getKeyword() { return keyword; 	}
}
