package com.campus.campus.model;

import javax.persistence.*;

@Entity
@Table
public class Hero {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToOne
    @JoinColumn(unique = true)
    private Type type;

    private int health;
    private int strength;
    private String weapon;

    public Hero(){};

    public Hero(String name, Type type) {
        this.name = name;
        this.type = type;
        this.health = type.getHealth();
        this.strength = type.getStrength();
        this.weapon = null;
    }

    public Hero(Integer id, String name, Type type, int health, int strength, String weapon) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.health = health;
        this.strength = strength;
        this.weapon = weapon;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
