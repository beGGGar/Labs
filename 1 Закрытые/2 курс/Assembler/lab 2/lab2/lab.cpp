#include <iostream>
using namespace std;

void printDump(void* _p, size_t N) {
unsigned char* p = reinterpret_cast<unsigned char*>(_p);
for (size_t i = 0; i < N; i++) {
printf("%02hhx", p[i]);
}
putchar('\n');
}

int main()
{
double d = 5;
int i = 0x99887766;
int im[] = { 34, 50, 2 };

printDump(&i, 20);
printDump(im, 20);
printDump(&d, 20);
}