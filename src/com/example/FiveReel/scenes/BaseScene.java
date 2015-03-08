package com.example.FiveReel.scenes;

import com.example.FiveReel.MainActivity;
import com.example.FiveReel.utils.GameResources;
import org.andengine.entity.scene.CameraScene;
import org.andengine.entity.sprite.Sprite;

public class BaseScene extends CameraScene {

    protected MainActivity activity;

    public BaseScene(MainActivity activity) {
        super(activity.getCamera());
        this.activity = activity;
        GameResources.getInstance().loadBackground(activity);
        Sprite backgroundSprite = new Sprite(0, 0, activity.getCamera().getWidth() * 2, activity.getCamera().getHeight() * 2, GameResources.getInstance().getBackgroundRegion(),
                activity.getVertexBufferObjectManager());
        attachChild(backgroundSprite);
    }

    public void show() {
        setVisibility(true);
    }

    public void hide() {
        setVisibility(false);
    }

    private void setVisibility(boolean value) {
        setVisible(value);
        setIgnoreUpdate(!value);

    }
}
