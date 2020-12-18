package com.campus.campus.controller;


import com.campus.campus.dao.ItemDAO;
import com.campus.campus.model.Item;
import com.campus.campus.services.ItemService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "Récupère tous les personnages")
    @RequestMapping(value="/items", method= RequestMethod.GET)
    public ResponseEntity<List<Item>> objectsList(){
        return new ResponseEntity<>(itemDAO.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Récupère un perso grâce à son ID à condition que celui-ci existe!")
    @GetMapping(value = "/items/{id}")
    public ResponseEntity<Optional<Item>> objectDisplay(@PathVariable int id){
        ResponseEntity res;
        Optional<Item> item = itemDAO.findById(id);
        if(item.isEmpty()){
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<>(item, HttpStatus.OK);
        }
        return res;
    }
//
    @ApiOperation(value = "Mise à jour d'un perso")
    @PutMapping(value = "/items")
    public ResponseEntity objectUpdate(@RequestBody Item item){
        Optional<Item> toUpdate = itemDAO.findById(item.getId());
        ResponseEntity res;
        if(toUpdate.isEmpty()){
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            itemDAO.save(item);
            res = new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return res;
    }
//
    @ApiOperation(value = "Ajout d'un perso")
    @PostMapping(value = "/items")
    public ResponseEntity<Object> addObject(@RequestBody Object object) {
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }
//
    /**
     * Suppression d'un perso
     *
     * @param id;
     * @return une ResponseEntity
     */
    @DeleteMapping(value = "/items/{id}")
    public ResponseEntity deleteObject(@PathVariable int id) {
        Optional<Item> item = itemDAO.findById(id);
        ResponseEntity res;
        if(item.isEmpty()){
            res = new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            itemDAO.delete(item.get());
            res = new ResponseEntity(HttpStatus.OK);
        }
        return res;
    }
}
