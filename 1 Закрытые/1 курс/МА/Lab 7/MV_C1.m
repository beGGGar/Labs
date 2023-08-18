clear; clc; close all;
syms phy teta r;
x = r*cos(phy)*cos(teta);
y = r*sin(phy)*cos(teta);
z = r*sin(teta);
J = [diff([x; y; z], r) diff([x; y; z], phy) diff([x; y; z], teta)];
simplify(det(J))
