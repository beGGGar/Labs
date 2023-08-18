package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Наследуемый от студента класс ботаника, помимо полей суперкласса присутствуют
 * карманные деньги, получаемые от крутого родителя.
 * 
 * @author Raznoglazov Nikita PIN-24
 *
 */
public class Botanic extends Student {

	private int pocket_money;

	public int GetPocket_money() {
		return pocket_money;
	}

	public void SetPocket_money(int pocket_money) {
		this.pocket_money = pocket_money;
	}

	public Botanic(String name, int age, String sex, String patronymic, float session_mark, int pocket_money) {
		super(name, age, sex, patronymic, session_mark);
		this.pocket_money = pocket_money;
	}

	public Botanic() {
		super();
		this.pocket_money = 0;
	}

	/**
	 * Переопределение метода toString, возвращающего все поля класса в виде строки
	 */
	public String toString() {
		return super.toString() + "\t" + pocket_money;
	}

	/**
	 * Метод ищущий пару для ботаника в лице родителя.
	 * Идет проверка по отчеству и оговоренных карманных деньгах, если имя родителя совпадает с отчеством ученика,
	 * а также совпадают карманные деньги, то возвращается строка,
	 * содержащая в себе оба класса преобразованные toString.
	 * @param array
	 * @return result
	 */
	public String create_pair(ArrayList<Human> array) {
		String result = "";
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getClass() == Cool_parent.class) {
				String s = array.get(i).toString().split("\t", 5)[3];
				String s1 = array.get(i).GetName();
				if (this.GetSex() == "Male") {
					s1 = s1 + "evich";
				} else {
					s1 = s1 + "evna";
				}
				Integer pm = Integer.valueOf(s);
				if (pm == this.GetPocket_money() & s1.equals(this.GetPatronymic())) {
					result = this.toString() + "\n" + array.get(i).toString();
					break;
				} else {
					result = this.toString() + "\n" + "Не было найдено пары";

				}
			}
		}
		return result;
	}
}
