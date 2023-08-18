%Найти точку минимума функции
clear; clc; cla; close all;
syms x;
x = -2:0.1:4;
y = exp(x)-3*x.^2;
plot(x,y)
grid on;
title('y=exp(x)-3*x.^2')
xlabel('x'), ylabel('y')
legend('exp(x)-3*x.^2')

figure()
x = 2.5:0.1:3;
y1 = exp(x) - 6*x;
plot(x,y1)
grid on;
title('График производной y(x)')
xlabel('x'), ylabel('y')
legend('exp(x)-6*x')
%точки минимума: 2.83

