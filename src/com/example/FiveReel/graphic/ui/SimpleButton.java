package com.example.FiveReel.graphic.ui;

import com.example.FiveReel.MainActivity;
import com.example.FiveReel.utils.GameResources;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.input.touch.TouchEvent;

public abstract class SimpleButton extends ButtonSprite {

    protected ButtonListener listener;


    public SimpleButton(MainActivity activity) {
        super(0, 0, GameResources.getInstance().getButtonRectangleRegion(), activity.getVertexBufferObjectManager());
    }

    public void setListener(ButtonListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
        switch (pSceneTouchEvent.getAction()) {
            case TouchEvent.ACTION_DOWN:
                this.setCurrentTileIndex(1);
                break;
            case TouchEvent.ACTION_UP:
                this.setCurrentTileIndex(0);
                listener.actionUp();
        }
        return true;
    }
}