package com.example.FiveReel.graphic.ui;


import com.example.FiveReel.MainActivity;
import com.example.FiveReel.utils.GameResources;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

public class BonusButton extends SimpleButton {

    public BonusButton(int resourceId, MainActivity activity) {
        super(activity);
        Text t = new Text(100, 40, GameResources.getInstance().getFont(), activity.getResources().getString(resourceId), activity.getVertexBufferObjectManager());
        t.setColor(Color.BLACK);
        attachChild(t);
    }
}
