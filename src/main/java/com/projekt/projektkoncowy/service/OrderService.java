package com.projekt.projektkoncowy.service;

import com.projekt.projektkoncowy.dto.*;
import com.projekt.projektkoncowy.entity.Order;
import com.projekt.projektkoncowy.entity.OrderLine;
import com.projekt.projektkoncowy.entity.User;
import com.projekt.projektkoncowy.repository.OrderLineRepository;
import com.projekt.projektkoncowy.repository.OrderRepository;
import com.projekt.projektkoncowy.repository.ProductRepository;
import com.projekt.projektkoncowy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderLineRepository orderLineRepository;



    public void createOrder (Cart cart, String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User with username"
                        + username + " not found"));

        Order order = new Order();
        //OrderLine orderLine = new OrderLine();
        List<OrderLine> orderLineList= new ArrayList<>();
        order.setOrderLines(orderLineList);


        for (ItemInCart itemInCart: cart.getItemInCartList()) {
            order.getOrderLines().add(createOrderLine(itemInCart));
        }

        order.setDate(getLocalDate());
        order.setUser(user);

        orderRepository.save(order);
    }

    public OrderLine createOrderLine(ItemInCart itemInCart){

        OrderLine orderLine = new OrderLine();
        Long productId = itemInCart.getProductDto().getId();


        orderLine.setQuantity(itemInCart.getQuantity());
        orderLine.setProduct(productRepository.getOne(productId));

       // orderLineRepository.save(orderLine);

        return orderLine;
    }




    private String getLocalDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }



}
