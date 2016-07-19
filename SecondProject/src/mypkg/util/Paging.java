package mypkg.util;

public class Paging {
	//����¡ ���� ����
	private int totalCount = 0 ; //�� ���ڵ� �Ǽ�
	private int totalPage = 0 ; //��ü ������ ��
	
	private int pageNumber = 0 ; //������ ������ �ѹ�(ǥ�� ������ �������� 1���� totalPage�����̴�.)
	private int pageSize = 0 ; //�� �������� ������ �Ǽ�
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
	private String paginationSize = " pagination-sm " ; //  pagination-lg   pagination-sm    pagination-xs

//Constructor	
	public Paging(String _pageNumber, String _pageSize, int totalCount, String url, String mode, String keyword) {
		if ( _pageNumber == null || _pageNumber.equals("null")) {
			_pageNumber = "1" ; 
		}
		
		this.pageNumber = Integer.parseInt( _pageNumber ) ;
		
		if ( _pageSize == null || _pageSize.equals("null")) {
			_pageSize = "10" ; 
		}
		
		this.pageSize = Integer.parseInt( _pageSize ) ;
		
		this.totalCount = totalCount ;
		this.url = url ;
		
		this.totalPage = (int)Math.ceil((double)totalCount / pageSize) ;
		
		this.beginRow = ( pageNumber - 1 ) * pageSize + 1 ;
		
		this.endRow = this.pageNumber * this.pageSize  ;

		this.beginPage = ( this.pageNumber -1 ) / this.pageCount * this.pageCount + 1 ;
		
		this.endPage = this.beginPage + this.pageCount - 1 ;  

		if( this.totalPage < this.endPage ){ this.endPage = this.totalPage ;  } 
		
		this.pagingHtml = this.getPagingHtml( url ) ;
		
		this.pagingStatus = "�� " + totalCount + "��[" 
				+ this.pageNumber + "/" + this.totalPage + "]" ;
		
		this.mode = mode ;
		this.keyword = keyword ; 
		
		//this.DisplayInformation(); 
	}//Constructor end

	private String getPagingHtml( String url ){ //����¡ ���ڿ��� �����.
		String result = "" ;
		
		//add_param ���� : �˻� �����Ͽ� �߰��Ǵ� �Ķ���� ����Ʈ
		String add_param = "&mode=" + mode + "&keyword=" + keyword ; 
		
		result += "<ul class='pagination" + paginationSize + "'>";
		if ( pageNumber <= pageCount ) {//1���� 10������������ [��ó��]�� [����]�� ���� 
			//result += "��ó��&nbsp;&nbsp;";
			//result += "����&nbsp;&nbsp;";			
		} else {
			result += "<li><a href='" + url + "&pageNumber=" + 1 + 
				"&pageSize=" + pageSize + add_param + "'>��ó��</a></li>&nbsp;&nbsp;";
			
			result += "<li><a href='" + url + "&pageNumber=" + (beginPage - 1) + 
				"&pageSize=" + pageSize + add_param + "'>����</a></li>&nbsp;&nbsp;";
		}		
		//������ ���� ��ȣ ���� ~ �� ��ȣ ���� ǥ��
		
		for (int i = beginPage ; i <= endPage ; i++) {
			if(i == pageNumber){ //���� �������̸� ��ũ�� ����, ���������� ǥ��
				result += "<li class='active'><a><font color='red'><b>" + i + "</b></font></a></li>&nbsp;";
			}else{
				result += "<li><a href='" + url + "&pageNumber=" + i + 
					"&pageSize=" + pageSize + add_param + "'>" + i + "</li></a>&nbsp;";	
			}			
		}
		
		//���������� [����]�� [�ǳ�]�� ����
		if ( pageNumber >= (totalPage / pageCount * pageCount + 1) ) {
			//result += "����&nbsp;&nbsp;";
			//result += "�� ��&nbsp;&nbsp;";	
		} else {			
			result += "<li><a href='" + url + "&pageNumber=" + (endPage + 1) + 
				"&pageSize=" + pageSize + add_param + "'>����</a></li>&nbsp;&nbsp;";
			
			result += "<li><a href='" + url + "&pageNumber=" + totalPage + 
				"&pageSize=" + pageSize + add_param + "'>�� ��</a></li>";
		}
		result += "</ul>"; 
		return result ;
	}	

	private void DisplayInformation() {
		System.out.println("�� ���ڵ� �Ǽ� : " + totalCount + "\n");
		System.out.println("��ü ������ �� : " + totalPage + "\n");
		System.out.println("������ ������ �ѹ� : " + pageNumber + "\n");
		System.out.println("�� �������� ������ �Ǽ� : " + pageSize + "\n");
		System.out.println("���� �������� ���� �� : " + beginRow + "\n");
		System.out.println("���� �������� �� �� : " + endRow + "\n");
		System.out.println("������ ������ ��ũ �� : " + pageCount + "\n");
		System.out.println("����¡ ó�� ���� ������ ��ȣ : " + beginPage + "\n");
		System.out.println("����¡ ó�� �� ������ ��ȣ : " + endPage + "\n");
		System.out.println("��û URL : " + url + "\n");
		System.out.println("�ϴ��� ���� ������ ��ũ : " + pagingHtml + "\n");
		System.out.println("��� ������ ���� ������ ��ġ ǥ�� : " + pagingStatus + "\n");	
		System.out.println("�˻� ��� : " + mode + "\n");
		System.out.println("�˻� Ű���� : " + keyword + "\n");
	}
	
	public String getPagingHtml() {	return pagingHtml;}
	public int getPageNumber() {	return pageNumber;}
	public int getPageSize() {	return pageSize;}	
	public String getPagingStatus() {	return pagingStatus;}	
	public int getBeginRow() {	return beginRow;}
	public int getEndRow() {	return endRow;}
	
	//�� �˻��� ���Ͽ� �˻� ���� �˻� Ű���� �׸��� �߰���
	public String getMode() {return mode;}
	public String getKeyword() { return keyword; 	}	 
}