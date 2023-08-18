clear; close all; clc;  
[X, Y] = meshgrid(0.1:0.05:2, 0.1:0.05:2);
Z = 1./X+1./Y;
surf(X, Y, Z);
colorbar;
figure()
surfc(X, Y, Z)
figure()
contour3(X, Y, Z)
figure()
contour(X, Y, Z);
figure()
[CMatr, h] = contour(X, Y, Z);
clabel(CMatr, h, 0.1:0.1:2);
figure()
contourf(X, Y, Z, 10);
colorbar;
figure()
surf(X, Y, Z)
view(0, 60);
figure()
t = 0:0.1:100;
x = exp(-abs(t-50)-50).*cosd(t);
y = exp(-abs(t-50)-50).*sind(t);
z = t;
plot3(x, y, z, 'r--');
grid on;
figure()
u(:, 1) = -pi/2:pi/100:pi/2;
v(1, :) = 0:pi/100:2*pi;
x = cos(u)*cos(v);
y = 2*cos(u)*sin(v);
z = sin(u)*ones(size(v));
mesh(x, y, z)
colorbar();
%shading flat