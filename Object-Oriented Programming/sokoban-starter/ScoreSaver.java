package pt.iscte.dcti.poo.sokoban.starter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreSaver {
	private static ScoreSorter sorter = new ScoreSorter();
	
	public static void saveNewScore(String name, int newScore, int level) {
		System.out.println(name + " : " + newScore + " moves");
		File file = new File("scores/score_level" + level);
		ArrayList<String> scores = new ArrayList<String>();
		
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String score = reader.nextLine();
				scores.add(score);
			}
			reader.close();
			scores.add(newScore + " . . . . . " + name);
			Collections.sort(scores, sorter);
			Collections.reverse(scores);
		} catch (FileNotFoundException exceptionSB) {
			System.out.println("No file found");
		}

		try {
			PrintWriter writer = new PrintWriter(file);
			for (String score : scores) {
				writer.println(score);
			}
			writer.close();
			System.out.println(file.getAbsolutePath());
		} catch (final FileNotFoundException exceptionSB) {
			System.out.println("Can't write file");
		}

		System.out.println("New score saved!");
	}


}
