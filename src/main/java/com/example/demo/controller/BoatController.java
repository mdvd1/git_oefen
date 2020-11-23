package com.example.demo.controller;

import com.example.demo.model.Boat;
import com.example.demo.repository.BoatRepository;
import com.example.demo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Medy van Dijk <me.van.dijk@st.hanze.nl>
 * Uitwerking van opdracht
 * Doel:
 */
@Controller
public class BoatController {

    @Autowired
    BoatRepository boatRepository;

    @Autowired
    TypeRepository typeRepository;

    @GetMapping({"/", "/boats"})
    protected String showBoats(Model model) {
        model.addAttribute("allBoats", boatRepository.findAll());
        return "boatOverview";
    }

    @GetMapping("/boat/{boatname}")
    protected String showBookDetails(Model model, @PathVariable("boatname") String boatname){
        Optional<Boat> bookBox = boatRepository.findByBoatname(boatname);
        if (bookBox.isEmpty()) {
            return "redirect:/boats";
        }
        model.addAttribute("boat", bookBox.get());
        return "boatDetails";
    }

    @GetMapping("/boats/add")
    protected String showBoatForm(Model model) {
        model.addAttribute("boat", new Boat());
        model.addAttribute("allTypes", typeRepository.findAll());
        return "boatForm";
    }

    @PostMapping("/boats/add")
    protected String saveOrUpdateBoat(@ModelAttribute("boat") Boat boat, BindingResult result) {
        if (result.hasErrors()) {
            return "boatForm";
        } else {
            boatRepository.save(boat);
            return "redirect:/boats";
        }
    }
}


