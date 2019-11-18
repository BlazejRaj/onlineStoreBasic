package com.projekt.projektkoncowy.service;


import com.projekt.projektkoncowy.dto.ProductDto;
import com.projekt.projektkoncowy.entity.Product;
import com.projekt.projektkoncowy.entity.User;
import com.projekt.projektkoncowy.repository.ProductRepository;
import com.projekt.projektkoncowy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final UserRepository userRepository;


//    public List<ProductDto> findAllByUsername(String username){
//        return productRepository.findAllByUserUsername(username)
//                .stream().map(this::map)
//                .collect(Collectors.toList());
//    }


    public void create (ProductDto dto, String username){

//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new EntityNotFoundException("User with username"
//                        + username + " not found"));
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrize(dto.getPrize());
    //    entity.setUser(user);
        productRepository.save(entity);

    }

    public List<ProductDto> findAll (){
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList)
        {
            productDtoList.add(map(product));

        }
        return productDtoList;
    }

    public ProductDto findById(Long id){
        ProductDto productDto = map(productRepository.getOne(id));

        return productDto;
    }


    private ProductDto map(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setPrize(product.getPrize());
        return dto;
    }
}



