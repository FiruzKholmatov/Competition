package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


class GameTest {

    Collection<Player> players = new ArrayList<>();

    Player player1 = new Player(101, "Fighter", 95);
    Player player2 = new Player(102, "Kicker", 96);
    Player player3 = new Player(103, "Puncher", 96);
    Player player4 = new Player(104, "Killer", 100);


    @BeforeEach
    public void setUp() {
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

    }


    @Test
    public void shouldRegisterAllPlayers() {
        Game game = new Game();
        game.register(players);

        Collection<Player> playersList = game.findAll();

        assertEquals(4, playersList.size());


    }

    @Test
    public void testFirstPlayerWins() {

        Game game = new Game();
        game.register(players);

        int actual = game.round("Kicker", "Fighter");
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerWins() {

        Game game = new Game();
        game.register(players);

        int actual = game.round("Fighter", "Killer");
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void testDraw() {

        Game game = new Game();
        game.register(players);

        int actual = game.round("Kicker", "Puncher");
        int expected = 0;

        assertEquals(expected, actual);
    }


    @Test
    public void shouldThrowExceptionForPlayer1() {

        Game game = new Game();
        game.register(players);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Ironman", "Kicker");
        });


    }

    @Test
    public void shouldThrowExceptionForPlayer2() {

        Game game = new Game();
        game.register(players);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Kicker", "Terminator");
        });


    }


}
