package library_system;

public class Teacher extends User{
	private String firstName,lastName;
	private int accountID;
	Teacher(int id,String firstName,String lastName,int birthdayYear,String address, int accountID,String password ,double fines) {
		super.Name = firstName+" "+lastName;
		this.firstName = firstName;
		this.lastName = lastName;
		super.cardNumber = id;
		super.password = password;
		super.Age = birthdayYear;
		super.Fees = fines;
		super.Address = address;
		super.items = new Checked_out_itm[50];
		this.accountID = accountID;
		
	}
	public String toString() {
		return "{\n\"id\":" +cardNumber+",\n\"firstname\":\""+firstName+",\n\"name\":\""+lastName+",\n\"birthdayYear\":"+Age+",\n\"address\":\""+Address+",\n\"accountID\":"+accountID+",\n\"password\":\""+password+",\n\"type\":\"T\",\n\"fines\":"+Fees + "\n}";
	}
}
