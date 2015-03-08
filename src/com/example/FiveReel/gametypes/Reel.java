package com.example.FiveReel.gametypes;

import com.example.FiveReel.graphic.SpinAnimationListener;
import com.example.FiveReel.graphic.SpinListener;
import com.example.FiveReel.utils.GameResources;
import com.example.FiveReel.utils.SpinParams;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public abstract class Reel extends AnimatedSprite implements ReelI {
    private SpinListener listener;

    public Reel(SimpleBaseGameActivity activity, TiledTextureRegion textureRegion) {
        super(0f, 0f, textureRegion.deepCopy(), activity.getVertexBufferObjectManager());
    }

    public void setListener(SpinListener listener) {
        this.listener = listener;
    }

    public abstract void animate(SpinParams params);

    public boolean isSpinning() {
        return isAnimationRunning();
    }

    protected SpinAnimationListener createAnimationListener(int frameCount, int frameIndexStep) {
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
