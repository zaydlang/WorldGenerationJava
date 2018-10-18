package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.Timer;

public class Main {
	private static Display display;
	private static ArrayList<Entity> entities;
	private static Keyboard keyboard;
	
	public static void main(String[] args) {
		entities = new ArrayList<Entity>();
		entities.add(new Player(0, 0, 10, 10, 0, 0));
		Level level;
		do {
			level = new LevelBuilder().fillLevel(new Block(Color.BLACK))
											   .createRooms(45, 10, 10, 30, 30, new Block(Color.WHITE))
											   .smooth(new Block(Color.WHITE), new Block(Color.BLACK))
											   .smooth(new Block(Color.WHITE), new Block(Color.BLACK))
											   .smooth(new Block(Color.WHITE), new Block(Color.BLACK))
											   .getLevel();
		} while (level.getDensityScore(4, 4, 0.5, new Block(Color.WHITE)) < 0.85 ||
				 level.getRoomSizeScore(90, new Block(Color.WHITE)) < 1 ||
				 level.getRoomSizeScore(30, new Block(Color.BLACK)) < 1);
		
		keyboard = new Keyboard();
		display = new Display();
		display.addKeyListener(keyboard);
		display.setLevel(level);
		display.setEntities(entities);
		
		Timer updateTimer = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				updateEntities();
			}
		});
		updateTimer.start();
		Timer drawTimer = new Timer((1000) / (60), new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				draw();
			}
		});
		drawTimer.start();
	} 
	
	public static void updateEntities() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(keyboard.getKeyMap());
		}
	}
	
	public static void draw() {
		display.draw();
	}
}

class Keyboard extends JComponent implements KeyListener {
	private static final long serialVersionUID = 1L;
	private boolean[] keyMap;
	
	public Keyboard() {
		super();
		keyMap = new boolean[256];
	}

    @Override
    public void keyPressed(KeyEvent e) {
    	keyMap[e.getKeyCode()] = true;
    	System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	keyMap[e.getKeyCode()] = false;
    }
	
	@Override
    public void keyTyped(KeyEvent e) {}

	public boolean[] getKeyMap() {
		return keyMap;
	}
}