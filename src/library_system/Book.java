package library_system;

public class Book extends Item {
	private int year;
	private String genre;
	private String publisher;
	private String author;
	private int numCopies;
	private boolean newArrival;
	private String[] searchTerms = new String[3];
	public Book(int id,String title,int year,String genre,String publisher,String author,int numCopies,boolean newArrival) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
		this.author = author;
		this.numCopies = numCopies;
		this.newArrival = newArrival;
		//Placeholders to test the search function, will clean up once it works 
		searchTerms[0]= this.title;
		searchTerms[1]= this.genre;
		searchTerms[2] = this.author;
		setSearchTerms(searchTerms);
 	}
	
	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
}
