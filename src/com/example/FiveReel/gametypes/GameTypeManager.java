package com.example.FiveReel.gametypes;

import com.example.FiveReel.combinations.CombinationManagerI;
import com.example.FiveReel.combinations.CombinationResult;
import com.example.FiveReel.combinations.SpinResult;
import com.example.FiveReel.graphic.ReelMachine;
import com.example.FiveReel.graphic.SpinListener;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public abstract class GameTypeManager<COMBManager extends CombinationManagerI, REEL extends Reel> implements GameTypeManagerI {
    protected SimpleBaseGameActivity activity;
    protected COMBManager combinationManager;
    protected ReelMachine reelMachine;

    public GameTypeManager() {
        initCombinationManager();
        initReelMachine();
    }

    public abstract void loadResources(SimpleBaseGameActivity activity);

    private void initReelMachine() {
        reelMachine = new ReelMachine();
    }

    protected abstract void initCombinationManager();

    @Override
    public CombinationResult calculateResult(SpinResult result) {
        return combinationManager.calculate(result);
    }

    @Override
    public void setSpinListener(SpinListener listener) {
        reelMachine.setListener(listener);
    }

    protected abstract REEL createReel(SimpleBaseGameActivity activity);

    public ReelMachine getReelMachine() {
        return reelMachine;
    }

    public void createReels(int count) {
        for (int i = 0; i < count; i++) {
            reelMachine.addReel(createReel(activity));
        }
    }

    public boolean isSpinning(){
        return reelMachine.isSpinning();
    }
}


