clear; clc; cla; close all;
syms x a;
f = x*sin(a/x);
lim = subs(diff(sin(a/x))/diff(1/x), x, inf)