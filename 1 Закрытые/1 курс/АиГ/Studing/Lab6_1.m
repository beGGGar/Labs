x1 = 1; y1=-4; alfa = pi/4;
x = x1*cos(alfa) - y1*sin(alfa);
y=y1*cos(alfa)+y1*sin(alfa);
A  =[x, y]
hold on; grid on; axis square;

quiver(-1, 0, 6, 0, 0, 'Color', 'k', 'LineWidth', 2)
quiver(0, -2, 0, 7, 0, 'Color', 'k', 'LineWidth', 2)
x3 = cos(-alfa); y3 = -sin(-alfa);
x4 = sin(-alfa); y4 = cos(-alfa);
quiver(0, 0, x3, y3, 0, 'Color', 'b')
quiver(0, 0, x4, y4, 0, 'Color', 'b')
plot(A(1), A(2), 'r*')