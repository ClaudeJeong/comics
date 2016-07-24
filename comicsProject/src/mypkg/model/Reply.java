package mypkg.model;

public class Reply {
//Instance	
	private int reNum;
	private int boNum;
	private String writer;
	private String content;
	private String regDate;
	private String updateDate;
	private int orderNo;
	private int depth;
	
//Method
	@Override
	public String toString() {
		return "Reply [reNum=" + reNum + ", boNum=" + boNum + ", writer=" + writer + ", content=" + content +
				"orderNo=" + orderNo + ", depth=" + depth + "]";
	}
	
	public int getReNum() {
		return reNum;
	}
	
	public void setReNum(int reNum) {
		this.reNum = reNum;
	}
	public int getBoNum() {
		return boNum;
	}
	public void setBoNum(int boNum) {
		this.boNum = boNum;
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
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
}
