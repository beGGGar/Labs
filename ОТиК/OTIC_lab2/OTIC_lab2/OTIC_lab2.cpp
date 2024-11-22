#include <iostream>
#include <fstream>
#include <vector>
#include <unordered_map>
#include <Windows.h>
#include <cmath>
#include <iomanip> 
#include <algorithm>
#include <string>


using namespace std;

class FileInfo {
private: 
	string fileName;
	size_t length = 0; // кол во байт
	unordered_map<unsigned char, size_t> byteCount; // сколько раз появлястся символ в файле
	vector<pair<unsigned char, size_t>> byteCountVec; // отсортирован по убыванию количества вхождений
	unordered_map<unsigned char, float> byteFreq; // частота для каждого символа
	unordered_map<unsigned char, float> Ibp; // колво инфо в символе
	float Ibpsum = 0; // общее кол во инфо

	// для задания 4	
	unordered_map<string, size_t> bytePairCount; // Подсчет вхождений пар байтов (ab)
	unordered_map<unsigned char, size_t> prefixPairCount; // Подсчет вхождений подстрок (a*)
	unordered_map<unsigned char, float> paa; // условная вероятность
	float Icmsum = 0; // общее кол во инфо по Системе Маркова

	int E = 0; // длины только сжатого текста
	int G64 = 0; // длины архива с таблицей данных из 256 64битных частот
	int G8 = 0; // длины архива с таблицей данных из 256 8битных частот

	
	
public:
	FileInfo(string fileName_) {
		fileName = fileName_;
	}

	~FileInfo() {
		// file.close();
	}


	// LENGTH, BYTE_COUNT, BYTE_FREQ подсчет частоты для каждого байта
	void CountBitesFreq(ifstream& file) {
		//unordered_map<unsigned char, size_t> byteCount;
		length = 0;
		unsigned char byte;
		
		unsigned char praByte = 1024; // предыдущий байт. Для задания 4

		file.seekg(0, ios::beg);
		//read ожидает char. Нужно приведение типов
		while (file.read(reinterpret_cast<char*>(&byte), 1)) {
			byteCount[byte]++;
			prefixPairCount[byte]++;
			length++;

			if (praByte!=1024) {
				// Подсчет пар байтов
				string bytePair = string(1, praByte) + string(1, byte);
				bytePairCount[bytePair]++;
			}
			praByte = byte;
		}
		prefixPairCount[byte]--; // последний символ не считаем. у него нет пары
		cout << "BYTE_COUNT, PREFIX_PAIR_COUNT, LENGTH, ";

		// определение частоты включения байта
		for (int i = 0; i <= 255; i++) {
			auto it = byteCount.find(i);
			if (it != byteCount.end()) {
				byteFreq[i] = static_cast<float>(it->second) / static_cast<float>(length);
			}
		}
		cout << "BYTE_FREQ,";

		// вычисляем условную вероятность
		/*for (const auto& pairBytePair : bytePairCount) {
			byte = (pairBytePair.first)[1];
			paa[byte] = static_cast<float>(pairBytePair.second) / static_cast<float>(prefixPairCount[byte]);
		}
		cout << ""*/

		ByteInfoAmount(file);
		cout << "BYTE_INFO_AMOUNT, ";
		E = static_cast<int>(ceil(Ibpsum));
		G64 = E + 256 * 8;
		G8 = E + 256 * 1;
		ByteCountSort();
		cout << "VECTOR_SORT";
	}


	// LENGTH получить длину файла 
	size_t GetFileLenght(ifstream& file) {
		file.seekg(0, ios::end); // перенос указателя в конец файла
		size_t fileLength = file.tellg();  // Получаем размер файла в байтах
		file.seekg(0, ios::beg);
		return fileLength;
	}


