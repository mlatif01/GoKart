package com.latif.gokart;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/*
a pixmap is a 2d array which holds info about pixels of an image.
 */
public class PixMap3D extends Pixmap {

  private Texture pixmapTex;
  private int horizon;
  public double angle;
  private Pixmap grass;
  public Vector3 pos;
  public Vector3 scale;

  public PixMap3D(int width, int height, Format format) {
    super(width, height, format);
    // how to place the pixels relative to each other
    setFilter(Filter.NearestNeighbour);
    pixmapTex = new Texture(this, getFormat(), true);
    pixmapTex = new Texture(this, getFormat(), true);
    // pixels from the top of the screen
    horizon = 30;
    grass = new Pixmap(new FileHandle("grass.png"));
    // the theoretical position in the world
    pos = new Vector3(903, 768, 16);
    scale = new Vector3(300, 300, 16);
    angle = 2;
  }

  public void render(SpriteBatch batch) {
    drawGround();
    pixmapTex.draw(this, 0, 0);
    batch.draw(pixmapTex, 0, 0);
  }

  private void drawGround() {
    double dirx = Math.cos(angle);
    double diry = Math.sin(angle);

    for (int screeny = horizon; screeny < getHeight(); screeny++) {
      double distanceInWorldSpace = pos.z * scale.y / ((double) screeny - horizon);
      double deltax = -diry * (distanceInWorldSpace / scale.x);
      double deltay = dirx * (distanceInWorldSpace / scale.y);

      double spacex = pos.x + dirx * distanceInWorldSpace - getWidth() / 2 * deltax;
      double spacey = pos.y + diry * distanceInWorldSpace - getHeight() / 2 * deltay;

      for(int screenx = 0; screenx < getWidth(); screenx++) {
        setColor(grass.getPixel(((int) Math.abs(spacex % grass.getWidth())), (int) Math.abs(spacey % grass.getHeight())));
        drawPixel(screenx, screeny);

        spacex += deltax;
        spacey += deltay;
      }
    }
  }

}
