package com.example.FiveReel.scenes;

import com.example.FiveReel.MainActivity;
import com.example.FiveReel.R;
import com.example.FiveReel.gametypes.Reel;
import com.example.FiveReel.graphic.ReelSpin;
import com.example.FiveReel.graphic.SpinListener;
import com.example.FiveReel.graphic.ui.BetButton;
import com.example.FiveReel.graphic.ui.BonusButton;
import com.example.FiveReel.graphic.ui.SpinButton;
import com.example.FiveReel.graphic.ui.TextField;
import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.primitive.Rectangle;

import java.util.List;

public class BoardScene extends BaseScene implements SpinListener {

    private static final int FIELD_CELL_SIZE = 130;
    private static final int REEL_COUNT = 5;
    //  private ReelMachine reelMachine;
    private float topX = (activity.getCamera().getWidth() - 5 * FIELD_CELL_SIZE - 4 * 10) / 2 + FIELD_CELL_SIZE / 2;
    private float bottomY = FIELD_CELL_SIZE * 3;

    private BetButton buttonBet;
    private SpinButton buttonSpin;
    private BonusButton buttonBonus;
    private TextField textField1Win;
    private TextField textFieldCredits;
    private SpinListener listener;

    public BoardScene(MainActivity activity) {
        super(activity);
        initReelsBackgroundRectangle();
        initButtons();
        initTextFields();
      //  initReelMachine();
    }

    public void setListener(SpinListener listener) {
        this.listener = listener;
    }

    private void initReelsBackgroundRectangle() {
        IEntity wrapper = new Entity(0, 0);
        float x;
        x = topX;
        for (int i = 0; i < REEL_COUNT; i++) {
            Rectangle r = new Rectangle(x, 960, FIELD_CELL_SIZE, bottomY, activity.getVertexBufferObjectManager());
            wrapper.attachChild(r);
            x = x + FIELD_CELL_SIZE + 10;
        }
        attachChild(wrapper);
    }

    private void initButtons() {
        initButtonBet();
        initButtonSpin();
        initButtonBonus();
    }

    private void initButtonBet() {
        buttonBet = new BetButton(R.string.bet, activity);
        buttonBet.setPosition(activity.getCamera().getWidth() / 2 - 250, activity.getCamera().getHeight() / 2 - 150);
        buttonBet.setAnchorCenter(0, 0);
        registerTouchArea(buttonBet);
        attachChild(buttonBet);
    }

    private void initButtonSpin() {
        buttonSpin = new SpinButton(R.string.spin, activity);
        buttonSpin.setPosition(activity.getCamera().getWidth() / 2 + 50, activity.getCamera().getHeight() / 2 - 250);
        buttonSpin.setAnchorCenter(0, 0);
        registerTouchArea(buttonSpin);
        attachChild(buttonSpin);
    }

    private void initButtonBonus() {
        buttonBonus = new BonusButton(R.string.bonus_game, activity);
        buttonBonus.setPosition(activity.getCamera().getWidth() / 2 - 250, activity.getCamera().getHeight() / 2 - 250);
        buttonBonus.setAnchorCenter(0, 0);
        registerTouchArea(buttonBonus);
        attachChild(buttonBonus);
    }

    private void initTextFields() {
        textField1Win = new TextField(activity.getCamera().getWidth() / 2 - 250, activity.getCamera().getHeight() / 2, 200, 80, R.string.win, activity);
        attachChild(textField1Win);
        textFieldCredits = new TextField(activity.getCamera().getWidth() / 2 + 50, activity.getCamera().getHeight() / 2, 200, 80, R.string.credits, activity);
        attachChild(textFieldCredits);
    }

    /*private void initReelMachine() {
        //  GameResources.getInstance().loadReelSpinStandart(activity);
        //  GameResources.getInstance().loadReelSpinBonus(activity);
        //  reelMachine = new ReelMachine();
        //   reelMachine.setListener(this);
        float x = topX;
        for (int i = 0; i < REEL_COUNT; i++) {
            reelMachine.addReel(createReel(x, activity.getCamera().getHeight() * 3 / 4));
            x = x + FIELD_CELL_SIZE + 10;
        }
        List<ReelSpin> reels = reelMachine.getReels();
        for (ReelSpin reel : reels) {
            attachChild(reel);
        }
    }*/
    public void initReelsCoordinates(List<Reel> reels) {
        float x = topX;
        float y = activity.getCamera().getHeight() * 3 / 4;
        for (Reel reel : reels) {
            reel.setPosition(x, y);
            attachChild(reel);
            x = x + FIELD_CELL_SIZE + 10;
        }
    }

  /*  private ReelSpin createReel(float x, float y) {
        ReelSpin reelSpin = new ReelSpin(activity);
        reelSpin.setPosition(x, y);
        return reelSpin;
    }*/

    @Override
    public void spinFinish() {
        listener.spinFinish();
    }

    public BetButton getButtonBet() {
        return buttonBet;
    }

    public SpinButton getButtonSpin() {
        return buttonSpin;
    }

    public TextField getTextField1Win() {
        return textField1Win;
    }

    public TextField getTextFieldCredits() {
        return textFieldCredits;
    }

//    public ReelMachine getReelMachine() {
//        return reelMachine;
//    }

    public BonusButton getButtonBonus() {
        return buttonBonus;
    }
}
