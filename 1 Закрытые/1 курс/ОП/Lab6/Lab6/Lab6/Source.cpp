#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
#include <locale.h>
using namespace std;

struct artical {
	char* MagName;
	int num;
	int year;
	char* AuthorSurname;
	char* AuthorName;
	char* magName;
};

void DialogInterface() {
	cout << "����� ������ ������ Ever"                << endl;
	cout << "�������� ����� ������________________ 1" << endl;
	cout << "����������� ���������� � ������______ 2" << endl;
	cout << "����� ��� ������ ��������� ������____ 3" << endl;
	cout << "����� ���� ������� ��������� �������_ 4" << endl;
	cout << "����� � �������� ������______________ 5" << endl;
	cout                                              << endl;
	cout << "������� ����� �������: ";
}

int i() {
	struct artical mag;
	const int number = 10;
	artical magazine[number] = {};
	int c = 0, i = 0, j = 0, a;
	char buff[30];
	DialogInterface();
	while (true) {
		cin >> c;
		switch (c) {
		case 1: // ���������� ������
			cout << "�������� �������: "; cin >> buff;
			magazine[i].MagName = new char[strlen(buff) + 1];
			strcpy(magazine[i].MagName, buff);
			cout << "����� �������:    "; cin >> magazine[i].num;
			cout << "��� �������:      "; cin >> magazine[i].year;
			cout << "������� ������:   "; cin >> buff;
			magazine[i].AuthorSurname = new char[strlen(buff) + 1];
			strcpy(magazine[i].AuthorSurname, buff);
			cout << "��� ������:       "; cin >> buff;
			magazine[i].AuthorName = new char[strlen(buff) + 1];
			strcpy(magazine[i].AuthorName, buff);
			cout << "�������� ������:  "; cin >> buff;
			magazine[i].magName = new char[strlen(buff) + 1];
			strcpy(magazine[i].magName, buff);
			i++;
			cout << endl;
			cout << "������� ����� �������: ";
			break;
		case 2:
			cout << "������� ���������� ����� ������: "; cin >> j;
			cout << "������ ������� ����� " << j << ":" << endl;
			cout << "�������� �������: " << magazine[j - 1].MagName << endl;
			cout << "����� �������:    " << magazine[j - 1].num << endl;
			cout << "��� �������:      " << magazine[j - 1].year << endl;
			cout << "������� ������:   " << magazine[j - 1].AuthorSurname << endl;
			cout << "��� ������:       " << magazine[j - 1].AuthorName << endl;
			cout << "�������� ������:  " << magazine[j - 1].magName << endl << endl;
			cout << "������� ����� �������: ";
			break;
		case 3:
			cout << "������� ������: "; cin >> buff;
			mag.AuthorSurname = new char[strlen(buff) + 1];
			strcpy(mag.AuthorSurname, buff);
			cout << "��� ������:     "; cin >> buff;
			mag.AuthorName = new char[strlen(buff) + 1];
			strcpy(mag.AuthorName, buff);
			cout << "��������� ������ �� ������:";
			for (int a = 0; magazine[a].AuthorName; a++)
				if (*magazine[a].AuthorName == *mag.AuthorName && *magazine[a].AuthorSurname == *mag.AuthorSurname)
					cout << endl << magazine[a].magName;
			cout << endl << endl << "������� ����� �������: ";
			break;
		case 4:
			cout << "�������� �������: "; cin >> buff;
			mag.MagName = new char[strlen(buff) + 1];
			strcpy(mag.MagName, buff);
			cout << "����� �������:    "; cin >> mag.num;
			cout << "��� �������:      "; cin >> mag.year;
			for (int a = 0; magazine[a].AuthorName; a++)
				if (*magazine[a].MagName == *mag.MagName && magazine[a].num == mag.num && magazine[a].year == mag.year) {
					cout << endl << "������� ������: " << magazine[a].AuthorSurname << endl;
					cout << "��� ������:     " << magazine[a].AuthorName << endl << endl;
				}
			cout << endl << "������� ����� �������: ";
		default:
			cout << "�������� ������, ��������� �������..." << endl;
		case 5:
			return 0;
		}
	}
	delete[] magazine;
}
void main() {
	setlocale(LC_ALL, "Rus");
	i();
	/*cout << "�������� �������: "; cin >> buff;
	mag.MagName = new char[strlen(buff) + 1];
	strcpy(mag.MagName, buff);
	cout << "����� �������:    "; cin >> mag.num;
	cout << "��� �������:      "; cin >> mag.year;
	cout << "������� ������:   "; cin >> buff;
	mag.AuthorSurname = new char[strlen(buff) + 1];
	strcpy(mag.AuthorSurname, buff);
	cout << "��� ������:       "; cin >> buff;
	mag.AuthorName = new char[strlen(buff) + 1];
	strcpy(mag.AuthorName, buff);
	cout << "�������� ������:  "; cin >> buff;
	mag.magName = new char[strlen(buff) + 1];
	strcpy(mag.magName, buff);*/
}