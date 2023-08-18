#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
#include <locale.h>
using namespace std;

struct artical {
	char* MagName;
	int num;
	int year;
	char* AuthorSurname;
	char* AuthorName;
	char* magName;
};

void DialogInterface() {
	cout << "Самый модный журнал Ever"                << endl;
	cout << "добавить новую статью________________ 1" << endl;
	cout << "распечатать информацию о статье______ 2" << endl;
	cout << "найти все статьи заданного автора____ 3" << endl;
	cout << "Найти всех авторов заданного журнала_ 4" << endl;
	cout << "Выход и удаление данных______________ 5" << endl;
	cout                                              << endl;
	cout << "Введите номер функции: ";
}

int i() {
	struct artical mag;
	const int number = 10;
	artical magazine[number] = {};
	int c = 0, i = 0, j = 0, a;
	char buff[30];
	DialogInterface();
	while (true) {
		cin >> c;
		switch (c) {
		case 1: // добавление статьи
			cout << "Название журнала: "; cin >> buff;
			magazine[i].MagName = new char[strlen(buff) + 1];
			strcpy(magazine[i].MagName, buff);
			cout << "Номер журнала:    "; cin >> magazine[i].num;
			cout << "Год выпуска:      "; cin >> magazine[i].year;
			cout << "Фамилия автора:   "; cin >> buff;
			magazine[i].AuthorSurname = new char[strlen(buff) + 1];
			strcpy(magazine[i].AuthorSurname, buff);
			cout << "Имя автора:       "; cin >> buff;
			magazine[i].AuthorName = new char[strlen(buff) + 1];
			strcpy(magazine[i].AuthorName, buff);
			cout << "Название статьи:  "; cin >> buff;
			magazine[i].magName = new char[strlen(buff) + 1];
			strcpy(magazine[i].magName, buff);
			i++;
			cout << endl;
			cout << "Введите номер функции: ";
			break;
		case 2:
			cout << "Введите порядковый номер статьи: "; cin >> j;
			cout << "Данные журнала номер " << j << ":" << endl;
			cout << "Название журнала: " << magazine[j - 1].MagName << endl;
			cout << "Номер журнала:    " << magazine[j - 1].num << endl;
			cout << "Год выпуска:      " << magazine[j - 1].year << endl;
			cout << "Фамилия автора:   " << magazine[j - 1].AuthorSurname << endl;
			cout << "Имя автора:       " << magazine[j - 1].AuthorName << endl;
			cout << "Название статьи:  " << magazine[j - 1].magName << endl << endl;
			cout << "Введите номер функции: ";
			break;
		case 3:
			cout << "Фамилия автора: "; cin >> buff;
			mag.AuthorSurname = new char[strlen(buff) + 1];
			strcpy(mag.AuthorSurname, buff);
			cout << "Имя автора:     "; cin >> buff;
			mag.AuthorName = new char[strlen(buff) + 1];
			strcpy(mag.AuthorName, buff);
			cout << "Найденные статьи по автору:";
			for (int a = 0; magazine[a].AuthorName; a++)
				if (*magazine[a].AuthorName == *mag.AuthorName && *magazine[a].AuthorSurname == *mag.AuthorSurname)
					cout << endl << magazine[a].magName;
			cout << endl << endl << "Введите номер функции: ";
			break;
		case 4:
			cout << "Название журнала: "; cin >> buff;
			mag.MagName = new char[strlen(buff) + 1];
			strcpy(mag.MagName, buff);
			cout << "Номер журнала:    "; cin >> mag.num;
			cout << "Год выпуска:      "; cin >> mag.year;
			for (int a = 0; magazine[a].AuthorName; a++)
				if (*magazine[a].MagName == *mag.MagName && magazine[a].num == mag.num && magazine[a].year == mag.year) {
					cout << endl << "Фамилия автора: " << magazine[a].AuthorSurname << endl;
					cout << "Имя автора:     " << magazine[a].AuthorName << endl << endl;
				}
			cout << endl << "Введите номер функции: ";
		default:
			cout << "Неверный запрос, повторите попытку..." << endl;
		case 5:
			return 0;
		}
	}
	delete[] magazine;
}
void main() {
	setlocale(LC_ALL, "Rus");
	i();
	/*cout << "Название журнала: "; cin >> buff;
	mag.MagName = new char[strlen(buff) + 1];
	strcpy(mag.MagName, buff);
	cout << "Номер журнала:    "; cin >> mag.num;
	cout << "Год выпуска:      "; cin >> mag.year;
	cout << "Фамилия автора:   "; cin >> buff;
	mag.AuthorSurname = new char[strlen(buff) + 1];
	strcpy(mag.AuthorSurname, buff);
	cout << "Имя автора:       "; cin >> buff;
	mag.AuthorName = new char[strlen(buff) + 1];
	strcpy(mag.AuthorName, buff);
	cout << "Название статьи:  "; cin >> buff;
	mag.magName = new char[strlen(buff) + 1];
	strcpy(mag.magName, buff);*/
}