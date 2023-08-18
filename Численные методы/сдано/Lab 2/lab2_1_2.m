clear; clc; close all;
%метод деления отрезка пополам
%syms x;
%f = lab2_1f(x);
f = @(x)x.^3 - 11*x.^2-16*x+320;
a = -5.5; b = -4.5; delt = 0.001;
[x0, n] = half_found_zeros(f, a, b, delt)
a = 7.5; b = 8.5;
[x0, n] = half_found_zeros(f, a, b, delt)