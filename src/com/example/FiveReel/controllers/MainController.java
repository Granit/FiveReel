package com.example.FiveReel.controllers;

import android.view.KeyEvent;
import com.example.FiveReel.MainActivity;
import com.example.FiveReel.scenes.MainScene;
import com.example.FiveReel.utils.GameResources;
import com.example.FiveReel.utils.GameState;
import org.andengine.input.touch.TouchEvent;

public class MainController implements TouchListener {

    private GameState gameState;
    private MenuController menuController;
    private BoardController boardController;
    private MainScene scene;

    public MainController(MainActivity activity) {
        GameResources.getInstance().loadBackground(activity);
        menuController = new MenuController(activity);
        boardController = new BoardController(activity);
        scene = new MainScene(activity);
        scene.setListener(this);
        scene.attachChild(menuController.getScene());
        scene.attachChild(boardController.getScene());
        showMenuScene();
    }

    public void showMenuScene() {
        menuController.getScene().show();
        boardController.getScene().hide();
        gameState = GameState.MENU;
    }

    public void showBoardScene() {
        menuController.getScene().hide();
        boardController.getScene().show();
        gameState = GameState.BOARD;
    }

    public MainScene getScene() {
        return scene;
    }

    public void KeyPressed(int keyCode, KeyEvent event) {
        switch (gameState) {
            case MENU:
                break;
            case BOARD:
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    showMenuScene();
                }
                break;
        }
    }

    @Override
    public boolean onSceneTouchEvent(TouchEvent sceneTouchEvent) {
        switch (gameState) {
            case MENU:
                return menuController.getScene().onSceneTouchEvent(sceneTouchEvent);
            case BOARD:
                return boardController.getScene().onSceneTouchEvent(sceneTouchEvent);
        }
        return false;
    }
}
