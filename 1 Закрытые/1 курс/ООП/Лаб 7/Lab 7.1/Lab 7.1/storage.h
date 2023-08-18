#include "iostream"
#define max_bread 100
using namespace std;

class date {
	int day, month, year;
	friend class storage;
public:
	date();
	date(int day_, int month_, int year_);
	void defineDate();
	int  getDay() { return day; }
	int  getMonth() { return month; }
	int  getYear() { return year; }
	void setDay(int day_) { day = day_; }
	void setMonth(int month_) { month = month_; }
	void setYear(int year_) { year = year_; }
};

class storage {
	date expir;
	char* name;	   //Название товара
	double price;   // цена
	int quant, num;	    // количество, номер секции
	static int count;        // счетчик существующих объектов класса
public:
	friend void sortBread(storage* BB, int n);		//сортировка продуктов по уменьшению количества 
	friend int findFresh(storage* BB, int n);
	storage& operator=(storage& right);
	bool operator >(date& D);

	storage();
	storage(const storage&);
	~storage();

	void findBread(int max);        //найти хлеб
	int filterNum(storage* product, int n);        //отфильтровать хлеб по секциям
	friend void saveList(storage* product, int n, char* path);         // сохранение
	//friend int  loadList(storage* product, char* path);				//загрузка из базы

	char* getName() { return name; }
	double getPrice() { return price; }
	int    getNum() { return num; }
	int	   getQuant() { return quant; }
	int    getCount() { return count; }

	void setName(char* name_);
	void setPrice(double price_) { price = price_; }
	void setNum(int num_) { num = num_; }
	void setQuant(int quant_) { quant = quant_; }

	friend ostream& operator<< (ostream& out, storage& St);
	friend istream& operator>> (istream& in, storage& St);
	void setDay(int day) { expir.day = day; }
	void setMonth(int month) { expir.month = month; }
	void setYear(int year) { expir.year = year; }
};

int storage::count = 0;

double intCheck();
double valueCheck(double min, double max);
void DialogInterface();
void sortBread(storage* product, int n);
int findFresh(storage* product, int n);
void print();

ostream& operator<< (ostream& out, storage& St) {
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
	quant = (int)valueCheck(0, 99999999);
	cout << "Секция: ";
	num = (int)valueCheck(0, 99999999);
	cout << "Дата в формате dd:mm:yy" << endl << "День: ";
	day = (int)valueCheck(0, 31);
	cout << "Месяц: ";
	month = (int)valueCheck(0, 12);
	cout << "Год: ";
	year = (int)valueCheck(0, 99);
	St.setName(name);
	St.setNum(num);
	St.setQuant(quant);
	St.setPrice(price);
	St.expir.setDay(day);
	St.expir.setMonth(month);
	St.expir.setYear(year);
	return in;
}

date::date() {
	setDay(0);
	setMonth(0);
	setYear(0);
}

date::date(int day, int month, int year) {
	setDay(day);
	setMonth(month);
	setYear(year);
}

void date::defineDate() {
	cout << "Дата в формате dd:mm:yy" << endl << "День: ";
	day = (int)valueCheck(1, 31);
	cout << "Месяц: ";
	month = (int)valueCheck(1, 12);
	cout << "Год: ";
	year = (int)valueCheck(0, 99);
}

void storage::setName(char* name_) {
	//if (name != nullptr) delete[] this->name;
	name = new char[strlen(name_) + 1];
	strcpy(name, name_);
}

storage::storage() {
	//Конструктор по-умолчанию
	char buff[] = "None";
	//setName(buff);
	name = new char[strlen(buff) + 1];
	strcpy(name, buff);
	price = 0;
	quant = 0;
	num = 0;
	expir.day = 0;
	expir.month = 0;
	expir.year = 0;
	count++;
}

storage::storage(const storage& old) {
	this->expir = old.expir;
	char* buff = old.name;
	setName(buff);
	this->num = old.num;
	this->quant = old.quant;
	this->price = old.price;
}

