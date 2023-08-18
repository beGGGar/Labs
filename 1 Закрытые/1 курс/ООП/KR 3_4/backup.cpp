#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
//#include <string.h>
#include <string>
#include <Windows.h>
using namespace std;

//ПРОДУКТ
class Category {

    char* catName;
    int code;

public:
    Category();
    Category(int c, const char*);
    Category(Category& other);
    ~Category();

    char* getCatName();
    int getCode();
    void setCode(int C);
    void setCatName(char* name);

    friend std::ostream& operator<< (std::ostream& out, Category& category);
    Category& operator=(Category const& other);
    bool operator==(Category const& other);
};

int Category::getCode() { return code; }
void Category::setCode(int C) { code = C; }

Category& Category::operator=(Category const& other) {
    code = other.code;
    catName = new char[strlen(other.catName) + 1];
    strcpy(this->catName, other.catName);
    return *this;
}

bool Category::operator==(Category const& other) {
    if (code == other.code)return 1;
    return 0;
}

Category::Category() {
    catName = new char[1];
    code = 0;
}

Category::Category(Category& other) {
    //if (this->catName != nullptr) delete[] this->catName;
    catName = new char[strlen(other.catName) + 1];
    strcpy(this->catName, other.catName);
    code = other.code;
}

Category::Category(int c, const char* name) {
    code = c;
    catName = new char[strlen(name) + 1];
    strcpy(catName, name);
}

Category::~Category() {
    delete[] catName;
}

char* Category::getCatName() {
    char* name = new char[strlen(catName) + 1];
    strcpy(name, catName);

    return name;
}

void Category::setCatName(char* name) {
    delete[] catName;
    catName = new char(strlen(name) + 1);
    strcpy(catName, name);
}

std::ostream& operator<< (std::ostream& out, Category& category) {

    out << "------------------------" << endl << "Category " << category.catName << endl << "Code: " << category.code << endl << "------------------------" << endl;
    return out;
}

class Product {
    int article;
    char* name;
    double price;
    Category cat;

public:
    Product();
    Product(Product&);
    ~Product();
    Product(int, const char*, double, Category&);

    int getArticle();
    char* getName();
    double getPrice();
    int getCode();

    void setCode(int C);
    void setArticle(int a);
    void setName(char* name_);
    void setPrice(double p);

    friend std::ostream& operator<< (std::ostream&, Product&);
};

int Product::getArticle() { return article; }
double Product::getPrice() { return price; }
int Product::getCode() { return cat.getCode(); }
void Product::setCode(int C) { cat.setCode(C); }
void Product::setArticle(int a) { article = a; }
void Product::setPrice(double p) { price = p; }

void Product::setName(char* name_) {
    //if (this->name) delete[] this->name;
    this->name = new char[strlen(name_) + 1];
    strcpy(this->name, name_);
}

char* Product::getName() {
    char* name_ = new char[strlen(name) + 1];
    strcpy(name_, name);

    return name_;
}

Product::Product(int article_, const char* name_, double price_, Category& cat_) {
    article = article_;
    price = price_;
    cat = cat_;
    //delete[] name; 
    name = new char[strlen(name_) + 1];
    strcpy(name, name_);
}

Product::Product() {
    article = 0;
    name = new char[1];
    price = 0;
}

Product::Product(Product& other) {
    article = other.article;
    price = other.price;
    name = new char[strlen(other.name) + 1];
    strcpy(this->name, other.name);
    //setName(other.name);
    cat = other.cat;
}

Product::~Product() {
    delete[] name;
}

std::ostream& operator<< (std::ostream& out, Product& P) {

    //out << "Product " << endl << "Name: " << P.name << "Price: " << P.price;// << "Article: " << P.article << ", Category: " << P.getCode() << endl;
    return out;
}

//ПОКУПАТЕЛЬ
class Buyer {
    char* name;
    char* fam;
    int number;
    double baseSale;

public:
    Buyer();
    ~Buyer();
    Buyer(Buyer&);
    Buyer(const char* name_, const char* fam_, int number_, double baseSale_);

    char* getName();
    char* getFam();
    int getNumber();
    double getBaseSale(); 

    void setName(const char* name_);
    void setFam(const char* name_);
    void setNumber(int N);
    void setBaseSale(double BS);

    virtual double getSale(Product&);
    double getCost(Product&);
    friend std::ostream& operator<< (std::ostream& out, Buyer& B);
};

