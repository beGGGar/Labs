#define _CRT_SECURE_NO_WARNINGS
//#pragma once
#include "date.h"

using namespace std;

date::date() { month = 0; day = 0; year = 0; }
void date::setDay(int day_) { day = day_; }
void date::setYear(int year_) { year = year_; }
void date::setMonth(int month_) { month = month_; }
int  date::getDay() { return day; }
int  date::getYear() { return year; }
int  date::getMonth() { return month; }

date::date(int day_, int month_, int year_) {
	day = day_; month = month_; year = year_;
}

void date::defineDate() {
	cout << "Дата поставки" << endl << "День: ";
	day = valueCheck(1, 31);
	cout << "Месяц: ";
	month = valueCheck(1, 12);
	cout << "Год: ";
	year = valueCheck(0, 99);
}


