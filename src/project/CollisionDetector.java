package project;

import java.util.ArrayList;

public class CollisionDetector {
	public static void checkCollision(ArrayList<Entity> entities, Level level) {
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			// xi and yi are initial bounding box positions
			double xi = entity.getX();
			double yi = entity.getY();
			// xf and yf are final bounding box positions
			double xf = xi + entity.getxVel();
			double yf = yi + entity.getyVel();
		}
	}
}
