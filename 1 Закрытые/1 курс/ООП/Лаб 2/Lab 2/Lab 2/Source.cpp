#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <locale.h>
#include <stdio.h>
#include <Windows.h>
#include <iomanip>
#define max_bread 20
using namespace std;

class date {
	int day, month, year;
	friend class storage;
public:
	date();
	date(int day_, int month_, int year_);
	void defineDate();
	int  getDay(){return day;}
	int  getMonth(){return month;}
	int  getYear(){return year;}
	void setDay(int day_){day = day_;}
	void setMonth(int month_){month = month_;}
	void setYear(int year_){year = year_;}
};

class storage {
	date expir;
	char* name;	   //Название товара
	double price;   // цена
	int quant, num;	    // количество, номер секции
	static int count;        // счетчик существующих объектов класса

	friend void sortBread(storage& BB, int n);		//сортировка продуктов по уменьшению количества 
public:
	storage();
	storage(storage &old);
	storage(const char s[], double newprice, int newquant, int newnum);
	storage(const char s[], double newprice, int newquant, int newnum, int day, int month, int year);
	~storage();
	void define();

	void printList(storage* product, int n);
	void findBread(storage* product, int n);        //найти хлеб
	void filterNum(storage* product, int n);        //отфильтровать хлеб по секциям
	void saveList(storage* product, int n);         // сохранение
	int  loadList(storage* product);				//загрузка из базы

	char*  getName() { return name; }
	double getPrice() { return price; }
	int    getNum() { return num; }
	int	   getQuant() { return quant; }
	int    getCount() { return count; }

	void setName(char* name_);
	void setPrice(double price_) { price = price_; }
	void setNum(int num_) { num = num_; }
	void setQuant(int quant_) { quant = quant_; }
};

void DialogInterface();
void sortBread(storage* product, int n);		//сортировка продуктов по уменьшению количества 
int storage::count = 0;


int main() {
	setlocale(LC_ALL, "Rus");
	SetConsoleCP(1251); // Ввод с консоли в кодировке
	SetConsoleOutputCP(1251); // Вывод на консоль в кодировке

	storage  BB[max_bread];
	int num = 0, c;

	FILE* file;
	if ((file = fopen("data.txt", "r")) == NULL)
		cout << "Файла нет, первый запуск." << endl;
	else {
		num = BB[0].loadList(BB);
		if (num == 0)cout << "Первый запуск." << endl;
	}

	DialogInterface();
	while (true) { // цикл с ключами
		cin >> c;
		switch (c) {
		case 0:
			break;
		case 1: // добавление товара
			BB[num].define();
			num++;
			cout << "Введите номер функции: " << endl;
			break;
		case 2:
			BB[0].printList(BB, num);
			break;
		case 3:
			BB[0].findBread(BB, num);
			break;
		case 4:
			BB[0].filterNum(BB, num);
			break;
		case 5:
			sortBread(BB, num);
			break;
		case 6:
			BB[0].saveList(BB, num);
			return 0;
		default:
			cout << "Неверный запрос, повторите попытку..." << endl;
			c = 0;
		}
	}
	cout << "Выполнение прервано... Произведен откат базы данных." << endl;
	return 0;
}

void DialogInterface() {
	//интерфейс
	cout << "Добавить новый элемент................1" << endl;
	cout << "Распечатать базу товаров..............2" << endl;
	cout << "Поиск товара по названию..............3" << endl;
	cout << "Фильтр по номеру секции...............4" << endl;
	cout << "Сортировать по уменьшению количества..5" << endl;
	cout << "Выход из программы с сохранением......6" << endl;
	cout << "......................................." << endl;
	cout << "Введите номер функции: " << endl;
};

void storage::setName(char* name_) { 
	delete[] name;
	name = new char[strlen(name_)+1];
	strcpy(name, name_); 
}

storage::storage() {
	//Конструктор по-умолчанию
	name = new char[40];
	strcpy(name, "None");
	price = 0;
	quant = 0;
	num = 0;
	expir.setDay(00);
	expir.setMonth(00);
	expir.setYear(00);
	count++;
}

storage::storage(storage& old) {
	expir = old.expir;
	setName(old.getName());
	setNum(old.getNum());
	setQuant(old.getQuant());
	setPrice(old.getPrice());
}

storage::storage(const char s[], double newprice, int newquant, int newnum) {
	name = new char[strlen(s) + 1];
	strcpy(name, s);
	price = newprice;
	quant = newquant;
	num = newnum;
	count++;
	expir.defineDate();
}

storage::storage(const char s[], double newprice, int newquant, int newnum, int day, int month, int year) {
	name = new char[strlen(s) + 1];
	strcpy(name, s);
	price = newprice;
	quant = newquant;
	num = newnum;
	expir.day = day;
	expir.month = month;
	expir.year = year;
	count++;
}

storage::~storage() {
	//cout << endl << "storage::Destructor!" << endl;
	delete[] name;
	count--;
}

