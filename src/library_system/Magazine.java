package library_system;
/**
 *  Magazine item class
 * @author riley and lance
 *
 */
public class Magazine extends Item {
	private int year;
	private String genre;
	private String publisher;
	private int volume;
	private int issue;
	private int numCopies;
	private boolean newArrival;
	/**
	 * 
	 * @param id Item id 
	 * @param title title of the magazine
	 * @param year year the magazine came out
	 * @param genre genre of the magazine
	 * @param publisher publisher of the magazine
	 * @param volume volume of the magazine
	 * @param issue issue number of the magazine
	 * @param numCopies number of copies of the magazine
	 * @param newArrival if the magazine is a new arrival or not
	 */
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
		setMax_checkout_time(30);
		searchTerms = new String[3];
		searchTerms[0]= this.title;
		searchTerms[1]= this.genre;
		searchTerms[2] = this.publisher;
		setSearchTerms(searchTerms);
	}
	/**
	 * Notifies the users on the waitlist 
	 */
	public void notifyWaitlist() {
		super.notifyWaitlist();
	}
	/**
	 * Prints the magazine information to the json file in the correct format
	 */
	public String toString() {
		return "{\n \"id\":" + id + ",\n\"title\":\"" + title + "\",\n\"year\":"+ year + ",\n\"genre\":\"" + genre + "\",\n\"publisher\":\"" + publisher + "\",\n\"volume\":" + volume + ",\n\"issue\":" + issue + ",\n\"numCopies\":" + numCopies + ",\n\"newArrival\":" +newArrival + "\n}";
	}
}
