package moviebookservice.models;

// Used to store book database API calls note fields data

public class BookNote {

	private String type;
	private String value;

	public BookNote() {}

	public BookNote(String type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public String getType(){ return type; }

	public String getValue(){ return value; }

	public void setType(String type){ this.type = type; }

	public void setValue(String value){ this.value = value; }

}
