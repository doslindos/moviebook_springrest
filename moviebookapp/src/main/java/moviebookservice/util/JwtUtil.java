package moviebookservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// Source https://github.com/koushikkothagal/spring-security-jwt/blob/master/src/main/java/io/javabrains/springsecurityjwt/util/JwtUtil.java

@Service
public class JwtUtil {

    private String SECRET_KEY = "secret";
	
    // Extract username from a created token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
	
    // Extracts expiration date from a created token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    
    // takes claims and uses claimsResolver object to figure out claims ??
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
	
    // Checks is token is expired
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Generates a token with userdetail object
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    // Takes claims and creates jwt token with Jwts.builder to the user specified 'subject'
    // current date is used to set the issued at time
    // sets expiration to 10 h from issuing
    // signed with HS256 algorithm and secret key defined in the class
    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    // Takes token and User object to check if token is valid by checking if it's expired
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
