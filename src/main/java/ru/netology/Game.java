package ru.netology;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    protected Collection<Player> players = new ArrayList<>();

    public Collection<Player> findAll() {
        return players;
    }


    public void register(Collection<Player> players) {
        this.players.addAll(players);
    }


    public int round (String playerName1, String playerName2) {
        int result=0;
        int player1=0;
        int player2=0;
        for (Player player : players)
            if (player.getName().equals(playerName1)) {
                player1 = player.getStrength(playerName1);
            }
        for (Player player : players)
            if (player.getName().equals(playerName2)) {
                player2 = player.getStrength(playerName2);
            }
        if (player1 > player2){
            result = 1;
        }
        if (player2 > player1){
            result = 2;
        }

        if (findByName(playerName1)==null){
                throw new NotRegisteredException(
                        "Player is NOT registered"
                );
            }
        if (findByName(playerName2)==null){
            throw new NotRegisteredException(
                    "Player is NOT registered"
            );
        }

        return result;
    }


    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }















































//    protected Collection<Player> players = new ArrayList<>();
//
//    public boolean addPlayer(Player player) {
//        return players.add(player);
//    }
//
//    public boolean register (Player player){
//       return players.contains(player);
//    }
//
//    public Collection<Player> getAll() {
//        return players;
//    }
//
//
//
//    public int round(String playerName1, String playerName2) {
//        int result = 0;
//        for (Player player : players){
//            int player1 = player.getStrength(playerName1);
//            int player2 = player.getStrength(playerName2);
//            if (player1 > player2){
//                result = 1;
//            } else if (player2 > player1){
//                result = 2;
//            } else {
//                result = 0;
//            }
//        }
//        return result;
//
//
//
//
//
////            if (findByName(playerName1) == null || findByName(playerName2) == null)
////                throw new RuntimeException(
////                        "Player not found!!! Try another one!!!"
////                );
//
//
//
//    }
//
//    public Player findByName(String name) {
//        for (Player player : players) {
//            if (player.getName().equals(name)) {
//                return player;
//            }
//        }
//        return null;
//    }


}
