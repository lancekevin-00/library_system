import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class StockLoader {
private static final String BOOK_FILE_NAME = "books.json";
private static final String DVD_FILE_NAME = "dvds.json";
private static final String MAGAZINE_FILE_NAME = "magazines.json";
private static final String EBOOK_FILE_NAME = "ebooks.json";
private static final String AUDIOBOOK_FILE_NAME = "audiobooks.json";
	
	public static ArrayList<Stock> loadBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
			FileReader reader = new FileReader("src/books.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray bookJSON = (JSONArray)jsonData.get("books");
			
			for(int i=0; i < bookJSON.size(); i++) {
				JSONObject BookJSON = (JSONObject)bookJSON.get(i);
				int id = (int)BookJSON.get("id");
				String title = (String)BookJSON.get("title");
				int year = (int)BookJSON.get("year");
				String genre = (String)BookJSON.get("genre");
				String publisher = (String)BookJSON.get("publisher");
				String author = (String)BookJSON.get("author");
				int numCopies = (int)BookJSON.get("numCopies");
				boolean newArrival = (boolean)BookJSON.get("newArrival");
				
				books.add(new Book(id,title,year,genre,publisher,author,numCopies,newArrival));
			}
			
			return books;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static ArrayList<Stock> loadDVDs() {
		ArrayList<DVD> dvds = new ArrayList<DVD>();
		
		try {
			FileReader reader = new FileReader("src/dvds.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray dvdJSON = (JSONArray)jsonData.get("dvds");
			
			for(int i=0; i < dvdJSON.size(); i++) {
				JSONObject DVDJSON = (JSONObject)dvdJSON.get(i);
				int id = (int)DVDJSON.get("id");
				String title = (String)DVDJSON.get("title");
				int year = (int)DVDJSON.get("year");
				String genre = (String)DVDJSON.get("genre");
				String director = (String)DVDJSON.get("director");
				String actors = (String)DVDJSON.get("actors");
				int numCopies = (int)DVDJSON.get("numCopies");
				boolean newArrival = (boolean)DVDJSON.get("newArrival");
				
				dvds.add(new DVD(id,title,year,genre,director,actors,numCopies,newArrival));
			}
			
			return dvds;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<Stock> loadMagazines() {
		ArrayList<Magazine> magazines = new ArrayList<Magazine>();
		
		try {
			FileReader reader = new FileReader("src/magazines.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray magazineJSON = (JSONArray)jsonData.get("magazines");
			
			for(int i=0; i < magazineJSON.size(); i++) {
				JSONObject MagazineJSON = (JSONObject)magazineJSON.get(i);
				int id = (int)MagazineJSON.get("id");
				String title = (String)MagazineJSON.get("title");
				int year = (int)MagazineJSON.get("year");
				String genre = (String)MagazineJSON.get("genre");
				String publisher = (String)MagazineJSON.get("publisher");
				String volume = (String)MagazineJSON.get("volume");
				String issue = (String)MagazineJSON.get("issue");
				int numCopies = (int)MagazineJSON.get("numCopies");
				boolean newArrival = (boolean)MagazineJSON.get("newArrival");
				
				magazines.add(new Magazine(id,title,year,genre,publisher,issue,numCopies,newArrival));
			}
			
			return magazines;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static ArrayList<Stock> loadeBooks() {
		ArrayList<eBook> eBooks = new ArrayList<eBook>();
		
		try {
			FileReader reader = new FileReader("src/eBooks.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray ebookJSON = (JSONArray)jsonData.get("eBooks");
			
			for(int i=0; i < ebookJSON.size(); i++) {
				JSONObject eBookJSON = (JSONObject)ebookJSON.get(i);
				int id = (int)eBookJSON.get("id");
				String title = (String)eBookJSON.get("title");
				int year = (int)eBookJSON.get("year");
				String genre = (String)eBookJSON.get("genre");
				String publisher = (String)eBookJSON.get("publisher");
				String author = (String)eBookJSON.get("author");
				int numCopies = (int)eBookJSON.get("numCopies");
				boolean newArrival = (boolean)eBookJSON.get("newArrival");
				
				eeBooks.add(new eBook(id,title,year,genre,publisher,author,numCopies,newArrival));
			}
			
			return ebooks;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<Stock> loadaudioBooks() {
		ArrayList<audioBook> audiobooks = new ArrayList<audioBook>();
		
		try {
			FileReader reader = new FileReader("src/audiobooks.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray audiobookJSON = (JSONArray)jsonData.get("audiobooks");
			
			for(int i=0; i < audiobookJSON.size(); i++) {
				JSONObject audioBookJSON = (JSONObject)audiobookJSON.get(i);
				int id = (int)audioBookJSON.get("id");
				String title = (String)audioBookJSON.get("title");
				int year = (int)audioBookJSON.get("year");
				String genre = (String)audioBookJSON.get("genre");
				String publisher = (String)audioBookJSON.get("publisher");
				String author = (String)audioBookJSON.get("author");
				int numCopies = (int)audioBookJSON.get("numCopies");
				boolean newArrival = (boolean)audioBookJSON.get("newArrival");
				
				audiobooks.add(new audioBook(id,title,year,genre,publisher,author,numCopies,newArrival));
			}
			
			return audiobooks;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
