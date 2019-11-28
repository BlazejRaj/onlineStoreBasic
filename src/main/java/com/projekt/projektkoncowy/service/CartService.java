package com.projekt.projektkoncowy.service;

import com.projekt.projektkoncowy.dto.Cart;
import com.projekt.projektkoncowy.dto.ItemInCart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;

    public void addToCart(Long id, HttpSession session, Principal principal){
        if(session.getAttribute("cart") == null){
            Cart cart = new Cart();

            ItemInCart itemInCart = new ItemInCart(productService.findById(id), 1);
            List<ItemInCart> itemInCartList = new ArrayList<>();
            itemInCartList.add(itemInCart);

            cart.setItemInCartList(itemInCartList);
            //cart.setUsername("admin");
            cart.setUsername(principal.getName());

            session.setAttribute("cart", cart);
            session.setAttribute("itemInCartList", cart.getItemInCartList());

        }else{

            Cart cart = (Cart) session.getAttribute("cart");
            List<ItemInCart> itemInCartList = cart.getItemInCartList();

            int positionInCart = isInCart(id, itemInCartList);
            if(positionInCart >= 0){
                int quantity = itemInCartList.get(positionInCart).getQuantity() + 1;
                itemInCartList.get(positionInCart).setQuantity(quantity);
            }else{
                itemInCartList.add(new ItemInCart(productService.findById(id), 1));
            }
//            session.setAttribute("cart", cart);
//            session.setAttribute("itemInCartList", itemInCartList);
        }

    }

    public void removeFromCart(Long id, HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        if(session.getAttribute("cart") != null){
            List<ItemInCart> itemInCartList = cart.getItemInCartList();
            int positionInCart = isInCart(id, itemInCartList);
            if(positionInCart >=0){
                itemInCartList.remove(positionInCart);
            }
            // session.setAttribute("cart", cart);
            //  session.setAttribute("itemInCartList", itemInCartList);
        }
    }






    private int isInCart(Long id, List<ItemInCart> cartList){
        for(int i =0; i< cartList.size(); i++){
            if (cartList.get(i).getProductDto().getId() == id){
                return i;
            }
        }
        return -1;
    }
}
