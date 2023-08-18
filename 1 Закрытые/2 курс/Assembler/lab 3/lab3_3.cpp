#include "lab3_1.cpp"

using namespace std;

void Operations(void *p){
    short  sign = *reinterpret_cast<short*>(p);
    unsigned short uns = *reinterpret_cast<unsigned short*>(p);
    //print16(&(sign));
    cout << sign*2 << endl;
    cout << uns*2 << endl;
    cout << sign/2 << endl;
    cout << uns/2 << endl;
    cout << uns%16 << endl;
    cout << uns-uns%16 << endl << endl;
}


int main(){
    short n = -455;
    unsigned short m = 223;
    Operations(&n);
    Operations(&m);
    cin >> n;
    return 0;
}

