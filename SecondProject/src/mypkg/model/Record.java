package mypkg.model;

public class Record {
//Instance
	private int recordNum;
	private String mid;
	private int bCode;
	private String lendDate;
	private String period;
	private String returnDate;
	
//Method
	@Override
	public String toString() {
		return "Record [recordNum=" + recordNum + ", mid=" + mid + ", bCode="
				+ bCode + ", lendDate=" + lendDate + ", period=" + period
				+ ", returnDate=" + returnDate + "]";
	}
	
	public int getRecordNum() {
		return recordNum;
	}
	
	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getbCode() {
		return bCode;
	}
	public void setbCode(int bCode) {
		this.bCode = bCode;
	}
	public String getLendDate() {
		return lendDate;
	}
	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	
}
