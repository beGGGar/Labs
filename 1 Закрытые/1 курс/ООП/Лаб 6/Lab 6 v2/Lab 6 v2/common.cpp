#define _CRT_SECURE_NO_WARNINGS
#include "common.h"
using namespace std;

int common::ClassCount = 0;

string common::getName() { return name; }
double common::getPrice() { return price; }
int	   common::getQuant() { return quant; }
int    common::getClassCount() { return ClassCount; }

void common::setQuant(int quant_) { quant = quant_; }
void common::setPrice(double price_) { price = price_; }
void common::setName(string name_) { name = name_; }

common::common(common& old) {
	//expir = old.expir;
	setName(old.getName());
	setQuant(old.getQuant());
	setPrice(old.getPrice());
}
common::common() {
	//Конструктор по-умолчанию
	name = "NotStated";
	price = 0;
	quant = 0;
	ClassCount++;
}

common::~common() { ClassCount--; }

void DialogInterface() {
	//интерфейс
	cout << "(1) Добавить новый элемент" << endl;
	cout << "(2) Распечатать базу товаров" << endl;
	cout << "(3) Поиск товара по названию" << endl;
	cout << "(4) Фильтр по номеру секции" << endl;
	cout << "(5) Сортировать по уменьшению количества" << endl;
	cout << "(6) Поиск свежего товара" << endl;
	cout << "(7) Приход товара на склад" << endl;
	cout << "(8) Расход товара" << endl;
	cout << "(9) Выход из программы с сохранением" << endl;
	cout << "(10) Смена базы данных" << endl;
	cout << "storage  - 1 БД" << endl;
	cout << "storage1 - 2 БД" << endl;
	cout << "......................................." << endl;
};

//int common::newDelivery(int max) {
	//	int id = 0;
	//	char buff[4000];
	//
	//	cout << "Введите название товара: "; cin >> buff;
	//	int I = 0;
	//	for (id = 0; id < max; id++) {
	//		if (strcmp(buff, this[id].getName()) == 0) {
	//			if (I == 0) {
	//				this[id].print(0);
	//				I = 1;
	//			}
	//			//this[i].print(1);
	//		}
	//	}
	//	if (I == 0) cout << "Таких товаров нет" << endl;
	//
	//	return max;
	//}

