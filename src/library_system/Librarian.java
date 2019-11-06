package library_system;
import java.io.FileWriter;
import java.util.ArrayList;
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
	protected void addNewBook(ArrayList<Book> books) {
		
		try (FileWriter file = new FileWriter("books.json")) {	
			file.write("{\"books\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <books.size(); i++) {
		    	  list.add(books.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");

	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void addNewDVD(ArrayList<DVD> dvd) {
		try (FileWriter file = new FileWriter("dvds.json")) {	
			file.write("{\"dvds\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <dvd.size(); i++) {
		    	  list.add(dvd.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");
	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void addNewMagazine(ArrayList<Magazine> magazines) {
		try (FileWriter file = new FileWriter("magazines.json")) {	
			file.write("{\"magazines\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <magazines.size(); i++) {
		    	  list.add(magazines.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");
	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void addNeweBook(ArrayList<eBook> ebook) {
		try (FileWriter file = new FileWriter("ebooks.json")) {	
			file.write("{\"ebooks\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <ebook.size(); i++) {
		    	  list.add(ebook.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");
	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void addNewAudio_Book(ArrayList<Audio_Book> audiobook) {
		try (FileWriter file = new FileWriter("audiobooks.json")) {	
			file.write("{\"audiobooks\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <audiobook.size(); i++) {
		    	  list.add(audiobook.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");
	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	

	
}
	
