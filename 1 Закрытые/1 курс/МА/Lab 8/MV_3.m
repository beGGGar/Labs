close all; clear; clc; cla;
syms x y
z = x^2+y^2-2*log(x)-18*log(y);
[X, Y] = meshgrid(0.1:0.1:5, 1:0.1:5);
Z = X.^2+Y.^2-2*log(X)-18*log(Y);
[CM, h] = contour(X, Y, Z);
clabel(CM, h);
[min, ~] = fminsearch('MV_3f',[1, 3])

%проверка через функцию 2
[d, main_minors] = MV_2f(z, 1, 3)
%первые частные производные = 0
%по критерию сильвестра положительно определенный => точка - минимум