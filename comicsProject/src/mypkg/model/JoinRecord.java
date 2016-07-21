package mypkg.model;

public class JoinRecord {
	//객체 변수들을 멤버 변수로 만드는 예시
	//사용되지 않는 변수들에 대한 메모리가 낭비될 수 있다.	
	private Member member ;
	private Book book ;
	private Record record ;
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	
	@Override
	public String toString() {
		return "JoinRecord [member=" + member + ", book=" + book + ", record="
				+ record + "]";
	}
}