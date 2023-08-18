clc; clear;
A = [2 -3 1; 1 1 1; -4 6 -2];
B = [2; 2; -4];
C = [A B];
R = [rank(A) rank(C) 3]
syms x1 x2 c
[x1 x2] = solve(2*x1 - 3*x2 == 2 - c, x1 + x2 == 2 -c, x1, x2)
R = [x1; x2; c]