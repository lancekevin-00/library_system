package library_system;
/**
 * Item class
 * @author riley and lance
 *
 */
public class Item{
	/**
	 * Variables to be used by all item types
	 */
	protected int max_checkout_time;
	protected User[] waitlist;
	protected int copies_avalible;
	protected int copies_in_stock;
	protected String[] searchTerms;
	protected String title;
	protected int id;
	//Getters and Setters for attributes of each item
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMax_checkout_time() {
		return max_checkout_time;
	}
	public void setMax_checkout_time(int max_checkout_time) {
		this.max_checkout_time = max_checkout_time;
	}
	
	public User[] getWaitlist() {
		return waitlist;
	}
	public void notifyWaitlist() {
		User next = waitlist[0];
	}
	public int getCopies_avalible() {
		return copies_avalible;
	}
	public void setCopies_avalible(int copies_avalible) {
		this.copies_avalible = copies_avalible;
	}
	
	public int getCopies_in_stock() {
		return copies_in_stock;
	}
	public void setCopies_in_stock(int copies_in_stock) {
		this.copies_in_stock = copies_in_stock;
	}
	
	public String[] getSearchTerms() {
		return searchTerms;
	}
	public void setSearchTerms(String[] searchTerms) {
		this.searchTerms = searchTerms;
	}
	
	public String getTitle() {
		return title;
	}
	/**
	 *  Checks out the item for the specific user
	 * @param u The specific user
	 * @return null
	 */
	public Checked_out_itm checkout(User u) {
		if(waitlist == null)
			waitlist = new User[10];
		//being added to the waitlist
		if(copies_avalible == 0) {
			System.out.println("There are no copies of "+ title + " in stock. You are being added to the waitlist");
			for(int i = 0; i < waitlist.length; i++) {
				if(waitlist[i] == null) {
					waitlist[i] = u;
					System.out.println("you are the #" + (i+1) + " in line for this book");
					return null;
				}
				System.out.println("The waitlist has reached its maximum size, Sorry");
			}
		}
		
		//checking out the item
		copies_avalible --;
		Checked_out_itm ret = new Checked_out_itm(title, this);
		return ret;
	}

}
