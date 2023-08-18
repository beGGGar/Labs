#include <iostream>
#include <bitset>
#include <iomanip>
using namespace std;

void print16(void* p);

int main()
{
    short imin = -32768;
    short imax = 32767;
    unsigned short iumin = 0;
    unsigned short iumax = 65535;
    short y = 5;
    short z = -5;

    print16(&imin);
    print16(&imax);
    print16(&iumin);
    print16(&iumax);
    print16(&y);
    print16(&z);

    cin >> imin;
}


void print16(void* p) {
    unsigned short* p1 = reinterpret_cast<unsigned short*>(p);
    short* p2 = reinterpret_cast<short*>(p);

    cout << "16x unsigned "
        << setfill('0') << hex << setw(4) << *p1
        << " " << bitset<16>(*p1)
        << dec << setfill(' ') << setw(6) << *p1;
    cout << " signed "
        << setfill('0') << hex << setw(4) << *p2
        << " " << bitset<16>(*p2)
        << " " << dec << setfill(' ') << setw(6) << *p2
        << endl;
}