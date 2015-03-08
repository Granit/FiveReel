package com.example.FiveReel.gametypes;

import com.example.FiveReel.combinations.standart.StandartCombinationManager;
import com.example.FiveReel.utils.GameResources;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public class StandartGameTypeManager extends GameTypeManager<StandartCombinationManager, StandartReel> {

    @Override
    public void loadResources(SimpleBaseGameActivity activity) {
        this.activity = activity;
        GameResources.getInstance().loadReelSpinStandart(activity);
    }

    @Override
    protected void initCombinationManager() {
        combinationManager = new StandartCombinationManager();

    }

    @Override
    protected StandartReel createReel(SimpleBaseGameActivity activity) {
        StandartReel reel = new StandartReel(activity);
        return reel;
    }

}
