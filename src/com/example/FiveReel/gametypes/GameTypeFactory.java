package com.example.FiveReel.gametypes;

import com.example.FiveReel.combinations.GameType;

public class GameTypeFactory {

    public static GameTypeManagerI getManager(GameType gameType) {
        switch (gameType) {
            case BONUS:
                return new BonusGameTypeManager();
            case STANDART:
                return new StandartGameTypeManager();
            default:
                throw new IllegalArgumentException("Unknown GameType: " + gameType);
        }
    }
}
