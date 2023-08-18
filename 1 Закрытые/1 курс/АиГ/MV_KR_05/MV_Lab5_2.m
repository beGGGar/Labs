%—оставить уравнение плоскости, проход€щей через точку ћ перпендикул€рно вектору MN
clear; clc; cla; close all;
MN=[1 -1 -3];
N=[2 -8 -1];
M = N-MN;
syms x y z;
simplify((x-1)-(y+7)-3*(z-2))
%x - y - 3*z - 2 = 0

A = 1; B = -1; C = -3; D = -2;
% задаем диапазоны изменени€ переменных x и y
x=-5:0.5:5; y=-5:0.5:5;
[X,Y]= meshgrid(x,y); % координаты узлов сетки
Z = (-A*X-B*Y-D)/C;
mesh(X, Y, Z)
line([-5 0 0;5 0 0],[0 -5 0;0 5 0],[0 0 -5;0 0 5],'Color', 'black');
hold on, axis equal, grid on;
quiver3(0, 0, 0, 3, 4, -4, 0, 'r', 'LineWidth', 2)

xlabel('x'), ylabel('y'), zlabel('z');
title('x - y - 3*z - 2 = 0');
