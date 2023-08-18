clear; clc;
syms x
a=2; x=1;
f=1/2*(a/x+x);
eps=0.1; x0 = 1;
[x0, n] = lab2_1_4f(f, x0, eps)
