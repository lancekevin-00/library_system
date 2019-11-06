package library_system;
import java.util.ArrayList;
public abstract class User {
	protected String Name;
	protected int cardNumber;
	protected String password;
	protected int Age;
	protected double Fees;
	protected Checked_out_itm[] items;
	protected String Address;
	public boolean is_librarian = false;
	protected String email;
	protected int phone;

	public void checkout(Checked_out_itm itm, int i) {
		items[i] = itm;
	}

	public void return_itm(int index) {
		items[index].return_itm();
		items[index] = null;
	}

	public void changePwd(String pwd) {
		password = pwd;
	}
	public void makePayment(double pmt) {
		Fees = Fees - pmt;
	}
	public int checkReturnDate(int id) {
		for(Checked_out_itm item:items) {
			if (id == item.getId())
				return item.getTime_remaining();
		}
		return -1;
	}

	//getters and setters
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
			if(itm.getTime_remaining() < 0) {
				Fees += itm.getTime_remaining() * -1;
			}
		}
	}
	
	public void updateDay() {
		for(Checked_out_itm itm: items) {
			itm.updateDay();
		}
	}
	
	protected void setFees(double fees) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
}
