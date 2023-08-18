%Прямая проходит через точки А(2, 3) и В(-4, -1), пересекает ось Оу в точке С. Найти
%координаты точки С
clear; clc;
syms y;
A= [2 3];
B =[-4 -1];
C = [0 y];
AB = B-A;
AC = C-A;
Y = solve(AC(1)/AB(1)*AB(2)==AC(2));
C = [0 Y];
AC = C-A;
x = -5:5;
f = (2*x + 5)/3;

plot(x, f);
hold on;
grid on;
plot(0, 5/3, '.', 'MarkerSize',15, 'MarkerEdgeColor','Black');
plot(A(1), A(2), '.', B(1), B(2), '.');
plot(0, -2:0.1:5, 'Marker','.','MarkerFaceColor','k');
xlabel('x'); ylabel('y');
text( 0, 2, 'C(0, 5/3)' ); 



