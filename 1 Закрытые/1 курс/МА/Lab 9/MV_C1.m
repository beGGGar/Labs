close all; clear; clc; 
[x, y] = meshgrid(-5/2:0.1:5/2, -10:1:10);
z = x.^2 + 12.*x.*y + 2*y.^2;
phy = 4*x.^2 + y.^2 - 25;
surf(x, y, z);
hold on; grid on;
colorbar
xlabel('x'); ylabel('y'); zlabel('z'); title('Z = X^3/3 + Y^3/3, 4*x^2 + y^2 = 25')
mesh(x, (abs(25-4*x.^2)).^(1/2), z)
mesh(x, -(abs(25-4*x.^2)).^(1/2), z)

