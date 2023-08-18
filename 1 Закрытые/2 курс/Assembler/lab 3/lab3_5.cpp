#include <iostream>
using namespace std;

unsigned short roundDown(unsigned short p, short D = 16){
    return p  - (p&(D-1));
}

unsigned short roundUp(unsigned short p, short D = 16){
    return p + (D - (p&(D-1)));
}

int main(){
    unsigned short m = 223, n = 312;
    cout << roundDown(m) << " " << roundUp(m) << endl;
    cout << roundDown(n) << " " << roundUp(n);
    cin >> n;
    return 0;
}