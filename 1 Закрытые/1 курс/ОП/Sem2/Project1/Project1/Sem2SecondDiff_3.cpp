#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
//#include <iostream>
//using namespace std;

int main() {
    const int N1 = 5, N2 = 7;
    float M1[N1], M2[N2], car;

    //инициализация и сортировка массивов
    for (int i = 0; i < N1; i++) {
        printf("M1[%d] = ", i);
        scanf("%f", &M1[i]);
    }
    printf("\n");
    for (int i = 0; i < N2; i++) {
        printf("M2[%d] = ", i);
        scanf("%f", &M2[i]);
    }
    for (int j = 0; j < N1; j++) {
       for (int k = 0; k < N1 - 1; k++) {
           if (M1[k] > M1[k + 1]) {
               car = M1[k + 1];
               M1[k + 1] = M1[k];
               M1[k] = car;
           }
       }
   }
   for (int j = 0; j < N2; j++) {
       for (int k = 0; k < N2 - 1; k++) {
           if (M2[k] > M2[k + 1]) {
               car = M2[k + 1];
               M2[k + 1] = M2[k];
               M2[k] = car;
           }
       }
   }

   printf("\n");
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
   for (int i = 0; i < N2; i++) {
       for (j = 0; j < N1; j++) {
           if (M2[i] == M1[j])
               break;
       }
       if (M2[i] == M1[j])
           continue;
       printf("%f ", M2[i]);
   }
    
   /*float*M3 = new float[k];
   int p = 0;
   for (int i = 0; i < N1; i++) {
       for (j = 0; j < N2; j++) {
           if (M1[i] == M2[j])
               break;
       }
       if (M1[i] == M2[j])
           continue;
       M3[p++]=M1[i];
   }
   for (int i = 0; i < N2; i++) {
       for (j = 0; j < N1; j++) {
           if (M2[i] == M1[j])
               break;
       }
       if (M2[i] == M1[j])
           continue;
       M3[p++] = M2[i];
   }*/

    //int k = 0;
    //for (int z = 0; z < N1;z++)M3[k++] = M1[z];
    //for (int z = 0;z < N2;z++)M3[k++] = M2[z];
    ////for (int z = 0;z < N2 + N1;z++)printf("%f ", M3[z]);
    //for (int j = 0; j < N1; j++) {
    //    for (int k = 0; k < N1 - 1; k++) {
    //        if (M1[k] > M1[k + 1]) {
    //            car = M1[k + 1];
    //            M1[k + 1] = M1[k];
    //            M1[k] = car;
    //        }
    //    }
    //}
    //for (int j = 0; j < N2; j++) {
    //    for (int k = 0; k < N2 - 1; k++) {
    //        if (M2[k] > M2[k + 1]) {
    //            car = M2[k + 1];
    //            M2[k + 1] = M2[k];
    //            M2[k] = car;
    //        }
    //    }
    //}
    //for (int j = 0; j < N1+N2; j++) {
    //    for (int k = 0; k < N1+N2 - 1; k++) {
    //        if (M3[k] > M3[k + 1]) {
    //            car = M3[k + 1];
    //            M3[k + 1] = M3[k];
    //            M3[k] = car;
    //        }
    //    }
    //}
    //
    //int repeat=0; // кол-во повторяющихся членов
    //for (int z = 0;z < N2 + N1-1;z++) {
    //    if (M3[z] == M3[z + 1])repeat++;
    //}
    ////неповторяющийся массив членов М1 и М2
    //float* M4 = new float[N1 + N2 - repeat];
    //int i = 0;
    //if (M3[0] != M3[1])M4[i++] = M3[0];
    //for (int z = 0;z < N2 + N1-1;z++) {
    //    if (M3[z+1] != M3[z])M4[i++] = M3[z+1];
    //}
    //for (int z = 0;z < N2 + N1-repeat;z++)printf("%f ", M4[z]);
    ////кол-во чисел не входищие в один из массивов
    //int fin = 0;
    //for (int i = 0; i < N1 + N2 - repeat; i++) {
    //    for (int j = 0; j < N1; j++) {
    //        if (M4[i] == M1[j]) {               
    //            continue;
    //        }
    //    }
    //    fin++;
    //}
    //for (int i = 0; i < N1 + N2 - repeat; i++) {
    //    for (int k = 0; k < N1; k++) {
    //        if (M4[i] == M2[k]) {               
    //            continue;
    //        }
    //    }
    //    fin++;
    //}
    //printf("\n%dfin=", fin);

	return 0;
}