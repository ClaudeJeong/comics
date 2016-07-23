package mypkg.model;

public class Board {
//Instance	
	private int no;
	private String boardType;
	private String writer;
	private String subject;
	private String content;
	private String regDate;
	private String updateDate;
	private int readHit;
	private String image ;
	private String password;
	private String remark;
	
	
//Method	
	
	@Override
	public String toString() {
		return "Board [no=" + no + ", boardType=" + boardType + ", writer=" + writer + ", subject=" + subject
				+ ", content=" + content + ", regDate=" + regDate + ", updateDate=" + updateDate + ", readHit="
				+ readHit + ", image=" + image + ", password=" + password + ", remark=" + remark + "]";
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
	public int getReadHit() {
		return readHit;
	}
	public void setReadHit(int readHit) {
		this.readHit = readHit;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
