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
			cout << "��������� �������   ";
		}
	}
}

int dateCheck() {
	int rez = 1000;
	while (true) {
		rez = intCheck();
		if (rez < 100 && rez >= 0)return rez;
		else cout << "��������� �������   ";
	}
}

void DialogInterface() {
	//���������
	cout << "�������� ����� �������................1" << endl;
	cout << "����������� ���� �������..............2" << endl;
	cout << "����� ������ �� ��������..............3" << endl;
	cout << "������ �� ������ ������...............4" << endl;
	cout << "����������� �� ���������� ����������..5" << endl;
	cout << "����� ������� ������..................6" << endl;
	cout << "����� �� ��������� � �����������......7" << endl;
	cout << "����� ���� ������.....................8" << endl;
	cout << "storage  - 1 ��" << endl;
	cout << "storage1 - 2 ��" << endl;
	cout << "......................................." << endl;
};

int switchCheck() {
	int sw = 0;
	cout << "����� ��: ";
	while (true) {
		sw = intCheck();
		if (sw == 1 || sw == 2)return sw;
		else cout << "��������� �������   ";
	}
}