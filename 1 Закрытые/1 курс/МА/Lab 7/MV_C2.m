clear; clc; close all;
x0 = 1; y0 = 2; z0 = 5; X0 = [x0, y0 z0];
DX = [-0.1, 0.2, 0,1];
syms x y z dx dy dz
X = [x y z]; Dx = [dx dy dz];
f = sym('(2*x^2+y^2-5*z^2)^2');
[p2 T] = MV_C2f(f, X, Dx, DX, X0)