#define _CRT_SECURE_NO_WARNINGS
#include "stdafx.h"
#include<iostream>
#include <clocale>
#include <iostream>
#include <locale.h>
#include <cstdio>
#include <stdio.h>
#include <string> // подключаем строки
#include <fstream> // подключаем файлы
#include <iomanip>
#define size_work 5	
#define size_max 200
using namespace std;
// Вспомогательный тип, для структуризации данных проекта
typedef struct _fio 	// информация о человеке
{
	char* fam;		//Фамилия 
	char* name;		//Имя 
	char* father;		//отчество
} fio;
//------------------------------------------------

typedef struct _work
{
	fio worker;		// ФИО сотрудника
	int dept;			// номер отдела
} work;


// ввод с клавиатуры фамилии имени и отчества 
void init_fio(work* pp);
// инициализация массива структур work
void init_work(work* b_work, int n);
// печать информации в табличном виде 
void list_work(work* b_work, int n);
// сохранение данных на диске 
void save_work(work* b_work, int n);
// загрузка данных с диска 
void load_work(work* b_work);

int main()
{// создание указателей для работы с памятью и жестким диском
	work* pD;
	FILE* pf;
	setlocale(LC_ALL, "Russian");  		// русификация вывода на экран
	/* выделение памяти под массив структур, запрос делается с запасом (чтобы хватило для данных, загружаемых с диска и на расширение массива при текущей работе)*/
	pD = new work[size_max];	// основной массив данных		
	/* режим rb+ позволяет читать и записывать данные, при отсутствии файла генерируется ошибка*/
	if ((pf = fopen("data.bin", "rb+")) == NULL)
		// если файла нет, то первоначальный ввод с клавиатуры
	{
		cout << "Файла нет, инициализация с клавиатуры !" << endl;
		init_work(pD, size_work);
	}
	else			// если файл есть, то загрузка из файла*/
		load_work(pD); // загрузка данных с диска в динамическую память
		// печать информации в табличном виде 
	list_work(pD, size_work);
	/* в этой части располагается пользовательский интерфейс (меню команд) проекта*/


		// сохранение данных на диске
		save_work(pD, size_work);
	delete[]pD;
	cout << endl; system("pause");
	return 0;
}

//-------------------- Определения Функций----------------------------
void init_fio(work * pp)	// ввод с клавиатуры фамилии имени и отчества
{
	char buff[80];	// буферная строка для ввода с клавиатуры
	int len;
	cout << "Введите\n Фамилию :";
	fscanf(stdin, "%s", buff); // ввод строки в буфер 
	len = strlen(buff) + 1; // определение длины
	pp->worker.fam = new char(len); //выделение дин. памяти под строку
	memcpy(pp->worker.fam, buff, len);// копирование из буфера в память
	fflush(stdin);				// очистка буфера входного потока
	cout << " Имя :";
	fscanf(stdin, "%s", buff);
	len = strlen(buff) + 1;
	pp->worker.name = new char(len);
	memcpy(pp->worker.name, buff, len);
	fflush(stdin);
	cout << " Отчество :";
	fscanf(stdin, "%s", buff);
	len = strlen(buff) + 1;
	pp->worker.father = new char(len);
	memcpy(pp->worker.father, buff, len);
	fflush(stdin);
};

//------------------------------------------------
// инициализация с клавиатуры массива структур типа work
void init_work(work* b_work, int n)
{
	work* tw;	// рабочий указатель для работы с дин. памятью
	for (tw = b_work; tw < b_work + n; tw++)
	{
		init_fio(tw); // ввод 3-х динамических строк
		cout << " Номер отдела : ";
		cin >> tw->dept; // ввод числовой информации	
		fflush(stdin);
	}
};

//------------------------------------------------
// печать информации в табличном виде
void list_work(work* b_work, int n)
{
	work* tw;
	char  buff[80]; // буфер для соединения (упаковки) строк
	// печать «шапки таблицы
	cout << '\t' << "ФИО" << '\t' << '\t' << "Номер отдела" << endl;
	cout << "-----------------------------------------------\n";
	for (tw = b_work; tw < b_work + n; tw++)
	{
		strcpy(buff, "");	//------------------------------ упаковка ФИО в одну строку
		strcat(buff, tw->worker.fam);strcat(buff, " ");
		strcat(buff, tw->worker.name);strcat(buff, " ");
		strcat(buff, tw->worker.father); //----------------------------
	  /*Какой бы длины не были строки ФИО, упакованный и отформатированный буфер не будет превышать 25 знаков, что не позволит выйти за границы столбца таблицы*/
		fprintf(stdout, "\n%-25s %5d", buff, tw->dept);
	}
};

// сохранение данных на диске
//------------------------------------------------
void save_work(work* b_work, int n)
{
	work* tw;
	FILE* pf;
	// определение формата записи на диск 
	if ((pf = fopen("data.bin", "wb")) == NULL)
	{
		perror("Ошибка открытия файла: режим save_bin");
	}
	// двоичная запись массива структур в файл data.bin
	tw = b_work;
	fwrite(tw, sizeof(work), size_work, pf);
	fclose(pf); // закрыть бинарный файл	
	// запись динамических строк из Кучи в файл data.txt
	if ((pf = fopen("data.txt", "w")) == NULL)
	{
		perror("Ошибка открытия файла: режим save_txt");
	}
	// запись строк в текстовый файл
	for (tw = b_work; tw < b_work + n; tw++)
	{
		fprintf(pf, "%s\n", tw->worker.fam);
		fprintf(pf, "%s\n", tw->worker.name);
		fprintf(pf, "%s\n", tw->worker.father);
	}
	fclose(pf); // закрыть текстовый файл};
}

	// загрузка данных с диска 
	//------------------------------------------------
	void load_work(work * b_work){
		work* tw;
		FILE* pf;
		char  buff[80]; // буфер для чтения строки с диска
	   // определение формата чтения с диска (бинарный файл)
		if ((pf = fopen("data.bin", "rb")) == NULL)
		{
			perror("Ошибка открытия файла: режим load_bin");
		}
		// продолжать цикл пока "не конец файла"
		for (tw = b_work; !feof(pf); tw++)
			fread(tw, sizeof(work), 1, pf);	// чтение 1–ой структуры
		fclose(pf); // закрыть бинарный файл	
		 // определение формата чтения с диска (текстовый файл)
		if ((pf = fopen("data.txt", "r")) == NULL)
		{
			perror("Ошибка открытия файла: режим load_txt");
		}
		for (tw = b_work; !feof(pf); tw++)
		{
			fscanf(pf, "%s\n", buff);			// fam с диска в буфер
		   //	выделение памяти под строку 
			tw->worker.fam = new char(strlen(buff) + 1);
			strcpy(tw->worker.fam, buff); // копирование из буфера в память
			fscanf(pf, "%s\n", buff);	    		// name с диска
			tw->worker.name = new char(strlen(buff) + 1);
			strcpy(tw->worker.name, buff);
			fscanf(pf, "%s\n", buff);				// father с диска
			tw->worker.father = new char(strlen(buff) + 1);
			strcpy(tw->worker.father, buff);
		}
		fclose(pf); // закрыть текстовый файл
	};

