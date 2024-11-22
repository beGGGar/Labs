package model;

import java.util.ArrayList;

/**
 * Наследуемый от человека класс студента, помимо полей суперкласса присутствуют
 * отчество и средняя оценка за семестр.
 * 
 * @author Raznoglazov Nikita PIN-24
 *
 */
public class Student extends Human {
	private String patronymic;
	private float session_mark;

	public String GetPatronymic() {
		return patronymic;
	}

	public float GetSession_mark() {
		return session_mark;
	}

	public void SetPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public void SetSession_mark(float session_mark) {
		this.session_mark = session_mark;
	}

	public Student() {
		super();
		this.patronymic = "";
		this.session_mark = 0;
	}

	public Student(String name, int age, String sex, String patronymic, float session_mark) {
		super(name, age, sex);
		this.patronymic = patronymic;
		this.session_mark = session_mark;
	}

	/**
	 * Переопределение метода toString, возвращающего все поля класса в виде строки
	 */
	public String toString() {
		return super.toString() + "\t" + patronymic + "\t" + session_mark;
	}

	/**
	 * 
	 * Метод ищущий пару для студента в лице родителя. Идет проверка по
	 * отчеству, если имя родителя совпадает с
	 * отчеством ученика, то возвращается
	 * строка, содержащая в себе оба класса преобразованные toString.
	 * 
	 * @param array
	 * @return result
	 */
	public String create_pair(ArrayList<Human> array) {
		String result = "";
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getClass() == Parent.class) {
				String s = array.get(i).GetName();
				if (this.GetSex() == "Male") {
					s = s + "evich";
					System.out.println(s);
				} else {
					s = s + "evna";
				}
				if (s.equals(patronymic)) {
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