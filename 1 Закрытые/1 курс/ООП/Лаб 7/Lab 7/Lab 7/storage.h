#include "iostream"
#include "cstring"
#include "locale.h"
#include <Windows.h>
#include "stdio.h"
#include "iomanip"
#include "ctype.h"
#include "stdlib.h"
#include <string.h>
#include <vector>
#include <algorithm>
#define max_bread 100
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
	friend void sortBread(storage* BB, int n);		//���������� ��������� �� ���������� ���������� 
	friend int findFresh(storage* BB, int n);
	storage& operator=(storage& right);
	bool operator >(date& D);

	storage();
	storage(storage& old);
	~storage();
	
	friend void printList(storage* product, int n);
	void findBread(int max);        //����� ����
	int filterNum(storage* product, int n);        //������������� ���� �� �������
	friend void saveList(storage* product, int n, char* path);         // ����������
	int  loadList(storage* product, char* path);				//�������� �� ����
	void print(int n);

	char* getName() { return name; }
	double getPrice() { return price; }
	int    getNum() { return num; }
	int	   getQuant() { return quant; }
	int    getCount() { return count; }

	void setName(char* name_);
	void setPrice(double price_) { price = price_; }
	void setNum(int num_) { num = num_; }
	void setQuant(int quant_) { quant = quant_; }

	friend ostream& operator<< (ostream& out, storage& St);
	friend istream& operator>> (istream& in, storage& St);
};

int storage::count = 0;

double intCheck();
double valueCheck(double min, double max);
void DialogInterface();
void sortBread(storage* product, int n);
int findFresh(storage* product, int n);

ostream& operator<< (ostream& out, storage& St) {
	out << setw(20) << St.getName() << setw(10) << St.getPrice() << setw(15) << St.getQuant() << setw(15) << St.getNum() << setw(10) << St.expir.getDay() << ":" << St.expir.getMonth() << ":" << St.expir.getYear() << endl;
	return out;
}

istream& operator>> (istream& in, storage& St) {
	char name[4000];
	double price;   // ����
	int quant, day, month, year, num;
	cout << "��������: ";
	in >> name;
	cout << "����: ";
	price = valueCheck(0, 99999999);
	cout << "����������: ";
	quant = valueCheck(0, 99999999);
	cout << "������: ";
	num = valueCheck(0, 99999999);
	cout << "���� � ������� dd:mm:yy" << endl << "����: ";
	day = valueCheck(0, 31);
	cout << "�����: ";
	month = valueCheck(0, 12);
	cout << "���: ";
	year = valueCheck(0, 99);
	St.setName(name);
	St.setNum(num);
	St.setQuant(quant);
	St.setPrice(price);
	St.expir.setDay(day);
	St.expir.setMonth(month);
	St.expir.setYear(year);
	return in;
}

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
	cout << "���� � ������� dd:mm:yy" << endl << "����: ";
	day = valueCheck(1, 31);
	cout << "�����: ";
	month = valueCheck(1, 12);
	cout << "���: ";
	year = valueCheck(0, 99);
}

void storage::setName(char* name_) {
	//�������� �������� �� nullptr � ���� �� nullptr, �� ��������
	if (this->name != nullptr) delete[] this->name;
	this->name = new char[strlen(name_) + 1];
	strcpy(this->name, name_);
}

storage::storage() {
	//����������� ��-���������
	char buff[] = "None";
	//setName(buff);
	name = new char[strlen(buff) + 1];
	strcpy(name, buff);
	price = 0;
	quant = 0;
	num = 0;
	expir.day = 0;
	expir.month = 0;
	expir.year = 0;
	count++;
}

storage::storage(storage& old) {
	expir = old.expir;
	char* buff = old.getName();
	setName(buff);
	num = old.getNum();
	quant = old.getQuant();
	price = old.getPrice();
}

storage::~storage() {
	delete[] name;
	count--;
}

bool storage::operator>(date& D) {
	if (this->expir.getYear() > D.getYear())return true;
	if (this->expir.getYear() == D.getYear() && this->expir.getMonth() > D.getMonth())return true;
	if (this->expir.getYear() == D.getYear() && this->expir.getMonth() == D.getMonth() && this->expir.getDay() > D.getDay())return true;
	return false;
}

storage& storage::operator=(storage& right) {
	this->expir.setDay(right.expir.getDay());
	this->expir.setMonth(right.expir.getMonth());
	this->expir.setYear(right.expir.getYear());
	this->setName(right.getName());
	this->setNum(right.getNum());
	this->setQuant(right.getQuant());
	this->setPrice(right.getPrice());
	return *this;
}

int storage::filterNum(storage* product, int n) {
	//�� �� ����� ��� � ����� �� �� ������
	int id, count = 0;
	storage* R = product;
	storage* temp = new storage[n];
	cout << "������� �������� ������: "; cin >> id;

	for (int j = 0; j < n; j++) {
		if (R[j].getNum() == id) {
			temp[count++] = R[j];
		}
	}
	if (count == 0) {
		cout << "������� � ������ ������ ���" << endl;
		delete[] temp;
		return n;
	}
	else {
		for (int j = 0; j < count; j++)R[j] = temp[j];
		//cout << count;
		delete[] temp;
		return count;
	}
}

