#include <string>
#include <iostream>
#include <stack>

using namespace std;

class STACK {
    int size = 0;
    char stack[4000];
public:
    ~STACK() {}
    
    int PUSH(char c) {
        if (size < 4000) {
            try {
                stack[size] = c;
                size++;
                return 0;
            }
            catch (...) { return 1; }
        }
        else return 1;
    }
    int POP() {
        if (size > 0) {
            try {
                stack[size - 1] = 0;
                size--;
                return 0;
            }
            catch (...) { return 1; }
        }
        else return 1;
    }
    void CLEAR() {
        size = 0;
        /*for (char c : stack) {
            c = 0;
        }*/
    }
    int strAnalyse(string str) {
        for (int i = 0; i < str.length(); i++) {
            if (str[i] == '(') {
                PUSH(str[i]);
            }
            if (str[i] == ')') {
                if (POP()) {
                    cout << "\nWrong ')' number or position in expression \n";
                    break;
                }
            }
        }
        if (size != 0) cout << "\nWrong '(' number or position in expression \n";
        else cout << "Correct '()' input\n";
        return size;
    }
};

int LabExpression() {

}

int main()
{
    string input;
    STACK stack;
    while(true) {
        cout << "Input mathematical expression: \n";
        getline(cin, input);
        if (input == " ")break;
        stack.strAnalyse(input);
        stack.CLEAR();
    }
    
}
