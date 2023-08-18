#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <iostream>
using namespace std;

int main() {
	const int N = 5;
	double M[N], M1[N + 1], car, temp;

	for (int i = 0; i < N; i++) {
		printf("M[%d]=", i);
		cin >> temp;
		M[i] = (double)temp;
	}
	for (int j = 0; j < N; j++) {
		for (int k = 0; k < N - 1; k++) {
			if (M[k] > M[k + 1]) {
				car = M[k + 1];
				M[k + 1] = M[k];
				M[k] = car;
			}
		}
	}
	for (int i = 0; i < N; i++) {
		cout << M[i] << " ";
	}
	cout << endl << "Num = ";
	cin >> car;

	for (int i = 0; i < N; i++) {
		if (M[i] < car) {
			M1[i] = M[i];

		}
		else {
			M1[i] = (double)car;
			for (i; i < N; i++) {
				M1[i + 1] = M[i];
			}
			break;
		}
		M1[N] = (double)car;
	}

	cout << endl;
	for (int i = 0; i < N + 1; i++) {
		cout << M1[i] << " ";
	}
	
	return 0;
}
