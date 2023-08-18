%Постройте в одной системе координат график функции и график многочленов Тейлора
clear; clc; cla; close all;
%А
x0 = 1; x = 0.01:0.01:10; syms z;
y = z^(1/2);
ya = @(x)sqrt(x);
%вычисляем значение nного члена в многочлене Тейлора
yap = @(n, x, x0)subs(diff(sqrt(z), n), z, x).*(x-x0).^n./factorial(n);

hold on; grid on; ylim([-5, 3]);
plot(x, ya(x));
plot(x, ya(x0)+yap(1, x, x0));
plot(x, ya(x0)+yap(1, x, x0)+yap(2, x, x0));
plot(x, ya(x0)+yap(1, x, x0)+yap(2, x, x0)+yap(3, x, x0));
plot(x, ya(x0)+yap(1, x, x0)+yap(2, x, x0)+yap(3, x, x0)+yap(4, x, x0));
xlabel('x'); ylabel('f(x)'); title('f = x^(1/2), x0 = 1'); 
legend('f(x)', 'n = 1', 'n = 2', 'n = 3', 'n = 4');

%Б 
figure(); hold on; grid on; ylim([-60, 60]);
x0 = 2;
yb = @(x)(2*x-1)./(x-1);
xl = 0:0.01:0.99; xr = 1.01:0.01:3;

%вычисляем значение nного члена в многочлене Тейлора
ybp = @(n, x, x0)subs(diff((2.*z-1)./(z-1), n), z, x).*(x-x0).^n./factorial(n);

plot(xl, yb(xl), 'b');
plot(xl, yb(x0)+ybp(1, xl, 0), 'r');
plot(xl, yb(x0)+ybp(1, xl, 0)+ybp(2, xl, 0), 'g');
plot(xl, yb(x0)+ybp(1, xl, 0)+ybp(2, xl, 0)+ybp(3, xl, 0), 'k');
plot(xl, yb(x0)+ybp(1, xl, 0)+ybp(2, xl, 0)+ybp(3, xl, 0)+ybp(4, xl, 0), 'm');
plot(xr, yb(xr), 'b');
plot(xr, yb(x0)+ybp(1, xr, 0), 'r');
plot(xr, yb(x0)+ybp(1, xr, 0)+ybp(2, xr, 0), 'g');
plot(xr, yb(x0)+ybp(1, xr, 0)+ybp(2, xr, 0)+ybp(3, xr, 0), 'k');
plot(xr, yb(x0)+ybp(1, xr, 0)+ybp(2, xr, 0)+ybp(3, xr, 0)+ybp(4, xr, 0), 'm');

xlabel('x'); ylabel('f(x)'); title('f = (2*x-1)/(x-1), x0 = 2'); 
legend('f(x)', 'n = 1',  'n = 2', 'n = 3', 'n = 4');
