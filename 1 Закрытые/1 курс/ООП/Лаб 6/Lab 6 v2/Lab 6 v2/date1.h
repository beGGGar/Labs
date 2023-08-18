#pragma once
#include <iostream>
#include <string>
#include "IntCheck.h"

class date1 {
private:
	string month;
	int day, year;
	friend class storage1;
public:
	date1();
	date1(int day_, string month_, int year_);
	void defineDate();
	string getMonth();
	void setMonth(string month_);
	void setDay(int day_);
	void setYear(int year_);
	int  getDay();
	int  getYear();
	friend class storage1;
};
