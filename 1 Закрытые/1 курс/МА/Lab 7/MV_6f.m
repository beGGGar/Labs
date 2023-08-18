function [p2, T] = MV_6f(f, x, y, dx, dy, O, d)
p2 = f + MV_3f(f, dx, dy, O(1), O(2)) + MV_4f(f, dx, dy, O(1), O(2))/2;
p2 = subs(p2, [x, y], O);

T = double(subs(p2, [dx, dy], d));
%p1 = subs(f, [x, y], O) + subs(diff(f, x), [x, y], O)*(x-O(1)) + subs(diff(f, y), [x, y], O)*(y-O(2));
end