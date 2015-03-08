package com.example.FiveReel.utils;

import android.graphics.Color;
import android.graphics.Typeface;
import com.example.FiveReel.MainActivity;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public class GameResources {

    private static GameResources gameResources;
    private Font fontDefault;
    private Font font;
    private ITextureRegion backgroundRegion;
    private TiledTextureRegion buttonRectangleRegion;
    private TiledTextureRegion reelSpinStandartRegion;
    private TiledTextureRegion reelSpinBonusRegion;

    public static GameResources getInstance() {
        if (gameResources == null) {
            gameResources = new GameResources();
        }
        return gameResources;

    }

    public void loadBackground(MainActivity activity) {
        BitmapTextureAtlas atlas = new BitmapTextureAtlas(activity.getTextureManager(), 600, 960);
        backgroundRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(atlas, activity, "gfx/background.png", 0, 0);
        atlas.load();
    }

    public ITextureRegion getBackgroundRegion() {
        return backgroundRegion;
    }

    public void loadFonts(MainActivity activity) {
        fontDefault = new Font(activity.getFontManager(), createFontAtlas(activity.getTextureManager()), Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 45, true, Color.WHITE);
        activity.getFontManager().loadFont(fontDefault);
        font = FontFactory.createFromAsset(activity.getFontManager(), createFontAtlas(activity.getTextureManager()), activity.getAssets(), "fonts/AxeHandel.ttf", 32, true, Color.WHITE);
        activity.getFontManager().loadFont(font);
    }

    public Font getFontDefault() {
        return fontDefault;
    }

    public Font getFont() {
        return font;
    }

    public void loadButtons(MainActivity activity) {
        loadButtonRectangle(activity);
    }

    private void loadButtonRectangle(MainActivity activity) {
        BitmapTextureAtlas buttonAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 204, 250, TextureOptions.NEAREST);
        buttonRectangleRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(buttonAtlas, activity.getAssets(), "gfx/button_tile.png", 0, 0, 1, 3);
        buttonAtlas.load();
    }

    public TiledTextureRegion getButtonRectangleRegion() {
        return buttonRectangleRegion;
    }

    private BitmapTextureAtlas createFontAtlas(TextureManager textureManager) {
        BitmapTextureAtlas atlas = new BitmapTextureAtlas(textureManager, 256, 256, TextureOptions.NEAREST_PREMULTIPLYALPHA);
        atlas.load();
        return atlas;
    }

    public void loadReelSpinStandart(SimpleBaseGameActivity activity) {
        if (reelSpinStandartRegion == null) {
            BuildableBitmapTextureAtlas atlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 850, 700, TextureOptions.NEAREST);
            reelSpinStandartRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(atlas, activity, "gfx/reelspin_standart.png", 7, 2);
            try {
                atlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 1));
                atlas.load();
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException ex) {
                LogUtils.e("load spin bonus ", ex);
                throw new RuntimeException(ex);
            }
        }
    }

    public TiledTextureRegion getReelSpinStandartRegion() {
        return reelSpinStandartRegion;
    }

    public void loadReelSpinBonus(SimpleBaseGameActivity activity) {
        if (reelSpinBonusRegion == null) {
            BuildableBitmapTextureAtlas atlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 850, 700, TextureOptions.NEAREST);
            reelSpinBonusRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(atlas, activity, "gfx/reelspin_bonus.png", 7, 2);
            try {
                atlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 1));
                atlas.load();
            } catch (ITextureAtlasBuilder.TextureAtlasBuilderException ex) {
                LogUtils.e("load spin standart ", ex);
                throw new RuntimeException(ex);
            }
        }
    }

    public TiledTextureRegion getReelSpinBonusRegion() {
        return reelSpinBonusRegion;
    }
}
