#pragma once
#define _CRT_SECURE_NO_WARNINGS
//#include "StdAfx.h"
#include "iostream"
#include "IntCheck.h"
#include "common.h"
#include "date.h"


class storage : public common {
private:
	date expir;
	int num;
public:
	storage& operator=(storage& right);
	bool operator >(date& D);

	storage();
	storage(storage& old);
	//virtual int define(int n, int max);
	virtual void print(int n);

	void printList(int max);
	int findBread(int n);        //найти хлеб
	int filterNum(int max);        //отфильтровать хлеб по секциям
	void saveList(int max, char* path);         // сохранение
	int  loadList(char* path);				//загрузка из базы
	void sortBread(int max);
	int findFresh(int max);
	void setDay(int day);
	void setMonth(int month);
	void setYear(int year);

	int    getNum();
	void setNum(int num_);

	friend ostream &operator<< (ostream& out, storage& St);
	friend istream& operator>> (istream& in, storage& St);
};

ostream& operator<< (ostream& out, storage& St);
istream& operator>> (istream& in, storage& St);
