close all; clear; clc;
f = @(x)x.^3 - 11*x.^2-16*x+320;
p = [1, -11, -16, 320];    
x0 = lab2_1f(f, p)
