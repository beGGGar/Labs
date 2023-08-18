clear; close all; clc; 
syms x;
figure; hold on; grid on; 
xlim([0, 0.7]); ylim([0, 0.8]);
format long e

f = sin(pi*x/2);
k = 8; t = 0:1/k:4/k;
P = lagrange2(f, t, x);
fplot(P,[0, 0.5], 'r')

f = @(x)sin(pi.*x./2);
fplot(f, [0, 0.5], '--k');

kdiff = k/4*6; tdiff = 0:1/kdiff:6/kdiff;

%погрешность по лагранжу по графику
for i = 1:1:length(tdiff)
    delta(i) = subs(P, tdiff(i)) - f(tdiff(i));
end
plotdiff = double(max(delta))

%погрешность теоретическая Rn
for i=1:1:5
a(i)=(x-t(i));
end
w=prod(a);

%оценим погрешность сверху
M5 = max(subs(diff(sin(pi*x/2), 5), tdiff));
teorDiff = double(M5/factorial(5)*int(abs(w), 0, 1))







