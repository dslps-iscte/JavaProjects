package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Point2D;

public class ParedeQuebradica extends InteractiveObject{
	
	public ParedeQuebradica(Point2D position) {
		super(position);
	}
	
	@Override
	public String getName() {
		return "Parede_Partida";
	}
	
	@Override
	public boolean isSolid () {
		return true;
	}
	
	@Override
	public boolean isInteractive() {
		return true;
	}
	
	@Override
	public boolean isParedePartida() {
		return true;
	}
		
	@Override
	public void activateParede(AbstractSObject object) { 
		ImageMatrixGUI.getInstance().removeImage(this);
		ImageMatrixGUI.getInstance().removeImage(this);
		SokobanGame.getInstance().getTiles().remove(this);
		
	}
}
