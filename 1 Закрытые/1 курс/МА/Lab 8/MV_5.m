close all; clear; clc;
syms x y z
u = x + y./x + z./y + 2/z;
[min, max] = MV_4f(u)

%subs(sylv, [x y z], [0 0 0])