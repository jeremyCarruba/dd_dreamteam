package com.board_ms.board_ms.controller;

import com.board_ms.board_ms.model.Board;
import com.board_ms.board_ms.repository.BoardDAO;
import com.board_ms.board_ms.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

@RestController
public class BoardController {

    @Autowired
    private BoardDAO boardDAO;

    @Autowired
    private BoardService boardService;

//    @ApiOperation(value = "Récupère tous les plateaux")
    @RequestMapping(value="/boards", method= RequestMethod.GET)
    public ResponseEntity<List<Board>> boardsList(){
        return new ResponseEntity<>(boardDAO.findAll(), HttpStatus.OK);
    }

//    @ApiOperation(value = "Récupère un perso grâce à son ID à condition que celui-ci existe!")
    @GetMapping(value = "/boards/{id}")
    public ResponseEntity<Optional<Board>> characterDisplay(@PathVariable int id){
        ResponseEntity res;
        Optional<Board> hero = boardDAO.findById(id);
        if(hero.isEmpty()){
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<>(hero, HttpStatus.OK);
        }
        return res;
    }
    //
//    @ApiOperation(value = "Mise à jour d'un perso")
    @PutMapping(value = "/boards")
    public ResponseEntity boardUpdate(@RequestBody Board board){
        Optional<Board> toUpdate = boardDAO.findById(board.getId());
        ResponseEntity res;
        if(toUpdate.isEmpty()){
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            boardDAO.save(board);
            res = new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return res;
    }
    //
//    @ApiOperation(value = "Ajout d'un perso")
    @PostMapping(value = "/boards")
    public ResponseEntity<Board> createBoard() {
        int boardSize = 64;
        TreeMap<Integer, String> map = boardService.createNewBoard(boardSize);
        Board board = new Board(map, boardSize);
        board = boardDAO.save(board);
        return new ResponseEntity<>(board, HttpStatus.CREATED);
    }
//
    /**
     * Suppression d'un perso
     *
     * @param id;
     * @return une ResponseEntity
     */
    @DeleteMapping(value = "/boards/{id}")
    public ResponseEntity deleteCharacter(@PathVariable int id) {
        Optional<Board> hero = boardDAO.findById(id);
        ResponseEntity res;
        if(hero.isEmpty()){
            res = new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            boardDAO.delete(hero.get());
            res = new ResponseEntity(HttpStatus.OK);
        }
        return res;
    }

}
