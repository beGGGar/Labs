#define _CRT_SECURE_NO_WARNINGS
#include "iostream"
//#include "cstring"
//#include "stdio.h"
#include "iomanip"
//#include "ctype.h"
//#include "stdlib.h"
#include "IntCheck.h"
using namespace std;

class common {
	char* name;
	double price;   // цена
	int quant;
	static int ClassCount;
public:
	common();
	~common();
	common(common& old);
	double getPrice() { return price; }
	int	   getQuant() { return quant; }
	int    getClassCount() { return ClassCount; }
	char* getName();
	void setQuant(int quant_) { quant = quant_; }
	void setPrice(double price_) { price = price_; }
	void setName(char* name_);

	virtual void print(int n) = 0;
	virtual void printList(int max) = 0;
	virtual int findBread(int n) = 0;
	virtual void saveList(int max, char* path) = 0;
	virtual void sortBread(int max) = 0;
	virtual int  loadList(char* path) = 0;
	virtual int findFresh(int max) = 0;
};

int common::ClassCount = 0;

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
	ClassCount++;
}

common::~common() {
	delete[] name;
	ClassCount--;
}

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