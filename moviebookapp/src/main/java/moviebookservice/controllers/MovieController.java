package moviebookservice.controllers;

import moviebookservice.models.Movie.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

// Build a SpringFramework RestController
// and use RequestMapping to map root call to MovieController
@RestController
@RequestMapping("/getMovie")
public class MovieController {
	
	// Fetch and define Api key defined in resources/application.settings
	@Value("${api.key}")
	private String apiKey;
	
	// Fetch and define the rest template created in MovieServiceApplication
	@Autowired
	private RestTemplate restTemplate;

	// Fetch initialized Gson object from MovieServiceApplication
	@Autowired
	private Gson gson;

	// Map /title call with title parameter to getMovieInfo
	@RequestMapping("/title/{title}")
	public Movie getMovieInfo(@PathVariable("title") String title) {
		// Use RestTemplate to fetch a String containing Json from Movie Database
		String jsonString = restTemplate.getForObject(
				"https://www.omdbapi.com/?apikey=" + apiKey + "&t="+title,
			       String.class
				);
		
		// Use Gson to form a Gson.JsonObject from the String containing json
		JsonObject gsonJson = gson.fromJson(jsonString, JsonObject.class);
		
		// Convert Gson.JsonObject to a Movie Java object
		Movie movie = gson.fromJson(gsonJson, Movie.class);
		
		// Return Movie java object as response
		return movie;
	}	
}
