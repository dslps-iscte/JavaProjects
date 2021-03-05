package pt.iscte.dcti.poo.sokoban.starter;

import java.util.ArrayList;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;

public class Alvo extends InteractiveObject{
	private boolean check;
	
	public Alvo(Point2D position) {
		super(position);
	}

	@Override
	public String getName() {
		return "alvo1";
	}

	@Override
	public int getLayer() {
		return 1;
	}
	
	public boolean isChecked() {
		return check;
	}
		
	@Override
	public void activate(AbstractSObject object) {
		if(object instanceof Player) {
			check=false;
		}
		
		if(object instanceof Caixote) {
			check=true;

			int numeroAlvo=0;
			int numeroAlvosAtingidos=0;
			ArrayList <ImageTile> objects = SokobanGame.getInstance().getTiles();
			
			for(int i=0; i!=objects.size();i++) {
				if(objects.get(i) instanceof Alvo) {
					numeroAlvo++;
				
				if(((Alvo) objects.get(i)).isChecked()) {
					numeroAlvosAtingidos++;
				}
			}
	
		}
			if(numeroAlvo==numeroAlvosAtingidos) {
			SokobanGame.getInstance().nextLevel();
			
			}
	}
	}
	

}
