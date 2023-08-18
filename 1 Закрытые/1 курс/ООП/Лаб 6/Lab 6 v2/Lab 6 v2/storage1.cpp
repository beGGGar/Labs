#define _CRT_SECURE_NO_WARNINGS
#include "storage1.h"
using namespace std;

void storage1::setDay(int day) { expir.day = day; }
void storage1::setMonth(string month) { expir.month = month; }
void storage1::setYear(int year) { expir.year = year; }

istream& operator>> (istream& in, storage1& St) {
	char name[4000], month[4000];
	double price;   // ����
	int quant, day, year;

	cout << "��������: ";
	cin >> name;
	cout << "����: ";
	price = doubleRangeCheck(0, 99999999);
	cout << "����������: ";
	quant = intRangeCheck(0, 99999999);
	cout << "���� � ������� dd:mm:yy" << endl << "����: ";
	day = intRangeCheck(0, 31);
	cout << "�����: ";
	cin >> month;
	cout << "���: ";
	year = intRangeCheck(0, 99);

	St.setName(name);
	St.setQuant(quant);
	St.setPrice(price);
	St.setDay(day);
	St.setMonth(month);
	St.setYear(year);
	return in;
}

ostream& operator<< (ostream& out, storage1& St) {
	out << setw(20) << St.getName() << setw(10) << St.getPrice() << setw(15) << St.getQuant() << setw(10) << St.expir.getDay() << ":" << St.expir.getMonth() << ":" << St.expir.getYear() << endl;
	return out;
}

void storage1::sortBread(int max) {
	storage1 temp;
	for (int i = 0; i < max; i++) {
		for (int j = 0; j < max - 1; j++) {
			if (this[j].getQuant() > this[j + 1].getQuant()) {
				temp = this[j];
				this[j] = this[j + 1];
				this[j + 1] = temp;
			}
		}
	}
	//for (int i = 0; i < max; i++) cout << this[i].getQuant() << endl;
	cout << "�����!" << endl;
}

int storage1::findFresh(int max) {
	storage1* temp = new storage1[max];
	char month_[] = "10";
	date1 D(10, month_, 10);
	//date1 D;
	//D.defineDate();
	int count = 0;

	for (int j = 0; j < max; j++) {
		if (this[j] > D) {
			temp[count++] = this[j];
		}
	}

	if (count == 0) {
		cout << "������ ��������� ���" << endl;
		return max;
	}

	for (int j = 0; j < count; j++)this[j] = temp[j];
	cout << "�����" << endl;
	return count;
}

bool storage1::operator>(date1& D) {
	if (this->expir.getYear() > D.getYear())return true;
	//if (this->expir.getYear() == D.getYear() && this->expir.getMonth() > D.getMonth())return true;
	if (this->expir.getYear() == D.getYear() && this->expir.getDay() > D.getDay())return true;
	return false;
}

storage1& storage1::operator=(storage1& right) {
	expir.setDay(right.expir.getDay());
	expir.setMonth(right.expir.getMonth());
	expir.setYear(right.expir.getYear());
	setName(right.getName());
	setQuant(right.getQuant());
	setPrice(right.getPrice());
	return *this;
}

void storage1::print(int n) {
	if (n == 0) {
		cout << setw(20) << "�������� ������" << setw(10) << "����" << setw(15) << "����������" << setw(10) << "����" << endl;
	}
	if (n == 1) {
		cout << setw(20) << this->getName() << setw(10) << this->getPrice() << setw(15) << this->getQuant() << setw(10) << this->expir.getDay() << ":" << this->expir.getMonth() << ":" << this->expir.getYear() << endl;
	}
}

void storage1::printList(int max) {
	//����� ������� ��������
	this[0].print(0);
	cout << "---------------------------------------------------------------------------" << endl;
	for (int i = 0; i < max; i++) {
		//this[i].print(1);
		cout << this[i];
	}
	cout << "---------------------------------------------------------------------------" << endl;
	cout << "���������� �������: " << max << endl;
}

int storage1::findBread(int max) {
	string buff;
	cout << "������� �������� ������: "; cin >> buff;

	int I = 0;
	for (int i = 0; i < max; i++) {
		if (buff == this[i].getName()) {
			this[i].print(0);
			I = 1;
			cout << this[i];
			return i;
		}
	}
	if (I == 0) {
		cout << "����� ������� ���" << endl;
		return -1;
	}
}

void storage1::saveList(int max, char* path) {
	//���������� �����
	FILE* file;
	try
	{
		file = fopen(path, "w");
	}
	catch (...)
	{
		cout << "������ �������� �����" << endl;
		fclose(file);
	}

	fprintf(file, "%d\n", max);
	for (int i = 0; i < max; i++) {
		fprintf(file, "%s\n", this[i].getName());
		fprintf(file, "%f %d\n", this[i].getPrice(), this[i].getQuant());
		fprintf(file, "%d %s %d\n", this[i].expir.getDay(), this[i].expir.getMonth(), this[i].expir.getYear());
	}
	fclose(file);
};

int storage1::loadList(char* path) {
	//������ �����
	int n = 0, quant, day, year;
	char name[4000], month[4000];
	float price;
	FILE* file;
	try
	{
		file = fopen(path, "r");
		if (file == NULL)throw 1;
	}
	catch (...)
	{
		cout << "����� ���, ������ ������." << endl;
		return 0;
	}

	fscanf(file, "%d", &n);

	for (int j = 0; j < n; j++) {

		fscanf(file, "%s", name);
		fscanf(file, "%f %d", &price, &quant);
		fscanf(file, "%d %s %d", &day, month, &year);

		this[j].setName(name);
		this[j].setPrice(price);
		this[j].setQuant(quant);
		this[j].expir.setDay(day);
		this[j].expir.setMonth(month);
		this[j].expir.setYear(year);
	}
	fclose(file);
	if (n == 0)cout << "������ ������." << endl;
	return n;
}

