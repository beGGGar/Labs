clear; clc;
syms x;
f = cos(3*x)*(2*x^3-x+1);
f24 = (diff(f, 24))