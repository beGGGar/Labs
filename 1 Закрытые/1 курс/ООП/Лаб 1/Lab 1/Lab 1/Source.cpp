#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <locale.h>
#include <stdio.h>
#include <iomanip>
#include <Windows.h>
#define max_bread 20
using namespace std;

typedef struct Base {
	char* fam;		//�������� ������
	double price;	// ����
	int quant;		// ����������
	int num;		// ����� ������
}bread;

void DialogInterface();
int addBread(bread* product, int n, int max); //�������� ����� �������
void printList(bread* product, int n);       //����������� ������� �������
void findBread(bread* product, int n);        //����� ����
void filterNum(bread* product, int n);        //������������� ���� �� �������
void saveList(bread* product, int n);         // ����������
int loadList(bread* product);				//�������� �� ����
void sortBread(bread* product, int n);		//���������� ��������� �� ���������� ���������� 

int main() {
	setlocale(LC_ALL, "Rus");
	SetConsoleCP(1251); // ���� � ������� � ���������
	SetConsoleOutputCP(1251); // ����� �� ������� � ���������
	int num = 0, c;

	bread* BB;
	BB = new bread[max_bread];

	FILE* file;
	if ((file = fopen("data.txt", "r+")) == NULL)
		cout << "����� ���, ������ ������." << endl;
	else {
		num = loadList(BB);
	}


	DialogInterface();
	while (true) { // ���� � �������
		cin >> c;
		switch (c) {
		case 0: 
			//������ ������ ��� ��������� ����� �����. ������� �������
			break;
		case 1: // ���������� ������
			addBread(BB, num, max_bread);
			num++;
			break;
		case 2:
			printList(BB, num);
			break;
		case 3:
			findBread(BB, num);
			break;
		case 4:
			filterNum(BB, num);
			break;
		case 5:
			sortBread(BB, num);
			break;
		case 6:
			saveList(BB, num);
			return 0;
		default:
			cout << "�������� ������, ��������� �������..." << endl;
			c = 0;
		}
	}
	cout << "���������� ��������... ���������� ����� ���� ������." << endl;
	return 0;
}

void DialogInterface() {
	//���������
	cout << "�������� ����� �������................1" << endl;
	cout << "����������� ���� �������..............2" << endl;
	cout << "����� ������ �� ��������..............3" << endl;
	cout << "������ �� ������ ������...............4" << endl;
	cout << "����������� �� ���������� ����������..5" << endl;
	cout << "����� �� ���������....................6" << endl; 
	cout << "......................................." << endl;
	cout << "������� ����� �������: " << endl;
};

int addBread(bread* product, int n, int max) {
	//���������� ����� � ������
	char buff[4000] = {}, c = 'a';
	bread* R = product;
	R = R + n;

	if (n + 1 > max) {
		cout << "������ ����������" << endl;
		return 0;
	}

	cout << "�������� ������: "; 

	int i = 0;
	c = getchar();
	while (true)
	{
		c = getchar();
		if (c == '\n') break;
		buff[i++] = c;
	}
	//fflush(stdin);
	//cin >> buff;
	R->fam = new char[strlen(buff) + 1];
	strcpy(R->fam, buff);

	cout << "����:            "; cin >> R->price; 
	cout << "����������:      "; cin >> R->quant;
	cout << "����� ������:    "; cin >> R->num;
	cout << endl << "������� ����� �������: ";
};

void printList(bread* product, int n){
	//����� ������� ��������
	char buff[80] = {};
	bread* R = product;
	// cout �������� ������ printf
	cout << setw(30) << "�������� ������" << setw(10) << "����" << setw(15) << "����������" << setw(15) << "����� ������" << endl;
	cout << "--------------------------------------------------" << endl;
	for (int i = 0; i < n; R++, i++) {
		cout << setw(30) << R->fam << setw(10) << R->price << setw(15) << R->quant << setw(15) << R->num << endl;
	}
	cout << "--------------------------------------------------" << endl;
	cout << "���������� �������: " << n << endl;
	cout << "������� ����� �������: ";
}

