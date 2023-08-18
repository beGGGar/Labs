using namespace std;

double intcheck() {
	char buff[4000];
	double rez;
	while (true) {
		cin >> buff;
		for (int i = 0; i < strlen(buff); i++) if (isalpha(buff[i]))throw 1;
		rez = atof(buff);
		return rez;
	}
	return 0;
}

double intCheck() {
	try
	{
		return intcheck();
	}
	catch (int n)
	{
		if (n == 1)cout << "Только численные значения. Повторите попытку..." << endl;
	}
	return 0;
}

//dateCheck

double valuecheck(int min, int max) {
	double rez;
	while (true) {
		rez = intCheck();
		if (rez > max)throw 2;
		if (rez < min)throw 3;
		return rez;
	}
}

double valueCheck(int min, int max) {
	try
	{
		return valuecheck(min, max);
	}
	catch (int n)
	{
		if (n == 2)cout << "Значение слишком велико. Повторите попытку..." << endl;
		if (n == 3)cout << "Значение слишком мало. Повторите попытку..." << endl;
	}
	return 0;
}

void DialogInterface() {
	//интерфейс
	cout << "(1) Добавить новый элемент" << endl;
	cout << "(2) Распечатать базу товаров" << endl;
	cout << "(3) Поиск товара по названию" << endl;
	cout << "(4) Фильтр по номеру секции" << endl;
	cout << "(5) Сортировать по уменьшению количества" << endl;
	cout << "(6) Поиск свежего товара" << endl;
	cout << "(7) Приход товара на склад" << endl;
	cout << "(8) Расход товара" << endl;
	cout << "(9) Выход из программы с сохранением" << endl;
	cout << "(10) Смена базы данных" << endl;
	cout << "storage  - 1 БД" << endl;
	cout << "storage1 - 2 БД" << endl;
	cout << "......................................." << endl;
};

int switchcheck() {
	double sw;
	cout << "Номер БД: ";
	while (true) {
		sw = intCheck();
		if (sw != (int)sw)throw 4;
		if (sw != 1.0 && sw != 2.0)throw 5;
		return sw;
	}
	return 0;
}

int switchCheck() {
	try
	{
		return switchcheck();
	}
	catch (int n)
	{
		if (n == 4)cout << "Только целочисленные значения. Повторите попытку..." << endl;
		if (n == 5)cout << "Неподходящее значение. Повторите попытку..." << endl;
	}
	return 0;
}


