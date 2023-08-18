clear; clc; cla; close all;
n = 0:0.001:3;
f = (5*n.^6+3*n.^4+7)./(3*n.^5-35*n.^3+7*n);
plot(n, f);
ylim([-20, 20])