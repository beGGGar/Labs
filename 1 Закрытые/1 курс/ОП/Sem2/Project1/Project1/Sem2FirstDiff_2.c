#include <stdio.h>
int main(){
    const int N=7; 
    int K, sum=0, M[N];
    for(int a=0; a<N; a++)
        scanf("%d", &M[N]);
    printf("K = ");
    scanf("%d", &K);
    for(int a=0; a<N; a++){
        if(M[a]%K==0){
            sum+=M[a];
        }
        
    }
    printf("\n%d", sum);
    return 0;
}