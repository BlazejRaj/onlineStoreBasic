package com.projekt.projektkoncowy.controller;

import com.projekt.projektkoncowy.dto.ProductDto;
import com.projekt.projektkoncowy.dto.UserDto;
import com.projekt.projektkoncowy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProductController {


    private final ProductService productService;

    @GetMapping({"/productForm"})
    public String productForm (Model model){
        //List<ProductDto> products = productService.findAll();
        //model.addAttribute("productList", products);
        model.addAttribute("productForm", new ProductDto());
        return "productForm";
    }


    @PostMapping({"/productForm"})
    public String addProduct(@Valid ProductDto productForm, UserDto user){
        productService.create(productForm, user.getUsername());
        return "redirect:/productForm";
    }

    @GetMapping({"/productList"})
    public String productList (Model model){
        List<ProductDto> products = productService.findAll();
        model.addAttribute("productList", products);
        // model.addAttribute("productForm", new ProductDto());
        return "productList";
    }

    @GetMapping({"/productView"})
    public String productView(@RequestParam Long id, Model model){
        ProductDto product = productService.findById(id); // pobrac z  bazy produkt o wskazanym id
        model.addAttribute("product", product);
        return "productView";
    }



}
