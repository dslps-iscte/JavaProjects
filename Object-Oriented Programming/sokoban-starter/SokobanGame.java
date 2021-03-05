package pt.iscte.dcti.poo.sokoban.starter;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.observer.Observed;
import pt.iul.ista.poo.observer.Observer;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class SokobanGame implements Observer {
 	
	private static SokobanGame INSTANCE;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	private ScoreSaver s;
	private Player player;
	private int currentLevel = 0;
	private int maxLevel = 10;
	private int score = 0;
	private String playerName;
	private ArrayList<ImageTile> tiles = buildLevel();
	private ArrayList <AbstractSObject> objects = new ArrayList <AbstractSObject>();
	
	public static SokobanGame getInstance () {	
		if(INSTANCE == null) {
			INSTANCE = new SokobanGame();
		}
		return INSTANCE;
	}
	
	public SokobanGame(){
		
		JOptionPane.showMessageDialog(null, "Use the Arrow Keys to move."
				+ "\n" + "Press 'R' to reset the level."
				+ "\n" + "Press 'H' if you need Help."
				+ "\n" + "Press 'E' to end the game."
				+ "\n" + "The lesser the moves the more score you get."
				+ "\n" + "Press 'OK' or 'ENTER' to start the game.");
		this.playerName = JOptionPane.showInputDialog (null, "Insert player's name");
		tiles.add(player);
		ImageMatrixGUI.getInstance().addImages(tiles);
		
	}
			
	private ArrayList<ImageTile> buildLevel(){
		
		File levelInfo = new File("levels/level" + currentLevel + ".txt");
		
		ImageMatrixGUI.getInstance().setStatusMessage("Level: " + currentLevel + " " + "Moves: " + 0 + " " + "Energy: " + 100);
		
		ArrayList<ImageTile> LevelTiles = new ArrayList<ImageTile>();
		ArrayList <AbstractSObject> LevelObjects = new ArrayList <AbstractSObject> ();
		
		try {
		Scanner readLevel = new Scanner(levelInfo);
		
			while (readLevel.hasNextLine()) {
					for(int y=0;y!=HEIGHT;y++) {
						String line = readLevel.nextLine();
						for (int x=0; x!=WIDTH; x++) {
						LevelTiles.add(new Chao(new Point2D(x,y)));
						switch(line.charAt(x)) {
						case 'O':
							AbstractSObject o = (new Fabrica()).create ('O', x, y);
							LevelTiles.add(o);
							LevelObjects.add(o);
						break;
						case 'X':
							AbstractSObject a = (new Fabrica()).create ('X', x, y);
							LevelTiles.add(a);
							LevelObjects.add(a);
						break;
						case 'C':
							AbstractSObject c = (new Fabrica()).create ('C', x, y);
							LevelTiles.add(c);
							LevelObjects.add(c);
						break;
						case '#':
							AbstractSObject p = (new Fabrica()).create ('#', x, y);
							LevelTiles.add(p);
							LevelObjects.add(p);
						break;
						case 'b':
							AbstractSObject b = (new Fabrica()).create ('b', x, y);
							LevelTiles.add(b);
							LevelObjects.add(b);
						break;
						case 'p':
							AbstractSObject peq = (new Fabrica()).create('p', x, y);
							LevelTiles.add(peq);
							LevelObjects.add(peq);
						break;
						case 'P':
							AbstractSObject big = (new Fabrica()).create('P', x, y);
							LevelTiles.add(big);
							LevelObjects.add(big);
						break;
						case'm':
							AbstractSObject m = (new Fabrica()).create('m', x, y);
							LevelTiles.add(m);
							LevelObjects.add(m);
						break;
						case '%':
							AbstractSObject pd = (new Fabrica()).create('%', x, y);
							LevelTiles.add(pd);
							LevelObjects.add(pd);
						break;
						case 't':
							AbstractSObject t = (new Fabrica()).create('t', x, y);
							LevelTiles.add(t);
							LevelObjects.add(t);
						break;
						case 'g':
							AbstractSObject g = (new Fabrica()).create('g', x, y);
							LevelTiles.add(g);
							LevelObjects.add(g);
						break;
						case 'E':
							player = new Player(new Point2D(x,y));
						break;
					}
						}
					}
				}
			
			objects=LevelObjects;
			readLevel.close();
			} catch (FileNotFoundException exception) {
				System.out.println("File not found");
				exception.printStackTrace();
			}
			tiles = LevelTiles;
			return LevelTiles;	
		}
	
	
	@Override
	public void update(Observed arg0) {
		int lastKeyPressed = ((ImageMatrixGUI)arg0).keyPressed();
		if(Direction.isDirection(lastKeyPressed)) {		
			if(player!=null) 
				player.movePlayer(Direction.directionFor(lastKeyPressed));
			}
			if(player!=null) {
				switch(lastKeyPressed) {
					case KeyEvent.VK_R:
					resetLevel();
					break;
					case KeyEvent.VK_H:
					JOptionPane.showMessageDialog(null, "Use the Arrow Keys to move."
							+ "\n" + "Press 'R' to reset the level."
							+ "\n" + "Press 'H' if you need Help."
							+ "\n" + "Press 'E' to end the game."
							+ "\n" + "Only one box can be pushed at a time." 
							+ "\n" + "The player cannot walk through boxes, stones or walls."
							+ "\n" + "The player cannot push 2 objects at the same time (for example, one box and one stone)."
							+ "\n" + "In cause of low energy, the player can charge by going to the battery."
							+ "\n" + "The player must not fall into the black hole, or it's game over."
							+ "\n" + "The puzzle is solved when all boxes are on the targets."
							+ "\n" + "The lesser the moves the more score you get. "
							+ "\n" + "At the end of each level you'll be awarded a score which will be saved in a .txt file."
							+ "\n" + "This game images are part of 'Sokobox - Luis Paulo'.");
					break;
					case KeyEvent.VK_N:
					int secondChance = JOptionPane.showConfirmDialog(null, "CHEATER! "
							+ "\n" + "Are you sure you want to skip this level?"
							+ "\n" + "Your score will not be saved."
							+ "\n" + "If you chose 'NO' the level will be reset", "Next Level", JOptionPane.YES_NO_OPTION);
					if (secondChance == JOptionPane.YES_OPTION) {
						nextLevel();
					}else {
						resetLevel();
					}
					break;
					case KeyEvent.VK_E:
					int secondChance2 = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to end the game?"
									+ "\n" + "If you chose 'NO' the level will be reset'"
									, "End Game" , JOptionPane.YES_NO_OPTION);
					if (secondChance2 == JOptionPane.YES_OPTION) {
						System.exit(1);
					}else {
						resetLevel();
					}

				}
			}
		
	
		ImageMatrixGUI.getInstance().setStatusMessage("Level: " + currentLevel + " Moves: " + player.getMoves() + " Energy: " + player.getEnergy() + " Score: " + player.getMoves() + " moves");


		ImageMatrixGUI.getInstance().update();
	}
	
	
	@SuppressWarnings("static-access") //saveNewScore
	public void nextLevel() {
		s.saveNewScore(playerName, player.getMoves(), currentLevel);
		if (currentLevel < maxLevel) {
		currentLevel++;
		ImageMatrixGUI.getInstance().clearImages();
		objects.clear();
		System.out.println("Next Level");
		ImageMatrixGUI.getInstance().addImages(this.buildLevel());
		tiles.add(player);
		objects.add(player);
		ImageMatrixGUI.getInstance().addImages(tiles);	
	}else {
		JOptionPane.showMessageDialog(null, "You just finished the game! "
				+ "\n" + "Congratulations!");
		System.exit(1);
	}	
	}
	
	
	public void resetLevel() {
		score=0;
		ImageMatrixGUI.getInstance().clearImages();
		objects.clear();
		System.out.println("Level Reset");
		ImageMatrixGUI.getInstance().addImages(this.buildLevel());
		tiles.add(player);
		objects.add(player);
		ImageMatrixGUI.getInstance().addImages(tiles);	
	}
	
	public ArrayList<ImageTile> getTiles() {
		return tiles;
	}
	
	public ArrayList <AbstractSObject> getObject(){
		return objects;
	}

	public void setScore(int pontuacao) {
		score += pontuacao;
		
	}
	
	public int getScore() {
		return score;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}
	
	
	
	
	
	
}
