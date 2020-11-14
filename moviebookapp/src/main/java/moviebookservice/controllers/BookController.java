package moviebookservice.controllers;

import moviebookservice.models.Book;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

// Create a SpringFramework RestController
// and map all calls to this controller
@RestController
@RequestMapping("/getBook")
public class BookController {
	
	// Fetch and define RestTemplate initialized in application file
	@Autowired
	private RestTemplate restTemplate;
	
	// Fetch and define Gson initialized in application file
	@Autowired
	private Gson gson;
	
	// Map /getBook call to this function with book_id as parameter
	@RequestMapping("/ISBN/{book_id}")
	public Book getBookInfo(@PathVariable("book_id") String bookID) {
		// Use restTemplate to get String containing Json data from openlibrary db
		String jsonString = restTemplate.getForObject(
				"http://openlibrary.org/api/books?bibkeys=ISBN:"+bookID+"&jscmd=details&format=json",
			       String.class
				);
		
		// Build a Gson.JsonObject from the String with Json data
		JsonObject gsonJson = gson.fromJson(jsonString, JsonObject.class);
		
		// Fill a Book java object with the data from Gson.JsonObject
		Book bookjson = gson.fromJson(gsonJson.get("ISBN:"+bookID), Book.class);
		
		// Return the book object as response
		return bookjson;
	}
}
