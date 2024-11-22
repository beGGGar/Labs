package model;

import java.util.ArrayList;

/**
 * Наследуемый от родителя класс крутого родителя, помимо полей суперкласса
 * присутствуют карманные деньги, которые выдаются ботанику.
 * 
 * @author Raznoglazov Nikita PIN-24
 *
 */

public class Cool_parent extends Parent {

	private int pocket_money;

	public int GetPocket_money() {
		return pocket_money;
	}

	public void SetPocket_money(int pocket_money) {
		this.pocket_money = pocket_money;
	}

	public Cool_parent(String name, int age, String sex, int pocket_money) {
		super(name, age, sex);
		this.pocket_money = pocket_money;
	}

	public Cool_parent() {
		super();
		this.pocket_money = 0;
	}

	/**
	 * Переопределение метода toString, выводящего все поля класса в виде строки
	 */
	public String toString() {
		return super.toString() + "\t" + pocket_money;
	}

	/**
	 * Метод ищущий пару для крутого родителя в лице ботаника.
	 * Идет проверка по отчеству и оговоренных карманных деньгах, если имя родителя совпадает с отчеством ученика,
	 * а также совпадают карманные деньги, то возвращается строка,
	 * содержащая в себе оба класса преобразованные toString.
	 * @param array
	 * @return result
	 */
	public String create_pair(ArrayList<Human> array) {
		String result = "";
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getClass() == Botanic.class) {
				String s = array.get(i).toString().split("\t", 6)[5];
				String s1 = array.get(i).toString().split("\t", 5)[3];
				if (array.get(i).GetSex() == "Male") {
					s1 = s1.substring(0, s1.length() - 5);
				} else {
					s1 = s1.substring(0, s1.length() - 4);
				}
				Integer pm = Integer.valueOf(s);
				if (pm == this.GetPocket_money() & s1.equals(this.GetName())) {
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
