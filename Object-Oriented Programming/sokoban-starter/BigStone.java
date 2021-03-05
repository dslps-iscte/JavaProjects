package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class BigStone extends MovableObject {
	private boolean interactive;
	
	public BigStone(Point2D position) {
		super(position);
		this.interactive = true;
	}

	@Override
	public String getName() {
		return "pedragrande";
	}
		
	@Override
	public boolean isSolid () {
		return true;
	}
	
	@Override
	public boolean isInteractive() {
		return interactive;
	}
	
	public void setNonInteractive() {
		this.interactive = false;
	}
	
}
