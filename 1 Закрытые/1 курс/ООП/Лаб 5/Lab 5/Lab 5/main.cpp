//#include"stdafx.h"
#include <iostream>
#include <stdlib.h>
using namespace std;

template<class X>
void print(X* R, int num) {
	for (int i = 0; i < num; i++) {
		cout << R[i] << " ";
	}
	cout << endl;
}

template<class X>
void random(X *R, int n) {
	X buff = rand();
	for (int i = 0; i < n; i++)
	{
		buff = rand()/10;
		R[i] = buff / 10;
	}
}

template<class X>
void sortDec(X *R, int num) {
	X buff;
	for (int i = 0; i < num; i++) {
		for (int j = 0; j < num; j++) {
			if (R[j] < R[j + 1]) {
				buff = R[j];
				R[j] = R[j + 1];
				R[j + 1] = buff;
			}
		}
	}
}

void sortDec(char* R, int num) {cout << "sort is not need";}

template<class X>
void rowPrint(X *R, int num, int quant) {
	cout << endl;
	for (int i = 0; i < num;) {
		for (int j = 0; j < quant && i < num; j++) {
			cout << R[i++] << " ";
		}
		cout << endl;
	}
}


int main() {
	int i = 9, d = 10;
	int* I = new int[i];
	double* D = new double[d];
	char C[] = "Dfdghs";
	int c = strlen(C);
	random(I, i);
	random(D, d);
	cout << "before sort" << endl;
	print(I, i);
	print(D, d);
	print(C, c);

	cout << endl <<  "after sort" << endl;
	sortDec(I, i);
	print(I, i);
	sortDec(D, d);
	print(D, d);
	sortDec(C, c);
	cout << endl;
	rowPrint(I, i, 3);
	rowPrint(D, d, 4);
	rowPrint(C, c, 2);
	return 0;
}
