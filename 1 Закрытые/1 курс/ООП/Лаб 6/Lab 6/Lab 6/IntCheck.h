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
		if (n == 1)cout << "������ ��������� ��������. ��������� �������..." << endl;
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
		if (n == 2)cout << "�������� ������� ������. ��������� �������..." << endl;
		if (n == 3)cout << "�������� ������� ����. ��������� �������..." << endl;
	}
	return 0;
}

void DialogInterface() {
	//���������
	cout << "(1) �������� ����� �������" << endl;
	cout << "(2) ����������� ���� �������" << endl;
	cout << "(3) ����� ������ �� ��������" << endl;
	cout << "(4) ������ �� ������ ������" << endl;
	cout << "(5) ����������� �� ���������� ����������" << endl;
	cout << "(6) ����� ������� ������" << endl;
	cout << "(7) ������ ������ �� �����" << endl;
	cout << "(8) ������ ������" << endl;
	cout << "(9) ����� �� ��������� � �����������" << endl;
	cout << "(10) ����� ���� ������" << endl;
	cout << "storage  - 1 ��" << endl;
	cout << "storage1 - 2 ��" << endl;
	cout << "......................................." << endl;
};

int switchcheck() {
	double sw;
	cout << "����� ��: ";
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
		if (n == 4)cout << "������ ������������� ��������. ��������� �������..." << endl;
		if (n == 5)cout << "������������ ��������. ��������� �������..." << endl;
	}
	return 0;
}