void storage::define() {
	char buff[4000];
	cout << "Название :";
	cin >> buff;
	name = new char[strlen(buff) + 1];
	strcpy(name, buff);

	cout << "Цена: ";
	cin >> price;
	cout << "Количество: ";
	cin >> quant;
	cout << "Номер секции: ";
	cin >> num;
	expir.defineDate();
}

void storage::printList(storage* product, int n) {
	//вывод таблицы значений
	storage* R = product;
	cout << setw(20) << "Название товара" << setw(10) << "цена" << setw(15) << "количество" << setw(15) << "секция" << setw(10) << "Дата" <<endl;
	cout << "---------------------------------------------------------------------------" << endl;
	for (int i = 0; i < n; R++, i++) {
		cout << setw(20) << R->getName() << setw(10) << R->getPrice() << setw(15) << R->getQuant() << setw(15) << R->getNum() << setw(10) << R->expir.getDay() << ":" << R->expir.getMonth() << ":"<< R->expir.getYear() << endl;
	}
	cout << "---------------------------------------------------------------------------" << endl;
	cout << "Количество записей: " << n << endl;
	cout << "Введите номер функции: ";
}

void storage::findBread(storage* product, int n) {
	char buff[4000] = {};
	storage* R = product;

	cout << "Введите название товара: "; cin >> buff;
	cout << setw(20) << "Название товара" << setw(10) << "цена" << setw(15) << "количество" << setw(15) << "секция" << setw(10) << "Дата" << endl;
	//пробежка по массиву и вывод найденого хлеба
	for (R; R < product + n; R++) {
		//cout << R->getName();
		if (strcmp(buff, R->getName()) == 0) {
			cout << setw(20) << R->getName() << setw(10) << R->getPrice() << setw(15) << R->getQuant() << setw(15) << R->getNum() << setw(10) << R->expir.getDay() << ":" << R->expir.getMonth() << ":" << R->expir.getYear() << endl;
		}
	}
	cout << "Введите номер функции: " << endl;
}

void storage::filterNum(storage* product, int n) {
	//то же самое что и поиск но по секции
	int id, i = 0;
	storage* R = product;

	cout << "Введите желаемую секцию: "; cin >> id;
	cout << setw(20) << "Название товара" << setw(10) << "цена" << setw(15) << "количество" << setw(15) << "секция" << setw(10) << "Дата" << endl;
	for (R; R < product + n; R++) {
		if (id == R->getQuant()) {
			cout << setw(20) << R->getName() << setw(10) << R->getPrice() << setw(15) << R->getQuant() << setw(15) << R->getNum() << setw(10) << R->expir.getDay() << ":" << R->expir.getMonth() << ":" << R->expir.getYear() << endl;
			i = 1; // для проверки на наличие кокого либо товара
		}
	}
	if (i == 0)cout << "Товаров в данной секции нет" << endl;
	cout << "Введите номер функции: " << endl;
}

void sortBread(storage* product, int n) {
	storage temp;
	storage* R = product;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n - 1; j++) {
			if ((R + j)->getQuant() > (R + j + 1)->getQuant()) {
				temp = R[j];
				R[j] = R[j + 1];
				R[j + 1] = temp;
			}
		}
	}
}

void storage::saveList(storage* product, int n) {
	//сохранение хлеба
	storage* R = product;
	FILE* file;
	file = fopen("data.txt", "w");

	fprintf(file, "%d\n", n);
	for (R; R < product + n; R++) {
		fprintf(file, "%s\n", R->getName());
		fprintf(file, "%f %d %d\n", R->getPrice(), R->getQuant(), R->getNum());
		fprintf(file, "%d %d %d\n", R->expir.getDay(), R->expir.getMonth(), R->expir.getYear());
	}
	fclose(file);
};

int storage::loadList(storage* product) {
	//чтение хлеба
	storage* R = product;
	int n = 0, i = 0, quant, num, day, month, year;
	char buff[4000];
	float price;
	FILE* file;
	file = fopen("data.txt", "r");

	fscanf(file, "%d", &n);

	for (R; R < product + n; R++) {
		fscanf(file, "%s", buff);
		R->setName(buff);

		fscanf(file, "%f %d %d", &price, &quant, &num);
		R->setPrice(price);
		R->setQuant(quant);
		R->setNum(num);
		fscanf(file, "%d %d %d", &day, &month, &year);
		R->expir.setDay(day);
		R->expir.setMonth(month);
		R->expir.setYear(year);
	}
	fclose(file);
	return n;
}

date::date() {
	int day = 0;
	int month = 0;
	int year = 0;
}

date::date(int day, int month, int year) {
	setDay(day);
	setMonth(month);
	setYear(year);
}

void date::defineDate() {
	cout << "Дата в формате dd:mm:yy" << endl << "День: ";
	cin >> day;
	cout << "Месяц: ";
	cin >> month;
	cout << "Год: ";
	cin >> year;
}