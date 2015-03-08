package com.example.FiveReel.graphic;

import org.andengine.entity.sprite.AnimatedSprite;

public abstract class SpinAnimationListener implements AnimatedSprite.IAnimationListener {

    private int initialFrameCount;
    private int currentFrameCount;
    private int frameIndexStep;

    public SpinAnimationListener(int frameCount, int frameIndexStep) {
        this.initialFrameCount = frameCount;
        this.frameIndexStep = frameIndexStep;
    }

    @Override
    public void onAnimationStarted(AnimatedSprite animatedSprite, int initialLoopCount) {
        currentFrameCount = initialFrameCount;
    }

    @Override
    public void onAnimationFrameChanged(AnimatedSprite animatedSprite, int oldFrameIndex, int newFrameIndex) {
        if (currentFrameCount <= 0 && newFrameIndex % 2 == frameIndexStep) {
            animatedSprite.stopAnimation();
            spinFinished();
        }
        currentFrameCount--;
    }

    @Override
    public void onAnimationLoopFinished(AnimatedSprite animatedSprite, int remainingLoopCount, int initialLoopCount) {
    }

    @Override
    public void onAnimationFinished(AnimatedSprite animatedSprite) {
    }

    public abstract void spinFinished();
}