	// VIEW вывод статистики по количеству появлений символов
	void PrintByteFrequencies() {
		cout << fixed << setprecision(2);
		cout << "Частоты символов (вхождений каждого байта):" << endl;

		auto vec = byteCountVec.begin(); // для отсортированного вывода
		

		for (int i = 0; i <= 255; ++i) {
			auto it = byteCount.find(i);
			if (it != byteCount.end()) {
				float bf = byteFreq[i];
				float info = Ibp[i];
				cout << hex << i << " (или " << dec << static_cast<char>(i) << ")" 
					<< " вхождений:" << it->second 
					<< " частота:" << bf
					<< " I:" << info
					<< "\t|\t";

				unsigned char byte = vec->first;
				bf = byteFreq[byte];
				info = Ibp[byte];
				cout << "Вхождений:" << vec->second << " "
					<< hex << vec->first << " (или " << dec << static_cast<char>(vec->first) << ")"
					<< " частота:" << bf
					<< " I:" << info
					<< endl;
				vec++;
			}
			//else cout << hex << i << " (или " << dec << static_cast<char>(i) << "): " << 0 << " вхождений" << endl;
		}

		cout << endl << "Всего символов: " << length << endl << endl;
		cout << "Всего бит: " << length*8 << endl;
		//cout << "Всего инфо Ibpsum: " << Ibpsum << " или " << static_cast<int>(Ibpsum) << "+" << scientific << Ibpsum - static_cast<int>(Ibpsum) << endl << endl;
		cout << "Всего инфо Ibpsum: " << Ibpsum << " или " << scientific << Ibpsum << endl << endl << fixed;

		cout << "Длина октетов L: " << length << endl;
		cout << "Оценка инфо в октетах Ibpsumokt: " << static_cast<float>(Ibpsum) / 8 << endl << endl;

		cout << "Длины E[октетов]: " << E << endl
			<< "Длина архива G64: " << G64 << endl
			<< "Длина архива G8: " << G8 << endl << endl;
		

		cout << "Суммарное кол-во инфо Icm(Q): " << Icmsum << endl;
	}

	// I, Q вычисление колва инфо на символ	
	void ByteInfoAmount(ifstream& file) {
		for (const auto& pair : byteFreq) {
			Ibp[pair.first] = -log2(pair.second);
			Ibpsum += Ibp[pair.first] * byteCount[pair.first];
		}

		// вычисление Icmsum
		Icmsum = -log2(1.0f/256);
		unsigned char byte;
		unsigned char praByte;
		file.clear();
		file.seekg(0, ios::beg);
		file.read(reinterpret_cast<char*>(&byte), 1);
		praByte = byte;
		string bytePair;
		float freq;
		while (file.read(reinterpret_cast<char*>(&byte), 1)) {

			bytePair = string(1, praByte) + string(1, byte);
			if (bytePairCount.find(bytePair) != bytePairCount.end() && prefixPairCount.find(praByte) != prefixPairCount.end()) {
				freq = static_cast<float>(bytePairCount[bytePair]) / prefixPairCount[praByte];

				if (freq > 0) {
					Icmsum += -log2(freq);
				}
				praByte = byte;
			}
			
			
		}

	}
	void ByteCountSort() {
		for (auto& pair : byteCount) {
			byteCountVec.push_back(pair);
		}

		sort(byteCountVec.begin(), byteCountVec.end(),
			[](const pair<unsigned char, size_t>& a, const pair<unsigned char, size_t>& b) {
				return a.second > b.second;  // Сортировка по убыванию
			});
	}
};


int main()
{
	int a;
	setlocale(LC_ALL, "Rus");
	SetConsoleCP(1251); // Ввод с консоли в кодировке
	SetConsoleOutputCP(1251); // Вывод на консоль в кодировке
	while (true) {
		string fileName = "";// = "files/test-koi8.txt";
		cout << "Имя файла: " << endl;
		getline(cin, fileName);
		FileInfo f(fileName);
		fileName = "files/" + fileName;

		ifstream file(fileName, ios::binary);
		if (!file.is_open()) {
			std::cerr << "Не удалось открыть файл " << fileName << std::endl;
			return 1;
		}

		f.CountBitesFreq(file);
		//f.ByteInfoAmount(file);
		f.PrintByteFrequencies();
	}
	

	return 0;
}

