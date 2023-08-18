package model;

import java.util.ArrayList;

/**
 * Наследуемый от человека класс родителя, принципиальных отличий от своего суперкласса не имеет.
 * @author Raznoglazov Nikita PIN-24
 *
 */

public class Parent extends Human {

	protected Parent(String name, int age, String sex) {
		super(name, age, sex);
	}

	protected Parent() {
		super();
	}
/**
 * Переопределение метода toString, возвращающего все поля класса в виде строки
 */
	public String toString() {
		return super.toString();
	}
/**
 * Метод ищущий пару для родителя в лице студента.
 * Идет проверка по отчеству, если имя родителя совпадает с отчеством ученика возвращается строка,
 * содержащая в себе оба класса преобразованные toString.
 * @param array
 * @return result
 */
	public String create_pair(ArrayList<Human> array) {
		String result = "";
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getClass() == Student.class) {
				String s = array.get(i).toString().split("\t", 5)[3];
				if (array.get(i).GetSex() == "Male") {
					s = s.substring(0, s.length() - 5);
				} else {
					s = s.substring(0, s.length() - 4);
				}
				if (s.equals(this.GetName())) {
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
