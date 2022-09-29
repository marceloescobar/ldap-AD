package com.pms.ldap.controller;

import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	@RequestMapping(value = "/login")
    public String login() {
        return "signin";
    }
    
    @RequestMapping(value = "/home")
    public String home() {
        return "index";
    }
    
    @RequestMapping(value = "/")
    public String home1() {
        return "index";
    }
    
   
}
