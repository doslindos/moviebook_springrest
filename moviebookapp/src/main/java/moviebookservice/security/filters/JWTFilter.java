package moviebookservice.security.filters;

import moviebookservice.security.authServices.CustomUserDetailsService;
import moviebookservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Source https://github.com/koushikkothagal/spring-security-jwt/blob/master/src/main/java/io/javabrains/springsecurityjwt/filters/JwtRequestFilter.java

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    
    // Takes request, response and chain
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
	
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

    	// Examines request header and checks if JWT is valid
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }
	
	// Second part checks if the user doesn't allready have a token
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	    // Get user userdetails
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
		
	    // If valid JWT is found
            if (jwtUtil.validateToken(jwt, userDetails)) {
		// Spring security default behavior
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
	// Continue filter chain
        chain.doFilter(request, response);
    }

}
