function [L] = MV_2f(Y, x0, y0, n0)
syms x y;
y1 = y0+subs(int(Y, x, x0, x), y, y0);
L(1) = y1;

for i = 2:1:n0
    y1 = y0+subs(int(subs(Y, y, y1), x, x0, x), y, y0);
    L(i) = y1;
end
N = 100;
X = 0:1/N:1;
figure()
hold on; grid on; xlabel('x'); ylabel('y'); 
title('Метод последовательных приближений');
plot(X, subs(L(1), x, X))
plot(X, subs(L(2), x, X))
plot(X, subs(L(n0), x, X))
end