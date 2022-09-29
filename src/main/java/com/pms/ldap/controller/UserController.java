package com.pms.ldap.controller;

import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@GetMapping
	 @PreAuthorize("hasAuthority('ROLE_INFRA')")
	public Authentication getUser() {
				     
		      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		     //get username
		     String username = auth.getName();
		   // concat list of authorities to single string seperated by comma
		     String authorityString = auth
		        .getAuthorities()
		        .stream()
		        .map(GrantedAuthority::getAuthority)
		        .collect(Collectors.joining(","));
		   // check if the user have authority -roleA
		     String role = "ADMIN";
		     boolean isCurrentUserInRole = auth
		         .getAuthorities()
		         .stream()
		         .anyMatch(role::equals);
		   //return Authentication object  
		   return auth;
	}
}
