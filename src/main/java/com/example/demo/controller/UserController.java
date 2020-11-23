package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Medy van Dijk <me.van.dijk@st.hanze.nl>
 * Uitwerking van opdracht
 * Doel:
 */
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    protected String showUsers(Model model) {
        model.addAttribute("allUsers", userRepository.findAll());
        model.addAttribute("user", new User());
        return "userOverview";
    }

    @PostMapping("/user/add")
    protected String saveOrUpdateUser(@ModelAttribute("user") User user, BindingResult result){
        if (result.hasErrors()) {
            return "userOverview";
        } else {
            userRepository.save(user);
            return "redirect:/users";
        }
    }
}