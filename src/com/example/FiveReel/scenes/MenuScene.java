package com.example.FiveReel.scenes;

import com.example.FiveReel.MainActivity;
import com.example.FiveReel.R;
import com.example.FiveReel.graphic.ui.MenuButton;

public class MenuScene extends BaseScene {
    private MenuButton buttonGame;
    private MenuButton buttonExit;

    public MenuScene(MainActivity activity) {
        super(activity);
        buttonGame = new MenuButton(R.string.game, activity);
        buttonGame.setPosition((activity.getCamera().getWidth()) / 2, activity.getCamera().getHeight() / 2 + 200);
        registerTouchArea(buttonGame);
        buttonExit = new MenuButton(R.string.exit, activity);
        buttonExit.setPosition((activity.getCamera().getWidth()) / 2, activity.getCamera().getHeight() / 2 - 25);
        registerTouchArea(buttonExit);

        attachChild(buttonGame);
        attachChild(buttonExit);

        //  buttonGame.setListener(createButtonGameListener());
        //  buttonExit.setListener(createButtonExitListener());
        setTouchAreaBindingOnActionDownEnabled(true);
    }

    public MenuButton getButtonGame() {
        return buttonGame;
    }

    public MenuButton getButtonExit() {
        return buttonExit;
    }
/*  private ButtonListener createButtonGameListener() {
        return new ButtonListener() {
            public void actionUp() {
                activity.getMainScene().showBoardScene();
            }
        };
    }

    private ButtonListener createButtonExitListener() {
        return new ButtonListener() {
            public void actionUp() {
                activity.closeActivity();
            }
        };
    }*/
}
