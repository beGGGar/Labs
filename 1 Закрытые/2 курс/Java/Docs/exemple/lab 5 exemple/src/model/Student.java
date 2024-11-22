package model;

import java.util.ArrayList;

import controller.Controller;
import model.Exceptions.NumberException;
import model.Exceptions.StringException;
import view.View;

/**
 * Наследуемый от человека класс студента, помимо полей суперкласса присутствуют
 * отчество и средняя оценка за семестр.
 * 
 * @author Raznoglazov Nikita PIN-24
 *
 */
public class Student extends Human implements IControlledInput {
	protected String patronymic;
	protected float session_mark;

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
	

	@Override
	public Object addNew() {

		while (true) {
			try {
			View.printWordsName();
			String name = Controller.readString();
			char[] array=name.toCharArray();
	        if(!Character.isUpperCase(array[0])) throw new Exceptions.StringException("Starts with a non capital letter: ",name);
			View.printWordsAge();
			int age = Controller.readInt();
			if(age >= 110 || age <= 18) throw new Exceptions.NumberException("Wrong age: ",age);
			View.printWordsSex();
			String sex = Controller.readString();
			if (!sex.equals("Male") || !sex.equals("Female")) throw new Exceptions.StringException("Wrong sex: ",name);
			View.printWordsPatronymic();
			String patronymic = Controller.readString();
			char[] array1=patronymic.toCharArray();
	        if(!Character.isUpperCase(array1[0])) throw new Exceptions.StringException("Starts with a non capital letter: ",patronymic);
			View.printWordsMark();
			float session_mark = Controller.readFloat();
			if(session_mark > 5 || session_mark <= 2) throw new Exceptions.NumberException("Wrong mark: ",age);

			return new Student(name, age, sex, patronymic, session_mark);
			}
			catch(Exceptions.StringException ex1){
				System.out.println(ex1.getMessage());
		        System.out.println(ex1.getName());
			}
			catch (Exceptions.NumberException ex) {
				System.out.println(ex.getMessage());
		        System.out.println(ex.getName());
			}
			finally {
				System.out.println("Что-то было введено неправильно, попробуйте ещё раз");
			}
		}
	}

	@Override
	public void changeExisting(Object smth) {
		while (true) {
			try {
			View.printWordsName();
			((Student)smth).name = Controller.readString();
			char[] array=((Student)smth).name.toCharArray();
	        if(!Character.isUpperCase(array[0])) throw new Exceptions.StringException("Starts with a non capital letter: ",((Student)smth).name);
			View.printWordsAge();
			((Student)smth).age = Controller.readInt();
			if(((Student)smth).age >= 110 || ((Student)smth).age <= 18) throw new Exceptions.NumberException("Wrong age: ",((Student)smth).age);
			View.printWordsSex();
			((Student)smth).sex = Controller.readString();
			if (!((Student)smth).sex.equals("Male") || !((Student)smth).sex.equals("Female")) throw new Exceptions.StringException("Wrong sex: ",((Student)smth).sex);
			View.printWordsPatronymic();
			((Student)smth).patronymic = Controller.readString();
			char[] array1=((Student)smth).patronymic.toCharArray();
	        if(!Character.isUpperCase(array1[0])) throw new Exceptions.StringException("Starts with a non capital letter: ",((Student)smth).patronymic);
			View.printWordsMark();
			((Student)smth).session_mark = Controller.readFloat();
			if(((Student)smth).session_mark > 5 || ((Student)smth).session_mark <= 2) throw new NumberException("Wrong mark: ",((Student)smth).session_mark);
			}
			catch(StringException ex1){
				System.out.println(ex1.getMessage());
		        System.out.println(ex1.getName());
			}
			catch (NumberException ex) {
				System.out.println(ex.getMessage());
		        System.out.println(ex.getName());
			}
			finally {
				System.out.println("Что-то было введено неправильно, попробуйте ещё раз");
			}
		}
	}

}