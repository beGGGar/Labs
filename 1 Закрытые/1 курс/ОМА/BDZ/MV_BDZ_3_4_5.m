%3, 4, 5. Вычислить предел. Построить график функций в окрестности точкиx ,отметить значение предела.
clear; clc; cla; close all;
%3
x03 = 16;
x = 15.5:0.01:16.5;
f3 = (x.^(1/4)-2)./(sqrt(x)-4)./(sqrt(x)-2);
F3 = @(x)(x^(1/4)-2)/(sqrt(x)-4)/(sqrt(x)-2);
d = 0.0001;
lim3 = (F3(x03+d)+F3(x03-d))/2% = 0.125
plot(x, f3)
grid on; hold on;
plot(x03, lim3, 'o', 'MarkerSize',10);
xlabel('x'); ylabel('y'); title('(x^(1/4)-2)/(sqrt(x)-4)/(sqrt(x)-2)'); legend('f(x)', 'a (16, 0.125)');

%4
figure();
x04 = 0;
x = -1:0.01:1;
f4 = (sind(5+2.*x)-sind(5+x))./(2*tand(x));
plot(x, f4); 
grid on; hold on;
F4 = @(x)(sind(5+2*x)-sind(5+x))/(2*tand(x));
lim4 = (F4(x04+d)+F4(x04-d))/2% = 0.498
plot(x04, lim4, 'o', 'MarkerSize',10);
xlabel('x'); ylabel('y'); title('(sind(5+2*x)-sind(5+x))/(2*tand(x))');legend('f(x)', 'a (0, 0.498)');

%5
figure();
x05 = 1;
x = 0:0.01:2;
f5 = cosd(4.*(x-1)).^(1./(x-1).^2);
plot(x, f5); 
grid on; hold on;
F5 = @(x)cosd(4*(x-1))^(1/(x-1)^2);
lim5 = (F5(x05+d)+F5(x05-d))/2% = 0.9976
plot(x05, lim5, 'o', 'MarkerSize',10);
xlabel('x'); ylabel('y'); title('cosd(4*(x-1))^(1/(x-1)^2)');legend('f(x)', 'a (1, 0.9976)');
