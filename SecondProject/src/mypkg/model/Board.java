package mypkg.model;

public class Board {
//Instance
	private int num;
	private String boardType;
	private String writer;
	private String subject;
	private String content;
	private String regDate;
	private String updateDate;
	private int number;

//Method	
	@Override
	public String toString() {
		return "Board [num=" + num + ", boardType=" + boardType + ", writer="
				+ writer + ", subject=" + subject + ", content=" + content
				+ ", regDate=" + regDate + ", updateDate=" + updateDate
				+ ", number=" + number + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
