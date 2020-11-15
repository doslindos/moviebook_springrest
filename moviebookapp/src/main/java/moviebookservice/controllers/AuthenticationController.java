package moviebookservice.controllers;

import moviebookservice.util.JwtUtil;
import moviebookservice.security.authServices.CustomUserDetailsService;
import moviebookservice.models.Authentication.AuthenticationRequest;
import moviebookservice.models.Authentication.AuthenticationResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;


@RestController
public class AuthenticationController {

	// Fetch authentication manager object
	@Autowired
	private AuthenticationManager authManager;
	
	// Fetch jwttoken functions object
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	// Create an endpoint to jwt token retrieval
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authReq) throws Exception {
		// authReq is the authentication request which should have a valid username and password in it
		// to get the jwt
		try {
			// The authentication
			authManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
		}
		catch (BadCredentialsException e){
			throw new Exception("Bad user credentials... ", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());
		final String jwt_token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt_token));
	}	

}
