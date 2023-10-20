package com.auth.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;



public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity>{

	
    @Override
    public void configure(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
		CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager);
		customAuthenticationFilter.setFilterProcessesUrl("/api/login");
		http.addFilter(new CustomAuthenticationFilter(authenticationManager));
    }

    public static CustomDsl getCustomDsl() {
        return new CustomDsl();
    }
}
