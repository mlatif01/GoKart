package com.latif.gokart;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/* Game is the main class libgdx uses which is passed around to other classes in order to delegate
screen */

public class GoKart extends Game {
  
  // handles rendering - all of the drawing is done in the sprite batch
  SpriteBatch batch;

  // An instance of the PlayScreen which will be passed to the active screen
  private PlayScreen playScreen;


  // Runs before the render loop
  @Override
  public void create() {
    batch = new SpriteBatch();
    // create instance of PlayScreen and pass game and batch
    playScreen = new PlayScreen(this, batch);
    // set playScreen as the active screen using the method from the Game class which is inherited
    setScreen(playScreen);
  }

  /*
  Main game loop for the game
   */
  @Override
  public void render() {
    super.render();
  }

  // Disposes of assets - prevents memory leaks. Called once the class is no longer needed.
  // Will be called after the game is closed.
  @Override
  public void dispose() {
    batch.dispose();
  }
}
