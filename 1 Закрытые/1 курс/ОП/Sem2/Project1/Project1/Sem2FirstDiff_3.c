#include <stdio.h>
int main(){
    int M[3]={346, 526, 723, 355, 111}, min;
    printf("min = ");
    scanf("%d", min);
    printf("\n");
    for(int i=0; i<3; i++){
        if(M[i]>min)printf("%d ", i);
    }
    return 0;
}