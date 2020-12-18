package com.campus.campus.dao;


import java.util.List;
import java.util.Optional;

import com.campus.campus.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<Item, Integer> {
    public List<Item> findAll();
    public Optional<Item> findById(int id);
    public Item save(Item item);
}
