package mypkg.model;
public class Book {
	private int bookcode ;	
	private String name ;
	private int volume ;
	private String writer ;
	private String publisher ;
	private String pubdate ;
	private String genre ;
	private String image ;
	private String bookstat ;
	private String bookstory ;
	
	public int getBookcode() {
		return bookcode;
	}
	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBookstat() {
		return bookstat;
	}
	public void setBookstat(String bookstat) {
		this.bookstat = bookstat;
	}
	public String getBookstory() {
		return bookstory;
	}
	public void setBookstory(String bookstory) {
		this.bookstory = bookstory;
	}
	@Override
	public String toString() {
		return "Book [bookcode=" + bookcode + ", name=" + name + ", volume="
				+ volume + ", writer=" + writer + ", publisher=" + publisher
				+ ", pubdate=" + pubdate + ", genre=" + genre + ", image="
				+ image + ", bookstat=" + bookstat + ", bookstory=" + bookstory
				+ "]";
	}

}