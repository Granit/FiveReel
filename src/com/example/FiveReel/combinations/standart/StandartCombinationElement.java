package com.example.FiveReel.combinations.standart;

import com.example.FiveReel.combinations.CombinationElementI;

public enum StandartCombinationElement implements CombinationElementI {
    CHERRY(1),
    BAR(1),
    BELL(1),
    MELON(1),
    SEVEN(2),;
    private int multiplier;

    StandartCombinationElement(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public int getMultiplier() {
        return multiplier;
    }

    public static CombinationElementI findElementByIndex(int index) {
        switch (index) {
            case 1:
                return BAR;
            case 2:
                return BELL;
            case 5:
                return MELON;
            case 6:
                return SEVEN;
            default:
                return CHERRY;
        }
    }
}
