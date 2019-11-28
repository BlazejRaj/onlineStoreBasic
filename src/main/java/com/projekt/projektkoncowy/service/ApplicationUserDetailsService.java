package com.projekt.projektkoncowy.service;

import com.projekt.projektkoncowy.entity.User;
import com.projekt.projektkoncowy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User entity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));



        UserDetails userDetails;

        if (entity.getUsername().equals("admin")){
            String[] roles = new String[2];
            roles[0] = "USER";
            roles[1] = "ADMIN";
            userDetails = org.springframework.security.core.userdetails.User
                    .withUsername(entity.getUsername()).password(entity.getPassword()).roles(roles)
                    .build();

        }else{
            String[] roles = new String[1];
            roles[0] = "USER";
            userDetails = org.springframework.security.core.userdetails.User
                    .withUsername(entity.getUsername()).password(entity.getPassword()).roles(roles)
                    .build();
        }
        //TODO: implement user ROLES from DB


        return userDetails;

//        return org.springframework.security.core.userdetails.User
//                .withUsername(entity.getUsername()).password(entity.getPassword()).roles(roles)
//                .build();
    }
}
