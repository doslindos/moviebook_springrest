package moviebookservice.models;

import java.util.List;

// Used to store book database API calls detail fields data

public class BookDetail {

	private List<String> publishers;
	private int number_of_pages;
	private String subtitle;
	private List<Integer> covers;
	private List<String> local_id;
	private List<String> lc_classifications;
	private int latest_revision;
	private String key;
	private List authors;
	private String ocaid;
	private List publish_places;
	private List<String> contributions;
	private List<String> subjects;
	private List languages;
	private String pagination;
	private List<String> source_records;
	private String title;
	private List dewey_decimal_class;
	private BookNote notes;
	private BookIdentifier identifiers;
	private BookCreation created;
	private String edition_name;
	private List iccn;
	private List isbn_10;
	private String publish_date;
	private String publish_country;
	private BookLastModification last_modified;
	private List works;
	private BookType type;


	public BookDetail() {}

	public BookDetail(
		 List publishers,
		 int number_of_pages,
		 String subtitle,
		 List covers,
		 List local_id,
		 List lc_classifications,
		 int latest_revision,
		 String key,
		 List authors,
		 String ocaid,
		 List publish_places,
		 List contributions,
		 List subjects,
		 List languages,
		 String pagination,
		 List source_records,
		 String title,
		 List dewey_decimal_class,
		 BookNote notes,
		 BookIdentifier identifiers,
		 BookCreation created,
		 String edition_name,
		 List iccn,
		 List isbn_10,
		 String publish_date,
		 String publish_country,
		 BookLastModification last_modified,
		 List works,
		 BookType type
			) {
		 this.publishers = publishers;
		 this.number_of_pages = number_of_pages;
		 this.subtitle = subtitle;
		 this.covers = covers;
		 this.local_id = local_id;
		 this.lc_classifications = lc_classifications;
		 this.latest_revision = latest_revision;
		 this.key = key;
		 this.authors = authors;
		 this.ocaid = ocaid;
		 this.publish_places = publish_places;
		 this.contributions = contributions;
		 this.subjects = subjects;
		 this.languages = languages;
		 this.pagination = pagination;
		 this.source_records = source_records;
		 this.title = title;
		 this.dewey_decimal_class = dewey_decimal_class;
		 this.notes = notes;
		 this.identifiers = identifiers;
		 this.created = created;
		 this.edition_name = edition_name;
		 this.iccn = iccn;
		 this.isbn_10 = isbn_10;
		 this.publish_date = publish_date;
		 this.publish_country = publish_country;
		 this.last_modified = last_modified;
		 this.works = works;
		 this.type = type;
	}

		 
	public List getPublishers(){ return publishers; }
	public int getNumberOfPages(){ return number_of_pages; }
	public String getSubtitle(){ return subtitle; }
	public List getCover(){ return covers; }
	public List getLovalID(){ return local_id; }
	public List getIcClassification() { return lc_classifications; }
	public int getLatestRevision(){ return latest_revision; }
	public String getKey(){ return key; }
	public List getAuthors(){ return  authors; }
	public String getOcAid() { return ocaid; }
	public List getPublishPlaces(){ return publish_places; }
	public List getContributions(){ return contributions; }
	public List getSubjects(){ return subjects; }
	public List getLanguages(){ return languages; }
	public String getPagination(){ return pagination; }
	public List getSourceRecords(){ return source_records; }
	public String getTitle(){ return title; }
	public List getDeweyDecimalClass(){ return  dewey_decimal_class; }
	public BookNote getNotes(){ return notes; }
	public BookIdentifier getIdentifiers(){ return identifiers; }
	public BookCreation getCreation(){ return created; }
	public String getEditionName(){ return edition_name; }
	public List getIccn(){ return iccn; }
	public List getISBN10(){ return isbn_10; }
	public String getPublishDate(){ return publish_date; }
	public String getPublishCountry(){ return publish_country;}
	public BookLastModification getLastModified(){ return last_modified; }
	public List getWorks(){ return works; }
	public BookType getType(){ return type; }

	public void setPublishers(List publishers){ this.publishers = publishers; }
	public void setNumberOfPages(int number_of_pages){ this.number_of_pages = number_of_pages; }
	public void setSubtitle(String subtitle){ this.subtitle = subtitle; }
	public void setCover(List covers){ this.covers = covers; }
	public void setLovalID(List local_id){ this.local_id =  local_id; }
	public void setIcClassification(List lc_classifications) { this.lc_classifications = lc_classifications; }
	public void setLatestRevision(int latest_revision){ this.latest_revision = latest_revision; }
	public void setKey(String key){ this.key = key; }
	public void setAuthors(List authors){ this.authors = authors; }
	public void setOcAid(String ocaid) { this.ocaid = ocaid; }
	public void setPublishPlaces(List publish_places){ this.publish_places = publish_places; }
	public void setContributions(List contributions){ this.contributions = contributions; }
	public void setSubjects(List subjects){ this.subjects = subjects; }
	public void setLanguages(List languages){ this.languages = languages; }
	public void setPagination(String pagination){ this.pagination = pagination; }
	public void setSourceRecords(List source_records){ this.source_records = source_records; }
	public void setTitle(String title){ this.title = title; }
	public void setDeweyDecimalClass(List dewey_decimal_class){ this.dewey_decimal_class = dewey_decimal_class; }
	public void setNotes(BookNote notes){ this.notes = notes; }
	public void setIdentifiers(BookIdentifier identifiers){ this.identifiers = identifiers; }
	public void setCreation(BookCreation created){ this.created = created; }
	public void setEditionName(String edition_name){ this.edition_name = edition_name; }
	public void setIccn(List iccn){ this.iccn = iccn; }
	public void setISBN10(List isbn_10){ this.isbn_10 = isbn_10; }
	public void setPublishDate(String publish_date){ this.publish_date = publish_date; }
	public void setPublishCountry(String publish_country){ this.publish_country = publish_country;}
	public void setLastModified(BookLastModification last_modified){ this.last_modified = last_modified; }
	public void setWorks(List works){ this.works = works; }
	public void setType(BookType type){ this.type = type; }
	

}
