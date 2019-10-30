package library_system;

import java.util.ArrayList;

public class Item_DB {
	
	Item_DB db;
	
	private ArrayList<Book> books;
	private ArrayList<Audio_Book> audioBooks;
	private ArrayList<Magazine> magazines;
	private ArrayList<DVD> dvds;
	private ArrayList<eBook> eBooks;
	
	private Item_DB() {
		books = StockLoader.loadBooks();
		audioBooks = StockLoader.loadaudioBooks();
		magazines = StockLoader.loadMagazines();
		dvds = StockLoader.loadDVDs();
		eBooks = StockLoader.loadeBooks();
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
