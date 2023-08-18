#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <ctime>
#include <malloc.h>

int* SortM(int A[], int N) {
	int temp; 
	for (int i = 0; i < N-1; i++) {
		for (int j = 0; j < N-1; j++) {
			if (A[j] > A[j + 1]) {
				temp = A[j];
				A[j] = A[j + 1];
				A[j + 1] = temp;
			}
		}
	}
	for (int i = 0; i < N; i++)printf("%d ", A[i]);
	printf("\n");
	return(A);
}

int FirstLvl_1() {
	const int N1 = 15, N2 = 17;
	int A[N1], B[N2], r = 0;

	for (int i = 0; i < N1; i++) {
		srand((i + 1) ^ 2 * time(NULL));
		if (rand() % 2 == 0)r = 1;
		else r = -1;
		A[i] = r * rand() % 100 + 1;
	}

	for (int i = 0; i < N2; i++) {
		srand((i * 3) ^ 2 * time(NULL));
		if (rand() % 2 == 0)r = 1;
		else r = -1;
		B[i] = r * rand() % 100 + 1;

	}

	int* A1 = SortM(A, N1);
	int* B1 = SortM(B, N2);
	int idA1 = 0, idB1 = 0;
	for (int i = 0; i < N1; i++) {
		if (A1[i] > 0) {
			idA1 = i;
			break;
		}
	}
	for (int i = 0; i < N2; i++) {
		if (B1[i] > 0) {
			idB1 = i;
			break;
		}
	}
	printf("\n%d, %d ", idA1, N1 - idA1);
	printf("\n%d, %d ", idB1, N2 - idB1);
	printf("\n---------------------------------------------\n\n");
	return 0;
}

int FirstLvl_2() {
	const int N = 8, M = 12;
	int A[N][M];
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			srand((i * 3 + 1) ^ 2 * (j + 1) ^ (1 / 2) * time(NULL));
			A[i][j] = rand() % 99;
			printf("%d ", A[i][j]);
		}
		printf("\n");
	}
	int max = A[0][4];
	for (int i = 0; i < N / 2; i++) {
		for (int j = M / 2; j < M; j++) {
			if (max < A[i][j])max = A[i][j];
		}
	}
	
	for (int i = N / 2; i < N; i++) {
		for (int j = 0; j < M / 2; j++) {
			if (max < A[i][j])max = A[i][j];
		}
	}
	printf("max=%d ", max);
	printf("\n---------------------------------------------\n\n");
	return 0;
}

int sum_str(int N, int M, int **A) {
	int sum, a = 0;
	int* SumM;
	SumM = (int*)malloc(sizeof(int) * N / 2);
	
	for (int i = 1; i < N; i = i + 2) {
		sum = 0;
		for (int j = 0; j < M; j++) {
			sum += A[i][j];
		}
		SumM[a] = sum;
		a++;
	}
	printf("\n");
	for (int i = 0; i < N / 2; i++) printf("%d ", SumM[i]);
	return 0;
}

int* max_min(int N, int M, int** A) {
	int max = A[0][M / 2+1], min = A[0][M / 2+1];
	for (int i = 0; i < N / 2; i++) {
		for (int j = M / 2; j < M; j++) {
			if (max < A[i][j])max = A[i][j];
		}
	}
	
	for (int i = N / 2; i < N; i++) {
		for (int j = 0; j < M / 2; j++) {
			if (min > A[i][j])min = A[i][j];
		}
	}
	int res[2] = { max, min };
	return res;
}

int SecondLvl() {
	int N = 16, M = 18;
	int **A;

	A = (int**)malloc(sizeof(int*) * N);
	for (int i = 0; i < N; i++) {
		A[i] = (int*)malloc(sizeof(int) * M);
		for (int j = 0; j < M; j++) {
			srand((i*5 + 1) ^ 2 * (j*8 + 1) ^ (1 / 2) * time(NULL));
			A[i][j] = rand() % 99 + 1;
			printf("%d ", A[i][j]);
		}
		printf("\n");
	}
	
	//sum_str(N, M, A);
	int *MaxMin;
	//MaxMin = (int*)malloc(sizeof(int) * 2);
	MaxMin = max_min(N, M, A);
	printf("\nmax=%d, min=%d", MaxMin[0], MaxMin[1]);
	return 0;
}
int main() {
	FirstLvl_1();
	FirstLvl_2();
	SecondLvl();

	return 0;
}