package mypkg.model;

public class BookComent {
//Instance
	private int bcNum;
	private int bCode;
	private String writer;
	private String content;
	private String regDate;
	private String updateDate;
	private int star;
//Method
	@Override
	public String toString() {
		return "BookComent [bcNum=" + bcNum + ", bCode=" + bCode + ", writer="
				+ writer + ", content=" + content + ", regDate=" + regDate
				+ ", updateDate=" + updateDate + ", star=" + star + "]";
	}
	public int getBcNum() {
		return bcNum;
	}
	public void setBcNum(int bcNum) {
		this.bcNum = bcNum;
	}
	public int getbCode() {
		return bCode;
	}
	public void setbCode(int bCode) {
		this.bCode = bCode;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
	
}
