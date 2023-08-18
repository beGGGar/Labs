close all; clear; clc;
       %zeros(size(x))
[x, y] = meshgrid(-1:0.1:1, -2:0.1:2);
z = (x.^2 + y.^2).^(1/2);
surf(x, y, z);
hold on; grid on; 
xlabel('x'); ylabel('y'); zlabel('z');
mesh(x, (1-x.^2).^(1/2), z);
mesh(x, -(1-x.^2).^(1/2), z);
mesh(x, y, zeros(size(x)))

syms x y z r phy 
f = sqrt(x^2+y^2);
Iz = int(f, z, 0, (x^2 + y^2)^(1/2));
Iy = 2*int(Iz, y, 0, (1-x.^2).^(1/2));
Ix = int(Iy, x, -1, 1)

x = r*cos(phy);
y = r*sin(phy);
f = simplify(sqrt(x^2+y^2)*r);
Iz = int(f, z, 0, r);
Ir = int(Iz, r, 0, 1);
Iphy = int(Ir, phy, 0, 2*pi)