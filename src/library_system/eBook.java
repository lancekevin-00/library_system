package library_system;

public class eBook extends Item {
	private int year;
	private String genre;
	private String publisher;
	private String author;
	private int numCopies;
	private boolean newArrival;
	public eBook(int id,String title,int year,String genre,String publisher,String author,int numCopies,boolean newArrival) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
		this.author = author;
		this.numCopies = numCopies;
		this.newArrival = newArrival;
	}
	
	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
}
