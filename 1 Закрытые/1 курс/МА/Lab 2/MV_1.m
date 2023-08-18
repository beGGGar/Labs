clear; clc; cla;
x = 0: pi/100: pi/2;
f = @(x)x.*cos(x);
S = quad(f, 0, pi/2)

plot(x, f(x), '--r');
grid on; hold on;
line([0, pi/2], [0 0]); line([0 0], [-1 1]); line([pi/2, pi/2], [-1 1]);
xlabel('x'); ylabel('y'); title('x*cosx'); legend('x*cosx', 'y = 0', 'x = 0', 'x = pi/2');

