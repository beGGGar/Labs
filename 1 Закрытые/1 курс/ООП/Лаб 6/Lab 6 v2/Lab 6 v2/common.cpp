#define _CRT_SECURE_NO_WARNINGS
#include "common.h"
using namespace std;

int common::ClassCount = 0;

string common::getName() { return name; }
double common::getPrice() { return price; }
int	   common::getQuant() { return quant; }
int    common::getClassCount() { return ClassCount; }

void common::setQuant(int quant_) { quant = quant_; }
void common::setPrice(double price_) { price = price_; }
void common::setName(string name_) { name = name_; }

common::common(common& old) {
	//expir = old.expir;
	setName(old.getName());
	setQuant(old.getQuant());
	setPrice(old.getPrice());
}
common::common() {
	//����������� ��-���������
	name = "NotStated";
	price = 0;
	quant = 0;
	ClassCount++;
}

common::~common() { ClassCount--; }

void DialogInterface() {
	//���������
	cout << "(1) �������� ����� �������" << endl;
	cout << "(2) ����������� ���� �������" << endl;
	cout << "(3) ����� ������ �� ��������" << endl;
	cout << "(4) ������ �� ������ ������" << endl;
	cout << "(5) ����������� �� ���������� ����������" << endl;
	cout << "(6) ����� ������� ������" << endl;
	cout << "(7) ������ ������ �� �����" << endl;
	cout << "(8) ������ ������" << endl;
	cout << "(9) ����� �� ��������� � �����������" << endl;
	cout << "(10) ����� ���� ������" << endl;
	cout << "storage  - 1 ��" << endl;
	cout << "storage1 - 2 ��" << endl;
	cout << "......................................." << endl;
};

//int common::newDelivery(int max) {
	//	int id = 0;
	//	char buff[4000];
	//
	//	cout << "������� �������� ������: "; cin >> buff;
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
	//	if (I == 0) cout << "����� ������� ���" << endl;
	//
	//	return max;
	//}

