package pt.iscte.dcti.poo.sokoban.starter;

import java.util.Comparator;

public class ScoreSorter implements Comparator<String>{

	@Override
	public int compare(String scoreA, String scoreB) {
		int scoreAA = Integer.parseInt((scoreA.split(" . . . . . ")[0].trim()));
		int scoreBB = Integer.parseInt((scoreB.split(" . . . . . ")[0].trim()));
		return scoreBB - scoreAA;
	}
}
