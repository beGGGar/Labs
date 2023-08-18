%Найти расстояние между прямыми 3x + 4y ? 20 = 0 и 6x + 8y + 5 = 0
clear; clc; 
M0 = [0 5];%точка на первой прямой
p = [-0.5 -0.25];%точка на второй прямой
q = [4 -3];%направляющий вектор
M0p = p-M0;
h = abs(dot(q, M0p)/sqrt(q(1)^2+q(2)^2))
x = -5:5;
f1 = (-3*x+20)/4;
f2 = (-6*x-5)/8;
plot(x, f1);
grid on;
hold on;
plot(x, f2);
plot(M0(1), M0(2), '.', 'MarkerSize',15, 'MarkerEdgeColor','Black');
plot(p(1), p(2), '.', 'MarkerSize',15, 'MarkerEdgeColor','Black');
plot([M0(1),p(1)], [M0(2),p(2)]);
quiver(M0(1), M0(2), q(1),q(2),'r-')
xlabel('x'); ylabel('y');