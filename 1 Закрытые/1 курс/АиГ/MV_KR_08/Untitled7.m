[X, Y, Z] = meshgrid(-10:0.5:10, -10:0.5:10, -10:0.5:10);
a = 1; b = 1; c = 1;
V = X.^2/a^2 + Y.^2/b^2 - Z.^2/c^2;
p = patch(isosurface(X, Y, Z, V, 1));
set(p, 'FaceColor', 'red', 'EdgeColor', 'b')
axis equal
grid on
camlight