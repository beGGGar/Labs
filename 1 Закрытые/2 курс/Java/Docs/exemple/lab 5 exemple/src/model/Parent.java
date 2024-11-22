package model;

import java.util.ArrayList;

import controller.Controller;
import model.Exceptions.NumberException;
import model.Exceptions.StringException;
import view.View;

/**
 * Наследуемый от человека класс родителя, принципиальных отличий от своего суперкласса не имеет.
 * @author Raznoglazov Nikita PIN-24
 *
 */

public class Parent extends Human implements IControlledInput {

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
	
	@Override
	public Object addNew() {

		while (true) {
			try {
				View.printWordsName();
				String name = Controller.readString();
				char[] array = name.toCharArray();
				if (!Character.isUpperCase(array[0]))
					throw new Exceptions.StringException("Starts with a non capital letter: ", name);
				View.printWordsAge();
				int age = Controller.readInt();
				if (age >= 110 || age <= 18)
					throw new Exceptions.NumberException("Wrong age: ", age);
				View.printWordsSex();
				String sex = Controller.readString();
				if (!sex.equals("Male") || !sex.equals("Female"))
					throw new Exceptions.StringException("Wrong sex: ", name);

				return new Parent(name, age, sex);
			} catch (Exceptions.StringException ex1) {
				System.out.println(ex1.getMessage());
				System.out.println(ex1.getName());
			} catch (Exceptions.NumberException ex) {
				System.out.println(ex.getMessage());
				System.out.println(ex.getName());
			} finally {
				System.out.println("Что-то было введено неправильно, попробуйте ещё раз");
			}
		}
	}

	@Override
	public void changeExisting(Object smth) {
		while (true) {
			try {
				View.printWordsName();
				((Parent) smth).name = Controller.readString();
				char[] array = ((Parent) smth).name.toCharArray();
				if (!Character.isUpperCase(array[0]))
					throw new Exceptions.StringException("Starts with a non capital letter: ",
							((Parent) smth).name);
				View.printWordsAge();
				((Parent) smth).age = Controller.readInt();
				if (((Parent) smth).age >= 110 || ((Parent) smth).age <= 18)
					throw new Exceptions.NumberException("Wrong age: ", ((Parent) smth).age);
				View.printWordsSex();
				((Parent) smth).sex = Controller.readString();
				if (!((Parent) smth).sex.equals("Male") || !((Parent) smth).sex.equals("Female"))
					throw new Exceptions.StringException("Wrong sex: ", ((Parent) smth).sex);

			} catch (StringException ex1) {
				System.out.println(ex1.getMessage());
				System.out.println(ex1.getName());
			} catch (NumberException ex) {
				System.out.println(ex.getMessage());
				System.out.println(ex.getName());
			} finally {
				System.out.println("Что-то было введено неправильно, попробуйте ещё раз");
			}
		}
	}

	
}
