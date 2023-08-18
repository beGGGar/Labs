#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <locale.h>
#include <cstdio>
#include <stdio.h>
#include <string> // ���������� ������
#include <fstream> // ���������� �����
#include <iomanip>
#define size_max 20
#define size_artical 6
using namespace std;

struct Date {
	int date;
	char* month;
	int year;
};

typedef struct artical {
	char* fio;
	char* MagName;
	struct Date date;
	int givetime;
}reader;

//bool expired(int date, char* month, int year);
void DialogInterface();
int init_artical(reader* art, int n, int max);
void print_list(reader* art, int n);
void print_artical(reader* art);
void save_list(reader* art, int n);
int load_list(reader* art);
//void find_expired();

int main() {
	int c, i=0;
	setlocale(LC_ALL, "Rus");

	reader* RR;
	
	RR = new reader[size_max];
	FILE* file;
	if ((file = fopen("data.txt", "r+")) == NULL)
		cout << "����� ���, ������ ������." << endl;
	else {
		i = load_list(RR);
		//print_list(RR, i);
	}

	DialogInterface();
	while (true) {
		cin >> c;
		switch (c) {
		case 1: // ���������� ��������
			init_artical(RR, i, size_max);
			i++;
			break;
		case 2:
			print_artical(RR);
			break;
		case 3:
			print_list(RR, i);
			break;
		case 4:
			return 0;
		case 5:
			save_list(RR, i);
			delete[]RR;
			cout << endl; system("pause");
			return 0;
		default:
			cout << "�������� ������, ��������� �������..." << endl;
		}
	}
	//save_list();
	delete[]RR;
	cout << endl; system("pause");
	return 0;
}

int init_artical(reader * art, int n, int max) {
	char buff[80] = {};
	reader* R = art;
	R = R + n;

	if (n + 1 > max) {
		cout << "������ ����������" << endl;
		return 0;
	}

	cout << "��� ��������:   "; cin >> buff;
	R->fio = new char[strlen(buff) + 1];
	strcpy(R->fio, buff);

	cout << "�������� �������: "; cin >> buff;
	R->MagName = new char[strlen(buff) + 1];
	strcpy(R->MagName, buff);

	cout << "���� ������: "; cin >> R->date.date >> buff >> R->date.year;
	R->date.month = new char[strlen(buff) + 1];
	strcpy(R->date.month, buff);

	cout << "�� ������� ������� �����:      "; cin >> R->givetime;
	cout << endl;
	cout << "������� ����� �������: ";
	return 0;
}

void print_artical(reader* art) {
	reader* R=art; 
	int j;

	cout << "������� ����� ��������� �����: "; cin >> j;
	R = R + j-1;
	cout << "�������� �������: " << R->MagName << endl;
	cout << "��� ��������:     " << R->fio << endl;
	cout << "���� ������:      " << R->date.date << " " << R->date.month << " " << R->date.year << endl;
	cout << "���� ������:      " << R->givetime << endl << endl;
	//cout << "���������:      " << R->year << endl << endl;
	cout << "������� ����� �������: ";
}

void save_list(reader* art, int n){
	reader* R = art;
	FILE* file;
	
	//file = fopen("data.bin", "wb");
	////fwrite(&n, sizeof(n), 1, file);
	//fwrite(R, sizeof(artical), size_artical, file);
	//fclose(file); 

	//file = fopen("data.bat", "bw");

	file = fopen("data.txt", "w");
	//fwrite(&n, sizeof(n), 1, file);
	fprintf(file, "%d\n", n);
	for (R; R < art + n; R++){
		fprintf(file, "%s\n", R->MagName);
		fprintf(file, "%s\n", R->fio); 
		fprintf(file, "%d\n", R->date.date);
		fprintf(file, "%s\n", R->date.month);
		fprintf(file, "%d\n", R->date.year);
		fprintf(file, "%d\n", R->givetime);
	}
	fclose(file);
}

