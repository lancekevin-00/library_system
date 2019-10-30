package library_system;

import java.util.ArrayList;

public class Item_DB {
	
	Item_DB db;
	public ArrayList<Item> items;
	public ArrayList<Book> books;
	public ArrayList<Audio_Book> audioBooks;
	public ArrayList<Magazine> magazines;
	public ArrayList<DVD> dvds;
	public ArrayList<eBook> eBooks;
	
	public Item_DB() {
		books = StockLoader.loadBooks();
		audioBooks = StockLoader.loadaudioBooks();
		magazines = StockLoader.loadMagazines();
		dvds = StockLoader.loadDVDs();
		eBooks = StockLoader.loadeBooks();
		
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public Item_DB getInstance() {
		if (db == null)
			db = new Item_DB();
		return db;
	}
	
	public void update_day() {
		System.out.println("updating day");
		System.out.println("this method does nothing currently");
	}
	
}
