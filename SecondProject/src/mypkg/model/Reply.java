package mypkg.model;

public class Reply {
//Instance
	private int reNum;
	private int bNum;
	private String writer;
	private String content;
	private String regDate;
	private String updateDate;

//Method	
	@Override
	public String toString() {
		return "Reply [reNum=" + reNum + ", bNum=" + bNum + ", writer="
				+ writer + ", content=" + content + ", regDate=" + regDate
				+ ", updateDate=" + updateDate + "]";
	}

	public int getReNum() {
		return reNum;
	}

	public void setReNum(int reNum) {
		this.reNum = reNum;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
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
	
	
}
