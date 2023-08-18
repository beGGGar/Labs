#define _CRT_SECURE_NO_WARNINGS
using namespace std;

class date{
	int month, day, year;
	friend class storage;
public:
	date() { month = 0; day = 0; year = 0;}
	date(int day_, int month_, int year_);
	void defineDate();
	void setDay(int day_) { day = day_; }
	void setYear(int year_) { year = year_; }
	int  getDay() { return day; }
	int  getYear() { return year; }
	int  getMonth() { return month; }
	void setMonth(int month_) { month = month_; }
};

class storage : protected common{
	date expir;
	int num;
public:
	storage& operator=(storage& right);
	bool operator >(date& D);

	storage() { num = 0; }
	storage(storage& old);
	virtual int define(int n, int max);
	virtual void print(int n);

	void printList(int max);
	void findBread(int n);        //����� ����
	int filterNum(int max);        //������������� ���� �� �������
	void saveList(int max, char* path);         // ����������
	int  loadList(char* path);				//�������� �� ����
	void sortBread(int max);
	int findFresh(int max);
	
	int    getNum() { return num; }
	void setNum(int num_) { num = num_; }
};

void storage::sortBread(int max) {
	storage temp;
	for (int i = 0; i < max; i++) {
		for (int j = 0; j < max-1; j++) {
			if (this[j].getQuant() > this[j+1].getQuant()) {
				temp = this[j];
				this[j] = this[j + 1];
				this[j + 1] = temp;
			}
		}
	}
	for (int i = 0; i < max; i++) cout << this[i].getQuant() << endl;
	std::cout << "�����" << endl;
}

int storage::findFresh(int max) {
	storage* temp = new storage[max];
	date D{ 10, 10, 10 };
	//date D;
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
	//�� �� ����� ��� � ����� �� �� ������
	int id, count = 0;
	storage* temp = new storage[max];
	cout << "������� �������� ������: "; cin >> id;

	for (int j = 0; j < max; j++) {
		if (this[j].getNum() == id) {
			temp[count++] = this[j];
		}
	}
	if (count == 0) {
		cout << "������� � ������ ������ ���" << endl;
		delete[] temp;
		return max;
	}
	else {
		for (int j = 0; j < count; j++)this[j] = temp[j];
		delete[] temp;
		cout << "�����!" << endl;
		return count;
	}
}

storage::storage(storage& old) {
	expir = old.expir;
	setName(old.getName());
	setNum(old.getNum());
	setQuant(old.getQuant());
	setPrice(old.getPrice());
}

int storage::define(int n, int max) {
	if (n >= max) {
		cout << "����� ������ ���!" << endl;
		return 0;
	}
	char buff[4000];
	cout << "�������� :";
	cin >> buff;
	setName(buff);

	cout << "����: ";
	setPrice(intCheck());
	cout << "����������: ";
	setQuant(intCheck());
	cout << "����� ������: ";
	setNum(intCheck());
	expir.defineDate();
	return 0;
}

void storage::findBread(int max) {
	char buff[4000] = {};
	cout << "������� �������� ������: "; cin >> buff;

	int I = 0;
	for (int i = 0; i < max; i++) {
		if (strcmp(buff, this[i].getName()) == 0) {
			if (I == 0) {
				this[i].print(0);
				I = 1;
			}
			this[i].print(1);
		}
	}
	if (I == 0) cout << "����� ������� ���" << endl;
}

void storage::saveList(int max, char* path) {
	//���������� �����
	FILE* file;
	file = fopen(path, "w");

	fprintf(file, "%d\n", max);
	for (int i = 0; i<max; i++) {
		fprintf(file, "%s\n", this[i].getName());
		fprintf(file, "%f %d %d\n", this[i].getPrice(), this[i].getQuant(), this[i].getNum());
		fprintf(file, "%d %d %d\n", this[i].expir.getDay(), this[i].expir.getMonth(), this[i].expir.getYear());
	}
	fclose(file);
};

int storage::loadList(char* path) {
	//������ �����
	int n = 0, quant, num, day, month, year;
	char buff[4000];
	float price;
	FILE* file;
	file = fopen(path, "r");
	if (file == NULL) {
		cout << "����� ���, ������ ������." << endl;
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
	if (n == 0)cout << "������ ������." << endl;
	return n;
}

date::date(int day_, int month_, int year_) {
	day = day_; month = month_; year = year_; 
}

void date::defineDate() {
	cout << "���� � ������� dd:mm:yy" << endl << "����: ";
	day = dateCheck();
	cout << "�����: ";
	month = dateCheck();
	cout << "���: ";
	year = dateCheck();
}

void storage::print(int n) {
	if (n == 0) {
		cout << setw(20) << "�������� ������" << setw(10) << "����" << setw(15) << "����������" << setw(15) << "������" << setw(10) << "����" << endl;
	}
	if (n == 1) {
		cout << setw(20) << this->getName() << setw(10) << this->getPrice() << setw(15) << this->getQuant() << setw(15) << this->getNum() << setw(10) << this->expir.getDay() << ":" << this->expir.getMonth() << ":" << this->expir.getYear() << endl;
	}
}

void storage::printList(int max) {
	//����� ������� ��������
	this[0].print(0);
	cout << "---------------------------------------------------------------------------" << endl;
	for (int i = 0; i < max; i++) {
		this[i].print(1);
	}
	cout << "---------------------------------------------------------------------------" << endl;
	cout << "���������� �������: " << max << endl;
}