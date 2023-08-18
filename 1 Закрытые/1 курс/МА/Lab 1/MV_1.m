clear; clc; 
%a
syms x; fa = sym('x*sin(5*x)'); 
Ia = int(fa,x)

%b
fb = sym('1/((x^2+1)*(x-2)^2)');
Ib = int(fb, x)