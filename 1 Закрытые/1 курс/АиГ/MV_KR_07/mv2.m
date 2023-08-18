syms x y x1 y1
A = 2; B = -2; C = 5;
a = 2*B / (A - C);
b = 1/2 * atan(a);
alfa = 1/2 * atand(a)
c1 = cos(b); c2 = sin(b);
x = x1 * c1 - y1 * c2;
y = x1 * c2 + y1 * c1;
yp = 2*x^2 - 4*x*y + 5*y^2 + 8*x - 2*y + 9;
simplify(yp);
x0 = -7/5^(1/2); y0 = 1/5^(1/2);
X0 = [x0 y0]; C = [c1 -c2 ; c2 c1];
X = C * X0';
E = [1 0; 0 1];
E1 = C * E';
subplot(1, 2, 1)
hold on, grid on, axis([-5 -1 -3 1])
ezplot('2*x^2 - 4*x*y + 5*y^2 + 8*x - 2*y + 9')
plot(X(1), X(2), 'ok', 'MarkerFaceColor', 'r')
quiver(X(1), X(2), E1(1), E1(2)), quiver(X(1), X(2), E1(3), E1(4))
subplot(1, 2, 2)
hold on, grid on, axis([-5 -1 -2 2])
ezplot('((x1 + 7/5^(1/2))^2)/2 + ((y1 - 1/5^(1/2))^2)/(1/3)=1')
plot(x0, y0, 'ok', 'MarkerFaceColor', 'r')
quiver(x0, y0, E(1), E(2)), quiver(x0, y0, E(3), E(4))
