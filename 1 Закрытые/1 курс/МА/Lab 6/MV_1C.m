clear; close all; clc; 
g1 = sym('0');
f1 = sym('(1-x^2)^(1/2)');
X = [-1, 1]; n = 50;
rg = 'r--'; rf = 'g';
MV_1f(f1, g1, X, n, rf, rg);

f2 = sym('(4-x^2)^(1/2)');
g2 = sym('(1-x^2)^(1/2)');
X = [-1, 1]; n = 50;
rg = 'r--'; rf = 'g';
MV_1f(f2, g2, X, n, rf, rg);