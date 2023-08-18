%1.Вычислить определители (упростите полученное выражение).
clear; clc;
syms a;
A=[cos(a) sin(a); -sin(a) cos(a)];
det1 = simplify(cos(a)*cos(a)+sin(a)*sin(a))

B=[1 1 1; 5 7 8;  25 47 64];
det2 = det(B)