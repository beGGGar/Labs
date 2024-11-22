package controller;

import java.util.logging.Logger;

//import javafx.application.Application;

import java.util.*;
import view.View;
import model.Botanic;
import model.CollectionCreator;
import model.Cool_parent;
import model.FrameBotanic;
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
		
	Botanic a = new Botanic();
	Botanic b = (Botanic)a.addNew();
	System.out.println(b);
	b.changeExisting(b);
		
	}

}
