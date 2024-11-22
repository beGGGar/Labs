package model;
import java.util.Random;
import java.util.*;

public class Randomizer {
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

}
