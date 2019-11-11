package library_system;
/**
 * User abstract super class
 * @author riley and lance
 *
 */
import java.util.ArrayList;
public abstract class User {
	/**
	 * Variables that will be used by each user 
	 */
	protected String Name;
	protected int cardNumber;
	protected String password;
	protected int Age,Fees;
	protected Checked_out_itm[] items;
	protected String Address;
	public boolean is_librarian = false;
	protected String type;
	/** 
	 * Adds a checked out item to the users checked out items
	 * @param itm The item that is being added 
	 * @param i The index that it is adding 
	 */
	public void checkout(Checked_out_itm itm, int i) {
		items[i] = itm;
	}
	/**
	 * Returns a users checked out item
	 * @param index The index of the book that is being returned 
	 */
	public void return_itm(int index) {
		items[index].return_itm();
		items[index] = null;
	}
	/**
	 * Changes the users passwords
	 * @param pwd The new password
	 */
	public void changePwd(String pwd) {
		password = pwd;
	}
	/**
	 * Make payment of fines
	 * @param pmt The payment that the user is paying for their fines
	 */
	public void makePayment(int pmt) {
		Fees = Fees - pmt;
	}
	/**
	 * Checks the return date of a users check 
	 * @param id The id of the book that is being checked for a return date 
	 * @return The time remaining on the checked out book before it is overdue 
	 */
	public int checkReturnDate(int id) {
		for(Checked_out_itm item:items) {
			if (id == item.getId())
				return item.getTime_remaining();
		}
		return -1;
	}

	//getters and setters for the variables
	public String getName() {
		return Name;
	}
	protected void setName(String name) {
		Name = name;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	protected void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return Age;
	}
	protected void setAge(int age) {
		Age = age;
	}
	public double getFees() {
		return Fees;
	}
	
	public void updateFees() {
		Fees = 0;
		for(Checked_out_itm itm: items) {
			if(itm != null) {
				if(itm.getTime_remaining() < 0) {
					Fees += itm.getTime_remaining() * -1;
				}
			}
		}
	}
	
	public void updateDay() {
		for(Checked_out_itm itm: items) {
			if(itm != null) {
				itm.updateDay();
			}
		}
	}
	public String getType() {
		return type;
	}
	protected void setFees(int fees) {
		Fees = fees;
	}
	public String getAddress() {
		return Address;
	}
	protected void setAddress(String address) {
		Address = address;
	}
	public Checked_out_itm[] getItems() {
		return items;
	}
	public void setItems(Checked_out_itm[] items) {
		this.items = items;
	}
}

