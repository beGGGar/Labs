%3.	Найти величину острого угла между плоскостями
clear; clc; cla; close all;

A1=2; B1=3; C1=-4; D1=4;
A2=5; B2=-2; C2=1; D2=-3;
n1 = [A1 B1 C1];
n2 = [A2 B2 C2];

alfa = acosd(dot(n1, n2)/norm(n1)/norm(n2))


x=-5:0.5:5; y=-5:0.5:5;
[X,Y]= meshgrid(x,y); % координаты узлов сетки
Z1 = (-A1*X-B1*Y-D1)/C1;
mesh(X, Y, Z1)
hold on, axis equal, grid on;
Z2 = (-A2*X-B2*Y-D2)/C2;
surfl(X, Y, Z2); shading interp

line([-5 0 0;5 0 0],[0 -5 0;0 5 0],[0 0 -35;0 0 35],'Color', 'black');
xlabel('x'), ylabel('y'), zlabel('z');
legend('2x+3y-4z+4=0', '5x-2y+z-3=0')
title('alfa=90');
zlim([-10 10]);
