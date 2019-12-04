package com.projekt.projektkoncowy.controller;

import com.projekt.projektkoncowy.dto.Cart;
import com.projekt.projektkoncowy.service.CartService;
import com.projekt.projektkoncowy.service.OrderService;
import com.projekt.projektkoncowy.service.ProductService;
import com.projekt.projektkoncowy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CartController {

    private final ProductService productService;
    private final CartService cartService;
    private final OrderService orderService;
    private final UserService userService;

    @GetMapping({"/addToCart"})
    public String addToCart(@RequestParam Long id, HttpSession session, Principal principal){
        cartService.addToCart(id, session, principal);
        return "redirect:productList";
    }

    @GetMapping({"/removeFromCart"})
    public String removeFromCart(@RequestParam Long id, HttpSession session){
        cartService.removeFromCart(id, session);
        return "cart";
    }





//
//    @GetMapping("/test")
//    public String test() {
//        return "test";
//    }


}
