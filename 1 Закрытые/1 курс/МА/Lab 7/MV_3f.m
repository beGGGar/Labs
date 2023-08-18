function [dz] = MV_3f(z, dx, dy, x0, y0)
syms x y
dz = subs(diff(z, x), [x, y], [x0, y0])*dx+ subs(diff(z, y), [x, y], [x0, y0])*dy;
end