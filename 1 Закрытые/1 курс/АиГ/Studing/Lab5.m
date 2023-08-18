clear; clc; cla; close all
A=3; B=4; C = -4; D=-12;
x = -5: 0.5:5;
y = -3: 0.5:3;
[X, Y]=meshgrid(x,y);
Z = (-A*X - B*Y -D)/C;
hold on;
plot3(X,Y,Z, 'or');
quiver3(0, 0, 0, 3, 4, -4, 0, 'r', 'LineWidth', 2)
line([-5 0 0; 5 0 0], [0 -5 0; 0 5 0], [0 0 -5; 0 0 5], 'Color', 'blue')
axis square, grid on;

figure()
subplot(3, 2, 1), plot3(X,Y,Z, 'or', 'MarkerSize', 3)

subplot(3, 2, 2), mesh(X, Y, Z)

subplot(3, 2, 3), surf(X, Y, Z)

subplot(3, 2, 4), surfl(X, Y, Z)

subplot(3, 2, 5), surfl(X, Y, Z), shading interp

subplot(3, 2, 6), surfl(X, Y, Z), shading interp
