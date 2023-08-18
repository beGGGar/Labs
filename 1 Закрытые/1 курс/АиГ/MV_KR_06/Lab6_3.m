%поворот прямых
clear; clc; cla; close all;
syms x y x1 y1 alfa
x = x1 * cos(alfa) - y1 * sin(alfa);
y = y1 * cos(alfa) + x1 * sin(alfa);
f = y - 2 * x;
y1 = solve(f, y1);
yy = subs(y1, alfa, pi/3);
y1 = simplify(yy);
hold on, grid on, axis equal
x=-2:1:4; y = 2 * x;
alfa = pi/3; x0=1; y0=2;
x2 = x0 * cos(-alfa) - y0 * sin(-alfa);
y2 = y0 * cos(-alfa) + x0 * sin(-alfa);
M = [x2 y2]
x1 = -2:1:4;
y1 = (x1*(5*3^(1/2) - 8))/11;
quiver(-2, 0, 6, 0, 0, 'Color', 'k', 'LineWidth', 2)
quiver(0, -2, 0, 6, 0, 'Color', 'k', 'LineWidth', 2)
x3 = cos(alfa); y3 = -sin(alfa); x4 = sin(alfa); y4=cos(alfa);
e1 = [x3 y3]; e2 = [x4 y4];
quiver(0,0, x3, y3, 0, 'Color', 'b', 'LineWidth', 2)
quiver(0, 0, x4, y4, 0 ,'Color', 'b', 'LineWidth', 2)
plot(x, y, 'r', x0, y0, 'ro', x1, y1, 'g', x2, y2, 'go')
text(x0 + 0.2, y0, 'M'), text(x2 + 0.2, y2, 'M1')
axis([-2 4 -2 4])