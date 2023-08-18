x = 4; y = -1; a = 2; b = 3;
syms x1 y1
x1 = x - a; y1 = y - b;
disp('Ответ'), A = [x1 y1]
hold on, grid on, axis square
quiver(-2, 0, 7, 0, 0, 'Color', 'k', 'LineWidth', 2)
quiver(0, -2, 0, 7, 0, 'Color', 'k', 'LineWidth', 2)
quiver(2, 3, 1, 0, 0, 'Color', 'b', 'LineWidth', 2)
quiver(2, 3, 0, 1, 0, 'Color', 'b', 'LineWidth', 2)
plot(4, -1, 'r*')
text(0.2, -0.2, 'O'), text(2.2, 2.6, 'O_{1}'), text(4.2, -1, 'A')
x1 = 2; y1 = -4; alfa = pi/4;
x = x1 * cos(alfa) - y1 * sin(alfa);
y = y1 * cos(alfa) + x1 * sin(alfa);
disp('Ответ:'), A = [x y]
hold on, grid on, axis square
quiver(-1, 0, 6, 0, 0, 'Color', 'k', 'LineWidth', 2)
quiver(0, -2, 0, 7, 0, 'Color', 'k', 'LineWidth', 2)
x3 = cos(-alfa); y3 = -sin(-alfa);
x4 = sin(-alfa); y4 = cos(-alfa);
quiver(0, 0, x3, y3, 0, 'Color', 'b')
quiver(0, 0, x4, y4, 0, 'Color', 'b')
plot(A(1), A(2), 'r*')