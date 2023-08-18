#define _CRT_SECURE_NO_WARNINGS
#include "storage.h"

using namespace std;

storage::storage() { num = 0; }
int  storage::getNum() { return num; }
void storage::setNum(int num_) { num = num_; }
void storage::setDay(int day) { expir.day = day; }
void storage::setMonth(int month) { expir.month = month; }
void storage::setYear(int year) { expir.year = year; }
ostream& operator<< (ostream& out, storage& St) {
	//out << "- Название: " << St.getName() << endl << "- Цена: " << St.getPrice() << endl << "- Количество: " << St.getQuant() << endl << "- Секция: " << St.getNum() << endl << "- Дата: " << St.expir.getDay() << ":" << St.expir.getMonth() << ":" << St.expir.getYear() << endl;
	out << setw(20) << St.getName() << setw(10) << St.getPrice() << setw(15) << St.getQuant() << setw(15) << St.getNum() << setw(10) << St.expir.getDay() << ":" << St.expir.getMonth() << ":" << St.expir.getYear() << endl;
	return out;
}

istream& operator>> (istream& in, storage& St) {
	char name[4000];
	double price;   // цена
	int quant, day, month, year, num;
	cout << "Название: ";
	in >> name;
	cout << "Цена: ";
	price = valueCheck(0, 99999999);
	cout << "Количество: ";
	quant = valueCheck(0, 99999999);
	cout << "Секция: ";
	num = valueCheck(0, 99999999);
	cout << "Дата в формате dd:mm:yy" << endl << "День: ";
	day = valueCheck(1, 31);
	cout << "Месяц: ";
	month = valueCheck(1, 12);
	cout << "Год: ";
	year = valueCheck(0, 99);
	St.setName(name);
	St.setNum(num);
	St.setQuant(quant);
	St.setPrice(price);
	St.setDay(day);
	St.setMonth(month);
	St.setYear(year);
	return in;
}

void storage::sortBread(int max) {
	storage temp;
	for (int i = 0; i < max; i++) {
		for (int j = 0; j < max - 1; j++) {
			if (this[j].getQuant() > this[j + 1].getQuant()) {
				temp = this[j];
				this[j] = this[j + 1];
				this[j + 1] = temp;
			}
		}
	}
	//for (int i = 0; i < max; i++) cout << this[i].getQuant() << endl;
	std::cout << "Успех!" << endl;
}

int storage::findFresh(int max) {
	storage* temp = new storage[max];
	date D;/// { 10, 10, 10 };
	//date D;
	D.defineDate();
	int count = 0;
	try
	{
		for (int j = 0; j < max; j++) {
			if (this[j] > D) {
				temp[count++] = this[j];
			}
		}
		if (count == 0) throw 0;

		for (int j = 0; j < count; j++)this[j] = temp[j];
		cout << "Успех" << endl;
		return count;
	}
	catch (...)
	{
		cout << "Свежих продуктов нет" << endl;
		return max;
	}


}

bool storage::operator>(date& D) {
	if (this->expir.getYear() > D.getYear())return true;
	if (this->expir.getYear() == D.getYear() && this->expir.getMonth() > D.getMonth())return true;
	if (this->expir.getYear() == D.getYear() && this->expir.getMonth() == D.getMonth() && this->expir.getDay() > D.getDay())return true;
	return false;
}

storage& storage::operator=(storage& right) {
	this->expir.setDay(right.expir.getDay());
	this->expir.setMonth(right.expir.getMonth());
	this->expir.setYear(right.expir.getYear());
	this->setName(right.getName());
	this->setNum(right.getNum());
	this->setQuant(right.getQuant());
	this->setPrice(right.getPrice());
	return *this;
}

int storage::filterNum(int max) {
	//то же самое что и поиск но по секции
	int id, count = 0;
	storage* temp = new storage[max];
	cout << "Введите желаемую секцию: "; cin >> id;

	try
	{
		for (int j = 0; j < max; j++) {
			if (this[j].getNum() == id) {
				temp[count++] = this[j];
			}
		}

		if (count == 0) throw 1;


		for (int j = 0; j < count; j++)this[j] = temp[j];
		delete[] temp;
		cout << "Успех!" << endl;
		return count;
	}
	catch (int n)
	{
		if (n == 1) {
			cout << "Товаров в данной секции нет" << endl;
			delete[] temp;
			return max;
		}
	}
}

storage::storage(storage& old) {
	expir = old.expir;
	setName(old.getName());
	setNum(old.getNum());
	setQuant(old.getQuant());
	setPrice(old.getPrice());
}

int storage::findBread(int max) {
	string buff;
	cout << "Введите название товара: "; cin >> buff;

	int I = 0, i = 0;
	for (i; i < max; i++) {
		if (buff == this[i].getName()) {
			this[i].print(0);
			I = 1;
			cout << this[i];
			return i;
		}
	}
	if (I == 0) {
		cout << "Таких товаров нет" << endl;
		return -1;
	}
}

void storage::saveList(int max, char* path) {
	//сохранение хлеба
	FILE* file;
	try
	{
		file = fopen(path, "w");
	}
	catch (...)
	{
		cout << "Ошибка открытия файла" << endl;
		fclose(file);
	}


	fprintf(file, "%d\n", max);
	for (int i = 0; i < max; i++) {
		fprintf(file, "%s\n", this[i].getName());
		fprintf(file, "%f %d %d\n", this[i].getPrice(), this[i].getQuant(), this[i].getNum());
		fprintf(file, "%d %d %d\n", this[i].expir.getDay(), this[i].expir.getMonth(), this[i].expir.getYear());
	}
	fclose(file);
};

int storage::loadList(char* path) {
	//чтение хлеба
	int n = 0, quant, num, day, month, year;
	char buff[4000];
	float price;
	FILE* file;
	try
	{
		file = fopen(path, "r");
		if (file == NULL)throw 1;
	}
	catch (...)
	{
		cout << "Файла нет, первый запуск." << endl;
		return 0;
	}

	fscanf(file, "%d", &n);

	for (int j = 0; j < n; j++) {
		fscanf(file, "%s", buff);
		this[j].setName(buff);

		fscanf(file, "%f %d %d", &price, &quant, &num);
		this[j].setPrice(price);
		this[j].setQuant(quant);
		this[j].setNum(num);
		fscanf(file, "%d %d %d", &day, &month, &year);
		this[j].expir.setDay(day);
		this[j].expir.setMonth(month);
		this[j].expir.setYear(year);
	}
	fclose(file);
	if (n == 0)cout << "Первый запуск." << endl;
	return n;
}

void storage::print(int n) {
	if (n == 0) {
		cout << setw(20) << "Название товара" << setw(10) << "цена" << setw(15) << "количество" << setw(15) << "секция" << setw(10) << "Дата" << endl;
	}
	if (n == 1) {
		cout << setw(20) << this->getName() << setw(10) << this->getPrice() << setw(15) << this->getQuant() << setw(15) << this->getNum() << setw(10) << this->expir.getDay() << ":" << this->expir.getMonth() << ":" << this->expir.getYear() << endl;
	}
}

void storage::printList(int max) {
	//вывод таблицы значений
	this[0].print(0);
	cout << "---------------------------------------------------------------------------" << endl;
	for (int i = 0; i < max; i++) {
		//this[i].print(1);
		cout << this[i];
	}
	cout << "---------------------------------------------------------------------------" << endl;
	cout << "Количество записей: " << max << endl;
}

