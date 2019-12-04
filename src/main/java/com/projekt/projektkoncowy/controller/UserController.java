package com.projekt.projektkoncowy.controller;


import com.projekt.projektkoncowy.dto.AddressDto;
import com.projekt.projektkoncowy.dto.OrderDto;
import com.projekt.projektkoncowy.dto.UserDto;
import com.projekt.projektkoncowy.service.OrderService;
import com.projekt.projektkoncowy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class UserController {

    private final UserService userService;
    private final OrderService orderService;

    @GetMapping({"/register"})
    public String register (Model model){
        model.addAttribute("userForm", new UserDto());
        return "register";
    }

    @PostMapping({"/register"})
    public String registerUser(@Valid @ModelAttribute UserDto userForm){
        userService.create(userForm);
        return "redirect:register";
    }

    @GetMapping({"/userOrderList"})
    public String userOrderList (Model model, Principal principal){
        List<OrderDto> orders = orderService.findAllByUsername(principal.getName());
        model.addAttribute("orderList", orders);

        return "user/userOrders";
    }

    @GetMapping({"/updateAddress"})
    public String userAddress (Model model){
        model.addAttribute("addressForm", new AddressDto());
        return "addressForm";
    }

    @PostMapping({"/updateAddress"})
    public String updateUserAddress(@Valid @ModelAttribute AddressDto addressDto, Principal principal){
        userService.updateAddress(addressDto, principal);
        return "redirect:addressForm";
    }



}
