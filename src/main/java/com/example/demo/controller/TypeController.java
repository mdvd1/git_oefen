package com.example.demo.controller;

import com.example.demo.model.Type;
import com.example.demo.repository.TypeRepository;
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
public class TypeController {

    @Autowired
    TypeRepository typeRepository;

    @GetMapping("/types")
    protected String showTypes(Model model){
        model.addAttribute("allTypes", typeRepository.findAll());
        model.addAttribute("type", new Type());
        return "typeOverview";
    }

    @PostMapping("/type/add")
    protected String SaveOrUpdateType(@ModelAttribute("type")Type type, BindingResult result) {
        if (result.hasErrors()) {
            return "typeOverview";
        } else {
            typeRepository.save(type);
            return "redirect:/types";
        }
    }

}
