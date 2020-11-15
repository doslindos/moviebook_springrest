package moviebookservice.models.Authentication;

// Provides input argument for authentication requests
// defines structure for user sent in a request
// source https://github.com/koushikkothagal/spring-security-jwt/blob/master/src/main/java/io/javabrains/springsecurityjwt/models/AuthenticationRequest.java

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {


    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.print(username);
	this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }

    public AuthenticationRequest(String username, String password) {
        
	this.setUsername(username);
        this.setPassword(password);
    }
}
