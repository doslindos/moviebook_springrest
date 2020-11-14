package moviebookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;

// Create a SpringApplication
@SpringBootApplication
public class MovieBookApplication {
	
	// Initialize rest template bean to be used from controller
	@Bean
	public RestTemplate getTemplate(){ return new RestTemplate();}

	// Initialize rest template bean to be used from controller
	@Bean
	public Gson getGson(){ return new Gson();}
	
	// Main function
	public static void main(String[] args) {
		// Run SpringApplication
		SpringApplication.run(MovieBookApplication.class, args);
	}

}
