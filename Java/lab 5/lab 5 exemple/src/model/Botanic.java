package model;

import java.util.ArrayList;
import view.View;
import controller.Controller;
import model.Exceptions.NumberException;
import model.Exceptions.StringException;

/**
 * Наследуемый от студента класс ботаника, помимо полей суперкласса присутствуют
 * карманные деньги, получаемые от крутого родителя.
 * 
 * @author Raznoglazov Nikita PIN-24
 *
 */
public class Botanic extends Student implements IControlledInput {

	protected int pocket_money;

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
	 * Метод ищущий пару для ботаника в лице родителя. Идет проверка по отчеству и
	 * оговоренных карманных деньгах, если имя родителя совпадает с отчеством
	 * ученика, а также совпадают карманные деньги, то возвращается строка,
	 * содержащая в себе оба класса преобразованные toString.
	 * 
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

	/**
	 * Метод, наследуемый от интерфейса, позволяет создать новый объект с проверками.
	 * 
	 * 
	 * @return  new Botanic(name, age, sex, patronymic, session_mark, pocket_money)
	 */
	@Override
	public Object addNew() {
		boolean exCount = false;

		while (true) {
			try {

				FrameBotanic frame = new FrameBotanic();
				frame.setVisible(true);

				while (true) {
					if (frame.wait == false) {
							break;
					}
					Thread.sleep(100);
				}

				View.printWordsName();
				String name = frame.TField1.getText();
				char[] array = name.toCharArray();
				if (!Character.isUpperCase(array[0]))
					throw new Exceptions.StringException("Starts with a non capital letter: ", name);
				View.printWordsAge();
				int age = Integer.valueOf(frame.TField2.getText());
				if (age >= 110 | age <= 17)
					throw new Exceptions.NumberException("Wrong age: ", age);
				View.printWordsSex();
				String sex = frame.TField3.getText();
				if (!sex.equals("Male") && !sex.equals("Female"))
					throw new Exceptions.StringException("Wrong sex: ", name);
				View.printWordsPatronymic();
				String patronymic = frame.TField4.getText();
				char[] array1 = patronymic.toCharArray();
				if (!Character.isUpperCase(array1[0]))
					throw new Exceptions.StringException("Starts with a non capital letter: ", patronymic);
				View.printWordsMark();
				float session_mark = Float.valueOf(frame.TField5.getText());
				if (session_mark > 5 | session_mark <= 2)
					throw new Exceptions.NumberException("Wrong mark: ", age);
				View.printWordsPocketMoney();
				int pocket_money = Integer.valueOf(frame.TField6.getText());
				if (pocket_money > 100000 | pocket_money < 10)
					throw new Exceptions.NumberException("Wrong amount of pocket money: ", pocket_money);

				return new Botanic(name, age, sex, patronymic, session_mark, pocket_money);

			} catch (Exceptions.StringException ex1) {
				System.out.println(ex1.getMessage());
				System.out.println(ex1.getName());
				exCount = true;
			} catch (Exceptions.NumberException ex) {
				System.out.println(ex.getMessage());
				System.out.println(ex.getName());
				exCount = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				if (exCount == true) {
					System.out.println("Что-то было введено неправильно, попробуйте ещё раз");
					exCount = false;
				}
			}
		}
	}

	
	/**
	 * Метод, наследуемый от интерфейса, позволяет изменить объект
	 * 
	 */
	@Override
	public void changeExisting(Object smth) {
		boolean exCount = false;
		while (true) {
			try {
				
				FrameBotanic frame = new FrameBotanic();
				frame.setVisible(true);

				while (true) {
					if (frame.wait == false) {
							break;
					}
					Thread.sleep(100);
				}
				
				View.printWordsName();
				((Botanic) smth).name = frame.TField1.getText();
				char[] array = ((Botanic) smth).name.toCharArray();
				if (!Character.isUpperCase(array[0]))
					throw new Exceptions.StringException("Starts with a non capital letter: ", ((Botanic) smth).name);
				View.printWordsAge();
				((Botanic) smth).age = Integer.valueOf(frame.TField2.getText());
				if (((Botanic) smth).age >= 110 | ((Botanic) smth).age <= 18)
					throw new Exceptions.NumberException("Wrong age: ", ((Botanic) smth).age);
				View.printWordsSex();
				((Botanic) smth).sex = frame.TField3.getText();
				if (!((Botanic) smth).sex.equals("Male") && !((Botanic) smth).sex.equals("Female"))
					throw new Exceptions.StringException("Wrong sex: ", ((Botanic) smth).sex);
				View.printWordsPatronymic();
				((Botanic) smth).patronymic = frame.TField4.getText();
				char[] array1 = ((Botanic) smth).patronymic.toCharArray();
				if (!Character.isUpperCase(array1[0]))
					throw new Exceptions.StringException("Starts with a non capital letter: ",
							((Botanic) smth).patronymic);
				View.printWordsMark();
				((Botanic) smth).session_mark = Float.valueOf(frame.TField5.getText());
				if (((Botanic) smth).session_mark > 5 | ((Botanic) smth).session_mark <= 2)
					throw new NumberException("Wrong mark: ", ((Botanic) smth).session_mark);
				View.printWordsPocketMoney();
				((Botanic) smth).pocket_money = Integer.valueOf(frame.TField6.getText());
				if (((Botanic) smth).pocket_money > 100000 | ((Botanic) smth).pocket_money < 10)
					throw new NumberException("Wrong amount of pocket money: ", ((Botanic) smth).pocket_money);
			} catch (StringException ex1) {
				System.out.println(ex1.getMessage());
				System.out.println(ex1.getName());
			} catch (NumberException ex) {
				System.out.println(ex.getMessage());
				System.out.println(ex.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Что-то было введено неправильно, попробуйте ещё раз");
			}
		}
	}
}
