package pt.iscte.dcti.poo.sokoban.starter;
import pt.iul.ista.poo.utils.Point2D;

public class Chao extends AbstractSObject {
	
	public Chao(Point2D Point2D){
		super(Point2D);
	}
	
	@Override
	public String getName() {
		return "chao1";
	}

	@Override
	public int getLayer() {
		return 0;
	}

}
