package com.campus.campus.model;

public class NewHero {

    private String name;
    private String type;

    public NewHero() {
    }

    public NewHero(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NewHero{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
