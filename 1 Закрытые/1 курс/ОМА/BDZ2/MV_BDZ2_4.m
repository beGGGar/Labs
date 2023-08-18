clear; clc; cla; close all;
syms x;
x = 2.5:0.1:5;
Xymin = fminbnd ('(x.^2-4*x+5)/(x-2)', x(1), x(end));
Xymax = fminbnd ('-(x.^2-4*x+5)/(x-2)', x(1), x(end))
y = @(x)(x.^2-4*x+5)./(x-2);
ymin = y(Xymin);
ymax = y(Xymax)
hold on;
plot(x, y(x))
plot(Xymin, ymin, 'r*', Xymax, ymax, 'g*')
grid on; xlabel('x'); ylabel('y'); title('(x.^2-4*x+5)./(x-2)');
legend('функция ', 'минимум', 'максимум'); 

