clear; clc; 
syms x;
f = x.^3 - 11*x.^2-16*x+320;
%f = simplify(f/(x-8)/(x+5));
% x=8 - кратный корень
eps = 0.01;
[x0, n] = newton2(f, 8.5, eps, 2)
