package com.example.FiveReel.graphic.ui;

import com.example.FiveReel.MainActivity;
import com.example.FiveReel.utils.GameResources;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;


public class TextField extends Rectangle {
    private Text text;

    public TextField(float pX, float pY, float pWidth, float pHeight, int titleResourceId, MainActivity activity) {
        super(pX, pY, pWidth, pHeight, activity.getVertexBufferObjectManager());
        setAnchorCenter(0, 0);
        createTitle(titleResourceId, activity);
        createText(activity);

    }

    private void createTitle(int titleResourceId, MainActivity activity) {
        Text title = new Text(0, 0, GameResources.getInstance().getFont(), activity.getResources().getString(titleResourceId), 8, activity.getVertexBufferObjectManager());
        title.setAnchorCenter(0, 1);
        title.setColor(Color.GREEN);
        attachChild(title);
    }

    private void createText(MainActivity activity) {
        text = new Text(0, 0, GameResources.getInstance().getFontDefault(), "1234567", 7, activity.getVertexBufferObjectManager());
        text.setAnchorCenter(0, 0);
        text.setColor(Color.RED);
        attachChild(text);
    }

    public void setText(String text) {
        this.text.setText(text);
    }
}
