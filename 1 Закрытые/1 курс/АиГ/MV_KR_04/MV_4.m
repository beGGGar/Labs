%Составить уравнение биссектрисы внутреннего угла треугольника АВС с вершинами
%A(1, -2), В(5, 4), С(-2, 0).
clear; clc; cla;
A = [1 -2];
B = [5 4];
C = [-2 0];
plot([1 5], [-2 4]);
hold on; grid on;
plot([5 -2], [4 0]);
plot([-2 1], [0 -2]);
AB = B-A;
AC = C-A;
x = -3:5;
%ABf = (3*x-7)/2;
%ACf = (-2*x-4)/3;
%plot(x, ABf);
%plot(x, ACf);
syms x y;
simplify(dot(AB, [x, y])/sqrt(AB(1)^2+AB(2)^2) == dot(AC, [x, y])/sqrt(AC(1)^2+AC(2)^2))
AD = [-1 5];
simplify((x-1)/-1==(y+2)/5)
x = -3:5;
f3 = 3-5*x;
plot(x, f3);