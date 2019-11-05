package library_system;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;
public class UserLoader {
	private static final String USER_FILE_NAME = "users.json";
	
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
				String email = (String)UserJSON.get("email"); //add this and phone to constructors
				String phone = (String)UserJSON.get("phone"); //Have it as a string right now but idk if you want to make it an integer or not
				int accountID = (int)(long)UserJSON.get("accountId");
				String password = (String)UserJSON.get("password");
				String type = (String)UserJSON.get("type");
				Number val = (Number)UserJSON.get("value");//Temporary until i figure out how to get rid of the error
				double fines = val.doubleValue();
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
	
	
}
