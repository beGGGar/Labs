clear; clc;
dx = 0.1; dy = -0.2;
z = sym('x*y^2+2*y-x^2');
x0 = 2; y0 = -1;
ddz = MV_4f(z, dx, dy, x0, y0)