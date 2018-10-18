package project;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Display extends JFrame {
	private static final long serialVersionUID = 1L;
	private static LevelComponent currentLevel;
	
	public Display() {
		currentLevel = new LevelComponent();
		add(currentLevel);
		setTitle("Infiltration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(Constants.DISPLAY_WIDTH, Constants.DISPLAY_HEIGHT));
		pack();
		setVisible(true);
	}
	
	public void setEntities(ArrayList<Entity> entities) {
		currentLevel.setEntities(entities);
	}
	
	public void setLevel(Level level) {
		currentLevel.setLevel(level);
	}
	
	public void draw() {
		currentLevel.repaint();
	}
}

class LevelComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	private Level level;
	private ArrayList<Entity> entities;
	
	public LevelComponent() {
		entities = new ArrayList<Entity>();
		setPreferredSize(new Dimension(Constants.DISPLAY_WIDTH, Constants.DISPLAY_HEIGHT));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < Constants.LEVEL_ROWS; i++) {
			for (int j = 0; j < Constants.LEVEL_COLUMNS; j++) {
				Block currentBlock = level.get(i, j);
				g.setColor(currentBlock.getColor());
		        g.fillRect((int) Math.floor(Constants.DISPLAY_WIDTH - ((i + 1) * Constants.DISPLAY_WIDTH / Constants.LEVEL_ROWS)), 
		        		   (int) Math.floor(Constants.DISPLAY_HEIGHT - ((j + 1) * Constants.DISPLAY_HEIGHT / Constants.LEVEL_COLUMNS)), 
		        		   (int) Math.floor(Constants.DISPLAY_WIDTH / Constants.LEVEL_ROWS), 
		        		   (int) Math.floor(Constants.DISPLAY_HEIGHT / Constants.LEVEL_COLUMNS));
			}
		}
		
		for (int i = 0; i < entities.size(); i++) {
			Entity currentEntity = entities.get(i);
			g.setColor(currentEntity.getColor());
			g.fillRect((int) Math.floor(Constants.DISPLAY_WIDTH - currentEntity.getX() - currentEntity.getWidth()),
					   (int) Math.floor(Constants.DISPLAY_HEIGHT - currentEntity.getY() - currentEntity.getHeight()),
					   (int) Math.floor(currentEntity.getWidth()),
					   (int) Math.floor(currentEntity.getHeight()));
		}
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}