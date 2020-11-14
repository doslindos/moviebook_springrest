package moviebookservice.models;

// Used to store book database API calls type fiels data

public class BookType {

	private String key;

	public BookType() {}

	public BookType(String key) {
		this.key = key;
	}

	public String getKey(){ return key; }

	public void setKey(String key){ this.key = key; }


}
