%ƒана точка ћ . Ќова€ система координат повернута относительно старой на угол   
%против часовой стрелки. Ќайти координаты этой точки в новой системе координат и базис этой системы. 
%—делать проверку в матричном виде.
clear; clc; cla; close all;
M = [sqrt(2) sqrt(2)];  alfa = 225; 

M1 = [M(1)*cosd(alfa) - M(2)*sind(alfa), M(1)*sind(alfa) + M(2)*cosd(alfa)];
hold on; grid on; 
plot(0, 0, 'ro', M(1), M(2), 'r*', M1(1), M1(2), 'g*', 'Markersize', 10);

Mp = [cosd(alfa) -sind(alfa); sind(alfa) cosd(alfa)];%матрица поворота
[M1(1); M1(2)] == Mp*[M(1); M(2)] %проверка матрицей поворота

quiver(-5, 0, 10, 0, 0, 'Color', 'k')
quiver(0, -5, 0, 10, 0, 'Color', 'k')
quiver(0, 0, 4*cosd(alfa) - 0*sind(alfa), 4*sind(alfa) + 0*cosd(alfa), 0, 'Color', 'g');
quiver(0, 0, 0*cosd(alfa) - 4*sind(alfa), 0*sind(alfa) + 4*cosd(alfa), 0, 'Color', 'g');
xlabel('x'); ylabel('y'); title('ѕоворот системы координат'); 
legend('“ отсчета (0, 0)', '“очка в сторой сист (sqrt(2), sqrt(2))', '“очка в новой системе(0, -2)', 'x', 'y', 'x"', 'y"');
