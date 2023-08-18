clear; clc;
syms x a n;
f = x^2+x-a;
df = diff(f, x, 1);
%limit(abs(subs(f, x, x+1)/f), x, inf) = 1
%limit(f^(1/x), x, inf) = 1
%If = int(f+a, x) - a*x;
%If = subs(If, x, inf) - subs(If, x, 1) расходится
