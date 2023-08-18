#include <stdio.h>
#include <iostream>
//char* copy(char* s, char* t) {
//	char str = *s + *t;
//	char str1[] = s;
//	char str2[] = t;
//	printf("%c", str1+ str2);
//	char* s1 = &str;
//	return s1;
//}
using namespace std;
void copy(char* s, char* t) {
	for (int i = 0; s[i] ;i++) t[i] = s[i];
	cout << t;
}

int main() {
	char str1[] = "hello";
	char str2[5];
	char* s1 = str1;
	char* s2 = str2;
	copy(s1, s2);
	cout << s2;
	
	//copy(s1, s2);
	//printf("%c", copy(s1, s2));
	return 0;
}