package com.projekt.projektkoncowy.controller;


import com.projekt.projektkoncowy.dto.Cart;
import com.projekt.projektkoncowy.dto.OrderDto;
import com.projekt.projektkoncowy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class OrderController {

    private final OrderService orderService;

    @GetMapping({"/order"})
    public String orderNow(HttpSession session, Principal principal){
        if(session.getAttribute("cart") !=null){
            Cart cart = (Cart) session.getAttribute("cart");
            orderService.createOrder(cart,principal.getName());
        }
        return "order";
    }





}
