package com.dd_dreamteam.ennemy_ms.dao;

import com.dd_dreamteam.ennemy_ms.model.Ennemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnnemyDAO extends JpaRepository<Ennemy, Integer> {
    public List<Ennemy> findAll();
    public Optional<Ennemy> findById(int id);
}
