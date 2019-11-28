package com.projekt.projektkoncowy.controller;


import com.projekt.projektkoncowy.dto.OrderDto;
import com.projekt.projektkoncowy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class OrderController {

    private final OrderService orderService;


    @GetMapping({"/userOrderList"})
    public String userOrderList (Model model, Principal principal){

       List<OrderDto> orders = orderService.findAllByUsername(principal.getName());
       model.addAttribute("orderList", orders);

        return "user";
    }




}
