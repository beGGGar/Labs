clear; close all; clc;
%C2
figure()
[X, Y] = meshgrid(-2*pi:pi/20:2*pi, -2*pi:pi/20:2*pi);
Z = cos(X.*Y);
surf(X, Y, Z);
colorbar;
grid on; xlabel('x'); ylabel('y'); zlabel('z'); title('C2 cos(x*y)');
[az, el] = view;

%C3
figure()
subplot(1, 2, 1)
meshc(X, Y, Z)
grid on; xlabel('x'); ylabel('y'); zlabel('z'); title('C3 Линии уровня');

subplot(1, 2, 2)
contour3(X, Y, Z, -1:0.05:1);
grid on; xlabel('x'); ylabel('y'); zlabel('z'); title('C3 Поверхности из линий ур-ня'); colorbar;

%С4
figure()
subplot(1, 2, 1)
contour(X, Y, Z);
grid on; xlabel('x'); ylabel('y'); zlabel('z'); title('C4 Плоские линии уровня без значений');

subplot(1, 2, 2)
[CMatr,h]=contour(X,Y,Z);
clabel(CMatr,h, min(Z):0.1:max(Z))
grid on; xlabel('x'); ylabel('y'); zlabel('z'); title('C4 С нанесением значений');

%C5
figure()
contourf(X, Y, Z, 10); colorbar; shading flat;
grid on; xlabel('x'); ylabel('y'); zlabel('z'); title('C5 Плоские линии в цвете и с баром');

%С6
figure()
surf(X, Y, Z);
colorbar;
grid on; xlabel('x'); ylabel('y'); zlabel('z'); title('C6 cos(x*y)');
view(az, 60)
shading flat;