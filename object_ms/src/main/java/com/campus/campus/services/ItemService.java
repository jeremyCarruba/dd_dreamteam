package com.campus.campus.services;

import com.campus.campus.dao.ItemDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemDAO itemDAO;

}
