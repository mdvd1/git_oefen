package com.example.demo.controller;

import com.example.demo.repository.BoatRepository;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Medy van Dijk <me.van.dijk@st.hanze.nl>
 * Uitwerking van opdracht
 * Doel:
 */
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    BoatRepository boatRepository;

    @GetMapping({"/reservations"})
    protected String showReservations(Model model) {
        model.addAttribute("allReservations", reservationRepository.
        model.addAttribute("reservat")
    }
}
