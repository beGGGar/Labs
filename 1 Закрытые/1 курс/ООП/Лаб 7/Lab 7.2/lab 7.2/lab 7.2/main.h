#define _CRT_SECURE_NO_WARNINGS
#include "iostream"
//#include "StdAfx.h"
#include <string.h>
#include "locale.h"
#include <Windows.h>
#include "iomanip"
#include <vector>
#include <algorithm>
#include <list>
#include <map>
using namespace std;

class date {
	int day, month, year;
	friend class storage;
public:
	date();
	date(int day_, int month_, int year_);
	void defineDate();
	int  getDay();
	int  getMonth();
	int  getYear();
	void setDay(int day_);
	void setMonth(int month_);
	void setYear(int year_);
};

class storage {
	date expir;
	string name;	   //Название товара
	double price;   // цена
	int quant, num;	    // количество, номер секции
	static int count;        // счетчик существующих объектов класса

public:
	friend void sortBread(list<storage>& ST);		//сортировка продуктов по уменьшению количества 
	friend void findFresh(list<storage>& ST);

	
	bool operator >(date& D);

	storage();
	storage(string name, double price, int quant, int num, int day, int month, int year);
	storage(const storage&);
	~storage();

	friend void printList(const list<storage>& ST);
	void findBread(list<storage>& ST);        //найти хлеб
	void filterNum(list<storage>& ST);        //отфильтровать хлеб по секциям
	friend void saveList(list<storage>& ST, char* path);         // сохранение
	friend void addToEnd(list<storage>&);
	friend void addToStart(list<storage>&);

	string getName();
	double getPrice();
	int    getNum();
	int	   getQuant();
	int    getCount();
	int getExpirDay();
	int getExpirMonth();
	int getExpirYear();

	void setName(string name_);
	void setPrice(double price_);
	void setNum(int num_);
	void setQuant(int quant_);

	friend ostream& operator<< (ostream& out, storage& St);
	friend istream& operator>> (istream& in, storage& St);
	friend ostream& operator<< (ostream& out, list<storage>& St);
	storage& operator=(const storage& right);
};

int storage::count = 0;


void loadList(char* path, list<storage>&ST);        //загрузка из базы
double intCheck();
double valueCheck(double min, double max);
void DialogInterface();
void printTitle();
void delBred(list<storage>& ST);
//void define(list<storage>&);