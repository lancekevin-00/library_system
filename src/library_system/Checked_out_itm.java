package library_system;
/**
 * 	Checked out item class
 * @author riley and lance
 *
 */
public class Checked_out_itm {
	/**
	 * All variables used by the checked out item
	 */
	private Item item;
	private String type;
	private int renewals;
	private int time_remaining;
	private String title;
	private int id,userid;
	/**
	 * Constructor of checked_out_itm
	 * @param t the type of item
	 * @param item The object of the specific itme being checked out 
	 */
	public Checked_out_itm(String t, Item item) {
		type = t;
		renewals = 0;
		time_remaining = item.getMax_checkout_time();
		title = item.getTitle();
		id = item.getId();
		this.item = item;
	}
	/** 
	 * Constructor for loading from database
	 * @param userid User that checked out the item
	 * @param title Title of the checked out item
	 * @param id id of the checeked out item
	 * @param renewals how many times the item has been renewed
	 * @param timeremaining time left before item is overdue
	 */
	public Checked_out_itm(int userid, String title, int id, int renewals, int timeremaining) { 
		this.userid = userid;
		this.title = title;
		this.id = id;
		this.renewals = renewals;
		this.time_remaining = timeremaining;
	}
	/**
	 * Returns the item 
	 */
	public void return_itm() {
		item.setCopies_avalible(item.getCopies_avalible() + 1);
	}
	/**
	 * Renews the item
	 */
	public void renew() {
		if(renewals == 3) {
			System.out.println("this item is not renewable");
		}
		else {
			renewals ++;
			System.out.println("this is the "+ renewals + "renewal of this item");
		}
	}
	//Getters and Setters
	public int getUserId() {
		return userid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRenewals() {
		return renewals;
	}
	public void setRenewals(int renewals) {
		this.renewals = renewals;
	}
	public int getTime_remaining() {
		return time_remaining;
	}
	public void updateDay() {
		time_remaining --;
		System.out.println(id + ": " +time_remaining);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String name) {
		this.title = name;
	}
	public void setItem(Item i) {
		item = i;
	}
	
	/**
	 * Prints the checked_out_itm information to the database in the specific format
	 */
	public String toString() {

		return "{\n\"userid\":"+ userid+",\n\"id\":" +id+",\n\"title\":\""+title+"\",\n\"renewals\":"+renewals+",\n\"timeremaining\":"+time_remaining+"\n}";
	}
}
