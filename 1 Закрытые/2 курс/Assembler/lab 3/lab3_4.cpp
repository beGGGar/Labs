#include <iostream>
//#include "lab3_1.cpp"
using namespace std;

void shifting(void* p){
    short sign = *reinterpret_cast<short*>(p);
    unsigned short uns = *reinterpret_cast<unsigned short*>(p);

    cout << (sign << 1) << endl;
    cout << (uns << 1) << endl;
    cout << (sign >> 1) << endl;
    cout << (uns >> 1) << endl;
    cout << (uns & 15) << endl;
    cout << (uns & -16) << endl << endl;
}
int main(){
    short n = -455;
    unsigned short m = 223;
    shifting(&n);
    shifting(&m);
    cin >> n;
    return 0;
}