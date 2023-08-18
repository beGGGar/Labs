#define _CRT_SECURE_NO_WARNINGS
#include "Lab 3.h"

int main() {
	setlocale(LC_ALL, "Rus");
	SetConsoleCP(1251); // Ввод с консоли в кодировке
	SetConsoleOutputCP(1251); // Вывод на консоль в кодировке

	storage* BB = new storage[0];
	char path[] = "data.txt";
	loadList(BB, path);
	int c;

	DialogInterface();
	cout << "Введите номер функции: ";
	while (true) { // цикл с ключами
		cout << BB->getCount();
		c = intCheck();
		switch (c) {
		case 1: // добавление товарa
			define(BB);
			//BB[0].setName("sdf");
			break;
		case 2:
			printList(BB);
			break;
		case 3:
			BB[-1].findBread();
			break;
		case 4:
			BB[-1].filterNum(BB);
			break;
		case 5:
			sortBread(BB);
			break;
		case 6:
			findFresh(BB);
			break;
		case 7:
			BB[-1].saveList(BB, path);
			delete[] BB;
			return 0;
		default:
			cout << "Неверный запрос, повторите попытку..." << endl;
		}
		cout << "Введите номер функции: ";
	}
	cout << "Выполнение прервано... Произведен откат базы данных." << endl;
	return 0;
}

char* storage::getName() const {
	char buff[4000];
	cout << this->name;
	strcpy(buff, this->getName());
	cout << buff;
	return buff;
}

bool storage::operator>(date& D) {
	if (this->expir.getYear() > D.getYear())return true;
	if (this->expir.getYear() == D.getYear() && this->expir.getMonth() > D.getMonth())return true;
	if (this->expir.getYear() == D.getYear() && this->expir.getMonth() == D.getMonth() && this->expir.getDay() > D.getDay())return true;
	return false;
}

storage& storage::operator=(storage& right) {
	if (&right != this) {
		this->expir = right.expir;
		this->setNum(right.num);
		this->setQuant(right.quant);
		this->setPrice(right.price);
		delete[] name;
		name = new char[strlen(right.name) + 1];
		strcpy(name, right.name);
	}
	return *this;
}

void findFresh(storage* product) {
	storage* R = product;
	int number = R->getCount();
	storage* temp = new storage[number];
	date D(10, 10, 10);
	//date D;
	//D.defineDate();
	int count = 0;

	for (int j = 0; j < number; j++) {
		if (R[j] > D) {
			temp[count++] = R[j];
		}
	}

	if (count == 0) {
		cout << "Свежих продуктов нет" << endl;
		return;
	}
	delete[] R;
	R = new storage[count];
	for (int j = 0; j < count; j++)R[j] = temp[j];
	cout << "Успех" << endl;
	return;
}

void storage::filterNum(storage* product) {
	//то же самое что и поиск но по секции
	int id, count = 0;
	storage* R = product;
	int n = R->getCount();
	storage* temp = new storage[n];
	cout << "Введите желаемую секцию: "; 
	id = intCheck();

	for (int j = 0; j < n; j++) {
		if (R[j].getNum() == id) {
			temp[count++] = R[j];
		}
	}
	if (count == 0) {
		cout << "Товаров в данной секции нет" << endl;
		delete[] temp;
		return;
	}
	else {
		delete[] R;
		R = new storage[count];
		for (int j = 0; j < count; j++)R[j] = temp[j];
		delete[] temp;
		return;
	}
}

