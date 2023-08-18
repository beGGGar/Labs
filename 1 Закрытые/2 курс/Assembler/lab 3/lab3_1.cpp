#define print(n)(sizeof(n)==2 ? print16(&n) : print32(&n)) //требовать балл за макросы хе-хе-хе
#include <iostream>
#include <bitset>
#include <iomanip>
using namespace std;

// int main(){
//     int n = 5;
//     print16(&n);
//     print32(&n);
//     cin >> n;
//     return 0;
// }

void print32(void* p) {
    unsigned int* p1 = reinterpret_cast<unsigned int*>(p);
    int* p2 = reinterpret_cast<int*>(p);
    float* p3 = reinterpret_cast<float*>(p);

    cout << "32x"
        << " " << setw(8) << hex << setfill('0')  << *p1
        << " " << setw(32) << bitset<32>(*p1)
        << " " << setw(20) << dec << setfill(' ')  << *p1
        //<< " " << setw(8) << hex << setfill('0')  << *p2
        //<< " " << setw(32) << bitset<32>(*p2)
        << " " << setw(20) << dec << setfill(' ')  << *p2
        << " " << setw(15) << fixed << setw(15) << *p3
        << " " << setw(15) << scientific << setw(15) << *p3 << endl;
}

void print16(void* p) {
    unsigned short* p1 = reinterpret_cast<unsigned short*>(p);
    short* p2 = reinterpret_cast<short*>(p);

    cout << "16x unsigned"
        << " " << setw(4) << setfill('0') << hex << *p1
        << " " << setw(16) << bitset<16>(*p1)
        << " " << setw(6) << dec << setfill(' ') << *p1
        << " " << "signed"
        << " " << setw(4) << setfill('0') << hex << *p2
        << " " << setw(16) << bitset<16>(*p2)
        << " " << setw(6) << dec << setfill(' ')<< *p2 << endl;
}

