#define _CRT_SECURE_NO_WARNINGS
#include "iostream"
#include "cstring"
#include "locale.h"
#include <Windows.h>
#include "stdio.h"
#include "iomanip"
#include "ctype.h"
#include "stdlib.h"
#include <string.h>

using namespace std;

class date {
	int day, month, year;
	friend class storage;
public:
	date();
	date(int day_, int month_, int year_);
	void defineDate();
	int  getDay() { return day; }
	int  getMonth() { return month; }
	int  getYear() { return year; }
	void setDay(int day_) { day = day_; }
	void setMonth(int month_) { month = month_; }
	void setYear(int year_) { year = year_; }
};

class storage {
	date expir;
	char* name;	   //Название товара
	double price;   // цена
	int quant, num;	    // количество, номер секции
	static int count;        // счетчик существующих объектов класса

public:
	friend void sortBread(storage* BB);		//сортировка продуктов по уменьшению количества 
	friend void findFresh(storage* BB);
	storage& operator=(storage&);
	bool operator >(date& D);

	storage();
	storage(storage& old);
	~storage();

	friend void define(storage*);
	friend storage* loadList(char* path);
	friend void loadList(storage*, char* path);				//загрузка из базы
	friend void printList(storage*);
	friend void print(storage*, int param);

	//void printList(storage* product);
	void findBread();        //найти хлеб
	void filterNum(storage* product);        //отфильтровать хлеб по секциям
	void saveList(storage* product, char* path);         // сохранение

	char* getName() const;
	double getPrice() { return price; }
	int    getNum() { return num; }
	int	   getQuant() { return quant; }
	static int    getCount() { return count; }

	void setName(char* const name_);
	void setPrice(double price_) { price = price_; }
	void setNum(int num_) { num = num_; }
	void setQuant(int quant_) { quant = quant_; }
};

int intCheck();
int dateCheck(int min, int max);
void DialogInterface();
void sortBread(storage* product);
void findFresh(storage* product);
void printList(storage* product);
int storage::count = 0;

void DialogInterface() {
	//интерфейс
	cout << "Добавить новый элемент................1" << endl;
	cout << "Распечатать базу товаров..............2" << endl;
	cout << "Поиск товара по названию..............3" << endl;
	cout << "Фильтр по номеру секции...............4" << endl;
	cout << "Сортировать по уменьшению количества..5" << endl;
	cout << "Поиск свежего товара..................6" << endl;
	cout << "Выход из программы с сохранением......7" << endl;
	cout << "......................................." << endl;
};

date::date() {
	setDay(0);
	setMonth(0);
	setYear(0);
}

date::date(int day, int month, int year) {
	setDay(day);
	setMonth(month);
	setYear(year);
}

void date::defineDate() {
	cout << "Введите дату" << endl << "День: ";
	day = dateCheck(1, 31);
	cout << "Месяц: ";
	month = dateCheck(1, 12);
	cout << "Год: ";
	year = dateCheck(0, 99);
}