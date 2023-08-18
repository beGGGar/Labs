clear; clc; 
z = sym('x*y^2+2*y-x^2');
d = [0.1, -0.2]; x0 = 2; y0 = -1;

dx = 0.1; dy = -0.2;
dz = MV_3f(z, dx, dy, x0, y0)