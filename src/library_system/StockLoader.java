package library_system;
/**
 * UserLoader class
 * @author riley and lance
 * Imports for all of the json files
 */
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;
public class StockLoader {
	/**
	 * File names and  item arrayLists
	 */
private static final String BOOK_FILE_NAME = "books.json";
private static final String DVD_FILE_NAME = "dvds.json";
private static final String MAGAZINE_FILE_NAME = "magazines.json";
private static final String EBOOK_FILE_NAME = "ebooks.json";
private static final String AUDIOBOOK_FILE_NAME = "audiobooks.json";
private static ArrayList<Item> stock;

private static ArrayList<Book> books;
private static ArrayList<DVD> dvds;
private static ArrayList<Magazine> magazines;
private static ArrayList<eBook> ebooks;
private static ArrayList<Audio_Book> audiobooks;
/**
 * Loads all of the item arraylist into the stock arraylist
 * @return The stock arraylist
 */
	private static ArrayList<Item> getStock(){
		stock = new ArrayList<Item>();
		loadBooks();
		loadDVDs();
		loadeBooks();
		loadMagazines();
		loadaudioBooks();
		
		return stock;
	}
	/**
	 * Loads the database
	 * @return The stock arraylist
	 */
	public static ArrayList<Item> loadDB(){
		if(stock == null) {
			stock = getStock();
		}
		return stock;
	}
	/**
	 * Loads the books by parsing through the book json file
	 * @return the book arraylist
	 */
	private static ArrayList<Book> loadBooks() {
		books = new ArrayList<Book>();
		
		try {
			FileReader reader = new FileReader(BOOK_FILE_NAME);
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray bookJSON = (JSONArray)jsonData.get("books");
			
			for(int i=0; i < bookJSON.size(); i++) {
				JSONObject BookJSON = (JSONObject)bookJSON.get(i);
				int id = (int)(long)BookJSON.get("id");
				String title = (String)BookJSON.get("title");
				int year = (int)(long)BookJSON.get("year");
				String genre = (String)BookJSON.get("genre");
				String publisher = (String)BookJSON.get("publisher");
				String author = (String)BookJSON.get("author");
				int numCopies = (int)(long)BookJSON.get("numCopies");
				boolean newArrival = (boolean)BookJSON.get("newArrival");
				
				books.add(new Book(id,title,year,genre,publisher,author,numCopies,newArrival));
				stock.addAll(books);
			}
			
			return books;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * Loads the dvds by parsing through the dvd json file
	 * @return the dvd arraylist
	 */
	private static ArrayList<DVD> loadDVDs() {
		dvds = new ArrayList<DVD>();
		
		try {
			FileReader reader = new FileReader(DVD_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray dvdJSON = (JSONArray)jsonData.get("dvds");
			for(int i=0; i < dvdJSON.size(); i++) {
				JSONObject DVDJSON = (JSONObject)dvdJSON.get(i);
				int id = (int)(long)DVDJSON.get("id");
				String title = (String)DVDJSON.get("title");
				int year = (int)(long)DVDJSON.get("year");
				String genre = (String)DVDJSON.get("genre");
				String director = (String)DVDJSON.get("director");			
				String actors = (String)DVDJSON.get("actors");
				int numCopies = (int)(long)DVDJSON.get("numCopies");
				boolean newArrival = (boolean)DVDJSON.get("newArrival");
				
				dvds.add(new DVD(id,title,year,genre,director,actors,numCopies,newArrival));
				stock.addAll(dvds);
			}
			
			return dvds;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * Loads the magazines by parsing through the magazines json file
	 * @return the magazine arraylist
	 */
	private static ArrayList<Magazine> loadMagazines() {
		magazines = new ArrayList<Magazine>();
		
		try {
			FileReader reader = new FileReader(MAGAZINE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray magazineJSON = (JSONArray)jsonData.get("magazines");
			
			for(int i=0; i < magazineJSON.size(); i++) {
				JSONObject MagazineJSON = (JSONObject)magazineJSON.get(i);
				int id = (int)(long)MagazineJSON.get("id");
				String title = (String)MagazineJSON.get("title");
				int year = (int)(long)MagazineJSON.get("year");
				String genre = (String)MagazineJSON.get("genre");
				String publisher = (String)MagazineJSON.get("publisher");
				int volume = (int)(long)MagazineJSON.get("volume");
				int issue = (int)(long)MagazineJSON.get("issue");
				int numCopies = (int)(long)MagazineJSON.get("numCopies");
				boolean newArrival = (boolean)MagazineJSON.get("newArrival");
				
				magazines.add(new Magazine(id,title,year,genre,publisher,volume, issue,numCopies,newArrival));
				stock.addAll(magazines);
			}
			
			return magazines;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * Loads the ebooks by parsing through the ebook json file
	 * @return the ebook arraylist
	 */
	private static ArrayList<eBook> loadeBooks() {
		ebooks = new ArrayList<eBook>();
		
		try {
			FileReader reader = new FileReader(EBOOK_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray ebookJSON = (JSONArray)jsonData.get("ebooks");
			
			for(int i=0; i < ebookJSON.size(); i++) { //Null pointer at this line 
				JSONObject eBookJSON = (JSONObject)ebookJSON.get(i);
				int id = (int)(long)eBookJSON.get("id");
				String title = (String)eBookJSON.get("title");
				int year = (int)(long)eBookJSON.get("year");
				String genre = (String)eBookJSON.get("genre");
				String publisher = (String)eBookJSON.get("publisher");
				String author = (String)eBookJSON.get("author");
				int numCopies = (int)(long)eBookJSON.get("numCopies");
				boolean newArrival = (boolean)eBookJSON.get("newArrival");
				
				ebooks.add(new eBook(id,title,year,genre,publisher,author,numCopies,newArrival));		
			}
			stock.addAll(ebooks);
			return ebooks;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * Loads the audiobooks by parsing through the audiobook json file
	 * @return the audiobook arraylist
	 */
	private static ArrayList<Audio_Book> loadaudioBooks() {
		audiobooks = new ArrayList<Audio_Book>();
		
		try {
			FileReader reader = new FileReader(AUDIOBOOK_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray audiobookJSON = (JSONArray)jsonData.get("audiobooks");
			
			for(int i=0; i < audiobookJSON.size(); i++) {
				JSONObject audioBookJSON = (JSONObject)audiobookJSON.get(i);
				int id = (int)(long)audioBookJSON.get("id");
				String title = (String)audioBookJSON.get("title");
				int year = (int)(long)audioBookJSON.get("year");
				String genre = (String)audioBookJSON.get("genre");
				String publisher = (String)audioBookJSON.get("publisher");
				String author = (String)audioBookJSON.get("author");
				int numCopies = (int)(long)audioBookJSON.get("numCopies");
				boolean newArrival = (boolean)audioBookJSON.get("newArrival");
				
				audiobooks.add(new Audio_Book(id,title,year,genre,publisher,author,numCopies,newArrival));		
			}
			stock.addAll(audiobooks);
			return audiobooks;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	//Getters for the item arraylists
	public static ArrayList<Book> getBooks() {
		return books;
	}

	public static ArrayList<DVD> getDvds() {
		return dvds;
	}

	public static ArrayList<Magazine> getMagazines() {
		return magazines;
	}

	public static ArrayList<eBook> getEbooks() {
		return ebooks;
	}

	public static ArrayList<Audio_Book> getAudiobooks() {
		return audiobooks;
	}
	
	
}
