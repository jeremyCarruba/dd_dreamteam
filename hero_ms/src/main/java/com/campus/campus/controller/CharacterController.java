package com.campus.campus.controller;


import com.campus.campus.dao.HeroDAO;
import com.campus.campus.model.Hero;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api( description="API pour es opérations CRUD sur les personnages.")
@RestController
public class CharacterController {

    @Autowired
    private HeroDAO heroDAO;

    @ApiOperation(value = "Récupère tous les personnages")
    @RequestMapping(value="/characters", method= RequestMethod.GET)
    public ResponseEntity<List<Hero>> charactersList(){
        return new ResponseEntity<>(heroDAO.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Récupère un perso grâce à son ID à condition que celui-ci existe!")
    @GetMapping(value = "/characters/{id}")
    public ResponseEntity<Optional<Hero>> characterDisplay(@PathVariable int id){
        ResponseEntity res;
        Optional<Hero> hero = heroDAO.findById(id);
        if(hero.isEmpty()){
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<>(hero, HttpStatus.OK);
        }
        return res;
    }
//
    @ApiOperation(value = "Mise à jour d'un perso")
    @PutMapping(value = "/characters")
    public ResponseEntity characterUpdate(@RequestBody Hero hero){
        Optional<Hero> toUpdate = heroDAO.findById(hero.getId());
        ResponseEntity res;
        if(toUpdate.isEmpty()){
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            heroDAO.save(hero);
            res = new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return res;
    }
//
    @ApiOperation(value = "Ajout d'un perso")
    @PostMapping(value = "/characters")
    public ResponseEntity<Hero> addCharacter(@RequestBody Hero hero) {
        return new ResponseEntity<>(heroDAO.save(hero), HttpStatus.CREATED);
    }
//
    /**
     * Suppression d'un perso
     *
     * @param id;
     * @return une ResponseEntity
     */
    @DeleteMapping(value = "/characters/{id}")
    public ResponseEntity deleteCharacter(@PathVariable int id) {
        Optional<Hero> hero = heroDAO.findById(id);
        ResponseEntity res;
        if(hero.isEmpty()){
            res = new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            heroDAO.delete(hero.get());
            res = new ResponseEntity(HttpStatus.OK);
        }
        return res;
    }
}
