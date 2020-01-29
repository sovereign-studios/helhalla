package sovereignstudios.legendaryspoon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LegendarySpoon extends Game {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture coinImage;

    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Legendary Spoon";
        config.width = 800;
        config.height = 600;
        new LwjglApplication(new LegendarySpoon(), config);
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        batch = new SpriteBatch();
        coinImage = new Texture("coin.png");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(coinImage, 10, 10, 400, 371);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        coinImage.dispose();
    }
}
