package library_system;

public class Item{
	protected int max_checkout_time;
	protected User[] waitlist;
	protected int copies_avalible;
	protected int copies_in_stock;
	protected String[] searchTerms;
	protected String title;
	protected int id;
	
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
		for(User user:waitlist) {
			System.out.println("notifying " + user.getName());
		}
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
	
	public Checked_out_itm checkout() {
		copies_avalible --;
		Checked_out_itm ret = new Checked_out_itm(title, this);
		return ret;
	}

}
