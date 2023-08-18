using namespace std;
int intCheck() {
	int rez, I, Fir = 1;
	char buff[4000];
	while (true) {
		I = 1;
		buff[0] = 0;
		cin.clear();
		cin >> buff;
		for (int i = 0; i < strlen(buff) && I == 1; i++) if (isalpha(buff[i]))I = 0;

		rez = atoi(buff);
		if (I == 1 && rez >= 0)return rez;
		else {
			if (Fir == 0)cout << "\r                                               \r";
			cout << "Повторите попытку   ";
		}
	}
}

int dateCheck() {
	int rez = 1000;
	while (true) {
		rez = intCheck();
		if (rez < 100 && rez >= 0)return rez;
		else cout << "Повторите попытку   ";
	}
}

void DialogInterface() {
	//интерфейс
	cout << "Добавить новый элемент................1" << endl;
	cout << "Распечатать базу товаров..............2" << endl;
	cout << "Поиск товара по названию..............3" << endl;
	cout << "Фильтр по номеру секции...............4" << endl;
	cout << "Сортировать по уменьшению количества..5" << endl;
	cout << "Поиск свежего товара..................6" << endl;
	cout << "Выход из программы с сохранением......7" << endl;
	cout << "Смена базы данных.....................8" << endl;
	cout << "storage  - 1 БД" << endl;
	cout << "storage1 - 2 БД" << endl;
	cout << "......................................." << endl;
};

int switchCheck() {
	int sw = 0;
	cout << "Номер БД: ";
	while (true) {
		sw = intCheck();
		if (sw == 1 || sw == 2)return sw;
		else cout << "Повторите попытку   ";
	}
}