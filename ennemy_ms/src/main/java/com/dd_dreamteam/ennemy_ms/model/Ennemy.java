package com.dd_dreamteam.ennemy_ms.model;

import javax.persistence.*;

@Entity
@Table
public class Ennemy {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private int health;
    private int strength;
    private int number;

    public Ennemy(){
    };

    public Ennemy(Integer id){
        this.id = id;
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                ", number=" + number +
                '}';
    }
}
