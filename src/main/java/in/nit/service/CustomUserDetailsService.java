package in.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.nit.model.User;
import in.nit.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		CustomUserDetails userDetails = null;
		
		if(user != null)
		{
			userDetails = new CustomUserDetails();
			userDetails.setUser(user);
		}
		else
		{
			throw new UsernameNotFoundException("User does not exist with this id and password");
		}
		return userDetails;
	}

}
