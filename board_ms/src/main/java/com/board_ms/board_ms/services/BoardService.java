package com.board_ms.board_ms.services;

import com.board_ms.board_ms.model.Board;
import com.board_ms.board_ms.model.Ennemy;
import com.board_ms.board_ms.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

@Service
public class BoardService {

    @Autowired
    MainService mainService;

    public TreeMap<Integer, String> createNewBoard(int boardSize){
        TreeMap<Integer, String> board = new TreeMap<>();
        setRandomBoardEvents(boardSize, board);
        return board;
    }

    /**
     * Fonction responsable du peuplement de la Treemap en cas de plateau aléatoire
     */
    protected void setRandomBoardEvents(int boardSize, TreeMap<Integer, String> boardEvents) {
        List<Integer> randomBoard = createRandomArray(boardSize);
        Item[] items = mainService.itemsList();
        Ennemy[] ennemies = mainService.ennemiesList();
        emptySquares(boardSize, boardEvents);
        createEvents(ennemies[0].getType(), ennemies[0].getNumber(), pickArray(randomBoard, ennemies[0].getNumber()), boardEvents);
        createEvents(ennemies[1].getType(), ennemies[1].getNumber(), pickArray(randomBoard,ennemies[1].getNumber()), boardEvents);
        createEvents(ennemies[2].getType(), ennemies[2].getNumber(), pickArray(randomBoard,ennemies[2].getNumber()),  boardEvents);
        createEvents(items[0].getName(), 5, pickArray(randomBoard,5),boardEvents);
        createEvents(items[1].getName(), 4, pickArray(randomBoard,4),boardEvents);
        createEvents(items[2].getName(), 5, pickArray(randomBoard,5),boardEvents);
        createEvents(items[3].getName(), 2, pickArray(randomBoard,2),boardEvents);
        createEvents(items[4].getName(), 5, pickArray(randomBoard,5),boardEvents);
        createEvents(items[5].getName(), 2, pickArray(randomBoard,2),boardEvents);
    }

    /**
     * Fonction de création d'une array aléatoire avec 63 terme (la 64 étant la case de victoire)
     * @return Une array aléatoire de 64 valeurs
     */
    private List <Integer> createRandomArray(int boardSize){
        List<Integer> numberArray =new ArrayList<>();
        for(int i =1; i<boardSize; i++) {
            numberArray.add(i);
        }
        Collections.shuffle(numberArray);
        return numberArray;
    }

    /**
     * On pick une nouvelle array d'un certain size dans la liste random
     * @param list une liste de valeurs aléatoire
     * @param size la taille de l'array final que l'on veut
     * @return une array d'une taille donnée précédemment, contenant des valeurs choisi dans une liste
     */
    private int[] pickArray(List<Integer> list, int size) {
        int[] newArray = new int[size];
        for(int i = 0; i<size; i++){
            newArray[i] = list.get(i);
            list.remove(i);
        }
        return newArray;
    }

    /**
     * Fonction responsable du peuplement du plateau par des cases vides
     *
     * @param taillePlateau la taille du Plateau
     */
    private void emptySquares(int taillePlateau, TreeMap<Integer, String> boardEvents) {
        for (int i = 1; i < taillePlateau; i++) {
            boardEvents.put(i, new String("empty"));
        }
    }

    /**
     * La fonction responsable du peuplement de la Treemap par des ennemis
     *
     * @param occurences le nombre d'ennemi à instancier
     * @param positions  les positions auxquelles se trouveront les ennemis
     */
    private void createEvents(String event, int occurences, int[] positions, TreeMap<Integer, String> boardEvents) {
        for (int i = 0; i < occurences; i++) {
            boardEvents.put(positions[i], event);
        }
    }
}
