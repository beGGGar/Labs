#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main() {
    const int N = 7;
    int M[N], car;
    for (int a = 0; a < N; a++) {
        printf("M[%d] = ", a);
        scanf("%d", &M[N]);
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
    printf("\n");
    
    int sum = 0, num = 0;
    if (M[0] == M[1]) {
        printf("0 ");
        sum = sum + M[0];
        num++;
    }
    for (int i = 0; i < N - 1; i++) {
        if (M[i + 1] == M[i]) { 
            sum = sum+ M[i + 1];
            num++;
            printf("%d ", i + 1);
        }
    }
    printf("\nsum = %d, count = %d", sum, num);
    return 0;
}