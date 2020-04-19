package com.example.tictactoegame;

import java.util.HashMap;
import java.util.Map;

public enum FragmentCollection {
    MENU_FRAGMENT(0),
    ONE_PLAYER_FRAGMENT(1),
    TWO_PLAYERS_FRAGMENT(2),
    RANKING_FRAGMENT(3),
    BOARD_FRAGMENT(4);


    private int value;
    private static Map map = new HashMap<>();

    private FragmentCollection(int value) {
        this.value = value;
    }

    static {
        for (FragmentCollection pageType : FragmentCollection.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static FragmentCollection valueOf(int pageType) {
        return (FragmentCollection) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}
