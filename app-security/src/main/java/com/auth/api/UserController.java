package com.auth.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.domain.User;
import com.auth.repositories.UserRepository;
import com.auth.services.UserService;
import com.datastax.oss.driver.api.core.uuid.Uuids;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepo ;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/root")
	public String test() {
		User user = new User(Uuids.timeBased().toString(),"badr","badr600"); 
		userRepo.save(user);
		return "hi there";
	}
	
	@PostMapping("/user/register")
	public ResponseEntity<Map<String, Object>> register(@RequestBody User user) {
		Map<String, Object> response = new HashMap<String, Object>();
		User userExist = userService.getUser(user.getUsername());
		if (userExist == null ) {
			userService.save(user);
			response.put("success", (String) "User "+user.getUsername() +" created successfully" );
		}else {
			response.put("error", (String) "User "+user.getUsername() +" already exist" );			
		}
		return  ResponseEntity.ok().body(response);
	}
}
