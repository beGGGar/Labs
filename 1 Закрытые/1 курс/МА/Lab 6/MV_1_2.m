clear; close all; clc; 
rf = 'g--'; rg = 'r';
X = [1, 5]; n = 100;
f = sym('x^2-1'); g = sym('x^2+1');
MV_1f(f, g, X, n, rf, rg)