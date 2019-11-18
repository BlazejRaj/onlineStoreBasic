package com.projekt.projektkoncowy.smietnik;

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
public class ProductListController {


    private final ProductService productService;






}
