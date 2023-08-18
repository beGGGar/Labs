clear; clc;
eps = 0.001;
syms x
%F = 2*x^3 + 5*x^2 + 3*x + 0.5;
%f = -(F/x-5*x)/5
x0 = 0;
%[x0, n] = lab2_1_4f(f,x0, eps)
%double(subs(f,  -0.6769))
f = sinh(x) - x^2 - 0.1; 
[x0, n] = newton(f, x0, eps)