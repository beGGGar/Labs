#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <locale.h>
#include <cstdio>
#include <stdio.h>
#include <string> // ���������� ������
#include <fstream> // ���������� �����
using namespace std;

struct Disk {
	char* DiskName;
	int year;
	char* firm;
	int songsNum;
	float price;
};

void DialogInterface() {
	cout << "������ ������" << endl;
	cout << "�������� ����� ����____________ 1" << endl;
	cout << "����������� ���������� � �����_ 2" << endl;
	cout << "�����__________________________ 3" << endl;
	cout << endl;
	cout << "������� ����� �������: ";
}

int main() {
	setlocale(LC_ALL, "Rus");
	//struct Disk cd;
	const int number = 10;
	Disk disk[number] = {};

	//������ �� �����
	FILE* fp;
	char name[] = "base.txt";
	if ((fp = fopen(name, "r")) == NULL)
	{
		printf("�� ������� ������� ����");
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
		case 1: // ���������� �����
			cout << "�������� �����:   "; cin >> buff;
			disk[i].DiskName = new char[strlen(buff) + 1];
			strcpy(disk[i].DiskName, buff);
			cout << "��� �������:      "; cin >> disk[i].year;
			cout << "�����:            "; cin >> buff;
			disk[i].firm = new char[strlen(buff) + 1];
			strcpy(disk[i].firm, buff);
			cout << "���������� �����: "; cin >> disk[i].songsNum;
			cout << "����:             "; cin >> disk[i].price;
			i++;
			cout << endl;
			cout << "������� ����� �������: ";
			break;
		case 2:
			cout << "������� ���������� ����� �����: "; cin >> j;
			cout << "������ ����� �����: " << j << ":" << endl;
			cout << "�������� �����:     " << disk[j - 1].DiskName << endl;
			cout << "��� �������:        " << disk[j - 1].year << endl;
			cout << "�����:              " << disk[j - 1].firm << endl;
			cout << "���������� �����:   " << disk[j - 1].songsNum << endl;
			cout << "����:               " << disk[j - 1].price << endl << endl;
			cout << "������� ����� �������: ";
			break;
		case 3:
			//������ ������ � ���� ����� �������
			FILE * fp;
			if ((fp = fopen(name, "w")) == NULL)
			{
				printf("�� ������� ������� ����");
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
