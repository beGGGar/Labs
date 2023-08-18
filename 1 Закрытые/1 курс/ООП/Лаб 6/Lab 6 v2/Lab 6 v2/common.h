#pragma once
#define _CRT_SECURE_NO_WARNINGS
#include "iostream"
#include "iomanip"
#include <string>

class common {
	string name;
	double price;   // цена
	int quant;
	static int ClassCount;
public:
	common();
	~common();
	common(common& old);
	double getPrice();
	int	   getQuant();
	int    getClassCount();
	string getName();
	void setQuant(int quant_);
	void setPrice(double price_);
	void setName(string name_);

	virtual void print(int n) = 0;
	virtual void printList(int max) = 0;
	virtual int findBread(int n) = 0;
	virtual void saveList(int max, char* path) = 0;
	virtual void sortBread(int max) = 0;
	virtual int  loadList(char* path) = 0;
	virtual int findFresh(int max) = 0;
};
void DialogInterface();

