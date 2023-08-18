#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <locale.h>
#include <cstdio>
#include <stdio.h>
#include <string> // подключаем строки
#include <fstream> // подключаем файлы
using namespace std;

struct Disk {
	char* DiskName;
	int year;
	char* firm;
	int songsNum;
	float price;
};

void DialogInterface() {
	cout << "Данные дисков" << endl;
	cout << "добавить новый диск____________ 1" << endl;
	cout << "распечатать информацию о диске_ 2" << endl;
	cout << "Выход__________________________ 3" << endl;
	cout << endl;
	cout << "Введите номер функции: ";
}

int main() {
	setlocale(LC_ALL, "Rus");
	//struct Disk cd;
	const int number = 10;
	Disk disk[number] = {};

	//чтение из файла
	FILE* fp;
	char name[] = "base.txt";
	if ((fp = fopen(name, "r")) == NULL)
	{
		printf("Не удалось открыть файл");
		system("pause");
		return 0;
	}
	int st;
	//if ((st = fgetc(fp)) != EOF) 
	//while(fscanf(f, "%d %d",&n, &nn)&& m++<11) 
	int s = 0;
	/*while (true) {
		if ((st = fgetc(fp)) == EOF) break;
		fscanf(fp, "%s", disk[s].DiskName);*/
		//fscanf(fp, "%d", disk[s].year);
		//fscanf(fp, "%s", disk[s].firm);
		//fscanf(fp, "%d", disk[s].songsNum);
		//fscanf(fp, "%f", disk[s].price);
		//s++;
	//}	
	fclose(fp);

	int c = 0, i = 0, j = 0, a;
	char buff[30];
	DialogInterface();
	while (true) {
		cin >> c;
		switch (c) {
		case 1: // добавление диска
			cout << "Название диска:   "; cin >> buff;
			disk[i].DiskName = new char[strlen(buff) + 1];
			strcpy(disk[i].DiskName, buff);
			cout << "Год выпуска:      "; cin >> disk[i].year;
			cout << "Фирма:            "; cin >> buff;
			disk[i].firm = new char[strlen(buff) + 1];
			strcpy(disk[i].firm, buff);
			cout << "Количество песен: "; cin >> disk[i].songsNum;
			cout << "Цена:             "; cin >> disk[i].price;
			i++;
			cout << endl;
			cout << "Введите номер функции: ";
			break;
		case 2:
			cout << "Введите порядковый номер диска: "; cin >> j;
			cout << "Данные диска номер: " << j << ":" << endl;
			cout << "Название диска:     " << disk[j - 1].DiskName << endl;
			cout << "Год выпуска:        " << disk[j - 1].year << endl;
			cout << "Фирма:              " << disk[j - 1].firm << endl;
			cout << "Количество песен:   " << disk[j - 1].songsNum << endl;
			cout << "Цена:               " << disk[j - 1].price << endl << endl;
			cout << "Введите номер функции: ";
			break;
		case 3:
			//запись данных в файл перед выходом
			FILE * fp;
			if ((fp = fopen(name, "w")) == NULL)
			{
				printf("Не удалось открыть файл");
				system("pause");
				return 0;
			}
			for (int i = 0; disk[i].DiskName; i++) {
				fprintf(fp, "%s\n", disk[i].DiskName);
				fprintf(fp, "%d\n", disk[i].year);
				fprintf(fp, "%s\n", disk[i].firm);
				fprintf(fp, "%d\n", disk[i].songsNum);
				fprintf(fp, "%f\n", disk[i].price);
			}
			//fprintf(fp, "%d", number);
			fclose(fp);
			system("pause");
			return 0;
		}
	}
	return 0;
}
