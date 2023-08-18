%4.	Осуществите поворот треугольника из задания 3. 
%Параметры преобразований задайте самостоятельно.
clear; clc; cla; close all;
A = [4 5]; B = [4 2]; C = [0 5]; x0 = 0; y0 = 0; a = 4; b = -3; 
alfa = 72;
A1 = [A(1)*cosd(alfa)-A(2)*sind(alfa), A(1)*sind(alfa)+A(2)*cosd(alfa)];
B1 = [B(1)*cosd(alfa)-B(2)*sind(alfa), B(1)*sind(alfa)+B(2)*cosd(alfa)];
C1 = [C(1)*cosd(alfa)-C(2)*sind(alfa), C(1)*sind(alfa)+C(2)*cosd(alfa)];
hold on; grid on;
line([A(1) B(1) C(1); C(1) A(1) B(1)], [A(2) B(2) C(2); C(2) A(2) B(2)], 'Color', 'r');
line([A1(1) B1(1) C1(1); C1(1) A1(1) B1(1)], [A1(2) B1(2) C1(2); C1(2) A1(2) B1(2)], 'Color', 'g');

plot(0, 0, 'ro', 'MarkerSize',10);
quiver(-5, 0, 10, 0, 0, 'Color', 'k', 'LineWidth', 2)
quiver(0, -1, 0, 8, 0, 'Color', 'k', 'LineWidth', 2)
xlabel('x'); ylabel('y'); title('Поворот прямоугольного треугольника на 72гр против часовой'); 
legend('AB', 'BC', 'CA','A1B1','B1C1','C1A1','Т. отсчета. О(0, 0)');


