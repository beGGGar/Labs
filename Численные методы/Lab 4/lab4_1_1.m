clear; clc;
syms x
x0 = 2.8;
f = sinh(pi*x/2);
h1 = 10^(-3); h2 = 10^(-6);
format long e
df1 = double(newDiff(f, x0, h1))
df2 = double(newDiff(f, x0, h2))
