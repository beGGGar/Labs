#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <locale.h>
#include <cstdio>
#include <stdio.h>
#include <string> // подключаем строки
#include <fstream> // подключаем файлы

using namespace std;

void DialogInterface() {
	cout << "Библиотека 'Тишина'" << endl;
	cout << "Выдать новый журнал____________ 1" << endl;
	cout << "Распечатать информацию о книге_ 2" << endl;
	cout << "Найти всех должников___________ 3" << endl;
	cout << "Выход и сохранение_____________ 4" << endl;
	cout << endl;
	cout << "Введите номер функции: ";
}

struct Date {
	int date;
	char* month;
	int year;
};

struct artical {
	char* fio;
	char* MagName;
	struct Date date;
	int givetime;
}reader;

bool expired(int date, char* month, int year) {

	return 0;
}

//void init_artical(artical*);
//void print_artical(artical*, int n);
//void save_list(artical*, int n);
//void load_list(artical*, int n);

int main() {
	setlocale(LC_ALL, "Rus");

	//struct artical Person;
	const int number = 15;
	artical reader[number] = {};
	int c = 0, i = 0, j = 0, a;
	char buff[30];
	DialogInterface();

	while (true) {
		cin >> c;
		switch (c) {
		case 1: // добавление читателя
			//cout << "Дата выдачи:      "; cin >> reader[i].year;
			cout << "ФИО читателя:   "; cin >> buff;
			reader[i].fio = new char[strlen(buff) + 1];
			strcpy(reader[i].fio, buff);
			cout << "Название журнала: "; cin >> buff;
			reader[i].MagName = new char[strlen(buff) + 1];
			strcpy(reader[i].MagName, buff);
			cout << "Дата выдачи: "; cin >> reader[i].date.date >> buff >> reader[i].date.year;
			reader[i].date.month = new char[strlen(buff) + 1];
			strcpy(reader[i].date.month, buff);
			cout << "На сколько месяцев выдан:      "; cin >> reader[i].givetime;
			i++;
			cout << endl;
			cout << "Введите номер функции: ";
			break;
		case 2:
			cout << "Введите номер забранной книги: "; cin >> j;
			cout << "Название журнала: " << reader[j - 1].MagName << endl;
			cout << "ФИО читателя:       " << reader[j - 1].fio << endl;
			cout << "Дата выдачи:      " << reader[j - 1].date.date << " " << reader[j - 1].date.month << " " << reader[j - 1].date.year << endl;
			cout << "Срок выдачи:      " << reader[j - 1].givetime << endl << endl;
			//cout << "Просрочен:      " << reader[j - 1].year << endl << endl;
			cout << "Введите номер функции: ";
			break;
		case 3:
			break;
		case 4:
			return 0;
		default:
			cout << "Неверный запрос, повторите попытку..." << endl;
		}
		return 0;
	}