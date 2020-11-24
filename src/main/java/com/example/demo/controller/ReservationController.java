package com.example.demo.controller;

import com.example.demo.model.Boat;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.repository.BoatRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

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

    @Autowired
    UserRepository userRepository;

    @GetMapping("/reservation/add/b/{boatId}")
    protected String addCopy(@PathVariable("boatId") Integer boatId) {
        Optional<Boat> boatBox = boatRepository.findById(boatId);
        if (boatBox.isPresent()) {
            Reservation reservation = new reservation();
            reservation.setBoat(boatBox.get());
            reservationRepository.save(reservation);
        }
        return "redirect:/boats";
    }

    @GetMapping("/reservations/add/bn/{boatname}")
    protected String addCopy(@PathVariable("boatname") Integer boatname) {
        Optional<Boat> boatBox = boatRepository.findByBoatname(boatname);
        if (boatBox.isPresent()) {
            Reservation reservation = new reservation();
            reservation.setBoat(boatBox.get());
            reservationRepository.save(reservation);
        }
        return "redirect:/boats";
    }

    @GetMapping("/reservation/add/u/{userId}")
    protected String addCopy(@PathVariable("userId") Integer userId) {
        Optional<User> userBox = userRepository.findById(userId);
        if (userBox.isPresent()) {
            Reservation reservation = new reservation();
            reservation.setUser(userBox.get());
            reservationRepository.save(reservation);
        }
        return "redirect:/users";
    }

    @GetMapping("/reservations/add/un/{name}")
    protected String addCopy(@PathVariable("name") Integer name) {
        Optional<User> userBox = userRepository.f;
        if (userBox.isPresent()) {
            Reservation reservation = new reservation();
            reservation.setUser(userBox.get());
            reservationRepository.save(reservation);
        }
        return "redirect:/users";

}