std::ostream& operator<< (std::ostream& out, Buyer& B) {
    out << "---------------";
    //out << "------------------------" << endl << "Classic Buyer" << endl << "Name: " << B.name << endl << "Surname: " << B.fam << endl << "Number: " << B.number << endl << "Base sale : " << B.baseSale << "%" << endl << "------------------------" << endl;
    return out;
}

double Buyer::getCost(Product& P) { return P.getPrice() - getSale(P); }
int Buyer::getNumber() { return number; }
double Buyer::getBaseSale() { return baseSale; }

void Buyer::setNumber(int N) { number = N; }
void Buyer::setBaseSale(double BS) { baseSale = BS; }

void Buyer::setName(const char* name_) {
    //if (this->name) delete this->name;
    this->name = new char[strlen(name_) + 1];
    strcpy(this->name, name_);
}

char* Buyer::getName() {
    char* N = new char[strlen(name) + 1];
    strcpy(N, name);
    return N;
}

void Buyer::setFam(const char* name_) {
    //if (this->fam != nullptr) delete[] this->fam;
    this->fam = new char[strlen(name_) + 1];
    strcpy(this->fam, name_);
}

char* Buyer::getFam() {
    char* N = new char[strlen(fam) + 1];
    strcpy(N, fam);
    return N;
}

Buyer::Buyer() {
    name = new char[1];
    fam = new char[1];
    number = 0;
    baseSale = 1;
}

Buyer::~Buyer() {
    delete[] name;
    delete[] fam;
}

Buyer::Buyer(Buyer& other) {
    setName(other.name);
    setFam(other.fam);
    number = other.number;
    baseSale = other.baseSale;
}

double Buyer::getSale(Product& P) {
    return P.getPrice() * baseSale;
}

Buyer::Buyer(const char* name_, const char* fam_, int number_, double baseSale_) {
    /*name = new char[strlen(name_) + 1];
    strcpy(name, name_);
    fam = new char[strlen(fam_) + 1];
    strcpy(fam, fam_);*/
    setName(name_);
    setFam(fam_);
    number = number_;
    baseSale = baseSale_;
}

class VIP_buyer : public Buyer {

    double addSale;
    Category favCat;

public:
    VIP_buyer();
    VIP_buyer(const char* name_, const char* fam_, int number_, double baseSale_, double addSale_, Category const& favor);
    VIP_buyer(VIP_buyer& B);

    double getAddSale();
    Category& getfavCat();
    double getSale(Product&);

    void setAddSale(double AS);
    void setFavCat(Category const&);

    friend std::ostream& operator<< (std::ostream& out, VIP_buyer& B);
};

VIP_buyer::VIP_buyer() { addSale = 0; }
VIP_buyer::VIP_buyer(VIP_buyer& B) { addSale = B.addSale; }
double VIP_buyer::getAddSale() { return addSale; }
void VIP_buyer::setAddSale(double AS) { addSale = AS; }
Category& VIP_buyer::getfavCat() { return favCat; }
void VIP_buyer::setFavCat(Category const& C) { favCat = C; }

double VIP_buyer::getSale(Product& P) {
    double finSale = getBaseSale();
    if (this->favCat.getCode() == P.getCode())finSale = finSale + addSale;
    return P.getPrice() * (getAddSale() + getBaseSale());
}

VIP_buyer::VIP_buyer(const char* name_, const char* fam_, int number_, double baseSale_, double addSale_, Category const& favor) :Buyer(name_, fam_, number_, baseSale_) {
    /*setName(name_);
    setFam(fam_);
    setNumber(number_);
    setBaseSale(baseSale_);*/
    setAddSale(addSale_);
    favCat = favor;
}

class Pencion_buyer : protected Buyer {

    double addSale;

public:
    Pencion_buyer();
    Pencion_buyer(const char* name_, const char* fam_, int number_, double baseSale_, double addSale_);
    double getAddSale();
    void setAddSale(double AS);
    double getSale(Product&);

    friend std::ostream& operator<< (std::ostream& out, Pencion_buyer& B);
};

Pencion_buyer::Pencion_buyer() { addSale = 0; }
double Pencion_buyer::getAddSale() { return addSale; }
void Pencion_buyer::setAddSale(double AS) { addSale = AS; }

