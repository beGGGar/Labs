clear; clc; 
%задание 5
a = 1; b = 2; n = 1000; f = sym('exp(-x^2)'); 
syms x;
fun = @(u)subs(f, x, u);

right = 0;
SL = MV_3f(a, b, f, n, right)

right = 1;
SR = MV_3f(a, b, f, n, right)

[S, s] = MV_4f(a, b, f, n)

%задание 6
SS = double(quad(fun,a,b))

d1 = SS - SL
d2 = SS - SR
d3 = SS - S
d4 = SS - s