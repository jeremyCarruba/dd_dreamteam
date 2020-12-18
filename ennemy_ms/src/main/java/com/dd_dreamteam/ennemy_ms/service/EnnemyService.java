package com.dd_dreamteam.ennemy_ms.service;

import com.dd_dreamteam.ennemy_ms.dao.EnnemyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnnemyService {

    @Autowired
    EnnemyDAO EnnemyDAO;

    }
