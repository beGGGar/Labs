%Вычислить односторонние пределы в точках разрыва. Построить
%график функции в окрестности точки разрыва, отметить точку разрыва. 
%10
clear; clc; cla; close all;
x = 0:0.001:2; d = 0.001
f10 = (1+x).*atan(1./(1-x.^2));%разрыв первого рода в x=1
x0 = 1;
y = (1+x0)*atan(1/(1-x0.^2))% = 3,14
F10 = @(x)(1+x)*atan(1/(1-x^2));
limL = F10(x0-d);
limR = F10(x0+d);
xl = -3:0.01:1; xr = 1+d:0.01:5;
f10L = (1+xl).*atan(1./(1-xl.^2));
f10R = (1+xr).*atan(1./(1-xr.^2));


hold on
plot(x0, y, '*', 'MarkerSize',10)
plot(x0, limR, 'o', 'MarkerSize',10)
plot(xl, f10L, 'k'); hold on; grid on; 
plot(xr, f10R, 'k'); 
xlabel('x'); ylabel('y'); title('(1+x)*atan(1/(1-x.^2))'); legend('левый предел', 'правый предел', '(1+x)*atan(1/(1-x^2))');
