#pragma once
#include <iostream>
#include "date1.h"
#include "common.h"

using namespace std;

class storage1 : public common {
	date1 expir;
public:
	//storage1(storage1& old);
	storage1& operator =(storage1& right);
	bool operator >(date1& D);

	//int define(int n, int max);
	void print(int n);

	void printList(int max);
	int findBread(int n);        //найти хлеб
	void saveList(int max, char* path);         // сохранение
	int  loadList(char* path);				//загрузка из базы
	void sortBread(int max);
	int findFresh(int max);
	void setDay(int day);
	void setMonth(string month);
	void setYear(int year);

	friend istream& operator>> (istream& in, storage1& St);
	friend ostream& operator<< (ostream& out, storage1& St);
};
istream& operator>> (istream& in, storage1& St);
ostream& operator<< (ostream& out, storage1& St);
	