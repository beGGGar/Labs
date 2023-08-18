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

void harmonic_first_float(long N)
{
    float s=0;
    for (long i=1;i<N+1;i++)
    {
        s = s+1.0/i;
    }
    cout<<s<<endl;
}
    
void harmonic_second_float(long N)
{
    float s=0;
    for (long i=N;i > 0;i--)
    {
        s = s+1.0/i;
    }
    cout<<s<<endl;
}

void harmonic_first_double(long N)
{
    double s=0;
    for (long i=1;i<N+1;i++)
    {
        s = s+1.0/i;
    }
    cout<<s<<endl;
}
    
void harmonic_second_double(long N)
{
    double s=0;
    for (long i=N;i > 0;i--)
    {
        s = s+1.0/i;
    }
    cout<<s<<endl;
}

int main() {
   cout<<"N8"<<endl;
        harmonic_first_float(1000);
        harmonic_second_float(1000);
        harmonic_first_float(1000000);
        harmonic_second_float(1000000);
        harmonic_first_float(1000000000);
        harmonic_second_float(1000000000);
        cout << endl << endl;
        harmonic_first_double(1000);
        harmonic_second_double(1000);
        harmonic_first_double(1000000);
        harmonic_second_double(1000000);
        harmonic_first_double(1000000000);
        harmonic_second_double(1000000000);
   return 0;
}
