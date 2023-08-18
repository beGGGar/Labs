%2.	Решить уравнение и неравенство 
clear; clc;
syms x;
A=[x+3 x-1; 7-x x-1];
x1 = solve(det(A))

B=[2 0 3; -1 7 x-3; 5 -3 6];
x = -5:10;
y = det(B)
y=6*x - 30;
plot(x, y)
grid on;
%x>5