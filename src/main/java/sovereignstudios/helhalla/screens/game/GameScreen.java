package sovereignstudios.helhalla.screens.game;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import sovereignstudios.helhalla.Helhalla;
import sovereignstudios.helhalla.assets.AssetDescriptors;
import sovereignstudios.helhalla.config.GameConfig;
import sovereignstudios.helhalla.util.GdxUtils;


public class GameScreen implements Screen {

    private static final Logger log = new Logger(GameScreen.class.getName(), Logger.DEBUG);
    private static final Boolean DEBUG = false;

    private final AssetManager assetManager;
    private final Helhalla game;

    private OrthographicCamera camera;
    private Viewport viewport;
    private Viewport hudViewPort;
    private ShapeRenderer renderer;
    private PooledEngine engine;
//    private EntityFactory factory;
    private Sound hit;
    private boolean reset;

    public GameScreen(Helhalla game) {
        this.game = game;
        assetManager = game.getAssetManager();
    }

    @Override
    public void show() {
        log.debug("Show()");
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
        hudViewPort = new FitViewport(GameConfig.HUD_WIDTH, GameConfig.HUD_HEIGHT);
        renderer = new ShapeRenderer();
        engine = new PooledEngine();
//        factory = new EntityFactory(engine, assetManager);

        BitmapFont font = assetManager.get(AssetDescriptors.FONT);

//        CollisionListener listener = new CollisionListener() {
//            @Override
//            public void hitObstacle() {
//                GameManager.INSTANCE.decrementLives();
//                hit.play();
//
//                if (GameManager.INSTANCE.isGameOver()){
//                    engine.removeAllEntities();
//                    reset = true;
//                }
//            }
//        };

//        engine.addSystem(new PlayerSystem());
//        engine.addSystem(new MovementSystem());
//        engine.addSystem(new WorldWrapSystem(viewport));
//        engine.addSystem(new BoundsSystem());
//        engine.addSystem(new CleanUpSystem());
//        engine.addSystem(new CollisionSystem(listener));

//        engine.addSystem(new RenderSystem(viewport, game.getBatch()));
//
//        if (DEBUG) {
//            engine.addSystem(new GridRenderSystem(viewport, renderer));
//            engine.addSystem(new DebugRenderSystem(viewport, renderer));
//            engine.addSystem(new DebugCameraSystem(camera,
//                    GameConfig.WORLD_CENTRE_X, GameConfig.WORLD_CENTRE_Y));
//        }

//        engine.addSystem(new HudRenderSystem(hudViewPort, game.getBatch(), font));
//
//        addEntities();
    }

    @Override
    public void render(float delta) {
        GdxUtils.clearScreen();
        engine.update(delta);

//        if (GameManager.INSTANCE.isGameOver()){
//            GameManager.INSTANCE.reset();
//            game.setScreen(new menuScreen(game));
//        }
//
//        if (reset) {
//            reset = false;
//            addEntities();
//        }

    }

//    private void addEntities() {
//        factory.addBackground();
//        factory.addPlayer();
//    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
        hudViewPort.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
