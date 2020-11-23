package com.example.demo.repository;

import com.example.demo.model.Boat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoatRepository extends JpaRepository<Boat, Integer> {
    Optional<Boat> findByBoatname(String boatname);
}
