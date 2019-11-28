package com.projekt.projektkoncowy.controller;

import com.projekt.projektkoncowy.dto.Cart;
import com.projekt.projektkoncowy.dto.ItemInCart;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CartController {

    private final ProductService productService;
    private final CartService cartService;
    private final OrderService orderService;
    private final UserService userService;

//STARA WERSJA
//    @GetMapping({"/addToCart"})
//    public String addToCart(@RequestParam Long id, HttpSession session){
//        if(session.getAttribute("cart") == null){
//            List<ItemInCart> cart = new ArrayList<>();
//            cart.add(new ItemInCart(productService.findById(id), 1));
//            session.setAttribute("cart", cart);
//        }else{
//            List<ItemInCart> cart = (List<ItemInCart>) session.getAttribute("cart");
//            int positionInCart = cartService.isInCart(id, cart);
//            if(positionInCart >= 0){
//                int quantity = cart.get(positionInCart).getQuantity() + 1;
//                cart.get(positionInCart).setQuantity(quantity);
//            }else{
//                cart.add(new ItemInCart(productService.findById(id), 1));
//            }
//            session.setAttribute("cart", cart);
//        }
//        return "redirect:productList";
//    }

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



    @GetMapping({"/order"})
    public String orderNow(HttpSession session, Principal principal){
        if(session.getAttribute("cart") !=null){
            Cart cart = (Cart) session.getAttribute("cart");
            orderService.createOrder(cart,principal.getName());

        }

        return "order";
    }






}
