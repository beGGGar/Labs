clear; clc; cla; close all;
t = 0:0.01:100;
hold on; grid on;

C1 = 1; C2 = 1;
[x, y] = MV_Lab11_3f(C1 ,C2, t);
plot(x, y, x(1), y(1), '*')

C1 = 3; C2 = 7;
[x, y] = MV_Lab11_3f(C1 ,C2, t);
plot(x, y, x(1), y(1), '*')

C1 = -2; C2 = 3;
[x, y] = MV_Lab11_3f(C1 ,C2, t);
plot(x, y, x(1), y(1), '*')

quiver(-2.5, 0, 2.5, -2, 0);
quiver(10, 5, -5, 2, 0);
quiver(10, -1, 0, 3, 0);
xlabel('x'); ylabel('y'); title('Траектория движения точки'); 
legend('C1 = 1, C2 = 1', 'точка начала C1 = 1, C2 = 1', 'C1 = 3, C2 = 7', 'точка начала C1 = 3, C2 = 7', 'C1 = -2, C2 = 3', 'точка начала C1 = -2, C2 = 3');
%спираль