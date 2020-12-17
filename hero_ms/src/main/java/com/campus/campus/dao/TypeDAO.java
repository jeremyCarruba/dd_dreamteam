
package com.campus.campus.dao;

import java.util.List;
import java.util.Optional;

import com.campus.campus.model.Hero;
import com.campus.campus.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDAO extends JpaRepository<Type, Integer> {
        public List<Type> findAll();
        public Optional<Type> findById(int id);
        public Optional<Type> findByName(String name);
        public Type save(Type type);
    }
