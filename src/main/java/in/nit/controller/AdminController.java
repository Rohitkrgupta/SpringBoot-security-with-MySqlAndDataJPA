package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.User;
import in.nit.repository.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String addUserByAdmin(@RequestBody User user)
	{  
		String pwd = user.getUserPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setUserPassword(encryptPwd);
		userRepository.save(user);
		
		return "User added successfullty with id "+user.getUserId();
	}
	

}
