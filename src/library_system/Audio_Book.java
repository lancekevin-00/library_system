package library_system;

public class Audio_Book extends Item {
	private int year;
	private String genre;
	private String publisher;
	private String author;
	private int numCopies;
	private boolean newArrival;
	public Audio_Book(int id,String title,int year,String genre,String publisher,String author,int numCopies,boolean newArrival) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
		this.author = author;
		this.numCopies = numCopies;
		this.newArrival = newArrival;
		setCopies_avalible(numCopies);
		searchTerms = new String[3];
		searchTerms[0]= this.title;
		searchTerms[1]= this.genre;
		searchTerms[2] = this.author;
		setSearchTerms(searchTerms);
	}
	
	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
	public String toString() {
		return "{\n \"id\":" + id + ",\n\"title\":\"" + title + "\",\n\"year\":"+ year + ",\n\"genre\":\"" + genre + "\",\n\"publisher\":\"" + publisher +"\",\n\"author\":\"" + author + "\",\n\"numCopies\":" + numCopies + ",\n\"newArrival\":" +newArrival + "\n}";
	}
}
