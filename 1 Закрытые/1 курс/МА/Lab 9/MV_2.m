close all; clear; clc; 
[X, Y] = meshgrid(-10:1:10, -10:1:10);
Z = X.^3./3 + Y.^3./3;
%surf(X, Y, Z)
hold on; grid on;
mesh(X, (1-X)/4, X.^3./3 + ((1-X)/4).^3./3)
xlabel('x'); ylabel('y'); zlabel('z'); title('Z = X^3/3 + Y^3/3')
z1 = @(X)X^3/3 - (X/4 - 1/4)^3/3;
z2 = @(X)-1*(X^3/3 - (X/4 - 1/4)^3/3);

syms X
solve(diff(X^3/3 - (X/4 - 1/4)^3/3, X));

[min(1), ~] = fminsearch(z1, 1/9);
min(2) = (1-min(1))/4;
min(3) = min(1)^3/3 + min(2)^3/3

[max(1), ~] = fminsearch(z2, -1/7);
max(2) = (1-max(1))/4;
max(3) = max(1)^3/3 + max(2)^3/3