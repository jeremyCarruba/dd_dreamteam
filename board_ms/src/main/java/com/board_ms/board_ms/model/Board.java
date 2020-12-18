package com.board_ms.board_ms.model;

import com.board_ms.board_ms.services.HashMapConverter;

import javax.persistence.*;
import java.util.*;

/**
 * Classe responsable de la mise en place du plateau de jeu
 */

@Entity
public class Board {
    /**
     * Choix d'une treemap pour avoir un couple clé - valeur et une liste ordonnée
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Transient
    @Convert(converter = HashMapConverter.class)
    private TreeMap<Integer, String> events;
    private int size;

    public Board(){};

    public Board(TreeMap<Integer, String> events, int size) {
        this.events = events;
        this.size = size;
    }

    public TreeMap<Integer, String> getEvents() {
        return events;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Board{" +
                "events=" + events +
                ", size=" + size +
                '}';
    }
}

