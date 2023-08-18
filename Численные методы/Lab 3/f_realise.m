clear all; clear; clc; 
syms x
hold on; grid on;
fplot(2*x^3 + 5*x^2 + 3*x + 0.5)
q = 2*x^3 + 5*x^2 + 3*x + 0.5;
subs(q, -0.5)
double(subs(q, -0.39))
double(subs(q, -1.27))
subs(q, 1)