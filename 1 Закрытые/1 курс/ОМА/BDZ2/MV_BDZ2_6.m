clear; clc; cla; close all;
syms x;
f = log(sin(x))+x;
y = @(x)log(sin(x))+x;
hold on;
for k = -3:1:3
    x = 2*pi*k:pi/100:2*pi*k+pi;
    plot(x, y(x), 'b')
end
grid on; xlabel('x'); ylabel('f(x)'); title('log(sin(x))+x'); ylim([-40, 30])

%1) y определена на x = (2*pi*k, 2*pi*k+pi) при k в Z
%2) функция не четная не нечтная, не периодична
%3) при x<0 - y <0, при х>0 - y>0 при х(2pi*k; 2pi*k+pi), в х уходит в
%минус беск
x0 = fzero(y, [0.1, 1]);%для первого икса  0.5885
%4) вертикальные асимптоты x = k*pi, для всех к в Z
%5) 
syms x;
k = limit((log(sin(x))+x)./x, x, +inf); %k=1
b = limit(log(sin(x))+x-k*x, x, +inf); %limit(log(sin(x)), x == Inf) => наклонных ассимптот нет
%6) первая Производная
syms x;
dy= diff(log(sin(x))+x);
dY = @(x)cot(x)+1;
figure()
hold on;
for k = -3:1:3
    x = 2*pi*k:pi/100:2*pi*k+pi;
    plot(x, dY(x), 'b')
end
grid on; ylim([-3, 3]); xlabel('x'); ylabel('f(x)'); title('Производная');
%максимумы в x = pi/2+2pi*k
%7) вторая производная
syms x;
ddy = simplify(diff(log(sin(x))+x, 2));
ddY = @(x)-1./sin(x).^2;
figure()
hold on;
for k = -3:1:3
    x = 2*pi*k:pi/100:2*pi*k+pi;
    plot(x, ddY(x), 'b')
end
grid on; ylim([-3, 3]); xlabel('x'); ylabel('f(x)'); title('Вторая производная');
%Выпукла вверх на всех промехутках определенности
