clear; clc; cla; close all;
syms x;
f = sym('x*y'); 
Y = sym('exp(x^2/2)');
e = 0.001; a = 0; b = 1; y0 = 1; x0 = 0; n0 = 5;
[L, n] = MV_1f(f, x0, y0, a, b, n0, e);

X = a:(b-a)/n:b;
figure()
plot(X, L, 'r')
hold on; grid on;
plot(X, subs(Y, x, X), 'k')
xlabel('x'); ylabel('y'); title('Точное и полученное значения');
legend('Полученные', 'Точные')
%xlim([0.95, 1]); %ylim([])