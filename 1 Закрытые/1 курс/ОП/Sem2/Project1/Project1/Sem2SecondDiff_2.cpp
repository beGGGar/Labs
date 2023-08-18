#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
//#include <iostream>
//using namespace std;

int main() {
    const int N1 = 5, N2 = 7, N3 = 2;
    float M1[N1], M2[N2], Mmin[N3], Mmax[N3], temp;

    for (int i = 0; i < N1; i++) {
        printf("M1[%d] = ", i);
        scanf("%f", &M1[i]);
    }
    printf("\n");
    for (int i = 0; i < N2; i++) {
        printf("M2[%d] = ", i);
        scanf("%f", &M2[i]);
    }
    float min1 = M1[0], min2 = M2[0], max1 = M1[0], max2 = M2[0];
    for (int j = 0; j < N1; j++) {
        if (min1 > M1[j])
            min1 = M1[j];
        if (max1 < M1[j])
            max1 = M1[j];
    }
    for (int i = 0; i < N2; i++) {
        if (min2 > M2[i])
            min2 = M2[i];
        if (max2 < M2[i])
            max2 = M2[i];
    }

    Mmin[0] = min1;
    Mmin[1] = min2;
    Mmax[0] = max1;
    Mmax[1] = max2;
    printf("\n min=");
    for (int i = 0; i < N3; i++)
        printf("%f ", Mmin[i]);
    printf("\n max=");
    for (int i = 0; i < N3; i++)
        printf("%f ", Mmax[i]);
	return 0;
}
