close all; clear; clc;
[x, y] = meshgrid(-10:0.2:10, -10:0.2:10);
z = x.*y;
mesh(x, y, z)
hold on; grid on; xlabel('x'); ylabel('y'); zlabel('z'); 
title('область инт.: y=x^2, x=y^2, z=xy, z=0'); 
xlim([-4 6]); ylim([-4 6]); zlim([-40 40]); colorbar; 

mesh(x, y, zeros(size(z)))

[x, z] = meshgrid(-10:0.2:10, -100:10:100, 'r');
surf(x, x.^2, z)

[y, z] = meshgrid(-10:0.2:10, -100:10:100);
surf(y.^2, y, z)

syms x y z
f = x*y*z;
s = solve(x^2-sqrt(x));
X = [s(1), s(2)];
Y = X.^2;
Iz = int(f, z, 0, x*y)
Iy = int(Iz, y, x^2, sqrt(x))
Ix = int(Iy, x, min(X), max(X))

