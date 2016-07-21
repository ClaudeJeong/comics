package mypkg.model;

public class Record {
	private int recordnum ;	
	private String mid ;
	private int bcode ;
	private String lenddate ;
	private int period ;
	private String returndate ;
	
	public int getRecordnum() {
		return recordnum;
	}
	public void setRecordnum(int recordnum) {
		this.recordnum = recordnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getLenddate() {
		return lenddate;
	}
	public void setLenddate(String lenddate) {
		this.lenddate = lenddate;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	@Override
	public String toString() {
		return "Record [recordnum=" + recordnum + ", mid=" + mid + ", bcode="
				+ bcode + ", lenddate=" + lenddate + ", period=" + period
				+ ", returndate=" + returndate + "]";
	}
	
}