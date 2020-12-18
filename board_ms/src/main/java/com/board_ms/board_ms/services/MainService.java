package com.board_ms.board_ms.services;

import com.board_ms.board_ms.model.Board;
import com.board_ms.board_ms.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MainService {

    private final String baseUrl = "http://localhost:8083/items";
    private final RestTemplate restTemplate = new RestTemplate();

    public Item[] itemsList(){
        ResponseEntity<Item[]> response = restTemplate.getForEntity(baseUrl, Item[].class);
        Item[] list = null;
        if(response.getStatusCode() == HttpStatus.OK){
            list = response.getBody();
        }
        return list;
    }
}
