function [d, m] = MV_2f(f, x0, y0)
syms x y;
d = subs(diff(f, x) + diff(f, y), [x y], [x0, y0]);%x
%d(2) = subs(diff(f, y), [x y], [x0, y0]);%y

xx = subs(diff(f, x, 2), [x y], [x0, y0]); %xx
yy = subs(diff(f, y, 2), [x y], [x0, y0]); %yy
xy = subs(diff(diff(f, x), y), [x y], [x0, y0]); %xy
yx = subs(diff(diff(f, y), x), [x y], [x0, y0]); %yx
 
M = [xx, xy; yx, yy];
m(1) = xx;
m(2) = det(M);
end