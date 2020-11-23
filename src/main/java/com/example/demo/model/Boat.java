package com.example.demo.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * @author Medy van Dijk <me.van.dijk@st.hanze.nl>
 * Uitwerking van opdracht
 * Doel:
 */

@Entity
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer boatId;

    private String boatname;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "typeId", referencedColumnName = "typeId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Integer getBoatId() {
        return boatId;
    }

    public void setBoatId(Integer boatId) {
        this.boatId = boatId;
    }

    public String getBoatname() {
        return boatname;
    }

    public void setBoatname(String boatname) {
        this.boatname = boatname;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
