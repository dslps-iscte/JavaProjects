package pt.iscte.dcti.poo.sokoban.starter;


import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Point2D;

public class Martelo extends InteractiveObject{
		
	Martelo(Point2D position){
		super(position);
	
	}

	@Override
	public String getName() {
		return "Martelo";
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
	@Override
	public boolean isMartelo() {
		return true;
	}
	
	@Override
	public void activateMartelo(AbstractSObject object) {
		ImageMatrixGUI.getInstance().removeImage(this);
		ImageMatrixGUI.getInstance().removeImage(this);
		SokobanGame.getInstance().getTiles().remove(this);
		System.out.println("Martelo Ativo");
	}

	

	
	
	
	
	
}
