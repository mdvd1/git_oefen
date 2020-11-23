package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Medy van Dijk <me.van.dijk@st.hanze.nl>
 * Uitwerking van opdracht
 * Doel:
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String name;

    @OneToMany(mappedBy = "user")
    private List<Boat> myReservedBoats;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Boat> getMyReservedBoats() {
//        return myReservedBoats;
//    }
//
//    public void setMyReservedBoats(List<Boat> myReservedBoats) {
//        this.myReservedBoats = myReservedBoats;
//    }

    public List<Boat> getReservedBoats(){
        return myReservedBoats;
    }

}
