package library_system;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;
public class UserLoader {
	private static final String BOOK_FILE_NAME = "users.json";
	
	public static ArrayList<User> loadUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader("src/users.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray userJSON = (JSONArray)jsonData.get("users");
			
			for(int i=0; i < userJSON.size(); i++) {
				JSONObject UserJSON = (JSONObject)userJSON.get(i);
				int id = (int)UserJSON.get("id");
				String firstName = (String)UserJSON.get("firstName"); 
				String lastName = (String)UserJSON.get("lastName");
				int birthdayYear = (int)UserJSON.get("birthdayYear");
				String address = (String)UserJSON.get("address");
				String email = (String)UserJSON.get("email");
				String phone = (String)UserJSON.get("phone"); //Have it as a string right now but idk if you want to make it an integer or not
				int accountID = (int)UserJSON.get("accountID");
				String password = (String)UserJSON.get("password");
				String type = (String)UserJSON.get("type");
				double fines = (double)UserJSON.get("fines");
				
				users.add(new User(id,firstName,lastName,birthdayYear,address,accountID,password ,type,fines));
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
