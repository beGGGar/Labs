#include <iostream>
#include <bitset>
#include <iomanip>
#include <climits>
using namespace std;

void print32(void* p);
void print64(void* p);


int main()
{
    cout << "//////////////print32/////////////" << endl;
    long lmin = - 2147483647; //-1
    long lmax = 2147483647;
    unsigned long lumin = 0;
    unsigned long lumax = 4294967295;
    long xl = 0x99887766;
    long yl = 5;
    long zl = -5;
    float xf = (float)0x99887766;
    float yf = 5;
    float zf = -5;

    print32(&lmin);
    print32(&lmax);
    print32(&lumin);
    print32(&lumax);
    print32(&xl);
    print32(&yl);
    print32(&zl);
    print32(&xf);
    print32(&yf);
    print32(&zf);


    cout << "//////////////print64/////////////" << endl;
    long long llmin = -9223372036854775807; //-1
    long long llmax = 9223372036854775807;
    unsigned long long llumin = 0;
    unsigned long long llumax = ULLONG_MAX;
    long long xll = 0x99887766;
    long long yll = 5;
    long long zll = -5;
    double xd = 0x99887766;
    double yd = 5;
    double zd = -5;

    print64(&llmin);
    print64(&llmax);
    print64(&llumin);
    print64(&llumax);
    print64(&xll);
    print64(&yll);
    print64(&zll);
    print64(&xd);
    print64(&yd);
    print64(&zd);

    cin >> lmin;
}

void print32(void* p) {
    unsigned int* p1 = reinterpret_cast<unsigned int*>(p);
    int* p2 = reinterpret_cast<int*>(p);
    float* p3 = reinterpret_cast<float*>(p);

    cout << "32x unsigned "
        << setw(8) << hex << setfill('0')  << *p1 << " " 
        << bitset<32>(*p1) << " " 
        << dec << setfill(' ')  << *p1;
    cout << endl << "32x signed   "
        << setw(8) << hex << setfill('0')  << *p2 << " " 
        << bitset<32>(*p2) << " " 
        << dec << setfill(' ')  << *p2;
    cout << endl << "float      " 
        << fixed << setw(15) << *p3 << " "
        << scientific << setw(15) << *p3 << endl << endl;
}

void print64(void* p) {
    unsigned long long* p1 = reinterpret_cast<unsigned long long*>(p);
    long long* p2 = reinterpret_cast<long long*>(p);
    double* p3 = reinterpret_cast<double*>(p);
    
    cout << "64x unsigned "
        << setw(16) << hex << setfill('0')  << *p1 << " " 
        << bitset<64>(*p1) << " " 
        << dec << setfill(' ')  << *p1;
    cout << endl << "64x signed   "
        << setw(16) << hex << setfill('0')  << *p2 << " " 
        << bitset<64>(*p2) << " " 
        << dec << setfill(' ')  << *p2;
    cout << endl << "double     " 
        << fixed << *p3 << " "
        << scientific << *p3 << endl << endl;
}
