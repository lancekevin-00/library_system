package library_system;

public class DVD extends Item {
	private int year;
	private String genre;
	private String director;
	private String actors;
	private int numCopies;
	private boolean newArrival;
	public DVD(int id,String title,int year,String genre,String director,String actors,int numCopies,boolean newArrival) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.actors = actors;
		this.numCopies = numCopies;
		this.newArrival = newArrival;
	}
	
	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
}
