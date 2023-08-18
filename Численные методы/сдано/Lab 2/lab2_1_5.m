clear; clc;
f = @(x)x.^3 - 11*x.^2-16*x+320;
fzero(f, [8, 8.5])
fzero(f, [-6, -4])
