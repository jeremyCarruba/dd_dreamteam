//package com.board_ms.board_ms.services;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//
//public class EventService {
//
//    private TreeMap boardEvents;
//
//    public EventService(Board board) {
//        this.boardEvents = board.getBoardEvents();
//    }
//
//    public void makeEvents(String type, int occurences, int[] positions) {
//        if (type.equalsIgnoreCase("empty")) {
//            emptySquares(occurences);
//        } else if (type.equalsIgnoreCase("Goblin")
//                || type.equalsIgnoreCase("Dragon")
//                || type.equalsIgnoreCase("Sorcerer")) {
//            createFoes(type, occurences, positions);
//        } else if (type.equalsIgnoreCase("Potion Standard")
//                || type.equalsIgnoreCase("Grande Potion")) {
//            createPotions(type, occurences, positions);
//        } else if (type.equalsIgnoreCase("Épée")
//                || type.equalsIgnoreCase("Massue")) {
//            createWeapons(type, occurences, positions);
//        } else if (type.equalsIgnoreCase("Éclair")
//                || type.equalsIgnoreCase("Boule de feu")){
//            createPotions(type, occurences, positions);
//        }
//    }
//
//
//
//    /**
//     * La fonction responsable du peuplement de la Treemap par des ennemis
//     *
//     * @param occurences le nombre d'ennemi à instancier
//     * @param positions  les positions auxquelles se trouveront les ennemis
//     * @param foeType    le type d'ennemi à instancier sous forme de String
//     */
//    private void createFoes(String foeType, int occurences, int[] positions) {
//        for (int i = 0; i < occurences; i++) {
//            Event Foe = new Foe(positions[i], foeType);
//            boardEvents.put(positions[i], Foe);
//        }
//    }
//
//    /**
//     * La fonction responsable de l'instanciation des potions dans la treemap
//     *
//     * @param occurences le nombre de potions à créé
//     * @param positions  les positions auxquelles se trouvent les potions
//     * @param bonusType  le type de bonus à créé (potion standard ou grande)
//     */
//    private void createPotions(String bonusType, int occurences, int[] positions) {
//        for (int i = 0; i < occurences; i++) {
//            Event Bonus = new Potion(positions[i], bonusType);
//            boardEvents.put(positions[i], Bonus);
//        }
//    }
//
//    /**
//     * Fonction responsable de la création des armes sur le plateau
//     *
//     * @param occurences le nombre d'arme à créer
//     * @param positions  les positions où les placer
//     * @param bonusType  Le type d'arme (épée ou massue)
//     */
//    private void createWeapons(String bonusType, int occurences, int[] positions) {
//        for (int i = 0; i < occurences; i++) {
//            Event Bonus = new Weapon(positions[i], bonusType);
//            boardEvents.put(positions[i], Bonus);
//        }
//    }
//
//    /**
//     * Fonction responsable de la création des sorts sur le plateau
//     * @param occurences Le nombre de sort à placer
//     * @param positions Les positions auxquelles les placer
//     * @param bonusType Le type de sort (éclair / boule de feu)
//     */
//    private void createSpell(String bonusType, int occurences, int[] positions) {
//        for (int i = 0; i < occurences; i++) {
//            Event Bonus = new Spell(positions[i], bonusType);
//            boardEvents.put(positions[i], Bonus);
//        }
//    }
//
//
//
//    /**
//     * Fonction de listage des events
//     */
//    public void listBoardEvents() {
//        Set<Map.Entry<Integer, String>> listOfEvents = this.boardEvents.entrySet();
//        for (Object listOfEvent : listOfEvents) {
//            Map.Entry me = (Map.Entry) listOfEvent;
//            System.out.println("**======= CASE " + me.getKey() + " =======**");
//            System.out.println(me.getValue());
//        }
//    }
//}
