close all; clear; clc;
[x, y] = meshgrid(-5:0.1:5, -5:0.1:5);
z = 1  - x - y;
surf(x, y, z)
hold on; grid on;
xlabel('x'); ylabel('y'); zlabel('z'); title('Z = X^3/3 + Y^3/3')
xlim([0 1]); ylim([0 1]); zlim([0 1]);
mesh(x, y, zeros(size(x)))
mesh(x, zeros(size(x)),z )
mesh(zeros(size(x)), y, z)

syms x y z
f = z;
Iz = int(f, z, 0, 1-x-y);
Iy = int(Iz, y, 0, 1-x);
Ix = int(Iy, x, 0, 1)