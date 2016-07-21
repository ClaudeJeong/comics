package mypkg.model;

public class JoinRecord {
	//��ü �������� ��� ������ ����� ����
	//������ �ʴ� �����鿡 ���� �޸𸮰� ����� �� �ִ�.	
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