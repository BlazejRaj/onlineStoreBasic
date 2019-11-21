package com.projekt.projektkoncowy.service;

import com.projekt.projektkoncowy.dto.OrderDto;
import com.projekt.projektkoncowy.dto.UserDto;
import com.projekt.projektkoncowy.entity.Order;
import com.projekt.projektkoncowy.entity.User;
import com.projekt.projektkoncowy.repository.OrderRepository;
import com.projekt.projektkoncowy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;



    public void createOrder (String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User with username"
                        + username + " not found"));

        Order entity = new Order();
        entity.setDate(getLocalDate());
        entity.setUser(user);

        orderRepository.save(entity);
    }

    private String getLocalDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }



}
