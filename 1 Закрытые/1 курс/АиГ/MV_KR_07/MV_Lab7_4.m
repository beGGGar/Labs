%4.	ѕостроить кривую и определить ее тип
clear; clc; cla; close all;
t = -pi:pi/200:pi;
x1 = cosh(t);
x2 = -cosh(t);
y = sinh(t);
z = 5;
hold on; grid on;
plot3(x1, y, z*ones(size(y)), 'g');
plot3(x2, y, z*ones(size(y)), 'g');
a = 1; c = exp(1)*a; b = sqrt(a^2-c^2);
%line([1 1], [-15, 15], [5 5]); %директриссы
%line([-1 -1], [-15, 15], [5 5]);
plot3([c, -c], [0 0], [5 5], 'r*');%фокусы
quiver3(-15, 0, 5, 30, 0, 0, 0, 'k'); quiver3(0, -15, 5, 0, 30, 0, 'k'); quiver3(0, 0, 3, 0, 0, 4, 0, 'k')
xlabel('x'); ylabel('y'); zlabel('z'); title('x = +-ch(t), y = sh(t), z = 5'); legend('гипербола', '', 'фокус (2.718, 0, 5) (-2.718, 0, 5)');