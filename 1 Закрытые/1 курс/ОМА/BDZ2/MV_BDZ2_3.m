clear; clc; cla; close all;
syms x; x0 = 4;
y = @(x)(x.^2+x+5).^(1/2);
simplify(diff(sqrt(x.^2+x+5)));
dy = @(x)(2*x + 1)./(2*(x.^2 + x + 5).^(1/2));
k = dy(x0);
k*x + y(x0)-x0*k;% (9*x)/10 + 7/5 касательная
ky = @(x)(9*x)/10 + 7/5;
q = [ky(0), ky(4)];
n = [-ky(4), ky(0)];
syms y1 x;
simplify((x-x0)/n(1) - (y1-y(x0))/n(2));%x/5 + (5*y1)/7 - 153/35
ny = @(x)(153/35-x/5)*7/5;
x = 0:0.1:8;
hold on; grid on;
plot(x, y(x), x, ky(x), x0, y(x0), '*')
quiver(x0, y(x0), 6-x0, ny(6)-y(x0), 0);
xlabel('x'); ylabel('y'); title('(x.^2+x+5).^(1/2)'); 
legend('Функция', 'Касательная','заданная точка' , 'перпендикуляр');