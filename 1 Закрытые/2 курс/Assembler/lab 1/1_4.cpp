#include <stdio.h>
#include <iostream>
using namespace std;
int main() {
	cout << "Task 4" << endl;

	const int N = 5;
	short Ms[N];
	long Ml[N];
	long long Mq[N];
	float Mfs[N];
	double Mfl[N];
	for (int i = 0; i < N; i++) {
		Ms[i] = 0xDEAD;
		Ml[i] = 0xC0CAC01A;
		Mq[i] = 0xC0FFEE11BEA7;
		Mfs[i] = 7 / 5;
		Mfl[i] = 7 / 5;
	}

	cout << "10x output " << endl;
	for (short i : Ms) { printf("%hd\n", i); }
	cout << endl;
	for (long i : Ml) { printf("%ld\n", i); }
	cout << endl;
	for (long long i : Ms) { printf("%lld\n", i); }	
	cout << endl;
	for (float i : Ms) { printf("%.2f\n", i); }
	cout << endl;
	for (double i : Ms) { printf("%.2f\n", i); }

	cout << endl << "16x output" << endl;
	for (short i : Ms) { printf("%hx\n", i); }
	cout << endl;
	for (long i : Ml) { printf("%lx\n", i); }
	cout << endl;
	for (long long i : Ms) { printf("%llx\n", i); }
	cout << endl;
	for (float i : Ms) { printf("%e\n", i); }
	cout << endl;
	for (double i : Ms) { printf("%e\n", i); }


	system("pause");
	return 0;
}