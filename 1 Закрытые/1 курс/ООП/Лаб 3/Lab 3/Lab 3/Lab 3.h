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
	char* name;	   //�������� ������
	double price;   // ����
	int quant, num;	    // ����������, ����� ������
	static int count;        // ������� ������������ �������� ������

public:
	friend void sortBread(storage* BB);		//���������� ��������� �� ���������� ���������� 
	friend void findFresh(storage* BB);
	storage& operator=(storage&);
	bool operator >(date& D);

	storage();
	storage(storage& old);
	~storage();

	friend void define(storage*);
	friend storage* loadList(char* path);
	friend void loadList(storage*, char* path);				//�������� �� ����
	friend void printList(storage*);
	friend void print(storage*, int param);

	//void printList(storage* product);
	void findBread();        //����� ����
	void filterNum(storage* product);        //������������� ���� �� �������
	void saveList(storage* product, char* path);         // ����������

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
	//���������
	cout << "�������� ����� �������................1" << endl;
	cout << "����������� ���� �������..............2" << endl;
	cout << "����� ������ �� ��������..............3" << endl;
	cout << "������ �� ������ ������...............4" << endl;
	cout << "����������� �� ���������� ����������..5" << endl;
	cout << "����� ������� ������..................6" << endl;
	cout << "����� �� ��������� � �����������......7" << endl;
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
	cout << "������� ����" << endl << "����: ";
	day = dateCheck(1, 31);
	cout << "�����: ";
	month = dateCheck(1, 12);
	cout << "���: ";
	year = dateCheck(0, 99);
}