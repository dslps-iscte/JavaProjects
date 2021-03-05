package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

public abstract class AbstractSObject implements ImageTile {
	private String name;
	private Point2D position;
	private boolean interactive;
	private boolean solid;       
	
	public AbstractSObject(Point2D position) {
		this.position=position;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String imagename) {
		this.name=imagename;
	}
	

	@Override
	public Point2D getPosition() {
		return position;
	}
	
	public void setPosition(Point2D point) {
		this.position=point;
	}
	
	public int getLayer() {
		return 2;
	}
	
	public boolean isSolid () {
		return solid;
	}
	
	public void setNonSolid() {
		this.solid=false;
	}
	
	public boolean isInteractive() {
		return interactive;
	}
	
	public void activate (AbstractSObject object) {
	}
	
	public boolean move(Direction d) {
		return false;
	}
	
	public boolean movePlayer(Direction d) {
		return false;
	}
	
	public boolean isMartelo() {
		return false;
	}
	
	public boolean isParedePartida() {
		return false;
	}
	
	public void activateMartelo(AbstractSObject object) {
	}
	
	public void activateParede(AbstractSObject object) {
		
	}

}
