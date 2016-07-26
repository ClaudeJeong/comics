package mypkg.util;

public class ReplyPaging {
	//페이징 관련 변수
		private int totalCount = 0 ; //총 레코드 건수
		private int totalPage = 0 ; //전체 페이지 수
		
		private int repageNumber = 0 ; //보여줄 페이지 넘버(표현 가능한 페이지는 1부터 totalPage까지이다.)
		private int repageSize = 0 ; //한 페이지에 보여줄 건수
		private int beginRow = 0 ; //현재 페이지의 시작 행
		private int endRow = 0 ; //현재 페이지의 끝 행
		
		private int pageCount = 10 ; //보여줄 페이지 링크 수
		private int beginPage = 0 ; //페이징 처리 시작 페이지 번호
		private int endPage = 0 ; //페이징 처리 끝 페이지 번호
		
		private String url = "" ; //예시 ==>  http://localhost:8989/MyServlet/list.do
		private String pagingHtml = "";//하단의 숫자 페이지 링크
		private String pagingStatus = ""; //상단 우측의 현재 페이지 위치 표시
		//검색을 위한 변수 추가
		private String mode = "" ; //검색 모드(작성자, 글제목, 전체 검색은 all) 등등
		private String keyword = "" ; //검색할 단어  
		
		//pagination Size 변수
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
			
			this.pagingStatus = "총 " + totalCount + "건[" 
					+ this.repageNumber + "/" + this.totalPage + "]" ;
			
			
			
			//this.DisplayInformation(); 
		}

		
		private String getPagingHtml( String url, int no ){ //페이징 문자열을 만든다.
			String result = "" ;
			
			//add_param 변수 : 검색 관련하여 추가되는 파라미터 리스트
			
			result += "<ul class='pagination" + paginationSize + "'>";
			if ( repageNumber <= pageCount ) {//1부터 10페이지까지는 [맨처음]과 [이전]이 없다 
				//result += "맨처음&nbsp;&nbsp;";
				//result += "이전&nbsp;&nbsp;";			
			} else {
				result += "<li><a href='" + url + "&repageNumber=" + 1 + 
					"&repageSize=" + repageSize + "&no=" + no + "'>맨처음</a></li>&nbsp;&nbsp;";
				
				result += "<li><a href='" + url + "&repageNumber=" + (beginPage - 1) + 
					"&repageSize=" + repageSize + "&no=" + no + "'>이전</a></li>&nbsp;&nbsp;";
			}		
			//페이지 시작 번호 부터 ~ 끝 번호 까지 표시
			
			for (int i = beginPage ; i <= endPage ; i++) {
				if(i == repageNumber){ //현재 페이지이면 링크는 없고, 빨간색으로 표시
					result += "<li class='active'><a><font color='red'><b>" + i + "</b></font></a></li>&nbsp;";
				}else{
					result += "<li><a href='" + url + "&repageNumber=" + i + 
						"&repageSize=" + repageSize + "&no=" + no + "'>" + i + "</li></a>&nbsp;";	
				}			
			}
			
			//마지막에는 [다음]과 [맨끝]이 없다
			if ( repageNumber >= (totalPage / pageCount * pageCount + 1) ) {
				//result += "다음&nbsp;&nbsp;";
				//result += "맨 끝&nbsp;&nbsp;";	
			} else {			
				result += "<li><a href='" + url + "&repageNumber=" + (endPage + 1) + 
					"&repageSize=" + repageSize + "&no=" + no + "'>다음</a></li>&nbsp;&nbsp;";
				
				result += "<li><a href='" + url + "&repageNumber=" + totalPage + 
					"&repageSize=" + repageSize + "&no=" + no + "'>맨 끝</a></li>";
			}
			result += "</ul>"; 
			return result ;
		}	

		private void DisplayInformation() {
			System.out.println("총 레코드 건수 : " + totalCount + "\n");
			System.out.println("전체 페이지 수 : " + totalPage + "\n");
			System.out.println("보여줄 페이지 넘버 : " + repageNumber + "\n");
			System.out.println("한 페이지에 보여줄 건수 : " + repageSize + "\n");
			System.out.println("현재 페이지의 시작 행 : " + beginRow + "\n");
			System.out.println("현재 페이지의 끝 행 : " + endRow + "\n");
			System.out.println("보여줄 페이지 링크 수 : " + pageCount + "\n");
			System.out.println("페이징 처리 시작 페이지 번호 : " + beginPage + "\n");
			System.out.println("페이징 처리 끝 페이지 번호 : " + endPage + "\n");
			System.out.println("요청 URL : " + url + "\n");
			//System.out.println("하단의 숫자 페이지 링크 : " + pagingHtml + "\n");
			System.out.println("상단 우측의 현재 페이지 위치 표시 : " + pagingStatus + "\n");	
			System.out.println("검색 모드 : " + mode + "\n");
			System.out.println("검색 키워드 : " + keyword + "\n");
		}
		
		public String getPagingHtml() {	return pagingHtml;}
		public int getrepageNumber() {	return repageNumber;}
		public int getrepageSize() {	return repageSize;}	
		public String getPagingStatus() {	return pagingStatus;}	
		public int getBeginRow() {	return beginRow;}
		public int getEndRow() {	return endRow;}
		
		//상세 검색을 위하여 검색 모드와 검색 키워드 항목이 추가됨
		public String getMode() {return mode;}
		public String getKeyword() { return keyword; 	}
}
