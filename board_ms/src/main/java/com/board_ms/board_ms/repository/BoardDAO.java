package com.board_ms.board_ms.repository;

import com.board_ms.board_ms.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardDAO extends JpaRepository<Board, Integer> {
    public List<Board> findAll();
    public Optional<Board> findById(int id);
    public Board save(Board hero);
}

