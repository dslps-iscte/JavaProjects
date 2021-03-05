package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class Parede extends AbstractSObject{
	
	public Parede(Point2D position) {
		super(position);
	}
	
	@Override
	public String getName() {
		return "Parede1";
	}
	

	@Override
	public boolean isSolid () {
		return true;
	}
}
