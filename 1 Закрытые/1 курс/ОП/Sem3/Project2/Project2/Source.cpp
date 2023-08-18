#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <iostream>

using namespace std;
	
void copy(char *t, char *s) {
	//1 функция
	while (*s++ = *t++);
		
}

void strcat(char *s, char *t){
	//2 функция
	while (*s != '\0')s++;
	while (*s++ = *t++);
}

int t_in_fin_of_s(char* s, char* t) {
	//3 функция
	int i = 0, j = 0, rez = 5;
	while (s[i++] != '\0');
	while (t[j++] != '\0');
	while (j >= 0) {
		if (s[i--] != t[j--]) {
			rez = 0;
			break;
		}
	}
	if (rez != 0)rez = 1;
	return rez;
}

double f(double x) {
	double y = 3 * x *x - 20 * x + 5;
	return y;
}

double Num4(double (*f)(double x), double a, double b) {
	//4 функция
	double min=f(a);
	for (a; a < b; a = a + 0.0001) {
		if (min > f(a))min = f(a);
	}
	return min;
}

double Num5(double (*f)(double x), double a, double b, double n) {
	//5 функция
	if (n > b - a)return 0;
	int i = 0;
	double sum = 0;
	for (a; a < b; a = a + n) {
		sum = sum + f(a);
		i++;
	}
	//printf("i = %d", i);
	double rez = sum / i;
	return rez;
}

double Num6(double (*f)(double x), double a, double b) {
	//6 функция
	double min = f(a), max = f(a);
	for (a; a < b; a = a + 0.0001) {
		if (min > f(a))min = f(a);
		if (max < f(a))max = f(a);
	}
	return abs(max-min);
}

double& midle(int x1, int x2, int x3) {
	//7 функция
	double rez;
	if (x1 > x2 && x1 > x3)rez = (double)x1;
	if (x2 > x1 && x2 > x3)rez = (double)x2;
	if (x3 > x1 && x3 > x2)rez = (double)x3;
	return rez;
}

int main() {
	//номер 1
	char t[15] = "hello ";
	char s[15];
	copy(t, s);
	cout << "N 1: " << s;

	//номер 2
	printf("\n");
	char s1[15] = "hello ";
	char t1[15] = "world";
	strcat(s1, t1);
	cout << "N 2: " << s1;

	//номер 3
	printf("\n");
	char s2[15] = "hello world";
	char t2[15] = "world";
	cout << "N 3: "<<t_in_fin_of_s(s2, t2);

	//номер 4
	printf("\n");
	double a = -1, b = 5;
	cout << "N 4: " <<  Num4(f, a, b);

	//номер 5
	printf("\n");
	double a1 = -2, b1 = 7, n = 0.1;
	cout << "N 5: " << Num5(f, a1, b1, n);

	//номер 6
	printf("\n");
	double a2 = 3, b2 = 9;
	cout << "N 6: " << Num6(f, a2, b2);

	//номер 7
	printf("\n");
	int x1 = 6, x2 = 17, x3 = 7;
	double &rez = midle(x1, x2, x3);
	rez = (double)(x1 + x2 + x3) / 3;
	cout << "N 7: " << rez;
	return 0;
}