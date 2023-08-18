function [ddz] = MV_4f(z, dx, dy, x0, y0)
syms x y;
ddxx = subs(diff(z, x, 2), [x y], [x0, y0])*dx^2;
ddyy = subs(diff(z, y, 2), [x y], [x0, y0])*dy^2;
ddxy = subs(diff(diff(z, x), y), [x y], [x0, y0])*dy*dx;
ddyx = subs(diff(diff(z, y), x), [x y], [x0, y0])*dy*dx;
ddz = ddxx+ddyy+ddxy+ddyx;
end