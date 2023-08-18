%Найти площадь треугольника, заключенного между осями координат и прямой
%2x ? 5y +10 = 0.
clear; clc;
n = -8:8;
f = (2*n+10)/5;
plot(n, f);
hold on; grid on;
plot([0 0], [-3 5]); %Y
plot([-8 8], [0 0]); %X
xlabel('x'); ylabel('y');
syms x y;
x = solve(2*x+10== 0);
y = solve(5*y==10);
Ax = [x, 0];
By = [0, y];
S = sqrt(Ax(1)^2+Ax(2)^2)*sqrt(By(1)^2+By(2)^2)/2