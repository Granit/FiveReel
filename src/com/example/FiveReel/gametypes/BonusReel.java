package com.example.FiveReel.gametypes;

import com.example.FiveReel.utils.GameResources;
import com.example.FiveReel.utils.SpinParams;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.util.Arrays;

public class BonusReel extends Reel {

    public BonusReel(SimpleBaseGameActivity activity) {
        super(activity, GameResources.getInstance().getReelSpinBonusRegion());
    }

    @Override
    public void animate(SpinParams params) {
        animate(generateFrameDurationArray(params.getFrameDuration(), 14), generateFrameArray(14), params.getFrameCount(), createAnimationListener(params.getFrameCount(), 1));
    }

    private long[] generateFrameDurationArray(long duration, int size) {
        long[] array = new long[size];
        Arrays.fill(array, duration);
        return array;
    }

    private int[] generateFrameArray(int size) {
        int[] array = new int[size];
        int frame = size - 1;
        for (int i = 0; i < size; i++) {
            array[i] = frame;
            frame--;
        }
        return array;
    }
}
