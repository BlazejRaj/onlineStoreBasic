package com.projekt.projektkoncowy.service;

import com.projekt.projektkoncowy.dto.ItemInCart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {



    public int isInCart(Long id, List<ItemInCart> cartList){
        for(int i =0; i< cartList.size(); i++){
            if (cartList.get(i).getProductDto().getId() == id){
                return i;
            }
        }
        return -1;
    }
}
