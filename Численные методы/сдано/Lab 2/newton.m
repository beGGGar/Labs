function [x0, n] = newton(f, x0, eps)
syms x
df = diff(f, x, 1);
fdf = simplify(f/df);
n = 0;
while 1
old_root = x0;
x0 = double(x0 - subs(fdf, x0))
n = n + 1;
%fprintf('%f \n', old_root - x0);
    if abs(old_root - x0) < eps
        break
    end
end
end