#include "lab3_1.cpp"

int main(){ 
    short n = -455;
    unsigned short m = 223;
    int n1 = static_cast<int>(n), m1 = static_cast<int>(m);
    unsigned int n2 = static_cast<unsigned int>(n), m2 = static_cast<unsigned int>(m);
    print(n);
    print(m);

    cout << "16s to 32s ";
    print(n1);
    cout << "16s to 32u ";
    print(n2);
    cout << "16u to 32s ";
    print(m1);
    cout << "16u to 32u ";
    print(m2); 
    cin >> n;
    return 0;
}