close all; clear; clc;
x = -1:0.1:3;
y = 2*x;
plot(x, y);
hold on; grid on;
y = x.^2;
plot(x, y);
syms x y
f = x + y^2;
Iy = int(f, y, x.^2, 2*x);
Ix = int(Iy, x, 0, 2)