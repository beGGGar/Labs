clear; clc; cla; 
%a
syms x;
y = sym(sin(x)); 
fa = @(u)subs(y^2, x, u);
x = 0:pi;
Va = double(pi*quad(fa, x(1), x(end)))

%b
syms x;
y = sym(sin(x)); 
fb = @(u)subs(x*y, x, u);
x = 0:pi;
Vb = double(2*pi*quad(fb, x(1), x(end)))