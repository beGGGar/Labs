#define _CRT_SECURE_NO_WARNINGS
#include "date1.h"
using namespace std;

void date1::defineDate() {
	cout << "Дата в формате dd:месяц:yy" << endl << "День: ";
	day = intRangeCheck(1, 31);
	cout << "Месяц: ";
	char buff[4000];
	cin >> buff;
	setMonth(buff);
	cout << "Год: ";
	year = intRangeCheck(0, 99);
}

date1::date1() {
	month = "NotStated";
	day = 0;
	year = 0;
}

string date1::getMonth() {
	return month;
}

void date1::setMonth(string month_) {
	month = month_;
}

date1::date1(int day_, string month_, int year_) { setDay(day_); setMonth(month_); setYear(year_); }
void date1::setDay(int day_) { day = day_; }
void date1::setYear(int year_) { year = year_; }
int  date1::getDay() { return day; }
int  date1::getYear() { return year; }

