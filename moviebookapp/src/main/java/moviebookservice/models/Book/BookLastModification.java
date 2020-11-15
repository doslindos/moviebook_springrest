package moviebookservice.models.Book;

// Used to store book database API calls last modification fields data

public class BookLastModification {

	private String type;
	private String value;

	public BookLastModification() {}

	public BookLastModification(String type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public String getType(){ return type; }

	public String getValue(){ return value; }

	public void setType(String type){ this.type = type; }

	public void setValue(String value){ this.value = value; }

}
