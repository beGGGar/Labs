#define _CRT_SECURE_NO_WARNINGS
//#include <iostream>
//#include <stdio.h>
//#include <stdlib.h>
//#include <string.h>
#include <Windows.h>
#include "Buyer.cpp"
using namespace std;


int main() {
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);

    Category* cat = new Category("name1", 325);
    Product* prod = new Product("Хлеб", 12.1, 23, *cat);
    Buyer* buy = new Buyer("Piter", "Pedigry", 888, 0.11);
    Pencion_buyer* pen = new Pencion_buyer("Piter", "Pedigry", 888, 0.11, 0.33);

    cout << *pen;
    delete prod;
    delete cat;
    return 0;
}