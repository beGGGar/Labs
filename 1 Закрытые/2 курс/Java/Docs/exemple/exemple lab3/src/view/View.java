package view;



public class View {

	public static void printWords () {
		System.out.println("Введите число, будет создана колекция с n*4+2 элементов");
	}
	
	public static void printPair (String result) {
		System.out.println("Пара:");
		System.out.println(result.split("\n")[0]);
		System.out.println(result.split("\n")[1]);
	}
	
	public static void errorMessage () {
		System.out.println("Ошибка, повторите ввод");
	
	}
}
