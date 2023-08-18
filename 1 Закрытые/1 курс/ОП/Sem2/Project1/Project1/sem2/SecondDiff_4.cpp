#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
    const int N1 = 7, N2 = 9, N3 = 5;
    float M1[N1], M2[N2], M3[N3], M4[N2 + N3];
   
    //инициализация и заполнение массивов
    for (int i = 0; i < N1; i++) {
        printf("M1[%d] = ", i);
        scanf("%f", &M1[i]);
    }
    for (int a = 0; a < N2; a++) {
        printf("M2[%d] = ", a);
        scanf("%f", &M2[a]);
    }    
    for (int a = 0; a < N3; a++) {
        printf("M3[%d] = ", a);
        scanf("%f", &M3[a]);
    }
    int k = 0;
    for (int j = 0;j < N2;j++)
        M4[k++] = M2[j];
    for (int z = 0;z < N3;z++)
        M4[k++] = M3[z];

    int j;
    for (int i = 0; i < N1; i++) {
        for (j = 0; j < N2; j++) {
            if (M1[i] == M2[j])
                break;
        }
        if (M1[i] == M2[j])
            continue;
        printf("%f ", M1[i]);
    }
    for (int i = 0; i < N1; i++) {
        for (j = 0; j < N3; j++) {
            if (M1[i] == M3[j])
                break;
        }
        if (M1[i] == M3[j])
            continue;
        printf("%f ", M1[i]);
    }
    return 0;
}