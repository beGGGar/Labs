#define _CRT_SECURE_NO_WARNINGS
#include "Category.cpp"
//#include <iostream>
//using namespace std;



class Product {
    int article; //код товара 
    string name;
    double price;
    Category cat;

public:
    Product();
    Product(Product&);
    //~Product();
    Product(string name_, double price_, int article_, Category& cat_);

    int getArticle();
    const string getName();
    double getPrice();
    int getCode();

    void setCode(int C);
    void setArticle(int a);
    void setName(string name_);
    void setPrice(double p);

    friend std::ostream& operator<< (std::ostream&, Product&);
};

int Product::getArticle() { return article; }
double Product::getPrice() { return price; }
int Product::getCode() { return cat.getCode(); }
void Product::setCode(int C) { cat.setCode(C); }
void Product::setArticle(int a) { article = a; }
void Product::setPrice(double p) { price = p; }
void Product::setName(string name_) {name = name_;}
const string Product::getName() {return name;}

Product::Product(string name_, double price_, int article_, Category& cat_) {
    article = article_;
    price = price_;
    cat = cat_;
    name = name_;
}

Product::Product() {
    article = 0;
    name = "NotStated";
    price = 0;
    cat = *(new Category());
}

Product::Product(Product& other) {
    article = other.article;
    price = other.price;
    name = other.name;
}

std::ostream& operator<< (std::ostream& out, Product& P) {
    out << "Product " << endl << "Name: " << P.name << "Price: " << P.price << "Article: " << P.article << ", Category: " << P.getCode() << endl;
    return out;
}