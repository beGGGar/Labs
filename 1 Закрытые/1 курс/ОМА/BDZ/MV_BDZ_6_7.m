%Вычислить предел. В одной системе координат построить в окрестности точки 0x
%графики исходной функции и функции где p - порядок малости
clear; clc; cla; close all;
%6
x06 = 0; p6 = 1;%вычисленно в тетрадном бдз
x = -1:0.01:1; d = 0.001;
f6 = sqrt(1+x)-sqrt(1-x);
plot(x, f6)
hold on; grid on;
F6 = @(x)sqrt(1+x)-sqrt(1-x);
lim6 = (F6(x06+d)+F6(x06-d))/2
plot(x06, lim6, '*', 'MarkerSize',10);
%C = lim f(x)/(x-x0)^p
C6 = (F6(x06-d)/(x06-d-x06)^p6+F6(x06+d)/(x06+d-x06)^p6)/2;
G6 = C6*(x-x06).^p6;
plot(x, G6)
xlabel('x'); ylabel('y'); title('lim f(x) и g(x)'); legend('f(x)', 'lim f(x), x0=0', 'g(x)');

%7
figure();
x07 = pi; p7 = 1;%вычисленно в тетрадном бдз
x = pi-1:0.01:pi+1;
f7 = (x-pi).*log(cos(2.*x));
plot(x, f7)
hold on; grid on;
F7 = @(x)(x-pi)*log(cos(2*x));
lim7 = F7(x07)% = 0
plot(x07, lim7, '*', 'MarkerSize',10);
C7 = (F7(x07-d)/(x07-d-x07)^p7+F7(x07+d)/(x07+d-x07)^p7)/2;
G7 = C7*(x-x07).^p7;
plot(x, G7);
xlabel('x'); ylabel('y'); title('lim f(x) и g(x)'); legend('f(x)', 'lim f(x), x0=pi', 'g(x)');

