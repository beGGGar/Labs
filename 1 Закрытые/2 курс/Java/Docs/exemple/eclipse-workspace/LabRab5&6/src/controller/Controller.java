package controller;

import java.util.Scanner;
import view.View;

/**
 * Контроллер, осуществляющиий вводы в программу
 * @author Raznoglazov Nikita PIN-24
 *
 */
public class Controller {
/**
 * Функция считывания одного неотрицательного числа с клавиатуры.
 * Есть проверки на число, его положительность, при их непрохождении повторяется ввод.
 * @return res
 */
	static public int readInt() {
		while (true) {
			Scanner in = new Scanner(System.in);
			try {
				int res = in.nextInt();
				if(res >= 0) {
				return res;
				} else {System.out.println("Ошибка, введите данные ещё раз");}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	static public String readString() {
		while (true) {
			Scanner in = new Scanner(System.in);
			try {
				String res = in.nextLine();
				if(!res.equals("")) {
				return res;
				} else {System.out.println("Ошибка, введите данные ещё раз");}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	static public float readFloat() {
		while (true) {
			Scanner in = new Scanner(System.in);
			try {
				float res = in.nextFloat();
				if(res >= 0) {
				return res;
				} else {System.out.println("Ошибка, введите данные ещё раз");}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
