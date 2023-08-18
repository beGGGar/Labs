#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

class Category {

    string name;
    int code;

public:
    Category();
    Category(string name_, int code_);
    Category(const Category&);
    //~Category();

    const string getName();
    void setName(const string);
    int getCode();
    void setCode(int);

    friend std::ostream& operator<< (std::ostream&, Category&);
    Category& operator=(const Category&);
};

int Category::getCode() { return code; }
void Category::setCode(int C) { code = C; }
const string Category::getName() { return name; }

void Category::setName(const string name) {
    this->name = name;
}

Category::Category() {
    name = "NotStated";
    code = 0;
}

Category::Category(string name_, int code_) {
    code = code_;
    name = name_;
}

Category::Category(const Category& other) {
    code = other.code;
    setName(other.name);
}

std::ostream& operator<< (std::ostream& out, Category& category) {

    out << "------------------------" << endl << "Category " << category.getName() << endl << "Code: " << category.getCode() << endl << "------------------------" << endl;
    return out;
}

Category& Category::operator=(const Category& other) {
    code = other.code;
    setName(other.name);
    return *this;
}