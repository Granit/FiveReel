package com.example.FiveReel.gametypes;

import com.example.FiveReel.utils.GameResources;
import com.example.FiveReel.utils.SpinParams;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public class StandartReel extends Reel {

    public StandartReel(SimpleBaseGameActivity activity) {
        super(activity, GameResources.getInstance().getReelSpinStandartRegion());
    }

    @Override
    public void animate(SpinParams params) {
        animate(params.getFrameDuration(), createAnimationListener(params.getFrameCount(), 0));
    }

}
