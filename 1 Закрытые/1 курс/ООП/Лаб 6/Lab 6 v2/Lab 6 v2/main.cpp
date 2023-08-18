#define _CRT_SECURE_NO_WARNINGS
//#include "StdAfx.h"
#include "iostream"
#include <Windows.h>
#include "locale.h"
#include "storage.h"
#include "storage1.h"
#define max_bread 100
using namespace std;


//void define(storage* R, storage1* R1, int &max, int &max1, int sw);
template<class X>
void define(X* R, int& max) {
	try
	{
		if (max >= max_bread) throw 1;
		cin >> R[max];
		max++;
		cout << "������" << endl;
	}
	catch (int n)
	{
		if (n == 1) { cout << "����� ���������!" << endl; }
	}
}

int main(int argc, char* argv[]) {
	try
	{
		setlocale(LC_ALL, "Rus");
		SetConsoleCP(1251); // ���� � ������� � ���������
		SetConsoleOutputCP(1251); // ����� �� ������� � ���������

		storage* St = new storage[max_bread];
		//storage1* St1 = new storage1[max_bread];

		char path[] = "data.txt";
		char path1[] = "data1.txt";
		int max = St[0].loadList(path);
		//int max1 = St1[0].loadList(path1);
		int c, sw, quant, found;

		DialogInterface();
		sw = intRangeCheck(1, 2);
		while (true) {
			cout << "������� ����� �������: ";
			c = intCheck();
			switch (c) {

			case 1: // ���������� ������
				if (sw == 1) { define(St, max); }
				//if (sw == 2) { define(St1, max1); }
				break;

			case 2: //����� ��
				if (sw == 1) { St[0].printList(max); }
				//if (sw == 2) { St1[0].printList(max1); }
				break;

			case 3: //����� �� ��������
				if (sw == 1) { St[0].findBread(max); }
				//if (sw == 2) { St1[0].findBread(max1); }
				break;

			case 4: //������ �� ������ ������ ��� 1 ��
				if (sw == 1) { max = St[0].filterNum(max); }
				if (sw == 2) { cout << "��� �� �� ������������ ��� �������!" << endl; }
				break;

			case 5: //���������� �� ����������
				if (sw == 1) { St[0].sortBread(max); }
				//if (sw == 2) { St1[0].sortBread(max1); }
				break;

			case 6: //�������� ������ ��������
				if (sw == 1) { max = St[0].findFresh(max); }
				//if (sw == 2) { max1 = St1[0].findFresh(max1); }
				break;

			case 7:
				//������ ������ �� �����
				if (sw == 1) {
					found = St[0].findBread(max);
					if (found == -1) {
						define(St, max);
					}
					else {
						cout << "����������: ";
						cin >> quant;
						St[found].setQuant(St[found].getQuant() + quant);
					}
				}
				if (sw == 2) {
					//found = St1[0].findBread(max1);
					if (found == -1) {

						//define(St1, max1);
					}
					else {
						cout << "����������: ";
						cin >> quant;
						//St1[found].setQuant(St1[found].getQuant() + quant);
					}
				}
				break;
			case 8:
				try
				{
					if (sw == 1) {
						found = St[0].findBread(max);
						if (found != -1) {
							cout << "���������� ����������� ������: ";
							cin >> quant;
							if (St[found].getQuant() - quant < 0)throw 1;
							St[found].setQuant(St[found].getQuant() - quant);
						}
					}
					if (sw == 2) {
						//found = St1[0].findBread(max1);
						if (found != -1) {
							cout << "���������� ����������� ������: ";
							cin >> quant;
							//if (St1[found].getQuant() - quant < 0)throw 1;
							//St1[found].setQuant(St1[found].getQuant() - quant);
						}
					}
				}
				catch (int n)
				{
					if (n == 1)cout << "������� ������ ��� �� ������" << endl;
				}

				break;
			case 9: //����������
				St[0].saveList(max, path);
				//St1[0].saveList(max1, path1);
				delete[] St;
				//delete[] St1;
				return 0;
			case 10: //����� �������� ���� ������
				sw = intRangeCheck(1, 2);
				break;
			default:
				cout << "�������� ������, ��������� �������..." << endl;

			}
			system("pause");
			system("cls");
			DialogInterface();
		}
	}
	catch (...)
	{
		cout << "���������� ��������... ���������� ����� ���� ������." << endl;
		return 0;
	}


}

//void define(storage* St, storage1* St1, int& max, int& max1, int sw) {
//	try
//	{
//		if (sw == 1) {
//			if (max >= max_bread) throw 1;
//			// St[max].define(max, max_bread);
//			cin >> St[max];
//			max++;
//		}
//		if (sw == 2) {
//			if (max1 >= max_bread) throw 1;
//			cin >> St1[max1];
//			max1++;
//		}
//	}
//	catch (int n)
//	{
//		if (n == 1) { cout << "����� ���������!" << endl; }
//	}
//}


