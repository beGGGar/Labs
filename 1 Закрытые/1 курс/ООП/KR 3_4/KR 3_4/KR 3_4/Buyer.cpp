#define _CRT_SECURE_NO_WARNINGS
#include "Product.cpp"
#include <Windows.h>
#include <vector>
#include <algorithm>
//#include <iostream>
//using namespace std;


class Buyer {
    string name;
    string fam;
    int number;
    double baseSale;

public:
    Buyer();
    //~Buyer();
    Buyer(Buyer&);
    Buyer(string name_, string fam_, int number_, double baseSale_);

    string getName();
    string getFam();
    int getNumber();
    double getBaseSale();

    void setName(string);
    void setFam(string);
    void setNumber(int N);
    void setBaseSale(double BS);

    virtual double getSale(Product&);
    double getCost(Product&);
    friend std::ostream& operator<< (std::ostream& out, Buyer& B);
};

int Buyer::getNumber() { return number; }
double Buyer::getBaseSale() { return baseSale; }
void Buyer::setNumber(int N) { number = N; }
void Buyer::setBaseSale(double BS) { if (BS >= 0 && BS <1)baseSale = BS; }
void Buyer::setName(string name_) { name = name_; }
string Buyer::getName() { return name; }
void Buyer::setFam(string fname_) { fam = fname_; }
string Buyer::getFam() { return fam; }

double Buyer::getCost(Product& P) { return P.getPrice() - getSale(P); }

std::ostream& operator<< (std::ostream& out, Buyer& B) {
    out << "------------------------" << endl << "Buyer" << endl << "Name: " << B.name << endl 
        << "Surname: " << B.fam << endl << "Number: " << B.number << endl << "Base sale : " 
        << B.baseSale*100 << "%" << endl << "------------------------" << endl;
    return out;
}

Buyer::Buyer() {
    name = "NotStated";
    fam = "NotStated";
    number = 0;
    baseSale = 1;
}

Buyer::Buyer(string name_, string fam_, int number_, double baseSale_) {
    name = name_;
    fam = fam_;
    number = number_;
    baseSale = baseSale_;
}

double Buyer::getSale(Product& P) {
    return P.getPrice() * baseSale;
}

///////////////////////////////////
class Pencion_buyer : protected Buyer {

    double addSale;

public:
    Pencion_buyer();
    Pencion_buyer(string name_, string fam_, int number_, double baseSale_, double addSale_);
    double getAddSale();
    void setAddSale(double AS);
    double getCost(Product&);

    friend std::ostream& operator<< (std::ostream& out, Pencion_buyer& B);
};

Pencion_buyer::Pencion_buyer() { addSale = 0; }
double Pencion_buyer::getAddSale() { return addSale; }
void Pencion_buyer::setAddSale(double AS) { if (AS >= 0 && AS + getBaseSale() < 1)addSale = AS; }

Pencion_buyer::Pencion_buyer(string name_, string fam_, int number_, double baseSale_, double addSale_) :Buyer(name_, fam_, number_, baseSale_) {
    addSale = addSale_;
}

double Pencion_buyer::getCost(Product& P) {
    double finSale = getBaseSale();
    time_t now = time(0);
    tm* ltm = localtime(&now);
    
    if (ltm->tm_hour >= 9 && ltm->tm_hour < 12)finSale = finSale + getAddSale();

    return P.getPrice() * finSale;
}

ostream& operator<< (std::ostream& out, Pencion_buyer& B) {
    out << "------------------------" << endl << "Premium buyer" << endl << "Name: " << B.getName()
        << endl << "Surname: " << B.getFam() << endl << "Number: " << B.getNumber() << endl
        << "Base sale : " << B.getBaseSale() * 100 << "%" << endl << "Add sale (с 9 до 12): " << B.getAddSale() * 100
        << endl << "------------------------" << endl;
    return out;
}

/////////////////////////////////////////////////////
class VIP_buyer : private Buyer {

    double addSale;
    vector<Category> favCat;

public:
    VIP_buyer();
    VIP_buyer(const char* name_, const char* fam_, int number_, double baseSale_, double addSale_);
    VIP_buyer(VIP_buyer& B);

    double getAddSale();
    Category* getfavCat();
    double getSale(Product&);

    void setAddSale(double AS);
    void setFavCat(vector<Category>);

    friend std::ostream& operator<< (std::ostream& out, VIP_buyer& B);
};

VIP_buyer::VIP_buyer() {
    addSale = 0;
    favCat = {};
}

double VIP_buyer::getAddSale() { return addSale; }
void VIP_buyer::setAddSale(double AS) { if (AS >= 0 && AS + getBaseSale() < 1) addSale = AS; }
void VIP_buyer::setFavCat(vector<Category> C) { favCat = C; }
VIP_buyer::VIP_buyer(VIP_buyer& B) {
    addSale = B.addSale; 
    setName(B.getName());
    setFam(B.getFam());
    setBaseSale(B.getBaseSale());
    setAddSale(B.getAddSale());
}



double VIP_buyer::getSale(Product& P) {
    int favCatLen = favCat.size();
    if (favCatLen > 0) {
        if (find(favCat.begin(), favCat.end(), P) != favCat.end())
            return P.getPrice() * (addSale + getBaseSale());
    }
    return P.getPrice() * getBaseSale();
}

VIP_buyer::VIP_buyer(const char* name_, const char* fam_, int number_, double baseSale_, double addSale_) :Buyer(name_, fam_, number_, baseSale_) {
    addSale = addSale_;
}

ostream& operator<< (std::ostream& out, VIP_buyer& B) {
    out << "------------------------" << endl << "Premium buyer" << endl << "Name: " << B.getName()
        << endl << "Surname: " << B.getFam() << endl << "Number: " << B.getNumber() << endl
        << "Base sale : " << B.getBaseSale() * 100 << "%" << endl << "Add sale : " << B.getAddSale() * 100
        << endl << "------------------------" << endl;
    return out;
}