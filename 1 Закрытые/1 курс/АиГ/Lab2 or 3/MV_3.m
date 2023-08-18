clean; clc;
a = 1;
x = -3:0.1:3;
f = a*cosh(x./a);
plot(x, f);
hold on;
grid on;
plot(f, x);