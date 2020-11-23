package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Medy van Dijk <me.van.dijk@st.hanze.nl>
 * Uitwerking van opdracht
 * Doel:
 */
@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer typeId;

    private String typeName;

    @OneToMany(mappedBy = "type")
    private List<Boat> myBoats;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getNumberofBoats() {
        return myBoats.size();
    }
}
