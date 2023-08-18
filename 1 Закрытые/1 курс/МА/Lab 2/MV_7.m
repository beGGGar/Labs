clear; clc; cla; 
syms phy;
r = sym(4*(1+cos(phy)));
f = @(x)subs((r^2 + diff(r)^2)^(1/2), phy, x);
phy = 0:2*pi;
L = double(quad(f, phy(1), phy(end)))   