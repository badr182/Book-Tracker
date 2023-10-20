package com.auth.services;

import com.auth.domain.User;

public interface UserService {
	
	User save(User user);
	User getUser(String username);

}
