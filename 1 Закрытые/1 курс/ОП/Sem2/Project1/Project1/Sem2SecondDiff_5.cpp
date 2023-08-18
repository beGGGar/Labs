#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <malloc.h>

int main() {
    const int N1 = 5, N2 = 7;
    float M1[N1], M2[N2], car;

    for (int i = 0; i < N1; i++) {
        printf("M1[%d] = ", i);
        scanf("%f", &M1[i]);
    }
    printf("\n");
    for (int i = 0; i < N2; i++) {
        printf("M2[%d] = ", i);
        scanf("%f", &M2[i]);
    }
    
    int j;
    int k = 0;
    for (int i = 0; i < N1; i++) {
        for (j = 0; j < N2; j++) {
            if (M1[i] == M2[j]) {
                k++;
                break;
            }
        }
     }
    printf("\nk = %d   ", k);
    /*float* M3 = new float[k];*/
    float* M3;
    M3 = (float*)malloc(sizeof(float) * k);
    int p = 0;
    for (int i = 0; i < N1; i++) {
        for (j = 0; j < N2; j++) {
            if (M1[i] == M2[j]) {
                M3[p++] = M1[i];
                break;
            }
        }
    }

    for (int j = 0; j < k; j++) {
        for (int z = 0; z < k-1; z++) {
            if (M3[z] > M3[z + 1]) {
                car = M3[z + 1];
                M3[z + 1] = M3[z];
                M3[z] = car;
            }
        }
    }

    int repeat=0; 
    if (k > 1) {
        for (int z = 0; z < k - 1; z++) {
            if (M3[z] == M3[z + 1])repeat++;
        }
    }
    printf("repeat = %d\n", repeat);
    /*float* M4 = new float[k - repeat];*/
    float* M4;
    M4 = (float*)malloc(sizeof(float) * (k-repeat));
    int r = 0;
    if (M3[0] != M3[1]) {
        M4[r++] = M3[0];
        for (int z = 1;z < N2 + N1 - 1;z++) {
            if (M3[z + 1] != M3[z])M4[p++] = M3[z + 1];
        }
    }
    else {
        for (int z = 0;z < N2 + N1 - 1;z++) {
            if (M3[z + 1] != M3[z])M4[p++] = M3[z + 1];
        }
    }
    printf("\n");
    for (int i = 0; i < k; i++) printf("%f ", M3[i]);
    printf("\n");
    for (int i = 0; i < k-repeat; i++) printf("%f ", M4[i]);
    return 0;
}