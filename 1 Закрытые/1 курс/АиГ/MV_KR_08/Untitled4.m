hold on, grid on, axis equal, view(15,50)
quiver3(0, -10, 0, 0, 10, 0, 2, 'LineWidth', 2, 'Color', 'r')
t = -5:0.1:5;
h = [t; 2*t];
L = plot(h(1, :), h(2, :), 'LineWidth', 2);
xlabel('x'), ylabel('y'), zlabel('z')
for i=1:6:360
    L = plot(h(1, :), h(2, :), 'm')
    rotate(L, [0 1 0], i)
    pause(0.1)
end