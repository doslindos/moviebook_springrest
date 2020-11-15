package moviebookservice.models.Book;

import java.util.List;

// Used to store book database API calls identifier fields data

public class BookIdentifier {

	private List goodreads;
	private List wikidata;
	private List librarything;

	public BookIdentifier() {}

	public BookIdentifier(List goodreads, List wikidata, List librarything) {
		this.goodreads = goodreads;
		this.wikidata = wikidata;
		this.librarything = librarything;
	}
	
	public List getGoodreads(){ return goodreads; }
	public List getWikidata(){ return wikidata; }
	public List getLibrarything(){ return librarything; }
	
	public void setGoodreads(List goodreads){ this.goodreads = goodreads; }
	public void setWikidata(List wikidata){ this.wikidata = wikidata; }
	public void setLibrarything(List librarything){ this.librarything = librarything; }

}
