#define _CRT_SECURE_NO_WARNINGS
#include "main.h"

int main() {
	setlocale(LC_ALL, "Rus");
	SetConsoleCP(1251); // ���� � ������� � ���������
	SetConsoleOutputCP(1251); // ����� �� ������� � ���������

	char path[] = "data.txt";
	list<storage> BB;
	loadList(path, BB);

	int c;
	DialogInterface();
	cout << "������� ����� �������: ";
	while (true) { // ���� � �������
		c = (int)intCheck();
		switch (c) {
		case 1: // ���������� �����a
			addToStart(BB);
			break;
		case 2:
			addToEnd(BB);
			break;
		case 3:
			delBred(BB);
			break;
		case 4:
			printList(BB);
			break;
		case 5:
			BB.begin()->findBread(BB);
			break;
		case 6:
			BB.begin()->filterNum(BB);
			break;
		case 7:
			sortBread(BB);
			break;
		case 8:
			findFresh(BB);
			break;
		case 9:
			saveList(BB, path);
			return 0;
		default:
			cout << "�������� ������, ��������� �������..." << endl;
		}
		cout << "������� ����� �������: ";
	}
	cout << "���������� ��������... ���������� ����� ���� ������." << endl;
	return 0;
}

/////////////////////// DATE ///////////////////
int  date::getDay() { return day; }
int  date::getMonth() { return month; }
int  date::getYear() { return year; }
void date::setDay(int day_) { day = day_; }
void date::setMonth(int month_) { month = month_; }
void date::setYear(int year_) { year = year_; }

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
	cout << "���� � ������� dd:mm:yy" << endl << "����: ";
	day = (int)valueCheck(1, 31);
	cout << "�����: ";
	month = (int)valueCheck(1, 12);
	cout << "���: ";
	year = (int)valueCheck(0, 4000);
}


////////////////////////// STORAGE ///////////////////////

storage::storage() {
	//����������� ��-���������
	name = "NotStated";
	price = 0;
	quant = 0;
	num = 0;
	expir.day = 0;
	expir.month = 0;
	expir.year = 0;
	count++;
}

storage::storage(string name, double price, int quant, int num, int day, int month, int year) {
	this->name = name;
	this->price = price;
	this->quant = quant;
	this->num = num;
	this->expir.day = day;
	this->expir.month = month;
	this->expir.year = year;
	count++;
}

storage::storage(const storage& old) {
	expir = old.expir;
	name = old.name;
	num = old.num;
	quant = old.quant;
	price = old.price;
}

storage::~storage() { count--; }

string storage::getName() { return name; }
double storage::getPrice() { return price; }
int    storage::getNum() { return num; }
int	   storage::getQuant() { return quant; }
int    storage::getCount() { return count; }
int    storage::getExpirDay() { return expir.getDay(); }
int    storage::getExpirMonth() { return expir.getMonth(); }
int    storage::getExpirYear() { return expir.getYear(); }

void storage::setPrice(double price_) { price = price_; }
void storage::setNum(int num_) { num = num_; }
void storage::setQuant(int quant_) { quant = quant_; }
void storage::setName(string name_) {name = name_;}

//���������
ostream& operator<< (ostream& out, storage& St) {
	out << setw(20) << St.getName() << setw(10) << St.getPrice() << setw(15) << St.getQuant() << setw(15) << St.getNum() << setw(10) << St.expir.getDay() << ":" << St.expir.getMonth() << ":" << St.expir.getYear() << endl;
	return out;
}

ostream& operator<< (ostream& out, list<storage>& St) {
	list<storage>::iterator it = St.begin();
	out << setw(20) << it->getName() << setw(10) << it->getPrice() << setw(15) << it->getQuant() << setw(15) << it->getNum() << setw(10) << it->expir.getDay() << ":" << it->expir.getMonth() << ":" << it->expir.getYear() << endl;
	return out;
}

ostream& operator<< (ostream& out, list<storage>::iterator it) {
	out << setw(20) << it->getName() << setw(10) << it->getPrice() << setw(15) << it->getQuant() << setw(15) << it->getNum() << setw(10) << it->getExpirDay() << ":" << it->getExpirMonth() << ":" << it->getExpirYear() << endl;
	return out;
}

