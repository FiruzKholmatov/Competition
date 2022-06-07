package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class Player {
    int id;
    String name;
    int strength;


    public int getStrength(String player) {
        return strength;
    }

}
