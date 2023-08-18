close all; clear; clc;
syms x y r phy
ezplot('x^2+y^2=1')
hold on; grid on; xlabel('x'); ylabel('y');
ezplot('x^2+y^2=4')
f = sqrt(4 - x^2 - y^2);
Iy1 = 2*int(f, y, 0, sqrt(4-x^2));
Iy2 = 2*int(f, y, sqrt(1-x^2), sqrt(4-x^2));
Ix1 = 2*int(Iy1, x, 1, 2);
Ix2 = int(Iy2, x, -1, 1);
Ix = Ix1+Ix2

x = r*cos(phy);
y = r*sin(phy);
f = sqrt(4 - r^2)*r;
Ir = int(f, r, 1, 2);
Iphy = int(Ir, phy, 0, 2*pi)
