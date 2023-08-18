#include <iostream>
#include <bitset>
#include <iomanip>
using namespace std;

void print16(void* p);
void print32(void* p);
void print64(void* p);


int main()
{
    cout << "//////////////print16/////////////" << endl;
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

    cout << "//////////////print32/////////////" << endl;
    //long lmin = - 2147483647; //-1
    //long lmax = 2147483647;
    //unsigned long lumin = 0;
    //unsigned long lumax = 4294967295;
    //long xl = 0x99887766;
    //long yl = 5;
    //long zl = -5;
    //float xf = (float)0x99887766;
    //float yf = 5;
    //float zf = -5;

    /*print32(&lmin);
    print32(&lmax);
    print32(&lumin);
    print32(&lumax);
    print32(&xl);
    print32(&yl);
    print32(&zl);
    print32(&xf);
    print32(&yf);
    print32(&zf);*/


    cout << "//////////////print64/////////////" << endl;
    //long long llmin = -9223372036854775807; //-1
    //long long llmax = 9223372036854775807;
    //unsigned long long llumin = 0;
    //unsigned long long llumax = 18446744073709551615;
    //long long xll = 0x99887766;
    //long long yll = 5;
    //long long zll = -5;
    //double xd = 0x99887766;
    //double yd = 5;
    //double zd = -5;

    /*print64(&llmin);
    print64(&llmax);
    print64(&llumin);
    print64(&llumax);
    print64(&xll);
    print64(&yll);
    print64(&zll);
    print64(&xd);
    print64(&yd);
    print64(&zd);*/

    cin >> imin;
}


void print16(void* p) {
    unsigned short* p1 = reinterpret_cast<unsigned short*>(p);
    short* p2 = reinterpret_cast<short*>(p);
    cout << hex << *(reinterpret_cast<unsigned short*>(p)) << " 16x uns" << endl;
    bitset<sizeof(*p1) * 8> x1(*p1);
    cout << x1 << " 2x uns" << endl;
    cout << *p1 << " 10x uns" << endl;
    cout << hex << *p2 << " 16x" << endl;
    bitset<16> x2(*p2);
    cout << x2 << " 2x" << endl;
    cout << *p2 << " 10x" << endl << endl;
}

void print32(void* p) {
    float* p1 = reinterpret_cast<float*>(p);
    cout << fixed<< setprecision(2) << *p1 << " 32x" << endl;
    cout << scientific << *p1 << " 32x" << endl << endl;
    
}
void print64(void* p) {
    double* p1 = reinterpret_cast<double*>(p);
    cout << fixed << setprecision(2) << *p1 << " 64x" << endl;
    cout << scientific << *p1 << " 64x" << endl << endl;
}