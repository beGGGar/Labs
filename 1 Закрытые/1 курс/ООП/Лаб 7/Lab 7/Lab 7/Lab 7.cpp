#define _CRT_SECURE_NO_WARNINGS
//#include "StdAfx.h"
#include "storage.h"
#define max_bread 100
using namespace std;

template<class X>
void define(X* R, int& max) {
	try
	{
		if (max >= max_bread) throw 1;
		cin >> R[max];
		max++;
	}
	catch (int n)
	{
		if (n == 1) { cout << "Место кончилось!" << endl; }
	}
}

int main() {
	setlocale(LC_ALL, "Rus");
	SetConsoleCP(1251); // Ввод с консоли в кодировке
	SetConsoleOutputCP(1251); // Вывод на консоль в кодировке

	storage* BB = new storage[max_bread];
	char path[] = "data.txt";
	int num = BB[0].loadList(BB, path);
	int c;
	vector<storage>St;
	char C[] = "dsgsdfg";
	BB[0].setName(C);
	cout << BB[0].getName();
	DialogInterface();
	cout << "Введите номер функции: ";
	while (true) { // цикл с ключами
		c = intCheck();
		switch (c) {
		case 1: // добавление товарa
			define(BB, num);
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			printList(BB, num);
			break;
		case 5:
			BB[0].findBread(num);
			break;
		case 6:
			num = BB[0].filterNum(BB, num);
			break;
		case 7:
			sortBread(BB, num);
			break;
		case 8:
			num = findFresh(BB, num);
			break;
		case 9:
			saveList(BB, num, path);
			delete[] BB;
			return 0;
		default:
			cout << "Неверный запрос, повторите попытку..." << endl;
		}
		cout << "Введите номер функции: ";
	}
	cout << "Выполнение прервано... Произведен откат базы данных." << endl;
	return 0;
}
