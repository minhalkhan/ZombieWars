package com.elite.ui;

import com.badlogic.gdx.Game;
import com.elite.ui.menu.HomeScreen;

/**
 * Launches the game UI and the HomeScreen
 *
 * @author Will Goodman
 */
public class LaunchUI extends Game {

    /**
     * Sets the screen to the HomeScreen
     */
    @Override
    public void create() {
        setScreen(new HomeScreen());
    }

}
