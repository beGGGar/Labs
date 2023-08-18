//#include <iostream>
//using namespace std;
//
//void printDump(void* p, size_t N) {
//    //num 5
//    unsigned short* p1 = reinterpret_cast<unsigned short*>(p);
//    double* p2 = reinterpret_cast<double*>(p);
//    for (size_t i = 0; i < N; i++) {
//        printf("%02hhX", p1[i]);
//    }
//    cout << endl;
//    for (size_t i = 0; i < N; i++) {
//        printf("%02hhX", p2[i]);
//    }
//    cout << endl << endl;
//
//}
//
//int main()
//{
//    double d = 3455.33;
//    int i = 34;
//    int im[] = { 34, 50, 2 };
//
//    printDump(&i, 16);
//    printDump(im, 16);
//    printDump(&d, 16);
//
//}
//void viewPoint(void* p) {
//    char* p1 = reinterpret_cast<char*>(p);
//    unsigned short* p2 = reinterpret_cast<unsigned short*>(p);
//    double* p3 = reinterpret_cast<double*>(p);
//    cout << p << endl;
//    cout << p1 << endl;
//    cout << p2 << endl;
//    cout << p3 << endl << endl;
//}
//
//void printDump(void* p, size_t N) {
//    //num 5
//    unsigned short* p1 = reinterpret_cast<unsigned short*>(p);
//    double* p2 = reinterpret_cast<double*>(p);
//    for (size_t i = 0; i < N; i++) {
//        printf("%02hhX", p1[i]);
//    }
//    cout << endl;
//    for (size_t i = 0; i < N; i++) {
//        printf("%02hhX", p2[i]);
//    }
//    cout << endl << endl;
//
//}
//
//void mem_display(void* address) {
//    char* p = reinterpret_cast<char*>(address);
//    for (size_t i = 0; i < 16; i++) {
//        printf("%02hhx", p[i]);
//    }
//    putchar('\n');
//}