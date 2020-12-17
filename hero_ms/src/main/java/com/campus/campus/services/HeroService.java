package com.campus.campus.services;

import com.campus.campus.dao.HeroDAO;
import com.campus.campus.dao.TypeDAO;
import com.campus.campus.model.Hero;
import com.campus.campus.model.NewHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

    @Autowired
    HeroDAO heroDAO;

    @Autowired
    TypeDAO typeDAO;
    public Hero createNewHero(NewHero newHero){
        Hero hero = new Hero(newHero.getName(), typeDAO.findByName(newHero.getType()).get());
        return heroDAO.save(hero);
    }
}
