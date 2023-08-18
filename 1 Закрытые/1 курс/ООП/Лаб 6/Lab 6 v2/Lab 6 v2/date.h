#pragma once
#include <iostream>
#include <string>
#include "IntCheck.h"
#pragma once

class date {
	int day, month, year;
	friend class storage;
public:
	date();
	date(int day_, int month_, int year_);
	void defineDate();
	void setDay(int day_);
	void setYear(int year_);
	void setMonth(int month_);
	int  getDay();
	int  getYear();
	int  getMonth();
	friend class storage;
};

