clear; clc;
%метод ньютона
syms x
f = x.^3 - 11*x.^2-16*x+320;
df = diff(f);
 eps = 0.1;
[x0, n] = newton(f, -5, eps)
[x0, n] = newton(f, 8, eps)