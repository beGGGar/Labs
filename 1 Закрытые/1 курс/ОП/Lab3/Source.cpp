#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
#include <ctime>

int max_mass(int* A, int i) {
	//функция поиска максимума
	int max = A[0];
	int I;
	for (int a = 0; a < i; a++) {
		if (max < A[a]) {
			max = A[a];
			I = a;
		}
	}
	return(I);
}

int Func() {
	//ЧАСТЬ 1
	int N2, N1, * A, * B;

	printf("N1 = ");
	scanf("%d", &N1);
	A = (int*)malloc(N1 * sizeof(int));
	for (int i = 0; i < N1; i++) {
		printf("A[%d] = ", i);
		scanf("%d", &A[i]);
	}

	printf("N2 = ");
	scanf("%d", &N2);
	B = (int*)malloc(N2 * sizeof(int));
	for (int j = 0; j < N2; j++) {
		printf("B[%d] = ", j);
		scanf("%d", &B[j]);
	}


	int m, n;
	printf("max_i_in_a=%d\n", m = max_mass(A, N1));
	printf("max_i_in_b=%d", n = max_mass(B, N2));
	if (m < n)printf("\nmax_in_a_nearly");
	if (m > n)printf("\nmax_in_b_nearly");
	if (m == n)printf("\nmaxa_and_maxb_in_the_same_distance");
	free(A); free(B);
	return 0;
}

int creatMus() {
	int** A;
	int N, M, r, col, sid=0, i, j, sum=0;
	printf("\n\nN = ");
	scanf("%d", &N);
	printf("M = ");
	scanf("%d", &M);

	A = (int**)malloc(sizeof(int*) * N);
	for (i = 0; i < N; i++) {
		A[i] = (int*)malloc(sizeof(int) * M);
		for (j = 0; j < M; j++) {
			if ((i + j) % 2 == 0)r = 1;
			else r = -1;
			srand((i+1)^2*(j+1)^(1/2)* time(NULL));
			A[i][j] = r*rand() % 100 + 1;
			printf("%d ", A[i][j]);
		}
		printf("\n");
	}

	printf("Column = ");
	scanf("%d", &col);
	if (N % 2 != 0) N = N / 2 + 1;
	else N = N / 2; 
	for (j = col-1, i = 0; i < N; i++) {
		if (A[i][j] < 0) {
			//printf("%d ", A[i][j]);
			sum = sum + A[i][j];
			//printf("%d ", sum);
			sid++;
			//printf("%d ", sid);
		}
	}
	printf("%d ", sum);
	printf("%d ", sid);
	double sum1;
	sum1= (double)sum / sid; //проблемка
	printf("\n%f", sum1);
	free(A);
	return 0;
}

int main() {
	
	//Func();
	creatMus();
	return 0;
}