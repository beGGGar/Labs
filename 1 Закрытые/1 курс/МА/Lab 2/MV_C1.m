clear; clc; cla;
ezplot('y = x^2+1'); hold on; grid on;
ezplot('y = 3 - x');
line([-3 3], [1 1]); xlim([-3, 3]); ylim([0, 6])

x0 = 0; x1 = 1; x2 = 2;
plot([0 1 2], [1 2 1], '*r')
title('Площадь между графиками' ); 
legend('y = x^2+1', 'y = 3 - x', 'y = 1', 'углы искомой фигуры');

syms x;
f1 = @(u)subs(x^2+1-1, x, u);%abs
f2 = @(u)subs(3 - x-1, x, u);
S = double(quad(f1, x0, x1)+quad(f2, x1, x2))