package library_system;

public class Magazine extends Item {
	private int year;
	private String genre;
	private String publisher;
	private int volume;
	private String issue;
	private int numCopies;
	private boolean newArrival;
	public Magazine(int id,String title,int year,String genre,String publisher,int volume, String issue,int numCopies,boolean newArrival) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
		this.volume = volume;
		this.issue = issue;
		this.numCopies = numCopies;
		this.newArrival = newArrival;
	}
	
	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
}
