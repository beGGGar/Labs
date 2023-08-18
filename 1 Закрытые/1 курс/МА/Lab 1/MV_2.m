clear; clc; 
%a
syms x; fa = sym('sqrt(1-x^2)');
Ia = int(fa, x, [-1, 1])

%b
fb = sym('x*exp(3*x)');
Ib = int(fb, x, [0, 1]) 