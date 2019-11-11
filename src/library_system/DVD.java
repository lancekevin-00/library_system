package library_system;
/**
 *  DVD item class
 * @author riley and lance
 *
 */
import java.util.ArrayList;
public class DVD extends Item {
	private int year;
	private String genre;
	private String director;
	private String actors;
	private int numCopies;
	private boolean newArrival;
	/**
	 * 
	 * @param id Item id
	 * @param title title of the dvd
	 * @param year year the dvd came out
	 * @param genre genre of the dvd
	 * @param director director fo the dvd
	 * @param actors actors in the dvd
	 * @param numCopies number of copies of the dvd
	 * @param newArrival if the dvd is a new arrival or not
	 */
	public DVD(int id,String title,int year,String genre,String director,String actors,int numCopies,boolean newArrival) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.actors = actors;
		this.numCopies = numCopies;
		this.newArrival = newArrival;
		setCopies_avalible(numCopies);
		setMax_checkout_time(7);
		searchTerms = new String[3];
		searchTerms[0]= this.title;
		searchTerms[1]= this.genre;
		searchTerms[2] = this.director;
		setSearchTerms(searchTerms);
	}
	/**
	 * Notifies the users on the waitlist 
	 */
	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
	/**
	 * Prints the dvd information to the json file in the correct format
	 */
	public String toString() {
		return "{\n \"id\":" + id + ",\n\"title\":\"" + title + "\",\n\"year\":"+ year + ",\n\"genre\":\"" + genre + "\",\n\"director\":\"" + director +"\",\n\"actors\":\"" + actors + "\",\n\"numCopies\":" + numCopies + ",\n\"newArrival\":" +newArrival + "\n}";
	}
}
