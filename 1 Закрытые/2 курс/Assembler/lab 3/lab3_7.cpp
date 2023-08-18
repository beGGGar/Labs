#include <iostream>
#include <iomanip>
#include <bitset>

using namespace std;

void print32(void* p) {
    unsigned int* p1 = reinterpret_cast<unsigned int*>(p);
    int* p2 = reinterpret_cast<int*>(p);
    float* p3 = reinterpret_cast<float*>(p);

    cout << " " << setw(8) << hex << setfill('0')  << *p1
            << " " << setw(32) << bitset<32>(*p1)
            << " " << setw(20) << dec << setfill(' ')  << *p1
            //<< " " << setw(8) << hex << setfill('0')  << *p2
            //<< " " << setw(32) << bitset<32>(*p2)
            << " " << setw(20) << dec << setfill(' ')  << *p2
            << " " << setw(15) << fixed << setw(15) << *p3
            << " " << setw(15) << scientific << setw(15) << *p3 << endl;
}


void increment(void *p){
   int i = -~(*(reinterpret_cast<int *>(p)));
   //p = (reinterpret_cast<int *>(p));
   *(int*)p = i;
}

void decrement(void *p){
   int i = ~-(*(reinterpret_cast<int *>(p)));
   //p = (reinterpret_cast<int *>(p));
   *(int*)p = i;
}

void tilda_func(void *p){
   int i = ~(*(reinterpret_cast<int *>(p)));
   //p = (reinterpret_cast<int *>(p));
   *(int*)p = i;
}

void minus_func(void *p){
   int i = -(*(reinterpret_cast<int *>(p)));
   //p = (reinterpret_cast<int *>(p));
   *(int*)p = i;
}

void modul(void *p){
    int i = *(reinterpret_cast<int *>(p))&0x7fffffff;
    *(int*)p = i;
}
int main() {
   float d = -8.1233;
   cout << "d = -8.1233"<< endl;
   print32(&d);
   cout << "MODULE d = -8.1233"<< endl;
   modul(&d);
   print32(&d);
   return 0;
}
