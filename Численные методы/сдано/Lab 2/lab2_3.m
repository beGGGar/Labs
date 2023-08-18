clear; clc;
hold on; grid on;
fplot(@(x) sin(x)-x/2, [-5 5])

syms x
f = @(x)sin(x) - x/2;
xabt = [-2, 0, 2]; eps = 0.01;
x1 = []; x2 = []; x3 = [];
%метод деления отрезка пополам
[x1(1), ~] = half_found_zeros(f, -2, -1, eps);
[x1(2), ~] = half_found_zeros(f, -1, 1, eps);
[x1(3), ~] = half_found_zeros(f, 1, 2, eps);
x1
%ньютон
[x2(1), ~] = newton(f, -2, eps);
[x2(2), ~] = newton(f, 0, eps);
[x2(3), ~] = newton(f, 2, eps);
x2
%простые итерации
f1 = 2*sin(x);
[x3(1), ~] = lab2_1_4f(f1, -2, eps);
[x3(2), ~] = lab2_1_4f(f1, 0, eps);
[x3(3), ~] = lab2_1_4f(f1, 2, eps);
x3
