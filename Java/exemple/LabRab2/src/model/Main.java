package model;

import java.util.*;
import view.View;
import controller.Controller;
/**
 * Main часть прогаммы
 * @author Nikita Raznoglazov PIN-24
 *
 */
public class Main {

	private static Random sRandom = new Random();
	private static char[] sAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	private static int sLength = sAlphabet.length;

	/**
	 * Функция, генерирующая рандомное слово из 5 букв. Используется для генерации имен и отчеств.
	 * @return s
	 */
	public static String getRandomWord() {
		String s = "";
		for (int i = 0; i < 5; i++) {
			s = s + sAlphabet[sRandom.nextInt(sLength)];
		}
		return s;
	}

	/**
	 * Функция, генерирующая рандомное число от 18 до 99.
	 * @return a
	 */
	public static int getRandomAge() {
		int a = 0;
		a = (int) (Math.random() * 81) + 18;
		return a;
	}
	
	/**
	 * Функция, генерирующая рандомное число от 0 до 2, 
	 * если число больше единицы возвращается мужской пол, если меньше - женский.
	 * @return s
	 */
	public static String getRandomSex() {
		String s = "";
		int a = (int) (Math.random() * 2);
		if (a >= 1) {
			s = "Male";
		} else {
			s = "Female";
		}
		return s;
	}

	/**
	 * Функция, генерирующая рандомное слово из 5 букв с помощью функции getRandomWord 
	 * и прибавляющая окончания для получения отчеств.
	 * @return s
	 */
	public static String getRandomPatronymic(String sex) {
		String s = "";
		s = getRandomWord();
		if (sex == "Male") {
			s = s + "evich";
		} else {
			s = s + "evna";
		}
		return s;
	}

	/**
	 * Функция, генерирующая n*4 объектов класса student, parent, cool_parent, botanic 
	 * + 2 тестовых объекта с помощью представленных функций, а затем объединяет их в список типа
	 * их общего суперкласса human.
	 * @return array
	 */
	public static ArrayList<Human> createArray(int n) {
		ArrayList array = new ArrayList();
		for (int i = 0; i < n; i++) {
			String s = getRandomSex();
			Student s1 = new Student(getRandomWord(), getRandomAge(), s, getRandomPatronymic(s),
					(float) Math.random() * 5);
			Parent p1 = new Parent(getRandomWord(), getRandomAge(), getRandomSex());
			Cool_parent c1 = new Cool_parent(getRandomWord(), getRandomAge(), getRandomSex(),
					(int) Math.random() * 10000);
			float m = (float) Math.random() * 5;
			s = getRandomSex();
			Botanic b1 = new Botanic(getRandomWord(), getRandomAge(), s, getRandomPatronymic(s), m,
					(int) Math.pow(10, (int) m));
			array.add(p1);
			array.add(s1);
			array.add(b1);
			array.add(c1);
		}
		Botanic test = new Botanic("Igork", 50, "Male", "Igorkevich", 1, 10);
		Cool_parent test1 = new Cool_parent("Igor", 50, "Male", 100);
		array.add(test);
		array.add(test1);
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		return array;
	}

	/**
	 * Часть программы для демонстрации работы классов.
	 * @param args
	 */
	public static void main(String args[]) {
		View.printWords();
		int n = Controller.readInt();
		ArrayList smth = createArray(n);
		Cool_parent p = new Cool_parent("Igork", 50, "Male", 10);
		Botanic p1 = new Botanic("Igor", 50, "Male", "Igorevich", 2, 100);
		String res = p.create_pair(smth);
		View.printPair(res);
		p1.create_pair(smth);
		String res1 = p1.create_pair(smth);
		View.printPair(res1);
	}

}
