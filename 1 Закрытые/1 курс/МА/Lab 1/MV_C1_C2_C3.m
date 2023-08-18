clear; clc;
%Ñ1
syms x;
f1 = 1/(x^2+2*x+3)^(1/2);
I = int(f1, x)

%Ñ2
fun = @(x)x.*cosd(x.^2);
a2 = 0; b2 = pi/2;
S2 = double(quad(fun,a2,b2))

%Ñ3
a3 = 1; b3 = 2; n = 4; L = 0.5; f3 = sym('x');        
S3 = MV_C3f(a3, b3, f3, n, L)