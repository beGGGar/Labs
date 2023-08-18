close all; clear; clc;
%x^2 + y^2 +(z-1/2)^2 = 1/4

[teta, phy] = meshgrid(-pi/2:pi/100:pi/2, 0:pi/50:2*pi);
r = 1/2;
x = r*cos(phy).*cos(teta);
y = r*sin(phy).*cos(teta);
z = r*sin(teta).*ones(size(teta)) + 1/2;
mesh(x, y, z)
hold on; grid on; xlabel('x'); ylabel('y'); zlabel('z'); 
title('Область интегрирования'); colorbar;

%БЕЗ ЗАМЕНЫ 
syms x y z r phy teta
f = sqrt(x^2+y^2+z^2);
Iz = int(f, z, -sqrt(1/4 - x^2 - y^2), sqrt(1/4 - x^2 - y^2));
Iy = int(Iz, y, -sqrt(1/4 - x^2), sqrt(1/4 - x^2));
Ix = int(Iy, x, -1/2, 1/2);
I1 = vpa(Ix, 4)

%ЗАМЕНА
x = r*cos(phy)*sin(teta);
y = r*sin(phy)*sin(teta);
z = r*cos(teta);
f = r^3*sin(teta); %sqrt(x^2+y^2+z^2)*r^2*sin(teta);
Ir = int(f, r, 0, 1/2);
Iphy = int(Ir, phy, 0, 2*pi);
Iteta = 2*int(Iphy, teta, 0, pi/2);
I2 = double(Iteta)