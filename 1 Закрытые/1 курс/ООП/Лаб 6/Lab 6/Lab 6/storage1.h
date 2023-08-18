#define _CRT_SECURE_NO_WARNINGS
using namespace std;

class date1{
private:
	char* month;
	int day, year;
	friend class storage1;
public:
	date1();
	date1(int day_, char* month_, int year_) { setDay(day_); setMonth(month_); setYear(year_); }
	~date1() { delete[] month; }
	void defineDate();
	char*  getMonth();
	void setMonth(char* month_);
	void setDay(int day_) { day = day_; }
	void setYear(int year_) { year = year_; }
	int  getDay() { return day; }
	int  getYear() { return year; }
};

void date1::defineDate() {
	cout << "���� � ������� dd:�����:yy" << endl << "����: ";
	day = valueCheck(0, 31);
	cout << "�����: ";
	char buff[4000];
	cin >> buff;
	setMonth(buff);
	cout << "���: ";
	year = valueCheck(0, 99);
}

date1::date1() {
	char buff[] = "None";
	month = new char[strlen(buff) + 1];
	strcpy(month, buff);
	day = 0;
	year = 0;
}

char* date1::getMonth() {
	char* buff = new char[strlen(month) + 1];
	strcpy(buff, month);
	return buff;
}

void date1::setMonth(char* month_) {
	if (this->month != nullptr) delete[] this->month;
	month = new char[strlen(month_) + 1];
	strcpy(month, month_);
}

class storage1 : public common {
	date1 expir;
public:
	storage1() {}
	//storage1(storage1& old);
	storage1& operator =(storage1& right);
	bool operator >(date1& D);

	//int define(int n, int max);
	void print(int n);

	void printList(int max);
	int findBread(int n);        //����� ����
	void saveList(int max, char* path);         // ����������
	int  loadList(char* path);				//�������� �� ����
	void sortBread(int max);
	int findFresh(int max);

	friend istream& operator>> (istream& in, storage1& St);
	friend ostream& operator<< (ostream& out, storage1& St);
};

istream& operator>> (istream& in, storage1& St) {
	char name[4000], month[4000];
	double price;   // ����
	int quant, day, year;

	cout << "��������: ";
	in >> name;
	cout << "����: ";
	price = valueCheck(0, 99999999);
	cout << "����������: ";
	quant = valueCheck(0, 99999999);
	cout << "���� � ������� dd:mm:yy" << endl << "����: ";
	day = valueCheck(0, 31);
	cout << "�����: ";
	in >> month;
	cout << "���: ";
	year = valueCheck(0, 99);

	St.setName(name);
	St.setQuant(quant);
	St.setPrice(price);
	St.expir.setDay(day);
	St.expir.setMonth(month);
	St.expir.setYear(year);
	return in;
}

ostream& operator<< (ostream& out, storage1& St) {
	out << setw(20) << St.getName() << setw(10) << St.getPrice() << setw(15) << St.getQuant() << setw(10) << St.expir.getDay() << ":" << St.expir.getMonth() << ":" << St.expir.getYear() << endl;
	return out;
}

void storage1::sortBread(int max) {
	storage1 temp;
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
	cout << "�����!" << endl;
}

int storage1::findFresh(int max) {
	storage1* temp = new storage1[max];
	char month_[] = "10";
	date1 D( 10, month_, 10 );
	//date1 D;
	//D.defineDate();
	int count = 0;

	for (int j = 0; j < max; j++) {
		if (this[j] > D) {
			temp[count++] = this[j];
		}
	}

	if (count == 0) {
		cout << "������ ��������� ���" << endl;
		return max;
	}

	for (int j = 0; j < count; j++)this[j] = temp[j];
	cout << "�����" << endl;
	return count;
}

bool storage1::operator>(date1& D) {
	if (this->expir.getYear() > D.getYear())return true;
	//if (this->expir.getYear() == D.getYear() && this->expir.getMonth() > D.getMonth())return true;
	if (this->expir.getYear() == D.getYear() && this->expir.getDay() > D.getDay())return true;
	return false;
}

storage1& storage1::operator=(storage1& right) {
	expir.setDay(right.expir.getDay());
	expir.setMonth(right.expir.getMonth());
	expir.setYear(right.expir.getYear());
	setName(right.getName());
	setQuant(right.getQuant());
	setPrice(right.getPrice());
	return *this;
}

void storage1::print(int n) {
	if (n == 0) {
		cout << setw(20) << "�������� ������" << setw(10) << "����" << setw(15) << "����������" << setw(10) << "����" << endl;
	}
	if (n == 1) {
		cout << setw(20) << this->getName() << setw(10) << this->getPrice() << setw(15) << this->getQuant() << setw(10) << this->expir.getDay() << ":" << this->expir.getMonth() << ":" << this->expir.getYear() << endl;
	}
}

void storage1::printList(int max) {
	//����� ������� ��������
	this[0].print(0);
	cout << "---------------------------------------------------------------------------" << endl;
	for (int i = 0; i < max; i++) {
		//this[i].print(1);
		cout << this[i];
	}
	cout << "---------------------------------------------------------------------------" << endl;
	cout << "���������� �������: " << max << endl;
}

int storage1::findBread(int max) {
	char buff[4000] = {};
	cout << "������� �������� ������: "; cin >> buff;

	int I = 0;
	for (int i = 0; i < max; i++) {
		if (strcmp(buff, this[i].getName()) == 0) {
			this[i].print(0);
			I = 1;
			cout << this[i];
			return i;
		}
	}
	if (I == 0) {
		cout << "����� ������� ���" << endl;
		return -1;
	}
}

void storage1::saveList(int max, char* path) {
	//���������� �����
	FILE* file;
	try
	{
		file = fopen(path, "w");
	}
	catch (...)
	{
		cout << "������ �������� �����" << endl;
		fclose(file);
	}

	fprintf(file, "%d\n", max);
	for (int i = 0; i < max; i++) {
		fprintf(file, "%s\n", this[i].getName());
		fprintf(file, "%f %d\n", this[i].getPrice(), this[i].getQuant());
		fprintf(file, "%d %s %d\n", this[i].expir.getDay(), this[i].expir.getMonth(), this[i].expir.getYear());
	}
	fclose(file);
};

int storage1::loadList(char* path) {
	//������ �����
	int n = 0, quant, day, year;
	char name[4000], month[4000];
	float price;
	FILE* file;
	try
	{
		file = fopen(path, "r");
		if (file == NULL)throw 1;
	}
	catch (...)
	{
		cout << "����� ���, ������ ������." << endl;
		return 0;
	}

	fscanf(file, "%d", &n);

	for (int j = 0; j < n; j++) {

		fscanf(file, "%s", name);
		fscanf(file, "%f %d", &price, &quant);
		fscanf(file, "%d %s %d", &day, month, &year);

		this[j].setName(name);
		this[j].setPrice(price);
		this[j].setQuant(quant);
		this[j].expir.setDay(day);
		this[j].expir.setMonth(month);
		this[j].expir.setYear(year);
	}
	fclose(file);
	if (n == 0)cout << "������ ������." << endl;
	return n;
}