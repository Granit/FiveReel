package com.example.FiveReel.combinations;

public class CombinationResult {

    private boolean win;
    private int winMultiplier;

    public CombinationResult() {
        winMultiplier = -1;
        win = Boolean.FALSE;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public void setWinMultiplier(int winMultiplier) {
        this.winMultiplier = winMultiplier;
    }

    public int getWinMultiplier() {
        return winMultiplier;
    }

}
