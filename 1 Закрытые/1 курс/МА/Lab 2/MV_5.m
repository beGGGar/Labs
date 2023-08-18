clear; clc; cla;
syms x;

f = @(u)subs((1+diff(x.^2).^2).^(1/2), x, u);
L = double(quad(f, 1, 2))
