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


int main() {
   int m = 223,
       n = -455,
       zero = 0,
       max32 = 2147483647,
       min32 = -2147483648;
      
   unsigned  int u_max32 = 4294967295;

   float a = 0, 
         b = 1, 
         c = 12345678, 
         d = 123456789;
   //a
   cout << "a = "<< endl;
   print32(&a);
   cout << endl;
   increment(&a);
   cout << "(a+1) = " << endl;
   print32(&a);
   cout << endl;
   decrement(&a);
   decrement(&a);
   cout << "(a-1) = "<< endl;
   print32(&a);
   cout << endl << endl;

   //b
   cout << "b = "<< endl;
   print32(&b);
   cout << endl;
   increment(&b);
   cout << "(b+1) = " << endl;
   print32(&b);
   cout << endl;
   decrement(&b);
   decrement(&b);
   cout << "(b-1) = "<< endl;
   print32(&b);
   cout << endl << endl;

   //c
   cout << "c = "<< endl;
   print32(&c);
   cout << endl;
   increment(&c);
   cout << "(c+1) = " << endl;
   print32(&c);
   cout << endl;
   decrement(&c);
   decrement(&c);
   cout << "(c-1) = "<< endl;
   print32(&c);
   cout << endl << endl;

   //d
   cout << "d = "<< endl;
   print32(&d);
   cout << endl;
   increment(&d);
   cout << "(d+1) = " << endl;
   print32(&d);
   cout << endl;
   decrement(&d);
   decrement(&d);
   cout << "(d-1) = "<< endl;
   print32(&d);
   cout << endl << endl;
   
   //m
   cout << "m = "<< endl;
   print32(&m);
   cout << endl;
   increment(&m);
   cout << "(m+1) = " << endl;
   print32(&m);
   cout << endl;
   decrement(&m);
   decrement(&m);
   cout << "(m-1) = "<< endl;
   print32(&m);
   cout << endl << endl;

   //n
   cout << "n = "<< endl;
   print32(&n);
   cout << endl;
   increment(&n);
   cout << "(n+1) = " << endl;
   print32(&n);
   cout << endl;
   decrement(&n);
   decrement(&n);
   cout << "(n-1) = "<< endl;
   print32(&n);
   cout << endl << endl;

   //zero
   cout << "zero = "<< endl;
   print32(&zero);
   cout << endl;
   increment(&zero);
   cout << "(zero+1) = " << endl;
   print32(&zero);
   cout << endl;
   decrement(&zero);
   decrement(&zero);
   cout << "(zero-1) = "<< endl;
   print32(&zero);
   cout << endl << endl;

   //u_max32
   cout << "u_max32 = "<< endl;
   print32(&u_max32);
   cout << endl;
   increment(&u_max32);
   cout << "(u_max32+1) = " << endl;
   print32(&u_max32);
   cout << endl;
   decrement(&u_max32);
   decrement(&u_max32);
   cout << "(u_max32-1) = "<< endl;
   print32(&u_max32);
   cout << endl << endl;

   //min32
   cout << "min32 = "<< endl;
   print32(&min32);
   cout << endl;
   increment(&min32);
   cout << "(min32+1) = " << endl;
   print32(&min32);
   cout << endl;
   decrement(&min32);
   decrement(&min32);
   cout << "(min32-1) = "<< endl;
   print32(&min32);
   cout << endl << endl;

   //max32
   cout << "max32 = "<< endl;
   print32(&max32);
   cout << endl;
   increment(&max32);
   cout << "(max32+1) = " << endl;
   print32(&max32);
   cout << endl;
   decrement(&max32);
   decrement(&max32);
   cout << "(max32-1) = "<< endl;
   print32(&max32);
   cout << endl << endl;
   return 0;
}
