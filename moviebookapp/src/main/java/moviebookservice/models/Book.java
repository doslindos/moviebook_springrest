package moviebookservice.models;

// Book java object to be filled with data from external Book Database

public class Book {

	private String bib_key;
	private String info_url;
	private String preview;
	private String preview_url;
	private String thumbnail_url;

	private BookDetail details;

	public Book() {}

	public Book(String bib_key, String info_url, String preview, String preview_url, String thumbnail_url, BookDetail details) {
		this.bib_key = bib_key;
		this.info_url = info_url;
		this.preview = preview;
		this.preview_url = preview_url;
		this.thumbnail_url = thumbnail_url;
		this.details = details;
	}

	public String getBibKey() {
		return bib_key;
	}

	public String getInfoURL() {
		return info_url;
	}
	public String getPreview() {
		return preview;
	}
	public String getPreviewURL() {
		return preview_url;
	}
	public String getThumbnailURL() {
		return thumbnail_url;
	}
	public BookDetail getBookDetails(){
		return details;
	}

	public void setBibKey(String bib_key){
		this.bib_key = bib_key;
	}
	public void setInfoURL(String info_url){
		this.info_url = info_url;
	}
	public void setPreview(String preview){
		this.preview = preview;
	}
	public void setPreviewURL(String preview_url){
		this.preview_url = preview_url;
	}
	public void setThumbnailURL(String thumbnail_url){
		this.thumbnail_url = thumbnail_url;
	}
	public void setBookDetails(BookDetail details){
		this.details = details;
	}

	@Override
	public String toString(){
		return "Book {"+
			"bib_key='"+ bib_key + '\'' +
			", info_url='"+ info_url + '\'' +
			", preview='"+ preview + '\'' +
			", preview_url='"+ preview_url + '\'' +
			", thumbnail_url='"+ thumbnail_url + '\'' +
			", details='"+ details + '\'' +
			"}";
	}
}
