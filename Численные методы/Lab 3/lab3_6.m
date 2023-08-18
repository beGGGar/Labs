close all; clear; clc; 
syms x
knot = 10; a = -5; b = 5;
t = a:(b-a)/(knot-1):b;

f = 1/(1+25*x^2);
P = lagrange2(f, t, x);
diff4 = double(subs(abs(f - P), 4))
diff5 = subs(abs(f - P), 5)

hold on; grid on; %ylim([-1, 1]);
fplot(P, [a, b])
fplot(f, [a, b])
legend('P', 'f');

%При увеличении числа чебышевских узлов, на удалении от начала
%координат, в промежуточных точках происходит волнение с большей
%амплитудой

