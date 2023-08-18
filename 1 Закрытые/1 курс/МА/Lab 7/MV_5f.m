function [p1, T] = MV_5f(f, x, y, dx, dy, O, d)
p1 = subs(f+MV_3f(f, dx, dy, O(1), O(2)), [x, y], O);
T = double(subs(p1, [dx, dy], d));
%p1 = subs(f, [x, y], O) + subs(diff(f, x), [x, y], O)*(x-O(1)) + subs(diff(f, y), [x, y], O)*(y-O(2));
end