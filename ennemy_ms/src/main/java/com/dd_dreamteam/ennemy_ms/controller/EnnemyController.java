package com.dd_dreamteam.ennemy_ms.controller;

import com.dd_dreamteam.ennemy_ms.dao.EnnemyDAO;
import com.dd_dreamteam.ennemy_ms.model.Ennemy;
import com.dd_dreamteam.ennemy_ms.service.EnnemyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api("API pour les opérations CRUD sur les ennemis")
@RestController
public class EnnemyController {

    @Autowired
    private EnnemyDAO ennemyDAO;

    @Autowired
    private EnnemyService ennemyService;

    @ApiOperation(value = "Récupère tous les ennemis")
    @RequestMapping(value="/ennemies", method= RequestMethod.GET)
    public ResponseEntity<List<Ennemy>> ennemiesList(){
        return new ResponseEntity<>(ennemyDAO.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Récupère un ennemi grâce à son ID à condition que celui-ci existe!")
    @GetMapping(value = "/ennemies/{id}")
    public ResponseEntity<Optional<Ennemy>> characterDisplay(@PathVariable int id){
        ResponseEntity res;
        Optional<Ennemy> ennemy = ennemyDAO.findById(id);
        if(ennemy.isEmpty()){
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<>(ennemy, HttpStatus.OK);
        }
        return res;
    }
}
