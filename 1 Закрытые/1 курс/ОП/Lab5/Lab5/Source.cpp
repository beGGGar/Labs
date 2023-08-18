#include <ctype.h>
#include <iostream>
#include <locale.h>
#include <stdio.h>
//#include <stdafx.h>
using namespace std;

int* AnText(char *str){
	int S_low = 0, S_hight = 0, num = 0, j=0;

		for (j; iscntrl(str[j])==0; j++) {
			if (isdigit(str[j]) != 0) num++;
			if (isalpha(str[j]) != 0 && islower(str[j]) != 0) S_low++;
			if (isalpha(str[j]) != 0 && islower(str[j]) == 0) S_hight++;
		}

	//printf("\n%d, %d, %d\n", S_low, S_hight, num); //проверка
	int rez[3] = { S_low , S_hight ,num };
	return rez;
}

void FirstLvl_1() {
	int const N = 2; //число строк
	char** text;
	char buff[80] = { 'q' };
	int k;
	text = (char**)malloc(N * sizeof(char*));
	cout << "¬ведите 2 строки на латинице" << endl;
	for (k = 0; k < N; k++) {
		// ввод с клавиатуры в статический буфер
		cin.getline(buff, 80);
		//cout << buff << endl;
		text[k] = (char*)malloc(strlen(buff) + 1); //выделение динамической пам€ти под строку
		for (int j = 0; j < strlen(buff)+1; j++) {
			text[k][j] = buff[j]; // копирование строки в динамическую пам€ть
		}
	}

	int strmax[2] = { AnText(text[0])[0] + AnText(text[0])[1], AnText(text[1])[0] + AnText(text[1])[1] };
	if (strmax[0] > strmax[1])printf("\nв строке 1 букв больче чем во 2");
	if (strmax[0] < strmax[1])printf("\nв строке 2 букв больче чем в 1");
	if (strmax[0] == strmax[1])printf("\nв строках 1 и 2 букв одинаковое количество");
	cout << "\n----------------------------------" << endl;
	//cout << text[0] << endl;
	free(text);

}

void FirstLvl_2() {
	int M, N;
	printf("¬ведите N, M черед пробел: ");
	cin >> N >> M;
	double** A;
	A = (double**)malloc(sizeof(double*) * N);
	for (int i = 0; i < N; i++) {
		A[i] = (double*)malloc(sizeof(double) * M);
		for (int j = 0; j < M; j++) {
			srand((i * 5 + 1) ^ 2 * (j * 8 + 1) ^ (1 / 2) * time(NULL));
			A[i][j] = (double)(rand() % 10000)/10;
			cout << A[i][j] << " ";
		}
		cout << endl;
	}
	int num = 0;
	double sum = 0, rez;
	if (N > M) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < i && A[i][j]; j++) {
				sum = sum + A[i][j];
				num++;
			}
		}
		for (int i = M; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum = sum + A[i][j];
				num++;
			}
		}

	}
	else {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i && A[i][j]; j++) {
				sum = sum + A[i][j];
				num++;
			}
		}
	}
	rez = sum / num;
	cout << endl << "Midle sum = " << rez;
	cout << "-----------------------------------------------" << endl;
}

void SecondLvl_1() {
	const int N = 5; //макс колво строк
	char** A;
	int len = 0;
	A = (char**)malloc(sizeof(char*) * N);
	char buff[80] = { 'q' };
	cout << "¬ведите несколько строк на латинице, окончание ввода - stop" << endl;
	for (int i = 0;; i++) {
		cin.getline(buff, 80);
		if (buff[0] == *"s"&& buff[1] == *"t" && buff[2] == *"o" && buff[3] == *"p")break;
		len++;
		A[i] = (char*)malloc(strlen(buff) + 1);
		for (int j = 0; j < strlen(buff)+1; j++) {
			A[i][j] = buff[j];
		}
	}	
	int n, w_len = 0, w_num = 0;
	cout << endl << "ƒлина искомых слов = ";
	cin >> n;

	for (int i = 0; i < len; i++) {
		for (int j = 0; A[i][j]; j++) {
			if (A[i][j] != ' ' and A[i][j] != '\n')w_len++;
			else {
				if (n == w_len) w_num++;
				//if (w_len != 0)cout << w_len<<' ';
				w_len = 0;
			}
			
		}
		if (n == w_len) w_num++;
		//if (w_len!=0)cout << w_len << ' ';
		w_len = 0;
	}
	cout << endl << "Word num = "  << w_num << endl;
	free(A);
	cout << "-----------------------------------------------" << endl;
}

void MinMaxSec2(double **A, int N, int M) {
	double min = A[0][0], max = A[0][0];
	int i, j;
	//find max
	if (N > M) {
		for (i = 0; i<M; i++) 
			for (j = i; j<M; j++) 
				if (min > A[i][j])min = A[i][j];
	}
	else {
		for (i = 0; i < N; i++) 
			for (j = i; j < M; j++) 
				if (min > A[i][j])min = A[i][j];
	}
	//find min
	if (N < M or N == M) {
		for(i = 0; i<N; i++)
			for(j = 0; j<i; j++)
				if (max < A[i][j])max = A[i][j];
	}
	else {
		for (i = 0; i < N; i++)
			for (j = 0; j < i && j<M; j++)
				if (max < A[i][j])max = A[i][j];
	}
	cout << "min = " << min << ", max= " << max;
}

void SecondLvl_2() {
	int N, M;
	cout << "¬ведите N, M: ";
	cin >> N >> M;
	double** A;
	A = (double**)malloc(sizeof(double*) * N);
	for (int i = 0; i < N; i++) {
		A[i] = (double*)malloc(sizeof(double) * M);
		for (int j = 0; j < M; j++) {
			srand((i*4+10) ^ 2 * (j*2+5) ^ (1 / 2) * time(NULL));
			A[i][j] = (double)(rand() % 10000) / 10;
			cout << A[i][j] << " ";
		}
		cout << endl;
	}
	double min, max;
	MinMaxSec2(A, N, M);

}

int main() {
	setlocale(LC_ALL, "Rus");
	FirstLvl_1();
	FirstLvl_2();
	SecondLvl_1();
	SecondLvl_2();
	return 0;
}