void printList(storage* product, int n) {
	//����� ������� ��������
	storage* R = product;
	R[0].print(0);
	cout << "---------------------------------------------------------------------------" << endl;
	for (int i = 0; i < n; i++) {
		cout << R[i];
	}
	cout << "---------------------------------------------------------------------------" << endl;
	cout << "���������� �������: " << n << endl;
}

void storage::findBread(int max) {
	char buff[4000] = {};
	cout << "������� �������� ������: "; cin >> buff;

	int I = 0;
	for (int i = 0; i < max; i++) {
		if (strcmp(buff, this[i].getName()) == 0) {
			if (I == 0) {
				this[i].print(0);
				I = 1;
			}
			cout << this[i];
		}
	}
	if (I == 0) cout << "����� ������� ���" << endl;
}

void saveList(storage* product, int n, char* path) {
	//���������� �����
	storage* R = product;
	FILE* file;
	file = fopen(path, "w");

	fprintf(file, "%d\n", n);
	for (R; R < product + n; R++) {
		fprintf(file, "%s\n", R->getName());
		fprintf(file, "%f %d %d\n", R->getPrice(), R->getQuant(), R->getNum());
		fprintf(file, "%d %d %d\n", R->expir.getDay(), R->expir.getMonth(), R->expir.getYear());
	}
	fclose(file);
};

int storage::loadList(storage* product, char* path) {
	//������ �����
	storage* R = product;
	int n = 0, i = 0, quant, num, day, month, year;
	char buff[4000];
	float price;
	FILE* file;
	file = fopen(path, "r");
	if (file == NULL) {
		cout << "����� ���, ������ ������." << endl;
		return 0;
	}

	fscanf(file, "%d", &n);

	for (int j = 0; j < n; j++) {
		fscanf(file, "%s", buff);
		R[j].setName(buff);

		fscanf(file, "%f %d %d", &price, &quant, &num);
		R[j].setPrice(price);
		R[j].setQuant(quant);
		R[j].setNum(num);
		fscanf(file, "%d %d %d", &day, &month, &year);
		R[j].expir.setDay(day);
		R[j].expir.setMonth(month);
		R[j].expir.setYear(year);
	}
	fclose(file);
	if (n == 0)cout << "������ ������." << endl;
	return n;
}



void storage::print(int n) {
	if (n == 0) {
		cout << setw(20) << "�������� ������" << setw(10) << "����" << setw(15) << "����������" << setw(15) << "������" << setw(10) << "����" << endl;
	}
	if (n == 1) {
		cout << setw(20) << this->getName() << setw(10) << this->getPrice() << setw(15) << this->getQuant() << setw(15) << this->getNum() << setw(10) << this->expir.getDay() << ":" << this->expir.getMonth() << ":" << this->expir.getYear() << endl;
	}
}



int findFresh(storage* product, int n) {
	storage* R = product;
	storage* temp = new storage[max_bread];
	date D(10, 10, 10);
	//date D;
	//D.defineDate();
	int count = 0;

	for (int j = 0; j < n; j++) {
		if (R[j] > D) {// ������� � ����������� ����, � �� � ��������������
			temp[count++] = R[j];
		}
	}

	if (count == 0) {
		cout << "������ ��������� ���" << endl;
		return n;
	}

	for (int j = 0; j < count; j++)R[j] = temp[j];
	cout << "�����" << endl;
	return count;
}

void DialogInterface() {
	//���������
	cout << "(1) �������� ������� � ������" << endl;
	cout << "(2) �������� ������� � �����" << endl;
	cout << "(3) �������� ��������" << endl;
	cout << "(4) ����������� ���� �������" << endl;
	cout << "(5) ����� ������ �� ��������" << endl;
	cout << "(6) ������ �� ������ ������" << endl;
	cout << "(7) ����������� �� ���������� ����������" << endl;
	cout << "(8) ����� ������� ������" << endl;
	cout << "(9) ����� �� ��������� � �����������" << endl;
	cout << "......................................." << endl;
};

void sortBread(storage* product, int n) {
	//���������� �� ����������
	storage temp;
	storage* R = product;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n - 1; j++) {
			if ((R + j)->getQuant() > (R + j + 1)->getQuant()) {
				temp = R[j];
				R[j] = R[j + 1];
				R[j + 1] = temp;
			}
		}
	}
	cout << "�����" << endl;
}



double intCheck() {
	char buff[4000];
	double rez;
	while (true) {
		try
		{
			cin >> buff;
			for (int i = 0; i < strlen(buff); i++) if (isalpha(buff[i]))throw 1;
			rez = atof(buff);
			return rez;
		}
		catch (int n)
		{
			if (n == 1)cout << "������ ��������� ��������. ��������� �������..." << endl;

		}
	}
}

//dateCheck
double valueCheck(double min, double max) {
	double rez;
	while (true) {
		try
		{
			rez = intCheck();
			if (rez > max)throw 1;
			if (rez < min)throw 2;
			return rez;
		}
		catch (int n)
		{
			if (n == 1)cout << "�������� ������� ������. ��������� �������..." << endl;
			if (n == 2)cout << "�������� ������� ����. ��������� �������..." << endl;
		}
	}
}