int load_list(artical* art) {
	reader* R = art;
	int n = 0;

	ifstream file("data.txt");
	string str;
	if(getline(file, str))
		n = stoi(str);
	for (R; R < art + n; R++) {
		getline(file, str);
		R->MagName = new char[strlen(str.c_str()) + 1];
		strcpy(R->MagName, str.c_str());
		
		getline(file, str);
		R->fio = new char[strlen(str.c_str()) + 1];
		strcpy(R->fio, str.c_str());

		getline(file, str);
		R->date.date = stoi(str);

		getline(file, str);
		R->date.month = new char[strlen(str.c_str()) + 1];
		strcpy(R->date.month, str.c_str());

		getline(file, str);
		R->date.year = stoi(str);

		getline(file, str);
		R->givetime = stoi(str);
	}
	return n;
}
//int load_list(artical* art) {
//	artical* R = art;
//	FILE* file;
//	//file = fopen("data.dat", "rb");
//	int n = 0;
//	char buff[80];
//
//	file = fopen("data.txt", "r");
//	/*for (R = art; !feof(file); R++) {
//		fread(R, sizeof(artical), 1, file);
//		n++;
//	}*/
//	
//	
//	//fscanf(file, "%d\n", n);
//	//cout << "n=" << n;
//
//	for (; !feof(file); R++){
//		fscanf(file, "%s\n", buff);
//		R->MagName = new char[strlen(buff) + 1];
//		strcpy(R->MagName, buff);
//
//		fscanf(file, "%s\n", buff);	
//		R->fio = new char[strlen(buff) + 1];
//		strcpy(R->fio, buff);
//
//		fscanf(file, "%s\n", buff);
//		R->date.date = (int)buff;
//		
//		fscanf(file, "%s\n", buff); 
//		R->date.month = new char[strlen(buff) + 1];
//		strcpy(R->date.month, buff);
//
//		fscanf(file, "%s\n", buff);
//		R->date.year = (int)buff;
//
//		fscanf(file, "%s\n", buff);
//		R->givetime = (int)buff;
//		n++;
//	}
//
//
//
//	//fread(&n, sizeof(n), 1, file);
//	//for (R; !feof(file); R++)
//	//	fread(R, sizeof(artical), 1, file);	// ������ 1��� ���������
//	//fclose(file);
//	//file = fopen("data1.bin", "wb");
//	//fwrite(&n, sizeof(n), 1, file);
//	//fwrite(R, sizeof(artical), size_artical, file);
//	//fclose(file);
//	//file = fopen("data1.txt", "w");
//	//fwrite(&n, sizeof(n), 1, file);
//
//
//
//	/*fprintf(file, "%d\n", n);
//	for (R; R < art + n; R++) {
//		fprintf(file, "%s\n", R->MagName);
//		fprintf(file, "%s\n", R->fio);
//		fprintf(file, "%d\n", R->date.date);
//		fprintf(file, "%s\n", R->date.month);
//		fprintf(file, "%d\n", R->date.year);
//		fprintf(file, "%d\n", R->givetime);
//	}*/
//	/*file = fopen("data1.bin", "wb");
//	fwrite(R, sizeof(artical), size_artical, file);*/
//	fclose(file);
//	return n;
//}

void print_list(reader* art, int n) {
	reader* R = art;
	char buff[80];
	cout << setw(20) << "�������� �����" << setw(15) << "���� ������" << setw(15) << "���� ������" << endl;
	cout << "--------------------------------------------------" << endl;
	for (int i=0; i < n; R++, i++) {
		strcpy(buff, R->date.month);
		cout << setw(20) << R->MagName << setw(15) << R->date.date << " " << buff << " " << R->date.year << setw(10) << R->givetime << endl;
	}
	cout << "--------------------------------------------------" << endl;
	cout << "���������� �������: " << n << endl;
	cout << "������� ����� �������: ";
}

void DialogInterface() {
	cout << "���������� '������'" << endl;
	cout << "������ ����� ������____________ 1" << endl;
	cout << "����������� ���������� � �����_ 2" << endl;
	cout << "����������� ������� ���������__ 3" << endl;
	cout << "����� ���� ���������___________ 4" << endl;
	cout << "����� � ����������_____________ 5" << endl;
	cout << endl;
	cout << "������� ����� �������: ";
}

//bool expired(int date, char* month, int year) {
//
//	return 0;
//}
