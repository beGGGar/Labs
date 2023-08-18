clear; clc; cla;
syms t;
f = @(u)subs((diff(2*cos(t))^2+diff(3*sin(t))^2)^(1/2), t, u);
t = 0:pi/100:2*pi;
L = double(quad(f, t(1), t(end)))   