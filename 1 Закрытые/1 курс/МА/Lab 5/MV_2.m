clear; clc; cla; close all;
syms x;
f = sym('x*y'); 
Y = sym('exp(x^2/2)');
a = 0; b = 1; y0 = 1; x0 = 0; n0 = 5;
L = MV_2f(f, x0, y0, n0);

X = 0:0.01:1;
plot(X, subs(Y, x, X), 'k')
legend('n = 1', 'n = 2', 'n = n0', 'Точное значение')

rez = double(max(abs(subs(L(n0), x, X) - subs(Y, x, X))))