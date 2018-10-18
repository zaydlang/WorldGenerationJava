package project;

import java.awt.Color;

public final class Constants {
	// Display.java
	public static final int DISPLAY_WIDTH  = 800;
	public static final int DISPLAY_HEIGHT = 600;
	
	// LevelBuilder.java
	public static final int LEVEL_ROWS          = 80;
	public static final int LEVEL_COLUMNS       = 60;
	public static final int MIN_NEIGHBORS_ALIVE = 4;
	public static final int MAX_NEIGHBORS_ALIVE = 8;
	
	// Player.java
	public static final Color PLAYER_COLOR              = Color.GREEN;
	public static final double PLAYER_ACCELERATION_X    = 0.1;
	public static final double PLAYER_MAX_SPEED_X       = 1;
	public static final double PLAYER_ACCELERATION_JUMP = 1;
}
