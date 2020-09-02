package sovereignstudios.helhalla.screens.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Logger;
import sovereignstudios.helhalla.Helhalla;
import sovereignstudios.helhalla.assets.AssetDescriptors;
import sovereignstudios.helhalla.assets.RegionNames;


public class menuScreen extends menuScreenBase {

    private static final Logger log = new Logger(menuScreen.class.getName(), Logger.DEBUG);


    public menuScreen(Helhalla game) {
        super(game);
    }

    @Override
    protected Actor createUi() {
        Table table = new Table();

        TextureAtlas menuAtlas = assetManager.get(AssetDescriptors.MENU);
        Skin uiSkin = assetManager.get(AssetDescriptors.UI_SKIN);

        TextureRegion backgroundRegion = menuAtlas.findRegion(RegionNames.MENU_BACKGROUND);
        table.setBackground(new TextureRegionDrawable(backgroundRegion));

        // Play Button
        TextButton playButton = new TextButton("PLAY", uiSkin);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                play();
            }
        });

        // Settings Button
        TextButton settingsButton = new TextButton("OPTIONS", uiSkin);
        settingsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
//                showOptions();
            }
        });

        // Quit Button
        TextButton quitButton = new TextButton("QUIT", uiSkin);
        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                quit();
            }
        });

        // Setup Table
        Table buttonTable = new Table(uiSkin);
        buttonTable.defaults().pad(20);

        buttonTable.add(playButton).row();
        buttonTable.add(settingsButton).row();
        buttonTable.add(quitButton).row();

        buttonTable.center();

        table.add(buttonTable);
        table.center();
        table.setFillParent(true);
        table.pack();

        return table;
    }
    private void play() {
//        game.setScreen(new gameScreen(game));
    }


    private void quit() {
        Gdx.app.exit();
    }

}
