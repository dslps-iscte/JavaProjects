package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Point2D;

public class Bateria extends InteractiveObject{
	private int energy;
	
	public Bateria(Point2D position) {
		super(position);
	}

	@Override
	public String getName() {
		return "bateria1";
	}

	@Override
	public int getLayer() {
		return 1;
	}
	
	@Override
	public void activate(AbstractSObject object) {
		if(object instanceof Player) {
			((Player) object).setEnergy(100);
			ImageMatrixGUI.getInstance().removeImage(this);
			ImageMatrixGUI.getInstance().removeImage(this);
		}
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	

}
