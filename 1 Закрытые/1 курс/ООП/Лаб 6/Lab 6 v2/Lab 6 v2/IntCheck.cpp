#include "IntCheck.h"
using namespace std;

int intCheck() {
	string buff;
	int rez;
	while (true) {
		try {
			cin >> rez;
			break;
		}
		catch (istream::failure e) {
			cerr << "������� ������������ ��������!" << endl;
		}
	}
	return rez;
}

double doubleCheck() {
	string buff;
	double rez;
	while (true) {
		try {
			cin >> rez;
			break;
		}
		catch (istream::failure e) {
			cerr << "������� �������� ��������!" << endl;
		}
	}
	return rez;
}

//dateCheck

double valuecheck(int min, int max) {
	double rez;
	while (true) {
		rez = intCheck();
		if (rez > max)throw 2;
		if (rez < min)throw 3;
		return rez;
	}
}

double valueCheck(int min, int max) {
	try
	{
		return valuecheck(min, max);
	}
	catch (int n)
	{
		if (n == 2)cout << "�������� ������� ������. ��������� �������..." << endl;
		if (n == 3)cout << "�������� ������� ����. ��������� �������..." << endl;
	}
	return 0;
}

int intRangeCheck(int min, int max) {
	int rez;
	while (true) {
		try {
			rez = intCheck();
			if (rez > max)throw "�������� ������� ������!";
			if (rez < min)throw "�������� ������� ����!";
			break;
		}
		catch (const char* n)
		{
			cout << n << endl;
		}			
	}
	return rez;
}

double doubleRangeCheck(double min, double max) {
	double rez;
	while (true) {
		try {
			rez = doubleCheck();
			if (rez > max)throw "�������� ������� ������!";
			if (rez < min)throw "�������� ������� ����!";
			break;
		}
		catch (const char* n)
		{
			cout << n << endl;
		}
	}
	return rez;
}

	

int switchcheck() {
	double sw;
	cout << "����� ��: ";
	while (true) {
		sw = intCheck();
		if (sw != (int)sw)throw 4;
		if (sw != 1.0 && sw != 2.0)throw 5;
		return sw;
	}
	return 0;
}




