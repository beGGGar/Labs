package controller;

import java.util.logging.Logger;
import java.util.*;
import view.View;
import model.Botanic;
import model.CollectionCreator;
import model.Cool_parent;
import model.Randomizer;

/**
 * Main часть прогаммы
 * 
 * @author Nikita Raznoglazov PIN-24
 *
 */
public class Main {
	/**
	 * Часть программы для демонстрации работы классов.
	 * @param args
	 */
	public static void main(String args[]) {
		
		
		
		try {
			View.printWords();
			int n = Controller.readInt();
			ArrayList smth = CollectionCreator.createArray(n);
			Cool_parent p = new Cool_parent("Igork", 50, "Male", 10);
			Botanic p1 = new Botanic("Igor", 50, "Male", "Igorevich", 2, 100);
			String res = p.create_pair(smth);
			View.printPair(res);
			p1.create_pair(smth);
			String res1 = p1.create_pair(smth);
			View.printPair(res1);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		CollectionCreator.RunTimeList(10);
		CollectionCreator.RunTimeLinked(10);
		
	
	}

}
