package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public abstract class InteractiveObject extends AbstractSObject implements Interactive{
	
	public InteractiveObject(Point2D position) {
		super(position);
	}
	
	@Override
	public boolean isInteractive() {
		return true;
	}

	


}
