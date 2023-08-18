close all; clear; clc; 
syms x
n = 10; a = -5; b = 5;
%t = a:(b-a)/(n-1):b;

for k = 1:n-1
   t(k) = (a + b)/2 + (b-a)/2*cos( (2*k-1)/(2*n)*pi );
end
f= 1./(1+25*x.^2);
P = lagrange2(f, t, x);
grid on; hold on;
fplot(P,[a, b])
fplot(f,[a, b])
legend('P', 'f');

