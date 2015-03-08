package com.example.FiveReel.scenes;

import com.example.FiveReel.MainActivity;
import com.example.FiveReel.controllers.TouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.input.touch.TouchEvent;

public class MainScene extends Scene {

//    private GameState gameState;
//    private BaseScene menuScene;
//    private BaseScene boardScene;
    private TouchListener listener;

    public MainScene(MainActivity activity) {
        setBackground(new Background(0.2f, 0.2f, 0.0f));
//        menuScene = new MenuScene(activity);
//        boardScene = new BoardScene(activity);
//        attachChild(menuScene);
//        attachChild(boardScene);
//       showMenuScene();
    }

    public void setListener(TouchListener listener) {
        this.listener = listener;
    }

    /* public void KeyPressed(int keyCode, KeyEvent event) {
        switch (gameState) {
            case MENU:
                break;
            case BOARD:
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    showMenuScene();
                }
                break;
        }
    }*/

   /* private void showMenuScene() {
        menuScene.show();
        boardScene.hide();
        gameState = GameState.MENU;
    }

    public void showBoardScene() {
        menuScene.hide();
        boardScene.show();
        gameState = GameState.BOARD;
    }*/

    @Override
    public boolean onSceneTouchEvent(TouchEvent pSceneTouchEvent) {
        return listener.onSceneTouchEvent(pSceneTouchEvent);
     /*   switch (gameState) {
            case MENU:
                return menuScene.onSceneTouchEvent(pSceneTouchEvent);
            case BOARD:
                return boardScene.onSceneTouchEvent(pSceneTouchEvent);
        }
        return super.onSceneTouchEvent(pSceneTouchEvent);*/
    }
}
