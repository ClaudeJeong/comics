package mypkg.model;

public class JoinRecord02 {
	
	private int recordnum ;
	private int bcode ;
	private String name ;
	private int volume ;
	private String writer ;
	private String nickname ;
	private String mid ;
	private String lenddate ;
	private String returndate ;
	private String overdue ;
	
	public int getRecordnum() {
		return recordnum;
	}
	public void setRecordnum(int recordnum) {
		this.recordnum = recordnum;
	}
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getLenddate() {
		return lenddate;
	}
	public void setLenddate(String lenddate) {
		this.lenddate = lenddate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public String getOverdue() {
		return overdue;
	}
	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	@Override
	public String toString() {
		return "JoinRecord02 [recordnum=" + recordnum + ", bcode=" + bcode
				+ ", name=" + name + ", volume=" + volume + ", writer="
				+ writer + ", nickname=" + nickname + ", mid=" + mid
				+ ", lenddate=" + lenddate + ", returndate=" + returndate
				+ ", overdue=" + overdue + "]";
	}
	
}