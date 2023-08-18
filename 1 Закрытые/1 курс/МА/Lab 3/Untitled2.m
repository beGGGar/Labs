clear; clc; cla; 
syms n;
f = asin(1-1/n)/(n^3-3*n)^(1/3);
S = MV_1f(f, 100)