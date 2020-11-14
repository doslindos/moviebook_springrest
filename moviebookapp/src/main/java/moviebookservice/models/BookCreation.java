package moviebookservice.models;

// Used to store book databases book creation data

public class BookCreation {

	private String type;
	private String value;

	public BookCreation() {}

	public BookCreation(String type, String value) {
		this.type = type;
		this.value = value;
	}

	public String getType(){ return type; }

	public String getValue(){ return value; }

	public void setType(String type){ this.type = type; }

	public void setValue(String value){ this.value = value; }

}
