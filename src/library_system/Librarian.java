package library_system;
import java.io.*;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Librarian extends User{
	 JSONObject obj = new JSONObject();
	Librarian(int id,String firstName,String lastName,int birthdayYear,String address, int accountID,String password ,double fines) {
		super.Name = firstName+" "+lastName;
		super.cardNumber = id;
		super.password = password;
		super.Age = birthdayYear;
		super.Fees = fines;
		super.Address = address;
		super.items = new Checked_out_itm[10];
		is_librarian = true;
	}
	
	@Override
	protected void addNewBook(int id,String title, int year, String genre, String publisher, String author, int numCopies, boolean newArrival) {
		
		try (FileWriter file = new FileWriter("books.json",true)) {	
			//JSONArray bookJSON = (JSONArray)jsonData.get("books")
			//JSONObject list1 = new JSONObject();
			obj.put("id", id);
			obj.put("title", title);
			obj.put("year", year);
			obj.put("genre",genre);
			obj.put("publisher",publisher);
			obj.put("author",author);
			obj.put("numCopies", numCopies);
			obj.put("newArrival", newArrival);
			
			file.write(obj.toJSONString());

	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void addNewDVD(int id,String title,int year,String genre,String director,String[] actors,int numCopies,boolean newArrival) {
		try (FileWriter file = new FileWriter("dvds.json",true)) {	
			obj.put("id", id);
			obj.put("title", title);
			obj.put("year", year);
			obj.put("genre",genre);
			obj.put("director",director);
			obj.put("actors",actors);
			obj.put("numCopies", numCopies);
			obj.put("newArrival", newArrival);
			
			file.write(obj.toJSONString());

	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void addNewMagazine(int id,String title,int year,String genre,String publisher,int volume, int issue,int numCopies,boolean newArrival) {
		try (FileWriter file = new FileWriter("magazines.json",true)) {	
			obj.put("id", id);
			obj.put("title", title);
			obj.put("year", year);
			obj.put("genre",genre);
			obj.put("publisher",publisher);
			obj.put("volume",volume);
			obj.put("issue",issue);
			obj.put("numCopies", numCopies);
			obj.put("newArrival", newArrival);
			
			file.write(obj.toJSONString());

	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void addNeweBook(int id,String title,int year,String genre,String publisher,String author,int numCopies,boolean newArrival) {
		try (FileWriter file = new FileWriter("ebooks.json",true)) {	
			//JSONArray bookJSON = (JSONArray)jsonData.get("books")
			//JSONObject list1 = new JSONObject();
			obj.put("id", id);
			obj.put("title", title);
			obj.put("year", year);
			obj.put("genre",genre);
			obj.put("publisher",publisher);
			obj.put("author",author);
			obj.put("numCopies", numCopies);
			obj.put("newArrival", newArrival);
			
			file.write(obj.toJSONString());

	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void addNewAudio_Book(int id,String title,int year,String genre,String publisher,String author,int numCopies,boolean newArrival) {
		try (FileWriter file = new FileWriter("audiobooks.json",true)) {	
			obj.put("id", id);
			obj.put("title", title);
			obj.put("year", year);
			obj.put("genre",genre);
			obj.put("publisher",publisher);
			obj.put("author",author);
			obj.put("numCopies", numCopies);
			obj.put("newArrival", newArrival);
			
			file.write(obj.toJSONString());

	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	

	
}
	
