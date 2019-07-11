package com.latif.gokart.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.latif.gokart.GoKart;
import com.latif.gokart.PlayScreen;

public class DesktopLauncher {

	// creates new instance of game and launches it as a lwjgl, with lib gdx built on top of it
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GoKart(), config);

		config.resizable = false;
		config.height = PlayScreen.V_HEIGHT * 3;
		config.width = PlayScreen.V_WIDTH * 3;
	}

}
