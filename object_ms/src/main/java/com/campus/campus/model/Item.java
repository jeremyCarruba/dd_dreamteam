package com.campus.campus.model;

import javax.persistence.*;

@Entity
@Table
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int efficacity;

    public Item(){};

    public Item(Integer id, String name, int efficacity) {
        this.id = id;
        this.name = name;
        this.efficacity = efficacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEfficacity() {
        return efficacity;
    }

    public void setEfficacity(int efficacity) {
        this.efficacity = efficacity;
    }
}
