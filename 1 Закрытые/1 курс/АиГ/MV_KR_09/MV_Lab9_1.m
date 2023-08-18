%Ќайти образ вектора x = (-2, 2) , если alfa = pi/6 . —делать рисунок
clear; clc; cla; close all;
alfa = pi/6;
A=[cos(alfa) -sin(alfa);sin(alfa) cos(alfa)];
x = [2; -2];
X = A*x
hold on; grid on; 
quiver(0, 0, x(1, 1), x(2,1), 0, 'r');
quiver(0, 0, X(1, 1), X(2,1), 0, 'g');
quiver(-3, 0, 6, 0, 0, 'k');
quiver(0, -3, 0, 6, 0, 'k');
xlabel('x'); ylabel('y'); title('образ х после поворота'); legend('x до поворота', 'х после поворота');
