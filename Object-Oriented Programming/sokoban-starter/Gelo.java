package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public class Gelo extends InteractiveObject{

	public Gelo(Point2D position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Gelo";
	}
	
	@Override
	public boolean isInteractive() {
		return true;
	}
	
	@Override
	public int getLayer() {
		return 1;
	}
	
	@Override
	public void activate(AbstractSObject object) {
		int lastKeyPressed = ImageMatrixGUI.getInstance().keyPressed();
		if(Direction.isDirection(lastKeyPressed)) { 
			if (object instanceof MovableObject) {
				((MovableObject)object).move(Direction.directionFor(lastKeyPressed));
			}
		}
	}
}

