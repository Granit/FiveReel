package com.example.FiveReel.controllers;

import com.example.FiveReel.MainActivity;
import com.example.FiveReel.graphic.ui.ButtonListener;
import com.example.FiveReel.scenes.BaseScene;
import com.example.FiveReel.scenes.MenuScene;

public class MenuController {
    private MainActivity activity;
    private MenuScene scene;

    public MenuController(MainActivity activity) {
        this.activity = activity;
        scene = new MenuScene(activity);
        initListeners();
    }

    private void initListeners() {
        scene.getButtonGame().setListener(createButtonGameListener());
        scene.getButtonExit().setListener(createButtonExitListener());
    }

    public BaseScene getScene() {
        return scene;
    }

    private ButtonListener createButtonGameListener() {
        return new ButtonListener() {
            public void actionUp() {
                activity.getMainController().showBoardScene();
            }
        };
    }

    private ButtonListener createButtonExitListener() {
        return new ButtonListener() {
            public void actionUp() {
                activity.closeActivity();
            }
        };
    }
}
