package com.projekt.projektkoncowy.service;

import com.projekt.projektkoncowy.dto.AddressDto;
import com.projekt.projektkoncowy.dto.UserDto;
import com.projekt.projektkoncowy.entity.User;
import com.projekt.projektkoncowy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void create (UserDto userDto){
        User entity = new User();
        entity.setFirstName(userDto.getFirstName());
        entity.setUsername(userDto.getUsername());
       // entity.setPassword(userDto.getPassword());

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        entity.setPassword(encodedPassword);

        userRepository.save(entity);
    }


    public void updateAddress (AddressDto addressDto, Principal principal){
        //TODO : imprement updateAddress
    }




}
