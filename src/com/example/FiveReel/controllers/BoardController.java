package com.example.FiveReel.controllers;

import com.example.FiveReel.MainActivity;
import com.example.FiveReel.combinations.CombinationResult;
import com.example.FiveReel.combinations.GameType;
import com.example.FiveReel.gametypes.GameTypeFactory;
import com.example.FiveReel.gametypes.GameTypeManagerI;
import com.example.FiveReel.gametypes.Reel;
import com.example.FiveReel.graphic.SpinListener;
import com.example.FiveReel.graphic.ui.ButtonListener;
import com.example.FiveReel.scenes.BoardScene;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.color.Color;

public class BoardController implements SpinListener {
    private static final int REEL_COUNT = 5;
    private SimpleBaseGameActivity activity;
    private BoardScene scene;
    private CreditsController creditsController;
    //  private CombinationManagerI combinationManager;
    private GameTypeManagerI gameTypeManager;
    private GameType gameType = GameType.STANDART;

    public BoardController(MainActivity activity) {
        this.activity = activity;
        scene = new BoardScene(activity);
        scene.setListener(this);
        initCreditsController();
        //    initCombinationManager();
        initGameTypeManager();
        initReelsOnScene();
        setListeners();
        updateBetText();
        updateCreditsText();
        updateWinText(0);

    }

    private void initReelsOnScene() {
        gameTypeManager.createReels(REEL_COUNT);
        scene.initReelsCoordinates(gameTypeManager.getReelMachine().getReels());
    }

    private void initGameTypeManager() {
        gameTypeManager = GameTypeFactory.getManager(gameType);
        gameTypeManager.loadResources(activity);
        gameTypeManager.setSpinListener(this);
    }

    private void initCreditsController() {
        creditsController = new CreditsController();
    }

//    private void initCombinationManager() {
//        combinationManager = CombinationFactory.getManager(gameType);
//    }

    private void setListeners() {
        scene.getButtonBet().setListener(createButtonBetListener());
        scene.getButtonSpin().setListener(createButtonSpinListener());
        scene.getButtonBonus().setListener(createButtonBonusListener());
    }

    public BoardScene getScene() {
        return scene;
    }

    private ButtonListener createButtonBetListener() {
        return new ButtonListener() {
            public void actionUp() {
                if (!gameTypeManager.isSpinning()) {
                    bet();
                    updateSpinButton();
                }
            }
        };
    }

    private ButtonListener createButtonSpinListener() {
        return new ButtonListener() {
            public void actionUp() {
                if (!gameTypeManager.isSpinning()) {
                    spin();
                }
            }
        };
    }

    private ButtonListener createButtonBonusListener() {
        return new ButtonListener() {
            public void actionUp() {
                if (!gameTypeManager.isSpinning()) {
                    toggleGameType();
                }
            }
        };
    }

    private void toggleGameType() {
        gameType = (gameType == GameType.STANDART ? GameType.BONUS : GameType.STANDART);
        //  initCombinationManager();
        initGameTypeManager();
        detachReels();
        initReelsOnScene();
        // scene.getReelMachine().setGameType(gameType);
    }

    private void detachReels() {
        for (Reel reel : gameTypeManager.getReelMachine().getReels()) {
            scene.detachChild(reel);
        }
    }

    private void spin() {
        if (creditsController.checkPayingCapacity()) {
            creditsController.addToCredit(-creditsController.getBetSum());
            updateCreditsText();
            // scene.getReelMachine().start();
            gameTypeManager.getReelMachine().start();
        }
    }

    private void updateSpinButton() {
        boolean enable = creditsController.checkPayingCapacity();
        scene.getButtonSpin().setEnabled(enable);
        scene.getButtonSpin().setColor(enable ? Color.WHITE : Color.BLACK);
    }

    private void bet() {
        creditsController.updateBet();
        updateBetText();
    }

    private void updateBetText() {
        scene.getButtonBet().setText(String.valueOf(creditsController.getBetSum()));
    }

    private void updateCreditsText() {
        scene.getTextFieldCredits().setText(String.valueOf(creditsController.getCreditsSum()));
    }

    private void checkWinCombination() {
        //CombinationResult result = combinationManager.calculate(scene.getReelMachine().getResult());
        //CombinationResult result = gameTypeManager.calculateResult(scene.getReelMachine().getResult());
        CombinationResult result = gameTypeManager.calculateResult(gameTypeManager.getReelMachine().getResult());

        if (result.isWin()) {
            int wimSum = creditsController.getBetSum() * result.getWinMultiplier();
            creditsController.addToCredit(wimSum);
            updateWinText(wimSum);
        } else {
            updateWinText(-creditsController.getBetSum());
        }
        updateCreditsText();
        updateSpinButton();
    }

    private void updateWinText(int winSum) {
        scene.getTextField1Win().setText(String.valueOf(winSum));
    }

    @Override
    public void spinFinish() {
        checkWinCombination();
    }
}