void storage::setName(char* const name_) {
	if (this->name!= nullptr) {
		delete[] this->name;
	}
	this->name = new char[strlen(name_) + 1];
	strcpy(this->name, name_);	
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

storage::storage(storage& old) {
	expir = old.expir;
	char* buff = old.getName();
	setName(buff);
	num = old.getNum();
	quant = old.getQuant();
	price = old.getPrice();
}

storage::~storage() {
	delete[] name;
	count--;
}

void define(storage* product) {	
	storage* R = product;
	int num = R->getCount();
	if(num != 0){
		storage* temp = new storage[num+1];
		for (int i = 0; i < num; i++) {
			temp[i] = R[i];
		}
		delete[] R;
		R = temp;
	}
	else {
		R = new storage[1];
	}
	char buff[4000];
	cout << "Название :";
	cin >> buff;
	R[num].setName(buff);
	cout << "Цена: ";
	R[num].setPrice(intCheck());
	cout << "Количество: ";
	R[num].setQuant(intCheck());
	cout << "Номер секции: ";
	R[num].setNum(intCheck());
	R[num].expir.defineDate();
}

void printList(storage* product) {
	//вывод таблицы значений
	storage* R = product;
	int n = R->getCount();
	if (n == 0) {
		cout << "Элементов пока нет." << endl;
		return;
	}
	print(R, 0);
	cout << "---------------------------------------------------------------------------" << endl;
	for (int i = 0; i < n; i++) {
		print(&R[i], 1);
	}
	cout << "---------------------------------------------------------------------------" << endl;
	cout << "Количество записей: " << n << endl;
}

void print(storage* R, int n) {
	if (n == 0) {
		cout << setw(20) << "Название товара" << setw(10) << "цена" << setw(15) << "количество" << setw(15) << "секция" << setw(10) << "Дата" << endl;
	}
	if (n == 1) {
		cout << setw(20) << R->getName() << setw(10) << R->getPrice() << setw(15) << R->getQuant() << setw(15) << R->getNum() << setw(10) << R->expir.getDay() << ":" << R->expir.getMonth() << ":" << R->expir.getYear() << endl;
	}
}

void storage::findBread() {
	char buff[4000] = {};
	cout << "Введите название товара: "; cin >> buff;
	int max = this->getCount();
	int I = 0;
	for (int i = 0; i < max; i++) {
		if (strcmp(buff, this[i].getName()) == 0) {
			if (I == 0) {
				print(&this[i], 0);
				I = 1;
			}
			print(&this[i], 1);
		}
	}
	if (I == 0) cout << "Таких товаров нет" << endl;
}

void sortBread(storage* product) {
	//сортировка по количеству
	storage temp;
	storage* R = product;
	int n = R->getCount();

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

void storage::saveList(storage* product, char* path) {
	//сохранение хлеба
	storage* R = product;
	int n = R->getCount();
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

void loadList(storage* product, char* path) {
	//чтение хлеба
	storage* R = product;
	int n = 0, i = 0, quant, num, day, month, year;
	char buff[4000];
	float price;
	FILE* file;
	file = fopen(path, "r");
	if (file == NULL) {
		cout << "Файла нет, первый запуск." << endl;
		return ;
	}

	(void)fscanf(file, "%d", &n);
	R = new storage[n];
	for (int j = 0; j < n; j++) {
		(void)fscanf(file, "%s", buff);
		R[j].setName(buff);

		(void)fscanf(file, "%f %d %d", &price, &quant, &num);
		R[j].setPrice(price);
		R[j].setQuant(quant);
		R[j].setNum(num);
		(void)fscanf(file, "%d %d %d", &day, &month, &year);
		R[j].expir.setDay(day);
		R[j].expir.setMonth(month);
		R[j].expir.setYear(year);
	}
	if (n == 0)cout << "Первый запуск." << endl;
	fclose(file);
	return;
}

int intCheck() {
	int I, Fir = 1;
	char buff[4000];
	while (true) {
		I = 1;
		buff[0] = 0;
		cin.clear();
		cin >> buff;
		for (int i = 0; i < strlen(buff); i++) {
			if (isalpha(buff[i])) {
				I = 0;
				cout << "Введите целочисленные значения!   ";
				break;
			}
		}
		if (I == 0) { continue; }
		
		else {
			//cout << atoi(buff);
			return atoi(buff); }
	}
}

int dateCheck(int min, int max) {
	int rez;
	while (true) {
		rez = intCheck();
		if (rez <= max && rez >= min)return rez;
		else cout << "Повторите попытку   " << endl;
	}
}