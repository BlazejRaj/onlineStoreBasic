package com.projekt.projektkoncowy.controller;


import com.projekt.projektkoncowy.dto.UserDto;
import com.projekt.projektkoncowy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping({"/register"})
public class UserController {

    private final UserService userService;

    @GetMapping
    public String register (Model model){
        model.addAttribute("userForm", new UserDto());
        return "register";
    }


    @PostMapping
    public String registerUser(@Valid @ModelAttribute UserDto userForm){
        userService.create(userForm);
        return "redirect:register";
    }

}
