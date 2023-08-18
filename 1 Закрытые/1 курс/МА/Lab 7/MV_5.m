clear; clc; close all;
x0 = 1; y0 = 2; O = [x0, y0];
d = [-0.2, 0.2];
syms x y dx dy
f = sym('(2*x^2+y^2)^2');
[p1 T] = MV_5f(f, x, y, dx, dy, O, d)
ft = double(subs(f, [x, y], [x0+d(1), y0+d(2)]));
D1 = T-ft;

[X, Y] = meshgrid(-6:6, -6:6);
Z1 = (2*X.^2+Y.^2).^2;
figure()
hold on; grid on;
mesh(X, Y, Z1)
DX = X-x0*ones(size(X)); DY = Y-y0*ones(size(Y));
Z2 = 48*DX + 48*DY - 108*ones(size(X));
%Z2 = subs(p1, [x, y], [X, Y]);
mesh(X, Y, Z2)

[p2, T] = MV_6f(f, x, y, dx, dy, O, d)
D2 = T-ft;

p2 = 80*DX.^2 + 64.*DX.*DY + 48.*DX + 56.*DX.^2 + 48.*DX + 36*ones(size(Y));
Z3 = p2;%subs(p2, [dx, dy], [X-x0*ones(size(X)), Y-y0*ones(size(Y))]);
mesh(X, Y, Z3)