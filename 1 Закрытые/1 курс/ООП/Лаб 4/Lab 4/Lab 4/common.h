#define _CRT_SECURE_NO_WARNINGS
#include "iostream"
#include "cstring"
#include "stdio.h"
#include "iomanip"
#include "ctype.h"
#include "stdlib.h"
#include "IntCheck.h"
using namespace std;

//class dateC {
//public:
//	friend class common;
//};
class common {
	//dateC expir;
	char* name;
	double price;   // цена
	int quant;
	static int count;
public:
	common();
	~common();
	common(common& old);
	double getPrice() { return price; }
	int	   getQuant() { return quant; }
	int    getCount() { return count; }
	char* getName();
	void setQuant(int quant_) { quant = quant_; }
	void setPrice(double price_) { price = price_; }
	void setName(char* name_);

	virtual void print(int n);
	virtual int define(int n, int max);

	virtual void printList(int max) {}
	virtual void findBread(int n) {}
	virtual int filterNum(int max) { return 0; }
	virtual void saveList(int max, char* path) {}
	virtual int  loadList(char* path) { return 0; }
	virtual void sortBread(int max) {}
	virtual int findFresh(int max) { return 0; }
};

int common::count = 0;

void common::print(int n) {
	if (n == 0) {
		cout << setw(20) << "Название товара" << setw(10) << "цена" << setw(15) << "количество" << endl;
	}
	if (n == 1) {
		cout << setw(20) << this->getName() << setw(10) << this->getPrice() << setw(15) << this->getQuant() << endl;
	}
}

char* common::getName() {
	/*char* buff = new char[strlen(name)+1];
	strcpy(buff, name);
	return buff;*/
	return name;
}

void common::setName(char* name_) {
	if (this->name != nullptr) delete[] this->name;
	this->name = new char[strlen(name_) + 1];
	strcpy(this->name, name_);
}

common::common(common& old) {
	//expir = old.expir;
	setName(old.getName());
	setQuant(old.getQuant());
	setPrice(old.getPrice());
}
common::common() {
	//Конструктор по-умолчанию
	char buff[] = "None";
	name = new char[strlen(buff) + 1];
	strcpy(name, buff);
	price = 0;
	quant = 0;
	count++;
}

common::~common() {
	delete[] name;
	count--;
}

int common::define(int n, int max) {
	if (n >= max) {
		cout << "Места больше нет!" << endl;
		return 0;
	}
	char buff[4000];
	cout << "Название :";
	cin >> buff;
	name = new char[strlen(buff) + 1];
	strcpy(name, buff);

	cout << "Цена: ";
	price = intCheck();
	cout << "Количество: ";
	quant = intCheck();
	return 0;
}