%поворо прямых
clear; clc; cla; close all;
alfa = -pi/3;
A = [cos(alfa) -sin(alfa); sin(alfa) cos(alfa)];
hold on, grid on, axis equal
x=-1:0.1:2; y = 2 * x;
X = [x; y];
Y = A * X;
M1 = A * [1; 2];
e1 = [1 0]; e2 = [0 1]; E = A * [e1; e2];
quiver(-2, 0, 6, 0, 0, 'Color', 'k', 'LineWidth', 2)
quiver(0, -2, 0, 6, 0, 'Color', 'k', 'LineWidth', 2)
plot(x, y, 'r', 1, 2, 'ro')
plot(Y(1, :), Y(2, :), 'g', M1(1), M1(2), 'go')
quiver(0, 0, E(1), E(2), 0, 'Color', 'b')
quiver(0, 0, E(3), E(4), 0, 'Color', 'b')