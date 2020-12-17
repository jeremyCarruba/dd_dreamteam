package com.campus.campus.model;

import javax.persistence.*;

@Entity
@Table
public class Type {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="id")
    private Integer id;
    private String name;
    private int health;
    private int strength;

    public Type(){}

    public Type(Integer id, String name, int health, int strength) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.strength = strength;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                '}';
    }
}
