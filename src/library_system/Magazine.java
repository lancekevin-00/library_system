package library_system;

public class Magazine extends Item {
	private int year;
	private String genre;
	private String publisher;
	private int volume;
	private int issue;
	private int numCopies;
	private boolean newArrival;
	public Magazine(int id,String title,int year,String genre,String publisher,int volume, int issue,int numCopies,boolean newArrival) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
		this.volume = volume;
		this.issue = issue;
		this.numCopies = numCopies;
		this.newArrival = newArrival;
		setCopies_avalible(numCopies);
		searchTerms = new String[3];
		searchTerms[0]= this.title;
		searchTerms[1]= this.genre;
		searchTerms[2] = this.publisher;
		setSearchTerms(searchTerms);
	}
	

	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
	public String toString() {
		return "{\n \"id\":" + id + ",\n\"title\":\"" + title + "\",\n\"year\":"+ year + ",\n\"genre\":\"" + genre + "\",\n\"publisher\":\"" + publisher + "\",\n\"volume\":" + volume + ",\n\"issue\":" + issue + ",\n\"numCopies\":" + numCopies + ",\n\"newArrival\":" +newArrival + "\n}";
	}
}
