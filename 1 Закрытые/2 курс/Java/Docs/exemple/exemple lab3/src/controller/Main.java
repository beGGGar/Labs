package controller;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.*;
import view.View;
import model.Botanic;
import model.CollectionCreator;
import model.Cool_parent;
import model.Human;
import model.Parent;
import model.Randomizer;
import model.Student;

/**
 * Main часть прогаммы
 * 
 * @author Nikita Raznoglazov PIN-24
 *
 */
public class Main {
	/**
	 * Часть программы для демонстрации работы классов.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		ArrayList<Human> smth = new ArrayList();
		File file = new File("notes.txt");
		//настройка логов для текста 
		ErrMsgLog.errhnd = new FileHandler("src/controller/Log.txt", true);
        ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
        ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
      //Считывание из файла
		if (file.exists() & file.length() != 0) {
			String buf = new String();
			try (FileReader reader = new FileReader(file)) {
				int c;
				while ((c = reader.read()) != -1) {

					buf = buf + (char) c;

				}
				String[] mas = buf.split("\n");
				smth = CollectionCreator.createArrayList(mas.length);
				for (int i = 0; i < mas.length; i++) {
					String[] ob = mas[i].split("\t");
					switch (ob[0]) {
					case ("Parent") -> {
						Parent p1 = new Parent(ob[1], Integer.valueOf(ob[2]), ob[3]);
						smth.add(p1);
					}
					case ("Cool_parent") -> {
						Cool_parent c1 = new Cool_parent(ob[1], Integer.valueOf(ob[2]), ob[3], Integer.valueOf(ob[4]));
						smth.add(c1);
					}
					case ("Student") -> {
						Student s1 = new Student(ob[1], Integer.valueOf(ob[2]), ob[3], ob[4],
								(float) Double.parseDouble(ob[5]));
						smth.add(s1);
					}
					case ("Botanic") -> {
						Botanic b1 = new Botanic(ob[1], Integer.valueOf(ob[2]), ob[3], ob[4],
								(float) Double.parseDouble(ob[5]), Integer.valueOf(ob[6]));
						smth.add(b1);
					}
					}
				
				}
				LocalTime time = LocalTime.now();
                ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" Read from "+ file);

			} catch (IOException ex) {

				System.out.println(ex.getMessage());
				ErrMsgLog.addErrWithLog(ex);
			}
			for (int i = 0; i < smth.size(); i++) {
				System.out.println(smth.get(i));
			}
		} else {

			View.printWords();
			int n = Controller.readInt();
			smth = CollectionCreator.createArray(n);
		}
		//Получение property значений
		System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
		String nameProperty = System.getProperty("name");
		String passwordProperty = System.getProperty("password");
		String groupRootProperty = System.getProperty("users.group.root");
		String groupUserProperty = System.getProperty("users.group.user");
		String debugProperty = System.getProperty("debug");
		String autotestProperty = System.getProperty("autotest");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean tumb = false;
		//выполнение программы в соответсвии с полученными property значениями
		if (groupRootProperty.equals("true")) {
			while (true) {
				System.out.println("Enter your username");
				String un = reader.readLine();
				System.out.println("Enter your password");
				String pw = reader.readLine();

				if (un.equals(nameProperty) && pw.equals(passwordProperty)) {
					System.out.println("Welcome " + nameProperty + "\n");
					String paw = new String();
					for (int i = 0; i < passwordProperty.length(); i++) {
						paw = paw+"*";
					}
					System.out.println("Password "+ paw);
					if (autotestProperty.equals("true")) {
						CollectionCreator.RunTimeList(10);
					}
					if (debugProperty.equals("true")) {
						tumb = true;
					}
					LocalTime time = LocalTime.now();
	                ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano()+":"+time.getNano() + " Login: "+ nameProperty);
					break;
				} else System.out.println("Wrong data");
			}
		} else if (groupUserProperty.equals("true")) {
			System.out.println("Welcome Guest \n");
		}
		//Сохранения значений в базу данных
		try (FileWriter writer = new FileWriter("notes.txt", false)) {
			for (int i = 0; i < smth.size(); i++) {
				String text = smth.get(i).getClass().toString().substring(12) + "\t" + smth.get(i).toString();
				writer.write(text);
				writer.append('\n');

				writer.flush();
			}
            LocalTime time = LocalTime.now();
            ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" Write to "+ file);
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
			ErrMsgLog.addErrWithLog(ex);
		}
        LocalTime time = LocalTime.now();
        ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" End ");

	}

}
