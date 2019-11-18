package com.projekt.projektkoncowy.service;

import com.projekt.projektkoncowy.dto.UserDto;
import com.projekt.projektkoncowy.entity.User;
import com.projekt.projektkoncowy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void create (UserDto userDto){
        User entity = new User();
        entity.setFirstName(userDto.getFirstName());
        entity.setUsername(userDto.getUsername());
        entity.setPassword(userDto.getPassword());

        userRepository.save(entity);
    }


}
