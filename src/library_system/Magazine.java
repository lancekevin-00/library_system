package library_system;

public class Magazine extends Item {
	private int year;
	private String genre;
	private String publisher;
	private int volume;
	private int issue;
	private int numCopies;
	private boolean newArrival;
	private String searchTerms[] = new String[3]; //Placeholder 
	public Magazine(int id,String title,int year,String genre,String publisher,int volume, int issue,int numCopies,boolean newArrival) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
		this.volume = volume;
		this.issue = issue;
		this.numCopies = numCopies;
		this.newArrival = newArrival;
		searchTerms[0]= this.title;
		searchTerms[1]= this.genre;
		searchTerms[2] = this.publisher;
		setSearchTerms(searchTerms);
	}
	
	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
}
