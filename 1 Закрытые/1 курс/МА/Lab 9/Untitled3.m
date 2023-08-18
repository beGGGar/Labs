close all; clear; clc; 
u = (-1:0.05:1)';
v = 0:0.05*pi:2*pi;
X = cosh(u)*cos(v);
Y = cosh(u)*sin(v);
Z = sinh(u)*ones(size(v));
mesh(X,Y,Z)
xlabel('x'); ylabel('y'); zlabel('z')