Pencion_buyer::Pencion_buyer(const char* name_, const char* fam_, int number_, double baseSale_, double addSale_) :Buyer(name_, fam_, number_, baseSale_) {
    /*setName(name_);
    setFam(fam_);
    setNumber(number_);
    setBaseSale(baseSale_);*/
    setAddSale(addSale_);
}


double Pencion_buyer::getSale(Product& P) {

    double finSale = getBaseSale();
    SYSTEMTIME st;
    GetLocalTime(&st);
    if (st.wHour >= 9 && st.wHour < 12)finSale = finSale + getAddSale();

    return P.getPrice() * finSale;
}

void getDate() {

    SYSTEMTIME st;
    GetLocalTime(&st);
    cout << st.wHour << ":" << st.wMinute;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
int main() {
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);

    Category* cats = new Category[2];
    cats[0] = Category(111, "Fruts");
    cats[1] = Category(349, "Bred");

    Product* PP[5];
    PP[0] = new Product(4467, "Banana", 23, cats[0]);
    PP[1] = new Product(125, "Melon", 99, cats[0]);
    PP[2] = new Product(2324, "Apple", 322.2, cats[0]);
    PP[3] = new Product(2341, "Bred", 48, cats[1]);
    PP[4] = new Product(13445, "Biscuit", 99.3, cats[1]);

    Buyer* B[2];
    B[0] = new Buyer("Jo", "Green", 54944, 0.1);
    B[1] = new Buyer("Jo-Jo", "Brown", 666, 0.3);

    VIP_buyer* vip[2];
    vip[0] = new VIP_buyer("Bill", "Brown", 9925453, 0.1, 0.4, cats[0]);
    vip[1] = new VIP_buyer("Ivan", "Ivanov", 7777777, 0.1, 0.8, cats[1]);

    Pencion_buyer* pb[2];
    pb[0] = new Pencion_buyer("Nicolas", "Cage", 3465787, 0.1, 0.3);
    pb[1] = new Pencion_buyer("Billy", "Brown", 9876543, 0.1, 0.2);

    cout << cats[0];
    cout << PP[0];
    //cout << B1;
    //cout << B[0];
    //cout << vip[0]->getSale(*PP[0]);
    delete vip[0];
    delete vip[1];
    delete[] cats;
    delete pb[0];
    delete pb[1];
    delete B[0];
    for (int i = 0; i < 5; i++)delete PP[i];
    return 0;
}

//class VIP_buyer : private Buyer {
//
//    double addSale;
//    Category* favCat;
//
//public:
//    VIP_buyer();
//    VIP_buyer(const char* name_, const char* fam_, int number_, double baseSale_, double addSale_);
//    VIP_buyer(VIP_buyer& B);
//
//    double getAddSale();
//    Category* getfavCat();
//    double getSale(Product&);
//
//    void setAddSale(double AS);
//    void setFavCat(Category const&);
//
//    friend std::ostream& operator<< (std::ostream& out, VIP_buyer& B);
//};
//
//VIP_buyer::VIP_buyer() {
//    addSale = 0;
//    favCat = new Category[0];
//}
//VIP_buyer::VIP_buyer(VIP_buyer& B) { addSale = B.addSale; }
//double VIP_buyer::getAddSale() { return addSale; }
//void VIP_buyer::setAddSale(double AS) { if (AS >= 0 && AS + getBaseSale() < 1) addSale = AS; }
//void VIP_buyer::setFavCat(Category const& C) { favCat = C; }
//
////double VIP_buyer::getSale(Product& P) {
////    double finSale = getBaseSale();//////////////
////    if (this->favCat.getCode() == P.getCode())finSale = finSale + addSale;
////    return P.getPrice() * finSale;
////}
//
//VIP_buyer::VIP_buyer(const char* name_, const char* fam_, int number_, double baseSale_, double addSale_) :Buyer(name_, fam_, number_, baseSale_) {
//    addSale = addSale_;
//}
//
//ostream& operator<< (std::ostream& out, VIP_buyer& B) {
//    out << "------------------------" << endl << "Premium buyer" << endl << "Name: " << B.getName()
//        << endl << "Surname: " << B.getFam() << endl << "Number: " << B.getNumber() << endl
//        << "Base sale : " << B.getBaseSale() * 100 << "%" << endl << "Add sale : " << B.getAddSale() * 100
//        << "Favorite category: " << B.favCat.getName() << endl << "------------------------" << endl;
//    return out;
//}