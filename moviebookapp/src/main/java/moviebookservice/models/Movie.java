package moviebookservice.models;

import java.util.List;

// Movie object to fill with Movie Database data

public class Movie {

	private String Title;
	private String Year;
	private String Rated;
	private String Released;
	private String Runtime;
	private String Genre;
	private String Director;
	private String Writer;
	private String Actors;
	private String Plot;
	private String Language;
	private String Country;
	private String Awards;
	private String Poster;
	private List Ratings;
	private String Metascore;
	private String ImdbRating;
	private String ImdbVotes;
	private String ImdbID;
	private String Type;
	private String totalSeasons;
	private String Response;
	
	public Movie(){}

	public Movie(
		String Title,
		String Year,
		String Rated,
		String Released,
		String Runtime,
		String Genre,
		String Director,
		String Writer,
		String Actors,
		String Plot,
		String Language,
		String Country,
		String Awards,
		String Poster,
		List Ratings,
		String Metascore,
		String ImdbRating,
		String ImdbVotes,
		String imdbID,
		String Type,
		String totalSeasons,
		String Response
		){

		this.Title = Title;
		this.Year = Year;
		this. Rated = Rated;
		this.Released = Released;
		this.Runtime = Runtime;
		this.Genre = Genre;
		this.Director = Director;
		this.Writer = Writer;
		this.Actors = Actors;
		this.Plot = Plot;
		this.Language = Language;
		this.Country = Country;
		this.Awards = Awards;
		this.Poster = Poster;
		this.Ratings = Ratings;
		this.Metascore = Metascore;
		this.ImdbRating = ImdbRating;
		this.ImdbVotes = ImdbVotes;
		this.ImdbID = imdbID;
		this.Type = Type;
		this.totalSeasons = totalSeasons;
		this.Response = Response;
	}

	// Getters
	public String getTitle(){ return Title; };
	public String getYear(){ return Year; };
	public String getRated(){ return Rated; };
	public String getReleased(){ return Released; };
	public String getRuntime(){ return Runtime; };
	public String getGenre(){ return Genre; };
	public String getDirrector(){ return Director; };
	public String getWriter(){ return Writer; };
	public String getActors(){ return Actors; };
	public String getPlot(){ return Plot; };
	public String getLanguage(){ return Language; };
	public String getCountry(){ return Country; };
	public String getAwards(){ return Awards; };
	public String getPoster(){ return Poster; };
	public List getRatings(){ return Ratings; };
	public String getMetascore(){ return Metascore; };
	public String getImdbRating(){ return ImdbRating; };
	public String getImdbVotes(){ return ImdbVotes; };
	public String getimdbID(){ return ImdbID; };
	public String getType(){ return Type; };
	public String gettotalSeasons(){ return totalSeasons;};
	public String getResponse(){ return Response; };

	//Setters
	public void setTitle(String Title){this.Title = Title;};
	public void setYear(String Year){this.Year = Year;};
	public void setRated(String Rated){this.Rated = Rated;};
	public void setReleased(String Released){this.Released = Released;};
	public void setRuntime(String Runtime){this.Runtime = Runtime;};
	public void setGenre(String Genre){this.Genre = Genre;};
	public void setDirector(String Director){this.Director = Director;};
	public void setWriter(String Writer){this.Writer = Writer;};
	public void setActors(String Actors){this.Actors = Actors;};
	public void setPlot(String Plot){this.Plot = Plot;};
	public void setLanguage(String Language){this.Language = Language; };
	public void setCountry(String Country){this.Country = Country; };
	public void setAwards(String Awards){this.Awards = Awards; };
	public void setPoster(String Poster){this.Poster = Poster;};
	public void setRatings(List Ratings){this.Ratings = Ratings;};
	public void setMetascore(String Metascore){this.Metascore = Metascore;};
	public void setImdbRating(String ImdbRating){this.ImdbRating = ImdbRating; };
	public void setImdbVotes(String ImdbVotes){this.ImdbVotes = ImdbVotes; };
	public void setImdbID(String ImdbID){this.ImdbID = ImdbID;};
	public void setType(String Type){this.Type = Type; };
	public void settotalSeasons(String totalSeasons){this.totalSeasons = totalSeasons; };

}
