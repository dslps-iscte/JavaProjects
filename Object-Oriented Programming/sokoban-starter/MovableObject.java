package pt.iscte.dcti.poo.sokoban.starter;

import java.util.ArrayList;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public abstract class MovableObject extends AbstractSObject implements Movable {
	
	public MovableObject(Point2D position) {
		super(position);
	}
	
	@Override
	public boolean move(Direction d) {

		ArrayList <ImageTile> objects = SokobanGame.getInstance().getTiles();
		Point2D newPosition = getPosition().plus(d.asVector());
		boolean moveAllowed=true;

		if (newPosition.getX()>=0 && newPosition.getX()<10 && newPosition.getY()>=0 && newPosition.getY()<10 ){
			for (int i = 0; i != objects.size(); i++) {
				AbstractSObject obstacle = (AbstractSObject)objects.get(i);
				if (obstacle.getPosition().equals(newPosition)) {
						if (obstacle.isSolid()) {
							moveAllowed=false;
						}else {
							if (obstacle.isInteractive()) {
								obstacle.activate(this);				
							}
						}
				}
					
				}
			if(moveAllowed==true) {
				setPosition(newPosition);
			}
		}

		return moveAllowed;
	}
	

}
