package com.example.FiveReel;

import android.view.Display;
import android.view.KeyEvent;
import com.example.FiveReel.controllers.MainController;
import com.example.FiveReel.utils.GameResources;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.util.FPSLogger;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.io.IOException;

public class MainActivity extends SimpleBaseGameActivity {

    // private MainScene mainScene;
    private Camera camera;
    private MainController mainController;

    @Override
    protected void onCreateResources() throws IOException {
        GameResources.getInstance().loadButtons(this);
        GameResources.getInstance().loadFonts(this);
    }

    @Override
    protected Scene onCreateScene() {
       // mainScene = new MainScene(this);
        mainController = new MainController(this);
        mEngine.registerUpdateHandler(new FPSLogger());
        return mainController.getScene();
     //   return mainScene;
    }

    public EngineOptions onCreateEngineOptions() {
        final Display display = getWindowManager().getDefaultDisplay();
        int cameraWidth = display.getWidth();
        int cameraHeight = display.getHeight();
        camera = new Camera(0, 0, cameraWidth, cameraHeight);
        return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(cameraWidth, cameraHeight), camera);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void closeActivity() {
        finish();
    }

    public Camera getCamera() {
        return camera;
    }

    public MainController getMainController() {
        return mainController;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mainController.KeyPressed(keyCode, event);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
