package pt.iscte.dcti.poo.sokoban.starter;

import javax.swing.JOptionPane;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Point2D;

public class Buraco extends InteractiveObject {
	
	public Buraco(Point2D position) {
		super(position);
	}
	
	@Override
	public String getName() {
		return "Buraco";
	}
	
	@Override
	public void activate(AbstractSObject object) {	
		if(object instanceof Player) {
			int resetGame = JOptionPane.showConfirmDialog(null, "Game Over"
					+  "\n" + "Would you like to reset the level?" 
					+ "\n" + "(if not, you will exit the game)", "GAME OVER", JOptionPane.YES_NO_OPTION);
			if (resetGame == JOptionPane.YES_OPTION) {
				SokobanGame.getInstance().resetLevel();
			}else {
				System.exit(1);
			}
		}

		if(object instanceof Caixote) {
			int resetGame = JOptionPane.showConfirmDialog(null, "Game Over"
					+  "\n" + "Would you like to reset the level?" 
					+ "\n" + "(if not, you will exit the game)", "GAME OVER", JOptionPane.YES_NO_OPTION);
			if (resetGame == JOptionPane.YES_OPTION) {
				SokobanGame.getInstance().resetLevel();
			}else {
				System.exit(1);
			}

		}

		if(object instanceof BigStone) {
			((BigStone) object).setNonInteractive();
			ImageMatrixGUI.getInstance().removeImage(this);
			ImageMatrixGUI.getInstance().removeImage(this);
			SokobanGame.getInstance().getTiles().remove(this);		//remove o buraco
			SokobanGame.getInstance().getTiles().remove(this);
		}
		else {
			ImageMatrixGUI.getInstance().removeImage(object);
			ImageMatrixGUI.getInstance().removeImage(object);
			SokobanGame.getInstance().getTiles().remove(object);
			System.out.println("Object Stuck!");
		}


	}
}
