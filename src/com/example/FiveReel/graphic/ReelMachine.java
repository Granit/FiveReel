package com.example.FiveReel.graphic;

import com.example.FiveReel.combinations.SpinResult;
import com.example.FiveReel.gametypes.Reel;
import com.example.FiveReel.utils.LogUtils;
import com.example.FiveReel.utils.SpinParams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReelMachine implements SpinListener {

    private static final int FRAME_START = 7;
    private static final int FRAME_OFFSET = 14;
    private static final int FRAME_DURATION_START = 40;
    private static final int FRAME_DURATION_OFFSET = 8;
    //    private List<SpinParams> spinParams;
    // private List<ReelSpin> reels;
    private List<Reel> reels;
    private boolean spinning;
    private SpinListener listener;

    public ReelMachine() {
        // reels = new ArrayList<ReelSpin>();
        reels = new ArrayList<Reel>();
        spinning = Boolean.FALSE;
//        spinParams = new ArrayList<SpinParams>();
    }

//    public void addReel(ReelSpin reelSpin) {
//        reelSpin.setListener(this);
//        this.reels.add(reelSpin);
//}

    public void addReel(Reel reel) {
        reel.setListener(this);
        this.reels.add(reel);
    }

//    public List<ReelSpin> getReels() {
//        return reels;
//    }


    public List<Reel> getReels() {
        return reels;
    }

    public void start() {
        if (!spinning) {
            spinning = Boolean.TRUE;
            List<SpinParams> params = generateSpinParams();
            for (int i = 0; i < reels.size(); i++) {
                reels.get(i).animate(params.get(i));
            }
        }
    }

    @Override
    public void spinFinish() {
        //  for (ReelSpin reel : reels) {
        for (Reel reel : reels) {
            if (reel.isSpinning()) {
                return;
            }
        }
        spinning = Boolean.FALSE;
        listener.spinFinish();
    }

    public void setListener(SpinListener listener) {
        this.listener = listener;
    }

    private List<SpinParams> generateSpinParams() {
        List<SpinParams> params = new ArrayList<SpinParams>();
        int start = FRAME_START;
        int end;
        long frameDuration = FRAME_DURATION_START;
        Random r = new Random();
        for (int i = 0; i < reels.size(); i++) {
            end = start + FRAME_OFFSET;
            SpinParams param = new SpinParams();
            int frameCount = r.nextInt(end - start) + start;
            param.setFrameCount(frameCount);
            param.setFrameDuration(frameDuration);
            params.add(param);
            start = frameCount;
            frameDuration += FRAME_DURATION_OFFSET;
        }
        return params;
    }

    public SpinResult getResult() {
        SpinResult result = new SpinResult();
        // for (ReelSpin reel : reels) {
        for (Reel reel : reels) {
            result.addSelectedElement(reel.getCurrentTileIndex() / 2);
        }
        return result;
    }

    public boolean isSpinning() {
        return spinning;
    }
}
