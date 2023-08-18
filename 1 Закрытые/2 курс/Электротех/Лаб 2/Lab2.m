close all; clc; clear;
syms f;
L = 60*10^(-3); C = 260*10^(-6);
Xl = 2*pi*f*L;
Xc = 1./(2*pi*f*C);
f = abs(solve(Xc == Xl, f));
f = double(f(1))
Xc = 1./(2*pi*f*C)
figure
hold on; grid on;
plot(f, Xc, 'k*');
f = 30:0.1:120;
Xl = 2*pi*f*L;
Xc = 1./(2*pi*f*C);
plot(f, Xl);
plot(f, Xc);
title('Xl(f) и Xc(f)'); legend('Точка пересечения (40.3; 15.2)', 'Xl(f)', 'Xc(f)');
xlabel('f'); ylabel('X')