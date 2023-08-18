clear all; clc; cla; 
%a
syms u; t=0:pi/100:2*pi;
fa = @(x)subs(sin(u)*diff(cos(u)), u, x);
Sa = abs(double(quad(fa, t(1), t(end))))

xa = cos(t);
ya = sin(t);
plot(xa, ya); grid on;
xlabel('x'); ylabel('y'); title('x = cos(t), y = sin(t)');

%b
syms u; 
fb = @(x)subs(3*sin(u)*diff(2*cos(u)), u, x);
Sb = abs(double(quad(fb, t(1), t(end))))

figure;
xb = 2*cos(t);
yb = 3*sin(t);
plot(xb, yb); grid on;
xlabel('x'); ylabel('y'); title('x = 2cos(t), y = 3sin(t)');