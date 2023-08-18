clear; clc; close all;
syms x
x0 = 2.8;
f = sinh(pi*x/2);
fdf1 = @(f, x, h)(subs(f, x+h) - subs(f, x-h))/2/h; %центральная
fdf2 = @(f, x, h)(subs(f, x+h) - subs(f, x))/h;     %левая
eps1 = []; eps2 = [];
fperfect = double(fdf2(f, x0, 10^(-10)));
h=2.^-(1:0.5:8);
for i = 1:length(h)
    eps1(i) = abs(fdf1(f, x0, h(i)));
    eps2(i) = abs(fdf2(f, x0, h(i)));
end

figure()
hold on; grid on;
plot(h, eps1)
plot(h, eps2)
title('Погрешность от шага'); xlabel('h'); ylabel('eps');
legend('центральная', 'левая')


%погрешности имеют эксподенциальный рост O(h^2)