package com.latif.gokart;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
ScreenAdapter - Convenience implementation of Screen. Derive from this and only override what you need.
 */
public class PlayScreen extends ScreenAdapter {

  // Virtual width and height for the game - resolution of the super nintendo
  public static final int V_WIDTH = 256;
  public static final int V_HEIGHT = 224;

  // holds instance of our Game
  private Game game;
  // holds instance of sprite batch
  private SpriteBatch batch;
  // a basic game camera to look at our world
  private OrthographicCamera camera;
  // instance of pixmap
  private PixMap3D pixmap;

  // Constructor for PlayScreen
  public PlayScreen(Game game, SpriteBatch batch) {
    // initialise instance of game
    this.game = game;
    this.batch = batch;
  }

  // Runs after class is created but before first render loop
  @Override
  public void show() {
    camera = new OrthographicCamera(V_WIDTH, V_HEIGHT);
    camera.position.set(V_WIDTH/ 2, V_HEIGHT / 2, 0);
    camera.update();

    pixmap = new PixMap3D(V_WIDTH, V_HEIGHT, Pixmap.Format.RGB565);
  }

  @Override
  public void render(float delta) {
    // clears the screen to black
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    // tell sprite batch what to project to
    batch.setProjectionMatrix(camera.combined);
    handleInput();
    camera.update();

    batch.begin();
    pixmap.render(batch);

    batch.end();
  }

  // handles key presses
  private void handleInput() {

  }


  @Override
  public void dispose() {
    super.dispose();
  }

  // Holds logic when resizing window
  @Override
  public void resize(int width, int height) {
    super.resize(width, height);
  }


}
