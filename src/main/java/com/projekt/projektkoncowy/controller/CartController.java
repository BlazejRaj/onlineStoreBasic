package com.projekt.projektkoncowy.controller;

import com.projekt.projektkoncowy.entity.ItemInCart;
import com.projekt.projektkoncowy.service.CartService;
import com.projekt.projektkoncowy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CartController {

    private final ProductService productService;
    private final CartService cartService;


    @GetMapping({"/addToCart"})
    public String addToCart(@RequestParam Long id, HttpSession session){
        if(session.getAttribute("cart") == null){
            List<ItemInCart> cart = new ArrayList<>();
            cart.add(new ItemInCart(productService.findById(id), 1));
            session.setAttribute("cart", cart);
        }else{
            List<ItemInCart> cart = (List<ItemInCart>) session.getAttribute("cart");
            int positionInCart = cartService.isInCart(id, cart);
            if(positionInCart >= 0){
                int quantity = cart.get(positionInCart).getQuantity() + 1;
                cart.get(positionInCart).setQuantity(quantity);
            }else{
                cart.add(new ItemInCart(productService.findById(id), 1));
            }
            session.setAttribute("cart", cart);
        }
        return "redirect:productList";
    }

    @GetMapping({"/removeFromCart"})
    public String removeFromCart(@RequestParam Long id, HttpSession session){
        if(session.getAttribute("cart") != null){
            List<ItemInCart> cart = (List<ItemInCart>) session.getAttribute("cart");
            int positionInCart = cartService.isInCart(id, cart);
            if(positionInCart >=0){
                cart.remove(positionInCart);
            }
            session.setAttribute("cart", cart);
        }
        return "cart";
    }



//    @GetMapping({"/order"})
//    public String orderNow(){
//        return "order";
//    }

    @GetMapping({"/order"})
    public String orderNow(){
        return "order";
    }



}
