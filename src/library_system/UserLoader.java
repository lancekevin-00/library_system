package library_system;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;
public class UserLoader {
	private static final String USER_FILE_NAME = "users.json";
	private static final String CHKITEM_FILE_NAME = "checkedoutitems.json";
	public static ArrayList<User> loadUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray userJSON = (JSONArray)jsonData.get("users");
			
			for(int i=0; i < userJSON.size(); i++) {
				JSONObject UserJSON = (JSONObject)userJSON.get(i);
				int id = (int)(long)UserJSON.get("id");
				String firstName = (String)UserJSON.get("firstName"); 
				String lastName = (String)UserJSON.get("lastName");
				int birthdayYear = (int)(long)UserJSON.get("birthdayYear"); // Need to add this to the json file 
				String address = (String)UserJSON.get("address");
			//	String email = (String)UserJSON.get("email"); //add this and phone to constructors
			//	String phone = (String)UserJSON.get("phone"); //Have it as a string right now but idk if you want to make it an integer or not
				int accountID = (int)(long)UserJSON.get("accountId");
				String password = (String)UserJSON.get("password");
				String type = (String)UserJSON.get("type");
				int fines = (int)(long)UserJSON.get("fines");
				if(type.equals("A")) {
					users.add(new Adult(id,firstName,lastName,birthdayYear,address,accountID,password ,fines)); 
				}
				else if(type.equals("C")) {
					//users.add(new Child(id,firstName,lastName,birthdayYear,address,accountID,password ,fines)); 
				}
				else if(type.equals("T")) { 
					users.add(new Teacher(id,firstName,lastName,birthdayYear,address,accountID,password ,fines)); 
				}
				else if(type.equals("L")) {
					users.add(new Librarian(id,firstName,lastName,birthdayYear,address,accountID,password ,fines)); 
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
				String type = (String)ChkItemJSON.get("type");
				int renewal = (int)(long)ChkItemJSON.get("renewals");
				int daysremaining = (int)(long)ChkItemJSON.get("timeremaining");
				checkedOutItems.add(new Checked_out_itm(userid,type,id,renewal,daysremaining));
			}
			return checkedOutItems;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
