package library_system;

public class DVD extends Item {
	private int year;
	private String genre;
	private String director;
	//private String[] actors;
	private int numCopies;
	private boolean newArrival;
	public DVD(int id,String title,int year,String genre,String director/*,String[] actors*/,int numCopies,boolean newArrival) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.director = director;
		//this.actors = actors;
		this.numCopies = numCopies;
		this.newArrival = newArrival;
		searchTerms = new String[3];
		searchTerms[0]= this.title;
		searchTerms[1]= this.genre;
		searchTerms[2] = this.director;
		setSearchTerms(searchTerms);
	}
	
	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
	public String toString() {
		return "{\n \"id\":" + id + ",\n\"title\":\"" + title + "\",\n\"year\":"+ year + ",\n\"genre\":\"" + genre + "\",\n\"director\":\"" + director /*+"\",\n\"actors\":\"" + actors */+ "\",\n\"numCopies\":" + numCopies + ",\n\"newArrival\":" +newArrival + "\n}";
	}
}
