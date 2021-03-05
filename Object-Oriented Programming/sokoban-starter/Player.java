package pt.iscte.dcti.poo.sokoban.starter;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Player extends AbstractSObject{
	private int energy;
	private int moves;
	private boolean playerTemMartelo;

	public Player(Point2D initialPosition){
		super(initialPosition);
		setName("Player_D");
		this.energy=100;
		this.playerTemMartelo=false;
	}
	
	public void moveImage(Direction dir) {
		
		switch(dir) {
		case UP:
			setName("Player_U");
		break;
		case DOWN:
			setName("Player_D");
		break;
		case LEFT:
			setName("Player_L");
		break;
		case RIGHT:
			setName("Player_R");
		break;
		}
			
	}
	
	@Override
	public boolean movePlayer(Direction d) {

		ArrayList <ImageTile> objects = SokobanGame.getInstance().getTiles();
		Point2D newPosition = getPosition().plus(d.asVector());
		boolean moveAllowed=true;
		AbstractSObject activator = null;
		moveImage(d);


		if(energy==0) {
			moveAllowed=false;
			JOptionPane.showMessageDialog(null, "GAME OVER");
			SokobanGame.getInstance().resetLevel();

		}

		if (newPosition.getX()>=0 && newPosition.getX()<10 && newPosition.getY()>=0 && newPosition.getY()<10 ){
			for (int i = 0; i != objects.size(); i++) {
				AbstractSObject obstacle = (AbstractSObject)objects.get(i);
				if (obstacle.getPosition().equals(newPosition)) {					
					if(obstacle.isSolid()) {
						if (obstacle.isInteractive()) {
							if(obstacle.move(d)==false) { 
								moveAllowed=false;
							}

							if(obstacle.isMartelo()) {
								moveAllowed=true;
								obstacle.activateMartelo(this);
								playerTemMartelo=true;
							}
							if(obstacle.isParedePartida()) {
								if(playerTemMartelo) {
									moveAllowed=true;
									obstacle.activateParede(this);
								}else {
								}
							}
						}else {
							moveAllowed=false;
						}

					} else {
						if (obstacle.isInteractive() == true) {	
							obstacle.activate(this);
							if (moveAllowed) {
								activator = obstacle;				// battery, hole > perform action;
							}

						}
					}
				}
			}

			if (moveAllowed) {
				if (activator != null) {
					activator.activate(this);

				}

				setPosition(newPosition);
				energy--;
				moves++;

			}
		}

		return moveAllowed;
	}


	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy += energy;
	}

	public int getMoves() {
		return moves;
	}

}
