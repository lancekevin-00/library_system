package library_system;

public class Child extends User {
	private Adult parent;
	
	Child(int id,String firstName,String lastName,int birthdayYear,String address, int accountID,String password ,double fines, Adult parent) {
		super.Name = firstName+" "+lastName;
		super.cardNumber = id;
		super.password = password;
		super.Age = birthdayYear;
		super.Fees = 0;
		super.Address = address;
		super.items = new Checked_out_itm[3];
		this.parent = parent;
	}
	
	public void setFees(double fee) {
		parent.Fees = parent.Fees + Fees;
	}
}
