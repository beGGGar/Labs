#define _CRT_SECURE_NO_WARNINGS
//#include "StdAfx.h"
#include "iostream"
#include "cstring"
#include "locale.h"
#include <Windows.h>
#include "stdio.h"
#include "iomanip"
#include "ctype.h"
#include "stdlib.h"
#include <string.h>
#include <vector>
#include <algorithm>
#include "storage.h"
using namespace std;



int main() {
	setlocale(LC_ALL, "Rus");
	SetConsoleCP(1251); // Ввод с консоли в кодировке
	SetConsoleOutputCP(1251); // Вывод на консоль в кодировке
	vector<storage>St;
	storage R, G, B;
	char path[] = "data.txt";
	loadList(St, path);
	int c;
		
	

	DialogInterface();
	cout << "Введите номер функции: ";
	while (true) { // цикл с ключами
		c = (int)intCheck();
		switch (c) {
		case 1:
			
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:
			print();
			for (storage n : St)cout << n;
			break;
	//	case 5:
	//		//BB[0].findBread(num);
	//		break;
	//	case 6:
	//		//num = BB[0].filterNum(BB, num);
	//		break;
	//	case 7:
	//		//sortBread(BB, num);
	//		break;
	//	case 8:
	//		//num = findFresh(BB, num);
	//		break;
	//	case 9:
	//		//saveList(BB, num, path);
	//		return 0;
		default:
			cout << "Неверный запрос, повторите попытку..." << endl;
		}
		cout << "Введите номер функции: ";
	}
	cout << "Выполнение прервано... Произведен откат базы данных." << endl;
	return 0;
}
