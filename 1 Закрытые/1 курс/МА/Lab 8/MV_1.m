close all; clear; clc; 
syms x y;
t = [x, y];
[X Y] = meshgrid([-10:0.1:-1.5, 1.5:0.1:10], [-10:0.1:-1.5, 1.5:0.1:10]);
Z = X.*Y+50./X+50./Y;
[CM, h] = contour(X, Y, Z);
clabel(CM, h);
xlabel('x'); ylabel('y'); title('x.*y+50./x+20./y'); grid on;
%минимумы
[M1, F1] = fminsearch('MV_1f1', [4, 1])
[M2, F2] = fminsearch('MV_1f1', [-1, -1])
%[M3, F3] = fminsearch('MV_1f1', [-0.1, 0.1])
%[M4, F4] = fminsearch('MV_1f1', [0.1, -0.1])
%максимумы
[M3, F3] = fminsearch('MV_1f2', [0.1, 2])
[M4, F4] = fminsearch('MV_1f2', [0.1, -0.1])

