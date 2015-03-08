package com.example.FiveReel.gametypes;

import com.example.FiveReel.MainActivity;
import com.example.FiveReel.combinations.CombinationResult;
import com.example.FiveReel.combinations.SpinResult;
import com.example.FiveReel.combinations.bonus.BonusCombinationManager;
import com.example.FiveReel.utils.GameResources;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public class BonusGameTypeManager extends GameTypeManager<BonusCombinationManager, BonusReel> {

    @Override
    public void loadResources(SimpleBaseGameActivity activity) {
        this.activity = activity;
        GameResources.getInstance().loadReelSpinBonus(activity);
    }

    @Override
    protected void initCombinationManager() {
        combinationManager = new BonusCombinationManager();
    }

    @Override
    public CombinationResult calculateResult(SpinResult result) {
        return combinationManager.calculate(result);
    }

    @Override
    protected BonusReel createReel(SimpleBaseGameActivity activity) {
        BonusReel reel = new BonusReel(activity);
        return reel;
    }
}
