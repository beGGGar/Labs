#include <stdio.h>
int main(){
    const int N=7;
    int M[N];
    for(int a=0; a<N; a++){
        printf("\nM[%d] = ", a);
        scanf("%d", &M[N]);
    }

    for(int i=1; i<N; i++){
        if(M[i]>M[i-1])printf("%d ", i);
    }
    printf("\n");
    for(int a=0; a<N-1; a++){
        if(M[a]<M[a+1])printf("%d ", a);
    }
    return 0;
}
