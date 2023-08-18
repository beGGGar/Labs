package view;



public class View {

	public static void printWords () {
		System.out.println("Введите число, будет создана колекция с n*4+2 элементов");
	}
	
	public static void printPair (String result) {
		System.out.println("Пара найдена ");
		System.out.println(result.split("\n")[0]);
		System.out.println(result.split("\n")[1]);
	}
	
	public static void errorMessage () {
		System.out.println("Ошибка, повторите ввод");
	
	}
	
	public static void printWordsName () {
		System.out.println("Введите имя");
	}
	public static void printWordsSex() {
		System.out.println("Введите пол");
	}
	public static void printWordsPatronymic() {
		System.out.println("Введите oтчество");
	}
	public static void printWordsAge() {
		System.out.println("Введите возраст");
	}
	public static void printWordsMark() {
		System.out.println("Введите среднюю оценку за семестр");
	}
	public static void printWordsPocketMoney() {
		System.out.println("Введите число количество карманных денег");
	}
}
