#include <iostream>
#include <locale.h>
#include <windows.h>
#include <omp.h> 
#include <vector>
#include <chrono>

using namespace std;

int OnesCount(int num) {
    return __popcnt(num); // Стандартная функция VS для подсчета единиц в бинарнике
}

//const int NMAX = 100;
int main() {
    setlocale(LC_ALL, "Russian");
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);

    int M = 1000; // Количество строк
    int N = 1000; // Количество столбцов   
    
    vector<vector<int>> a(M, vector<int>(N));
    //инициализация
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            a[i][j] = rand()%(1000) + 1;
        }
    }

    int total_count = 0;
    auto start = std::chrono::high_resolution_clock::now();

#pragma omp parallel for reduction(+:total_count) shared(a)
    for (int i = 0; i < M; i++) {
        int line_ones = 0;
            
        for (int j = 0; j < N; j++) { //n-1
            for (int k = j + 1; k < N; k++) {
                line_ones += a[i][j] * a[i][k];
            }
        }
        total_count += OnesCount(line_ones);
        // cout << "Поток " << omp_get_thread_num() << " \t" << OnesCount(line_ones) << " единиц в строке " << i << endl;
    }
    cout << endl  << total_count << " единиц в бинарной записи числа всех попарных произведений элементов для каждой строки при параллельном подсчете" << endl;

    auto end = std::chrono::high_resolution_clock::now();
    std::chrono::duration<double> duration = end - start;
    cout << duration.count() << " Секунд занял параллельный код " << endl;

    start = std::chrono::high_resolution_clock::now();
    total_count = 0;
    for (int i = 0; i < M; i++) {
        int line_ones = 0;

        for (int j = 0; j < N; j++) { //n-1
            for (int k = j + 1; k < N; k++) {
                line_ones += a[i][j] * a[i][k];
            }
        }
        total_count += OnesCount(line_ones);
    }
    cout << endl << total_count << " единиц в бинарной записи числа всех попарных произведений элементов для каждой строки без omp" << endl;
    end = std::chrono::high_resolution_clock::now();
    duration = end - start;
    cout << duration.count() << " Секунд занял код без omp " << endl;
    return 0;
}

