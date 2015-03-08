package com.example.FiveReel.controllers;

public class CreditsController {
    private static final int DEFAULT_CREDITS = 50;
    private static final int MAX_BET = 5;
    private static final int DEFAULT_BET = 1;
    private int betSum;
    private int creditsSum;

    public CreditsController() {
        betSum = DEFAULT_BET;
        creditsSum = DEFAULT_CREDITS;
    }

    public int getBetSum() {
        return betSum;
    }

    public int getCreditsSum() {
        return creditsSum;
    }

    public void updateBet(){
        betSum = (betSum < MAX_BET ? betSum + 1 : 1);
    }

    public void addToCredit(int betSum){
        creditsSum += betSum;
    }

    public boolean checkPayingCapacity() {
        return creditsSum >= betSum;
    }
}
