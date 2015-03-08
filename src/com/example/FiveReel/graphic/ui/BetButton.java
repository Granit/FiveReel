package com.example.FiveReel.graphic.ui;

import com.example.FiveReel.MainActivity;
import com.example.FiveReel.utils.GameResources;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

public class BetButton extends SimpleButton {
    private  Text text;
    private String textPattern;
    public BetButton(int resourceId, MainActivity activity) {
        super(activity);
        this.textPattern = activity.getResources().getString(resourceId);
        text = new Text(100, 40, GameResources.getInstance().getFont(), textPattern, activity.getVertexBufferObjectManager());
        text.setColor(Color.BLACK);
        attachChild(text);
    }

    public void setText(String text) {
        this.text.setText(String.format(textPattern, text));
    }
}