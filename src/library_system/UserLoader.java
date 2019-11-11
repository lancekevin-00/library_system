package library_system;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;
public class UserLoader {
	private static final String USER_FILE_NAME = "users.json";
	private static final String CHKITEM_FILE_NAME = "checkedoutitems.json";
	private static ArrayList<User> users = new ArrayList<User>();	
	public static ArrayList<User> loadUsers() {
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray userJSON = (JSONArray)jsonData.get("users");
			
			for(int i=0; i < userJSON.size(); i++) {
				JSONObject UserJSON = (JSONObject)userJSON.get(i);
				int id = (int)(long)UserJSON.get("id");
				String firstName = (String)UserJSON.get("firstname"); 
				String lastName = (String)UserJSON.get("lastName");
				int birthdayYear = (int)(long)UserJSON.get("birthdayYear"); // Need to add this to the json file 
				String address = (String)UserJSON.get("address");
			//	String email = (String)UserJSON.get("email"); //add this and phone to constructors
			//	String phone = (String)UserJSON.get("phone"); //Have it as a string right now but idk if you want to make it an integer or not
				int accountID = (int)(long)UserJSON.get("accountID");
				String password = (String)UserJSON.get("password");
				String type = (String)UserJSON.get("type");
				int fines = (int)(long)UserJSON.get("fines");
				if(type.equals("A")) {
					users.add(new Adult(id,firstName,lastName,birthdayYear,address,accountID,password ,fines,type)); 
				}
				else if(type.equals("C")) {
					//users.add(new Child(id,firstName,lastName,birthdayYear,address,accountID,password ,fines)); 
				}
				else if(type.equals("T")) { 
					users.add(new Teacher(id,firstName,lastName,birthdayYear,address,accountID,password ,fines,type)); 
				}
				else if(type.equals("L")) {
					users.add(new Librarian(id,firstName,lastName,birthdayYear,address,accountID,password ,fines,type)); 
				}
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<Checked_out_itm> loadCheckedOutItems() {
		ArrayList<Checked_out_itm> checkedOutItems = new ArrayList<Checked_out_itm>();
		
		try {
			FileReader reader = new FileReader(CHKITEM_FILE_NAME);
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray chkItemJSON = (JSONArray)jsonData.get("checkedoutitems");
			
			for(int i=0; i < chkItemJSON.size(); i++) {
				JSONObject ChkItemJSON = (JSONObject)chkItemJSON.get(i);
				int userid = (int)(long)ChkItemJSON.get("userid");
				int id = (int)(long)ChkItemJSON.get("id");
				String type = (String)ChkItemJSON.get("title");
				int renewal = (int)(long)ChkItemJSON.get("renewals");
				int daysremaining = (int)(long)ChkItemJSON.get("timeremaining");
				checkedOutItems.add(new Checked_out_itm(userid,type,id,renewal,daysremaining));
			}
				Checked_out_itm[] checkedOut; //= new Checked_out_itm[10];
				
				for(User user : users) 
					System.out.println(user.getName());
				
				for(User user : users) {
					
					System.out.println(user.getName());
					
					if(user.getType() == "T") {
						checkedOut = new Checked_out_itm[50];
					}
					else{
						checkedOut = new Checked_out_itm[10];
					}
					
					int j = 0;
					//System.out.println(checkedOutItems.size());
					for(Checked_out_itm chkItem : checkedOutItems) {
						System.out.println("\t"+user.getName());
						if(chkItem.getUserId() == user.getCardNumber()) {
							System.out.println("adding " + chkItem.getId() + " to " + user.getName());
							checkedOut[j] = chkItem;
							j++;
						}
					}
					System.out.println("done loop for " + user.getName());
					user.setItems(checkedOut);
				} 
			return checkedOutItems;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//remove this if it doesn't work. It is supposed to add the item to the checked out item. This is nessessacary for the return method
	
	public static void finish_Checked_out_itm_intsantiation(ArrayList<Checked_out_itm> checked_out_items, ArrayList<Item> stock) {
		for(int i=0;i < checked_out_items.size(); i++) {
			for(int c=0; c < stock.size(); c++) {
				if(checked_out_items.get(i).getId() == stock.get(c).getId()) {
					checked_out_items.get(i).setItem(stock.get(c));
				}
			}
		}
	}
	
	
}