istream& operator>> (istream& in, storage& St) {
	char name[4000];
	double price;   // ����
	int quant, day, month, year, num;
	cout << "��������: ";
	cin >> name;
	cout << "����: ";
	price = valueCheck(0, 99999999);
	cout << "����������: ";
	quant = (int)valueCheck(0, 99999999);
	cout << "������: ";
	num = (int)valueCheck(0, 99999999);
	cout << "���� � ������� dd:mm:yy" << endl << "����: ";
	day = (int)valueCheck(0, 31);
	cout << "�����: ";
	month = (int)valueCheck(0, 12);
	cout << "���: ";
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

bool storage::operator>(date& D) {
	if (this->expir.getYear() > D.getYear())return true;
	if (this->expir.getYear() == D.getYear() && this->expir.getMonth() > D.getMonth())return true;
	if (this->expir.getYear() == D.getYear() && this->expir.getMonth() == D.getMonth() && this->expir.getDay() > D.getDay())return true;
	return false;
}

storage& storage::operator=(const storage& right) {
	expir = right.expir;
	name = right.name;
	num = right.num;
	quant = right.quant;
	price = right.price;
	return *this;
}


//������
//�������� � �����
void addToEnd(list<storage>& ST) {
	storage st;
	cin >> st;
	ST.push_back(st);
}

//�������� � ������
void addToStart(list<storage>& ST) {
	storage st;
	cin >> st;
	ST.push_front(st);
}

//�������� �� ������
void delBred(list<storage>& ST) {
	if (ST.empty()) {
		cout << "��������� ���� ���. \n";
		return;
	}
	int n;
	cout << "������� ����� ����������: ";
	n = (int)valueCheck(1, (double)ST.size());
	list<storage>::iterator it = ST.begin();
	for (int i = 0; i < n-1; i++)it++;
	ST.erase(it);
}

//������ �� ������ ���������
void storage::filterNum(list<storage>& ST) {
	//�� �� ����� ��� � ����� �� �� ������
	int id;
	list<storage> new_list;
	
	cout << "������� �������� ������: "; 
	id = (int)intCheck();

	for (list<storage>::iterator it = ST.begin(); it != ST.end(); it++) {
		if (it->getNum() == id) {
			new_list.push_back(*it);
		}
	}
	if (new_list.empty()) {
		cout << "������� � ������ ������ ���" << endl;
		return;
	}
	else {
		ST.clear();
		ST = new_list;
	}
}


void printList(const list<storage>& ST) {
	//����� ������� ��������
	list<storage> R = ST;
	if (ST.size() == 0) {
		cout << "��������� ���� ���. \n";
		return;
	}
	printTitle();
	cout << "---------------------------------------------------------------------------" << endl;
	/*list<storage>::iterator it;
	for (it = R.begin(); it != R.end(); ++it) {
		cout << it;
	}*/
	int number = 1;
	for (storage & i : R) {
		cout << "(" << number++ <<")" << i;
	}
	cout << "---------------------------------------------------------------------------" << endl;
	cout << "���������� �������: " << R.size() << endl;
}

//����� �� ��������
void storage::findBread(list<storage>& ST) {
	if (ST.empty()) {
		cout << "������� ���� ���." << endl;
		return;
	}
	string buff;
	cout << "������� �������� ������: "; cin >> buff;
	list<storage>::iterator it = ST.begin();
	int I = 0;
	for (it; it != ST.end(); it++) {
		if (buff == it->getName()) {
			if (I == 0) {
				printTitle();
				I = 1;
			}
			cout << it;
		}
	}
	if (I == 0) cout << "����� ������� ���" << endl;
}

//����������
void saveList(list<storage>& ST, char* path) {
	//���������� �����
	FILE* file;
	file = fopen(path, "w");
	if (ST.empty()) {
		fclose(file);
		return;
	}

	list<storage>::iterator it = ST.begin();

	fprintf(file, "%d\n", ST.size());
	for (it; it != ST.end(); it++) {
		fprintf(file, "%s\n", it->getName().c_str());
		fprintf(file, "%f %d %d\n", it->getPrice(), it->getQuant(), it->getNum());
		fprintf(file, "%d %d %d\n", it->getExpirDay(), it->getExpirMonth(), it->getExpirYear());
	}
	fclose(file);
};

//�������� �� �����
void loadList(char* path, list<storage>&ST) {
	//������ �����
	FILE* file;
	file = fopen(path, "r");

	if (file == NULL) {
		cout << "����� ���, ������ ������." << endl;
		return;
	}
	
	int n = 0, i = 0, quant, num, day, month, year;
	char name[4000];
	float price;

	(void)fscanf(file, "%d", &n);
	for (int j = 0; j < n; j++) {
		
		(void)fscanf(file, "%s", name);
		(void)fscanf(file, "%f %d %d", &price, &quant, &num);
		(void)fscanf(file, "%d %d %d", &day, &month, &year);
		ST.push_back(storage(name, price, quant, num, day, month, year));
	}
	fclose(file);
	if (n == 0)cout << "������ ������." << endl;
	return;
}

//����� �� ����
void findFresh(list<storage>& ST) {
	if (ST.empty()) {
		cout << "������� ��� ���.";
		return;
	}

	list<storage> newList;
	list<storage>::iterator it = ST.begin();
	date D(10, 10, 10);
	//date D;
	//D.defineDate();

	for (it; it != ST.end(); it++) {
		if (*it > D) {
			newList.push_back(*it);
		}
	}

	if (newList.empty()) {
		cout << "������ ��������� ���" << endl;
		return;
	}

	ST.clear();
	ST = newList;
	cout << "�����" << endl;
}

//���������� �� ���������� ����������
void sortBread(list<storage>& ST) {
	list<storage>::iterator it1,it2,it3;
	storage st1 = storage();
	//storage st2 = storage();
	it1 = ST.begin();
	it2 = ST.begin();
	it3 = ST.begin();	
	/*for (it1; it1 != ST.end(); it1++) {
		for (it2 = it1; it2 != --ST.end(); it2++) {
			it3 = ++it2;
			it2--;
			if (it2->getQuant() > it3->getQuant()) {
				st1 = *it2;
				*it2 = *it3;
				*it3 = st1;
			}
		}
	}*/
	storage buffst = storage();
	list<storage>::iterator it = ST.begin();
	map<int, list<storage>> m;
	for (it; it != ST.end(); it++) {
		m[it->getQuant()].push_back(*it);
	}
	ST.clear();
	for (auto it = m.begin(); it != m.end(); it++) {
		while (!it->second.empty()) {
			buffst = (it->second.back());
			//cout << (it->second.back());
			it->second.pop_back();
			ST.push_front(buffst);
		}
	}
	cout << "�����" << endl;
}

/////////////////////////////// OTHER //////////////////////////

void printTitle() {
	cout << setw(20) << "�������� ������" << setw(10) << "����" << setw(15)
		<< "����������" << setw(15) << "������" << setw(10) << "����" << endl;
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
			if (n == 1)cout << "������ ��������� ��������. ��������� �������..." << endl;

		}
	}
}

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
			if (n == 1)cout << "�������� ������� ������. ��������� �������..." << endl;
			if (n == 2)cout << "�������� ������� ����. ��������� �������..." << endl;
		}
	}
}

void DialogInterface() {
	//���������
	cout << "(1) �������� ������� � ������" << endl;
	cout << "(2) �������� ������� � �����" << endl;
	cout << "(3) �������� ��������" << endl;
	cout << "(4) ����������� ���� �������" << endl;
	cout << "(5) ����� ������ �� ��������" << endl;
	cout << "(6) ������ �� ������ ������" << endl;
	cout << "(7) ����������� �� ���������� ����������" << endl;
	cout << "(8) ����� ������� ������" << endl;
	cout << "(9) ����� �� ��������� � �����������" << endl;
	cout << "......................................." << endl;
};