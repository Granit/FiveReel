package com.example.FiveReel.gametypes;

import com.example.FiveReel.combinations.CombinationResult;
import com.example.FiveReel.combinations.SpinResult;
import com.example.FiveReel.graphic.ReelMachine;
import com.example.FiveReel.graphic.SpinListener;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public interface GameTypeManagerI {

    CombinationResult calculateResult(SpinResult result);

    void loadResources(SimpleBaseGameActivity activity);

    ReelMachine getReelMachine();

    void setSpinListener(SpinListener listener);

    void createReels(int count);

    boolean isSpinning();
}
