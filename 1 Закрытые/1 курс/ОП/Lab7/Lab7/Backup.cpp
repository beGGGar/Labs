#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <locale.h>
#include <cstdio>
#include <stdio.h>
#include <string> // ���������� ������
#include <fstream> // ���������� �����

using namespace std;

void DialogInterface() {
	cout << "���������� '������'" << endl;
	cout << "������ ����� ������____________ 1" << endl;
	cout << "����������� ���������� � �����_ 2" << endl;
	cout << "����� ���� ���������___________ 3" << endl;
	cout << "����� � ����������_____________ 4" << endl;
	cout << endl;
	cout << "������� ����� �������: ";
}

struct Date {
	int date;
	char* month;
	int year;
};

struct artical {
	char* fio;
	char* MagName;
	struct Date date;
	int givetime;
}reader;

bool expired(int date, char* month, int year) {

	return 0;
}

//void init_artical(artical*);
//void print_artical(artical*, int n);
//void save_list(artical*, int n);
//void load_list(artical*, int n);

int main() {
	setlocale(LC_ALL, "Rus");

	//struct artical Person;
	const int number = 15;
	artical reader[number] = {};
	int c = 0, i = 0, j = 0, a;
	char buff[30];
	DialogInterface();

	while (true) {
		cin >> c;
		switch (c) {
		case 1: // ���������� ��������
			//cout << "���� ������:      "; cin >> reader[i].year;
			cout << "��� ��������:   "; cin >> buff;
			reader[i].fio = new char[strlen(buff) + 1];
			strcpy(reader[i].fio, buff);
			cout << "�������� �������: "; cin >> buff;
			reader[i].MagName = new char[strlen(buff) + 1];
			strcpy(reader[i].MagName, buff);
			cout << "���� ������: "; cin >> reader[i].date.date >> buff >> reader[i].date.year;
			reader[i].date.month = new char[strlen(buff) + 1];
			strcpy(reader[i].date.month, buff);
			cout << "�� ������� ������� �����:      "; cin >> reader[i].givetime;
			i++;
			cout << endl;
			cout << "������� ����� �������: ";
			break;
		case 2:
			cout << "������� ����� ��������� �����: "; cin >> j;
			cout << "�������� �������: " << reader[j - 1].MagName << endl;
			cout << "��� ��������:       " << reader[j - 1].fio << endl;
			cout << "���� ������:      " << reader[j - 1].date.date << " " << reader[j - 1].date.month << " " << reader[j - 1].date.year << endl;
			cout << "���� ������:      " << reader[j - 1].givetime << endl << endl;
			//cout << "���������:      " << reader[j - 1].year << endl << endl;
			cout << "������� ����� �������: ";
			break;
		case 3:
			break;
		case 4:
			return 0;
		default:
			cout << "�������� ������, ��������� �������..." << endl;
		}
		return 0;
	}