storage::~storage() {
	delete[] name;
	count--;
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

int storage::filterNum(storage* product, int n) {
	//то же самое что и поиск но по секции
	int id, count = 0;
	storage* R = product;
	storage* temp = new storage[n];
	cout << "Введите желаемую секцию: "; cin >> id;

	for (int j = 0; j < n; j++) {
		if (R[j].getNum() == id) {
			temp[count++] = R[j];
		}
	}
	if (count == 0) {
		cout << "Товаров в данной секции нет" << endl;
		delete[] temp;
		return n;
	}
	else {
		for (int j = 0; j < count; j++)R[j] = temp[j];
		//cout << count;
		delete[] temp;
		return count;
	}
}

void storage::findBread(int max) {
	char buff[4000] = {};
	cout << "Введите название товара: "; cin >> buff;

	int I = 0;
	for (int i = 0; i < max; i++) {
		if (strcmp(buff, this[i].getName()) == 0) {
			if (I == 0) {
				print();
				I = 1;
			}
			cout << this[i];
		}
	}
	if (I == 0) cout << "Таких товаров нет" << endl;
}

void saveList(storage* product, int n, char* path) {
	//сохранение хлеба
	storage* R = product;
	FILE* file;
	file = fopen(path, "w");

	fprintf(file, "%d\n", n);
	for (R; R < product + n; R++) {
		fprintf(file, "%s\n", R->getName());
		fprintf(file, "%f %d %d\n", R->getPrice(), R->getQuant(), R->getNum());
		fprintf(file, "%d %d %d\n", R->expir.getDay(), R->expir.getMonth(), R->expir.getYear());
	}
	fclose(file);
};

int loadList(vector<storage>& St, char* path) {
	//чтение хлебa
	int  n = 0, i = 0, quant, num, day, month, year;
	char buff[4000];
	float price;
	storage R, B;

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

	for (i; i < n; i++) {
		fscanf(file, "%s", buff);
		fscanf(file, "%f %d %d", &price, &quant, &num);
		fscanf(file, "%d %d %d", &day, &month, &year);
		R.setName(buff);
		R.setPrice(price);
		R.setQuant(quant);
		R.setNum(num);
		R.setDay(day);
		R.setMonth(month);
		R.setYear(year);
		St.push_back(R);
	}

	fclose(file);
	//if (n == 0)cout << "Первый запуск." << endl;
	return 1;
}

void print() {cout << setw(20) << "Название товара" << setw(10) << "цена" << setw(15) << "количество" << setw(15) << "секция" << setw(10) << "Дата" << endl;}


int findFresh(storage* product, int n) {
	storage* R = product;
	storage* temp = new storage[max_bread];
	date D(10, 10, 10);
	//date D;
	//D.defineDate();
	int count = 0;

	for (int j = 0; j < n; j++) {
		if (R[j] > D) {// вызвать в операторном виде, а не в функциональном
			temp[count++] = R[j];
		}
	}

	if (count == 0) {
		cout << "Свежих продуктов нет" << endl;
		return n;
	}

	for (int j = 0; j < count; j++)R[j] = temp[j];
	cout << "Успех" << endl;
	return count;
}

void DialogInterface() {
	//интерфейс
	cout << "(1) Добавить элемент в начало" << endl;
	cout << "(2) Добавить элемент в конец" << endl;
	cout << "(3) Удаление элемента" << endl;
	cout << "(4) Распечатать базу товаров" << endl;
	cout << "(5) Поиск товара по названию" << endl;
	cout << "(6) Фильтр по номеру секции" << endl;
	cout << "(7) Сортировать по уменьшению количества" << endl;
	cout << "(8) Поиск свежего товара" << endl;
	cout << "(9) Выход из программы с сохранением" << endl;
	cout << "......................................." << endl;
};

void sortBread(storage* product, int n) {
	//сортировка по количеству
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
	cout << "успех" << endl;
}



double intCheck() {
	char buff[4000];
	double rez;
	while (true) {
		try
		{
			cin >> buff;
			for (int i = 0; i < strlen(buff); i++) if (isalpha(buff[i]))throw 1;
			rez = atof(buff);
			return rez;
		}
		catch (int n)
		{
			if (n == 1)cout << "Только численные значения. Повторите попытку..." << endl;

		}
	}
}

//dateCheck
double valueCheck(double min, double max) {
	double rez;
	while (true) {
		try
		{
			rez = intCheck();
			if (rez > max)throw 1;
			if (rez < min)throw 2;
			return rez;
		}
		catch (int n)
		{
			if (n == 1)cout << "Значение слишком велико. Повторите попытку..." << endl;
			if (n == 2)cout << "Значение слишком мало. Повторите попытку..." << endl;
		}
	}
}