package library_system;
/**
 *  Book item class
 * @author riley and lance
 *
 */
public class Audio_Book extends Item {
	private int year;
	private String genre;
	private String publisher;
	private String author;
	private int numCopies;
	private boolean newArrival;
	/**
	 * Constructor for AudioBook item class
	 * @param id Item id
	 * @param title Title of the audiobook
	 * @param year year of the audiobook
	 * @param genre Genre of the audiobook
	 * @param publisher publisher of the audiobook
	 * @param author author of the audiobook
	 * @param numCopies number of copies of the audiobook
	 * @param newArrival if the audiobook is a new arrival or not
	 */
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
		setMax_checkout_time(30);
		searchTerms = new String[3];
		searchTerms[0]= this.title;
		searchTerms[1]= this.genre;
		searchTerms[2] = this.author;
		setSearchTerms(searchTerms);
	}
	/**
	 * Notifies the users on the waitlist
	 */
	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
	/**
	 * Prints the audiobook information to the json file in the correct format
	 */
	public String toString() {
		return "{\n \"id\":" + id + ",\n\"title\":\"" + title + "\",\n\"year\":"+ year + ",\n\"genre\":\"" + genre + "\",\n\"publisher\":\"" + publisher +"\",\n\"author\":\"" + author + "\",\n\"numCopies\":" + numCopies + ",\n\"newArrival\":" +newArrival + "\n}";
	}
}
