clear; clc; 
syms x y z;
f = cos(3*x+y^2);
dx = diff(f, x)
dy = diff(f, y)
dxx = diff(f, x, 2)
dyy = diff(f, y, 2)
dxy = diff(dx, y)
dyx = diff(dy, x)

f2 = 2*x^3*y+y-z;
dx2 = diff(f2, x);
dy2 = diff(f2, y);
dz2 = diff(f2, z);
grad = [dx2, dy2, dz2];
grad = subs(grad, [x, y, z], [1, 2, -3])
