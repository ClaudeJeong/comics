package mypkg.model;

public class JoinRecord01 {
	private String nickname ;
	private String mid ;
	private String mname ;
	private String birth;
	private String phone1;
	private String phone2;
	private String phone3;
	private String gender;
	private int recordnum ;
	private int bcode ;
	private String bname ;
	private int volume ;
	private String writer ;
	private String lenddate ;
	private String duedate ;
	private int overdue;
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
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
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
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
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
	public String getLenddate() {
		return lenddate;
	}
	public void setLenddate(String lenddate) {
		this.lenddate = lenddate;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public int getOverdue() {
		return overdue;
	}
	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}
	@Override
	public String toString() {
		return "JoinRecord01 [nickname=" + nickname + ", mid=" + mid
				+ ", mname=" + mname + ", birth=" + birth + ", phone1="
				+ phone1 + ", phone2=" + phone2 + ", phone3=" + phone3
				+ ", gender=" + gender + ", recordnum=" + recordnum
				+ ", bcode=" + bcode + ", bname=" + bname + ", volume="
				+ volume + ", writer=" + writer + ", lenddate=" + lenddate
				+ ", duedate=" + duedate + ", overdue=" + overdue + "]";
	}
	
	
}