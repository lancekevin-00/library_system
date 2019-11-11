package library_system;
/**
 *  Adult User class
 * @author riley and lance
 *
 */
public class Adult extends User {	
	private String firstName,lastName;
	private int accountID;
	/**
	 * Constructor for Adult User
	 * @param id The id of the user
	 * @param firstName First Name of the user
	 * @param lastName Last name of the user
	 * @param birthdayYear Birthday of the user
	 * @param address The address of the user
	 * @param accountID The Id of the account
	 * @param password User's password
	 * @param fines User's fines
	 * @param type The type of user account
	 */
	Adult(int id,String firstName,String lastName,int birthdayYear,String address, int accountID,String password ,int fines,String type) {
		super.Name = firstName+" "+lastName;
		super.cardNumber = id;
		super.password = password;
		super.Age = birthdayYear;
		super.Fees = fines;
		super.Address = address;
		super.items = new Checked_out_itm[10];
		this.firstName = firstName;
		this.lastName = lastName;
		super.type = type;
	} 
	/**
	 * Prints the adult user to the user database in the specific format
	 */
	public String toString() {
		return "{\n\"id\":" +cardNumber+",\n\"firstname\":\""+firstName+"\",\n\"lastName\":\""+lastName+"\",\n\"birthdayYear\":"+Age+",\n\"address\":\""+Address+"\",\n\"accountID\":"+accountID+",\n\"password\":\""+password+"\",\n\"type\":\"A\",\n\"fines\":"+Fees + "\n}";
	}
}
