package moviebookservice.security.authServices;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// Customized user detail service
// if user info would be stored in a db the hook would be in here
// and usernames and passwords would be fetched from there 

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Hard coded valid user test with password test
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("test", "test",
                new ArrayList<>());
    }
}
