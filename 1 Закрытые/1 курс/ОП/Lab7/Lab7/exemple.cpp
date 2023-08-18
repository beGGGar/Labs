#define _CRT_SECURE_NO_WARNINGS
#include "stdafx.h"
#include<iostream>
#include <clocale>
#include <iostream>
#include <locale.h>
#include <cstdio>
#include <stdio.h>
#include <string> // ���������� ������
#include <fstream> // ���������� �����
#include <iomanip>
#define size_work 5	
#define size_max 200
using namespace std;
// ��������������� ���, ��� �������������� ������ �������
typedef struct _fio 	// ���������� � ��������
{
	char* fam;		//������� 
	char* name;		//��� 
	char* father;		//��������
} fio;
//------------------------------------------------

typedef struct _work
{
	fio worker;		// ��� ����������
	int dept;			// ����� ������
} work;


// ���� � ���������� ������� ����� � �������� 
void init_fio(work* pp);
// ������������� ������� �������� work
void init_work(work* b_work, int n);
// ������ ���������� � ��������� ���� 
void list_work(work* b_work, int n);
// ���������� ������ �� ����� 
void save_work(work* b_work, int n);
// �������� ������ � ����� 
void load_work(work* b_work);

int main()
{// �������� ���������� ��� ������ � ������� � ������� ������
	work* pD;
	FILE* pf;
	setlocale(LC_ALL, "Russian");  		// ����������� ������ �� �����
	/* ��������� ������ ��� ������ ��������, ������ �������� � ������� (����� ������� ��� ������, ����������� � ����� � �� ���������� ������� ��� ������� ������)*/
	pD = new work[size_max];	// �������� ������ ������		
	/* ����� rb+ ��������� ������ � ���������� ������, ��� ���������� ����� ������������ ������*/
	if ((pf = fopen("data.bin", "rb+")) == NULL)
		// ���� ����� ���, �� �������������� ���� � ����������
	{
		cout << "����� ���, ������������� � ���������� !" << endl;
		init_work(pD, size_work);
	}
	else			// ���� ���� ����, �� �������� �� �����*/
		load_work(pD); // �������� ������ � ����� � ������������ ������
		// ������ ���������� � ��������� ���� 
	list_work(pD, size_work);
	/* � ���� ����� ������������� ���������������� ��������� (���� ������) �������*/


		// ���������� ������ �� �����
		save_work(pD, size_work);
	delete[]pD;
	cout << endl; system("pause");
	return 0;
}

//-------------------- ����������� �������----------------------------
void init_fio(work * pp)	// ���� � ���������� ������� ����� � ��������
{
	char buff[80];	// �������� ������ ��� ����� � ����������
	int len;
	cout << "�������\n ������� :";
	fscanf(stdin, "%s", buff); // ���� ������ � ����� 
	len = strlen(buff) + 1; // ����������� �����
	pp->worker.fam = new char(len); //��������� ���. ������ ��� ������
	memcpy(pp->worker.fam, buff, len);// ����������� �� ������ � ������
	fflush(stdin);				// ������� ������ �������� ������
	cout << " ��� :";
	fscanf(stdin, "%s", buff);
	len = strlen(buff) + 1;
	pp->worker.name = new char(len);
	memcpy(pp->worker.name, buff, len);
	fflush(stdin);
	cout << " �������� :";
	fscanf(stdin, "%s", buff);
	len = strlen(buff) + 1;
	pp->worker.father = new char(len);
	memcpy(pp->worker.father, buff, len);
	fflush(stdin);
};

//------------------------------------------------
// ������������� � ���������� ������� �������� ���� work
void init_work(work* b_work, int n)
{
	work* tw;	// ������� ��������� ��� ������ � ���. �������
	for (tw = b_work; tw < b_work + n; tw++)
	{
		init_fio(tw); // ���� 3-� ������������ �����
		cout << " ����� ������ : ";
		cin >> tw->dept; // ���� �������� ����������	
		fflush(stdin);
	}
};

//------------------------------------------------
// ������ ���������� � ��������� ����
void list_work(work* b_work, int n)
{
	work* tw;
	char  buff[80]; // ����� ��� ���������� (��������) �����
	// ������ ������ �������
	cout << '\t' << "���" << '\t' << '\t' << "����� ������" << endl;
	cout << "-----------------------------------------------\n";
	for (tw = b_work; tw < b_work + n; tw++)
	{
		strcpy(buff, "");	//------------------------------ �������� ��� � ���� ������
		strcat(buff, tw->worker.fam);strcat(buff, " ");
		strcat(buff, tw->worker.name);strcat(buff, " ");
		strcat(buff, tw->worker.father); //----------------------------
	  /*����� �� ����� �� ���� ������ ���, ����������� � ����������������� ����� �� ����� ��������� 25 ������, ��� �� �������� ����� �� ������� ������� �������*/
		fprintf(stdout, "\n%-25s %5d", buff, tw->dept);
	}
};

// ���������� ������ �� �����
//------------------------------------------------
void save_work(work* b_work, int n)
{
	work* tw;
	FILE* pf;
	// ����������� ������� ������ �� ���� 
	if ((pf = fopen("data.bin", "wb")) == NULL)
	{
		perror("������ �������� �����: ����� save_bin");
	}
	// �������� ������ ������� �������� � ���� data.bin
	tw = b_work;
	fwrite(tw, sizeof(work), size_work, pf);
	fclose(pf); // ������� �������� ����	
	// ������ ������������ ����� �� ���� � ���� data.txt
	if ((pf = fopen("data.txt", "w")) == NULL)
	{
		perror("������ �������� �����: ����� save_txt");
	}
	// ������ ����� � ��������� ����
	for (tw = b_work; tw < b_work + n; tw++)
	{
		fprintf(pf, "%s\n", tw->worker.fam);
		fprintf(pf, "%s\n", tw->worker.name);
		fprintf(pf, "%s\n", tw->worker.father);
	}
	fclose(pf); // ������� ��������� ����};
}

	// �������� ������ � ����� 
	//------------------------------------------------
	void load_work(work * b_work){
		work* tw;
		FILE* pf;
		char  buff[80]; // ����� ��� ������ ������ � �����
	   // ����������� ������� ������ � ����� (�������� ����)
		if ((pf = fopen("data.bin", "rb")) == NULL)
		{
			perror("������ �������� �����: ����� load_bin");
		}
		// ���������� ���� ���� "�� ����� �����"
		for (tw = b_work; !feof(pf); tw++)
			fread(tw, sizeof(work), 1, pf);	// ������ 1��� ���������
		fclose(pf); // ������� �������� ����	
		 // ����������� ������� ������ � ����� (��������� ����)
		if ((pf = fopen("data.txt", "r")) == NULL)
		{
			perror("������ �������� �����: ����� load_txt");
		}
		for (tw = b_work; !feof(pf); tw++)
		{
			fscanf(pf, "%s\n", buff);			// fam � ����� � �����
		   //	��������� ������ ��� ������ 
			tw->worker.fam = new char(strlen(buff) + 1);
			strcpy(tw->worker.fam, buff); // ����������� �� ������ � ������
			fscanf(pf, "%s\n", buff);	    		// name � �����
			tw->worker.name = new char(strlen(buff) + 1);
			strcpy(tw->worker.name, buff);
			fscanf(pf, "%s\n", buff);				// father � �����
			tw->worker.father = new char(strlen(buff) + 1);
			strcpy(tw->worker.father, buff);
		}
		fclose(pf); // ������� ��������� ����
	};

