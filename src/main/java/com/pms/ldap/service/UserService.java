package com.pms.ldap.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.ldap.repository.User;
import com.pms.ldap.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;


    public List<String> search(final String username) {
        List<User> userList = userRepository.findByUsernameLikeIgnoreCase(username);
        if (userList == null) {
            return Collections.emptyList();
        }

        return userList.stream()
          .map(User::getUsername)
          .collect(Collectors.toList());
    }
    
    public User findByLogin(String login) {
    	return userRepository.findByLogin(login);
    }
}
