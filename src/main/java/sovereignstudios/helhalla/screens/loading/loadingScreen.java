package sovereignstudios.helhalla.screens.loading;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import sovereignstudios.helhalla.Helhalla;
import sovereignstudios.helhalla.assets.AssetDescriptors;
import sovereignstudios.helhalla.config.GameConfig;
import sovereignstudios.helhalla.screens.menu.menuScreen;
import sovereignstudios.helhalla.util.GdxUtils;

public class loadingScreen extends ScreenAdapter {

    //== Constants
    private static final float PROGRESS_BAR_WIDTH = GameConfig.HUD_WIDTH / 2f; // World units
    private static final float PROGRESS_BAR_HEIGHT = 60; // World units

    //== Attributes
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;

    private float progress;
    private float waitTime = 0.75f;
    private boolean changeScreen;


    private final Helhalla game;
    private final AssetManager assetManager;

    //== Constructor

    public loadingScreen(Helhalla game) {
        this.game = game;
        assetManager = game.getAssetManager();
    }

    //== Public Methods

    @Override
    public void render(float delta) {
        update(delta);

        GdxUtils.clearScreen();
        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        draw();

        renderer.end();

        if (changeScreen) {
            game.setScreen(new menuScreen(game));
        }
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.HUD_WIDTH, GameConfig.HUD_HEIGHT, camera);
        renderer = new ShapeRenderer();

        // Load assets here
        assetManager.load(AssetDescriptors.FONT);
        assetManager.load(AssetDescriptors.MENU);
//        assetManager.load(AssetDescriptors.GAME_PLAY);
        assetManager.load(AssetDescriptors.UI_SKIN);

    }

    @Override
    public void hide() {
        // Note; Screens don't dispose automatically.
        dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
        renderer = null;
    }

    //== Private methods ==\\
    private void update(float delta) {
        // Progress is between 0 and 1;
        progress = assetManager.getProgress();

        // Update returns true when all assets are loaded
        if (assetManager.update()) {
            waitTime -= delta;

            if (waitTime <= 0) {
                changeScreen = true;
            }
        }
    }

    private void draw() {
        float progressBarX = (GameConfig.HUD_WIDTH - PROGRESS_BAR_WIDTH) / 2f;
        float progressBarY = (GameConfig.HUD_HEIGHT - PROGRESS_BAR_HEIGHT) / 2f;

        renderer.rect(progressBarX, progressBarY,
                progress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT);
    }

    private static void waitMilis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
