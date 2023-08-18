#define _CRT_SECURE_NO_WARNINGS
//#include "StdAfx.h"
#include "iostream"
#include <Windows.h>
#include "locale.h"
#include "common.h"
#include "storage.h"
#include "storage1.h"
#define max_bread 100

using namespace std;

int main() {
	setlocale(LC_ALL, "Rus");
	SetConsoleCP(1251); // ���� � ������� � ���������
	SetConsoleOutputCP(1251); // ����� �� ������� � ���������

	storage* St = new storage[max_bread];
	storage1* St1 = new storage1[max_bread];
	
	char path[] = "data.txt";
	char path1[] = "data1.txt";
	int max = St[0].loadList(path);
	int max1 = St1[0].loadList(path1);
	int c, sw;

	DialogInterface();
	sw = switchCheck();
	while (true) {
		cout << "������� ����� �������: ";
		c = intCheck();
		switch (c) {
		case 1: // ���������� ������
			if (sw == 1) {
				if (max >= max_bread) {
					cout << "����� ���������!" << endl;
					break;
				}
				St[max].define(max, max_bread);
				max++;
			}
			if (sw == 2) {
				if (max1 >= max_bread) {
					cout << "����� ���������!" << endl;
					break;
				}
				St1[max1].define(max1, max_bread);
				max1++;
			}
			
			break;
		case 2: //����� ��
			if (sw == 1) {St[0].printList(max);}
			if (sw == 2) { St1[0].printList(max1); }
			break;
		case 3: //����� �� ��������
			if (sw == 1) { St[0].findBread(max); }
			if (sw == 2) { St1[0].findBread(max1); }
			break;
		case 4: //������ �� ������ ������ ��� 1 ��
			if (sw == 1) { max = St[0].filterNum(max); }
			if (sw == 2) { cout << "��� �� �� ������������ ��� �������!" << endl; }
			break;
		case 5: //���������� �� ����������
			if (sw == 1) { St[0].sortBread(max); }
			if (sw == 2) { St1[0].sortBread(max1); }
			break;
		case 6: //�������� ������ ��������
			if (sw == 1) { max = St[0].findFresh(max); }
			if (sw == 2) { max1 = St1[0].findFresh(max1); }
			break;
		case 7: //����������
			St[0].saveList(max, path);
			St1[0].saveList(max1, path1);
			delete[] St;
			delete[] St1;
			return 0;
		case 8: //����� �������� ���� ������
			sw = switchCheck();
			break;
		default:
			cout << "�������� ������, ��������� �������...";
			c = intCheck();
		}
	}
	cout << "���������� ��������... ���������� ����� ���� ������." << endl;
	return 0;
}
