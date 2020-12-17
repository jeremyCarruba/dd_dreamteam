package com.campus.campus.dao;


import java.util.List;
import java.util.Optional;

import com.campus.campus.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroDAO extends JpaRepository<Hero, Integer> {
    public List<Hero> findAll();
    public Optional<Hero> findById(int id);
    public Hero save(Hero hero);
}
