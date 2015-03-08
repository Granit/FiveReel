package com.example.FiveReel.graphic;

import com.example.FiveReel.utils.GameResources;
import com.example.FiveReel.utils.SpinParams;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.util.Arrays;
import java.util.Random;

public class ReelSpin extends AnimatedSprite {

    private SpinListener listener;

    public ReelSpin(SimpleBaseGameActivity activity) {
        super(0f, 0f, GameResources.getInstance().getReelSpinStandartRegion().deepCopy(), activity.getVertexBufferObjectManager());
    }

    public void setListener(SpinListener listener) {
        this.listener = listener;
    }

    public void animate(SpinParams params) {
        animate(params.getFrameDuration(), createAnimationListener(params.getFrameCount(), 0));
        //   animate(generateFrameDurationArray(params.getFrameDuration(), 14), generateFrameArray(14), params.getFrameCount(), createAnimationListener(params.getFrameCount(), 1));
    }

    private int generateLoop() {
        return new Random().nextInt(3 - 2) + 2;
    }

    public boolean isSpinning() {
        return isAnimationRunning();
    }

    private long[] generateFrameDurationArray(long duration, int size) {
        long[] array = new long[14];
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

    private SpinAnimationListener createAnimationListener(int frameCount, int frameIndexStep) {
        return new SpinAnimationListener(frameCount, frameIndexStep) {
            @Override
            public void spinFinished() {
                if (listener != null) {
                    listener.spinFinish();
                }
            }
        };
    }

}
