%4.	Построить эллиптический цилиндр
clear; clc; cla; close all;
a = 4; b = 3; h = 0:0.05:5; alfa = 0:pi/50:2*pi;
[ALFA, H] = meshgrid(alfa, h);
X = a*cos(ALFA);
Y = b*sin(ALFA);
Z = H;
surfl(X, Y, Z), shading interp
axis equal; camlight; shading interp;
xlabel('x'); ylabel('y'); zlabel('z'); title('Эллиптический цилиндр с а = 4, b = 3');