void findBread(bread* product, int n) {
	char buff[80] = {}, c;
	bread* R = product;

	cout << "������� �������� ������: "; 

	int i = 0;
	c = getchar();
	while (true)
	{
		c = getchar();
		if (c == '\n') break;
		buff[i++] = c;
	}
	//cin >> buff;

	cout << setw(30) << "�������� ������" << setw(10) << "����" << setw(15) << "����������" << setw(15) << "����� ������" << endl;
	//�������� �� ������� � ����� ��������� �����
	for (R; R < product + n; R++) {
		if (strcmp(buff, R->fam) == 0) {
			cout << setw(30) << R->fam << setw(10) << R->price << setw(15) << R->quant << setw(15) << R->num << endl;
		}
	}
	cout << "������� ����� �������: " << endl;
};

void filterNum(bread* product, int n) {
	//�� �� ����� ��� � ����� �� �� ������
	int id, i = 0;
	bread* R = product;

	cout << "������� �������� ������: "; cin >> id;
	cout << setw(20) << "�������� ������" << setw(10) << "����" << setw(10) << "����������" << setw(15) << "����� ������" << endl;
	for (R; R < product + n; R++) {
		if (id == R->quant) {
			cout << setw(20) << R->fam << setw(10) << R->price << setw(10) << R->num << setw(15) << R->quant << endl;
			i = 1; // ��� �������� �� ������� ������ ���� ������
		}
	}
	if (i == 0)cout << "������� � ������ ������ ���" << endl;
	cout << "������� ����� �������: " << endl;
}

void saveList(bread* product, int n) {
	//���������� �����
	bread* R = product;
	char buff[4000] = {};

	FILE* file;
	file = fopen("data.txt", "w");

	fprintf(file, "%d\n", n);
	for (R; R < product + n; R++) {
		strcpy(buff, R->fam);
		for (int i = 0; i < strlen(buff); i++) {
			fprintf(file, "%c", buff[i]);
		}
		//fprintf(file, "%s\n", R->fam);
		fprintf(file, "\n%f\n", R->price);
		fprintf(file, "%d\n", R->quant);
		fprintf(file, "%d\n", R->num);
	}
	fclose(file);
};

int loadList(bread* product) {
	//������ �����
	bread* R = product;
	int n = 0, quant, num, i;
	char buff[4000] = {}, c = ' ';
	float price;
	FILE* file;
	file = fopen("data.txt", "r");

	fscanf(file, "%d", &n);
	for (R; R < product + n; R++) {
		fscanf(file, "%s", buff);
		R->fam = new char[strlen(buff) + 1];
		strcpy(R->fam, buff);

		fscanf(file, "%f", &price);
		R->price = price;
		fscanf(file, "%d", &quant);
		R->quant = quant;
		fscanf(file, "%d", &num);
		R->num = num;
	}
	
	fclose(file);
	return n;
}

void sortBread(bread* product, int n) {
	//���������� �� ����������
	bread* R = product;
	char buff[4000] = {};
	double price;
	int quant, num;
	//��������� ����������� ����������
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n - 1; j++) {
			if ((R + j)->quant > (R + j + 1)->quant) {

				strcpy(buff, (R + j)->fam);
				price = (R + j)->price;
				quant = (R + j)->quant;
				num = (R + j)->num;

				delete (R + j)->fam;
				(R + j)->fam = new char[strlen((R + j + 1)->fam) + 1];
				strcpy((R + j)->fam, (R + j + 1)->fam);
				(R + j)->price = (R + j + 1)->price;
				(R + j)->quant = (R + j + 1)->quant;
				(R + j)->num = (R + j + 1)->num;

				//����� ������ �� ������ �������
				delete (R + j + 1)->fam;
				(R + j + 1)->fam = new char[strlen(buff) + 1];
				strcpy((R + j + 1)->fam, buff);
				(R + j + 1)->price = price;
				(R + j + 1)->quant = quant;
				(R + j + 1)->num = num;
			}
		}
	}
	cout << "���������� ������ �������!" << endl << "������� ����� �������: ";
}