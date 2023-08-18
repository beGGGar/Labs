clear; clc; 
syms phy z r t;

x = r*cos(phy);
y = r*sin(phy);
A = [diff([x; y; z], r) diff([x; y; z], phy) diff([x; y; z], z)]
simplify(det(A))

%A = [diff(x, r) diff(x, phy) diff(x, z); diff(y, r) diff(y, phy) diff(y, z); diff(z, r) diff(z, phy) diff(z, z)];
