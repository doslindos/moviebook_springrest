package moviebookservice.security.authConfigs;

import moviebookservice.security.filters.JWTFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	//@Override
	//protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		// Make in memory auth
	//	auth.inMemoryAuthentication()
	//		.withUser("testi")
	//		.password("testi")
	//		.roles("USER")
	//		.and()
	//		.withUser("admin")
	//		.password("admin")
	//		.roles("ADMIN");

	//}
	
	@Autowired
	private UserDetailsService customUserDetailsService;
	
	@Autowired
	private JWTFilter jwtFilter;
	
	// Sets customized user details service to be used by authentication manager
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(customUserDetailsService);
	}
		
	// Create PasswordEncoder bean which is automatically used by spring security
	// because it looks for PosswordEncoder named beans
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	// Deprecated authentication manager bean recreated
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	//@Override
	//protected void configure(HttpSecurity http) throws Exception {
		// Set http auth configurations
	//	http.authorizeRequests()
			// Set paths and auth roles that can access it
			// Permit admin
	//		.antMatchers("/authentication").permitAll()
			// Permit logged users to use APIs
	//		.antMatchers("/**").permitAll()
			//.hasAnyRole("ADMIN", "USER")
			// Permit any user
	//		.antMatchers("/").permitAll()
			// Set authentication method
	//		.and().formLogin();
	//}
	

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeRequests().antMatchers("/authenticate").permitAll().
				anyRequest().authenticated().and().
				// Add session management to be stateless = Spring doesn't create a session
				exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// Pass the jwt filter before username password filter
		httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	}

}
