package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Point2D;

public class Fabrica {
	
	public AbstractSObject create (char type, int x, int y) {
		switch(type) {
		case 'O':
			Buraco o = new Buraco(new Point2D(x,y));
			return o;
		case 'X':
			Alvo a = new Alvo(new Point2D(x,y));
			return a;
		case 'C':
			Caixote c = new Caixote(new Point2D(x,y));
			return c;
		case '#':
			Parede p = new Parede(new Point2D(x,y));
			return p;
		case 'b':
			Bateria b = new Bateria(new Point2D(x,y));
			return b;
		case 'E':
			Player pl = new Player(new Point2D(x,y));
			return pl;
		case 'p':
			SmallStone peq = new SmallStone(new Point2D(x,y));
			return peq;
		case 'P':
			BigStone big = new BigStone(new Point2D(x,y));
			return big;
		case 'm':
			Martelo m = new Martelo(new Point2D(x,y));
			return m;
		case '%':
			ParedeQuebradica pd = new ParedeQuebradica(new Point2D(x,y));
			return pd;
		case 't':
			Portal t = new Portal(new Point2D(x,y));
			return t;
		case 'g':
			Gelo g = new Gelo(new Point2D(x,y));
			return g;
		}
		
		return null;
	}

}
