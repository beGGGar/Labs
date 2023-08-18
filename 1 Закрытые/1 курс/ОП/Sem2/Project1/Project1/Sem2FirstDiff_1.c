#include <stdio.h>
int main(){
    const int N = 7;
    int k;
    float M[N];
    for(int a=0; a<N; a++)
        scanf("%f", &M[N]);
    float min = M[0];
    for(int j=0; j<N; j++){
        if(min>M[j]){
            min=M[j];
            k=j;
        }
    }
    M[k]=k;
    for(int i=0; i<N; i++)
        printf("%f ", M[i]);
    return 0;
}