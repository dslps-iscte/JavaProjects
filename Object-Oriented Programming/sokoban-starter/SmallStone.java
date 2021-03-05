package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class SmallStone extends MovableObject{
	private boolean solid;
	
	public SmallStone(Point2D position) {
		super(position);
		solid = true;
	}
	
	@Override
	public String getName() {
		return "pedrapequena";
	}
	
	@Override
	public boolean isSolid () {
		return solid;
	}
	
	@Override
	public boolean isInteractive() {
		return true;
	}
	
	public void setNonSolid() {
		this.solid = false;
	}

}
