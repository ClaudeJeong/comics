package mypkg.model;

public class Book {
//Instance
	private int bookCode;
	private String name;
	private String writer;
	private String publisher;
	private String pubDate;
	private String	genre;
	private String image;
	private String bookStat;

//Method
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", name=" + name + ", writer="
				+ writer + ", publisher=" + publisher + ", pubDate=" + pubDate
				+ ", genre=" + genre + ", image=" + image + ", bookStat="
				+ bookStat + "]";
	}
	
	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
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
	public String getBookStat() {
		return bookStat;
	}
	public void setBookStat(String bookStat) {
		this.bookStat = bookStat;
	}
	
	
}
