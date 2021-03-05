package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class Caixote extends MovableObject{
	
	public Caixote(Point2D position) {
		super(position);
	}
	
	@Override
	public String getName() {
		return "caixote1";
	}
	
	@Override
	public boolean isSolid () {
		return true;
	}
	
	@Override
	public boolean isInteractive() {
		return true;
	}

	}

		
		


