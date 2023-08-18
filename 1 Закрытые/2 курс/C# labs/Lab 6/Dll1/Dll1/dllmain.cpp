// dllmain.cpp : Определяет точку входа для приложения DLL.
#include "pch.h"
#include <iostream>

BOOL APIENTRY DllMain( HMODULE hModule,
                       DWORD  ul_reason_for_call,
                       LPVOID lpReserved
                     )
{
    switch (ul_reason_for_call)
    {
    case DLL_PROCESS_ATTACH:
    case DLL_THREAD_ATTACH:
    case DLL_THREAD_DETACH:
    case DLL_PROCESS_DETACH:
        break;
    }
    return TRUE;
}

class Matrix {
public:
    int matrixSize;
    Matrix(int n);
    ~Matrix();
    Matrix(const Matrix&);
    Matrix& operator=(const Matrix&);
    
};

Matrix::Matrix(int n) {

}