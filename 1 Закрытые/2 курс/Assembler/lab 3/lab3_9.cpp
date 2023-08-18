#include <iostream>
#include <iomanip>
#include <bitset>
#include <cmath>

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

int main() {
    double e = 0.0001;
    double s=0;
    for (int i=(1/e)+500;i>-1;i--)
    {
        s=s+pow(-1,i)*(i+2)/(pow(i,2)+1);
    }
    cout<<s<<endl;
   return 0;
}
