package pt.iscte.dcti.poo.sokoban.starter;

import java.util.ArrayList;
import java.util.List;
import pt.iul.ista.poo.utils.Point2D;

public class Portal extends InteractiveObject {
	InteractiveObject portal1;
	InteractiveObject portal2;
	
	public Portal(Point2D position) {
		super(position);
	}
	
	@Override
	public String getName() {
		return "Portal";
	}
		
	@Override
	public int getLayer() {
		return 1;
	}
	
			
	@Override
	public void activate(AbstractSObject object) {
		List <Portal> portais = new ArrayList <Portal>();
		
		for(int i=0; i!=portais.size(); i++) {
			if(portais.get(i).getPosition().equals(portal1.getPosition())) {
				System.out.println("portal1");
				object.setPosition(portal2.getPosition());
			}
		}
		
	}
			
		
}
