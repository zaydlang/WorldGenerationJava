package project;

import java.awt.Color;

public abstract class Entity {
	private double x;
	private double y;
	private double width;
	private double height;
	private double xVel;
	private double yVel;
	private Color color;
	
	private double lastUpdate;
	
	public Entity(double x, double y, double width, double height, double xVel, double yVel, Color color) {
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setxVel(xVel);
		this.setyVel(yVel);
		this.setColor(color);
		lastUpdate = System.currentTimeMillis();
	}
	
	public void update(boolean[] keyMap) {
		double dt = System.currentTimeMillis() - lastUpdate;
		lastUpdate = System.currentTimeMillis();
		x += xVel * dt;
		y += yVel * dt;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getxVel() {
		return xVel;
	}

	public void setxVel(double xVel) {
		this.xVel = xVel;
	}

	public double getyVel() {
		return yVel;
	}

	public void setyVel(double yVel) {
		this.yVel = yVel;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
