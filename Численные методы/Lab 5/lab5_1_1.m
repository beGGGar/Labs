clear; clc;
syms x
f = @(x)x^3;
fun = x^3;
a = 0; b = 1; n = 20;
trap = intTrap(fun, a, b, n)
simp = intSimpson(fun, a, b, n)    

f2 = x^2;
f3 = x/2;
eps(1) = int(fun, a, b)- intTrap(fun, a, b, n);
eps(2) = int(fun, a, b) - intSimpson(fun, a, b, n);
eps(3) = int(f2, a, b) - intTrap(f2, a, b, n);
eps(4) = int(f2, a, b) - intSimpson(f2, a, b, n);

eps(5) = int(f3, a, b) - intTrap(f3, a, b, n);
eps(6) = int(f3, a, b) - intSimpson(f3, a, b, n);
eps = double(eps)
max(eps)