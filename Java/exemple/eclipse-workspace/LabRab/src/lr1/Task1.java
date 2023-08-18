package lr1;

import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Класс предназначен для игры в "Угадай число" с компьютером.
 * Пользователь загадывает число, а компьютер отгадывает число в минимальное число ходов.
 * @author Raznoglazov Nukita PIN-24
 * @version 1.2
 *
 */
public class Task1 {

//Model
/**
* Производит вычисления.
* На входе получает массив с 5 значениями.
* 0 элемент является тумблером, который при включении завканчивает цикл.
* 1 элемент отвечает за количество итерации, увеличивается с каждым циклом.
* 2 эллемент является текущим числом, на котором остановился компьютер.
* 3 элемент является слагаемым, которое компьютер складывает/вычитает с теукщим числом для нахождения загаданного.
* 4 элемент является утверждением пользователя: больше, меньше, отгадано.
* На выходе возвращается тот же массив с произведенными в нем изменениями.
* @param mas
* @return mas
*/
public static int[] model(int[] mas) {
mas[4] = controller();
mas[3] = mas[3] / 2;


if (mas[4] == 1) {
if(mas[3]<=0)
{
mas[3] = 1;
}
mas[2] = mas[2] - mas[3];
}

if (mas[4] == 2) {
if(mas[3]<=0)
{
mas[3] = 1;
}
mas[2] = mas[2] + mas[3];
}

if (mas[1]==7)
{
mas[0]=2;
}

if (mas[4] == 0) {
mas[0] = 1;
}
return mas;
}

//view

/**
* Выводит строки в консоль
* Принимается строка и выводится в консоль
* @param sen
*/
public static void view(String sen) {
System.out.print(sen);
}

/**
* Выводит числа в консоль
* Принимается int число и выводится в консоль
* @param num
*/
public static void view(int num) {
System.out.print(num);
}

/**
* Считывает ввод числа с клавиатуры.
* Позволяет вввести число равное 0,1,2. Осуществляет проверку, при провале проверки отгаданнным считается прошлое число.
* @return ans
*/
//controller
public static int controller() {
Scanner in = new Scanner(System.in);
int ans = 0;
try {
ans = in.nextInt();
if(ans != 0 && ans!= 1 && ans!= 2) {
ans = 0;
}
} catch (Exception e) {
System.out.println(e.getMessage());
}

return ans;
}

/**
* Часть программы в которой происходит взаимодействие с пользователем.
* Применяются функции view, model
* @param args
*/
public static void main(String args[]) {
int[] mas = { 0, 0, 50, 50, 0 };
System.out.println("F");
view("Загадайте число. Компьютер будет отгадывать. "
+ "Нажимайте 1, если загаданное число меньше, 2 если больше, 0 если число отгадано \n");
while (true) {
view("Это ваше число? ");
view(mas[2]);
view("\n");
mas = model(mas);
mas[1]++;


if (mas[0] == 1) {
view("Ваше число отгадано \n");
view(mas[2]);
break;
}

if (mas[0] == 2) {
view("Вы мухлюете");
break;
}
}

}
}
