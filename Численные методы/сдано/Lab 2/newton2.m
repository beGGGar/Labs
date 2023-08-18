function [x0, n] = newton2(f, x0, eps, p)
%модиф ньютон
syms x
df = diff(f, x, 1);
fdf = p*simplify(f/df);
n = 0;
while 1
old_root = x0;
x0 = double(x0 - subs(fdf, x0));
n = n + 1;
%fprintf('%f \n', old_root - x0);
    if abs(old_root - x0) < eps
        break
    end
end
end