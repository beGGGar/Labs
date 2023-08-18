clear; clc; close all;
syms x;
f = sin(pi.*x./2);

k = 8; t = 0:1/k:4/k;
P = lagrange2(f, t, x);

f1 = subs(f, 2)
p1 = double(subs(P, 2))

hold on; grid on; 
fplot(P, [0, 2])
fplot(f, [0, 2])
legend('P', 'f')
%при приближении к точке t=2,полином теряет точность, т. к. эта точка 
%не лежит внутри интервала [х0,х4], и не удовлетворяет условиям.
