package model;

import java.util.ArrayList;

import controller.Controller;
import model.Exceptions.NumberException;
import model.Exceptions.StringException;
import view.View;

/**
 * Наследуемый от родителя класс крутого родителя, помимо полей суперкласса
 * присутствуют карманные деньги, которые выдаются ботанику.
 * 
 * @author Raznoglazov Nikita PIN-24
 *
 */

public class Cool_parent extends Parent implements IControlledInput {

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
	 * Метод ищущий пару для крутого родителя в лице ботаника. Идет проверка по
	 * отчеству и оговоренных карманных деньгах, если имя родителя совпадает с
	 * отчеством ученика, а также совпадают карманные деньги, то возвращается
	 * строка, содержащая в себе оба класса преобразованные toString.
	 * 
	 * @param array
	 * @return result
	 */
	public String create_pair(ArrayList<Human> array) {
		String result = "";
		for (int i = 0; i < array.size(); i++) {
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
				View.printWordsPocketMoney();
				int pocket_money = Controller.readInt();
				if (pocket_money > 100000 || pocket_money < 10)
					throw new Exceptions.NumberException("Wrong amount of pocket money: ", pocket_money);

				return new Cool_parent(name, age, sex, pocket_money);
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
				((Cool_parent) smth).name = Controller.readString();
				char[] array = ((Cool_parent) smth).name.toCharArray();
				if (!Character.isUpperCase(array[0]))
					throw new Exceptions.StringException("Starts with a non capital letter: ",
							((Cool_parent) smth).name);
				View.printWordsAge();
				((Cool_parent) smth).age = Controller.readInt();
				if (((Cool_parent) smth).age >= 110 || ((Cool_parent) smth).age <= 18)
					throw new Exceptions.NumberException("Wrong age: ", ((Cool_parent) smth).age);
				View.printWordsSex();
				((Cool_parent) smth).sex = Controller.readString();
				if (!((Cool_parent) smth).sex.equals("Male") || !((Cool_parent) smth).sex.equals("Female"))
					throw new Exceptions.StringException("Wrong sex: ", ((Cool_parent) smth).sex);

				View.printWordsPocketMoney();
				((Cool_parent) smth).pocket_money = Controller.readInt();
				if (((Cool_parent) smth).pocket_money > 100000 || ((Cool_parent) smth).pocket_money < 10)
					throw new NumberException("Wrong amount of pocket money: ", ((Cool_parent) smth).pocket_money);
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