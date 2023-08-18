#include <iostream>
using namespace std;

void print(int* mass, int n);
int* massGenerator(int n);
int* SimpleInsertSort(int* mass, int n);
int* ShellSort(int* mass, int n);
int InterpolationSearch(int* mass, int n, int needed);

int main()
{
	//1
	int n1 = 1000, n2 = 4000, n3 = 6000;
    int* mass;

	mass = massGenerator(n1);
	mass = SimpleInsertSort(mass, n1);
	cout << n1 << endl;
	/*for (int i = 0; i < n1; i++) {
		cout << mass[i] << " ";
	}*/
	delete mass;

	mass = massGenerator(n2);
	mass = SimpleInsertSort(mass, n2);
	cout << n2 << endl;
	delete mass;

	mass = massGenerator(n3);
	mass = SimpleInsertSort(mass, n3);
	cout << n3 << endl;
	delete mass;

	n1 = 2000, n2 = 5000, n3 = 6800;
	mass = massGenerator(n1);
	mass = ShellSort(mass, n1);
	cout << n1 << endl;
	delete mass;

	mass = massGenerator(n2);
	mass = ShellSort(mass, n2);
	cout << n2 << endl;
	delete mass;

	mass = massGenerator(n3);
	mass = ShellSort(mass, n3);
	cout << n3 << endl;
	
	system("pause");
	cout << endl << "Found" << endl;
	int needed, i = -1;
	while (true) {
         cout << "Input num >0 and <100000: "; cin >> needed;
		 i = InterpolationSearch(mass, n3, needed);
		 if (i == -1) {
			 cout << "No element in mass" << endl;
			 continue;
		 }
		 else if (i == -2) break;
		 else cout << "Element " << mass[i] << " was found on " << i << " place" << endl;
	}
	delete mass;
	return 0;
}

void print(int* mass, int n) {
	for (int i = 0; i < n; i++) {
		cout << mass[i] << " ";
	}
	cout << endl;
}

int* massGenerator(int n) {
	int* mass = new int[n];
	srand((unsigned)time(0));
	for (int i = 0; i < n; i++) {
		mass[i] = (rand() % 10000) + 1;
	}
	return mass;
}
//простая вставка
int* SimpleInsertSort(int* mass, int n) {
	int buff;
	for (int i = 1; i < n; i++) {
		buff = mass[i];
		for (int j = i; j >= 0; j--) {
			if (mass[j - 1] > buff) mass[j] = mass[j - 1];
			else {
				mass[j] = buff;
				break;
			}
		}
	}
	return mass;
}
//метод шелла
int* ShellSort(int* mass, int n) {
	int d = n, buff, det;
	while (true) {
		if (d != 1)d = d / 2;
		det = 0; //были ли смены
		for (int i = 0; i < n - d; i++) {
			if (mass[i] > mass[i + d]) {
				buff = mass[i];
				mass[i] = mass[i + d];
				mass[i + d] = buff;
				det--;
			}
		}
		if (d == 1 && det == 0)return mass;
	}
}

//интерполяционный поиск
int InterpolationSearch(int* mass, int n, int needed) {
	int left = 0, right = n - 1, mid;
	while (mass[left]<= needed && mass[right]>= needed) {
		mid = left + ((needed - mass[left]) * (right - left) / (mass[right] - mass[left]));
		if (mass[mid] < needed)left = mid + 1;
		else if (mass[mid] > needed)right = mid - 1;
		else return mid;
	}
	if (mass[left] == needed)return left;
	return -1;
}