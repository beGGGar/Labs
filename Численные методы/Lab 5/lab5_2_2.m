clear; clc;
syms x;
F = @(x)1./(1+x.^2);
a = 0; b = 1;
[I1, n1] = piFind(F, a, b, 10^(-6));
PI = I1*4, n1
format long e

[I2, n2] = piFindRunge(F, a, b, 10^(-6));
PIRunge = I2*4, n2


