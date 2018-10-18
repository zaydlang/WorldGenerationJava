package project;

public class Player extends Entity {
	public Player(double x, double y, double width, double height, double xVel, double yVel) {
		super(x, y, width, height, xVel, yVel, Constants.PLAYER_COLOR);
	}
	
	@Override
	public void update(boolean[] keyMap) {
		super.update(keyMap);
		
		setxVel(0);
		setyVel(0);
		
		if (keyMap[37] && !keyMap[39]) {
			setxVel(1);
		}
		
		if (keyMap[39] && !keyMap[37]) {
			setxVel(-1);
		}
	}
}
